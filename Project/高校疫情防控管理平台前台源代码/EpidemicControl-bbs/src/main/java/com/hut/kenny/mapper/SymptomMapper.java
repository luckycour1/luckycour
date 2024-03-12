package com.hut.kenny.mapper;

import com.hut.kenny.domain.entity.Symptom;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface SymptomMapper extends Mapper<Symptom> {

    /**
     * 获取所有症状信息
     * @return
     */
    List<Symptom> selectAllSymptom();

    /**
     * 通过主键获取症状信息
     * @return
     */
    Symptom selectById(int id);
}