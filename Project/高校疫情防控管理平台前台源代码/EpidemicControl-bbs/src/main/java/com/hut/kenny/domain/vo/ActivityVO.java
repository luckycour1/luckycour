package com.hut.kenny.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * TODO 活动界面显示对象
 * @Title: ActivityVO
 * @Description:
 * @Author: 李铖
 * @Version: 1.0
 * @Date:  2022/4/17 18:10
 */
@Data
public class ActivityVO implements Serializable {
    private static final long serialVersionUID = -2290089706301892618L;

    private Integer activeId;
    private String activeTitle;
    private Integer activeView;
    private String activePicUrl;
    private String activeStatus;
    private String activeCategory;
    private Integer activeNowNum;
    private Integer activeMaxNum;
    private String activeAddress;
    private String activeContent;
    private String activeCss;

    @JsonFormat(pattern = "MM-dd HH:mm", timezone = "GMT+8")
    private Date activeStartDate;
    @JsonFormat(pattern = "MM-dd HH:mm", timezone = "GMT+8")
    private Date activeEndDate;

    @JsonFormat(pattern = "MM-dd HH:mm", timezone = "GMT+8")
    private Date startSign;
    @JsonFormat(pattern = "MM-dd HH:mm", timezone = "GMT+8")
    private Date endSign;

    private String startSign1;
    private String endSign1;
    private String activeStartDate1;
    private String activeEndDate1;
}
