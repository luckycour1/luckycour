package com.hut.kenny.web.controller;

import com.hut.kenny.domain.entity.User;
import com.hut.kenny.domain.vo.ActivityVO;
import com.hut.kenny.service.ActivityService;
import com.hut.kenny.util.EmptyUtil;
import com.hut.kenny.util.ReturnValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.junit4.statements.SpringFailOnTimeout;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * TODO 活动界面控制器
 * @Title: ActivityContent
 * @Description:
 * @Author: 李铖
 * @Version: 1.0
 * @Date:  2022/4/17 13:46
 */
@Controller
public class ActivityController {
    @Autowired
    private ActivityService activityService;

    @GetMapping({"/activity.html", "/activity"})
    public String activity(Map map, @SessionAttribute(value = "LOGIN_TICKET", required = false)User user){
        if(EmptyUtil.isEmpty(user)) return "redirect:/login";
        map.put("cover", activityService.getActiveCover());
        map.put("table", activityService.getActivityVOByUserId(user.getUserId()));
        return "activity";
    }

    @PostMapping("/activity/pageData")
    @ResponseBody
    public Object pageData(int page) {
        List<ActivityVO> vos = activityService.getActivityVOByPage(page);
        ReturnValue returnValue = new ReturnValue();
        if(EmptyUtil.isEmpty(vos)) {
            return returnValue.returnFail("查询不到！");
        }
        return returnValue.success(vos);
    }

    @PostMapping("/activity/pageCount")
    @ResponseBody
    public Object pageCount() {
        ReturnValue returnValue = new ReturnValue();
        return returnValue.success(activityService.getPageCount());
    }

    @GetMapping({"/activity/{activeId}"})
    public String postContent(@PathVariable("activeId")int activeId, Map map, @SessionAttribute(value = "LOGIN_TICKET", required = false)User user){
        if(EmptyUtil.isEmpty(user)) return "redirect:/login";
        activityService.addView(activeId);
        ActivityVO vo = activityService.getActivityVOByActiveId(activeId);
        if(EmptyUtil.isEmpty(vo)) return null;
        map.put("vo", vo);
        return "activityContent";
    }

    @PostMapping("/activity/sign")
    @ResponseBody
    public Object sign(int activeId, @SessionAttribute(value = "LOGIN_TICKET", required = true)User user) {
        ReturnValue returnValue = new ReturnValue();
        if(activityService.querySignByUserIdAndActiveId(user.getUserId(), activeId)) {
            return returnValue.returnFail("不可重复报名！");
        }

        String str = activityService.signUp(user.getUserId(), activeId);
        if(!EmptyUtil.isEmpty(str)) {
            return returnValue.returnFail(str);
        }
        return returnValue.success("报名成功！");
    }

//    @GetMapping({"/activityContent.html", "/activityContent"})
//    public String activityContent(){
//        return "activityContent";
//    }
}
