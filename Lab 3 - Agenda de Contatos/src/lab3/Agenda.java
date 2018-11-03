package lab3;

import java.util.Arrays;

/**
 * Classe que representa uma agenda de contatos.
 * 
 * @author Wallyngson Guedes
 *
 */
public class Agenda {

	private Contato[] contatos;
	private Contato contato;

	public Agenda() {
		contatos = new Contato[100];
	}

	/**
	 * Cadastrada um contato na posicao informada por parametro.
	 * 
	 * @param posicao
	 * @param nome
	 * @param sobrenome
	 * @param telefone
	 * @return
	 */
	public String cadastraContato(int posicao, String nome, String sobrenome, String telefone) {
		this.posicaoInvalida(posicao);

		contato = new Contato(nome, sobrenome, telefone);
		contatos[posicao - 1] = contato;
		return "Cadastro realizado com sucesso!";

	}

	/**
	 * Verifica se a posicao eh valida.
	 * 
	 * @param posicao
	 */
	private void posicaoInvalida(int posicao) {
		if (posicao > this.contatos.length || posicao < 1)
			throw new IndexOutOfBoundsException("Cadastro nao realizado!\n"
					+ "A posicao informada excede o limite de posicoes.\n" + "Informe uma posicao entre 1 e 100.");
	}

	/**
	 * Exibe um contato em uma posicao passada por parametro.
	 * 
	 * @param posicao
	 * @return
	 */
	public String exibirContato(int posicao) {
		this.contatoValido(posicao);
		;

		return contatos[posicao - 1].toString();
	}

	/**
	 * Verifica se o contato eh valido.
	 * 
	 * @param posicao
	 */
	private void contatoValido(int posicao) {
		if (this.contatos[posicao - 1] == null)
			throw new NullPointerException("Nao exite nenhum contato nesta posicao!");
		if (posicao > this.contatos.length || posicao < 1)
			throw new IndexOutOfBoundsException("Posicao solicitada eh invalida!");
	}

	/**
	 * Lista todos os contatos cadastrados na agenda.
	 * 
	 * @return
	 */
	public String listarContatos() {
		if (this.listar().trim().isEmpty())
			throw new NullPointerException("Nenhum contato cadastrado!");

		return listar().substring(0, listar().length() - 1);
	}

	/**
	 * Cria uma String com todos os contatos cadastrados e retorna para o metodo que
	 * o chamou.
	 * 
	 * @return
	 */
	private String listar() {
		String lista = "";
		for (int i = 0; i < contatos.length; i++) {
			if (this.contatos[i] != null) {
				lista += Integer.toString(i + 1) + " - " + contatos[i].getNome() + " " + contatos[i].getSobrenome()
						+ "\n";
			}
		}
		return lista;
	}

	/**
	 * Adiciona nivel de amizade a um contato passado por parametro.
	 * 
	 * @param posicao
	 * @param nivelAmizade
	 * @return
	 */
	public String adicionaNivelAmizade(int posicao, int nivelAmizade) {
		this.contatoValido(posicao);

		contatos[posicao - 1].SetNivelAmizade(nivelAmizade);
		return "O nivel de amizade foi adicionado ao contato com sucesso!";

	}

	/**
	 * Lista todos os contatos que tem um estao cadastrados com o mesmo nivel de
	 * amizade.
	 * 
	 * @param nivelAmizadePesquisar
	 * @return
	 */
	public String contatosPorAmizade(int nivelAmizadePesquisar) {
		if (this.listarPorAmizade(nivelAmizadePesquisar).trim().isEmpty())
			return "Nao existem contatos com este nivel de amizade!\n"
					+ "Informe outro nivel de amizade ou cadastre este nivel de amizade em um contato.";

		return this.listarPorAmizade(nivelAmizadePesquisar).substring(0,
				listarPorAmizade(nivelAmizadePesquisar).length() - 1);

	}

	/**
	 * Cria uma String com todos os contatos com nivel de amizade em comum e retorna
	 * essa string.
	 * 
	 * @param amizade
	 * @return
	 */
	public String listarPorAmizade(int amizade) {
		String contatosAmizade = "";
		for (int i = 0; i < contatos.length; i++) {
			if (contatos[i] == null)
				continue;
			if (contatos[i].getNivelAmizade() == amizade)
				contatosAmizade += contatos[i].toString() + "\n";
		}

		return contatosAmizade;
	}

	/**
	 * Lista todos os contatos por nome.
	 * 
	 * @param nome
	 * @return
	 */
	public String contatosPorNome(String nome) {
		if (this.listarPorNome(nome).trim().equals(""))
			return "Nao existe nenhum contato cadastrado com este nome!";

		return this.listarPorNome(nome).substring(0, this.listarPorNome(nome).length() - 1);
	}

	/**
	 * Cria uma String de todos os contatos com o mesmo nome e retorna.
	 * 
	 * @param nome
	 * @return
	 */
	private String listarPorNome(String nome) {
		String contatosPorNome = "";
		for (int i = 0; i < contatos.length; i++) {
			if (contatos[i] == null)
				continue;
			if (contatos[i].getNome().equals(nome))
				contatosPorNome += contatos[i].toString() + "\n";
		}
		return contatosPorNome;
	}

	/**
	 * Verifica quantos contatos possuem o mesmo nivel de amizade.
	 * 
	 * @param nivelAmizade
	 * @return
	 */
	public int qtdNiveisContato(int nivelAmizade) {
		int qtdNiveis = 0;
		for (int i = 0; i < contatos.length; i++) {
			if (this.contatos[i] != null && contatos[i].getNivelAmizade() == nivelAmizade)
				qtdNiveis += 1;
		}
		return qtdNiveis;
	}

	/**
	 * Calcula o media dos niveis de contato. Soma de todos os niveis dividido por
	 * quantos niveis tem cadastrado.
	 * 
	 * @return
	 */
	public double mediaAmizade() {
		double somaNiveis = 0;
		double qtdNiveis = 0;
		for (int i = 0; i < contatos.length; i++) {
			if (contatos[i] != null) {
				somaNiveis += contatos[i].getNivelAmizade();
				if (contatos[i].getNivelAmizade() != 0)
					qtdNiveis += 1;
			}
		}
		
		return this.media(somaNiveis, qtdNiveis);
	}

	/**
	 * Calcula a media e retorna esse valor.
	 * 
	 * @param somaNiveis
	 * @param qtdNiveis
	 * @return
	 */
	private double media(double somaNiveis, double qtdNiveis) {
		if (qtdNiveis == 0)
			throw new ArithmeticException("Nao eh possivel calcular a media do nivel de amizade desta agenda!\n"
					+ "Nao existem Niveis de Amizade cadastrados.");

		double media = (somaNiveis / qtdNiveis);
		return media;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(contatos);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Agenda) {
			Agenda novaAgenda = (Agenda) obj;
			for (int i = 0; i < contatos.length; i++) {
				if (this.contatos[i] != null && !this.contatos[i].equals(novaAgenda.contatos[i])) {
					return false;
				}
			}
		}
		return true;
	}
}