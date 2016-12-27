package com.jiu.config;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	static final Logger logger = LoggerFactory.getLogger(SwaggerConfig.class);
	
	protected String requestHandlerSelectorsBasePackage;
	
	@Value("${request.handler.selectors.base.package:com.jiu.controller}")
	public void setRequestHandlerSelectorsBasePackage(String requestHandlerSelectorsBasePackage) {
    	logger.debug("requestHandlerSelectorsBasePackage: {}", requestHandlerSelectorsBasePackage);
		this.requestHandlerSelectorsBasePackage = requestHandlerSelectorsBasePackage;
	}
	
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
        		.apiInfo(getApiInfo())
        		.select()
				.apis(RequestHandlerSelectors.basePackage(requestHandlerSelectorsBasePackage))
				.paths(PathSelectors.any())
				.build();
    }
    
    protected ApiInfo getApiInfo() {
    	return new ApiInfo("FSL", "FSL Rest Service INT Release " + new Date(), "", "",
    			new Contact("FSL Team", "", "DL-DPYNA-Team2-FSLInterface@ITS.JNJ.com"), "", "");
    }
}