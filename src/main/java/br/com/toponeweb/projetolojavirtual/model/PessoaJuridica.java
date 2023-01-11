package br.com.toponeweb.projetolojavirtual.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "pessoa_juridica")
@PrimaryKeyJoinColumn(name = "id")
public class PessoaJuridica extends Pessoa{

    @Column(nullable = false, length = 18)
    private String cnpj;
    @Column(nullable = false, length = 15)
    private String ie;
    private String inscMunicipal;
    @Column(nullable = false, length = 60)
    private String nomeFantasia;
    @Column(nullable = false, length = 60)
    private String razaoSocial;
    @Column(length = 120)
    private String categoria;

}
