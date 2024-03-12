package com.hut.kenny.domain.entity;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name = "`user_hm`")
public class UserHm {
    @Id
    @Column(name = "`uhm_id`")
    private Integer uhmId;

    @Column(name = "`user_id`")
    private Integer userId;

    @Column(name = "`hm_id`")
    private Integer hmId;

    @Column(name = "`uhm_count`")
    private Integer uhmCount;

    @Column(name = "`uhm_answer`")
    private String uhmAnswer;

    @Column(name = "`uhm_date`")
    private Date uhmDate;
}
