package com.hut.kenny.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hut.kenny.domain.entity.ClickCard;
import com.hut.kenny.domain.entity.Symptom;
import com.hut.kenny.domain.vo.ClickCardExceptionVO;
import com.hut.kenny.mapper.ClickCardMapper;
import com.hut.kenny.mapper.SymptomMapper;
import com.hut.kenny.service.HealthClickService;
import com.hut.kenny.util.SysConstants;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class HealthClickServiceImpl implements HealthClickService {
    @Autowired
    private SymptomMapper symptomMapper;

    @Autowired
    private ClickCardMapper clickCardMapper;

    @Override
    public boolean healthClick(ClickCard clickCard) {
        return clickCardMapper.insertClickCard(clickCard) >= 1;
    }

    @Override
    public boolean verIsClick(int userId) {
        return clickCardMapper.selectTodayCountByUserId(userId) >= 1;
    }

    @Override
    public List<Symptom> getAllSymptom() {
        return symptomMapper.selectAllSymptom();
    }

    @Override
    public Page<ClickCard> getNormalByDateAndPage(Date date, int page) {
        Page<ClickCard> clickCards = PageHelper.startPage(page, SysConstants.SYSTEM_COUNT);
        clickCardMapper.selectNormalByDate(date);
        return clickCards;
    }

    @Override
    public Page<ClickCard> getExceptionByCondition(ClickCardExceptionVO vo) {
        ClickCard clickCard = new ClickCard();
        BeanUtils.copyProperties(vo, clickCard);
        System.out.println(clickCard);
        Page<ClickCard> clickCards = PageHelper.startPage(vo.getPage(), SysConstants.SYSTEM_COUNT);
        clickCardMapper.selectByCondition(clickCard);
        return clickCards;
    }

    @Override
    public Page<ClickCard> getExceptionByDateAndPage(Date date, int page) {
        Page<ClickCard> clickCards = PageHelper.startPage(page, SysConstants.SYSTEM_COUNT);
        clickCardMapper.selectExceptionByDate(date);
        return clickCards;
    }
}


















