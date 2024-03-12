package com.hut.kenny.web.controller;

import com.github.pagehelper.Page;
import com.hut.kenny.domain.entity.Feedback;
import com.hut.kenny.domain.vo.SystemFeedbackVO;
import com.hut.kenny.mapper.FdCategoryMapper;
import com.hut.kenny.mapper.FeedbackMapper;
import com.hut.kenny.mapper.UserMapper;
import com.hut.kenny.service.FeedbackService;
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

@Controller
public class SystemFeedbackController {
    @Autowired
    private FdCategoryMapper fdCategoryMapper;
    @Autowired
    private FeedbackMapper feedbackMapper;
    @Autowired
    private FeedbackService feedbackService;
    @Autowired
    private UserMapper userMapper;

    @PostMapping("/system/feedback/categoryData")
    @ResponseBody
    public Object categoryData() {
        return new ReturnValue().success(feedbackService.getAllCategory());
    }

    @PostMapping("/system/feedback/feedbackData")
    @ResponseBody
    public Object feedbackData(@RequestBody SystemFeedbackVO vo) throws ParseException{
        if(vo.getFdId() == null) return null;
        Feedback feedback = feedbackMapper.selectByFdId(vo.getFdId());
        SystemFeedbackVO systemFeedbackVO = new SystemFeedbackVO();
        systemFeedbackVO.setFdTitle(feedback.getFdTitle());
        systemFeedbackVO.setUserName(userMapper.selectByUserId(feedback.getUserId()).getUserName());
        systemFeedbackVO.setFdCategory(fdCategoryMapper.selectByCategoryId(feedback.getFdCategoryId()).getCategoryName());
        systemFeedbackVO.setUserPhone(feedback.getUserPhone());
        systemFeedbackVO.setFdDate(feedback.getFdDate());
        systemFeedbackVO.setFdStatus(SysConstants.FDSTATUS[feedback.getFdStatus()]);
        systemFeedbackVO.setFdContent(feedback.getFdContent());
        systemFeedbackVO.setFdPicUrl(feedback.getFdPicUrl());
        return new ReturnValue().success(systemFeedbackVO);
    }

    @PostMapping("/system/feedback/update")
    @ResponseBody
    public Object update(@RequestBody SystemFeedbackVO vo) {
        if(vo.getFdId() == null || vo.getFdStatusId() == null) {
            return null;
        }
        if(feedbackMapper.updateStatusByIdAndStatusId(vo.getFdId(), vo.getFdStatusId()) > 0) {
            return new ReturnValue().success("更新成功！");
        }
        return new ReturnValue().returnFail("更新失败！");
    }

    @PostMapping("/system/feedback")
    @ResponseBody
    public Object feedback(@RequestBody SystemFeedbackVO vo) throws ParseException {
        if(EmptyUtil.nonEmpty(vo.getDate())) {
            vo.setFdDate(DateUtil.StringToDate(vo.getDate()));
        }
        Page<Feedback> feedbacks = feedbackService.getByConditionAndPage(vo);
        if (EmptyUtil.isEmpty(feedbacks)) return new ReturnValue().returnFail("未查询到数据！");

        List<SystemFeedbackVO> voList = new ArrayList<>();
        for (Feedback feedback : feedbacks) {
            SystemFeedbackVO systemFeedbackVO = new SystemFeedbackVO();
            systemFeedbackVO.setFdId(feedback.getFdId());
            systemFeedbackVO.setFdTitle(feedback.getFdTitle());
            systemFeedbackVO.setUserName(userMapper.selectByUserId(feedback.getUserId()).getUserName());
            systemFeedbackVO.setUserId(feedback.getUserId());
            systemFeedbackVO.setFdCategory(fdCategoryMapper.selectByCategoryId(feedback.getFdCategoryId()).getCategoryName());
            systemFeedbackVO.setUserPhone(feedback.getUserPhone());
            systemFeedbackVO.setFdDate(feedback.getFdDate());
            systemFeedbackVO.setFdStatus(SysConstants.FDSTATUS[feedback.getFdStatus()]);
            systemFeedbackVO.setTotal((int) feedbacks.getTotal());
            systemFeedbackVO.setPageCount(SysConstants.SYSTEM_COUNT);
            voList.add(systemFeedbackVO);
        }
        return new ReturnValue().success(voList);
    }
}





