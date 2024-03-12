package com.hut.kenny.domain.vo;

import com.hut.kenny.domain.entity.HealthMental;
import lombok.Data;

import java.util.List;

/**
 * TODO 健康问卷
 * @Title: HealthMentalVO
 * @Description:
 * @Author: 李铖
 * @Version: 1.0
 * @Date:  2022/4/14 22:34
 */
@Data
public class HealthMentalVO {
    private List<HealthMental> singleMental;

    private List<HealthMental> multipleMental;

    private List<HealthMental> judgeMental;

}
