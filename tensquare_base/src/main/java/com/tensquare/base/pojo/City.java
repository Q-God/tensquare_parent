package com.tensquare.base.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @version v1.0
 * @ClassName City
 * @Description TODO
 * @Author Q
 */
@Data
@TableName("tb_city")
public class City implements Serializable {

    @TableId(type = IdType.INPUT)
    private String id;
    //城市名
    private String cityName;
    //是否热门
    private String isHot;
}
