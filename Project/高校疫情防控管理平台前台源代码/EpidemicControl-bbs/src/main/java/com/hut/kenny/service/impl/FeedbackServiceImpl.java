package com.hut.kenny.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hut.kenny.domain.entity.FdCategory;
import com.hut.kenny.domain.entity.Feedback;
import com.hut.kenny.domain.vo.FeedbackTableVO;
import com.hut.kenny.domain.vo.SystemFeedbackVO;
import com.hut.kenny.mapper.FdCategoryMapper;
import com.hut.kenny.mapper.FeedbackMapper;
import com.hut.kenny.service.FeedbackService;
import com.hut.kenny.util.DateUtil;
import com.hut.kenny.util.EmptyUtil;
import com.hut.kenny.util.SysConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class FeedbackServiceImpl implements FeedbackService {
    @Autowired
    private FdCategoryMapper fdCategoryMapper;

    @Autowired
    private FeedbackMapper feedbackMapper;

    @Override
    public List<FdCategory> getAllCategory() {
        return fdCategoryMapper.selectAll();
    }

    @Override
    public boolean keepFeedback(Feedback feedback) {
        return feedbackMapper.insertFeedback(feedback) > 0;
    }

    @Override
    public List<FeedbackTableVO> getFeedbackTableVOByPage(int page, int userId) {
        Page<Feedback> list = PageHelper.startPage(page, SysConstants.FEEDBACK_COUNT);
//        Page<Feedback> list = PageHelper.startPage(page, 2);
        feedbackMapper.selectAllByUserId(userId);
        List<FeedbackTableVO> vos = new ArrayList<>();
        for (Feedback feedback : list) {
            FeedbackTableVO vo = new FeedbackTableVO();
            vo.setDate(DateUtil.GetLocalDateTimeFromDefaultPattern(feedback.getFdDate(), SysConstants.PATTERN_2));
            vo.setFdCategory(fdCategoryMapper.selectByCategoryId(feedback.getFdCategoryId()).getCategoryName());
            vo.setFdContent(feedback.getFdContent());
            vo.setFdId(feedback.getFdId());
            vo.setUserPhone(feedback.getUserPhone());
            vo.setFdStatus(SysConstants.FDSTATUS[feedback.getFdStatus()]);
            vo.setFdPicUrl(feedback.getFdPicUrl());
            vo.setFdTitle(feedback.getFdTitle());
            vos.add(vo);
        }
        return vos;
    }

    @Override
    public FeedbackTableVO getFeedbackTableVOByFdId(int fdId) {
        FeedbackTableVO vo = new FeedbackTableVO();
        Feedback feedback = feedbackMapper.selectByFdId(fdId);
        if(EmptyUtil.isEmpty(feedback)) return null;
        vo.setDate(DateUtil.GetLocalDateTimeFromDefaultPattern(feedback.getFdDate()));
        vo.setFdCategory(fdCategoryMapper.selectByCategoryId(feedback.getFdCategoryId()).getCategoryName());
        vo.setFdContent(feedback.getFdContent());
        vo.setFdId(feedback.getFdId());
        vo.setUserPhone(feedback.getUserPhone());
        vo.setFdStatus(SysConstants.FDSTATUS[feedback.getFdStatus()]);
        vo.setFdPicUrl(feedback.getFdPicUrl());
        vo.setFdTitle(feedback.getFdTitle());
        return vo;
    }

    @Override
    public int isCanRevoke(int fdId) {
        Feedback feedback = feedbackMapper.selectByFdId(fdId);
        if(feedback.getFdStatus() != 0) {
            return feedback.getFdStatus();
        }
        feedbackMapper.revokeById(fdId);
        return 0;
    }

    @Override
    public int getTableCount(int userId) {
        Page<Feedback> list = PageHelper.startPage(1, SysConstants.FEEDBACK_COUNT);
//        Page<Feedback> list = PageHelper.startPage(page, 2);
        feedbackMapper.selectAllByUserId(userId);
        return list.getPages();
    }

    @Override
    public Page<Feedback> getByConditionAndPage(SystemFeedbackVO vo) {
        Feedback feedback = new Feedback();
        feedback.setFdCategoryId(vo.getFdCategoryId());
        feedback.setFdDate(vo.getFdDate());
        feedback.setFdStatus(vo.getFdStatusId());
        Page<Feedback> feedbacks = PageHelper.startPage(vo.getPage(), SysConstants.SYSTEM_COUNT);
        feedbackMapper.selectByCondition(feedback);
        if(EmptyUtil.isEmpty(feedbacks.getResult())) return null;
        return feedbacks;
    }


}














