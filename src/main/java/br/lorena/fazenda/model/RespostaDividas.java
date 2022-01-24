package br.lorena.fazenda.model;

import java.io.Serializable;
import java.util.List;

public class RespostaDividas implements Serializable {


    private static final long serialVersionUID = 3277957216101909060L;
    private List<Divida> dividas;

    public List<Divida> getDividas() {
        return dividas;
    }

    public void setDividas(List<Divida> dividas) {
        this.dividas = dividas;
    }

    public String getInscricaoImovel() {
        return inscricaoImovel;
    }

    public void setInscricaoImovel(String inscricaoImovel) {
        this.inscricaoImovel = inscricaoImovel;
    }

    private String inscricaoImovel;

    @Override
    public String toString() {
        return "RespostaDividas{" +
                "dividas=" + dividas +
                ", inscricaoImovel='" + inscricaoImovel + '\'' +
                '}';
    }
}
