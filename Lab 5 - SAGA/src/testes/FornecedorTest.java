package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lab5.Fornecedor;

/**
 * Classe de testes unitarios da classe Fornecedor do LAB5.
 * 
 * @author Wallyngson Guedes
 *
 */
class FornecedorTest {

	Fornecedor f1;
	Fornecedor f2;
	Fornecedor f3;

	@BeforeEach
	void setUp() throws Exception {
		f1 = new Fornecedor("Dona Inês", "dines@gmail.com", "83 9999-5050");
		f2 = new Fornecedor("Budega", "budega@lanchonete", "83 9999-0000");
		f3 = new Fornecedor("Dona Inês", "dines@gmail.com", "83 9999-5050");
		
		f1.cadastrarProduto("Mousse", "Maracuja", "3,00");
		f1.cadastrarProduto("Mousse", "Limao", "3,00");
		f1.cadastrarProduto("Bolo", "Bolo de Chocolate", "3,00");
	}

	@Test
	@DisplayName("Criando fornecedor com parametros vazios.")
	void testFornecedor() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Fornecedor("Lanches SA", "", "");
		});

		assertThrows(IllegalArgumentException.class, () -> {
			new Fornecedor("", "", "96822.5555");
		});
	}

	@Test
	@DisplayName("Criando fornecedor com parametros nulos.")
	void testFornecedor1() {
		assertThrows(NullPointerException.class, () -> {
			new Fornecedor("Lanches SA", null, null);
		});

		assertThrows(NullPointerException.class, () -> {
			new Fornecedor(null, "contato@lanches", "96822.5555");
		});
	}

	@Test
	@DisplayName("Editando fornecedor corretamente.")
	void testEditarFornecedor() {
		assertEquals("Fornecedor editado com sucesso!", f1.editarFornecedor("donaines@lanches.com", "83 9999-9999"));
	}

	@Test
	@DisplayName("Editando fornecedor passando parametro nulo.")
	void testEditarFornecedor1() {
		assertThrows(NullPointerException.class, () -> {
			f1.editarFornecedor(null, "83 99999-9922");
		});
		
		assertThrows(NullPointerException.class, () -> {
			f1.editarFornecedor(null, null);
		});
	}
	
	@Test
	@DisplayName("Editando fornecedor passando parametro invalido.")
	void testEditarFornecedor2() {
		assertThrows(IllegalArgumentException.class, () -> {
			f1.editarFornecedor("", "83 99999-9922");
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			f1.editarFornecedor("", "");
		});
	}

	@Test
	@DisplayName("Cadastrando produto corretamente.")
	void testCadastrarProduto() {
		assertEquals("Produto cadastrado com sucesso!", f1.cadastrarProduto("Bolo", "Mandioca", "3,00"));
	
	}
	
	@Test
	@DisplayName("Tentando cadastrar produto ja cadastrado.")
	void testCadastrarProduto1() {
		assertEquals("Produto ja cadastrado!", f1.cadastrarProduto("Mousse", "Maracuja", "3,00"));
	
	}
	
	@Test
	@DisplayName("Cadastrando produtos com parametros invalidos ou nulos")
	void testCadastrarProduto2() {
		assertThrows(NullPointerException.class, () -> {
			f1.cadastrarProduto(null, null, null);
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			f1.cadastrarProduto("", "", "");
		});
	}
	
	@Test
	@DisplayName("Retornando um produto ja cadastrado")
	void testRetornaProduto() {
		assertEquals("Mousse - Maracuja - R$3,00", f1.retornaProduto("Mousse", "Maracuja"));
	}
	
	@Test
	@DisplayName("Teste quando tentamos retornar um produto nao cadastrado")
	void testRetornaProduto2() {
		assertEquals("Produto nao cadastrado!", f1.retornaProduto("Bolo", "Bolo de Mandioca"));
	}
	
	@Test
	@DisplayName("Tentando retornar produto passando parametro nulo ou invalido")
	void testRetornaProduto3() {
		assertThrows(NullPointerException.class, () -> {
			f1.retornaProduto(null, null);
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			f1.retornaProduto("", "");
		});
	}
	
	@Test
	@DisplayName("Editando preco corretamente")
	void testEditarPreco() {
		assertEquals("Preco alterado com sucesso!", f1.editarPreco("Mousse", "Maracuja", "4,00"));
	}
	
	@Test
	@DisplayName("Tentando editar preco de um produto que nao existe.")
	void testEditarPreco1() {
		assertEquals("Produto nao cadastrado!", f1.editarPreco("Bolo", "Mandioca", "3,50"));
	}
	
	@Test
	@DisplayName("Tentando editar preco passando parametros invalidos ou nulos.")
	void testEditarPreco2() {
		assertThrows(NullPointerException.class, () -> {
			f1.editarPreco("Mousse", "Maracuja", null);
		});
		
		assertThrows(NullPointerException.class, () -> {
			f1.editarPreco(null, "Maracuja", "4,00");
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			f1.editarPreco("", "Maracuja", "4,00");
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			f1.editarPreco("Mousse", "Maracuja", "");
		});
	}
	
	@Test
	@DisplayName("Listando todos os produtos cadastrados.")
	void testListarProdutos() {
		assertEquals("Dona Inês - Bolo - Bolo de Chocolate - R$3,00 | "
				+ "Dona Inês - Mousse - Limao - R$3,00 | "
				+ "Dona Inês - Mousse - Maracuja - R$3,00 | ", f1.listarProdutos());
	}
	
	@Test
	@DisplayName("Tentando listar produtos quando nao tem nenhum listado")
	void testListarProduto1() {
		assertEquals("", f2.listarProdutos());
	}
	
	@Test
	@DisplayName("Teste toString")
	void testToString() {
		assertEquals("Dona Inês - dines@gmail.com - 83 9999-5050", f1.toString());
	}
	
	@Test
	@DisplayName("Equals, quando ambos sao iguais.")
	void testEquals() {
		assertEquals(true, f1.equals(f3));
	}
	
	@Test
	@DisplayName("Equals, quando ambos sao diferentes.")
	void testEquals1() {
		assertEquals(false, f1.equals(f2));
	}
}
