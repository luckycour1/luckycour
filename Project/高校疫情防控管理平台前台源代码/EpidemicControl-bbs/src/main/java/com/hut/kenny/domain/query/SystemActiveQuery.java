package com.hut.kenny.domain.query;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SystemActiveQuery implements Serializable {
    private static final long serialVersionUID = -2251160605623898745L;

    @NotBlank(message = "活动标题不可为空")
    private String activeTitle;
    @NotBlank(message = "图片路径不可为空")
    private String activePicUrl;

    @NotNull(message = "活动类别不可为空")
    private Integer activeCategoryId;

    @NotNull(message = "活动最大人数不可为空")
    private Integer activeMaxNum;
    @NotBlank(message = "活动地址不可为空")
    private String activeAddress;
    @NotBlank(message = "活动内容不可为空")
    private String activeContent;
    @NotNull(message = "活动是否为封面不可为空")
    private Integer activeIsCover;

    @NotBlank(message = "活动报名时间不可为空")
    private String date1;
    @NotBlank(message = "活动结束报名时间不可为空")
    private String date2;
    @NotBlank(message = "活动开始时间不可为空")
    private String date3;
    @NotBlank(message = "活动结束时间不可为空")
    private String date4;
}
