package com.hut.kenny.mapper;

import com.hut.kenny.domain.entity.User;
import com.hut.kenny.domain.vo.SystemActivityUser;
import tk.mybatis.mapper.common.Mapper;

import java.util.Date;
import java.util.List;

public interface UserMapper extends Mapper<User> {

    @Override
    User selectOne(User user);

    @Override
    int insert(User user);

    User selectByUserId(int userId);

    int updateUser(User user);

    int selectUserCount();

    List<User> selectUserByCondition(User user);

    List<User> selectUserByActiveId(int activeId);

    List<User> selectUserByActiveIdAndCondition(SystemActivityUser user);

    List<User> selectAll();

    int deleteByUserId(int userId);

    List<User> selectNotClick(Date date);
}