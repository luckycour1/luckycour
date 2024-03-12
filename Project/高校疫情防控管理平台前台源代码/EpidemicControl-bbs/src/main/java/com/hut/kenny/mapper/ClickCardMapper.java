package com.hut.kenny.mapper;

import com.hut.kenny.domain.entity.ClickCard;
import com.hut.kenny.domain.entity.Symptom;
import tk.mybatis.mapper.common.Mapper;

import java.util.Date;
import java.util.List;

public interface ClickCardMapper extends Mapper<ClickCard> {
    /**
     * 插入
     * @param clickCard
     * @return
     */
    int insertClickCard(ClickCard clickCard);

    /**
     * 通过userId获取当天打卡数量
     * @param userId
     * @return
     */
    int selectTodayCountByUserId(int userId);

    /**
     * 获取正常打卡数
     * @return
     */
    int selectNormalCount();

    /**
     * 获取异常打卡数
     * @return
     */
    int selectExceptionCount();

    List<ClickCard> selectNormalByDate(Date date);

    List<ClickCard> selectByCondition(ClickCard clickCard);

    List<ClickCard> selectExceptionByDate(Date date);
}




