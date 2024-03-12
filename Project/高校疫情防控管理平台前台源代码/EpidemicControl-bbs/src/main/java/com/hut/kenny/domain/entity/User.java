package com.hut.kenny.domain.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "`user`")
@Data
public class User implements Serializable {
    @Id
    @Column(name = "`user_id`")
    private Integer userId;

    @Column(name = "`user_name`")
    private String userName;

    @Column(name = "`user_pwd`")
    private String userPwd;

    @Column(name = "`user_num`")
    private String userNum;

    @Column(name = "`user_level`")
    private Integer userLevel;

    @Column(name = "`user_phone`")
    private String userPhone;

    @Column(name = "`class_id`")
    private Integer classId;

    @Column(name = "`birthday`")
    private Date birthday;

    @Column(name = "`header_icon`")
    private String headerIcon;

    @Column(name = "`user_sex`")
    private Integer userSex;

    private static final long serialVersionUID = 1L;

    /**
     * @return user_id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * @return user_name
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return user_pwd
     */
    public String getUserPwd() {
        return userPwd;
    }

    /**
     * @param userPwd
     */
    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    /**
     * @return user_num
     */
    public String getUserNum() {
        return userNum;
    }

    /**
     * @param userNum
     */
    public void setUserNum(String userNum) {
        this.userNum = userNum;
    }

    /**
     * @return user_level
     */
    public Integer getUserLevel() {
        return userLevel;
    }

    /**
     * @param userLevel
     */
    public void setUserLevel(Integer userLevel) {
        this.userLevel = userLevel;
    }

    /**
     * @return user_phone
     */
    public String getUserPhone() {
        return userPhone;
    }

    /**
     * @param userPhone
     */
    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    /**
     * @return class_id
     */
    public Integer getClassId() {
        return classId;
    }

    /**
     * @param classId
     */
    public void setClassId(Integer classId) {
        this.classId = classId;
    }
}