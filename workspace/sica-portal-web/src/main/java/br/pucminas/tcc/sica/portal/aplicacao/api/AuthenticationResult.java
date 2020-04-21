package br.pucminas.tcc.sica.portal.aplicacao.api;

public class AuthenticationResult {

    private final String message;

    public AuthenticationResult(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
