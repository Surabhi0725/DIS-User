package sgsits.cse.dis.user.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

  @Bean
  public Docket productApi() {
    return new Docket(DocumentationType.SWAGGER_2).select()
            .apis(RequestHandlerSelectors.basePackage("sgsits.cse.dis.user"))  //packgs to scan
            .paths(regex("/.*"))                 //rest points
            .build()
            .apiInfo(metaInfo());
  }

  private ApiInfo metaInfo() {

    ApiInfo apiInfo = new ApiInfo("User Service", "A service of Departmetal Information System ",
            "1.0", "Terms of Services Url", "Divyani Garg", "License Information", "License URL"

    );

    return apiInfo;
  }
}