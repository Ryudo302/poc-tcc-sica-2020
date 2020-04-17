package br.pucminas.tcc.sica.monitoramento.infra;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.*;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestClientConfiguration {

    private static final String URL_BASE_WS_DEFESA_CIVIL_ESTADUAL = "http://www.mocky.io/v2/5e991b473500007100c487e6";
    private static final String URL_BASE_WS_DEFESA_CIVIL_MUNICIPAL = "http://www.mocky.io/v2/5e991b473500007100c487e6";

    @Bean
    public RestTemplate defesaCivilEstadual(RestTemplateBuilder builder, @Value("${sica.integracao.defesaCivil.estadual.baseUri}") String baseUri) {
        return builder.rootUri(URL_BASE_WS_DEFESA_CIVIL_ESTADUAL).build();
    }

    @Bean
    public RestTemplate defesaCivilMunicipal(RestTemplateBuilder builder, @Value("${sica.integracao.defesaCivil.municipal.baseUri}") String baseUri) {
        return builder.rootUri(URL_BASE_WS_DEFESA_CIVIL_MUNICIPAL).build();
    }
}
