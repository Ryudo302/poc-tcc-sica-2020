package br.pucminas.tcc.sica.ativos.aplicacao.api;

import java.io.*;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import br.pucminas.tcc.sica.ativos.dominio.entidade.Ativo;
import br.pucminas.tcc.sica.ativos.dominio.servico.AtivoService;

import io.swagger.annotations.*;

@RestController
@Api(value = "api/ativos")
public class AtivoApi {

    @Autowired
    private AtivoService ativoService;

    @ApiOperation(value = "Obtém os ativos cadastrados")
    @GetMapping(value = "/api/ativos", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Ativo> getAtivos(
            @ApiParam(value = "Permite filtrar pelo tipo de ativo") @RequestParam(name = "tipoAtivo", required = false) Integer idTipoAtivo) {

        return ativoService.buscar(idTipoAtivo);
    }

    @ApiOperation(value = "Obtém um único ativo a partir de seu ID")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Não foi encontrado recurso com o ID informado")
    })
    @GetMapping(value = "/api/ativos/{idAtivo}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Ativo getAtivo(@PathVariable("idAtivo") long idAtivo) {

        return ativoService.buscarPeloId(idAtivo)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Ativo não encontrado: " + idAtivo));
    }

    @ApiOperation(value = "Obtém a imagem de determinado ativo")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Não foi encontrado recurso com o ID informado")
    })
    @GetMapping(value = "/api/ativos/{idAtivo}/imagem", produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] getImagemAtivo(@PathVariable("idAtivo") long idAtivo) throws IOException {

        Ativo ativo = ativoService.buscarPeloId(idAtivo)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Ativo não encontrado: " + idAtivo));
        InputStream stream = Thread.currentThread().getContextClassLoader().getResourceAsStream("imagens/" + ativo.getNomeImagem());
        return IOUtils.toByteArray(stream);
    }
}
