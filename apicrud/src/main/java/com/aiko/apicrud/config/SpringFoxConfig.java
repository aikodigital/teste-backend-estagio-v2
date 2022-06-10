package com.aiko.apicrud.config;

/**
 *
 * @author Celso França Neto
 */
import java.util.ArrayList;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.service.VendorExtension;

@Configuration
@EnableWebMvc
public class SpringFoxConfig implements WebMvcConfigurer {
    @Bean
    @ConditionalOnMissingBean(Docket.class)
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.aiko.apicrud"))
                .build();
    }

    ApiInfo apiInfo = new ApiInfo(
            "API CRUD - Aiko Equipments Informations",
            "API CRUD REST de informações sobre os equipamentos em campo",
            "0.0.1",
            "Terms of Service",
            new Contact("Celso França Neto", "https://github.com/CelsoFrancaNeto",
                    ""),
            "Apache License Version 2.0",
            "https://www.apache.org/licesen.html", new ArrayList<VendorExtension>());

}
