package com.hut.kenny.service.impl;

import com.hut.kenny.domain.entity.HealthMental;
import com.hut.kenny.domain.entity.UserHm;
import com.hut.kenny.domain.vo.HealthMentalVO;
import com.hut.kenny.domain.vo.SystemHealthProblemVO;
import com.hut.kenny.domain.vo.SystemQuestions;
import com.hut.kenny.mapper.HealthMentalMapper;
import com.hut.kenny.mapper.UserHmMapper;
import com.hut.kenny.mapper.UserMapper;
import com.hut.kenny.service.HealthMentalService;
import com.hut.kenny.util.EmptyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class HealthMentalServiceImpl implements HealthMentalService {
    @Autowired
    private HealthMentalMapper healthMentalMapper;
    @Autowired
    private UserHmMapper userHmMapper;
    @Autowired
    private UserMapper userMapper;

    @Override
    public HealthMentalVO getHealthMentalVO() {
        //装配 默认单选 30个 多选10个 判断10个
        HealthMentalVO healthMentalVO = new HealthMentalVO();
        healthMentalVO.setSingleMental(healthMentalMapper.selectByCategoryAndCount(0, 30));
        healthMentalVO.setMultipleMental(healthMentalMapper.selectByCategoryAndCount(1, 10));
        healthMentalVO.setJudgeMental(healthMentalMapper.selectByCategoryAndCount(2, 10));
        return healthMentalVO;
    }

    @Override
    public boolean preUserMental(List<UserHm> userHms) {
        //获取用户作答次数
        int count = userHmMapper.selectCountByUserId(userHms.get(0).getUserId()) + 1;
        for(UserHm userHm : userHms) {
            userHm.setUhmCount(count);
        }
        return userHmMapper.insertUserHm(userHms) > 0;
    }

    @Override
    public SystemQuestions getQuestions(int userId, int uhmCount) {
        List<UserHm> userHms = userHmMapper.selectByUserIdAndUhmCount(userId, uhmCount);
        if(EmptyUtil.isEmpty(userHms)) return null;

        SystemQuestions questions = new SystemQuestions();
        List<SystemHealthProblemVO> single = new ArrayList<>();
        List<SystemHealthProblemVO> multiple = new ArrayList<>();
        List<SystemHealthProblemVO> judge = new ArrayList<>();

        for (UserHm userHm : userHms) {
            SystemHealthProblemVO vo = new SystemHealthProblemVO();
            HealthMental healthMental = healthMentalMapper.selectById(userHm.getHmId());
            List<String> question = new ArrayList<>();
            if(EmptyUtil.nonEmpty(healthMental.getHmQa())) {
                question.add(healthMental.getHmQa());
            }
            if(EmptyUtil.nonEmpty(healthMental.getHmQb())) {
                question.add(healthMental.getHmQb());
            }
            if(EmptyUtil.nonEmpty(healthMental.getHmQc())) {
                question.add(healthMental.getHmQc());
            }
            if(EmptyUtil.nonEmpty(healthMental.getHmQd())) {
                question.add(healthMental.getHmQd());
            }
            if(EmptyUtil.nonEmpty(healthMental.getHmQe())) {
                question.add(healthMental.getHmQe());
            }
            if(EmptyUtil.nonEmpty(healthMental.getHmQf())) {
                question.add(healthMental.getHmQf());
            }
            vo.setQuestion(question);
            vo.setHmTitle(healthMental.getHmTitle());
            if(healthMental.getHmCategory() == 0) {
                //单选/判断
                vo.setSingleAnswer(Integer.parseInt(userHm.getUhmAnswer()));
                single.add(vo);
            } else if(healthMental.getHmCategory() == 2) {
                //判断
                vo.setSingleAnswer(Integer.parseInt(userHm.getUhmAnswer()));
                judge.add(vo);
            } else{
                //多选
                List<Integer> m = new ArrayList<>();
                char[] chars = userHm.getUhmAnswer().toCharArray();
                for (char c : chars) {
                    m.add((int)c - 48);
                }
                vo.setMultipleAnswer(m);
                multiple.add(vo);
            }

        }
        questions.setMultiple(multiple);
        questions.setJudge(judge);
        questions.setSingle(single);
        questions.setUserId(userHms.get(0).getUserId());
        questions.setUserName(userMapper.selectByUserId(userHms.get(0).getUserId()).getUserName());
        return questions;
    }


}























