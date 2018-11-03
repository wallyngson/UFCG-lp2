package lab3;

/**
 * Classe que representa um contato de uma agenda.
 * 
 * @author Wallyngson Guedes
 *
 */
public class Contato {
	private String[] telefones = new String[3];

	private String nome;
	private String sobrenome;
	private String telefone;
	private String numeroTelefone;
	private int ddd;
	private int codigoPais;
	private int nivelAmizade = 0;

	public Contato(String nome, String sobrenome, String telefone) {
		this.parametroInvalido(nome, sobrenome, telefone);
		
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.telefone = telefone;
	}

	/**
	 * Verifica se os parametros informados sao invalidos ou nulos.
	 * 
	 * @param nome
	 * @param sobrenome
	 * @param telefone
	 */
	private void parametroInvalido(String nome, String sobrenome, String telefone) {
		if (nome.trim().isEmpty() || nome == null)
			throw new IllegalArgumentException(
					"Cadastro nao realizado!\n" + "O Nome informado foi invalido ou nulo, por favor digite um nome valido.");
		if (sobrenome.trim().isEmpty() || sobrenome == null)
			throw new IllegalArgumentException(
					"Cadastro nao realizado!\n" + "O Sobrenome informado foi invalido ou nulo, por favor digite um sobrenome.");
		if (telefone.trim().isEmpty() || telefone == null)
			throw new IllegalArgumentException(
					"Cadastro nao realizado!\n" + "O Telefone informado foi invalido ou nulo, por favor digite um telefone.");
	}
	
	public String getNome() {
		return this.nome;
	}

	public String getSobrenome() {
		return this.sobrenome;
	}

	public String getTelefone() {
		return this.telefone;

	}

	public int getNivelAmizade() {
		return this.nivelAmizade;
	}

	/**
	 * Deixa a frase sem espacos e tudo minusculo.
	 * @param nome
	 * @param sobrenome
	 * @return
	 */
	private String formataFrase(String nome, String sobrenome) {
		return (nome + sobrenome).replace(" ", "").toLowerCase();
	}

	/**
	 * Adiciona telefone com Codigo do Pais e DDD em uma posicao vazia.
	 * 
	 * @param codigoPais
	 * @param ddd
	 * @param numeroTelefone
	 * @return
	 */
	public String adicionaTelefone(int codigoPais, int ddd, String numeroTelefone) {
		for (int i = 0; i < telefones.length; i++) {
			if (telefones[i] == null) {
				telefones[i] = formataTelefone(codigoPais, ddd, numeroTelefone);
				String posicao = Integer.toString(i);
				return "Seu telefone foi adicionado com sucesso!\n" + "Adicionado na posicao " + posicao + ".";
			}
		}
		return "Telefone nao pode ser adicionado, todas as posicoes estao lotadas!";
	}

	/**
	 * Formata o numero de telefone no formato:
	 * EX: 021 83 98888.8888;
	 * 
	 * @param codigoPais
	 * @param ddd
	 * @param numeroTelefone
	 * @return
	 */
	private String formataTelefone(int codigoPais, int ddd, String numeroTelefone) {
		this.codigoPais = codigoPais;
		this.ddd = ddd;
		this.numeroTelefone = numeroTelefone;
		return this.codigoPais + " " + this.ddd + " " + this.numeroTelefone;
	}

	/**
	 * Retorna o nivel de amizade do contato.
	 * 
	 * @param nivelAmizade
	 */
	public void SetNivelAmizade(int nivelAmizade) {
		if (nivelAmizade < 1 || nivelAmizade > 5) {
			throw new IllegalArgumentException(
					"Nivel de amizade nao adicionado!\n" + "Existem apenas 5 niveis de amizades, escolhar um deles.");
		}

		this.nivelAmizade = nivelAmizade;
	}
	
	@Override
	public String toString() {
		return nome + " " + sobrenome + " - " + telefone;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((sobrenome == null) ? 0 : sobrenome.hashCode());
		result = prime * result + ((telefone == null) ? 0 : telefone.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Contato) {
			Contato novo = (Contato) obj;
			return this.formataFrase(this.nome, this.sobrenome).equals(novo.formataFrase(getNome(), getSobrenome()));
		}
		return false;
	}
	
}