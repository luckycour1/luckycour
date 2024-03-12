package com.hut.kenny.service;

import com.hut.kenny.domain.entity.Post;
import com.hut.kenny.domain.vo.IndexPostVO;

import java.util.List;

/**
 * TODO 公告
 * @Title: PostService
 * @Description:
 * @Author: 李铖
 * @Version: 1.0
 * @Date:  2022/4/18 19:49
 */
public interface PostService {
    /**
     * 根据帖子类别获取帖子页数
     * @param categoryId
     * @return
     */
    int getPageCountByCategoryId(int categoryId);

    /**
     * 根据类型获取帖子
     * @param category
     * @return
     */
    List<IndexPostVO> getIndexPostVOByCategoryAndLimit(int category, int limit);

    /**
     * 根据id获取帖子
     * @param postId
     * @return
     */
    IndexPostVO getIndexPostVOByPostId(int postId);

    /**
     * 获取帖子列表
     * @param categoryId
     * @param page
     * @return
     */
    List<Post> getPostByCategoryId(int categoryId, int page);

    /**
     * 根据id获取帖子
     * @param postId
     * @return
     */
    Post getPostByPostId(int postId);
}






















