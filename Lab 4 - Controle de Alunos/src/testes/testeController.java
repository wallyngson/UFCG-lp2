package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lab4.Controller;

class testeController {

	Controller sistema = new Controller();

	@BeforeEach
	void setUp() throws Exception {
		sistema.cadastraAluno("2", "BK", "ENG");
		sistema.cadastraAluno("4", "Wall", "CC");
		sistema.cadastraAluno("5", "Rha", "MED");
		sistema.cadastraGrupo("MED");
	}

	@Test
	@DisplayName("Teste do metodo cadastraAluno() quando o cadastro eh um sucesso.")
	void testCadastraAluno() {
		assertEquals("CADASTRO REALIZADO!", sistema.cadastraAluno("1", "Wall", "CC"));
	}

	@Test
	@DisplayName("Teste do metodo cadastraAluno() quando o aluno ja esta cadastrado.")
	void testCadastraAluno1() {
		assertEquals("MATRICULA JA CADASTRADA!", sistema.cadastraAluno("2", "BK", "ENG"));
	}

	@Test
	@DisplayName("Teste do metodo exibeAluno() quando o aluno ja esta cadastrado no sistema.")
	void testExibeAluno() {
		assertEquals("Aluno: 2 - BK - ENG", sistema.exibeAluno("2"));
	}

	@Test
	@DisplayName("Teste do metodo exibeAluno() quando o aluno nao esta cadastrado no sistema.")
	void testExibeAluno1() {
		assertEquals("ALUNO NAO CADASTRADO!", sistema.exibeAluno("3"));
	}

	@Test
	@DisplayName("Teste do metodo cadastraGrupo() quando o cadastro eh um sucesso.")
	void testCadastraGrupo() {
		assertEquals("CADASTRO REALIZADO!", sistema.cadastraGrupo("CC"));
	}

	@Test
	@DisplayName("Teste do metodo cadastraGrupo() quando o grupo ja esta cadastrado.")
	void testCadastraGrupo1() {
		assertEquals("GRUPO JA CADASTRADO!", sistema.cadastraGrupo("MED"));
	}

	@Test
	@DisplayName("Teste do metodo cadastraGrupo() quando o grupo ja esta cadastrado com espacos e letras minusculas.")
	void testCadastraGrupo2() {
		assertEquals("GRUPO JA CADASTRADO!", sistema.cadastraGrupo("   me d  "));
	}

	@Test
	@DisplayName("Teste do metodo alocarAluno() quando o aluno eh alocado no grupo com sucesso.")
	void testAlocarAluno() {
		assertEquals("ALUNO ALOCADO COM SUCESSO!", sistema.alocarAluno("2", "MED"));
	}

	@Test
	@DisplayName("Teste do metodo alocarAluno() quando o aluno nao esta alocado no grupo.")
	void testAlocarAluno1() {
		assertEquals("ALUNO NAO CADASTRADO NO SISTEMA!", sistema.alocarAluno("3", "MED"));
	}

	@Test
	@DisplayName("Teste do metodo adicionarRespostaAoAluno() quando aluno realmente respondeu.")
	void testAdicionarRespostaAoAluno() {
		assertEquals("RESPOSTA REGISTRADA!", sistema.adicionarRepostaAoAluno("2"));
	}

	@Test
	@DisplayName("Teste do metodo adicionarRespostaAoAluno() quando aluno nao esta cadastrado no sistema.")
	void testAdicionarRespostaAoAluno1() {
		assertEquals("ALUNO NAO CADASTRADO NO SISTEMA!", sistema.adicionarRepostaAoAluno("3"));
	}

	@Test
	@DisplayName("Teste do metodo imprimirAlunosQueResponderam() quando nao tem nenhuma resposta registrada.")
	void testImprimirAlunosQueResponderam() {
		assertEquals("NENHUM ALUNO RESPONDEU NENHUMA QUESTAO!", sistema.imprimirAlunosQueResponderam());
	}

	@Test
	@DisplayName("Teste do metodo imprimirAlunosQueResponderam() quando temos 3 alunos cadastrado e 4 respostas.")
	void testImprimirAlunosQueResponderam1() {
		sistema.adicionarRepostaAoAluno("2");
		sistema.adicionarRepostaAoAluno("4");
		sistema.adicionarRepostaAoAluno("5");
		sistema.adicionarRepostaAoAluno("2");

		assertEquals("1. 2 - BK - ENG\n" + "2. 4 - Wall - CC\n" + "3. 5 - Rha - MED\n" + "4. 2 - BK - ENG",
				sistema.imprimirAlunosQueResponderam());
	}
}
