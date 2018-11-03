package lab2;

import java.util.Arrays;

/**
 * 
 * Classe que representa uma disciplina em que o aluno esta matriculada.
 * 
 * @author Wallyngson Guedes
 * 
 */

public class Disciplina {

	private String disciplina;
	private int horasEstudadas, numNotas;
	private double[] notas;
	private double media;
	private int[] pesoNotas = null;
	private int[] notasBonus;

	public Disciplina(String nomeDisciplina) {
		this.disciplina = nomeDisciplina;
		this.notas = new double[4];
	}

	public Disciplina(String nomeDisciplina, int numNotas) {
		this.disciplina = nomeDisciplina;
		this.numNotas = numNotas;
	}

	public Disciplina(String nomeDisciplina, int numNotas, int[] pesoNotas) {
		this.disciplina = nomeDisciplina;
		this.pesoNotas = pesoNotas;
		this.numNotas = numNotas;
	}

	/**
	 * Cadastra a quantidade de horas que o aluno estudou daquela disciplina.
	 * 
	 * @param horas
	 */
	public void cadastraHoras(int horas) {
		this.horasEstudadas = horas;
	}

	/**
	 * Cadastra uma nota do aluno em uma determinada posicao.
	 * 
	 * @param nota
	 * @param valorNota
	 */
	public void cadastraNota(int nota, double valorNota) {
		this.notas[nota - 1] = valorNota;
	}

	private void calculaMedia() {
		double soma = 0;
		for (double d : notas) {
			soma += d;
		}
		this.media = soma / 4;
	}

	/**
	 * Verifica se o aluno foi aprovado ou nao.
	 * 
	 * @return
	 */
	public boolean aprovado() {
		this.calculaMedia();
		if (this.media >= 7.0)
			return true;

		return false;
	}

	public String getDisciplina() {
		return this.disciplina;
	}

	/**
	 * Cadastra as notas do aluno em uma posicao especifica.
	 * 
	 * @param posicaoNota
	 * @param valorNota
	 */
	public void cadastraNota(int posicaoNota, int valorNota) {
		this.notasBonus[posicaoNota - 1] = valorNota;

	}

	/**
	 * Calcula media poderada das notas.
	 * 
	 * @return
	 */
	private int mediaPonderada() {
		int media = 0;

		for (int i = 0; i < notasBonus.length; i++) {
			media += notasBonus[i] * pesoNotas[i];
		}

		int mediaPonderada = (media / 10);
		return mediaPonderada;
	}

	/**
	 * Calcula media especial.
	 * 
	 * @return
	 */
	public int mediaEspecial() {
		return this.calculaMediaEspecial();

	}

	/**
	 * Calcula media ponderada sem os pesos das notas.
	 * 
	 * @return
	 */
	private int mediaSemPesos() {
		int media = 0;
		for (int i : notasBonus) {
			media += i;
		}

		int mediaPonderada = (media / this.numNotas);
		return mediaPonderada;
	}

	/**
	 * Calcula medias ponderadas com peso e sem peso nas notas.
	 * 
	 * @return
	 */
	private int calculaMediaEspecial() {
		if (pesoNotas == null)
			return mediaSemPesos();
		else
			return mediaPonderada();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((disciplina == null) ? 0 : disciplina.hashCode());
		result = prime * result + horasEstudadas;
		long temp;
		temp = Double.doubleToLongBits(media);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + Arrays.hashCode(notas);
		result = prime * result + Arrays.hashCode(notasBonus);
		result = prime * result + numNotas;
		result = prime * result + Arrays.hashCode(pesoNotas);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Disciplina) {
			Disciplina novaDisciplina = (Disciplina) obj;
			return this.getDisciplina().equals(novaDisciplina.getDisciplina());
		}

		return false;
	}
	
	@Override
	public String toString() {
		return this.disciplina + " " + this.horasEstudadas + " " + this.media + " " + Arrays.toString(notas);
	}

}
