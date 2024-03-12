package com.hut.kenny.domain.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class IndexPostVO implements Serializable {
    private static final long serialVersionUID = 306673762764940433L;

    private Integer postId;

    private String postTitle;

    private String date;

    private Integer postView;

    private String postUrl;

    private String postCategory;


}
