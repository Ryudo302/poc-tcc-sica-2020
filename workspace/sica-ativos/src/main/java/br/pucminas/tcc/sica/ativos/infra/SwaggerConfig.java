package br.pucminas.tcc.sica.ativos.infra;

import org.springframework.context.annotation.*;
import org.springframework.web.servlet.config.annotation.*;

import springfox.documentation.builders.*;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig extends WebMvcConfigurationSupport {

    @Bean
    public Docket greetingApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("br.pucminas.tcc.sica.ativos.aplicacao.api"))
                .build()
                .apiInfo(metaData());

    }

    private ApiInfo metaData() {
        return new ApiInfoBuilder()
                .title("SICA - Ativos")
                .description("Módulo de gestão de ativos da empresa")
                .version("1.0.0")
                .license("MIT")
                .licenseUrl("https://gitlab.com/ThiagoColbert/poc-tcc-sica-2020/-/blob/master/LICENSE")
                .build();
    }

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}
