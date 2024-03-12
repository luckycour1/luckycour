package com.hut.kenny.service;

import com.hut.kenny.domain.entity.UserHm;
import com.hut.kenny.domain.vo.HealthMentalVO;
import com.hut.kenny.domain.vo.SystemHealthProblemVO;
import com.hut.kenny.domain.vo.SystemQuestions;

import java.util.List;

/**
 * TODO 健康问卷服务层
 * @Title: HealthMentalService
 * @Description:
 * @Author: 李铖
 * @Version: 1.0
 * @Date:  2022/4/14 22:36
 */
public interface HealthMentalService {
    /**
     * 获取健康问卷显示对象
     * @return
     */
    HealthMentalVO getHealthMentalVO();

    /**
     * 保存用户试卷
     * @param userHms
     * @return
     */
    boolean preUserMental(List<UserHm> userHms);

    SystemQuestions getQuestions(int userId, int uhmCount);
}
