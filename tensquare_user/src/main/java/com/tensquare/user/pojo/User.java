package com.tensquare.user.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@ApiModel("User类")
@Data
@TableName("tb_user")
public class User implements Serializable {
    @ApiModelProperty("ID")
    @TableId(type = IdType.INPUT)
    private String id;

    @ApiModelProperty("手机号")
    private String mobile;

    @ApiModelProperty("用户密码")
    private String password;

    @ApiModelProperty("用户昵称")
    private String nickname;

    @ApiModelProperty("性别")
    private String sex;

    @ApiModelProperty("生日")
    private Date birthday;

    @ApiModelProperty("头像")
    private String avatar;

    @ApiModelProperty("邮箱")
    private String email;

    @ApiModelProperty("注册时间")
    private Date regdate;

    @ApiModelProperty("更新时间")
    private Date updatedate;

    @ApiModelProperty("最后一次操作时间")
    private Date lastdate;

    @ApiModelProperty("手机号")
    private Long online;

    @ApiModelProperty("兴趣爱好")
    private String interest;

    @ApiModelProperty("个性签名")
    private String personality;

    @ApiModelProperty("粉丝数")
    private Integer fanscount;

    @ApiModelProperty("收藏数")
    private Integer followcount;

}