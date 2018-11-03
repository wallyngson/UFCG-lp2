package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lab4.Aluno;
/**
 * Classe responsavel por testar todos os metodos da Classe Aluno do LAB4;
 * 
 * @author Wallyngson Guedes, Matricula: 117110835;
 *
 */
class testAluno {

	Aluno a1;
	Aluno a2;
	Aluno a3;
	
	@BeforeEach
	void setUp() throws Exception {
		a1 = new Aluno("2", "Rha", "MED");
		a2 = new Aluno("2", "Rha", "MED");
		a3 = new Aluno("1", "Wall", "CC");
	}
	
	@Test
	@DisplayName("Teste do construtor passando nada por parametro.")
	void testAluno1() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Aluno("", "", "");
		});
	}
	
	@Test
	@DisplayName("Teste do construtor passando apenas o nome por parametro.")
	void testAluno2() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Aluno("", "Wall", "");
		});
	}
	
	@Test
	@DisplayName("Teste do construtor passando apenas o curso por parametro.")
	void testAluno3() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Aluno("", "", "CC");
		});
	}
	
	@Test
	@DisplayName("Teste do construtor passando apenas a matricula por parametro.")
	void testAluno4() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Aluno("100", "", "");
		});
	}
	
	@Test
	@DisplayName("Teste do construtor passando apenas a matricula e o nome por parametro.")
	void testAluno5() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Aluno("00", "Wall", "");
		});
	}

	@Test
	@DisplayName("Teste do construtor passando apenas a matricula e o curso por parametro.")
	void testAluno6() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Aluno("00", "", "CC");
		});
	}
	
	@Test
	@DisplayName("Teste do construtor nao passando a matricula por parametro")
	void testAluno7() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Aluno("", "Wall", "CC");
		});
	}
	
	@Test
	@DisplayName("Teste do construtor passando todos os parametros validos.")
	// ESTE TESTE NAO RETORNA EXCECAO, ELE MONTA O ALUNO;
	void testAluno8() {
		Aluno a = new Aluno("1", "Wall", "CC");
		assertEquals("1 - Wall - CC", a.toString());
	}
	
	@Test
	@DisplayName("Teste do construtor passando a matricula nula.")
	void testAluno9() {
		assertThrows(NullPointerException.class, () -> {
			new Aluno(null, "Teu", "Escola");
		});
	}
	
	@Test
	@DisplayName("Teste do construtor passando o nome nulo.")
	void testAluno10() {
		assertThrows(NullPointerException.class, () -> {
			new Aluno("123", null, "Escola");
		});
	}
	
	@Test
	@DisplayName("Teste do construtor passando o curso nulo.")
	void testAluno11() {
		assertThrows(NullPointerException.class, () -> {
			new Aluno("11", "Teu", null);
		});
	}
	
	@Test
	@DisplayName("Teste do metodo toString()")
	void testToString() {
		assertEquals("2 - Rha - MED", a1.toString());
	}
	
	@Test
	@DisplayName("Teste do metodo equals, quando ambos sao iguais.")
	void testEquals() {
		assertEquals(true, a1.equals(a2));
	}
	
	@Test
	@DisplayName("Teste do metodo equals, quando ambos sao diferentes.")
	void testEquals1() {
		assertEquals(false, a1.equals(a3));
	}
}
