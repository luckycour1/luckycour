package com.hut.kenny.domain.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Data
@Table(name = "`feedback`")
public class Feedback implements Serializable {
    @Id
    @Column(name = "`fd_id`")
    private Integer fdId;

    @Column(name = "`fd_categroy_id`")
    private Integer fdCategoryId;

    @Column(name = "`fd_content`")
    private String fdContent;

    @Column(name = "`user_id`")
    private Integer userId;

    @Column(name = "`fd_title`")
    private String fdTitle;

    @Column(name = "`user_phone`")
    private String userPhone;

    @Column(name = "`fd_date`")
    private Date fdDate;

    @Column(name = "`fd_status`")
    private Integer fdStatus;

    @Column(name = "`fd_pic_url`")
    private String fdPicUrl;

    private static final long serialVersionUID = 1L;

    /**
     * @return fd_id
     */
    public Integer getFdId() {
        return fdId;
    }

    /**
     * @param fdId
     */
    public void setFdId(Integer fdId) {
        this.fdId = fdId;
    }

    /**
     * @return fd_content
     */
    public String getFdContent() {
        return fdContent;
    }

    /**
     * @param fdContent
     */
    public void setFdContent(String fdContent) {
        this.fdContent = fdContent;
    }

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
     * @return fd_title
     */
    public String getFdTitle() {
        return fdTitle;
    }

    /**
     * @param fdTitle
     */
    public void setFdTitle(String fdTitle) {
        this.fdTitle = fdTitle;
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
     * @return fd_date
     */
    public Date getFdDate() {
        return fdDate;
    }

    /**
     * @param fdDate
     */
    public void setFdDate(Date fdDate) {
        this.fdDate = fdDate;
    }

    /**
     * @return fd_status
     */
    public Integer getFdStatus() {
        return fdStatus;
    }

    /**
     * @param fdStatus
     */
    public void setFdStatus(Integer fdStatus) {
        this.fdStatus = fdStatus;
    }
}