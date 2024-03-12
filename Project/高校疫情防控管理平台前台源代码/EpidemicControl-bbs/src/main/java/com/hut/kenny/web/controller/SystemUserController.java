package com.hut.kenny.web.controller;

import com.github.pagehelper.Page;
import com.hut.kenny.domain.entity.User;
import com.hut.kenny.domain.vo.SystemUserVO;
import com.hut.kenny.service.UserService;
import com.hut.kenny.util.ReturnValue;
import com.hut.kenny.util.SysConstants;
import org.omg.CORBA.PRIVATE_MEMBER;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * TODO 用户管理控制器
 * @Title: SystemUserController
 * @Description:
 * @Author: 李铖
 * @Version: 1.0
 * @Date:  2022/4/22 12:02
 */
@Controller
public class SystemUserController {
    @Autowired
    private UserService userService;

    @PostMapping("/system/userData")
    @ResponseBody
    public Object userData(@RequestBody SystemUserVO vo) {
        Page<User> userPage = userService.getUserByPage(vo.getPage());
        List<SystemUserVO> userVOS = new ArrayList<>();
        for (User user : userPage) {
            SystemUserVO systemUserVO = new SystemUserVO();
            systemUserVO.setTotal((int) userPage.getTotal());
            systemUserVO.setUserId(user.getUserId());
            systemUserVO.setUserName(user.getUserName());
            systemUserVO.setUserNum(user.getUserNum());
            systemUserVO.setUserPhone(user.getUserPhone());
            systemUserVO.setPageCount(SysConstants.SYSTEM_COUNT);
            systemUserVO.setUserClass(userService.getClassNameByClassId(user.getClassId()));
            userVOS.add(systemUserVO);
        }
//        System.out.println(userVOS);
        return new ReturnValue().success(userVOS);
    }

    @PostMapping("/system/userDataAndCon")
    @ResponseBody
    public Object userDataAndCon(@RequestBody SystemUserVO vo) {
        User user1 = new User();
        BeanUtils.copyProperties(vo, user1);
        Page<User> userPage = userService.getUserByPageAndCondition(vo.getPage(), user1);
//        System.out.println(userPage);
//        System.out.println(vo);
        List<SystemUserVO> userVOS = new ArrayList<>();
        for (User user : userPage) {
            SystemUserVO systemUserVO = new SystemUserVO();
            systemUserVO.setTotal((int) userPage.getTotal());
            systemUserVO.setUserId(user.getUserId());
            systemUserVO.setUserName(user.getUserName());
            systemUserVO.setUserNum(user.getUserNum());
            systemUserVO.setUserPhone(user.getUserPhone());
            systemUserVO.setPageCount(SysConstants.SYSTEM_COUNT);
            systemUserVO.setUserClass(userService.getClassNameByClassId(user.getClassId()));
            userVOS.add(systemUserVO);
        }
        return new ReturnValue().success(userVOS);
    }
}
