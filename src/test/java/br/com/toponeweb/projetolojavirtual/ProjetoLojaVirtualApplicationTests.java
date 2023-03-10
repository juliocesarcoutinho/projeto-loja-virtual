package br.com.toponeweb.projetolojavirtual;

import br.com.toponeweb.projetolojavirtual.controller.AcessoController;
import br.com.toponeweb.projetolojavirtual.model.Acesso;
import br.com.toponeweb.projetolojavirtual.repository.AcessoRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import junit.framework.TestCase;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.lang.reflect.Type;
import java.util.List;

@SpringBootTest(classes = ProjetoLojaVirtualApplication.class)
class ProjetoLojaVirtualApplicationTests extends TestCase {


//	@Autowired
//	private AcessoService acessoService;
	@Autowired
	private AcessoController acessoController;

	@Autowired
	private AcessoRepository acessoRepository;

	@Autowired
	private WebApplicationContext wac;

	/*Teste Mock para salvar acesso*/
	@Test
	@Ignore
	public void testApiRestCadastroAcesso() throws Exception {
		DefaultMockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(this.wac);
		MockMvc mockMvc = builder.build();

		Acesso acesso = new Acesso();
		acesso.setDescricao("ROLE_COMPRADOR");

		ObjectMapper objectMapper = new ObjectMapper();

		ResultActions retornoApi = mockMvc
						.perform(MockMvcRequestBuilders.post("/salvarAcesso")
								.content(objectMapper.writeValueAsString(acesso))
								.accept(MediaType.APPLICATION_JSON)
								.contentType(MediaType.APPLICATION_JSON));

		System.out.println( "Retorno da Api" + retornoApi.andReturn().getResponse().getContentAsString());
		/*Converter retorno de api para um objeto de acesso*/
		Acesso objetoRetorno = objectMapper
				.readValue(retornoApi.andReturn()
						.getResponse()
						.getContentAsString()
						, Acesso.class);
		assertEquals(acesso.getDescricao(), objetoRetorno.getDescricao());


	}
	/*=====================================================================================================*/
	/*Teste Mock para Deletar acesso*/
	@Test
	public void testApiRestDeleteAcesso() throws Exception {
		DefaultMockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(this.wac);
		MockMvc mockMvc = builder.build();

		Acesso acesso = new Acesso();
		acesso.setDescricao("ROLE_COMPRADOR");
		acesso =acessoRepository.save(acesso);

		ObjectMapper objectMapper = new ObjectMapper();

		ResultActions retornoApi = mockMvc
				.perform(MockMvcRequestBuilders.post("/deleteAcesso")
						.content(objectMapper.writeValueAsString(acesso))
						.accept(MediaType.APPLICATION_JSON)
						.contentType(MediaType.APPLICATION_JSON));

		System.out.println( "Retorno da Api: " + retornoApi.andReturn().getResponse().getContentAsString());
		System.out.println("Status de Retorno: " + retornoApi.andReturn().getResponse().getStatus());
		assertEquals("Acesso Removido", retornoApi.andReturn().getResponse().getContentAsString() );
		assertEquals(200, + retornoApi.andReturn().getResponse().getStatus() );
		/*Converter retorno de api para um objeto de acesso*/
//		Acesso objetoRetorno = objectMapper
//				.readValue(retornoApi.andReturn()
//								.getResponse()
//								.getContentAsString()
//						, Acesso.class);
//		assertEquals(acesso.getDescricao(), objetoRetorno.getDescricao());


	}
	/*=====================================================================================================*/
	/*Teste Mock para deletar acesso por id*/
	@Test
	public void testApiRestDeleteIdAcesso() throws Exception {
		DefaultMockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(this.wac);
		MockMvc mockMvc = builder.build();

		Acesso acesso = new Acesso();
		acesso.setDescricao("ROLE_TESTE_DELETE_ID");
		acesso =acessoRepository.save(acesso);

		ObjectMapper objectMapper = new ObjectMapper();

		ResultActions retornoApi = mockMvc
				.perform(MockMvcRequestBuilders.delete("/deleteAcessoPorId/" + acesso.getId())
						.content(objectMapper.writeValueAsString(acesso))
						.accept(MediaType.APPLICATION_JSON)
						.contentType(MediaType.APPLICATION_JSON));

		System.out.println( "Retorno da Api: " + retornoApi.andReturn().getResponse().getContentAsString());
		System.out.println("Status de Retorno: " + retornoApi.andReturn().getResponse().getStatus());
		assertEquals("Acesso Removido", retornoApi.andReturn().getResponse().getContentAsString() );
		assertEquals(200, + retornoApi.andReturn().getResponse().getStatus() );

	}
	/*=====================================================================================================*/
	/*Teste Mock para deletar acesso por id*/
	@Test
	public void listarAcessoId() throws Exception {
		DefaultMockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(this.wac);
		MockMvc mockMvc = builder.build();

		Acesso acesso = new Acesso();
		acesso.setDescricao("ROLE_LISTAR_ID");
		acesso = acessoRepository.save(acesso);

		ObjectMapper objectMapper = new ObjectMapper();

		ResultActions retornoApi = mockMvc
				.perform(MockMvcRequestBuilders.get("/listaPorId/" + acesso.getId())
						.content(objectMapper.writeValueAsString(acesso))
						.accept(MediaType.APPLICATION_JSON)
						.contentType(MediaType.APPLICATION_JSON));

		assertEquals(200, + retornoApi.andReturn().getResponse().getStatus() );

		Acesso acessoRetorno = objectMapper.readValue(retornoApi.andReturn().getResponse().getContentAsString(), Acesso.class);
		assertEquals(acesso.getDescricao(), acessoRetorno.getDescricao());
		assertEquals(acesso.getId(), acessoRetorno.getId());

	}
	/*=====================================================================================================*/
	/*Teste com Mock para listar acesso por descri????o*/
	@Test
	public void listarAcessoDesc() throws Exception {
		DefaultMockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(this.wac);
		MockMvc mockMvc = builder.build();

		Acesso acesso = new Acesso();
		acesso.setDescricao("ROLE_LISTAR_DESC");
		acesso = acessoRepository.save(acesso);

		ObjectMapper objectMapper = new ObjectMapper();

		ResultActions retornoApi = mockMvc
				.perform(MockMvcRequestBuilders.get("/listaPorDesc/LISTAR_DESC")
						.content(objectMapper.writeValueAsString(acesso))
						.accept(MediaType.APPLICATION_JSON)
						.contentType(MediaType.APPLICATION_JSON));

		assertEquals(200, + retornoApi.andReturn().getResponse().getStatus() );

		List<Acesso> acessoList = objectMapper.readValue(
				retornoApi.andReturn()
						.getResponse()
						.getContentAsString(), new TypeReference<List<Acesso>>() {
					@Override
					public Type getType() {
						return super.getType();
					}
				});

		assertEquals(1, acessoList.size());
		assertEquals(acesso.getDescricao(), acessoList.get(0).getDescricao());
		acessoRepository.deleteById(acesso.getId());
	}

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
//		System.out.println("OS IDS S??o os mesmos" + " / " + acesso1.getId() + " / "  + acesso.getDescricao());

		/*Teste de Query*/
		 acesso = new Acesso();
		acesso.setDescricao("ROLE_ALUNO");

		acesso = acessoController.salvarAcesso(acesso).getBody();

		List<Acesso> acessos = acessoRepository.buscarAcessoDesc("ALUNO".trim().toUpperCase());
		assertEquals(1, acessos.size());
		acessoRepository.deleteById(acesso.getId());


	}

}
