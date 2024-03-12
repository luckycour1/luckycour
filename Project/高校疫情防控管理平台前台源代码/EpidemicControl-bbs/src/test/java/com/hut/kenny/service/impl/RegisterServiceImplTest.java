package com.hut.kenny.service.impl;

import com.hut.kenny.service.RegisterService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
        "classpath:spring/spring-mybatis.xml", "classpath:spring/spring-mvc.xml"
})
public class RegisterServiceImplTest {
    @Autowired
    private RegisterService classService;

    @Test
    public void getClassByParentId() {
        System.out.println(classService.getClassById(5).getClassId());
    }

    @Test
    public void getClassById() {
    }
}