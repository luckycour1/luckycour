package com.hut.kenny.mapper;

import com.hut.kenny.domain.entity.ActiveCategory;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ActiveCategoryMapper extends Mapper<ActiveCategory> {
    /**
     * 通过id获取种类
     * @param categoryId
     * @return
     */
    ActiveCategory selectById(int categoryId);

    List<ActiveCategory> selectAllCategory();
}