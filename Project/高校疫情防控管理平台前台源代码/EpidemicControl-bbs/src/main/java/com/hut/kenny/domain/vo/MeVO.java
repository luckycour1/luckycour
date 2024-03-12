package com.hut.kenny.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * TODO 个人界面显示对象
 * @Title: MeVO
 * @Description:
 * @Author: 李铖
 * @Version: 1.0
 * @Date:  2022/4/17 11:17
 */
@Data
public class MeVO implements Serializable {
    private static final long serialVersionUID = 1923762674283575018L;

    private Integer userId;
    private String userName;
    private String userPwd;
    private String userNum;
    private Integer userLevel;
    private String userPhone;
    private Integer classId;
    @JsonFormat(pattern = "YYYY-MM-dd", timezone = "GMT+8")
    private Date birthday;
    private String headerIcon;
    private Integer userSex;
    private Integer faculty;
    private Integer major;

}
