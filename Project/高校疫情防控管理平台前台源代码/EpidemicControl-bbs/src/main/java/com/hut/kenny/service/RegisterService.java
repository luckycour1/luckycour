package com.hut.kenny.service;

import com.hut.kenny.domain.entity.Class;
import com.hut.kenny.domain.entity.User;

import java.util.List;

/**
 * TODO 获取班级信息
 * @Title: ClassService
 * @Description:
 * @Author: 李铖
 * @Version: 1.0
 * @Date:  2022/4/12 17:15  
 */
public interface RegisterService {
    /**
     * TODO 通过父节点获取class信息
     * @Title: ClassService
     * @Description:
     * @Author: 李铖
     * @Version: 1.0
     * @Date:  2022/4/12 17:17  
     */
    List<Class> getClassByParentId(int parentId);

    /**
     *
     * @param id
     * @return
     */
    Class getClassById(int id);

    boolean register(User user);
}
















