package me.jincrates.kopringmvc.todo.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket

@Configuration
class SwaggerConfig {

    //http://localhost:8080/swagger-ui/
    @Bean
    fun docket(): Docket{
        return Docket(DocumentationType.OAS_30)
            .select()
            //.apis(RequestHandlerSelectors.any())//RequestHandlerSelectors.basePackage("com.nahwasa.iot.controller")
            .apis(RequestHandlerSelectors.basePackage("me.jincrates.kopringmvc.todo"))
            .paths(PathSelectors.any())
            .build()
    }
}