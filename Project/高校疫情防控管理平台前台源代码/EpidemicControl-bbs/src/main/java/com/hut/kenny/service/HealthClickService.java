package com.hut.kenny.service;

import com.github.pagehelper.Page;
import com.hut.kenny.domain.entity.ClickCard;
import com.hut.kenny.domain.entity.Symptom;
import com.hut.kenny.domain.vo.ClickCardExceptionVO;

import java.util.Date;
import java.util.List;

/**
 * TODO 健康打卡
 * @Title: HealthClickService
 * @Description:
 * @Author: 李铖
 * @Version: 1.0
 * @Date:  2022/4/14 8:57
 */
public interface HealthClickService {

    /**
     * 健康打卡
     * @param clickCard
     * @return
     */
    boolean healthClick(ClickCard clickCard);

    /**
     * 验证是否已经打卡
     * true: 已打卡
     * false：未打卡
     * @param userId
     * @return
     */
    boolean verIsClick(int userId);

    /**
     * 获取所有的症状信息
     * @return
     */
    List<Symptom> getAllSymptom();


    Page<ClickCard> getNormalByDateAndPage(Date date, int page);

    Page<ClickCard> getExceptionByCondition(ClickCardExceptionVO vo);

    Page<ClickCard> getExceptionByDateAndPage(Date date, int page);

}
