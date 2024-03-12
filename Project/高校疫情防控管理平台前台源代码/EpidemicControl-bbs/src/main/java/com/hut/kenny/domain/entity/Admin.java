package com.hut.kenny.domain.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name = "`admin`")
public class Admin {

    @Id
    @Column(name = "`admin_id`")
    private Integer adminId;

    @Column(name = "`admin_name`")
    private String adminName;

    @Column(name = "`admin_level`")
    private Integer adminLevel;

    @Column(name = "`login_name`")
    private String loginName;

    @Column(name = "`login_pwd`")
    private String loginPwd;

    @Column(name = "`level_name`")
    private String levelName;


}
