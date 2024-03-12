package com.hut.kenny.domain.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Data
@Table(name = "`actvie`")
public class Active implements Serializable {
    @Id
    @Column(name = "`active_id`")
    private Integer activeId;

    @Column(name = "`active_title`")
    private String activeTitle;

    @Column(name = "`active_start_date`")
    private Date activeStartDate;

    @Column(name = "`active_end_date`")
    private Date activeEndDate;

    @Column(name = "`active_view`")
    private Integer activeView;

    @Column(name = "`active_pic_url`")
    private String activePicUrl;

    @Column(name = "`active_category_id`")
    private Integer activeCategoryId;

    @Column(name = "`active_content`")
    private String activeContent;

    @Column(name = "`active_now_num`")
    private Integer activeNowNum;

    @Column(name = "`active_max_num`")
    private Integer activeMaxNum;

    @Column(name = "`start_sign`")
    private Date startSign;

    @Column(name = "`end_sign`")
    private Date endSign;

    @Column(name = "`active_is_cover`")
    private Integer activeIsCover;

    @Column(name = "`active_address`")
    private String activeAddress;

    private static final long serialVersionUID = 1L;

}