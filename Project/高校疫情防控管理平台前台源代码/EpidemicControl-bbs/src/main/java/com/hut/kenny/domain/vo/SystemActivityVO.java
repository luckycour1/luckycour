package com.hut.kenny.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hut.kenny.domain.entity.ActiveCategory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SystemActivityVO implements Serializable {
    private static final long serialVersionUID = -2251160605623898745L;

    private Integer activeId;
    private String activeTitle;
    private Integer activeView;
    private String activePicUrl;
    private String activeStatusName;
    private String activeCategoryContent;
    private Integer activeNowNum;
    private Integer activeMaxNum;
    private String activeAddress;
    private String activeContent;
    private Integer activeIsCover;

    @JsonFormat(pattern = "YYYY/MM/dd HH:mm", timezone = "GMT+8")
    private Date activeStartDate;
    @JsonFormat(pattern = "YYYY/MM/dd HH:mm", timezone = "GMT+8")
    private Date activeEndDate;
    @JsonFormat(pattern = "YYYY/MM/dd HH:mm", timezone = "GMT+8")
    private Date startSign;
    @JsonFormat(pattern = "YYYY/MM/dd HH:mm", timezone = "GMT+8")
    private Date endSign;

    //查询参数
    private Integer activeStatusId;
    private Integer activeCategoryId;
    private String date1;
    private String date2;
    private String date3;
    private String date4;

    private Integer page;
    private Integer total;
    private Integer pageCount;

}
