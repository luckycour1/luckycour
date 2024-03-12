package com.hut.kenny.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Data
@Table(name = "`post`")
public class Post implements Serializable {
    @Id
    @Column(name = "`post_id`")
    private Integer postId;

    @Column(name = "`post_title`")
    private String postTitle;

    @JsonFormat(pattern = "YYYY-MM-dd", timezone = "GMT+8")
    @Column(name = "`post_date`")
    private Date postDate;

    @Column(name = "`post_view`")
    private Integer postView;

    @Column(name = "`post_url`")
    private String postUrl;

    @Column(name = "`post_category`")
    private Integer postCategory;

    private static final long serialVersionUID = 1L;


}