package com.tensquare.config;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2Config {

    @Bean
    public Docket articleApiConfig() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("articleApi")
                .apiInfo(articleApiInfo())
                .select()
                .paths(Predicates.and(PathSelectors.regex("/article/.*")))
                .build();
    }

    private ApiInfo articleApiInfo() {
        return new ApiInfoBuilder()
                .title("网站-API文档")
                .description("本文档描述了网站文章微服务接口定义")
                .version("1.0")
                .contact(new Contact("tensquare", "http://tensquare.com", "3088887@gmail.com"))
                .build();
    }

    @Bean
    public Docket commentApiConfig() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("commentApi")
                .apiInfo(commentApiInfo())
                .select()
                .paths(Predicates.and(PathSelectors.regex("/comment/.*")))
                .build();
    }

    private ApiInfo commentApiInfo() {
        return new ApiInfoBuilder()
                .title("网站-API文档")
                .description("本文档描述了网站文章微服务接口定义")
                .version("1.0")
                .contact(new Contact("tensquare", "http://tensquare.com", "3088887@gmail.com"))
                .build();
    }

    @Bean
    public Docket labelApiConfig() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("labelApi")
                .apiInfo(labelApiInfo())
                .select()
                .paths(Predicates.and(PathSelectors.regex("/label/.*")))
                .build();
    }

    private ApiInfo labelApiInfo() {
        return new ApiInfoBuilder()
                .title("网站-API文档")
                .description("本文档描述了网站文章微服务接口定义")
                .version("1.0")
                .contact(new Contact("tensquare", "http://tensquare.com", "3088887@gmail.com"))
                .build();
    }

    @Bean
    public Docket noticeApiConfig() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("noticeApi")
                .apiInfo(noticeApiInfo())
                .select()
                .paths(Predicates.and(PathSelectors.regex("/notice/.*")))
                .build();
    }

    private ApiInfo noticeApiInfo() {
        return new ApiInfoBuilder()
                .title("网站-API文档")
                .description("本文档描述了网站文章微服务接口定义")
                .version("1.0")
                .contact(new Contact("tensquare", "http://tensquare.com", "3088887@gmail.com"))
                .build();
    }
}
