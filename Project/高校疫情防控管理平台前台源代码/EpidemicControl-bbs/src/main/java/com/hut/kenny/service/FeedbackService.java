package com.hut.kenny.service;

import com.github.pagehelper.Page;
import com.hut.kenny.domain.entity.FdCategory;
import com.hut.kenny.domain.entity.Feedback;
import com.hut.kenny.domain.vo.FeedbackTableVO;
import com.hut.kenny.domain.vo.SystemFeedbackVO;
import com.hut.kenny.domain.vo.SystemUserVO;

import java.util.List;

/**
 * TODO 反馈界面业务逻辑
 * @Title: FeedBackService
 * @Description:
 * @Author: 李铖
 * @Version: 1.0
 * @Date:  2022/4/16 11:24
 */
public interface FeedbackService {

    /**
     * 获取所有反馈类别
     * @return
     */
    List<FdCategory> getAllCategory();

    /**
     * 保存反馈信息
     * @param feedback
     * @return
     */
    boolean keepFeedback(Feedback feedback);

    /**
     * 根据页数获取反馈信息
     * @param page
     * @return
     */
    List<FeedbackTableVO> getFeedbackTableVOByPage(int page, int userId);

    /**
     * 通过主键id获取反馈视图对象
     * @param fdId
     * @return
     */
    FeedbackTableVO getFeedbackTableVOByFdId(int fdId);

    /**
     * 通过主键id撤销反馈
     * 0. 撤销成功
     * @param fdId
     * @return
     */
    int isCanRevoke(int fdId);

    /**
     * 根据id获取表格数量
     * @param userId
     * @return
     */
    int getTableCount(int userId);


    Page<Feedback> getByConditionAndPage(SystemFeedbackVO vo);
}






















