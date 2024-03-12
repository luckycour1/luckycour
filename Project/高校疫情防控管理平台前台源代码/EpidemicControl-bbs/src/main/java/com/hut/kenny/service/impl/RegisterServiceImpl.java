package com.hut.kenny.service.impl;

import com.hut.kenny.domain.entity.Class;
import com.hut.kenny.domain.entity.Number;
import com.hut.kenny.domain.entity.User;
import com.hut.kenny.mapper.ClassMapper;
import com.hut.kenny.mapper.NumberMapper;
import com.hut.kenny.mapper.UserMapper;
import com.hut.kenny.service.RegisterService;
import com.hut.kenny.util.EmptyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(timeout = 3, rollbackFor = Exception.class, readOnly = false)
public class RegisterServiceImpl implements RegisterService {
    @Autowired
    private ClassMapper classMapper;

    @Autowired
    private NumberMapper numberMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<Class> getClassByParentId(int parentId) {
        List<Class> classList = classMapper.selectByParentNode(parentId);
        return EmptyUtil.isEmpty(classList) ? null : classList;
    }

    @Override
    public Class getClassById(int id) {
        Class c = classMapper.selectById(id);
        return EmptyUtil.isEmpty(c) ? null : c;
    }

    @Override
    public boolean register(User user) {
        Number number = numberMapper.selectByNumberName(user.getUserNum());
        if(EmptyUtil.isEmpty(number)) {
            return false;
        }
        user.setUserLevel(number.getUserLevel());
        if(userMapper.insert(user) < 1) {
            return false;
        }
        return true;
    }


}
