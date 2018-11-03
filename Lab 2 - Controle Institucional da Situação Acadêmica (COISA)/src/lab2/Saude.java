package lab2;

/**
 * 
 * Classe que representa a saude do aluno.
 * 
 * @author Wallyngson Guedes
 * 
 */

public class Saude {

	private String statusMental = "boa";
	private String statusFisico = "boa";

	/**
	 * Indica como esta a saude mental do aluno.
	 * 
	 * @param valor
	 */
	public void defineSaudeMental(String valor) {
		this.statusMental = valor;
	}

	/**
	 * Indica como esta a saude mental do aluno.
	 * 
	 * @param valor
	 */
	public void defineSaudeFisica(String valor) {
		this.statusFisico = valor;
	}

	/**
	 * Informa como esta a saude geral do aluno.
	 * 
	 * @return
	 */
	public String getStatusGeral() {
		if (this.statusFisico == "boa" && this.statusMental == "boa")
			return "boa";
		if (this.statusFisico == "fraca" && this.statusMental == "fraca")
			return "fraca";
		return "ok";
	}
}
