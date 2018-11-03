package lab4;

import java.util.HashSet;

/**
 * Essa classe representa um grupo de estudos em que os alunos podem estar
 * inseridos;
 * 
 * @author Wallyngson Guedes, Matricula: 117110835;
 *
 */
public class Grupo {

	private HashSet<Aluno> alunos = new HashSet<Aluno>();
	private String nomeGrupo;

	public Grupo(String grupo) {
		if (grupo.trim().equals(""))
			throw new IllegalArgumentException("Cadastro nao realizado!\n" + "O nome do grupo eh invalido.");

		this.nomeGrupo = grupo;
	}

	public String getNomeGrupo() {
		return this.nomeGrupo;
	}

	/**
	 * Este metodo recebe um aluno como parametro e o adiciona a uma colecao de
	 * alunos cadastrados no grupp;
	 * 
	 * @param aluno = aluno que deve ser cadastrado no grupo;
	 * @return se o aluno foi alocado no grupo ou nao;
	 */
	public String cadastraAlunoEmGrupo(Aluno aluno) {
		if (alunos.contains(aluno)) {
			return "ALUNOS JA ESTA NO GRUPO!";
		}
		
		this.alunos.add(aluno);
		return "ALUNO ALOCADO!";
	}


	 /* Metodo responsavel por retornar uma representacao textual de todos os alunos
	 * que estao cadastrados neste no grupo de estudos;
	 * 
	 * @return os alunos cadastrados no frupo;
	 */
	public String imprimiAlunos() {
		if (alunos.size() == 0)
			return "NAO EXISTE NENHUM ALUNO CADASTRADO EM " + this.getNomeGrupo() + "!";

		return this.imprimir();
	}

	/**
	 * Este metodo eh responsavel por retornar a lista dos alunos cadastrados no grupo;
	 * 
	 * @return os alunos cadastrados no grupo;
	 */
	private String imprimir() {
		String alunosCadastrados = "Alunos do grupo " + this.getNomeGrupo() + ":\n";
		for (Aluno aluno : this.alunos) {
			alunosCadastrados += "* " + aluno + System.lineSeparator();
		}

		return alunosCadastrados.substring(0, alunosCadastrados.length() - 1);

	}

	@Override
	public String toString() {
		return "Nome do Grupo: " + this.nomeGrupo;
	}
	
	/**
	 * Este equals compara pelo nome do grupo, ambos sao iguais se possuirem o mesmo
	 * nome;
	 */
	public boolean equals(Object obj) {
		Grupo novoGrupo = (Grupo) obj;
		return this.getNomeGrupo().toLowerCase().trim().equals(novoGrupo.getNomeGrupo().toLowerCase().trim());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nomeGrupo == null) ? 0 : nomeGrupo.hashCode());
		return result;
	}

}
