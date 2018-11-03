package lab2;

import java.util.Arrays;

/**
 * 
 * Classe que representa uma conta que aluno faz em uma cantina.
 * 
 * @author Wallyngson Guedes
 * 
 */

public class ContaCantina {

	private String nomeCantina;
	private int contaPagar;
	private int itensConsumidos;
	private int valorTotal;
	private String[] detalhes = new String[5];

	public ContaCantina(String nomeCantina) {
		this.nomeCantina = nomeCantina;
	}

	/**
	 * Cadastra o lanches que o aluno consumiu, aumentando o valor da sua conta.
	 * 
	 * @param qtdItens
	 * @param valorCentavos
	 */
	public void cadastraLanche(int qtdItens, int valorCentavos) {
		this.valorTotal += valorCentavos;
		this.contaPagar += valorCentavos;
		this.itensConsumidos += qtdItens;
	}

	/**
	 * Cadastra o lanche e os seus detalhes.
	 * 
	 * @param qtdItens
	 * @param valorCentavos
	 * @param detalhes
	 */
	public void cadastrarLanche(int qtdItens, int valorCentavos, String detalhes) {
		this.valorTotal += valorCentavos;
		this.contaPagar += valorCentavos;
		this.itensConsumidos += qtdItens;
	
		adicionarDetalhe(detalhes);
	}

	/**
	 * Paga a conta do aluno.
	 * 
	 * @param valorCentavos
	 */
	public void pagaConta(int valorCentavos) {
		this.contaPagar -= valorCentavos;
	}

	/**
	 * Valor total da conta que aluno nao pagou.
	 * 
	 * @return
	 */
	public int getFaltaPagar() {
		return this.contaPagar;
	}

	public String getNome() {
		return this.nomeCantina;
	}
	
	/**
	 * Lista todos os detalhes dos lanches.
	 * 
	 * @return
	 */
	public String listarDetalhes() {
		return this.detalhes();
	}
	
	/**
	 * Cria a String com todos os detalhes listados.
	 * 
	 * @return
	 */
	private String detalhes() {
		String saida = "";
		
		for (String string : detalhes) {
			if(string != null) {
				saida += string + System.lineSeparator();
			} 
		}
		return saida.substring(0, saida.length() - 1);
	}

	/**
	 * Adiciona o detalhe na ultima posicao, fazendo um "shift" nos detalhes anteriores.
	 * 
	 * @param detalhe
	 */
	private void adicionarDetalhe(String detalhe) {
		for (int i = 1; i < detalhes.length; i++) {
			detalhes[i - 1] = detalhes[i];
		}
		
		detalhes[4] = detalhe;
		}
	
	@Override
	public String toString() {
		return this.nomeCantina + " " + this.itensConsumidos + " " + this.valorTotal;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + contaPagar;
		result = prime * result + Arrays.hashCode(detalhes);
		result = prime * result + itensConsumidos;
		result = prime * result + ((nomeCantina == null) ? 0 : nomeCantina.hashCode());
		result = prime * result + valorTotal;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof ContaCantina) {
			ContaCantina nova = (ContaCantina) obj;
			return this.getNome().equals(nova.getNome());
		}
		return false;
	}
	
}
	

