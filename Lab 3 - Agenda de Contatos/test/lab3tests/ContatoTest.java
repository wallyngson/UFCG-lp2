package lab3tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lab3.Contato;

/**
 * Classe de testes unitarios da classe Contato do LAB3
 * 
 * @author Wallyngson Guedes
 *
 */
class ContatoTest {

	Contato c;
	Contato c1;
	Contato c2;

	@BeforeEach
	void setUp() throws Exception {
		c = new Contato("Casa", "de Papel", "99999.8888");
		c1 = new Contato("Wall", "Guedes", "98888.8888");
		c2 = new Contato("Wall", "Guedes", "98888.8888");
		
		c1.SetNivelAmizade(1);
	}

	// CRAICAO DO CONTATO
	
	@Test
	@DisplayName("Test de Construcao do Contato.")
	void testContato() {
		assertEquals("Rha Estrela - 988888888", new Contato("Rha", "Estrela", "988888888").toString());
		assertEquals("a l - 98888.8888", new Contato("a", "l", "98888.8888").toString());
	}

	@Test
	@DisplayName("Teste de Contrucao do Contato com o nome nulo.")
	void testContato1() {
		assertThrows(NullPointerException.class, () -> {
			new Contato(null, "Guedes", "98888.8888");
		});
	}

	@Test
	@DisplayName("Teste de Contrucao do Contato com o nome vazio")
	void testCadastrarContato2() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contato(" ", "Guedes", "98888.8888");
		});
	}

	@Test
	@DisplayName("Teste de Contrucao do Contato com o sobrenome nulo")
	void testCadastrarContato3() {
		assertThrows(NullPointerException.class, () -> {
			new Contato("Wall", null, "98888.8888");
		});
	}

	@Test
	@DisplayName("Teste de Contrucao do Contato com o sobrenome vazio")
	void testCadastrarContato4() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contato("Wall", " ", "98888.8888");
		});
	}

	@Test
	@DisplayName("Teste de Contrucao do Contato com o telefone nulo")
	void testCadastrarContato5() {
		assertThrows(NullPointerException.class, () -> {
			new Contato("Wall", "Guedes", null);
		});
	}

	@Test
	@DisplayName("Teste de Contrucao do Contato com o telefone vazio")
	void testCadastrarContato6() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contato("Wall", "Guedes", " ");
		});
	}

	// GETS
	
	@Test
	@DisplayName("")
	void testGetNome() {
		assertEquals("Wall", c1.getNome());
	}

	@Test
	@DisplayName("")
	void testGetSobrenome() {
		assertEquals("Guedes", c1.getSobrenome());
	}

	@Test
	@DisplayName("")
	void testGetTelefone() {
		assertEquals("98888.8888", c1.getTelefone());
	}

	@Test
	@DisplayName("")
	void testToString() {
		assertEquals("Wall Guedes - 98888.8888", c1.toString());
	}

	// EQUALS

	@Test
	@DisplayName("Equals, quando os contatos sao diferentes.")
	void testEquals() {
		assertEquals(false, c1.equals(c));

	}

	@Test
	@DisplayName("Equals, quando os contatos sao iguais.")
	void testEquals1() {
		assertEquals(true, c1.equals(c2));
	}
	
	// BONUS
	
	@Test
	@DisplayName("Adicionando telefone ao contato.")
	void testAdicionaTelefone() {
		assertEquals("Seu telefone foi adicionado com sucesso!\n" + "Adicionado na posicao 0.", c1.adicionaTelefone(021, 83, "98888.8888"));
	}

}