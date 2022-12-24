package br.com.toponeweb.projetolojavirtual.enums;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


public enum TipoEndereco {

    COBRANCA("Cobrança"),
    ENTREGA("Entrega");

    private String descricao;

    private TipoEndereco(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "TipoEndereco{" +
                "descricao='" + descricao + '\'' +
                '}';
    }
}
