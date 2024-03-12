package com.hut.kenny.domain.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "`click_card`")
@Data
public class ClickCard implements Serializable {
    @Id
    @Column(name = "`cc_id`")
    private Integer ccId;

    @Column(name = "`user_id`")
    private Integer userId;

    @Column(name = "`cc_date`")
    private Date ccDate;

    @Column(name = "`cc_temperature`")
    private Float ccTemperature;

    @Column(name = "`symptom_id`")
    private Integer symptomId;

    @Column(name = "`cc_is_godanger`")
    private Integer ccIsGodanger;

    @Column(name = "`cc_is_vacc`")
    private Integer ccIsVacc;

    @Column(name = "`cc_card`")
    private Integer ccCard;

    @Column(name = "`cc_address`")
    private String ccAddress;

    @Column(name = "`cc_is_gap`")
    private Integer ccIsGap;

    private static final long serialVersionUID = 1L;

}