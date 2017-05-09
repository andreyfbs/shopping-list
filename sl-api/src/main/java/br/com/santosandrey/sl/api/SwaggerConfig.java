package br.com.santosandrey.sl.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.santosandrey.sl.api.resource.CreateShoppingListResource;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger config
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    private static final String SWAGGER_BASIC_SCAN_PACKAGE = CreateShoppingListResource.class.getPackage().getName();

    /**
     * Config the swagger, <HOST>:<PORT>/swagger-ui.html
     */
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2) //
                .select() //
                .apis(RequestHandlerSelectors.basePackage(SWAGGER_BASIC_SCAN_PACKAGE)) //
                .paths(PathSelectors.any()) //
                .build()//
                .apiInfo(new ApiInfoBuilder().title("Shopping List").description("Api Documentation").build());
    }
}