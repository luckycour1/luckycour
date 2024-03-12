package com.hut.kenny.domain.entity;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "`fd_category`")
public class FdCategory implements Serializable {
    @Id
    @Column(name = "`fd_category_id`")
    private Integer fdCategoryId;

    @Column(name = "`category_name`")
    private String categoryName;

    private static final long serialVersionUID = 1L;

    /**
     * @return fd_category_id
     */
    public Integer getFdCategoryId() {
        return fdCategoryId;
    }

    /**
     * @param fdCategoryId
     */
    public void setFdCategoryId(Integer fdCategoryId) {
        this.fdCategoryId = fdCategoryId;
    }

    /**
     * @return category_name
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * @param categoryName
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}