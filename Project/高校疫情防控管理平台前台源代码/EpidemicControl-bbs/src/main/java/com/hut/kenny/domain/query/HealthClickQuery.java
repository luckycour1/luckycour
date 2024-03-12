package com.hut.kenny.domain.query;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.util.Date;

/**
 * TODO 健康打卡查询参数
 * @Title: HealthClickQuery
 * @Description:
 * @Author: 李铖
 * @Version: 1.0
 * @Date:  2022/4/14 9:25
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HealthClickQuery {
    @Max(value = 42, message = "人体体温不得超过42度")
    @Min(value = 35, message = "人体体温不得低于35度")
    @NotNull(message = "体温不得为空")
    private Float ccTemperature;

    @NotNull(message = "症状选择为必选值")
    private Integer symptomId;

    @NotNull(message = "是否正在隔离为必选值")
    private Integer ccIsGap;

    @NotNull(message = "是否处于中高风险地区为必选值")
    private Integer ccIsGodanger;

    @NotNull(message = "是否接种疫苗为必选值")
    private Integer ccIsVacc;

    @NotNull(message = "当前健康码颜色为必选值")
    private Integer ccCard;

    @NotBlank(message = "当前地址为必填值")
    private String ccAddress;
}
