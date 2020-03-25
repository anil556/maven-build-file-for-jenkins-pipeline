package com.EasyRentalsBackup.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.EasyRentalsBackup.controller.CarController;
import com.EasyRentalsBackup.controller.CarDisplay;
import com.EasyRentalsBackup.controller.ConfirmationMailController;
import com.EasyRentalsBackup.controller.ReservationController;
import com.EasyRentalsBackup.controller.UploadImageController;
//import com.EasyRentalsBackup.controller.CarController;
import com.EasyRentalsBackup.controller.UserController;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@PropertySource("classpath:swagger.properties")
@ComponentScan(basePackageClasses={ ReservationController.class ,UserController.class , CarController.class,UploadImageController.class,CarDisplay.class,ConfirmationMailController.class} )
@Configuration
public class SwaggerConfig {
	private static final String SWAGGER_API_VERSION= "1.0";
	private static final String LICENSE_TEXT="License";
	private static final String title="REST API Documentation";
	private static final String description="RESTful API for EasyRentals Application";
	
	private ApiInfo apiInfo(){
	return new ApiInfoBuilder()
			.title(title)
			.description(description)
			.license(LICENSE_TEXT)
			.version(SWAGGER_API_VERSION)
			.build();
	
	}
	@Bean
	public Docket userApi()
	{
		return new Docket(DocumentationType.SWAGGER_2)
					.apiInfo(apiInfo())
					.pathMapping("/")
					.select()
					.paths(PathSelectors.regex("/EasyRentals.*"))
					//.paths(PathSelectors.regex (pathRegex:"/api.*"))
					.build();
	}
	}

