package com.tensquare.base.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @version v1.0
 * @ClassName Label
 * @Description TODO
 * @Author Q
 */
@Data
@TableName("tb_lable")
public class Label implements Serializable {
    //id
    @TableId(type = IdType.INPUT)
    private String id;

    //标签名称
    private String labelname;

    //状态
    private String state;

    //使用数量
    private int count;

    //是否推荐
    private String recommend;

    //关注数
    private int fans;
}
