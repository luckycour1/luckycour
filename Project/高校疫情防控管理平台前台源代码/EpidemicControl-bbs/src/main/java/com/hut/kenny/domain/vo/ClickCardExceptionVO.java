package com.hut.kenny.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class ClickCardExceptionVO implements Serializable {
    private static final long serialVersionUID = -2290089706301892618L;

    private Date ccDate;
    private Integer symptomId;
    private Integer ccIsGodanger;
    private Integer ccIsVacc;
    private Integer ccCard;
    private Integer ccIsGap;
    private Integer page;
    private Integer total;
    private String date;

    private Integer isClick;
}
