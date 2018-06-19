package com.zeros.backend.infrastructure.config;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Set;

@Configuration
@Profile("dev")
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("admin")
                .select()
                .apis(customRequestHandlers())
                .paths(Predicates.or(PathSelectors.ant("/api/v1/**")))
                .build()
                .apiInfo(metaData());

    }
    private ApiInfo metaData() {
        ApiInfo apiInfo = new ApiInfo("Restaurants Api Documentation",
                "Operations pertaining to manage and Restaurants",
                "1.0",
                "urn:tos",
                ApiInfo.DEFAULT_CONTACT,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList<>());
        return apiInfo;
    }

    private Predicate<RequestHandler> customRequestHandlers() {
        return input -> {
            Set<RequestMethod> methods = input.supportedMethods();
            return (methods.contains(RequestMethod.GET)
                    || methods.contains(RequestMethod.POST)
                    || methods.contains(RequestMethod.PUT)
                    || methods.contains(RequestMethod.PATCH));
        };
    }
}