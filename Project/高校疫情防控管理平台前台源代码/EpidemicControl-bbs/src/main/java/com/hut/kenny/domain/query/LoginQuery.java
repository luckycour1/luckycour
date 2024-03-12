package com.hut.kenny.domain.query;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

/**
 * TODO 登录查询参数
 * @Title: LoginQuery
 * @Description:
 * @Author: 李铖
 * @Version: 1.0
 * @Date:  2022/4/12 11:30  
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginQuery {
    @NotBlank(message = "账号为必填项！")
    private String userNum;
    @NotBlank(message = "密码为必填项！")
    private String userPwd;
}
