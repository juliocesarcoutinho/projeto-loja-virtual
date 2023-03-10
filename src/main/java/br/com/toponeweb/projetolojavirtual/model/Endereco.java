package br.com.toponeweb.projetolojavirtual.model;

import br.com.toponeweb.projetolojavirtual.enums.TipoEndereco;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Setter
@Getter
@Table(name = "endereco")
@SequenceGenerator(name = "seq_endereco", sequenceName = "seq_endereco", allocationSize = 1, initialValue = 1)
public class Endereco implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_endereco")
    private Long id;

    @Column(nullable = false, length = 120)
    private String ruaLogradouro;

    @Column(nullable = false, length = 9)
    private String cep;

    @Column(nullable = false, length = 50)
    private String numero;
    @Column(length = 50)
    private String complemento;
    @Column(nullable = false, length = 50)
    private String bairro;
    @Column(nullable = false, length = 2)
    private String uf;
    @Column(nullable = false, length = 50)
    private String cidade;

    @ManyToOne(targetEntity = Pessoa.class)
    @JoinColumn(name = "pessoa_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "pessoa_fk"))
    private Pessoa pessoa;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoEndereco tipoEndereco;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Endereco endereco)) return false;

        return id.equals(endereco.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
