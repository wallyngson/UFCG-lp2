package sp2fy;

import java.util.HashMap;
import java.util.Map;

/**
 * Esta classe representa um Aplicativo de Musica chamado Sp2fy, onde eh
 * possivel ter diversos perfis e albuns, sendo possivel cadastrar musicas em
 * albuns.
 * 
 * @author Wallyngson Guedes
 *
 */
public class ControllerSp2fy {
	private Map<String, Perfil> perfis;

	public ControllerSp2fy() {
		this.perfis = new HashMap<>();
	}

	public String criaPerfil(String nome) {
		if (this.validaPerfil(nome))
			return "Perfil ja existe!";

		this.perfis.put(nome, new Perfil(nome));
		return "Perfil criado!";
	}

	private boolean validaPerfil(String nome) {
		return this.perfis.containsKey(nome);
	}

}
