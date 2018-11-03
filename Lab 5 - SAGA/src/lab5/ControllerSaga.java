package lab5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Classe Controller do Sistema SAGA. Sistema para Auto-Gestao de comercio de
 * Alimentos;
 * 
 * @author Wallyngson Guedes
 *
 */
public class ControllerSaga {

	private Map<String, Cliente> clientes;
	private Map<String, Fornecedor> fornecedores;

	public ControllerSaga() {
		this.clientes = new HashMap<>();
		this.fornecedores = new HashMap<>();
	}

	// CLIENTES

	/**
	 * Metodo responsavel por adicionar Clientes.
	 * 
	 * @param cpf
	 * @param nome
	 * @param email
	 * @param localizacao
	 * 
	 * @return
	 */
	public String adicionaCliente(String cpf, String nome, String email, String localizacao) {
		try {
			this.cpfInvalido(cpf);
			this.validaCliente(cpf);

			this.clientes.put(cpf, new Cliente(cpf, nome, email, localizacao));
			return cpf;

		} catch (IllegalArgumentException iae) {
			throw new IllegalArgumentException("Erro no cadastro do cliente: " + iae.getMessage());
		}

	}

	/**
	 * Verifica se o CPF eh valido.
	 * 
	 * @param cpf
	 */
	private void cpfInvalido(String cpf) {
		if (cpf.replace(" ", "").length() != 11)
			throw new IllegalArgumentException("cpf invalido.");
	}

	/**
	 * Verifica se o cliente existe.
	 * 
	 * @param cpf
	 */
	private void validaCliente(String cpf) {
		if (this.clientes.containsKey(cpf))
			throw new IllegalArgumentException("cliente ja existe.");
	}

	/**
	 * Exibe cliente atraves do seu cpf.
	 * 
	 * @param cpf
	 * @return
	 */
	public String exibeCliente(String cpf) {
		try {
			this.cpfInvalido(cpf);
			this.clienteInexistente(cpf);

			return this.clientes.get(cpf).toString();

		} catch (IllegalArgumentException iae) {
			throw new IllegalArgumentException("Erro na exibicao do cliente: " + iae.getMessage());
		}

	}

	/**
	 * Verifica se o cliente nao existe.
	 * 
	 * @param cpf
	 */
	private void clienteInexistente(String cpf) {
		if (this.clientes.containsKey(cpf) == false)
			throw new IllegalArgumentException("cliente nao existe.");
	}

	/**
	 * Edita o valor do cliente atraves do seu CPF e o atributo a ser mudado.
	 * 
	 * @param cpf
	 * @param nome
	 * @param email
	 * @param localizacao
	 * @return
	 */
	public void editaCliente(String cpf, String atributo, String novoValor) {
		try {
			this.cpfInvalido(cpf);
			this.clienteInexistente(cpf);

			this.editar(cpf, atributo, novoValor);

		} catch (IllegalArgumentException iae) {
			throw new IllegalArgumentException("Erro na edicao do cliente: " + iae.getMessage());
		}
	}

	/**
	 * Edita o cliente passado por parametro.
	 * 
	 * @param cpf
	 * @param atributo
	 * @param novoValor
	 */
	private void editar(String cpf, String atributo, String novoValor) {
		this.valoresInvalidos(atributo, novoValor);

		if (atributo.equals("nome"))
			this.clientes.get(cpf).setNome(novoValor);
		if (atributo.equals("email"))
			this.clientes.get(cpf).setEmail(novoValor);
		if (atributo.equals("localizacao"))
			this.clientes.get(cpf).setLocalizacao(novoValor);
	}

	/**
	 * Verifica se os atributos e os novos valores sao validos.
	 * 
	 * @param atributo
	 * @param novoValor
	 */
	private void valoresInvalidos(String atributo, String novoValor) {
		if (atributo.isEmpty() || atributo == null)
			throw new IllegalArgumentException("atributo nao pode ser vazio ou nulo.");
		if (novoValor.isEmpty() || novoValor == null)
			throw new IllegalArgumentException("novo valor nao pode ser vazio ou nulo.");
		if (!atributo.equals("nome") && !atributo.equals("email") && !atributo.equals("localizacao"))
			throw new IllegalArgumentException("atributo nao existe.");

	}

