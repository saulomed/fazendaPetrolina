package br.lorena.fazenda.model;

import java.util.List;

public class ParametrosConsultaDividas {
    private String idCliente;
    private List<String> inscricoes;

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public List<String> getInscricoes() {
        return inscricoes;
    }

    public void setInscricoes(List<String> inscricoes) {
        this.inscricoes = inscricoes;
    }
}
