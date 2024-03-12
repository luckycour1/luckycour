package com.hut.kenny.service;

import com.hut.kenny.domain.entity.Admin;

/**
 * TODO
 * @Title: AdminService
 * @Description:
 * @Author: 李铖
 * @Version: 1.0
 * @Date:  2022/4/20 21:16
 */
public interface AdminService {

    Admin adminLogin(String loginName, String loginPwd);
}
