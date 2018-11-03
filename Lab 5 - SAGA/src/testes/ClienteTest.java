package testes;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import lab5.Cliente;;

/**
 * Classe de teste unitarios da classe Cliente do LAB5
 * 
 * @author Wallyngson Guedes
 *
 */
class ClienteTest {

	Cliente c1;
	Cliente c2;
	Cliente c3;
	
	@BeforeEach
	void setUp() throws Exception {
		c1 = new Cliente("111", "Wall", "wall@ccc", "CompCult");
		c2 = new Cliente("111", "Wall", "wall@ccc", "CompCult");
		c3 = new Cliente("000", "BK", "bk@ccc", "SPLab");
	}

	@Test
	@DisplayName("Criando clientes passando parametros vazios.")
	void testCliente() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Cliente("1212", "", "rha@gmail.com", "casa");
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			new Cliente("", "", "", "");
		});
	}
	
	@Test
	@DisplayName("Criando clientes passando parametros nulos.")
	void testCliente2() {
		assertThrows(NullPointerException.class, () -> {
			new Cliente(null, null, "rha@gmail.com", "casa");
		});
		
		assertThrows(NullPointerException.class, () -> {
			new Cliente(null, null, null, null);
		});
	}
	
	@Test
	@DisplayName("Editando um cliente ja criado.")
	void testEditarCliente() {
		assertEquals("Cliente editado com sucesso!", c1.editarCliente("Wallyngson", "wallyngosn@ccc", "SPLab"));
	}
	
	@Test
	@DisplayName("Testando editar cliente passando algum parametro vazio.")
	void testEditarCliente1() {
		assertThrows(IllegalArgumentException.class, () -> {
			c1.editarCliente("", "well@ccc", "SPLab");
		});
	}
	
	@Test
	@DisplayName("Tentando editar cliente passando algum parametro nulo.")
	void testEditarCliente2() {
		assertThrows(NullPointerException.class, () -> {
			c1.editarCliente(null, null, "SPLab");
		});
	}

	@Test
	@DisplayName("Equals, quando dois clientes sao iguais.")
	void testEquals() {
		assertEquals(true, c1.equals(c2));
	}
	
	@Test
	@DisplayName("Equals, quando dois clientes sao diferentes.")
	void testEquals1() {
		assertEquals(false, c1.equals(c3));
	}
	
	@Test
	@DisplayName("Testando o toString.")
	void testToString() {
		assertEquals("Wall - CompCult - wall@ccc", c1.toString());
		assertEquals("BK - SPLab - bk@ccc", c3.toString());
	}
}
