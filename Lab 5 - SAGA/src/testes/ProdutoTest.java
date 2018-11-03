package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lab5.Produto;

/**
 * Classe de testes unitarios da classe Produto do LAB5.
 * 
 * @author Wallyngson Guedes
 *
 */
class ProdutoTest {

	Produto p1;
	Produto p2;
	Produto p3;
	
	@BeforeEach
	void setUp() throws Exception {
		p1 = new Produto("Bolo", "Bolo de Chocolate", "3,00");
		p2 = new Produto("Bolo", "Bolo de Chocolate", "3,00");
	}

	@Test
	@DisplayName("Tentando criar produto passando parametro invalido ou nulo")
	void testProduto() {
		assertThrows(NullPointerException.class, () -> {
			new Produto(null, null, null);
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			new Produto("", "", "");
		});
	}
	
	@Test
	@DisplayName("Alterando preco do produto corretamente.")
	void testAlteraPreco() {
		assertEquals("Preco alterado com sucesso!", p1.alteraPreco("5,00"));
	}
	
	@Test
	@DisplayName("Alterando preco do produto passando preco invalido ou nulo.")
	void testAlteraPreco1() {
		assertThrows(NullPointerException.class, () -> {
			p1.alteraPreco(null);
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			p1.alteraPreco("");
		});
	}
	
	@Test
	@DisplayName("Testando metodo toString.")
	void testToString() {
		assertEquals("Bolo - Bolo de Chocolate - R$3,00", p1.toString());
	}
	
	@Test
	@DisplayName("Equals, quando produtos sao iguais.")
	void testEquals() {
		assertEquals(true, p1.equals(p2));
	}
	
	@Test
	@DisplayName("Equals, quando produtos sao diferentes.")
	void testEquals1() {
		assertEquals(false, p1.equals(p3));
	}

}
