package com.brunopereira.projetoaiko.config;

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
public class SwaggerConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.brunopereira.projetoaiko")).paths(PathSelectors.any())
				.build()
				.apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		 return new ApiInfo(
		 "API Teste Estágio Backend V2",
		 "Esta API é o teste para a vaga de estagiário em desenvolvimento Backend.",
		 "Versão V2",
		 "https://aiko.digital/",
		 new Contact("Bruno Pereira", "github.com/BrunoPereira-ctrl", "brunopereiradosreis369@gmail.com"),
		 "Permitido uso para avaliação",
		 "https://aiko.digital/",
		 Collections.emptyList()
		);
		}
}