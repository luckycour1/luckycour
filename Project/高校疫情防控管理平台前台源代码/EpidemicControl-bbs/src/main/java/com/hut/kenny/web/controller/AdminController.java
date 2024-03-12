package com.hut.kenny.web.controller;

import com.hut.kenny.domain.entity.Admin;
import com.hut.kenny.service.AdminService;
import com.hut.kenny.util.EmptyUtil;
import com.hut.kenny.util.ReturnValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO
 * @Title: AdminController
 * @Description:
 * @Author: 李铖
 * @Version: 1.0
 * @Date:  2022/4/20 21:19
 */
@Controller
public class AdminController {
    @Autowired
    private AdminService adminService;

    @PostMapping("/adminLogin")
    @ResponseBody
    public Object adminLogin(@RequestBody HashMap<String,Object> map) {
        ReturnValue returnValue = new ReturnValue();
        Admin admin = adminService.adminLogin(map.get("loginName").toString(), map.get("loginPwd").toString());
//        System.out.println(loginName + "" + loginPwd);
        if(EmptyUtil.isEmpty(admin)) return returnValue.returnFail("登录账号或密码错误");
        return returnValue.success(admin);
    }
}
