package com.hut.kenny.web.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hut.kenny.domain.entity.Active;
import com.hut.kenny.domain.entity.User;
import com.hut.kenny.domain.query.SystemActiveQuery;
import com.hut.kenny.domain.vo.ActivityVO;
import com.hut.kenny.domain.vo.SystemActivityUser;
import com.hut.kenny.domain.vo.SystemActivityVO;
import com.hut.kenny.mapper.ActiveCategoryMapper;
import com.hut.kenny.mapper.ActiveMapper;
import com.hut.kenny.mapper.ActiveUserMapper;
import com.hut.kenny.mapper.UserMapper;
import com.hut.kenny.service.ActivityService;
import com.hut.kenny.service.UserService;
import com.hut.kenny.util.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
//设置在Session中保存的属性名
@SessionAttributes(names = {"pic"})
public class SystemActivityController {
    @Autowired
    private ActivityService activityService;
    @Autowired
    private ActiveCategoryMapper activeCategoryMapper;
    @Autowired
    private ActiveUserMapper activeUserMapper;
    @Autowired
    private ActiveMapper activeMapper;
    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @PostMapping("/system/active")
    @ResponseBody
    public Object active(@RequestBody SystemActivityVO vo) {
        if(EmptyUtil.isEmpty(vo.getPage())) {
//            return new ReturnValue().returnFail("");
            return null;
        }
        List<SystemActivityVO> systemActivityVOList = activityService.getSystemActivityVOByPageAndCondition(vo);
        if(EmptyUtil.isEmpty(systemActivityVOList)) {
            return new ReturnValue().returnFail("未查询到数据！");
        }
        return new ReturnValue().success(systemActivityVOList);
    }

    @PostMapping("/system/active/getCategory")
    @ResponseBody
    public Object getCategory() {
        return new ReturnValue().success(activeCategoryMapper.selectAllCategory());
    }

    @PostMapping("/system/active/getVO")
    @ResponseBody
    public Object getVO(@RequestBody SystemActivityVO vo) {
        if(EmptyUtil.isEmpty(vo.getActiveId())) return null;
        SystemActivityVO vo1 = activityService.getSystemActivityVOByActiveId(vo.getActiveId());
        if(EmptyUtil.isEmpty(vo1)) return null;
        return new ReturnValue().success(vo1);
    }

    @PostMapping("/system/active/add")
    @ResponseBody
    public Object add(@Validated SystemActiveQuery query, BindingResult result) throws ParseException, IOException {
        ReturnValue returnValue = new ReturnValue();
        if(result.hasErrors()) return returnValue.returnFail(result.getAllErrors().get(0).getDefaultMessage());
        SystemActivityVO vo = new SystemActivityVO();
        BeanUtils.copyProperties(query, vo);
        vo.setStartSign(DateUtil.StringToDate2(query.getDate1()));
        vo.setEndSign(DateUtil.StringToDate2(query.getDate2()));
        vo.setActiveStartDate(DateUtil.StringToDate2(query.getDate3()));
        vo.setActiveEndDate(DateUtil.StringToDate2(query.getDate4()));
//        System.out.println(vo);
        if(activeMapper.insertActivity(vo) > 0) {
            return returnValue.success("添加活动成功！");
        }
        return new ReturnValue().returnFail("添加活动失败！");
    }

    @PostMapping("/system/active/pic")
    @ResponseBody
    public Object pic(@RequestBody MultipartFile file, HttpServletRequest request) throws IOException {
        if (EmptyUtil.isEmpty(file)) return null;
        String rootPath = request.getSession().getServletContext().getRealPath("image");
        String path = ImageUtil.upload(rootPath, "activity", file);
        //直接将图片路径保存到session
        HttpSession session = request.getSession();
        session.getServletContext().setAttribute("pic", path);
//        s.put();
        return new ReturnValue().success(path);
    }

    @PostMapping("/system/active/getPicPath")
    @ResponseBody
    public Object getPicPath(HttpSession session){
        String path = (String) session.getServletContext().getAttribute("pic");
        return new ReturnValue().success(path);
    }

    @PostMapping("/system/active/update")
    @ResponseBody
    public Object update(SystemActivityVO vo) throws ParseException {
        if(EmptyUtil.isEmpty(vo.getActiveId())) return null;
        if(EmptyUtil.nonEmpty(vo.getDate1()) && vo.getDate1().equals("null")) {
            vo.setStartSign(DateUtil.StringToDate2(vo.getDate1()));
        }
        if(EmptyUtil.nonEmpty(vo.getDate2()) && vo.getDate2().equals("null")) {
            vo.setEndSign(DateUtil.StringToDate2(vo.getDate2()));
        }
        if(EmptyUtil.nonEmpty(vo.getDate3()) && vo.getDate3().equals("null")) {
            vo.setActiveStartDate(DateUtil.StringToDate2(vo.getDate3()));
        }
        System.out.println(vo.getDate4());
        if(EmptyUtil.nonEmpty(vo.getDate4()) && !vo.getDate4().equals("null")) {
            vo.setActiveEndDate(DateUtil.StringToDate2(vo.getDate4()));
        }
        if(activeMapper.updateActivity(vo) > 0) {
            return new ReturnValue().success("更新成功！");
        }
        return new ReturnValue().returnFail("更新失败");
    }

    @PostMapping("/system/active/delete")
    @ResponseBody
    public Object delete(@RequestBody SystemActivityVO vo) {
        if(EmptyUtil.isEmpty(vo.getActiveId())) return null;
        if(activeUserMapper.deleteByActiveId(vo.getActiveId()) >= 0) {
            int id = activeMapper.deleteByActiveId(vo.getActiveId());
            System.out.println(id);
            System.out.println(vo.getActiveId());
        }

        return new ReturnValue().success("删除成功！");
    }

    @PostMapping("/system/active/user")
    @ResponseBody
    public Object user(@RequestBody SystemActivityUser vo) {
        if(EmptyUtil.isEmpty(vo.getActiveId()) || EmptyUtil.isEmpty(vo.getPage())) return null;
        Page<User> userPage = PageHelper.startPage(vo.getPage(), SysConstants.SYSTEM_COUNT);
        userMapper.selectUserByActiveIdAndCondition(vo);
        if(EmptyUtil.isEmpty(userPage.getResult())) return new ReturnValue().returnFail("没有查询到数据！");
        List<SystemActivityUser> userList = new ArrayList<>();
        for (User user : userPage) {
            SystemActivityUser activityUser = new SystemActivityUser();
            activityUser.setTotal((int) userPage.getTotal());
            activityUser.setUserId(user.getUserId());
            activityUser.setUserName(user.getUserName());
            activityUser.setUserNum(user.getUserNum());
            activityUser.setUserPhone(user.getUserPhone());
            activityUser.setPageCount(SysConstants.SYSTEM_COUNT);
            activityUser.setUserClass(userService.getClassNameByClassId(user.getClassId()));
            userList.add(activityUser);
        }
        return new ReturnValue().success(userList);
    }

}














