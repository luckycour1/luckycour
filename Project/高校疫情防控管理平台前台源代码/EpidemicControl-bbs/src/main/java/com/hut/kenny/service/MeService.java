package com.hut.kenny.service;

import com.hut.kenny.domain.entity.User;
import com.hut.kenny.domain.vo.MeVO;

/**
 * TODO 个人界面业务逻辑层
 * @Title: MeService
 * @Description:
 * @Author: 李铖
 * @Version: 1.0
 * @Date:  2022/4/17 11:21
 */
public interface MeService {

    /**
     * 通过user获取VO显示对象
     * @param user
     * @return
     */
    MeVO getMeVO(User user);

    /**
     * 保存user信息
     * @param user
     * @return
     */
    boolean keepUser(User user);

}
