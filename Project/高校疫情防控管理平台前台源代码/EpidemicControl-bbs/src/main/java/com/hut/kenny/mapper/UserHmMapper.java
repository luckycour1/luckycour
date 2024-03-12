package com.hut.kenny.mapper;

import com.hut.kenny.domain.entity.UserHm;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface UserHmMapper extends Mapper<UserHm> {
    /**
     * 通过userId获取用户答题次数
     * @return
     */
    int selectCountByUserId(int userId);

    /**
     * 插入
     * @param userHms
     * @return
     */
    int insertUserHm(List<UserHm> userHms);


    List<UserHm> selectAllMental(UserHm userHm);

    List<UserHm> selectByUserIdAndUhmCount(@Param("userId")int userId, @Param("uhmCount")int uhmCount);
}
