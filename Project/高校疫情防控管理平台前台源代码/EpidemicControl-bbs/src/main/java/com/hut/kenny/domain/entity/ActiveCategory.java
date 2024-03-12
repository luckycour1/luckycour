package com.hut.kenny.domain.entity;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "`active_category`")
public class ActiveCategory implements Serializable {
    @Id
    @Column(name = "`active_category_id`")
    private Integer activeCategoryId;

    @Column(name = "`active_category_content`")
    private String activeCategoryContent;

    private static final long serialVersionUID = 1L;

    /**
     * @return active_category_id
     */
    public Integer getActiveCategoryId() {
        return activeCategoryId;
    }

    /**
     * @param activeCategoryId
     */
    public void setActiveCategoryId(Integer activeCategoryId) {
        this.activeCategoryId = activeCategoryId;
    }

    /**
     * @return active_category_content
     */
    public String getActiveCategoryContent() {
        return activeCategoryContent;
    }

    /**
     * @param activeCategoryContent
     */
    public void setActiveCategoryContent(String activeCategoryContent) {
        this.activeCategoryContent = activeCategoryContent;
    }
}