package br.com.toponeweb.projetolojavirtual;

import br.com.toponeweb.projetolojavirtual.controller.AcessoController;
import br.com.toponeweb.projetolojavirtual.model.Acesso;
import br.com.toponeweb.projetolojavirtual.repository.AcessoRepository;
import br.com.toponeweb.projetolojavirtual.services.AcessoService;
import junit.framework.TestCase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = ProjetoLojaVirtualApplication.class)
class ProjetoLojaVirtualApplicationTests extends TestCase {

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

		assertEquals(true, acesso.getId() == null);

		acesso = acessoController.salvarAcesso(acesso).getBody();

		assertEquals(true, acesso.getId() > 0);

		assertEquals("ROLE_ADMIN", acesso.getDescricao());


		System.out.println("Usuario salvo com sucesso" + " / " + acesso.getId() + " / "  + acesso.getDescricao());

	}

}
