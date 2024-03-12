package com.hut.kenny.web.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hut.kenny.domain.entity.UserHm;
import com.hut.kenny.domain.vo.SystemHealthMentalVO;
import com.hut.kenny.domain.vo.SystemQuestions;
import com.hut.kenny.mapper.UserHmMapper;
import com.hut.kenny.mapper.UserMapper;
import com.hut.kenny.service.HealthMentalService;
import com.hut.kenny.util.DateUtil;
import com.hut.kenny.util.EmptyUtil;
import com.hut.kenny.util.ReturnValue;
import com.hut.kenny.util.SysConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * TODO 健康问卷控制器
 * @Title: SystemHealthMental
 * @Description:
 * @Author: 李铖
 * @Version: 1.0
 * @Date:  2022/4/23 20:27
 */
@Controller
public class SystemHealthMentalController {
    @Autowired
    private UserHmMapper userHmMapper;
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private HealthMentalService healthMentalService;

    @PostMapping("/system/HealthMental/test")
    @ResponseBody
    public Object test(@RequestBody SystemQuestions vo) {
        if(EmptyUtil.isEmpty(vo.getUserId()) || EmptyUtil.isEmpty(vo.getUhmCount())) {
            return null;
        }
        SystemQuestions systemQuestions = healthMentalService.getQuestions(vo.getUserId(), vo.getUhmCount());
        if(EmptyUtil.isEmpty(systemQuestions)) return new ReturnValue().returnFail("未查询到数据！");
//        System.out.println(systemQuestions);
        return new ReturnValue().success(systemQuestions);
    }

    @PostMapping("/system/HealthMental")
    @ResponseBody
    public Object HealthMental(@RequestBody SystemHealthMentalVO vo) throws ParseException {
        UserHm u = new UserHm();
        if(EmptyUtil.nonEmpty(vo.getDate())) {
            u.setUhmDate(DateUtil.StringToDate(vo.getDate()));
        }

        Page<UserHm> userHms = PageHelper.startPage(vo.getPage(), SysConstants.SYSTEM_COUNT);
        userHmMapper.selectAllMental(u);
        if(EmptyUtil.isEmpty(userHms.getResult())) {
            return new ReturnValue().returnFail("未查询到数据！");
        }
        List<SystemHealthMentalVO> voList = new ArrayList<>();
        for (UserHm userHm : userHms) {
            SystemHealthMentalVO vo1 = new SystemHealthMentalVO();
            vo1.setUserId(userHm.getUserId());
            vo1.setUserName(userMapper.selectByUserId(userHm.getUserId()).getUserName());
            vo1.setUhmDate(userHm.getUhmDate());
            vo1.setUhmCount(userHm.getUhmCount());
            vo1.setTotal((int) userHms.getTotal());
            vo1.setPageCount(SysConstants.SYSTEM_COUNT);
            voList.add(vo1);
        }
        return new ReturnValue().success(voList);
    }
}
