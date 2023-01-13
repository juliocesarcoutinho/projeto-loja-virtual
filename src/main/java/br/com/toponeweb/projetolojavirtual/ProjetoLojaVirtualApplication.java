package br.com.toponeweb.projetolojavirtual;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@ComponentScan(basePackages = {"br.*"}) /*Mapeamento dos pacotes*/
@EnableJpaRepositories(basePackages = {"br.com.toponeweb.projetolojavirtual.repository"}) /*Mapeamento dos pacotes dos Repositorios*/
@EnableTransactionManagement /*Transações que serão feitas pelo projeto*/
public class ProjetoLojaVirtualApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoLojaVirtualApplication.class, args);
	}

}
