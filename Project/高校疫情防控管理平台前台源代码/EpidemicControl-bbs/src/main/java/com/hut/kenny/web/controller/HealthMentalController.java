package com.hut.kenny.web.controller;

import com.hut.kenny.domain.entity.User;
import com.hut.kenny.domain.entity.UserHm;
import com.hut.kenny.service.HealthMentalService;
import com.hut.kenny.util.EmptyUtil;
import com.hut.kenny.util.ReturnValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
public class HealthMentalController {
    @Autowired
    private HealthMentalService healthMentalService;

    @GetMapping({"/healthMental.html", "/healthMental"})
    public String healthMental(Map map){
        map.put("test", healthMentalService.getHealthMentalVO());
        return "healthMental";
    }


    @PostMapping({"/healthMental/keep"})
    @ResponseBody
    public Object keep(@RequestBody List<UserHm> userHms, @SessionAttribute(value = "LOGIN_TICKET", required = false) User user){
        ReturnValue returnValue = new ReturnValue();
        if(EmptyUtil.isEmpty(user)) return returnValue.returnFail("/login");

        for (UserHm userHm : userHms) {
            userHm.setUserId(user.getUserId());
            userHm.setUserId(10089);
        }
        System.out.println(userHms);
        if(healthMentalService.preUserMental(userHms)) return returnValue.success("保存成功");
        return returnValue.returnFail("保存失败");
    }
}













