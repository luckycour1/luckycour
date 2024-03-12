package com.hut.kenny.web.controller;


import com.hut.kenny.domain.entity.User;
import com.hut.kenny.domain.query.MeQuery;
import com.hut.kenny.service.MeService;
import com.hut.kenny.util.EmptyUtil;
import com.hut.kenny.util.ImageUtil;
import com.hut.kenny.util.ReturnValue;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;

/**
 * TODO 个人中心控制器
 * @Title: MeController
 * @Description:
 * @Author: 李铖
 * @Version: 1.0
 * @Date:  2022/4/17 11:08
 */
@Controller
public class MeController {

    @Autowired
    private MeService meService;

    @GetMapping({"/me.html", "/me"})
    public String me(@SessionAttribute(value = "LOGIN_TICKET", required = false) User user){
        if(EmptyUtil.isEmpty(user)) return "redirect:/login";
        return "me";
    }

    @PostMapping({"/me/update"})
    @ResponseBody
    public Object update(@RequestParam(value = "image", required = false) MultipartFile file,
                         @SessionAttribute(value = "LOGIN_TICKET", required = true)User user, HttpServletRequest request,
                         @Validated MeQuery meQuery, BindingResult result, Map map) throws IOException {
        ReturnValue returnValue = new ReturnValue();
        if(result.hasErrors()) return returnValue.returnFail(result.getAllErrors().get(0).getDefaultMessage());
        BeanUtils.copyProperties(meQuery, user);

        if(file != null) {
            String rootPath = request.getSession().getServletContext().getRealPath("image");
            user.setHeaderIcon(ImageUtil.upload(rootPath, "me/header", file));
        }
        map.put("LOGIN_TICKET", user);
        if(meService.keepUser(user)) {
            return returnValue.success("保存成功！");
        }
        return returnValue.returnFail("保存失败！");
    }

    @PostMapping({"/me/user"})
    @ResponseBody
    public Object getUserData(@SessionAttribute(value = "LOGIN_TICKET", required = true) User user){
        return new ReturnValue().success(meService.getMeVO(user));
    }
}
