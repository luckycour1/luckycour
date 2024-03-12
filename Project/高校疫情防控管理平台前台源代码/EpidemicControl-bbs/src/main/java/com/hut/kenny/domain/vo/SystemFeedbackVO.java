package com.hut.kenny.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class SystemFeedbackVO implements Serializable {
    private static final long serialVersionUID = -2251160605623898745L;
    private Integer fdId;
    private String fdCategory;
    private String fdContent;
    private String fdTitle;
    private String userName;
    private int userId;
    private String userPhone;
//    @JsonFormat(pattern = "YYYY-MM-dd", timezone = "GMT+8")
    private String date;
    private String fdStatus;
    private String fdPicUrl;


    private Integer fdCategoryId;
    private Integer fdStatusId;
    @JsonFormat(pattern = "YYYY-MM-dd", timezone = "GMT+8")
    private Date fdDate;

    private int page;

    private int total;
    private int pageCount;
}