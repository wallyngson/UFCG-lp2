package lab3tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lab3.Agenda;

/**
 * CLASSE RESPONSAVEL POR TESTAR TODOS O METODOS DA CLASSE AGENDA;
 * 
 * @author Wallyngson Guedes
 *
 */
class AgendaTest {

	private Agenda agenda = new Agenda();
	private Agenda agenda1 = new Agenda();
	private Agenda agenda2 = new Agenda();
	private Agenda agenda3 = new Agenda();
	private Agenda agenda4 = new Agenda();

	@BeforeEach
	void setUp() throws Exception {
		agenda1.cadastraContato(1, "Wall", "Guedes", "(83) 98888.8888");
		agenda3.cadastraContato(1, "Wall", "Guedes", "(83) 98888.8888");
		agenda2.cadastraContato(1, "Rha", "Estrela", "(83) 98888.8888");
		agenda2.cadastraContato(2, "Bk", "Guedes", "(83) 98888.8888");
		agenda2.cadastraContato(3, "Bielly", "Ferreira", "(83) 98888.8888");
		agenda4.cadastraContato(1, "Wall", "Guedes", "(83) 98888.8888");
		agenda4.cadastraContato(4, "Wall", "Ferreira", "(83) 99999.9999");

		agenda2.adicionaNivelAmizade(1, 1);
		agenda2.adicionaNivelAmizade(2, 1);
		agenda1.adicionaNivelAmizade(1, 2);
		agenda4.adicionaNivelAmizade(1, 2);
		agenda4.adicionaNivelAmizade(4, 5);
	}

	// CADASTRAR CONTATO
	
	@Test
	@DisplayName("Tentando cadastrar um contato numa posicao invalida.")
	void testCadastraContato() {
		assertThrows(IndexOutOfBoundsException.class, () -> {
			agenda1.cadastraContato(1200, "Wall", "Guedes", "8888.8888");
		});
	}

	@Test
	@DisplayName("Teste Cadastrar contato em uma posicao ja existente, cadastro correto.")
	void testCadastraContato1() {
		assertEquals("Cadastro realizado com sucesso!", agenda.cadastraContato(1, "Novo", "Contato", "986846.7515"));
	}

	@Test
	@DisplayName("Cadastrando contato corretamente.")
	void testCadastraContato2() {
		assertEquals("Cadastro realizado com sucesso!", 
				agenda.cadastraContato(1, "Wall", "Guedes", "(83) 98888.8888"));
		
		assertEquals("Cadastro realizado com sucesso!",
				agenda.cadastraContato(100, "Rha", "Estrela", "(83) 98888.8888"));
	}

	// LISTAR CONTATOS
	
	@Test
	@DisplayName("Testando listar contato que nao esta cadastrado.")
	void testListarContatos() {
		assertThrows(NullPointerException.class, () -> {
			agenda.listarContatos();
		});
	}

	@Test
	@DisplayName("Listando contatos cadastrados.")
	void testListarContatos1() {
		assertEquals("1 - Wall Guedes", agenda1.listarContatos());
	}

	@Test
	@DisplayName("Listando mais de um contato.")
	void testListarContatos2() {
		assertEquals("1 - Rha Estrela\n" + "2 - Bk Guedes\n" + "3 - Bielly Ferreira", agenda2.listarContatos());
	}

	// EXIBIR CONTATO

	@Test
	@DisplayName("Tentando exibir contato que nao esta cadastrado.")
	void testExibirContato() {
		assertThrows(NullPointerException.class, () -> {
			agenda1.exibirContato(2);
		});
	}

	@Test
	@DisplayName("Tentando exibir contato passando uma posicao invalida, maior que 100 ou menor que 1.")
	void testExibirContato1() {
		assertThrows(IndexOutOfBoundsException.class, () -> {
			agenda1.exibirContato(200);
		});
	}

	@Test
	@DisplayName("Exibir contato corretamente.")
	void testExibirContato2() {
		assertEquals("Wall Guedes - (83) 98888.8888", agenda1.exibirContato(1));
	}

