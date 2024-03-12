package com.hut.kenny.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SystemUserVO implements Serializable {
    private static final long serialVersionUID = 101136096223394606L;

    private String userName;
    private int userId;
    private String userNum;
    private String userPhone;
    private String userClass;
    private int page;

    private int total;
    private int pageCount;
}
