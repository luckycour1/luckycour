package com.hut.kenny.mapper;

import com.hut.kenny.domain.entity.FdCategory;
import com.hut.kenny.domain.entity.Feedback;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface FeedbackMapper extends Mapper<Feedback> {

    /**
     * 插入
     * @param feedback
     * @return
     */
    int insertFeedback(Feedback feedback);

    /**
     * 根据用户id拿到反馈信息
     * id为0就默认所有反馈信息
     * @return
     */
    List<Feedback> selectAllByUserId(int userId);

    /**
     * 通过反馈id获取反馈信息
     * @param fdId
     * @return
     */
    Feedback selectByFdId(@Param("fdId") int fdId);

    /**
     * 撤销反馈信息
     * @return
     */
    int revokeById(int fdId);

    int selectTodayCount();

    int selectTodayCountByCategory(int category);


    List<Feedback> selectByCondition(Feedback feedback);

    int updateStatusByIdAndStatusId(@Param("fdId") int fdId, @Param("statusId") int statusId);

}