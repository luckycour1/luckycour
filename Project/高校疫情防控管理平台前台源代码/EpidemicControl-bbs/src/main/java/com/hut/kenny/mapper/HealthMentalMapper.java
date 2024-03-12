package com.hut.kenny.mapper;

import com.hut.kenny.domain.entity.HealthMental;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface HealthMentalMapper extends Mapper<HealthMental> {
    /**
     * 通过种类
     * @param category
     * @param count
     * @return
     */
    List<HealthMental> selectByCategoryAndCount(@Param("category") int category, @Param("count") int count);

    HealthMental selectById(int hmId);
}
