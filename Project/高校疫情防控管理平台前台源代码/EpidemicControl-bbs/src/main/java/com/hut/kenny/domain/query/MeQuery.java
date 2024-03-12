package com.hut.kenny.domain.query;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * TODO 个人中心查询
 * @Title: MeQuery
 * @Description:
 * @Author: 李铖
 * @Version: 1.0
 * @Date:  2022/4/17 12:14
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MeQuery {

    @NotBlank(message = "姓名不可为空")
    private String userName;
    @NotBlank(message = "联系人电话不可为空")
    private String userPhone;
    @NotNull(message = "班级不可不选")
    private Integer classId;
    private Integer userSex;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    @NotBlank(message = "密码不可为空")
    private String userPwd;

}























