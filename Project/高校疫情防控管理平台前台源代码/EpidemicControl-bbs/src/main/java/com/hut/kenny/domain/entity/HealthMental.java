package com.hut.kenny.domain.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "`health_mental`")
public class HealthMental {

    @Id
    @Column(name = "`hm_id`")
    private Integer hmId;

    @Column(name = "`hm_category`")
    private Integer hmCategory;

    @Column(name = "`hm_title`")
    private String hmTitle;

    @Column(name = "`hm_qa`")
    private String hmQa;

    @Column(name = "`hm_qb`")
    private String hmQb;

    @Column(name = "`hm_qc`")
    private String hmQc;

    @Column(name = "`hm_qd`")
    private String hmQd;

    @Column(name = "`hm_qe`")
    private String hmQe;

    @Column(name = "`hm_qf`")
    private String hmQf;

}
