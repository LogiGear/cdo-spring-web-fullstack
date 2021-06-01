package com.logigear.training;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfiguration {

	private static final String API_NAME = "CDO_SPRING API DOCUMENTATION";
	private static final String API_VERSION = "v1.0.0";
	private static final String API_DESCRIPTION = "API Documentation for Employees CRUD";
	private static final String API_TOS = "Terms of service";
	private static final String API_LICENSE_OF = "CDO_SPRING API DOCUMENTATION";
	private static final String API_LICENSE_URL = "CDO_SPRING API DOCUMENTATION";
	private static final Contact API_AUTHOR_CONTACT = new Contact("Bang Ngo", "www.logigear.com",
			"bang.ngo@logigear.com");
	private static final String BASE_API_PACKAGE = "com.logigear.training.controller";

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage(BASE_API_PACKAGE))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(apiInfo())
				.useDefaultResponseMessages(false);
	}

	private ApiInfo apiInfo() {
		return new ApiInfo(API_NAME, API_DESCRIPTION, API_VERSION, API_TOS, API_AUTHOR_CONTACT, API_LICENSE_OF,
				API_LICENSE_URL, Collections.emptyList());
	}

}
