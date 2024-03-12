package com.hut.kenny.domain.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class SystemQuestions implements Serializable {
    private static final long serialVersionUID = 101136096223394606L;

    private List<SystemHealthProblemVO> single;
    private List<SystemHealthProblemVO> multiple;
    private List<SystemHealthProblemVO> judge;

    private String userName;
    private Integer userId;
    private Integer uhmCount;
}
