package lab5;

/**
 * Classe representa produtos que serao vendidos por nossa lanchonete.
 * 
 * @author Wallyngson Guedes
 *
 */
public class Produto implements Comparable<Produto> {

	private String nome;
	private String descricao;
	private Double preco;

	public Produto(String nome, String descricao, Double preco) {
		this.parametroInvalido(descricao, preco);

		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
	}
	
	/**
	 * Verifica se os parametros sao vazios ou nulos.
	 * 
	 * @param nome
	 * @param descricao
	 * @param preco
	 */
	private void parametroInvalido(String descricao, Double preco) {
		if (descricao.trim().isEmpty() || descricao == null)
			throw new IllegalArgumentException("descricao nao pode ser vazia ou nula.");
		if (preco <= 0)
			throw new IllegalArgumentException("preco invalido.");
	}
	
	public Produto(String nome, String descricao) {
		this.nome = nome;
		this.descricao = descricao;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
	public String getNome() {
		return this.nome;
	}

	public String getDesricao() {
		return this.descricao;
	}

	/**
	 * Junta os nomes para ordenar os produtos por ordem alfabetica.
	 * 
	 * @return
	 */
	private String nomeCompleto() {
		return this.nome + " " + this.descricao;
	}

	/**
	 * Altera o preco do produto.
	 * 
	 * @param preco
	 * @return
	 */
	public String alteraPreco(Double preco) {
		this.validaPreco(preco);

		this.preco = preco;
		return "Preco alterado com sucesso!";
	}

	
	@Override
	public String toString() {
		return this.nome + " - " + this.descricao + " - R$" + String.valueOf(this.preco).replace(".", ",") + "0";
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Produto) {
			Produto novoProduto = (Produto) obj;
			return this.formataFrase(this.nomeCompleto()).equals(formataFrase(novoProduto.nomeCompleto()));
		}
		return false;
	}

	/**
	 * Tira todos os espacos e deixa toda a frase com letras minusculas.
	 * 
	 * @param frase
	 * @return
	 */
	private String formataFrase(String frase) {
		return frase.toLowerCase().replace(" ", "");
	}

	/**
	 * Verifica se o preco menor ou igual a zero.
	 * 
	 * @param preco
	 */
	private void validaPreco(double preco) {
		if (preco <= 0)
			throw new IllegalArgumentException();
	}

	@Override
	public int compareTo(Produto p2) {
		return this.nomeCompleto().compareTo(p2.nomeCompleto());
	}

}
