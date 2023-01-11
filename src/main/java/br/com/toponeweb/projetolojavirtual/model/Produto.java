package br.com.toponeweb.projetolojavirtual.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@Table(name = "produto")
@SequenceGenerator(name = "seq_produto", sequenceName = "seq_produto", allocationSize = 1, initialValue = 1)
public class Produto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_produto")
    private Long id;
    @Column(nullable = false)
    private String tipoUnidade;
    @Column(nullable = false)
    private String nome;
    @Column(columnDefinition = "text", length = 2000)
    private String descricao;

    /* Nota item Produto Associar */
    @Column(nullable = false)
    private Double peso;
    @Column(nullable = false)
    private Double largura;
    @Column(nullable = false)
    private Double altura;
    @Column(nullable = false)
    private Double profundidade;
    @Column(nullable = false)
    private BigDecimal valorVenda = BigDecimal.ZERO;
    @Column(nullable = false)
    private Integer qtdEstoque = 0;
    private Integer qtdAlertaEstoque = 0;

    private String linkYoutube;
    private Boolean alertaQtdEstoque = Boolean.FALSE;

    private Boolean ativo = Boolean.TRUE;
    private Integer alertaQtdClique = 0;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Produto produto)) return false;

        return getId().equals(produto.getId());
    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }
}
