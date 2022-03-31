package org.example.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


import java.util.function.Predicate;

import static springfox.documentation.builders.PathSelectors.regex;

/**
 * Swagger configuration class.
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {

    @Bean
    public Docket postsApi() {
        return new Docket(DocumentationType.OAS_30).apiInfo(apiInfo()).select().paths(postPaths()).paths(Predicate.not(PathSelectors.regex("/error.*"))).build().forCodeGeneration(true);
    }

    private Predicate<String> postPaths() {
        return regex("/api.*");
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("JavaInUse API")
                .description("JavaInUse API reference for developers").version("1.0").build();
    }

}
