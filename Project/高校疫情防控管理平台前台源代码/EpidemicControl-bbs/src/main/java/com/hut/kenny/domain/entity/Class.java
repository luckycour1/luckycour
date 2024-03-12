package com.hut.kenny.domain.entity;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "`class`")
public class Class implements Serializable {
    @Id
    @Column(name = "`class_id`")
    private Integer classId;

    @Column(name = "`class_name`")
    private String className;

    @Column(name = "`parent_id`")
    private Integer parentId;

    private static final long serialVersionUID = 1L;

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

    /**
     * @return class_name
     */
    public String getClassName() {
        return className;
    }

    /**
     * @param className
     */
    public void setClassName(String className) {
        this.className = className;
    }

    /**
     * @return parent_id
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * @param parentId
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }
}