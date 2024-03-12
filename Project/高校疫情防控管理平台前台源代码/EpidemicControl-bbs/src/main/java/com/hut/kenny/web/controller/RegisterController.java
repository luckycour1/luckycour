package com.hut.kenny.web.controller;

import com.hut.kenny.domain.entity.Class;
import com.hut.kenny.domain.entity.User;
import com.hut.kenny.domain.query.RegisterQuery;
import com.hut.kenny.service.RegisterService;
import com.hut.kenny.util.EmptyUtil;
import com.hut.kenny.util.ReturnValue;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * TODO 注册接口
 * @Title: RegisterController
 * @Description:
 * @Author: 李铖
 * @Version: 1.0
 * @Date:  2022/4/13 16:53
 */
@Controller
public class RegisterController {
    @Autowired
    private RegisterService registerService;

    @PostMapping("/register/class")
    @ResponseBody
    public Object getByParentId(Integer pid) {
        List<Class> classList = registerService.getClassByParentId(pid);
        ReturnValue returnValue = new ReturnValue();
        return EmptyUtil.isEmpty(classList) ? returnValue.returnFail("没有查询到子节点") : returnValue.success(classList);
    }

    @PostMapping("/register/register")
    @ResponseBody
    public Object register(@Validated @RequestBody RegisterQuery registerQuery, BindingResult bindingResult) {
        ReturnValue returnValue = new ReturnValue();
        if(bindingResult.hasErrors()) {
            List<ObjectError> objectErrorList = bindingResult.getAllErrors();
            String errorMessage = "";
            for (ObjectError error : objectErrorList){
                errorMessage += error.getDefaultMessage() + " | ";
            }
            return returnValue.returnFail(errorMessage);
        }//D:\IdeaProjects\EpidemicControl-bbs\src\main\webapp\image\activity\index
        User user = new User();
        BeanUtils.copyProperties(registerQuery, user);
        System.out.println(user);
        if(registerService.register(user)) {
            return returnValue.success("注册成功");
        }
        return returnValue.returnFail("注册失败");
    }


//    @PostMapping("/test")
//    @ResponseBody
//    public Object test(HttpServletRequest httpServletRequest) {
//        String image = httpServletRequest.getSession().getServletContext().getRealPath("image");
////        String image2 = image.;
//        System.out.println(image);
////        System.out.println(image2);
//        return new ReturnValue("成功");
//    }
}
