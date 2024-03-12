package com.hut.kenny.web.controller;

import com.hut.kenny.domain.entity.User;
import com.hut.kenny.domain.query.LoginQuery;
import com.hut.kenny.service.PostService;
import com.hut.kenny.service.UserService;
import com.hut.kenny.util.EmptyUtil;
import com.hut.kenny.util.ReturnValue;
import com.hut.kenny.util.SysConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * TODO 应用程序的入口Controller
 * @Title: ApplicationController
 * @Description:
 * @Author: 李铖
 * @Version: 1.0
 * @Date:  2022/4/9 12:43
 */
@Controller
//设置在Session中保存的属性名
@SessionAttributes(names = {"LOGIN_TICKET"})
public class ApplicationController {
    @Autowired
    private UserService userService;

    @Autowired
    private PostService postService;

    @GetMapping({"/index.html", "/index", "/"})
    public String index(Map map,  @SessionAttribute(value = "LOGIN_TICKET", required = false)User user){
        if(EmptyUtil.isEmpty(user)) return "redirect:/login";
        map.put("post2", postService.getIndexPostVOByCategoryAndLimit(2, SysConstants.INDEX_POST_COUNT));
        map.put("post1", postService.getIndexPostVOByCategoryAndLimit(1, SysConstants.INDEX_POST_COUNT));
        return "index";
    }

    @GetMapping({"/login.html", "/login"})
    public String login(){
        return "login";
    }

    @PostMapping({"/login.html", "/login"})
    @ResponseBody
    public Object login(@Validated LoginQuery query, BindingResult bindingResult, Map map){
        ReturnValue returnValue = new ReturnValue();
        if(bindingResult.hasErrors()) {
            List<ObjectError> objectErrorList = bindingResult.getAllErrors();
            String errorMessage = "";
            for (ObjectError error : objectErrorList){
                errorMessage += error.getDefaultMessage() + " | ";
            }
            return returnValue.returnFail(errorMessage);
        }
        User user = userService.login(query);
        if(EmptyUtil.isEmpty(user)) {
            return returnValue.returnFail("用户名或密码不匹配！");
        }
        //验证完成，把当前登录用户对象保存到Session中
        map.put("LOGIN_TICKET", user);
        return returnValue.success("登陆成功");
    }

    @GetMapping({"/register.html", "/register"})
    public String register(){
        return "register";
    }

    @GetMapping({"/footer.html", "/footer"})
    public String footer(){
        return "footer";
    }

    @GetMapping({"/header.html", "/header"})
    public String header(){
        return "header";
    }

}
