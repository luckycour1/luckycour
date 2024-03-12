package com.hut.kenny.mapper;

import com.hut.kenny.domain.entity.Class;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ClassMapper extends Mapper<Class> {

    /**
     * 根据id获取值
     * @param cid
     * @return
     */
    Class selectById(int cid);

    /**
     * 获取子节点
     * @param parentId
     * @return
     */
    List<Class> selectByParentNode(int parentId);

}