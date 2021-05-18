package com.chenhao.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class SwaggerConfig implements WebMvcConfigurer {

    @Bean
    public Docket createRestApi() {

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.tebonx.mbupservice.web.controllers"))
                .paths(PathSelectors.any())
                .build()
                // 主要关注点----每个接口调用都填写token
                .globalOperationParameters(globalOperation())   ;

    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("中后台API")
                .termsOfServiceUrl("http://despairyoke.github.io/")
                .version("1.0")
                .description("中后台API")
                .build();
    }

    /**
     * swagger测试在请求头假如token
     * @return
     */
    private List<Parameter> globalOperation(){
        //添加head参数配置start
        ParameterBuilder tokenPar = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<>();
        //第一个token为传参的key，第二个token为swagger页面显示的值
        tokenPar.name("MBUP-APP-ID").description("MBUP-APP-ID").modelRef(new ModelRef("string")).parameterType("header").required(false).build();
        pars.add(tokenPar.build());

        return pars;
    }
}