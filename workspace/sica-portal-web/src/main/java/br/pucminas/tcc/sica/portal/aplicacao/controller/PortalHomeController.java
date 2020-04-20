package br.pucminas.tcc.sica.portal.aplicacao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PortalHomeController {

    @RequestMapping(value = "/")
    public String index() {
        return "index";
    }
}
