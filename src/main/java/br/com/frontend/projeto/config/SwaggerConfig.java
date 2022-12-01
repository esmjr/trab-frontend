package br.com.frontend.projeto.config;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import static springfox.documentation.builders.PathSelectors.regex;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("br.com.frontend.projeto"))
				.paths(regex("/api.*"))
				.build()
				.pathMapping("/")
				.apiInfo(metaInfo());
	}
	
	private ApiInfo metaInfo() {
		ApiInfo apiInfo = new ApiInfo(
				"Sugestões API REST",
				"API REST de cadastro de sugestões para a cantina da Unit",
				"1.0",
				"Terms of service",
				new Contact("Mayara Cunha, cuunhamayara@gmail.com", null, null),
				"Apache License version 2.0", null, new ArrayList<VendorExtension>()
			);
			return apiInfo;
	}
}
