package br.pucminas.tcc.sica.portal.aplicacao.api;

import org.springframework.web.bind.annotation.*;

@RestController
public class BasicAuthenticationApi {

    @GetMapping(value = "/api/auth")
    public AuthenticationResult authenticate() {
        return new AuthenticationResult("Sucesso!");
    }
}
