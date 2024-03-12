package com.hut.kenny.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class SystemPostVO  implements Serializable {
    private static final long serialVersionUID = 101136096223394606L;

    private Integer postId;
    private String postTitle;
    @JsonFormat(pattern = "YYYY-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date postDate;
    private Integer postView;
    private String postUrl;
    private Integer postCategory;
    private String postCategoryName;

    private String content;

    private int page;
    private String date;

    private int total;
    private int pageCount;
}
