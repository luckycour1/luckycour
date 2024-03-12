package com.hut.kenny.service.impl;

import com.hut.kenny.domain.query.LoginQuery;
import com.hut.kenny.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
        "classpath:spring/spring-mybatis.xml", "classpath:spring/spring-mvc.xml"
})
public class UserServiceImplTest {
    @Autowired
    private UserService userService;
    @Test
    public void login() {
        System.out.println(userService.login(new LoginQuery("20408000910", "123456")).getUserId());
    }
}