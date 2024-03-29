package com.jsp.springboot_employee_pejm16.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class ApplicationConfig {
	
	@Bean
 	public Docket getDocket() {
 		Contact contact = new Contact("Ranjit", "http://localhost:8080/Ranjit", "Ranjit123@gmail.com");
 		List<VendorExtension> extensions = new ArrayList<>();
 		ApiInfo apiInfo = new ApiInfo("Employee Management", "EM version 1.0", "Version 1.0", "1 Year free Service", contact, "QSP123", "http://qsp123.com", extensions);
 		
 		return new Docket(DocumentationType.SWAGGER_2).select()
 				.apis(RequestHandlerSelectors.basePackage("com.jsp.springboot_employee_pejm16")).build()
 				.apiInfo(apiInfo).useDefaultResponseMessages(false);
 		
 	}
	
}
