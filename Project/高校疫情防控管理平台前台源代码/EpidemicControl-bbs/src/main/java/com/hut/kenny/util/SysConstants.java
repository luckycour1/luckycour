package com.hut.kenny.util;

/**
 * TODO 定义静态常量
 * @Title: SysConstants
 * @Description:
 * @Author: 李铖
 * @Version: 1.0
 * @Date:  2022/4/16 8:30
 */
public interface SysConstants {

    String ACTIVITYINDEXURL = "";


    //反馈中心一页的数量
    int FEEDBACK_COUNT = 10;

    //活动界面一页数量
    int ACTIVITY_COUNT = 12;

    int POST_COUNT = 10;

    int INDEX_POST_COUNT = 7;

    //后台每一页是6个数据
    int SYSTEM_COUNT = 7;

    String[] ACTIVITYSTATUS = {"规划中", "报名中", "等待中", "进行中", "已结束"};

    String[] FDSTATUS = {"未受理", "受理中", "已处理", "已撤销"};


    String[] CARD = {"绿码", "红码", "黄码"};


    String PATTERN_1 = "yyyy年MM月dd日 HH:mm:ss";
    String PATTERN_2 = "yyyy/MM/dd";
    String PATTERN_3 = "MM-dd HH:mm";
    String PATTERN_4 = "MM-dd";
}
