package com.hut.kenny.service.impl;

import com.hut.kenny.domain.entity.Class;
import com.hut.kenny.domain.entity.User;
import com.hut.kenny.domain.vo.MeVO;
import com.hut.kenny.mapper.ClassMapper;
import com.hut.kenny.mapper.UserMapper;
import com.hut.kenny.service.MeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MeServiceImpl implements MeService {
    @Autowired
    private ClassMapper classMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public MeVO getMeVO(User user) {
        Class c = classMapper.selectById(user.getClassId());
        MeVO vo = new MeVO();
        BeanUtils.copyProperties(user, vo);
        vo.setMajor(c.getParentId());
        vo.setFaculty(classMapper.selectById(vo.getMajor()).getParentId());
//        System.out.println(vo);
        return vo;
    }

    @Override
    public boolean keepUser(User user) {
        return userMapper.updateUser(user) > 0;
    }
}
