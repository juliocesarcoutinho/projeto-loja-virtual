package br.com.toponeweb.projetolojavirtual.model;

import br.com.toponeweb.projetolojavirtual.enums.StatusContaPagar;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Entity
@Getter
@Setter
@Table(name = "conta_pagar")
@SequenceGenerator(name = "seq_conta_pagar", sequenceName = "seq_conta_pagar", allocationSize = 1, initialValue = 1)
public class ContaPagar implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_conta_pagar")
    private Long id;

    private String descricao;
    private BigDecimal valorTotal;

    private BigDecimal valorDesconto;
    @Temporal(TemporalType.DATE)
    private Date dtVencimento;
    @Temporal(TemporalType.DATE)
    private Date dtPagamento;
    @Enumerated(value = EnumType.STRING)
    private StatusContaPagar status;

    @ManyToOne(targetEntity = Pessoa.class)
    @JoinColumn(name = "pessoa_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "pessoa_fk"))
    private Pessoa pessoa;

    @ManyToOne(targetEntity = Pessoa.class)
    @JoinColumn(name = "pessoa_forn_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "pessoa_forn_fk"))
    private Pessoa pessoa_fornecedor;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ContaPagar that)) return false;

        if (!id.equals(that.id)) return false;
        if (!Objects.equals(descricao, that.descricao)) return false;
        if (!Objects.equals(valorTotal, that.valorTotal)) return false;
        if (!Objects.equals(valorDesconto, that.valorDesconto))
            return false;
        if (!Objects.equals(dtVencimento, that.dtVencimento)) return false;
        if (!Objects.equals(dtPagamento, that.dtPagamento)) return false;
        if (status != that.status) return false;
        if (!Objects.equals(pessoa, that.pessoa)) return false;
        return Objects.equals(pessoa_fornecedor, that.pessoa_fornecedor);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
