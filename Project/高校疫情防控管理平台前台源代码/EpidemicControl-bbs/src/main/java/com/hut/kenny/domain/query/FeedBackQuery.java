package com.hut.kenny.domain.query;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * TODO 反馈界面查询对象
 * @Title: FeedBackQuery
 * @Description:
 * @Author: 李铖
 * @Version: 1.0
 * @Date:  2022/4/16 11:28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FeedBackQuery {
    @NotBlank(message = "反馈标题不可为空")
    private String fdTitle;
    @NotBlank(message = "联系人电话不可为空")
    private String userPhone;
    @NotNull(message = "反馈类别不可不选")
    private Integer fdCategoryId;
    @NotBlank(message = "反馈内容不可为空")
    private String fdContent;
}
