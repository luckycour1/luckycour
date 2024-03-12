package com.hut.kenny.mapper;

import com.hut.kenny.domain.entity.Post;
import com.hut.kenny.domain.vo.SystemPostVO;
import javafx.geometry.Pos;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface PostMapper extends Mapper<Post> {

    /**
     * 根据类型获取帖子
     * @param category
     * @return
     */
    List<Post> selectAllByCategory(int category);

    /**
     * 根据帖子id获取帖子
     * @param postId
     * @return
     */
    Post selectByPostId(int postId);

    int updateByPost(Post post);

    List<Post> selectByCondition(SystemPostVO postVO);

    int deleteById(int postId);

    int insertPost(Post post);

    /**
     * 增加帖子观看量
     * @param postId
     * @return
     */
    int updatePostViewByPostId(int postId);
}





















