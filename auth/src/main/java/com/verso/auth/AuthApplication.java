package com.verso.auth;

import com.fasterxml.jackson.databind.Module;
import org.openapitools.jackson.nullable.JsonNullableModule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@Configuration
//@EnableSwagger2
public class AuthApplication {

    public static void main(String[] args) {

        SpringApplication.run(AuthApplication.class, args);
    }
//    ApiInfo apiInfo() {
//        return new ApiInfoBuilder()
//                .title("Authorization API")
//                .description("Authorizations service for CGE")
//                .license(Strings.EMPTY)
//                .licenseUrl("http://unlicense.org")
//                .termsOfServiceUrl(Strings.EMPTY)
//                .version("1.0.0")
//                .contact(new Contact(Strings.EMPTY,Strings.EMPTY, Strings.EMPTY))
//                .build();
//    }
//    @Bean
//    public Docket authApiDocumentation(){
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.verso.auth"))
//                .build()
//                .apiInfo(apiInfo());
//    }

    @Bean
    public WebMvcConfigurer webConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("*").allowedMethods("*").allowedHeaders("*");
            }
        };
    }
    @Bean
    public Module jsonNullableModule() {
        return new JsonNullableModule();
    }

}
