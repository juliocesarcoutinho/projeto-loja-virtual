package br.com.toponeweb.projetolojavirtual.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Entity
@Getter
@Setter
@ToString
@Table(name = "avaliacao_produto")
@SequenceGenerator(name = "seq_avaliacao_produto", sequenceName = "seq_avaliacao_produto", allocationSize = 1, initialValue = 1)
public class AvaliacaoProduto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_avaliacao_produto")
    private Long id;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private Integer nota;

    @ManyToOne(targetEntity = Pessoa.class)
    @JoinColumn(name ="pessoa_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "pessoa_fk"))
    private Pessoa pessoa;

    @ManyToOne
    @JoinColumn(name ="produto_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "produto_fk"))
    private Produto produto;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AvaliacaoProduto that)) return false;

        return getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }
}
