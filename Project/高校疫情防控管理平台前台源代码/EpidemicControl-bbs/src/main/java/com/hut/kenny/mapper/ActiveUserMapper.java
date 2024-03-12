package com.hut.kenny.mapper;

import com.hut.kenny.domain.entity.Active;
import com.hut.kenny.domain.entity.ActiveUser;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ActiveUserMapper extends Mapper<ActiveUser> {
    /**
     * 插入
     * @param activeUser
     * @return
     */
    int insertByActiveUser(ActiveUser activeUser);

    /**
     * 取消报名
     * @param userId
     * @param activeId
     * @return
     */
    int deleteByUserIdAndActiveId(@Param("userId")int userId, @Param("activeId")int activeId);

    int deleteByActiveId(@Param("activeId")int activeId);

    /**
     * 根据id获取用户报名活动
     * @param userId
     * @return
     */
    List<ActiveUser> selectByUserId(int userId);

    /**
     * 根据用户ID和活动ID查询
     * @param userId
     * @param activeId
     * @return
     */
    ActiveUser selectByUserIdAndActiveId(@Param("userId")int userId, @Param("activeId")int activeId);

    /**
     * 通过种类id获取活动人数
     * @return
     */
    int selectCountByCategoryId(int categoryId);
}