package br.com.toponeweb.projetolojavirtual.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Setter
@Getter
@Table(name = "pessoa_fisica")
@PrimaryKeyJoinColumn(name = "id")
public class PessoaFisica extends Pessoa{

    @Column(nullable = false, length = 14 )
    private String cpf;

    @Column(name = "dt_nacimento", length = 10)
    @Temporal(TemporalType.DATE)
    private Date dataNacimento;
}
