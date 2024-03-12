package com.hut.kenny.service;

import com.hut.kenny.domain.entity.Active;
import com.hut.kenny.domain.vo.ActivityVO;
import com.hut.kenny.domain.vo.SystemActivityVO;

import java.util.List;

/**
 * TODO 活动界面业务逻辑层
 * @Title: ActiveService
 * @Description:
 * @Author: 李铖
 * @Version: 1.0
 * @Date:  2022/4/17 17:45
 */
public interface ActivityService {

    /**
     * 获得活动展示页面的轮播活动
     * @return
     */
    List<Active> getActiveCover();

    /**
     * 通过页数获取活动界面显示对象
     * @param page
     * @return
     */
    List<ActivityVO> getActivityVOByPage(int page);

    List<SystemActivityVO> getSystemActivityVOByPageAndCondition(SystemActivityVO systemActivityVO);

    SystemActivityVO getSystemActivityVOByActiveId(int activeId);

    /**
     * 通过id获得报名信息
     * @param activeId
     * @return
     */
    ActivityVO getActivityVOByActiveId(int activeId);

    /**
     * 获取用户报名列表
     * @param userId
     * @return
     */
    List<ActivityVO> getActivityVOByUserId(int userId);

    /**
     * 获取页数
     * @return
     */
    int getPageCount();

    /**
     * 报名
     * @param userId
     * @param activeId
     * @return
     */
    String signUp(int userId, int activeId);

    /**
     * 根据用户id和活动id查询用户是否报名
     * @param userId
     * @param activeId
     * @return
     */
    boolean querySignByUserIdAndActiveId(int userId, int activeId);

    /**
     * 增加游览量
     * @param activeId
     * @return
     */
    boolean addView(int activeId);
}
