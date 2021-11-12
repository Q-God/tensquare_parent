package com.tensquare.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@ApiModel(value = "分页结果")
@Data
@AllArgsConstructor
public class PageResult<T> {
    @ApiModelProperty(value = "总记录数")
    private Long total;
    @ApiModelProperty(value = "分页数据")
    private List<T> rows;
}
