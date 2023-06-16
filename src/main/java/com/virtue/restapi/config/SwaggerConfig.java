package com.virtue.restapi.config;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import org.springframework.context.annotation.Configuration;

@EnableSwagger2
@Configuration
@ComponentScan("com.virtue.restapi.config")
public class SwaggerConfig {
}
