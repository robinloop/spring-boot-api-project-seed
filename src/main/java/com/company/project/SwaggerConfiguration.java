/*
 * <<
 * Davinci
 * ==
 * Copyright (C) 2016 - 2018 EDP
 * ==
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *       http://www.apache.org/licenses/LICENSE-2.0
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 * >>
 */

package com.company.project;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.company.project.core.ProjectConstant;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
    public static final String SWAGGER_SCAN_BASE_PACKAGE = ProjectConstant.CONTROLLER_PACKAGE;
    public static final String VERSION = "1.0.0";

    ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Swagger API").description("This is to show api description").license("Apache 2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html").termsOfServiceUrl("").version(VERSION).build();
    }

    @Bean
    public Docket customImplementation(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage(SWAGGER_SCAN_BASE_PACKAGE))
                .paths(PathSelectors.any())
                .build()
//                .directModelSubstitute(org.joda.time.LocalDate.class, java.sql.Date.class)
//                .directModelSubstitute(org.joda.time.DateTime.class, java.util.Date.class)
                .apiInfo(apiInfo());
    }

}
