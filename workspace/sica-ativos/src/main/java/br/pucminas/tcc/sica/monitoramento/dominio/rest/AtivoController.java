package br.pucminas.tcc.sica.monitoramento.dominio.rest;

import java.io.*;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import br.pucminas.tcc.sica.monitoramento.dominio.entidade.Ativo;
import br.pucminas.tcc.sica.monitoramento.dominio.servico.AtivoService;

@RestController
public class AtivoController {

    @Autowired
    private AtivoService ativoService;

    @GetMapping(value = "/api/ativos", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Ativo> getTodosAtivo() {
        return ativoService.buscarTodos();
    }

    @GetMapping(value = "/api/ativos/{idAtivo}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Ativo getTodosAtivos(@PathVariable("idAtivo") long idAtivo) {
        return ativoService.buscarPeloId(idAtivo)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Ativo não encontrado: " + idAtivo));
    }

    @GetMapping(value = "/api/ativos/{idAtivo}/imagem", produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] getImagemAtivo(@PathVariable("idAtivo") long idAtivo) throws IOException {
        Ativo ativo = ativoService.buscarPeloId(idAtivo)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Ativo não encontrado: " + idAtivo));
        InputStream stream = Thread.currentThread().getContextClassLoader().getResourceAsStream("imagens/" + ativo.getNomeImagem());
        return IOUtils.toByteArray(stream);
    }
}
