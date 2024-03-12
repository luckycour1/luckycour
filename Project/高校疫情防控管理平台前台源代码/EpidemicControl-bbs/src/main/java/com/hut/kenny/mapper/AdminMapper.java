package com.hut.kenny.mapper;

import com.hut.kenny.domain.entity.ActiveUser;
import com.hut.kenny.domain.entity.Admin;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

public interface AdminMapper  extends Mapper<Admin> {

    Admin selectByLoginNameAndLoginPwd(@Param("loginName") String loginName, @Param("loginPwd") String loginPwd);
}
