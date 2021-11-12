package com.tensquare.notice.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @version v1.0
 * @ClassName NoticeFresh
 * @Description TODO
 * @Author Q
 */
@Data
@TableName("tb_notice_fresh")
public class NoticeFresh {
    @TableField("userId")
    private String userId;
    @TableField("noticeId")
    private String noticeId;
}
