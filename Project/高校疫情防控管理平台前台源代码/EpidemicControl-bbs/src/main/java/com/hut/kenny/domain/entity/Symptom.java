package com.hut.kenny.domain.entity;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "`symptom`")
public class Symptom implements Serializable {
    @Id
    @Column(name = "`symptom_id`")
    private Integer symptomId;

    @Column(name = "`symptom_name`")
    private String symptomName;

    private static final long serialVersionUID = 1L;

    /**
     * @return symptom_id
     */
    public Integer getSymptomId() {
        return symptomId;
    }

    /**
     * @param symptomId
     */
    public void setSymptomId(Integer symptomId) {
        this.symptomId = symptomId;
    }

    /**
     * @return symptom_name
     */
    public String getSymptomName() {
        return symptomName;
    }

    /**
     * @param symptomName
     */
    public void setSymptomName(String symptomName) {
        this.symptomName = symptomName;
    }
}