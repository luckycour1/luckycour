package com.hut.kenny.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hut.kenny.domain.entity.Active;
import com.hut.kenny.domain.entity.ActiveUser;
import com.hut.kenny.domain.vo.ActivityVO;
import com.hut.kenny.domain.vo.SystemActivityVO;
import com.hut.kenny.mapper.ActiveCategoryMapper;
import com.hut.kenny.mapper.ActiveMapper;
import com.hut.kenny.mapper.ActiveUserMapper;
import com.hut.kenny.service.ActivityService;
import com.hut.kenny.util.DateUtil;
import com.hut.kenny.util.EmptyUtil;
import com.hut.kenny.util.SysConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.unit.DataUnit;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ActivityServiceImpl implements ActivityService {
    @Autowired
    private ActiveMapper activeMapper;

    @Autowired
    private ActiveCategoryMapper activeCategoryMapper;

    @Autowired
    private ActiveUserMapper activeUserMapper;

    @Override
    public List<Active> getActiveCover() {
        return activeMapper.selectByRight(1);
    }

    @Override
    public List<ActivityVO> getActivityVOByPage(int page) {
        Page<Active> active = PageHelper.startPage(page, SysConstants.ACTIVITY_COUNT);
        activeMapper.selectByRight(0);
        List<ActivityVO> vos = new ArrayList<>();

        //组装vo对象
        for (Active a : active) {
            ActivityVO vo = new ActivityVO();
            vo.setActiveId(a.getActiveId());
            vo.setActiveView(a.getActiveView());
            vo.setActivePicUrl(a.getActivePicUrl());
            vo.setActiveCategory(activeCategoryMapper.selectById(a.getActiveCategoryId()).getActiveCategoryContent());
            vo.setActiveNowNum(a.getActiveNowNum());
            vo.setActiveMaxNum(a.getActiveMaxNum());
            vo.setActiveAddress(a.getActiveAddress());
            vo.setStartSign(a.getStartSign());
            vo.setActiveTitle(a.getActiveTitle());
            vo.setEndSign(a.getEndSign());
            //状态
            vo.setActiveStatus(judgeActivity(a));
            vo.setActiveCss(judgeCss(vo.getActiveStatus()));
            vos.add(vo);
        }

        return EmptyUtil.isEmpty(vos) ? null : vos;
    }

    @Override
    public List<SystemActivityVO> getSystemActivityVOByPageAndCondition(SystemActivityVO systemActivityVO) {
        Page<Active> activePage = PageHelper.startPage(systemActivityVO.getPage(), SysConstants.SYSTEM_COUNT);
        activeMapper.selectByCondition(systemActivityVO);
        if(EmptyUtil.isEmpty(activePage.getResult())) return null;
        List<SystemActivityVO> systemActivityVOList = new ArrayList<>();
        for (Active a : activePage) {
            SystemActivityVO vo = new SystemActivityVO();
            vo.setActiveId(a.getActiveId());
            vo.setActiveCategoryContent(activeCategoryMapper.selectById(a.getActiveCategoryId()).getActiveCategoryContent());
            vo.setActiveStatusName(judgeActivity(a));
            vo.setActiveNowNum(a.getActiveNowNum());
            vo.setActiveMaxNum(a.getActiveMaxNum());
            vo.setStartSign(a.getStartSign());
            vo.setPageCount(SysConstants.SYSTEM_COUNT);
            vo.setActiveTitle(a.getActiveTitle());
            vo.setTotal((int) activePage.getTotal());
            systemActivityVOList.add(vo);
        }
        return systemActivityVOList;
    }

    @Override
    public SystemActivityVO getSystemActivityVOByActiveId(int activeId) {
        Active a = activeMapper.selectByActiveId(activeId);
        if(EmptyUtil.isEmpty(a)) return null;
        SystemActivityVO vo = new SystemActivityVO();
        vo.setActiveId(a.getActiveId());
        vo.setActiveView(a.getActiveView());
        vo.setActivePicUrl(a.getActivePicUrl());
        vo.setActiveCategoryContent(activeCategoryMapper.selectById(a.getActiveCategoryId()).getActiveCategoryContent());
        vo.setActiveNowNum(a.getActiveNowNum());
        vo.setActiveMaxNum(a.getActiveMaxNum());
        vo.setActiveAddress(a.getActiveAddress());
        vo.setStartSign(a.getStartSign());
        vo.setActiveIsCover(a.getActiveIsCover());
        vo.setActiveCategoryId(a.getActiveCategoryId());
        vo.setActiveTitle(a.getActiveTitle());
        vo.setEndSign(a.getEndSign());
        //状态
        vo.setActiveStatusName(judgeActivity(a));
        vo.setActiveContent(a.getActiveContent());
        vo.setActiveStartDate(a.getActiveStartDate());
        vo.setActiveEndDate(a.getActiveEndDate());
        return vo;
    }

    @Override
    public ActivityVO getActivityVOByActiveId(int activeId) {
        Active a = activeMapper.selectByActiveId(activeId);
        if(EmptyUtil.isEmpty(a)) return null;
        ActivityVO vo = new ActivityVO();
        vo.setActiveId(a.getActiveId());
        vo.setActiveView(a.getActiveView());
        vo.setActivePicUrl(a.getActivePicUrl());
        vo.setActiveCategory(activeCategoryMapper.selectById(a.getActiveCategoryId()).getActiveCategoryContent());
        vo.setActiveNowNum(a.getActiveNowNum());
        vo.setActiveMaxNum(a.getActiveMaxNum());
        vo.setActiveAddress(a.getActiveAddress());
        vo.setStartSign1(DateUtil.GetLocalDateTimeFromDefaultPattern(a.getStartSign(), SysConstants.PATTERN_3));
        vo.setActiveTitle(a.getActiveTitle());
        vo.setEndSign1(DateUtil.GetLocalDateTimeFromDefaultPattern(a.getEndSign(), SysConstants.PATTERN_3));
        //状态
        vo.setActiveStatus(judgeActivity(a));
        vo.setActiveCss(judgeCss(vo.getActiveStatus()));
        vo.setActiveContent(a.getActiveContent());
        vo.setActiveStartDate1(DateUtil.GetLocalDateTimeFromDefaultPattern(a.getActiveStartDate(), SysConstants.PATTERN_3));
        vo.setActiveEndDate1(DateUtil.GetLocalDateTimeFromDefaultPattern(a.getActiveEndDate(), SysConstants.PATTERN_3));

        return vo;
    }

    @Override
    public List<ActivityVO> getActivityVOByUserId(int userId) {
        List<ActiveUser> activeUserList = activeUserMapper.selectByUserId(userId);
        if (EmptyUtil.isEmpty(activeUserList)) return null;
        List<ActivityVO> vos = new ArrayList<>();
        for (ActiveUser activeUser : activeUserList) {
            Active a = activeMapper.selectByActiveId(activeUser.getActiveId());
            ActivityVO vo = new ActivityVO();
            vo.setActiveId(a.getActiveId());
            vo.setActiveCategory(activeCategoryMapper.selectById(a.getActiveCategoryId()).getActiveCategoryContent());
            vo.setActiveTitle(a.getActiveTitle());;
            //状态
            vo.setActiveStatus(judgeActivity(a));
            vo.setActiveStartDate1(DateUtil.GetLocalDateTimeFromDefaultPattern(a.getActiveStartDate(), SysConstants.PATTERN_3));
            vo.setActiveEndDate1(DateUtil.GetLocalDateTimeFromDefaultPattern(a.getActiveEndDate(), SysConstants.PATTERN_3));
            vos.add(vo);
        }
        return EmptyUtil.isEmpty(vos) ? null : vos;
    }

    @Override
    public int getPageCount() {
        Page<ActivityVO> vos = PageHelper.startPage(1, SysConstants.ACTIVITY_COUNT);
        activeMapper.selectByRight(0);
        return vos.getPages();
    }

    @Override
    public String signUp(int userId, int activeId) {
        Active active = activeMapper.selectByActiveId(activeId);
        //判断是否过了报名时间
        String str = judgeActivity(active);
        if(str == "规划中") {
            return "报名还没还没开始！";
        } else if (str != "报名中") {
            return "报名已经结束了！";
        }
        //判断报名人数
        if(active.getActiveMaxNum() == active.getActiveNowNum()) {
            return "报名人数已经满了！";
        }
        if(activeUserMapper.insertByActiveUser(new ActiveUser(0, activeId, userId)) <= 0) {
            return "报名失败！";
        }
        //报名人数加1
        activeMapper.addUserCountByActiveId(activeId);
        return null;
    }

    @Override
    public boolean querySignByUserIdAndActiveId(int userId, int activeId) {
        return !EmptyUtil.isEmpty(activeUserMapper.selectByUserIdAndActiveId(userId, activeId));
    }

    @Override
    public boolean addView(int activeId) {
        return activeMapper.addViewByActiveId(activeId) > 0;
    }

    /**
     * 判断活动处于什么状态
     * 0：规划中
     * 1：报名中
     * 2：等待中
     * 3：进行中
     * 4：已结束
     * @param active
     * @return
     */
    private String judgeActivity(Active active) {
        if(DateUtil.compareDate(active.getStartSign())) {
            //活动报名还没开始
            return "规划中";
        } else if (DateUtil.compareDate(active.getEndSign())){
            return "报名中";
        } else if (DateUtil.compareDate(active.getActiveStartDate())){
            return "等待中";
        } else if (DateUtil.compareDate(active.getActiveEndDate())){
            return "进行中";
        } else {
            return "已结束";
        }
    }

    private String judgeCss(String status) {
        if(status == "规划中") return "prepare";
        else if (status == "已结束") return "end";
        return "";
    }


}
