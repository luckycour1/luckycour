package com.hut.kenny.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hut.kenny.domain.entity.Post;
import com.hut.kenny.domain.vo.IndexPostVO;
import com.hut.kenny.mapper.PostMapper;
import com.hut.kenny.service.PostService;
import com.hut.kenny.util.DateUtil;
import com.hut.kenny.util.EmptyUtil;
import com.hut.kenny.util.SysConstants;
import javafx.geometry.Pos;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class PostServiceImpl implements PostService {
    @Autowired
    private PostMapper postMapper;

    @Override
    public int getPageCountByCategoryId(int categoryId) {
//        PageHelper.offsetPage()
        Page<Post> post = PageHelper.startPage(1, SysConstants.POST_COUNT);
        postMapper.selectAllByCategory(categoryId);
        return post.getPages();
    }

    @Override
    public List<IndexPostVO> getIndexPostVOByCategoryAndLimit(int categoryId, int limit) {
        Page<Post> post = PageHelper.offsetPage(0, limit);
        postMapper.selectAllByCategory(categoryId);
        List<IndexPostVO> vos = new ArrayList<>();
        for (Post p : post) {
            IndexPostVO vo = new IndexPostVO();
            BeanUtils.copyProperties(p, vo);
            vo.setDate(DateUtil.GetLocalDateTimeFromDefaultPattern(p.getPostDate(), SysConstants.PATTERN_4));
            vos.add(vo);
        }
        return EmptyUtil.isEmpty(vos) ? null : vos;
    }

    @Override
    public IndexPostVO getIndexPostVOByPostId(int postId) {
        postMapper.updatePostViewByPostId(postId);
        Post post = postMapper.selectByPostId(postId);
        IndexPostVO vo = new IndexPostVO();
        BeanUtils.copyProperties(post, vo);
        vo.setDate(DateUtil.GetLocalDateTimeFromDefaultPattern(post.getPostDate(), SysConstants.PATTERN_2));
        return vo;
    }

    @Override
    public List<Post> getPostByCategoryId(int categoryId, int page) {
        Page<Post> post = PageHelper.startPage(page, SysConstants.POST_COUNT);
        postMapper.selectAllByCategory(categoryId);
        return EmptyUtil.isEmpty(post) ? null : post;
    }

    @Override
    public Post getPostByPostId(int postId) {
        //获取一次浏览量 + 1
        if(postMapper.updatePostViewByPostId(postId) <= 0) return null;
        return postMapper.selectByPostId(postId);
    }
}
