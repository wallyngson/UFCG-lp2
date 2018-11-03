package lab2;

/**
 * 
 * Classe que representa a conta de um laboratorio do aluno.
 * 
 * @author Wallyngson Guedes
 * 
 */

public class ContaLaboratorio {

	private String nomeLaboratorio;
	private int cota;
	private int espacoConsumido;

	public ContaLaboratorio(String laboratorio) {
		this.nomeLaboratorio = laboratorio;
		this.cota = 2000;
	}

	public ContaLaboratorio(String laboratorio, int cota) {
		this.nomeLaboratorio = laboratorio;
		this.cota = cota;
	}

	/**
	 * Informa se o aluno atingiu sua cota no laboratorio.
	 * 
	 * @return
	 */
	public boolean atingiuCota() {
		if (this.espacoConsumido >= this.cota)
			return true;

		return false;
	}

	public void setCota(int cota) {
		this.cota = cota;
	}
	
	public String getNomeLaboratorio() {
		return nomeLaboratorio;
	}

	public int getCota() {
		return this.cota;
	}

	public void setNomeLaboratorio(String nomeLaboratorio) {
		this.nomeLaboratorio = nomeLaboratorio;
	}

	/**
	 * Consome uma quantidade de espaco no laboratorio.
	 * 
	 * @param cotaOcupada
	 */
	public void consomeEspaco(int cotaOcupada) {
		this.espacoConsumido += cotaOcupada;
	}

	/**
	 * Libera uma quantidade de espaco no laboratorio.
	 * 
	 * @param espaco
	 */
	public void liberaEspaco(int espaco) {
		this.espacoConsumido -= espaco;
	}

	@Override
	public String toString() {
		return this.nomeLaboratorio + " " + espacoConsumido + "/" + this.cota;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cota;
		result = prime * result + espacoConsumido;
		result = prime * result + ((nomeLaboratorio == null) ? 0 : nomeLaboratorio.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof ContaLaboratorio) {
			ContaLaboratorio novoLab = (ContaLaboratorio) obj;
			return this.getNomeLaboratorio().equals(novoLab.getNomeLaboratorio());
		}
		return false;
	}

	
}
