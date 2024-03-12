package com.hut.kenny.web.controller;

import com.hut.kenny.domain.entity.Post;
import com.hut.kenny.domain.vo.ActivityVO;
import com.hut.kenny.domain.vo.IndexPostVO;
import com.hut.kenny.service.PostService;
import com.hut.kenny.util.EmptyUtil;
import com.hut.kenny.util.ReturnValue;
import com.hut.kenny.util.SysConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;

/**
 * TODO 帖子接口
 * @Title: PostController
 * @Description:
 * @Author: 李铖
 * @Version: 1.0
 * @Date:  2022/4/18 19:57
 */
@Controller
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping({"/announcement"})
    public String announcement(Map map){
        map.put("title", "校园公告");
        return "post";
    }

    @GetMapping({"/education"})
    public String education(Map map){
        map.put("title", "思政教育");
        return "post";
    }

    @GetMapping({"/news"})
    public String news(){
        return "news";
    }

    @PostMapping("/post/count")
    @ResponseBody
    public Object count(int categoryId) {
        return new ReturnValue().success(postService.getPageCountByCategoryId(categoryId));
    }

    @PostMapping("/post/data")
    @ResponseBody
    public Object data(int categoryId, int page) {
        List<Post> postList = postService.getPostByCategoryId(categoryId, page);
        if(EmptyUtil.isEmpty(postList)) return new ReturnValue().returnFail("无法查询到这么多数据！");
        return new ReturnValue().success(postList);
    }

    @GetMapping({"/post/{postId}"})
    public String postContent(@PathVariable("postId")int postId, Map map, HttpServletRequest request){
        IndexPostVO vo = postService.getIndexPostVOByPostId(postId);

        StringBuffer sb = new StringBuffer();
        BufferedReader br = null;
        String path = request.getServletContext().getRealPath("/WEB-INF/upload/" + vo.getPostUrl());
        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        map.put("vo", vo);
        map.put("content", sb.toString());
        return "postContent";
    }
}
