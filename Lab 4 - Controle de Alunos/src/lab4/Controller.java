package lab4;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Essa classe controller representa um sistema que gerencia os alunos, seus
 * grupos de estudos e quais responderam as questoes no quadro;
 * 
 * @author Wallyngson Guedes, Matricula: 117110835;
 *
 */
public class Controller {

	private HashMap<String, Aluno> alunos;
	private HashMap<String, Grupo> grupos;
	private ArrayList<Aluno> alunosQueResponderam;

	public Controller() {
		alunos = new HashMap<>();
		grupos = new HashMap<>();
		alunosQueResponderam = new ArrayList<>();
	}

	/**
	 * Este metodo cadastra um determinado aluno com sua matricula, nome e curso.
	 * 
	 * @param matricula = matricula do aluno;
	 * @param nome      = nome do aluno;
	 * @param curso     = curso do aluno;
	 * @return se foi possivel ou nao matricular o aluno;
	 */
	public String cadastraAluno(String matricula, String nome, String curso) {
		if (this.alunos.containsKey(matricula))
			return "MATRICULA JA CADASTRADA!";

		Aluno aluno = new Aluno(matricula, nome, curso);
		this.alunos.put(matricula, aluno);
		return "CADASTRO REALIZADO!";
	}

	/**
	 * Retorna uma represetacao textual do aluno passado como parametro atraves de
	 * sua matricula;
	 * 
	 * @param matricula = matricula do aluno a ser pesquisado;
	 * @return uma string com o aluno pesquisado ou informando que ele nao esta
	 *         cadastrado.
	 */
	public String exibeAluno(String matricula) {
		if (this.validaAluno(matricula))
			return "Aluno: " + this.alunos.get(matricula);

		return "ALUNO NAO CADASTRADO!";
	}

	/**
	 * Este metodo recebe o nome do grupo de estudo a ser cadastrado no sistema;
	 * 
	 * @param grupo = nome do grupo de estudo;
	 * @return se o grupo foi criado ou se ele ja existe;
	 */
	public String cadastraGrupo(String grupo) {
		if (this.validaGrupo(grupo))
			return "GRUPO JA CADASTRADO!";

		Grupo novoGrupo = new Grupo(grupo);
		this.grupos.put(grupo, novoGrupo);
		return "CADASTRO REALIZADO!";
	}

	/**
	 * Recebendo a matricula do aluno e o nome do grupo de estudos, este metodo deve
	 * alocar o aluno no grupo passado por parametro;
	 * 
	 * @param matricula = matricula do aluno;
	 * @param grupo     = grupo de estudo;
	 * @return se o aluno foi alocado ou nao;
	 */
	public String alocarAluno(String matricula, String grupo) {
		if (this.validaAluno(matricula) && this.validaGrupo(grupo))
			return this.alocar(matricula, grupo);

		if (this.validaAluno(matricula) == false && validaGrupo(grupo) == false)
			return "O GRUPO E O ALUNO NAO ESTAO CADASTRADO NO SISTEMA!";
		
		if (this.validaGrupo(grupo) == false)
			return "GRUPO NAO CADASTRADO NO SISTEMA!";
		
		return "ALUNO NAO CADASTRADO NO SISTEMA!";
	}

	/**
	 * Metodo responsavel por alocar o aluno no grupo;
	 * 
	 * @param matricula = matricula do aluno a ser matriculado no grupo;
	 * @param grupo     = grupo que o aluno deve ser matriculado;
	 * @return string afirmando que o aluno foi matriculado;
	 */
	private String alocar(String matricula, String grupo) {
		this.grupos.get(grupo).cadastraAlunoEmGrupo(alunos.get(matricula));
		return "ALUNO ALOCADO COM SUCESSO!";
	}

	/**
	 * Este metodo retorna uma representacao textual com todos os alunos que estao
	 * cadastrados em um determinado grupo de estudos passado por parametro;
	 * 
	 * @param grupo = nome do grupo de estudos a ser pesquisado;
	 * @return todos os alunos que estao cadastrados ou se nao foi possivel
	 *         imprimir;
	 */
	public String imprimirAlunosPorGrupo(String grupo) {
		if (this.validaGrupo(grupo))
			return this.grupos.get(grupo).imprimiAlunos();

		return "GRUPO NAO CADASTRADO NO SISTEMA!";
	}

	/**
	 * Metodo resposavel por procurar se o aluno esta cadastrado no sistema;
	 * 
	 * @param matricula = matricula do aluno a ser consultado;
	 * @return true se o aluno eh cadastrado ou false se nao;
	 */
	private boolean validaAluno(String matricula) {
		return this.alunos.containsKey(matricula);
	}

	/**
	 * Metodo resposavel por procurar se o grupo esta cadastrado no sistema;
	 * 
	 * @param grupo = nome do grupo a ser consultado;
	 * @return true se o grupo eh cadastrado ou false se nao;
	 */
	private boolean validaGrupo(String grupo) {
		for (String nome : grupos.keySet()) {
			Grupo nomeGrupo = grupos.get(nome);
			return this.reduzEspaco(nomeGrupo.getNomeGrupo()).equals(reduzEspaco(grupo));
		}
		return false;
	}

	/**
	 * Este metodo deixa todos as letras minusculas e retira todos os espacos da
	 * frase, para comparacao;
	 * 
	 * @param frase = a ser editada;
	 * @return a frase sem espacos e minuscula;
	 */
	private String reduzEspaco(String frase) {
		return frase.toLowerCase().replace(" ", "");
	}

	/**
	 * Metodo responsavel por adicionar no ArrayList alunosQueResponderam, um aluno
	 * que respondeu uma questao no quadro, recebendo por parametro a matricula do
	 * aluno que respondeu.
	 * 
	 * @param matricula = matricula do aluno que respondeu;
	 * @return se a resposta foi adicionada ou nao;
	 */
	public String adicionarRepostaAoAluno(String matricula) {
		if (this.validaAluno(matricula))
			return adicionaResposta(matricula);

		return "ALUNO NAO CADASTRADO NO SISTEMA!";
	}

	/**
	 * Metodo responsavel por adicionar o aluno ao o ArrayList de
	 * alunosQueResponderam;
	 * 
	 * @param matricula = matricula do aluno que respondeu a questao no quadro;
	 * @return se o a resposta foi salva ou nao;
	 */
	private String adicionaResposta(String matricula) {
		this.alunosQueResponderam.add(alunos.get(matricula));
		return "RESPOSTA REGISTRADA!";
	}

	/**
	 * Este metodo retorna uma lista com os alunos que responderam alguma questao no
	 * quadro, retorna na sequencia em que os alunos responderam;
	 * 
	 * @return os alunos que responderam ou informa que nenhum respondeu nenhuma
	 *         questao;
	 */
	public String imprimirAlunosQueResponderam() {
		if (this.alunosQueResponderam.size() == 0)
			return "NENHUM ALUNO RESPONDEU NENHUMA QUESTAO!";

		return imprimirAlunos();
	}

	/**
	 * Metodo resposavel por retornar ao metodo que o chamou a lista de alunos que
	 * responderam as quest�es;
	 * 
	 * @return
	 */
	private String imprimirAlunos() {
		String listaAlunos = "";
		int cont = 1;
		for (Aluno aluno : alunosQueResponderam) {
			listaAlunos += cont + ". " + aluno + "\n";
			cont += 1;
		}

		return listaAlunos.substring(0, listaAlunos.length() - 1);
	}

}
