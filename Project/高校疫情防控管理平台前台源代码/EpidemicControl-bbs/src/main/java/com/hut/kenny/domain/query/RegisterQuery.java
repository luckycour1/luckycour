package com.hut.kenny.domain.query;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * TODO 注册查询参数
 * @Title: RegisterQuery
 * @Description:
 * @Author: 李铖
 * @Version: 1.0
 * @Date:  2022/4/13 18:38
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterQuery {
    @NotBlank(message = "用户名不可为空")
    private String userName;

    @NotNull(message = "班级号不可为空")
    private Integer classId;

    @NotBlank(message = "学号不可为空")
    private String userNum;

    @NotBlank(message = "电话号码不可为空")
    private String userPhone;

    @NotBlank(message = "密码不可为空")
    private String userPwd;
}
