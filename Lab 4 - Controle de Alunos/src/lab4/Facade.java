package lab4;

/**
 * Esta classe eh uma camada de fachada, que recebe os dados da interface e
 * encaminha para o controller, seguindo o padrao do encapsulamento;
 * 
 * @author Wallyngson Guedes, Matricula: 117110835;
 *
 */
public class Facade {

	private Controller sistema;

	public Facade() {
		sistema = new Controller();
	}

	public String cadastraAluno(String matricula, String nome, String curso) {
		return sistema.cadastraAluno(matricula, nome, curso);
	}

	public String exibeAluno(String matricula) {
		return sistema.exibeAluno(matricula);
	}

	public String cadastraGrupo(String grupo) {
		return sistema.cadastraGrupo(grupo);
	}

	public String alocarAluno(String matricula, String grupo) {
		return sistema.alocarAluno(matricula, grupo);
	}

	public String imprimirAlunosPorGrupo(String grupo) {
		return sistema.imprimirAlunosPorGrupo(grupo);
	}

	public String adicionarRepostaAoAluno(String matricula) {
		return sistema.adicionarRepostaAoAluno(matricula);
	}

	public String imprimirAlunosQueResponderam() {
		return sistema.imprimirAlunosQueResponderam();
	}

}
