package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lab5.ControllerSaga;

/**
 * Classe de testes unitario da classe ControllerSaga do LAB5.
 * 
 * @author Wallyngson Guedes
 *
 */
class ControllerTest {

	private ControllerSaga controller;
	private ControllerSaga c1;

	@BeforeEach
	void setUp() throws Exception {

		controller = new ControllerSaga();
		c1 = new ControllerSaga();

		controller.cadastrarCliente("123", "Wall", "wall@ccc", "cg");
		controller.cadastrarCliente("122", "Amanda", "amands@ccc", "cg");
		controller.cadastrarCliente("111", "Rhalise", "rha@ccc", "cg");

		controller.cadastrarFornecedor("Josenilda", "nilda@computacao.ufcg.edu.br", "83 98736-5050");
		controller.cadastrarFornecedor("Dona Inês", "dines@gmail.com", "83 9999-5050");
		controller.cadastrarFornecedor("Ron Weasley", "rweasley@splab.ufcg.edu.br", "83 99936-5050");

		controller.adicionarProduto("Josenilda", "Mousse", "Mousse de Limão", "4,00");
		controller.adicionarProduto("Dona Inês", "Tapioca simples", "Tapioca com manteiga", "3,00");
		controller.adicionarProduto("Dona Inês", "Bolo", "Bolo de chocolate", "3,00");
		controller.adicionarProduto("Ron Weasley", "Coxinha", "Coxinha de Frango", "2,00");
		controller.adicionarProduto("Dona Inês", "Tapioca completa", "Tapioca com côco, queijo e manteiga", "3,50");
		controller.adicionarProduto("Josenilda", "Buchada", "Buchada de Bode", "10,00");
	}

	// TESTE CLIENTES OK

	@Test
	@DisplayName("Cadastrar clientes com algum ou todos os seus parametros vazios.")
	void testCadastrarClientes1() {
		// NOME VAZIO
		assertThrows(IllegalArgumentException.class, () -> {
			controller.cadastrarCliente("1111111", "", "wall@ccc.br", "SPLAB");
		});

		// TODOS VAZIOS
		assertThrows(IllegalArgumentException.class, () -> {
			controller.cadastrarCliente("", "", "", "");
		});
	}

	@Test
	@DisplayName("Cadastrando clientes corretamente.")
	void testCadastraCliente2() {
		assertEquals("Cliente cadastrado com sucesso!",
				controller.cadastrarCliente("111222", "Well", "well@ccc.br", "SPLAB"));
	}

	@Test
	@DisplayName("Cadastrando cliente que ja existe.")
	void testCadastraCliente3() {
		assertEquals("Cliente ja esta cadastrado no sistema!",
				controller.cadastrarCliente("123", "Wall", "wall@ccc", "cg"));
	}

	@Test
	@DisplayName("Tentando usar o mesmo cpf para cadastrar cliente com outros parametros.")
	void testCadastraCliente4() {
		assertEquals("Cliente ja esta cadastrado no sistema!",
				controller.cadastrarCliente("123", "Jose", "jose@ccc", "JP"));
	}

	@Test
	@DisplayName("teste do metodo listarClientes() que ordena todos os clientes por nome.")
	// TESTE CORRETO
	void testListarClientes() {
		assertEquals("Amanda - cg - amands@ccc | Rhalise - cg - rha@ccc | Wall - cg - wall@ccc",
				controller.listarClientes());

	}
	
	@Test
	@DisplayName("Tentando listar clientes sem nenhum cadastrado.")
	void testListarClientes2() {
		assertEquals("Nao existe nenhum cliente cadastrado nesse sistema.", c1.listarClientes());
	}

	@Test
	@DisplayName("Pesquisando determinado cliente atraves do seu cpf, usuario ja cadastrado.")
	void testRetornarCliente() {
		assertEquals("Wall - cg - wall@ccc", controller.retornaCliente("123"));
	}

	@Test
	@DisplayName("Pesquisando determinado cliente atraves do seu cpf, usuario nao cadastrado no sistema.")
	void testRetornarCliente2() {
		assertEquals("Este cliente nao esta cadastrado no sistema!", controller.retornaCliente("132"));
	}

	@Test
	@DisplayName("Pesquisando determinado cliente atraves do seu cpf, cpf nulo ou vazio.")
	// RETORNA UMA EXCESSAO
	void testRetornarCliente3() {
		// CPF NULO
		assertThrows(NullPointerException.class, () -> {
			controller.retornaCliente(null);
		});

		// CPF VAZIO
		assertThrows(IllegalArgumentException.class, () -> {
			controller.retornaCliente("");
		});
	}

	@Test
	@DisplayName("Editar o cliente passando por parametro o cpf.")
	void testEditarCliente() {
		assertEquals("Cliente editado com sucesso!",
				controller.editarCliente("123", "Wallyngson", "wallisonesg@gmail.com", "JP"));
	}

