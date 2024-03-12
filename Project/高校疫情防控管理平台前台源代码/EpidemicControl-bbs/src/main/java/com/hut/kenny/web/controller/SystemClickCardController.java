package com.hut.kenny.web.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hut.kenny.domain.entity.ClickCard;
import com.hut.kenny.domain.entity.User;
import com.hut.kenny.domain.vo.ClickCardExceptionVO;
import com.hut.kenny.domain.vo.ClickCardVO;
import com.hut.kenny.domain.vo.SystemUserVO;
import com.hut.kenny.mapper.SymptomMapper;
import com.hut.kenny.mapper.UserMapper;
import com.hut.kenny.service.HealthClickService;
import com.hut.kenny.service.UserService;
import com.hut.kenny.util.DateUtil;
import com.hut.kenny.util.EmptyUtil;
import com.hut.kenny.util.ReturnValue;
import com.hut.kenny.util.SysConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.unit.DataUnit;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class SystemClickCardController {
    @Autowired
    private HealthClickService healthClickService;
    @Autowired
    private SymptomMapper symptomMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserService userService;


    @PostMapping("/system/normal")
    @ResponseBody
    public Object normal(@RequestBody ClickCardVO clickCardVO) throws ParseException {
        clickCardVO.setCcDate(DateUtil.StringToDate(clickCardVO.getDate()));
//        System.out.println(DateUtil.GetLocalDateTimeFromDefaultPattern(clickCardVO.getCcDate()));
//        System.out.println(userVOS);
        Page<ClickCard> clickCards = healthClickService.getNormalByDateAndPage(clickCardVO.getCcDate(), clickCardVO.getPage());
        if (EmptyUtil.isEmpty(clickCards.getResult())) {
            return new ReturnValue().returnFail("当前没有打卡数据！");
        }
        List<ClickCardVO> clickCardVOS = new ArrayList<>();
        for (ClickCard clickCard : clickCards) {
            ClickCardVO vo1 = new ClickCardVO();
            vo1.setUserId(clickCard.getUserId());
            vo1.setTotal((int) clickCards.getTotal());
            vo1.setPageCount(SysConstants.SYSTEM_COUNT);
            vo1.setCcCard(SysConstants.CARD[clickCard.getCcCard()]);
            vo1.setCcDate(clickCard.getCcDate());
            vo1.setIsGap(clickCard.getCcIsGap() == 0 ? "否" : "是");
            vo1.setCcAddress(clickCard.getCcAddress());
            vo1.setIsGodanger(clickCard.getCcIsGodanger() == 0 ? "否" : "是");
            vo1.setIsVacc(clickCard.getCcIsVacc() == 0 ? "否" : "是");
            vo1.setCcTemperature(clickCard.getCcTemperature());
            vo1.setSymptom(symptomMapper.selectById(clickCard.getSymptomId()).getSymptomName());
            vo1.setUserName(userMapper.selectByUserId(clickCard.getUserId()).getUserName());
            clickCardVOS.add(vo1);
        }
        return new ReturnValue().success(clickCardVOS);
    }

    @PostMapping("/system/exception")
    @ResponseBody
    public Object exception(@RequestBody ClickCardExceptionVO clickCardExceptionVO) throws ParseException {
        clickCardExceptionVO.setCcDate(DateUtil.StringToDate(clickCardExceptionVO.getDate()));
//        System.out.println(DateUtil.GetLocalDateTimeFromDefaultPattern(clickCardVO.getCcDate()));
//        System.out.println(userVOS);
        Page<ClickCard> clickCards = healthClickService.getExceptionByDateAndPage(clickCardExceptionVO.getCcDate(), clickCardExceptionVO.getPage());
        if (EmptyUtil.isEmpty(clickCards.getResult())) {
            return new ReturnValue().returnFail("当前没有打卡数据！");
        }
        List<ClickCardVO> clickCardVOS = new ArrayList<>();
        for (ClickCard clickCard : clickCards) {
            ClickCardVO vo1 = new ClickCardVO();
            vo1.setUserId(clickCard.getUserId());
            vo1.setTotal((int) clickCards.getTotal());
            vo1.setPageCount(SysConstants.SYSTEM_COUNT);
            vo1.setCcCard(SysConstants.CARD[clickCard.getCcCard()]);
            vo1.setCcDate(clickCard.getCcDate());
            vo1.setIsGap(clickCard.getCcIsGap() == 0 ? "否" : "是");
            vo1.setCcAddress(clickCard.getCcAddress());
            vo1.setIsGodanger(clickCard.getCcIsGodanger() == 0 ? "否" : "是");
            vo1.setIsVacc(clickCard.getCcIsVacc() == 0 ? "否" : "是");
            vo1.setCcTemperature(clickCard.getCcTemperature());
            vo1.setSymptom(symptomMapper.selectById(clickCard.getSymptomId()).getSymptomName());
            vo1.setUserName(userMapper.selectByUserId(clickCard.getUserId()).getUserName());
            clickCardVOS.add(vo1);
        }
        return new ReturnValue().success(clickCardVOS);
    }

    @PostMapping("/system/noClick")
    @ResponseBody
    public Object noClick(@RequestBody ClickCardExceptionVO clickCardExceptionVO) throws ParseException {
        clickCardExceptionVO.setCcDate(DateUtil.StringToDate(clickCardExceptionVO.getDate()));
        Page<User> users = PageHelper.startPage(clickCardExceptionVO.getPage(), SysConstants.SYSTEM_COUNT);
        //查询未打卡
        userMapper.selectNotClick(clickCardExceptionVO.getCcDate());
        if (EmptyUtil.isEmpty(users)) {
            return new ReturnValue().returnFail("当前没有未打卡用户数据！");
        }
        List<ClickCardVO> clickCardVOS = new ArrayList<>();
        for (User user : users) {
            ClickCardVO clickCardVO = new ClickCardVO();
            clickCardVO.setUserId(user.getUserId());
            clickCardVO.setUserName(user.getUserName());
            clickCardVO.setTotal((int) users.getTotal());
            clickCardVO.setPageCount(SysConstants.SYSTEM_COUNT);
            clickCardVOS.add(clickCardVO);
        }
        return new ReturnValue().success(clickCardVOS);
    }

    @PostMapping("/system/exception/condition")
    @ResponseBody
    public Object exceptionCondition(@RequestBody ClickCardExceptionVO clickCardExceptionVO) throws ParseException {
        clickCardExceptionVO.setCcDate(DateUtil.StringToDate(clickCardExceptionVO.getDate()));
        System.out.println(clickCardExceptionVO.getIsClick() + "sss");
//        if (clickCardExceptionVO.getIsClick() != null) {
//            Page<User> users = PageHelper.startPage(clickCardExceptionVO.getPage(), SysConstants.SYSTEM_COUNT);
//            //查询未打卡
//            userMapper.selectNotClick();
//            if (EmptyUtil.isEmpty(users)) {
//                return new ReturnValue().returnFail("当前没有未打卡用户数据！");
//            }
//            List<ClickCardVO> clickCardVOS = new ArrayList<>();
//            for (User user : users) {
//                ClickCardVO clickCardVO = new ClickCardVO();
//                clickCardVO.setUserId(user.getUserId());
//                clickCardVO.setUserName(user.getUserName());
//                clickCardVOS.add(clickCardVO);
//            }
//            return new ReturnValue().success(clickCardVOS);
//        }


        Page<ClickCard> clickCards = healthClickService.getExceptionByCondition(clickCardExceptionVO);
        if (EmptyUtil.isEmpty(clickCards.getResult())) {
            return new ReturnValue().returnFail("当前没有打卡数据！");
        }
        List<ClickCardVO> clickCardVOS = new ArrayList<>();
        for (ClickCard clickCard : clickCards) {
            ClickCardVO vo1 = new ClickCardVO();
            vo1.setUserId(clickCard.getUserId());
            vo1.setTotal((int) clickCards.getTotal());
            vo1.setPageCount(SysConstants.SYSTEM_COUNT);
            vo1.setCcCard(SysConstants.CARD[clickCard.getCcCard()]);
            vo1.setCcDate(clickCard.getCcDate());
            vo1.setIsGap(clickCard.getCcIsGap() == 0 ? "否" : "是");
            vo1.setCcAddress(clickCard.getCcAddress());
            vo1.setIsGodanger(clickCard.getCcIsGodanger() == 0 ? "否" : "是");
            vo1.setIsVacc(clickCard.getCcIsVacc() == 0 ? "否" : "是");
            vo1.setCcTemperature(clickCard.getCcTemperature());
            vo1.setSymptom(symptomMapper.selectById(clickCard.getSymptomId()).getSymptomName());
            vo1.setUserName(userMapper.selectByUserId(clickCard.getUserId()).getUserName());
            clickCardVOS.add(vo1);
        }
        return new ReturnValue().success(clickCardVOS);
    }


    @PostMapping("/system/clickCard/userData")
    @ResponseBody
    public Object userData(@RequestBody ClickCardVO clickCardVO) throws ParseException {
        User user = userMapper.selectByUserId(clickCardVO.getUserId());
        if (EmptyUtil.isEmpty(user)) {
            return new ReturnValue().returnFail("未找到该用户！");
        }
        SystemUserVO systemUserVO = new SystemUserVO();
        systemUserVO.setUserId(user.getUserId());
        systemUserVO.setUserName(user.getUserName());
        systemUserVO.setUserNum(user.getUserNum());
        systemUserVO.setUserPhone(user.getUserPhone());
        systemUserVO.setPageCount(SysConstants.SYSTEM_COUNT);
        systemUserVO.setUserClass(userService.getClassNameByClassId(user.getClassId()));
        return new ReturnValue().success(systemUserVO);
    }


    @PostMapping("/system/clickCard/symptomData")
    @ResponseBody
    public Object symptomData() {
        return new ReturnValue().success(healthClickService.getAllSymptom());
    }



}
