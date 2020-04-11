package br.pucminas.tcc.sica.ativos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AtivosHomeController {

    @RequestMapping(value = "/")
    public String index() {
        return "index";
    }
}
