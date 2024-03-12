package com.hut.kenny.domain.entity;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "`fd_pic`")
public class FdPic implements Serializable {
    @Id
    @Column(name = "`fd_pic_id`")
    private Integer fdPicId;

    @Column(name = "`fd_id`")
    private Integer fdId;

    @Column(name = "`fd_pic_url`")
    private String fdPicUrl;

    private static final long serialVersionUID = 1L;

    /**
     * @return fd_pic_id
     */
    public Integer getFdPicId() {
        return fdPicId;
    }

    /**
     * @param fdPicId
     */
    public void setFdPicId(Integer fdPicId) {
        this.fdPicId = fdPicId;
    }

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
     * @return fd_pic_url
     */
    public String getFdPicUrl() {
        return fdPicUrl;
    }

    /**
     * @param fdPicUrl
     */
    public void setFdPicUrl(String fdPicUrl) {
        this.fdPicUrl = fdPicUrl;
    }
}