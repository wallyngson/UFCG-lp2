package lab3;

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Interface que se comunica com o usuario.
 * 
 * @author Wallyngson Guedes
 *
 */
public class InterfaceUsuario {

	public void start() {
		Agenda agenda = new Agenda();

		Scanner sc = new Scanner(System.in);
		String entrada = "";

		do {

			System.out.print("(C)adastrar Contato \n" + "(L)istar Contatos \n" + "(E)xibir Contato \n" + "(S)air \n"
					+ System.lineSeparator() + "Opcao> ");

			entrada = sc.nextLine().toLowerCase();

			switch (entrada) {

			/**
			 * Caso digite "c" deve cadastrar um contato.
			 */
			case "c":

				try {

					System.out.print("Posicao: ");
					int posicao = sc.nextInt();
					sc.nextLine();

					System.out.print("Nome: ");
					String nome = sc.nextLine();

					System.out.print("Sobrenome: ");
					String sobrenome = sc.nextLine();

					System.out.print("Telefone: ");
					String telefone = sc.nextLine();

					System.out.println(agenda.cadastraContato(posicao, nome, sobrenome, telefone));

				} catch (NullPointerException nulo) {
					System.err.println(nulo.getMessage());

				} catch (IllegalArgumentException argIllegal) {
					System.err.println(argIllegal.getMessage());

				} catch (IndexOutOfBoundsException indexException) {
					System.err.println(indexException.getMessage());

				}
				break;

			/**
			 * s Digitando "e" deve-se exibir um contato.
			 */
			case "e":
				try {

					System.out.print("Contato> ");
					int posicaoContato = sc.nextInt();
					sc.nextLine();

					System.out.println(System.lineSeparator() + agenda.exibirContato(posicaoContato));

					break;

				} catch (NoSuchElementException posicaoInvalida) {
					System.err.println(posicaoInvalida.getMessage());

				} catch (IndexOutOfBoundsException indexException) {
					System.err.println(indexException.getMessage());

				}
				break;

			/**
			 * Digintando "l" deve-se listar todos os contatos.
			 */
			case "l":
				try {

					System.out.println(System.lineSeparator() + agenda.listarContatos());
					break;

				} catch (IllegalArgumentException argumentoIlegal) {
					System.err.println(argumentoIlegal.getMessage());

				}
				break;

			/**
			 * Caso digite "s" deve se sair do programa.
			 */
			case "s":
				System.exit(0);
				break;

			/**
			 * Qualquer outra letra digitada deve gerar um erro. 
			 */
			default:
				System.out.print("Opcao Invalida!" + System.lineSeparator());
				break;
			}
			sc.nextLine();

		} while (!entrada.equals("s"));

		sc.close();
	}
}