	/**
	 * Metodo responsavel por remover um cliente do sistema.
	 * 
	 * @param cpf
	 * @return se o cliente foi ou nao removido;
	 */
	public void removeCliente(String cpf) {
		try {
			this.cpfInvalido(cpf);
			this.clienteInexistente(cpf);

			this.clientes.remove(cpf);

		} catch (IllegalArgumentException iae) {
			throw new IllegalArgumentException("Erro ao remover cliente: " + iae.getMessage());
		}
	}

	/**
	 * Lista todos os clientes cadastrados no sistema.
	 * 
	 * @return
	 */
	public String exibeClientes() {
		try {
			if (this.clientes.size() == 0)
				throw new IllegalArgumentException("nenhum cliente cadastrado.");

			List<Cliente> listaClientes = new ArrayList<Cliente>(clientes.values());
			Collections.sort(listaClientes);

			return this.listaDosClientes(listaClientes);

		} catch (IllegalArgumentException iae) {
			throw new IllegalArgumentException("Erro na exibicao dos clientes: " + iae.getMessage());
		}
	}

	/**
	 * Cria uma String com todos os clientes e a retorna.
	 * 
	 * @param listaClientes
	 * @return
	 */
	private String listaDosClientes(List<Cliente> listaClientes) {
		String clientes = "";

		for (int i = 0; i < listaClientes.size(); i++) {
			clientes += listaClientes.get(i).toString() + " | ";
		}

		return clientes.substring(0, clientes.length() - 3);
	}

	// FORNECEDOR

	/**
	 * Metodo responsavel por adicionar um fornecedor no sistema.
	 * 
	 * @param nome
	 * @param email
	 * @param telefone
	 * @return se o fornecedor ou nao criado;
	 */
	public String adicionaFornecedor(String nome, String email, String telefone) {
		try {
			this.nomeInvalido(nome);
			this.validaFornecedor(nome);

			this.fornecedores.put(nome, new Fornecedor(nome, email, telefone));
			return nome;
			
		} catch (IllegalArgumentException iae) {
			throw new IllegalArgumentException("Erro no cadastro do fornecedor: " + iae.getMessage());
		}
	}

	/**
	 * Verifica se o fornecedor existe.
	 * 
	 * @param nome
	 */
	private void validaFornecedor(String nome) {
		if (this.fornecedores.containsKey(nome))
			throw new IllegalArgumentException("fornecedor ja existe.");

	}

	/**
	 * Verifica se o nome eh invalido.
	 * 
	 * @param nome
	 */
	private void nomeInvalido(String nome) {
		if (nome.trim().isEmpty() || nome == null)
			throw new IllegalArgumentException("nome nao pode ser vazio ou nulo.");
	}

	/**
	 * Exibe um fornecedor cadastrado.
	 * 
	 * @param nome
	 * @return
	 */
	public String exibeFornecedor(String nome) {
		try {
			this.nomeInvalido(nome);
			this.fornecedorInexistente(nome);

			return this.fornecedores.get(nome).toString();

		} catch (IllegalArgumentException iae) {
			throw new IllegalArgumentException("Erro na exibicao do fornecedor: " + iae.getMessage());
		}
	}

	/**
	 * Verifica se o fornecedor nao existe.
	 * 
	 * @param nome
	 */
	private void fornecedorInexistente(String nome) {
		if (this.fornecedores.containsKey(nome) == false)
			throw new IllegalArgumentException("fornecedor nao existe.");

	}

	/**
	 * Exibe todos os fornecederes cadastrados no sistema.
	 * 
	 * @return
	 */
	public String exibeFornecedores() {
		try {
			if (fornecedores.size() == 0)
				throw new IllegalArgumentException("nenhum fornecedor cadastrado.");

			List<Fornecedor> listaFornecedor = new ArrayList<Fornecedor>(fornecedores.values());
			Collections.sort(listaFornecedor);
			return this.listaDeFornecedores(listaFornecedor);

		} catch (IllegalArgumentException iae) {
			throw new IllegalArgumentException("Erro na exibicao dos fornecedores: " + iae.getMessage());
		}
	}

