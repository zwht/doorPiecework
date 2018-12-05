package com.zw.config;

/**
 * Created by zhaowei on 2017/8/15.
 */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        ParameterBuilder tokenPar = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<Parameter>();
        tokenPar.name("token")
                .description("token令牌")
                .modelRef(new ModelRef("string"))
                .parameterType("header")
                .defaultValue("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE1NDI0MjUxMjk2MjYsInBheWxvYWQiOiJ7XCJpZFwiOlwiMTIxXCIsXCJsb2dpbk5hbWVcIjpcInp3XCIsXCJ0eXBlXCI6XCIxXCIsXCJyb2xlc1wiOlwiMFwiLFwiY29ycG9yYXRpb25JZFwiOlwiXCJ9In0.iukAapm6uNlQwvyRadKgZODl6IgmukGbvyqoK6yFWG8")
                .required(false)
                .build();
        pars.add(tokenPar.build());

        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .build()
                .globalOperationParameters(pars)
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("木门计价系统接口API 文档")
                .description("重庆川峰门业公司旗下系统，HTTP对外开放接口")
                .version("1.0.0")
                .termsOfServiceUrl("http://120.79.171.251")
                .license("LICENSE")
                .licenseUrl("http://120.79.171.251")
                .build();
    }

}
