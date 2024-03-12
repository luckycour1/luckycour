package com.hut.kenny.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * TODO 后台打卡管理视图对象
 * @Title: ClickCardVO
 * @Description:
 * @Author: 李铖
 * @Version: 1.0
 * @Date:  2022/4/22 21:11
 */
@Data
public class ClickCardVO implements Serializable {
    private static final long serialVersionUID = -2290089706301892618L;

    private int userId;
    private String userName;
    private Integer ccId;
//    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "YYYY-MM-dd", timezone = "GMT+8")
    private Date ccDate;
    private Float ccTemperature;
    private String symptom;
    private String isGodanger;
    private String isVacc;
    private String ccCard;
    private String ccAddress;
    private String isGap;

    private int page;
    private int total;
    private int pageCount;
    private String date;
}
