package com.hut.kenny.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import javax.persistence.*;

@Data
@Table(name = "`active_user`")
@AllArgsConstructor
@NoArgsConstructor
public class ActiveUser implements Serializable {
    @Id
    @Column(name = "`active_user_id`")
    private Integer activeUserId;

    @Column(name = "`active_id`")
    private Integer activeId;

    @Column(name = "`user_id`")
    private Integer userId;

    private static final long serialVersionUID = 1L;

}