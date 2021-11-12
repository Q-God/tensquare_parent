package com.tensquare.article.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@ApiModel(value = "文章模型")
@TableName("tb_article")
@Data
@AllArgsConstructor
public class Article implements Serializable {

    @ApiModelProperty(value = "主键id")
    @TableId(type = IdType.INPUT)
    private String id;
    @ApiModelProperty(value = "专栏ID")
    private String columnid;
    @ApiModelProperty(value = "用户ID")
    private String userid;
    @ApiModelProperty(value = "标题")
    private String title;
    @ApiModelProperty(value = "文章正文")
    private String content;
    @ApiModelProperty(value = "文章封面")
    private String image;
    @ApiModelProperty(value = "发表日期")
    private Date createtime;
    @ApiModelProperty(value = "修改日期")
    private Date updatetime;
    @ApiModelProperty(value = "是否公开")
    private String ispublic;
    @ApiModelProperty(value = "是否置顶")
    private String istop;
    @ApiModelProperty(value = "浏览量")
    private Integer visits;
    @ApiModelProperty(value = "点赞数")
    private Integer thumbup;
    @ApiModelProperty(value = "评论数")
    private Integer comment;
    @ApiModelProperty(value = "审核状态")
    private String state;
    @ApiModelProperty(value = "所属频道")
    private String channelid;
    @ApiModelProperty(value = "URL")
    private String url;
    @ApiModelProperty(value = "类型")
    private String type;

    private Article(Builder builder) {
        this.id = builder.id;
        this.columnid = builder.columnid;
        this.userid = builder.userid;
        this.title = builder.title;
        this.content = builder.content;
        this.image = builder.image;
        this.createtime = builder.createtime;
        this.updatetime = builder.updatetime;
        this.ispublic = builder.ispublic;
        this.istop = builder.istop;
        this.visits = builder.visits;
        this.thumbup = builder.thumbup;
        this.comment = builder.comment;
        this.state = builder.state;
        this.channelid = builder.channelid;
        this.url = builder.url;
        this.type = builder.type;
    }

    public final static class Builder {
        private String id;//ID
        private String columnid;    //专栏ID
        private String userid;      //用户ID
        private String title;       //标题
        private String content;     //文章正文
        private String image;       //文章封面
        private Date createtime;    //发表日期
        private Date updatetime;    //修改日期
        private String ispublic;    //是否公开
        private String istop;       //是否置顶
        private Integer visits;     //浏览量
        private Integer thumbup;    //点赞数
        private Integer comment;    //评论数
        private String state;       //审核状态
        private String channelid;   //所属频道
        private String url;         //URL
        private String type;        //类型

        public Builder id(String val) {
            this.id = val;
            return this;
        }

        public Builder columnid(String val) {
            this.columnid = val;
            return this;
        }

        public Builder userid(String val) {
            this.userid = val;
            return this;
        }

        public Builder title(String val) {
            this.title = val;
            return this;
        }

        public Builder content(String val) {
            this.content = val;
            return this;
        }

        public Builder image(String val) {
            this.image = val;
            return this;
        }

        public Builder createtime(Date val) {
            this.createtime = val;
            return this;
        }

        public Builder updatetime(Date val) {
            this.updatetime = val;
            return this;
        }

        public Builder ispublic(String val) {
            this.ispublic = val;
            return this;
        }

        public Builder istop(String val) {
            this.istop = val;
            return this;
        }

        public Builder visits(Integer val) {
            this.visits = val;
            return this;
        }

        public Builder thumbup(Integer val) {
            this.thumbup = val;
            return this;
        }

        public Builder comment(Integer val) {
            this.comment = val;
            return this;
        }

        public Builder state(String val) {
            this.state = val;
            return this;
        }

        public Builder channelid(String val) {
            this.channelid = val;
            return this;
        }

        public Builder url(String val) {
            this.url = val;
            return this;
        }

        public Builder type(String val) {
            this.type = val;
            return this;
        }

        public Article build() {
            return new Article(this);
        }
    }
}