	@Test
	@DisplayName("Editar o cliente passando por parametro o cpf, cliente nao cadastrado no sistema.")
	void testEditarCliente1() {
		assertEquals("Cliente nao cadastrado no sistema!",
				controller.editarCliente("132", "Wallyngson", "wallisonesg@gmail.com", "JP"));
	}

	@Test
	@DisplayName("Editar o cliente passando por parametro o cpf nulo ou invalido.")
	// RETORNA UMA EXCESSAO
	void testEditarCliente2() {
		// CPF NULO
		assertThrows(NullPointerException.class, () -> {
			controller.editarCliente(null, "Maria", "maria@gmail.com", "Casa de Maria");
		});

		// CPF VAZIO
		assertThrows(IllegalArgumentException.class, () -> {
			controller.editarCliente("", "Maria", "maria@gmail.com", "Casa de Maria");
		});
	}

	@Test
	@DisplayName("Remover clientes cadastrado passando por parametro seu cpf.")
	void testRemoverCliente() {
		assertEquals("Cliente removido com sucesso!", controller.removerCliente("123"));
	}

	@Test
	@DisplayName("Remover clientes nao cadastrado passando por parametro seu cpf.")
	void testRemoverCliente1() {
		assertEquals("Cliente nao cadastrado no sistema!", controller.removerCliente("132"));
	}

	@Test
	@DisplayName("Remover clientes nao cadastrado passando por parametro seu cpf.")
	void testRemoverCliente2() {
		// CPF NULO
		assertThrows(NullPointerException.class, () -> {
			controller.removerCliente(null);
		});

		// CPF VAZIO
		assertThrows(IllegalArgumentException.class, () -> {
			controller.removerCliente("");
		});
	}

	// TESTE FORNECEDORES

	@Test
	@DisplayName("Cadastrar clientes com algum dos parametros nulos.")
	void testCadastrarClientes() {
		// CPF NULO
		assertThrows(NullPointerException.class, () -> {
			controller.cadastrarCliente(null, "Wall", "wall@ccc.br", "CompCult");
		});

		// TODOS NULOS
		assertThrows(NullPointerException.class, () -> {
			controller.cadastrarCliente(null, null, null, null);
		});

	}

	@Test
	@DisplayName("Cadastrar fornecedores com algum ou todos dos seus parametros nulos.")
	void testCadastrarFornecedor() {
		// NOME NULO
		assertThrows(NullPointerException.class, () -> {
			controller.cadastrarFornecedor(null, "wall@ccc", "(83) 9990.9999");
		});

		// TODOS NULOS
		assertThrows(NullPointerException.class, () -> {
			controller.cadastrarFornecedor(null, null, null);
		});
	}

	@Test
	@DisplayName("Cadastrar fornecedores com algum ou todos os seus parametros vazios.")
	void testCadastrarFornecedor1() {
		// NOME VAZIO
		assertThrows(NullPointerException.class, () -> {
			controller.cadastrarFornecedor(null, "wall", "9999.0000");
		});

		// TODOS VAZIOS
		assertThrows(IllegalArgumentException.class, () -> {
			controller.cadastrarFornecedor("", "", "");
		});
	}

	@Test
	@DisplayName("Cadastrando fornecedor corretamente.")
	void testCadastraFornecedores2() {
		assertEquals("Fornecedor cadastrado com sucesso!",
				controller.cadastrarFornecedor("Vitamassa", "vitamassa@milho", "3333.3333"));
	}

	@Test
	@DisplayName("Cadastrando fornecedor que ja existe.")
	void testCadastraFornecedor3() {
		assertEquals("Fornecedor ja esta cadastrado no sistema!",
				controller.cadastrarFornecedor("Josenilda", "nilda@computacao.ufcg.edu.br", "83 98736-5050"));
	}

	@Test
	@DisplayName("Tentando usar o mesmo nome para cadastrar fornecedores com outros parametros.")
	void testCadastraFornecedor4() {
		assertEquals("Fornecedor ja esta cadastrado no sistema!",
				controller.cadastrarFornecedor("Josenilda", "josefa@gmail.com", "3333.3333"));
	}

	@Test
	@DisplayName("Pesquisando determinado fornecedor atraves do seu nome, usuario ja cadastrado.")
	void testRetornarFornecedor() {
		assertEquals("Josenilda - nilda@computacao.ufcg.edu.br - 83 98736-5050",
				controller.retornaFornecedor("Josenilda"));
	}

	@Test
	@DisplayName("Pesquisando determinado fornecedor atraves do seu nome, fornecedor nao cadastrado no sistema.")
	void testRetornarFornecedor1() {
		assertEquals("Fornecedor nao esta cadastrado no sistema!", controller.retornaFornecedor("Vitamassa"));
	}

