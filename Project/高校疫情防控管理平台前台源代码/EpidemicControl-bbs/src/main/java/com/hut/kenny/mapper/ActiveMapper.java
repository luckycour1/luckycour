package com.hut.kenny.mapper;

import com.hut.kenny.domain.entity.Active;
import com.hut.kenny.domain.vo.SystemActivityVO;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ActiveMapper extends Mapper<Active> {

    /**
     * 根据权限获取
     * 0：非封面
     * 1：封面
     * @param right
     * @return
     */
    List<Active> selectByRight(int right);

    List<Active> selectByCondition(SystemActivityVO vo);

    int deleteByActiveId(int activeId);
//    List<Active> selectByCondition(@Param("a") Active active, @Param("activeStatusId") int activeStatusId);

    /**
     * 根据获取id获取活动界面
     * @param activeId
     * @return
     */
    Active selectByActiveId(int activeId);

    int insertActivity(SystemActivityVO vo);

    int updateActivity(SystemActivityVO vo);

    /**
     * 增加点击量
     * @param activeId
     * @return
     */
    int addViewByActiveId(int activeId);

    /**
     * 增加报名人数
     * @param activeId
     * @return
     */
    int addUserCountByActiveId(int activeId);
}






















