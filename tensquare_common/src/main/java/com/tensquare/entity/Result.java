package com.tensquare.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "统一返回类型")
public class Result {
    @ApiModelProperty(value = "是否成功")
    private boolean flag;
    @ApiModelProperty(value = "返回码")
    private Integer code;
    @ApiModelProperty(value = "返回信息")
    private String message;
    @ApiModelProperty(value = "返回数据")
    private Object data;

    public Result(Builder builder) {
        this.flag = builder.flag;
        this.code = builder.code;
        this.message = builder.message;
        this.data = builder.data;
    }


    public final static class Builder {
        private boolean flag;
        private Integer code;
        private String message;
        private Object data;

        public Builder flag(boolean val) {
            this.flag = val;
            return this;
        }

        public Builder code(Integer val) {
            this.code = val;
            return this;
        }

        public Builder message(String val) {
            this.message = val;
            return this;
        }

        public Builder data(Object val) {
            this.data = val;
            return this;
        }

        public Result build() {
            return new Result(this);
        }

    }

}
