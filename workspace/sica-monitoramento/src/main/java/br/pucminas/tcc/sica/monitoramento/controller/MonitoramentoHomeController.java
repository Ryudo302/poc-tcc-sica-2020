package br.pucminas.tcc.sica.monitoramento.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MonitoramentoHomeController {

    @RequestMapping(value = "/")
    public String index() {
        return "index";
    }
}
