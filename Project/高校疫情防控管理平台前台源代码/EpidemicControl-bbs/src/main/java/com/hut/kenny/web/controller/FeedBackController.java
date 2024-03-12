package com.hut.kenny.web.controller;

import com.hut.kenny.domain.entity.Feedback;
import com.hut.kenny.domain.entity.User;
import com.hut.kenny.domain.query.FeedBackQuery;
import com.hut.kenny.service.FeedbackService;
import com.hut.kenny.util.EmptyUtil;
import com.hut.kenny.util.ImageUtil;
import com.hut.kenny.util.ReturnValue;
import com.hut.kenny.util.SysConstants;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

/**
 * TODO 反馈控制器
 * @Title: FeedBackController
 * @Description:
 * @Author: 李铖
 * @Version: 1.0
 * @Date:  2022/4/16 11:22
 */
@Controller
public class FeedBackController {
    @Autowired
    private FeedbackService feedbackService;

    @GetMapping({"/feedback.html", "/feedback"})
    public String feedback(Map map, @SessionAttribute(value = "LOGIN_TICKET", required = false)User user){
        if(EmptyUtil.isEmpty(user)) return "redirect:/login";
        map.put("feedCategory", feedbackService.getAllCategory());
        return "feedback";
    }

    @PostMapping("/feedback/keep")
    @ResponseBody
    public Object keep(@Validated FeedBackQuery query, BindingResult bindingResult, @RequestParam(value = "image", required = false)MultipartFile file,
                       @SessionAttribute(value = "LOGIN_TICKET", required = true)User user, HttpServletRequest request) throws IOException {
        ReturnValue returnValue = new ReturnValue();
        if(bindingResult.hasErrors()) {
            return returnValue.returnFail(bindingResult.getAllErrors().get(0).getDefaultMessage());
        }
        Feedback feedback = new Feedback();
        BeanUtils.copyProperties(query, feedback);
        feedback.setUserId(user.getUserId());

        if(file != null) {
            String rootPath = request.getSession().getServletContext().getRealPath("image");
            feedback.setFdPicUrl(ImageUtil.upload(rootPath, "feedback", file));
        }
        System.out.println(feedback);
        feedbackService.keepFeedback(feedback);
        return returnValue.success("反馈成功！");
    }

    @PostMapping("/feedback/table")
    @ResponseBody
    public Object feedTable(int page, @SessionAttribute(value = "LOGIN_TICKET", required = true)User user) {
        return new ReturnValue().success(feedbackService.getFeedbackTableVOByPage(page, user.getUserId()));
    }

    @PostMapping("/feedback/table/count")
    @ResponseBody
    public Object feedTableCount(@SessionAttribute(value = "LOGIN_TICKET", required = true)User user) {
        return new ReturnValue().success(feedbackService.getTableCount(user.getUserId()));
    }

    @PostMapping("/feedback/table/data")
    @ResponseBody
    public Object feedTableData(int fdId) {
        return new ReturnValue().success(feedbackService.getFeedbackTableVOByFdId(fdId));
    }

    @PostMapping("/feedback/table/revoke")
    @ResponseBody
    public Object revoke(int fdId) {
        ReturnValue returnValue = new ReturnValue();
        int status = feedbackService.isCanRevoke(fdId);
        if(status == 0) {
            return returnValue.success("撤销成功!");
        } else {
            if(status == 3) {
                return returnValue.returnFail("反馈不可重复撤销！");
            }
            String message = SysConstants.FDSTATUS[status] + "状态下不能撤销!";
            return returnValue.returnFail(message);
        }
    }
}
