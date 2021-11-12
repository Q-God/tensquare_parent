package com.tensquare.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "状态码")
public class StatusCode {
    @ApiModelProperty(value = "成功")
    public static final int OK = 20000;
    @ApiModelProperty(value = "失败")
    public static final int ERROR = 20001;
    @ApiModelProperty(value = "用户名或密码错误")
    public static final int LOGINERROR = 20002;
    @ApiModelProperty(value = "权限不足")
    public static final int ACCESSERROR = 20003;
    @ApiModelProperty(value = "远程调用失败")
    public static final int REMOTEERROR = 20004;
    @ApiModelProperty(value = "重复操作")
    public static final int REPERROR = 20005;
}
