package br.com.toponeweb.projetolojavirtual;

import br.com.toponeweb.projetolojavirtual.controller.AcessoController;
import br.com.toponeweb.projetolojavirtual.model.Acesso;
import br.com.toponeweb.projetolojavirtual.repository.AcessoRepository;
import br.com.toponeweb.projetolojavirtual.services.AcessoService;
import junit.framework.TestCase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest(classes = ProjetoLojaVirtualApplication.class)
class ProjetoLojaVirtualApplicationTests extends TestCase {

//	@Autowired
//	private AcessoService acessoService;
//	@Autowired
//	private AcessoRepository acessoRepository;

	@Autowired
	private AcessoController acessoController;

	@Autowired
	private AcessoRepository acessoRepository;
	@Test
	public void textCadastraAcesso() {
//
		Acesso acesso = new Acesso();
		acesso.setDescricao("ROLE_ADMIN");

		assertEquals(true, acesso.getId() == null);

		acesso = acessoController.salvarAcesso(acesso).getBody();

		assertEquals(true, acesso.getId() > 0);

		assertEquals("ROLE_ADMIN", acesso.getDescricao());

		Acesso acesso1 = acessoRepository.findById(acesso.getId()).get();
		assertEquals(acesso.getId(), acesso1.getId());

		/*TESTE DE DELETE*/

		acessoRepository.deleteById(acesso1.getId());
		acessoRepository.flush(); /*Roda a SQL no banco*/
		Acesso acesso2 = acessoRepository.findById(acesso1.getId()).orElse(null);

		assertEquals(true, acesso2 ==null);
//
//
//		System.out.println("OS IDS São os mesmos" + " / " + acesso1.getId() + " / "  + acesso.getDescricao());

		/*Teste de Query*/
		 acesso = new Acesso();
		acesso.setDescricao("ROLE_ALUNO");

		acesso = acessoController.salvarAcesso(acesso).getBody();

		List<Acesso> acessos = acessoRepository.buscarAcessoDesc("ALUNO".trim().toUpperCase());
		assertEquals(1, acessos.size());
		acessoRepository.deleteById(acesso.getId());


	}

}
