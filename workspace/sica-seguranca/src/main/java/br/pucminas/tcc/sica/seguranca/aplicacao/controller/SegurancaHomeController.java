package br.pucminas.tcc.sica.seguranca.aplicacao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SegurancaHomeController {

    @RequestMapping(value = "/")
    public String index() {
        return "index";
    }
}
