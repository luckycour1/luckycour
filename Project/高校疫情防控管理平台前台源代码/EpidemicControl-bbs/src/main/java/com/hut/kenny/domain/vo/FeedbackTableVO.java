package com.hut.kenny.domain.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * TODO 反馈表格vo
 * @Title: FeedbackTableVO
 * @Description:
 * @Author: 李铖
 * @Version: 1.0
 * @Date:  2022/4/16 13:28
 */
@Data
public class FeedbackTableVO implements Serializable {
    private static final long serialVersionUID = -2251160605623898745L;
    private Integer fdId;
    private String fdCategory;
    private String fdContent;
    private String fdTitle;
    private String userPhone;
    private String date;
    private String fdStatus;
    private String fdPicUrl;
}
