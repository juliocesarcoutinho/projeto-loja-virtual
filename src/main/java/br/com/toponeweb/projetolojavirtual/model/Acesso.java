package br.com.toponeweb.projetolojavirtual.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Table(name = "acesso")
@SequenceGenerator(name = "acesso", sequenceName = "acesso", initialValue = 1, allocationSize = 1)
public class Acesso implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_acesso")
    private Long id;

    @Column(name = "descricao", nullable = false, length = 120)
    private String descricao; /*Acesso*/

    @Override
    public String getAuthority() {
        return this.descricao;
    }
}
