package com.hut.kenny.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class SystemHealthMentalVO implements Serializable {
    private static final long serialVersionUID = -2251160605623898745L;

    private String userName;
    private Integer userId;
    private String date;
    @JsonFormat(pattern = "YYYY-MM-dd", timezone = "GMT+8")
    private Date uhmDate;
    private Integer uhmCount;

    private Integer page;
    private Integer total;
    private Integer pageCount;
}
