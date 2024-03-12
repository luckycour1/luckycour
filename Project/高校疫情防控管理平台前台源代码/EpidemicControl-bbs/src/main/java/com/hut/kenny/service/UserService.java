package com.hut.kenny.service;

import com.github.pagehelper.Page;
import com.hut.kenny.domain.entity.User;
import com.hut.kenny.domain.query.LoginQuery;
import com.hut.kenny.domain.vo.SystemUserVO;

/**
 * TODO 用户业务接口
 * @Title: UserService
 * @Description:
 * @Author: 李铖
 * @Version: 1.0
 * @Date:  2022/4/12 11:29
 */
public interface UserService {
    User login(LoginQuery loginQuery);

    Page<User> getUserByPage(int page);

    Page<User> getUserByPageAndCondition(int page, User user);

    boolean deleteUserByUserID(int userId);

    String getClassNameByClassId(int classId);
}
