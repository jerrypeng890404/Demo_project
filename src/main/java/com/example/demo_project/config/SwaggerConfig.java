//package com.example.demo_project.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
//@Configuration //讓spring載入該類別設定 產生@Bean
//@EnableSwagger2
//public class SwaggerConfig {
//	
//	public static final ApiInfo DEFAULT_API_INFO = new ApiInfoBuilder()
//			.title("RESTful APIs")
//			.build();
//	
//	@Bean
//	public Docket api() {
//		return new Docket(DocumentationType.SWAGGER_2)
//		.apiInfo(DEFAULT_API_INFO) //顯示API基本資訊,可不加
//		.select() //回傳一個ApiSelectorBuilder實測,用來控制哪些介面可以給Swagger展現
//		//設定套件掃描路徑
//		//Swagger曾掃描套件下所有controller定義的API並產生文件
//		//若不想API產生相關文件,可在API上加@ApiIgnore
//		.apis(RequestHandlerSelectors.basePackage("com.example.demo_project.controller"))
//		.paths(PathSelectors.any())
//		.build();
//	}
//	
//}