	/**
	 * Cria uma String com todos os fornecedores cadastrados e a retorna.
	 * 
	 * @param listaFornecedor
	 * @return
	 */
	private String listaDeFornecedores(List<Fornecedor> listaFornecedor) {
		String fornecedores = "";

		for (int i = 0; i < listaFornecedor.size(); i++) {
			fornecedores += listaFornecedor.get(i).toString() + " | ";
		}

		return fornecedores.substring(0, fornecedores.length() - 3);
	}

	/**
	 * Edita o fornecedor passado como parametro.
	 * 
	 * @param nome
	 * @param email
	 * @param telefone
	 * @return
	 */
	public void editaFornecedor(String nome, String atributo, String novoValor) {
		try {
			this.nomeInvalido(nome);
			this.fornecedorInexistente(nome);

			this.edita(nome, atributo, novoValor);
		} catch (IllegalArgumentException iae) {
			throw new IllegalArgumentException("Erro na edicao do fornecedor: " + iae.getMessage());
		}
	}

	/**
	 * Edita o email e o telefone.
	 * 
	 * @param nome
	 * @param atributo
	 * @param novoValor
	 */
	private void edita(String nome, String atributo, String novoValor) {
		this.valoresInvalidosFornecedor(atributo, novoValor);
		this.nomeFornecedor(nome, atributo, novoValor);

		if (atributo.equals("email"))
			this.fornecedores.get(nome).setEmail(novoValor);
		if (atributo.equals("telefone"))
			this.fornecedores.get(nome).setTelefone(novoValor);
	}
	
	/**
	 * Verifica se os valores do fornecedor sao invalidos.
	 * 
	 * @param atributo
	 * @param novoValor
	 */
	private void valoresInvalidosFornecedor(String atributo, String novoValor) {
		if (atributo.trim().isEmpty() || atributo == null)
			throw new IllegalArgumentException("atributo nao pode ser vazio ou nulo.");
		if (novoValor.trim().isEmpty() || novoValor == null)
			throw new IllegalArgumentException("novo valor nao pode ser vazio ou nulo.");
			
	}

	/**
	 * Verifica se os atributos passados sao corretos.
	 * 
	 * @param nome
	 * @param atributo
	 * @param novoValor
	 */
	private void nomeFornecedor(String nome, String atributo, String novoValor) {
		if (atributo.equals("nome"))
			throw new IllegalArgumentException("nome nao pode ser editado.");
		if (!atributo.equals("nome") && !atributo.equals("telefone") && !atributo.equals("email"))
			throw new IllegalArgumentException("atributo nao existe.");

	}

	/**
	 * Remove um fornecedor passado por parametro.
	 * 
	 * @param nome
	 * @return
	 */
	public void removeFornecedor(String nome) {
		try {
			this.nomeInvalido(nome);
			this.fornecedorInexistente(nome);

			this.fornecedores.remove(nome);
		} catch (IllegalArgumentException iae) {
			throw new IllegalArgumentException("Erro na remocao do fornecedor: " + iae.getMessage());
		}

	}

	// PRODUTOS

	/**
	 * Adiciona produtos ao fornecedor.
	 * 
	 * @param fornecedor
	 * @param nomeProduto
	 * @param descricao
	 * @param preco
	 * @return
	 */
	public void adicionaProduto(String fornecedor, String nomeProduto, String descricao, Double preco) {
		try {
			this.nomeFornecedorInvalido(fornecedor);
			this.fornecedorInexistente(fornecedor); // ERROR

			this.fornecedores.get(fornecedor).adicionaProduto(nomeProduto, descricao, preco);
		} catch (IllegalArgumentException iae) {
			throw new IllegalArgumentException("Erro no cadastro de produto: " + iae.getMessage());
		}
	}

