package lab4;

/**
 * Esta classe representa um aluno no mundo real, que possui um nome, uma
 * matricula e esta em um determinado curso;
 * 
 * @author Wallyngson Guedes, Matricula: 117110835;	
 *
 */
public class Aluno {

	private String matricula;
	private String nome;
	private String curso;

	public Aluno(String matricula, String nome, String curso) {
		if (matricula.trim().equals("") || nome.trim().equals("") || curso.trim().equals(""))
			throw new IllegalArgumentException(
					"Cadastro nao foi realizado!\n" + "Informe todas as informacoes necessarias.");

		if (matricula == null || nome == null || curso == null)
			throw new NullPointerException(
					"Cadastro nao foi realizado!\n" + "Alguma linha eh nula, informe dados validos.");

		this.matricula = matricula;
		this.nome = nome;
		this.curso = curso;
	}

	public String getMatricula() {
		return this.matricula;
	}

	/**
	 * Retorna uma Representacao Textual de um determinado aluno:
	 * matricula - nome - curso;
	 */
	@Override
	public String toString() {
		return this.matricula + " - " + this.nome + " - " + this.curso;
	}
	
	/**
	 * Verifica se os alunos sao iguais pela sua matricula,
	 * se forem iguais retorna true se nao false;
	 */
	@Override
	public boolean equals(Object obj) {
		Aluno novoAluno = (Aluno) obj;
		return this.getMatricula().equals(novoAluno.getMatricula());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((curso == null) ? 0 : curso.hashCode());
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

}
