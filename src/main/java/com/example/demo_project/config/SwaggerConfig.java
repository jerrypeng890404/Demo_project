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
//@Configuration //��spring���J�����O�]�w ����@Bean
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
//		.apiInfo(DEFAULT_API_INFO) //���API�򥻸�T,�i���[
//		.select() //�^�Ǥ@��ApiSelectorBuilder���,�Ψӱ�����Ǥ����i�H��Swagger�i�{
//		//�]�w�M�󱽴y���|
//		//Swagger�����y�M��U�Ҧ�controller�w�q��API�ò��ͤ��
//		//�Y���QAPI���ͬ������,�i�bAPI�W�[@ApiIgnore
//		.apis(RequestHandlerSelectors.basePackage("com.example.demo_project.controller"))
//		.paths(PathSelectors.any())
//		.build();
//	}
//	
//}
