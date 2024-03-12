package com.hut.kenny.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hut.kenny.domain.entity.Class;
import com.hut.kenny.domain.entity.User;
import com.hut.kenny.domain.query.LoginQuery;
import com.hut.kenny.mapper.ClassMapper;
import com.hut.kenny.mapper.UserMapper;
import com.hut.kenny.service.UserService;
import com.hut.kenny.util.EmptyUtil;
import com.hut.kenny.util.SysConstants;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(timeout = 3, rollbackFor = Exception.class, readOnly = false)
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private ClassMapper classMapper;

    @Override
    public com.hut.kenny.domain.entity.User login(LoginQuery loginQuery) {
        com.hut.kenny.domain.entity.User user = new com.hut.kenny.domain.entity.User();
        BeanUtils.copyProperties(loginQuery, user);
        return userMapper.selectOne(user);
    }

    @Override
    public Page<User> getUserByPage(int page) {
        Page<User> userPage = PageHelper.startPage(page, SysConstants.SYSTEM_COUNT);
        userMapper.selectAll();
//        Page<User> userVOS = new Page<>();
//        userVOS.setPageSize(SysConstants.SYSTEM_COUNT);
//        userVOS.setTotal(userPage.getTotal());
//        List<User> userList = userMapper
        return userPage;
    }

    @Override
    public Page<User> getUserByPageAndCondition(int page, User user) {
        Page<User> userPage = PageHelper.startPage(page, SysConstants.SYSTEM_COUNT);
        userMapper.selectUserByCondition(user);
        return userPage;
    }

    @Override
    public boolean deleteUserByUserID(int userId) {
        return userMapper.deleteByUserId(userId) > 0;
    }

    @Override
    public String getClassNameByClassId(int classId) {
        String c = "";
        Class c1 = null;
        Class c2 = null;
        Class c3 = null;
        c1 = classMapper.selectById(classId);
        if (EmptyUtil.nonEmpty(c1)) {
            c2 = classMapper.selectById(c1.getParentId());
        }
        if(EmptyUtil.nonEmpty(c2)) {
            c3 = classMapper.selectById(c2.getParentId());
        }
        if(EmptyUtil.nonEmpty(c3)) {
            c += c3.getClassName();
        }
        if(EmptyUtil.nonEmpty(c2)) {
            c += c2.getClassName();
        }
        if(EmptyUtil.nonEmpty(c1)) {
            c += c1.getClassName();
        }
        return c;
    }
}