	// EQUALS

	@Test
	@DisplayName("Equals, quando as agendas sao iguais.")
	void testEquals() {
		assertEquals(true, this.agenda1.equals(this.agenda3));
	}

	// BONUS

	@Test
	@DisplayName("Cadastrando nivel de amizade corretamente.")
	void testAdicionaContato() {
		assertEquals("O nivel de amizade foi adicionado ao contato com sucesso!", agenda1.adicionaNivelAmizade(1, 1));
	}

	@Test
	@DisplayName("Tentando adicionar nivel de amizade a um contato que nao existe.")
	void testAdicionaContato1() {
		assertThrows(NullPointerException.class, () -> {
			agenda1.adicionaNivelAmizade(2, 1);
		});
	}

	@Test
	@DisplayName("Tentando adicionar um nivel de amizade invalido, menor que 1 ou maior que 5.")
	public void testAdicionaContato2() {
		assertThrows(IllegalArgumentException.class, () -> {
			agenda1.adicionaNivelAmizade(1, 0);
		});

		assertThrows(IllegalArgumentException.class, () -> {
			agenda1.adicionaNivelAmizade(1, 6);
		});
	}

	@Test
	@DisplayName("Quando nenhum contato possue esse nivel de amizade.")
	public void testContatosPorAmizade() {
		assertEquals(
				"Nao existem contatos com este nivel de amizade!\n"
						+ "Informe outro nivel de amizade ou cadastre este nivel de amizade em um contato.",
				agenda.contatosPorAmizade(1));
	}

	@Test
	@DisplayName("Listando todos os contatos com o mesmo nivel de amizade.")
	public void testContatosPorAmizade1() {
		assertEquals("Rha Estrela - (83) 98888.8888\n" + "Bk Guedes - (83) 98888.8888", agenda2.contatosPorAmizade(1));
	}

	@Test
	@DisplayName("Listando por nivel de amizade quando so ha um contato.")
	public void testContatosPorAmizade2() {
		assertEquals("Wall Guedes - (83) 98888.8888", agenda1.contatosPorAmizade(2));
	}

	@Test
	@DisplayName("Tentando listar contatos por nome quando nao exite nenhum contato.")
	public void testContatosPorNome() {
		assertEquals("Nao existe nenhum contato cadastrado com este nome!", agenda1.contatosPorNome("Rha"));
	}

	@Test
	@DisplayName("Listando por nome corretamente.")
	public void testContatosPorNome1() {
		assertEquals("Wall Guedes - (83) 98888.8888", agenda1.contatosPorNome("Wall"));
	}

	@Test
	@DisplayName("Quando existe mais de um contato com o mesmo nome.")
	public void testContatosPorNome2() {
		assertEquals("Wall Guedes - (83) 98888.8888\n" + "Wall Ferreira - (83) 99999.9999",
				agenda4.contatosPorNome("Wall"));
	}

	@Test
	@DisplayName("Nao existe nenhum nivel de amizade cadastrado.")
	public void testQtdNiveisContatos() {
		assertEquals(0, agenda1.qtdNiveisContato(4));
	}

	@Test
	@DisplayName("Quando existem dois niveis de contatos cadastrados.")
	public void testQtdNiveisContatos1() {
		assertEquals(2, agenda2.qtdNiveisContato(1));
	}

	@Test
	@DisplayName("Teste quando nao existe nenhum nivel de amizade em nenhum contato, nao se pode fazer divisao por 0.")
	public void testMediaAmizade() {
		assertThrows(ArithmeticException.class, () -> {
			agenda.mediaAmizade();
		});
	}

	@Test
	@DisplayName("Testando a media quando existem niveis de amizade cadastrados.")
	public void testMediaAmizade1() {
		assertEquals(3.5, agenda4.mediaAmizade());
	}

	@Test
	@DisplayName("Testando a media quando existem niveis cadatrados nos contatos")
	public void testMediaAmizade2() {
		assertEquals(1.0, agenda2.mediaAmizade());
	}

}