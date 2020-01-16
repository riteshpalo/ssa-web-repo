package com.rpcl.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

	@Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.rpcl.rest"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(metaData());
    }
    private ApiInfo metaData() {
		 ApiInfo apiInfo = new ApiInfo(
				"Spring Boot REST API",
		        "Spring Boot REST API for SSN(Social Security Number) varification",
		        "1.0",
		        "Terms of service",
		        new Contact("SSA", "https://ssa.com/about/", "info@ssa.com"),
		        "Apache License Version 2.0",
		        "https://www.apache.org/licenses/LICENSE-2.0");
		return apiInfo;
    	
    }
}