	@Test
	@DisplayName("Pesquisando determinado fornecedor atraves do seu nome, nome nulo ou vazio.")
	// RETORNA UMA EXCESSAO
	void testRetornarFornecedor2() {
		// NOME NULO
		assertThrows(NullPointerException.class, () -> {
			controller.retornaFornecedor(null);
		});

		// NOME VAZIO
		assertThrows(IllegalArgumentException.class, () -> {
			controller.retornaFornecedor("");
		});
	}

	@Test
	@DisplayName("teste do metodo listarFornecedores() que ordena todos os fornecedores por nome.")
	// TESTE CORRETO
	void testListarFornecedores() {
		assertEquals(
				"Dona Inês - dines@gmail.com - 83 9999-5050 | Josenilda - nilda@computacao.ufcg.edu.br - 83 98736-5050 | Ron Weasley - rweasley@splab.ufcg.edu.br - 83 99936-5050",
				controller.listarFornecedores());
	}
	
	@Test
	@DisplayName("Tentando listar todos os fornecedores sem ter nenhum cadastrado.")
	void testListarFornecedores1() {
		assertEquals("Nao existe nenhum fornecedor cadastrado no sistema.", c1.listarFornecedores());
	}

	@Test
	@DisplayName("Editar o fornecedor passando por parametro o seu nome.")
	void testEditarFornecedor() {
		assertEquals("Fornecedor editado com sucesso!",
				controller.editarFornecedor("Dona Inês", "donaines@gmail.com", "3332.2222"));
	}

	@Test
	@DisplayName("Editar o fornecedor passando por parametro o nome, fornecedor nao cadastrado no sistema.")
	void testEditarFornecedor1() {
		assertEquals("Fornecedor nao cadastrado no sistema!",
				controller.editarFornecedor("Marata", "marata@gmail.com", "3333.3333"));
	}

	@Test
	@DisplayName("Editar o cliente passando por parametro o cpf nulo ou invalido.")
	// RETORNA UMA EXCESSAO
	void testEditarFornecedor2() {
		// NOME NULO
		assertThrows(NullPointerException.class, () -> {
			controller.editarFornecedor(null, "marata@gmail.com", "3333.3333");
		});

		// NOME VAZIO
		assertThrows(IllegalArgumentException.class, () -> {
			controller.editarFornecedor("", "marata@gmail.com", "3333.3333");
		});
	}

	@Test
	@DisplayName("Remover fornecedor cadastrado passando por parametro seu nome.")
	void testRemoverFornecedor() {
		assertEquals("Fornecedor removido com sucesso!", controller.removerFornecedor("Josenilda"));
	}

	@Test
	@DisplayName("Remover fornecedor nao cadastrado passando por parametro seu nome.")
	void testRemoverFornecedor1() {
		assertEquals("Fornecedor nao cadastrado no sistema!", controller.removerFornecedor("Vitamassa"));
	}

	@Test
	@DisplayName("Remover fornecedor passando por parametro seu nome, nulo ou vazio.")
	// DEVE RETORNAR UMA EXCESSAO
	void testRemoverFornecedor2() {
		// CPF NULO
		assertThrows(NullPointerException.class, () -> {
			controller.removerFornecedor(null);
		});

		// CPF VAZIO
		assertThrows(IllegalArgumentException.class, () -> {
			controller.removerFornecedor("");
		});
	}

	// TESTE PRODUTOS

	@Test
	@DisplayName("Teste de ordenacao dos produtos por fornecedor.")
	// TESTE CORRETO
	void testListarProdutosDeUmFornecedor() {
		assertEquals(
				"Dona Inês - Bolo - Bolo de chocolate - R$3,00 | "
						+ "Dona Inês - Tapioca completa - Tapioca com côco, queijo e manteiga - R$3,50 | "
						+ "Dona Inês - Tapioca simples - Tapioca com manteiga - R$3,00",
				controller.listarProdutosDeUmFornecedor("Dona Inês"));
	}

	@Test
	@DisplayName("Teste de ordenacao dos produtos de todos os fornecedores organizados por ordem alfabetica.")
	// TESTE CORRETO
	void testListarProdutos() {
		assertEquals("Dona Inês - Bolo - Bolo de chocolate - R$3,00 | "
				+ "Dona Inês - Tapioca completa - Tapioca com côco, queijo e manteiga - R$3,50 | "
				+ "Dona Inês - Tapioca simples - Tapioca com manteiga - R$3,00 | "
				+ "Josenilda - Buchada - Buchada de Bode - R$10,00 | "
				+ "Josenilda - Mousse - Mousse de Limão - R$4,00 | "
				+ "Ron Weasley - Coxinha - Coxinha de Frango - R$2,00", controller.listarProdutos());
	}

}
