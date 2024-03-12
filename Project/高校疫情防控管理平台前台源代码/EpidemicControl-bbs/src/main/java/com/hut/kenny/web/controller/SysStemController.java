package com.hut.kenny.web.controller;

import com.hut.kenny.service.SystemService;
import com.hut.kenny.util.ReturnValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

/**
 * TODO 系统管理控制器
 * @Title: SysStemController
 * @Description:
 * @Author: 李铖
 * @Version: 1.0
 * @Date:  2022/4/21 22:32
 */
@Controller
public class SysStemController {
    @Autowired
    private SystemService systemService;

    @PostMapping("/system")
    @ResponseBody
    public Object getSystemVO(HttpServletResponse response) {
//        response.setHeader("Access-Control-Allow-Origin", "*");
        return new ReturnValue().success(systemService.getSystemVO());
    }
}