	/**
	 * Verifica se o nome do fornecedor eh invalido.
	 * 
	 * @param nome
	 */
	private void nomeFornecedorInvalido(String fornecedor) {
		if (fornecedor.trim().isEmpty() || fornecedor == null)
			throw new IllegalArgumentException("fornecedor nao pode ser vazio ou nulo.");
	}

	/**
	 * Retorna um produto passado por parametro.
	 * 
	 * @param fornecedor
	 * @param nomeProduto
	 * @param descricao
	 * @return
	 */
	public String exibeProduto(String nomeProduto, String descricao, String fornecedor) {
		try {
			this.nomeFornecedorInvalido(fornecedor);
			this.fornecedorInexistente(fornecedor);

			return this.fornecedores.get(fornecedor).exibeProduto(nomeProduto, descricao);
		} catch (IllegalArgumentException iae) {
			throw new IllegalArgumentException("Erro na exibicao de produto: " + iae.getMessage());
		}

	}

	/**
	 * Edita o preco do produto passado como parametro.
	 * 
	 * @param fornecedor
	 * @param nomeProduto
	 * @param descricao
	 * @param preco
	 * @return 
	 */
	public void editaPreco(String nomeProduto, String descricao, String fornecedor, Double preco) {
		try {
			this.nomeFornecedorInvalido(fornecedor);
			this.fornecedorInexistente(fornecedor);;
			
			this.fornecedores.get(fornecedor).editaPreco(nomeProduto, descricao, preco);
			
		} catch (IllegalArgumentException iae) {
			throw new IllegalArgumentException("Erro na edicao de produto: " + iae.getMessage());
		}
		
	}

	/**
	 * Este metodo lista todos os produtos de todos os fornecedores.
	 * 
	 * @return
	 */
	public String exibeProdutos() {
		try {
			List<Fornecedor> listaFornecedor = new ArrayList<Fornecedor>(fornecedores.values());
			Collections.sort(listaFornecedor);

			return this.listaDeProdutos(listaFornecedor);

		} catch (IllegalArgumentException iae) {
			throw new IllegalArgumentException("" + iae.getMessage());
		}
	}

	/**
	 * Cria uma String com todos os produtos de todos os fornecedores.
	 * 
	 * @param listaFornecedor
	 * @return
	 */
	private String listaDeProdutos(List<Fornecedor> listaFornecedor) {
		String produtos = "";

		for (int i = 0; i < listaFornecedor.size(); i++) {
			produtos += listaFornecedor.get(i).listarProdutos();
		}

		return produtos.substring(0, produtos.length() - 3);
	}

	/**
	 * Metodo retorna todos os produtos de um fornecedor passado por parametro.
	 * 
	 * @param fornecedor
	 * @return os produtos ou informando que nao existe nenhum cadastrado;
	 */
	public String exibeProdutosFornecedor(String fornecedor) {
		try {
			this.nomeFornecedorInvalido(fornecedor);
			this.fornecedorInexistente(fornecedor);
			this.produtos(fornecedor);

			String lista = this.fornecedores.get(fornecedor).listarProdutos();
			return lista.substring(0, lista.length() - 3);

		} catch (IllegalArgumentException iae) {
			throw new IllegalArgumentException("Erro na exibicao dos produtos do fornecedor: " + iae.getMessage());
		}

	}

	/**
	 * Verifica se nenhum produto esta cadastrado.
	 * 
	 * @param fornecedor
	 */
	private void produtos(String fornecedor) {
		if (this.fornecedores.get(fornecedor).listarProdutos().equals(""))
			throw new IllegalArgumentException("nenhum produto cadastrado.");
	}

	/**
	 * Remove um produto de um fornecedor passado por parametro.
	 * 
	 * @param nome
	 * @param descricao
	 * @param fornecedor
	 */
	public void removeProduto(String nome, String descricao, String fornecedor) {
		try {
			this.nomeFornecedorInvalido(fornecedor);
//			this.fornecedorInexistente(nome);
			
			this.fornecedores.get(fornecedor).removeProduto(nome, descricao);

		} catch (IllegalArgumentException iae) {
			throw new IllegalArgumentException("Erro na remocao de produto: " + iae.getMessage());
		}
	}

}
