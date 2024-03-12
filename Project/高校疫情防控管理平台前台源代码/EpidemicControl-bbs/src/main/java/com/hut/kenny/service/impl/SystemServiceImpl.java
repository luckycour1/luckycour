package com.hut.kenny.service.impl;

import com.hut.kenny.domain.entity.ActiveCategory;
import com.hut.kenny.domain.entity.FdCategory;
import com.hut.kenny.domain.vo.SystemVO;
import com.hut.kenny.mapper.*;
import com.hut.kenny.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
@Transactional
public class SystemServiceImpl implements SystemService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private FeedbackMapper feedbackMapper;
    @Autowired
    private UserHmMapper userHmMapper;
    @Autowired
    private ClickCardMapper clickCardMapper;
    @Autowired
    private ActiveCategoryMapper activeCategoryMapper;
    @Autowired
    private ActiveUserMapper activeUserMapper;
    @Autowired
    private FdCategoryMapper fdCategoryMapper;

    @Override
    public SystemVO getSystemVO() {
        SystemVO systemVO = new SystemVO();
        systemVO.setExceptionCount(clickCardMapper.selectExceptionCount());
        systemVO.setClickCount(clickCardMapper.selectNormalCount());
        systemVO.setUserCount(userMapper.selectUserCount());
        systemVO.setFeedbackCount(feedbackMapper.selectTodayCount());

        List<ActiveCategory> activeCategoryList = activeCategoryMapper.selectAllCategory();
//        List<String> list1 = new ArrayList<>();
//        List<Integer> integerList1 = new ArrayList<>();
        List<HashMap<String, Object>> hashMaps = new ArrayList<>();
        for(ActiveCategory activeCategory : activeCategoryList) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("name", activeCategory.getActiveCategoryContent());
            hashMap.put("value", activeUserMapper.selectCountByCategoryId(activeCategory.getActiveCategoryId()));
            hashMaps.add(hashMap);
//            list1.add(activeCategory.getActiveCategoryContent());
//            //获取报名数
//            integerList1.add(activeUserMapper.selectCountByCategoryId(activeCategory.getActiveCategoryId()));
        }
        systemVO.setMapList(hashMaps);
//        systemVO.setLeftCategory(list1);
//        systemVO.setLeftData(integerList1);
        List<FdCategory> fdCategoryList = fdCategoryMapper.selectAll();

        List<String> list2 = new ArrayList<>();
        List<Integer> integerList2 = new ArrayList<>();
        for (FdCategory fdCategory : fdCategoryList) {
            list2.add(fdCategory.getCategoryName());
            integerList2.add(feedbackMapper.selectTodayCountByCategory(fdCategory.getFdCategoryId()));
        }
        systemVO.setRightCategory(list2);
        systemVO.setRightData(integerList2);
//        System.out.println(systemVO);
        return systemVO;
    }


}
