package com.hut.kenny.domain.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class SystemHealthProblemVO implements Serializable {
    private static final long serialVersionUID = 101136096223394606L;
    private List<String> question;
    private int singleAnswer;
    private List<Integer> multipleAnswer;
    private String hmTitle;
}
