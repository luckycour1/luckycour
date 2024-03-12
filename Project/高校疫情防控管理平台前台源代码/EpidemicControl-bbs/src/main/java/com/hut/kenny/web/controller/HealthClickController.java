package com.hut.kenny.web.controller;

import com.hut.kenny.domain.entity.ClickCard;
import com.hut.kenny.domain.entity.User;
import com.hut.kenny.domain.query.HealthClickQuery;
import com.hut.kenny.service.HealthClickService;
import com.hut.kenny.util.EmptyUtil;
import com.hut.kenny.util.ReturnValue;
import com.sun.deploy.net.HttpResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * TODO 健康打卡控制器
 * @Title: HealthClickController
 * @Description:
 * @Author: 李铖
 * @Version: 1.0
 * @Date:  2022/4/14 9:11
 */
@Controller
//设置在Session中保存的属性名
@SessionAttributes(names = {"LOGIN_TICKET"})
public class HealthClickController {
    @Autowired
    private HealthClickService healthClickService;


    @GetMapping({"/healthClick.html", "/healthClick"})
    public String healthClick(Map map){
        map.put("symptom",  healthClickService.getAllSymptom());
        return "healthClick";
    }

    @PostMapping("/healthClick/healthClick")
    @ResponseBody
    public Object healthClick(@SessionAttribute(value = "LOGIN_TICKET", required = false)User user,
                              @Validated HealthClickQuery healthClickQuery, BindingResult bindingResult) {
        ReturnValue returnValue = new ReturnValue();
        //如果没有登录，直接返回登录页面进行登录
        if(EmptyUtil.isEmpty(user)) return returnValue.returnFail("/login");
        //查看用户是否已经打过卡
        if(healthClickService.verIsClick(user.getUserId())) {
            return returnValue.returnFail("您今天已经打过卡了");
        }
        if(bindingResult.hasErrors()) {
            return returnValue.returnFail(bindingResult.getAllErrors().get(0).getDefaultMessage());
        }
        ClickCard clickCard = new ClickCard();
        BeanUtils.copyProperties(healthClickQuery, clickCard);
        clickCard.setUserId(user.getUserId());
        healthClickService.healthClick(clickCard);
        return returnValue.success("打卡成功！");
    }
}
