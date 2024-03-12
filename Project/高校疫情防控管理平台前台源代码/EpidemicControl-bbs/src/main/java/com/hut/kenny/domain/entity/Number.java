package com.hut.kenny.domain.entity;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "`number`")
public class Number implements Serializable {
    @Id
    @Column(name = "`number_id`")
    private Integer numberId;

    @Column(name = "`number_name`")
    private String numberName;

    @Column(name = "`user_level`")
    private Integer userLevel;

    private static final long serialVersionUID = 1L;

    /**
     * @return number_id
     */
    public Integer getNumberId() {
        return numberId;
    }

    /**
     * @param numberId
     */
    public void setNumberId(Integer numberId) {
        this.numberId = numberId;
    }

    /**
     * @return number_name
     */
    public String getNumberName() {
        return numberName;
    }

    /**
     * @param numberName
     */
    public void setNumberName(String numberName) {
        this.numberName = numberName;
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
}