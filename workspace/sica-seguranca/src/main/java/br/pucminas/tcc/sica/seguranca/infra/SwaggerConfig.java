package br.pucminas.tcc.sica.seguranca.infra;

import org.springframework.context.annotation.*;

import springfox.documentation.builders.*;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket greetingApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("br.pucminas.tcc.sica.seguranca.aplicacao.api"))
                .build()
                .apiInfo(metaData());

    }

    private ApiInfo metaData() {
        return new ApiInfoBuilder()
                .title("SICA - Segurança e Comunicação")
                .description("Módulo de segurança e comunicação do SICA")
                .version("1.0.0")
                .license("MIT")
                .licenseUrl("https://gitlab.com/ThiagoColbert/poc-tcc-sica-2020/-/blob/master/LICENSE")
                .build();
    }
}
