package com.hut.kenny.web.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hut.kenny.domain.entity.Admin;
import com.hut.kenny.domain.entity.Post;
import com.hut.kenny.domain.vo.IndexPostVO;
import com.hut.kenny.domain.vo.SystemPostVO;
import com.hut.kenny.mapper.PostMapper;
import com.hut.kenny.service.AdminService;
import com.hut.kenny.util.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO 系统帖子管理控制器
 * @Title: SystemPostController
 * @Description:
 * @Author: 李铖
 * @Version: 1.0
 * @Date:  2022/4/25 16:16
 */
@Controller
public class SystemPostController {
    @Autowired
    private PostMapper postMapper;
    @Autowired
    private AdminService adminService;

    @GetMapping({ "/postEdit"})
    public String login(HttpSession session, Map map, HttpServletRequest request){
//        session.getServletContext().
        String action = (String) session.getServletContext().getAttribute("admin");
        if(action == null) return "";
        if(action.equals("update")) {
            Post post = postMapper.selectByPostId((Integer) session.getServletContext().getAttribute("postId"));
            if(EmptyUtil.isEmpty(post)) return null;
            StringBuffer sb = new StringBuffer();
            BufferedReader br = null;
            String path = request.getServletContext().getRealPath("/WEB-INF/upload/" + post.getPostUrl());
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
            map.put("vo", post);
            map.put("content", sb.toString());
        }

        return "postEdit";
    }

    @PostMapping("/system/post/upload")
    @ResponseBody
    public Object upload(SystemPostVO vo, HttpServletRequest request, HttpSession session) throws IOException {
//        System.out.println(vo);
        if(EmptyUtil.isEmpty(vo.getPostCategory())) {
            return new ReturnValue().returnFail("类别未选择不可提交！");
        }
        if(EmptyUtil.isEmpty(vo.getPostTitle())) {
            return new ReturnValue().returnFail("帖子标题未填不可提交！");
        }
        if(EmptyUtil.isEmpty(vo.getContent())) {
            return new ReturnValue().returnFail("帖子内容未写不可提交！");
        }
        System.out.println(vo);
        String txtName = null;
        Post post = new Post();
        post.setPostId(vo.getPostId());
        post.setPostCategory(vo.getPostCategory());
        post.setPostTitle(vo.getPostTitle());
        if(vo.getPostId() != null) {
            //更新操作
            txtName = vo.getPostUrl();
            postMapper.updateByPost(post);
        } else {
            //添加操作
            txtName = ImageUtil.getFileName("1.txt");
            post.setPostUrl(txtName);
            postMapper.insertPost(post);
        }
        String targetPath = request.getServletContext().getRealPath("/WEB-INF/upload/") + txtName;
        String realPath = targetPath.substring(0, targetPath.indexOf("target")) + "src\\main\\webapp\\WEB-INF\\upload\\" + txtName;
        System.out.println(targetPath + "\n" + realPath);
        System.out.println(txtName);

        FileWriter fw = new FileWriter(targetPath);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(vo.getContent());
        bw.flush();
        bw.close();

        fw = new FileWriter(realPath);
        bw = new BufferedWriter(fw);
        bw.write(vo.getContent());
        bw.flush();
        bw.close();
        return new ReturnValue().success("操作成功！");
    }


    @PostMapping("/system/post/add")
    @ResponseBody
    public Object add(@RequestBody HashMap<String,Object> map, HttpSession session) {
        session.getServletContext().removeAttribute("admin");
        ReturnValue returnValue = new ReturnValue();
        Admin admin = adminService.adminLogin(map.get("loginName").toString(), map.get("loginPwd").toString());
//        System.out.println(loginName + "" + loginPwd);
        if(EmptyUtil.isEmpty(admin)) return returnValue.returnFail("参数错误！");
        session.getServletContext().setAttribute("admin", "add");

        return returnValue.success("");
    }

    @PostMapping("/system/post/update")
    @ResponseBody
    public Object update(@RequestBody HashMap<String,Object> map, HttpSession session) {
        session.getServletContext().removeAttribute("admin");
        session.getServletContext().removeAttribute("postId");
        if(EmptyUtil.isEmpty(map.get("postId"))) return null;
        ReturnValue returnValue = new ReturnValue();
        Admin admin = adminService.adminLogin(map.get("loginName").toString(), map.get("loginPwd").toString());
//        System.out.println(loginName + "" + loginPwd);
        if(EmptyUtil.isEmpty(admin)) return returnValue.returnFail("参数错误！");
        session.getServletContext().setAttribute("admin", "update");
        session.getServletContext().setAttribute("postId", map.get("postId"));
        return returnValue.success("");
    }

//    @GetMapping({"/post/{postId}"})
//    public String postContent(@PathVariable("postId")int postId, Map map, HttpServletRequest request){
//        IndexPostVO vo = postService.getIndexPostVOByPostId(postId);
//
//        StringBuffer sb = new StringBuffer();
//        BufferedReader br = null;
//        String path = request.getServletContext().getRealPath("/WEB-INF/upload/" + vo.getPostUrl());
//        try {
//            br = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
//            String line;
//            while ((line = br.readLine()) != null) {
//                sb.append(line).append("\n");
//            }
//            br.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        map.put("vo", vo);
//        map.put("content", sb.toString());
//        return "postContent";
//    }

    @PostMapping("/system/post")
    @ResponseBody
    public Object userData(@RequestBody SystemPostVO vo) throws ParseException {
        if(EmptyUtil.isEmpty(vo.getPage())) return null;
        if(EmptyUtil.nonEmpty(vo.getDate()) && !vo.getDate().equals("null")) {
            vo.setPostDate(DateUtil.StringToDate3(vo.getDate()));
        }
        Page<Post> postPage = PageHelper.startPage(vo.getPage(), SysConstants.SYSTEM_COUNT);
        postMapper.selectByCondition(vo);
        if(EmptyUtil.isEmpty(postPage.getResult())) return new ReturnValue().returnFail("没有查询到数据！");

        List<SystemPostVO> voList = new ArrayList<>();
        for (Post post : postPage) {
            SystemPostVO vo1 = new SystemPostVO();
            BeanUtils.copyProperties(post, vo1);
            vo1.setTotal((int) postPage.getTotal());
            vo1.setPageCount(SysConstants.SYSTEM_COUNT);
            vo1.setPostCategoryName(vo1.getPostCategory() == 1 ? "思政教育" : "校园公告");
            voList.add(vo1);
        }
        return new ReturnValue().success(voList);
    }

    @PostMapping("/system/post/delete")
    @ResponseBody
    public Object delete(@RequestBody SystemPostVO vo) {
        if(EmptyUtil.isEmpty(vo.getPostId())) {
            return null;
        }
        if(postMapper.deleteById(vo.getPostId()) > 0) {
            return new ReturnValue().success("删除成功！");
        }
        return new ReturnValue().returnFail("未找到或删除失败！");
    }


}















