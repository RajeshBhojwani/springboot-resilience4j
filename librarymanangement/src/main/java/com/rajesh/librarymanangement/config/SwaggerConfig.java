package com.rajesh.librarymanangement.config;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket swagConfig(){
       return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("com.rajesh"))
                .build()
               .apiInfo(getApiInfo());
    }

    private ApiInfo getApiInfo() {
        return new ApiInfo("Library management application",
                "Documentation for Library management application",
                "1.0",
                "Terms of service for using Library management application",
                new Contact("Rajesh Bhojwani","https://www.rajeshbhojwani.co.in","rajesh.bhojwani@gmail.com"),
                "",
                "",
                new ArrayList<>()
        );
    }
}


