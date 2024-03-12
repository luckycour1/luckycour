package com.hut.kenny.service.impl;

import com.hut.kenny.mapper.ActiveMapper;
import com.hut.kenny.service.FeedbackService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
        "classpath:spring/spring-mybatis.xml", "classpath:spring/spring-mvc.xml"
})
public class FeedbackServiceImplTest {
    @Autowired
    private FeedbackService feedbackService;

    @Autowired
    private ActiveMapper activeMapper;

    @Test
    public void getClassByParentId1() {
        activeMapper.deleteByActiveId(38);
    }


    @Test
    public void getClassByParentId() {
        System.out.println(feedbackService.getFeedbackTableVOByFdId(1));
    }
}