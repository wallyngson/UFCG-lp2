package lab5;

import easyaccept.EasyAccept;

public class Facade {

	private ControllerSaga controller;

	public static void main(String[] args) {
		args = new String[] { "lab5.Facade", "acceptance_test/use_case_1.txt", "acceptance_test/use_case_2.txt",
				"acceptance_test/use_case_3.txt" };
		EasyAccept.main(args);
	}

	public Facade() {
		controller = new ControllerSaga();
	}

	// CLIENTE

	public String adicionaCliente(String cpf, String nome, String email, String localizacao) {
		return this.controller.adicionaCliente(cpf, nome, email, localizacao);

	}

	public String exibeCliente(String cpf) {
		return this.controller.exibeCliente(cpf);

	}

	public void editaCliente(String cpf, String atributo, String novoValor) {
		this.controller.editaCliente(cpf, atributo, novoValor);
	}

	public void removeCliente(String cpf) {
		this.controller.removeCliente(cpf);
	}

	public String exibeClientes() {
		return this.controller.exibeClientes();
	}

	// FORNECEDOR

	public String adicionaFornecedor(String nome, String email, String telefone) {
		return this.controller.adicionaFornecedor(nome, email, telefone);
	}

	public String exibeFornecedor(String nome) {
		return this.controller.exibeFornecedor(nome);
	}

	public String exibeFornecedores() {
		return this.controller.exibeFornecedores();
	}

	public void editaFornecedor(String nome, String atributo, String novoValor) {
		this.editaFornecedor(nome, atributo, novoValor);
	}

	public void removeFornecedor(String nome) {
		this.removeFornecedor(nome);
	}

	// PRODUTO

	public void adicionaProduto(String fornecedor, String nomeProduto, String descricao, Double preco) {
		this.controller.adicionaProduto(fornecedor, nomeProduto, descricao, preco);
	}

	public String exibeProduto(String nomeProduto, String descricao, String fornecedor) {
		return this.controller.exibeProduto(nomeProduto, descricao, fornecedor);
	}

	public void editaProduto(String nomeProduto, String descricao, String fornecedor, Double novoPreco) {
		this.controller.editaPreco(nomeProduto, descricao, fornecedor, novoPreco);
	}

	public String exibeProdutos() {
		return this.controller.exibeProdutos();
	}

	public String exibeProdutosFornecedor(String fornecedor) {
		return this.controller.exibeProdutosFornecedor(fornecedor);
	}

	public void removeProduto(String nome, String descricao, String fornecedor) {
		this.controller.removeProduto(nome, descricao, fornecedor);
	}
}
