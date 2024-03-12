package com.hut.kenny.domain.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class SystemActivityUser implements Serializable {
    private static final long serialVersionUID = 101136096223394606L;

    private String userName;
    private int userId;
    private String userNum;
    private String userPhone;
    private String userClass;
    private int activeId;
    private int page;

    private int total;
    private int pageCount;
}
