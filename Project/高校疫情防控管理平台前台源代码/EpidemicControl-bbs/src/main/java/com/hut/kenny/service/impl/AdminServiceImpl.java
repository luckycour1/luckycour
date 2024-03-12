package com.hut.kenny.service.impl;

import com.hut.kenny.domain.entity.Admin;
import com.hut.kenny.mapper.AdminMapper;
import com.hut.kenny.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Admin adminLogin(String loginName, String loginPwd) {
        return adminMapper.selectByLoginNameAndLoginPwd(loginName, loginPwd);
    }
}
