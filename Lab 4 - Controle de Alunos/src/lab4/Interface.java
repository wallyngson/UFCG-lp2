package lab4;

import java.util.Scanner;

/**
 * Essa classe representa uma interface que se comunica com o usuario, captando
 * as entradas e imprimindo em tela as saidas;
 * 
 * @author Wallyngson Guedes, Matricula: 117110835;
 *
 */
public class Interface {

	private Facade facade = new Facade();
	private Scanner sc = new Scanner(System.in);

	public void start() {

		String condicao = "";

		do {

			System.out.print("(C)adastrar Aluno\n" + "(E)xibir Aluno\n" + "(N)ovo Grupo\n"
					+ "(A)locar Aluno no Grupo e Imprimir Grupos\n" + "(R)egistrar Aluno que Respondeu\n"
					+ "(I)mprimir Alunos que Responderam\n" + "(O)ra, vamos fechar o programa!\n"
					+ System.lineSeparator() + "Opcao> ");

			condicao = sc.nextLine().trim().toLowerCase();

			switch (condicao) {
			case "o":
				break;

			case "c":
				try {

					System.out.print("Matricula: ");
					String matricula = sc.nextLine().trim();

					System.out.print("Nome: ");
					String nome = sc.nextLine();

					System.out.print("Curso: ");
					String curso = sc.nextLine();

					System.out.println(facade.cadastraAluno(matricula, nome, curso) + System.lineSeparator());
					break;

				} catch (NullPointerException npe) {
					System.err.println(npe.getMessage() + System.lineSeparator());
				} catch (IllegalArgumentException iae) {
					System.err.println(iae.getMessage() + System.lineSeparator());
				}
				break;

			case "e":
				System.out.print("Matricula: ");
				String matricula = sc.nextLine().trim();

				System.out.println(facade.exibeAluno(matricula) + System.lineSeparator());

				break;

			case "n":
				try {
					System.out.print("Grupo: ");
					String grupo = sc.nextLine();

					System.out.println(facade.cadastraGrupo(grupo) + System.lineSeparator());
					break;

				} catch (IllegalArgumentException iae) {
					System.err.println(iae.getMessage() + System.lineSeparator());
				}
				break;

			case "a":
				System.out.print("(A)locar Aluno ou (I)mprimir Grupo? ");
				String op = sc.nextLine().toLowerCase().trim();

				switch (op) {
				case "a":
					System.out.print("Matricula: ");
					matricula = sc.nextLine().trim();

					System.out.print("Grupo: ");
					String grupo = sc.nextLine();

					System.out.println(facade.alocarAluno(matricula, grupo) + System.lineSeparator());

					break;
				case "i":
					System.out.print("Grupo: ");
					grupo = sc.nextLine();

					System.out.println(facade.imprimirAlunosPorGrupo(grupo) + System.lineSeparator());

					break;
				default:
					System.out.println("Operacao invalida!" + System.lineSeparator());
					break;
				}

				break;

			case "r":
				System.out.print("Matricula: ");
				matricula = sc.nextLine().trim();

				System.out.println(facade.adicionarRepostaAoAluno(matricula) + System.lineSeparator());

				break;

			case "i":
				System.out.println(facade.imprimirAlunosQueResponderam() + System.lineSeparator());
				break;

			default:
				System.out.println("Nao foi possivel realizar esta operacao, digite um parametro valido!"
						+ System.lineSeparator());
				break;
			}

		} while (!condicao.equals("o"));

	}

}
