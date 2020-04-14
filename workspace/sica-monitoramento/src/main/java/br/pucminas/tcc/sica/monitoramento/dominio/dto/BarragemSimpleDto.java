package br.pucminas.tcc.sica.monitoramento.dominio.dto;

public class BarragemSimpleDto {

    private int id;
    private String nome;
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
