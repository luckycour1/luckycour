package com.hut.kenny.mapper;

import com.hut.kenny.domain.entity.Number;
import tk.mybatis.mapper.common.Mapper;

public interface NumberMapper extends Mapper<Number> {

    /**
     * 通过学号获取 Number
     * @param numberName
     * @return
     */
    Number selectByNumberName(String numberName);
}