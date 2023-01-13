package br.com.toponeweb.projetolojavirtual;

import br.com.toponeweb.projetolojavirtual.controller.AcessoController;
import br.com.toponeweb.projetolojavirtual.model.Acesso;
import br.com.toponeweb.projetolojavirtual.repository.AcessoRepository;
import br.com.toponeweb.projetolojavirtual.services.AcessoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = ProjetoLojaVirtualApplication.class)
class ProjetoLojaVirtualApplicationTests {

//	@Autowired
//	private AcessoService acessoService;
//	@Autowired
//	private AcessoRepository acessoRepository;

	@Autowired
	private AcessoController acessoController;
	@Test
	public void textCadastraAcesso() {

		Acesso acesso = new Acesso();
		acesso.setDescricao("ROLE_ADMIN");
		acessoController.salvarAcesso(acesso);

		System.out.println("Usuario salvo com sucesso" + " / " + acesso.getId() + " / "  + acesso.getDescricao());

	}

}
