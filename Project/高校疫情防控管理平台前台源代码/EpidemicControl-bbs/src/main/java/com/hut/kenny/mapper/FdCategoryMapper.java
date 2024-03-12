package com.hut.kenny.mapper;

import com.hut.kenny.domain.entity.FdCategory;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface FdCategoryMapper extends Mapper<FdCategory> {

    /**
     * 获取所有类别信息
     * @return
     */
    List<FdCategory> selectAll();

    /**
     * 根据id获取种类
     * @return
     */
    FdCategory selectByCategoryId(@Param("id") int id);
}