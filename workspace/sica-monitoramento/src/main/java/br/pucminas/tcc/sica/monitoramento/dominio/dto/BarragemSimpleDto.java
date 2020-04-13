package br.pucminas.tcc.sica.monitoramento.dominio.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

public class BarragemSimpleDto {

    @JsonProperty(access = Access.READ_ONLY)
    private int id;
    @JsonProperty(access = Access.READ_ONLY)
    private String nome;
    @JsonProperty(access = Access.READ_ONLY)
    private int nivelEmergencia;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNivelEmergencia() {
        return nivelEmergencia;
    }

    public void setNivelEmergencia(int nivelEmergencia) {
        this.nivelEmergencia = nivelEmergencia;
    }
}
