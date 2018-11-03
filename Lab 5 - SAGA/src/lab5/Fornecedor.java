package lab5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Classe que representa um fornecedor.
 * 
 * @author Wallyngson Guedes
 *
 */
public class Fornecedor implements Comparable<Fornecedor> {

	private String nome;
	private String email;
	private String telefone;
	private List<Produto> produtos;

	public Fornecedor(String nome, String email, String telefone) {
		this.parametrosInvalidos(email, telefone);

		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.produtos = new ArrayList<>();
	}

	/**
	 * Verifica se o email e o telefone sao invalidos.
	 * 
	 * @param email
	 * @param telefone
	 */
	private void parametrosInvalidos(String email, String telefone) {
		if (email.trim().isEmpty() || email == null)
			throw new IllegalArgumentException("email nao pode ser vazio ou nulo.");
		if(telefone.trim().isEmpty() || telefone == null)
			throw new IllegalArgumentException("telefone nao pode ser vazio ou nulo.");
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	

	/**
	 * Cadastra um produto do fornecedor.
	 * 
	 * @param nomeProduto
	 * @param descricao
	 * @param preco
	 * @return
	 */
	public void adicionaProduto(String nomeProduto, String descricao, Double preco) {
		this.nomeProdutoInvalido(nomeProduto, descricao);
		this.validaProduto(nomeProduto, descricao);
		
		this.produtos.add(new Produto(nomeProduto, descricao, preco));
	}
	
	/**
	 * Verifica se o nome do produto eh invalido.
	 * 
	 * @param nome
	 */
	private void nomeProdutoInvalido(String nome, String descricao) {
		if (nome.trim().isEmpty() || nome == null)
			throw new IllegalArgumentException("nome nao pode ser vazio ou nulo.");
		if (descricao.trim().isEmpty() || descricao == null)
			throw new IllegalArgumentException("descricao nao pode ser vazia ou nula.");
	}
	
	/**
	 * Valida se o produto esta ou nao cadastrado.
	 * 
	 * @param nomeProduto
	 * @param descricao
	 * @return
	 */
	private void validaProduto(String nomeProduto, String descricao) {
		for (Produto produto : produtos) {
			if (produto != null && produto.equals(new Produto(nomeProduto, descricao)))
				throw new IllegalArgumentException("produto ja existe.");
		}
	}
	
	/**
	 * Pesquisa o produto passado por parametro e retorna uma representacao textual
	 * do produto.
	 * 
	 * @param nomeProduto
	 * @param descricao
	 * @return
	 */
	public String exibeProduto(String nomeProduto, String descricao) {
		this.nomeProdutoInvalido(nomeProduto, descricao);
		return this.exibe(nomeProduto, descricao).toString();
	}
	
	/**
	 * Verifica se o produto existe e o retorna.
	 * 
	 * @param nomeProduto
	 * @param descricao
	 * @return
	 */
	private Produto exibe(String nomeProduto, String descricao) {
		for (Produto produto : produtos) {
			if (produto != null && produto.equals(new Produto(nomeProduto, descricao)))
				return produto;
		}
		throw new IllegalArgumentException("produto nao existe.");
	}

	/**
	 * Edita o preco de um produto passado por parametro.
	 * 
	 * @param nomeProduto
	 * @param descricao
	 * @param preco
	 * @return
	 */
	public void editaPreco(String nomeProduto, String descricao, Double preco) {
		this.nomeProdutoInvalido(nomeProduto, descricao);
		if (preco <= 0)
			throw new IllegalArgumentException("preco invalido.");
		
		this.exibe(nomeProduto, descricao).setPreco(preco);
		
	}

	/**
	 * Lista todos os produtos do fornecedor.
	 * 
	 * @return
	 */
	public String listarProdutos() {
		Collections.sort(produtos);
		return listaDosProdutos(produtos);
	}

	/**
	 * Percorre a Colecao e retorna todos os produtos em uma representacao textual;
	 * 
	 * @param produtos
	 * @return
	 */
	private String listaDosProdutos(List<Produto> produtos) {
		if (produtos.size() == 0)
			return "";

		String listaProdutos = "";

		for (int i = 0; i < produtos.size(); i++) {
			listaProdutos += this.getNome() + " - " + produtos.get(i).toString() + " | ";
		}

		return listaProdutos;
	}

	/**
	 * Remove um produto.
	 * @param nome
	 * @param descricao
	 */
	public void removeProduto(String nome, String descricao) {
		this.nomeProdutoInvalido(nome, descricao);
		this.produtos.remove(this.exibe(nome, descricao));
	}
	
	@Override
	public String toString() {
		return this.nome + " - " + this.email + " - " + this.telefone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((telefone == null) ? 0 : telefone.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Fornecedor) {
			Fornecedor novoFornecedor = (Fornecedor) obj;
			return this.getNome().equals(novoFornecedor.getNome());
		}

		return false;
	}

	@Override
	public int compareTo(Fornecedor f2) {
		return this.getNome().compareTo(f2.getNome());
	}

}
