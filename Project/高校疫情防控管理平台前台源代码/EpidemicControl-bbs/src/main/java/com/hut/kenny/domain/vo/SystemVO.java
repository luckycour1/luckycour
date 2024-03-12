package com.hut.kenny.domain.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

/**
 * TODO 系统管理VO
 * @Title: SystemVO
 * @Description:
 * @Author: 李铖
 * @Version: 1.0
 * @Date:  2022/4/21 18:01
 */
@Data
public class SystemVO implements Serializable {
    private static final long serialVersionUID = 101136096223394606L;

    private int userCount;
    private int feedbackCount;
    private int exceptionCount;
    private int clickCount;
//    private List<String> leftCategory;
    private List<String> rightCategory;
//    private List<Integer> leftData;
    private List<Integer> rightData;

    private List<HashMap<String, Object>> mapList;
}



















