package br.com.toponeweb.projetolojavirtual.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name = "forma_pagamento")
@SequenceGenerator(name = "seq_forma_pagamento", sequenceName = "seq_forma_pagamento", allocationSize = 1, initialValue = 1)
public class FormaPagamento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_forma_pagamento")
    private Long Id;

    private String descricao;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FormaPagamento that)) return false;

        return Id.equals(that.Id);
    }

    @Override
    public int hashCode() {
        return Id.hashCode();
    }
}
