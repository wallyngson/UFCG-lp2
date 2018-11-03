package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lab4.Aluno;
import lab4.Grupo;

/**
 * Classe responsavel por testar todos os metodos da Classe Grupo do LAB4;.
 * 
 * @author Wallyngson Guedes, Matricula: 117110835;
 *
 */
class testGrupo {

	Grupo g1;
	Grupo g2;
	Grupo g3;

	@BeforeEach
	void setUp() throws Exception {
		g1 = new Grupo("MED");
		g2 = new Grupo("CC");
		g3 = new Grupo("CC");
	}

	@Test
	@DisplayName("Teste de criacao do grupo passando um parametro invalido.")
	void testGrupo1() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Grupo("");
		});
	}

	@Test
	@DisplayName("Teste do do metodo toString().")
	void testGrupo2() {
		assertEquals("Nome do Grupo: MED", g1.toString());
	}

	@Test
	@DisplayName("Teste do metodo cadastrarAlunoEmGrupo(), alocacao correta.")
	void testCadastraAlunoEmGrupo() {
		assertEquals("ALUNO ALOCADO!", g1.cadastraAlunoEmGrupo(new Aluno("11711", "Wall", "CC")));
	}

	@Test
	@DisplayName("Teste do metodo cadastrarAlunoEmGrupo(), tentando alocar o mesmo aluno duas vezes, aloca apenas na primeira.")
	void testCadastraAlunoEmGrupo1() {
		assertEquals("ALUNO ALOCADO!", g1.cadastraAlunoEmGrupo(new Aluno("11711", "Wall", "CC")));
		assertEquals("ALUNOS JA ESTA NO GRUPO!", g1.cadastraAlunoEmGrupo(new Aluno("11711", "Wall", "CC")));
	}
	
	@Test
	@DisplayName("Teste do metodo imprimirGrupo(), imprimindo todos do grupo corretamente.")
	void testImprimirAluno() {
		g1.cadastraAlunoEmGrupo(new Aluno("1", "Wall", "CC"));
		g1.cadastraAlunoEmGrupo(new Aluno("2", "Rha", "MED"));
		g1.cadastraAlunoEmGrupo(new Aluno("3", "Well", "ENG"));
		
		assertEquals("Alunos do grupo " + g1.getNomeGrupo() + ":\n"
				+ "* 1 - Wall - CC\n"
				+ "* 3 - Well - ENG\n"
				+ "* 2 - Rha - MED", g1.imprimiAlunos());
	}
	
	@Test
	@DisplayName("Teste do metodo imprimirGrupo(), quando nao existe nenhum aluno cadastrado no grupo.")
	void testImprimirAluno1() {
		assertEquals("NAO EXISTE NENHUM ALUNO CADASTRADO EM CC!", g2.imprimiAlunos());
	}

	@Test
	@DisplayName("Teste do metodo equals(), quando os grupos sao iguais.")
	void testEquals() {
		assertEquals(true, g2.equals(g3));
	}
	
	@Test
	@DisplayName("Teste do metodo equals(), quando os grupos sao diferentes.")
	void testeEquals1() {
		assertEquals(false, g1.equals(g2));
	}
	
	
}
