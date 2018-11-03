package sp2fy;

import java.util.HashMap;
import java.util.Map;

/**
 * Esta classe representa um perfil de um usuario. Possui um nome, e um conjunto
 * de playlists, albuns e albuns favoritos.
 * 
 * @author Wallyngson Guedes
 *
 */
public class Perfil {

	private String nomeUsuario;
	private Map<String, Playlist> playlists;
	private Map<String, Album> albuns;
	private Map<String, Album> albunsFavoritos;

	public Perfil(String nome) {
		this.nomeUsuario = nome;

		if (nome == null)
			throw new NullPointerException();

		if (nome.equals(""))
			throw new IllegalArgumentException();

		this.albuns = new HashMap<>();
		this.albunsFavoritos = new HashMap<>();
		this.playlists = new HashMap<>();
	}

	public String adicionaAlbum(Album album) {
		if (validaAlbum(album))
			return "Esta album ja esta cadastrado!";

		this.albuns.put(album.getTitulo(), album);
		return "Album cadastrado com sucesso!";

	}

	public String adicionaAosFavoritos(Album album) {
		if (validaAlbum(album))
			return "Nao foi possivel adicionar o album!";

		this.albunsFavoritos.put(album.getTitulo(), album);
		return "Album adicionado aos favoritos!";

	}

	public String getNomeUsuario() {
		return this.nomeUsuario;
	}

	public boolean validaAlbum(Album album) {
		return this.albuns != null && this.albuns.containsKey(album.getTitulo());
	}

	public void adicionaPlaylist(String nomePlaylist, String nomeAlbum, int faixa) {
		if (this.validaPlaylist(nomePlaylist) && this.albuns.containsKey(nomeAlbum)) {
			this.playlists.get(nomePlaylist).adicionaMusicaPlaylist(this.albuns.get(nomeAlbum).pesquisaMusica(faixa));
		}
		this.playlists.put(nomePlaylist, new Playlist(nomePlaylist));
	}

	private boolean validaPlaylist(String nomePlaylist) {
		return this.playlists.containsKey(nomePlaylist);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nomeUsuario == null) ? 0 : nomeUsuario.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {

		Perfil outro = (Perfil) obj;
		return this.reduzEspaco(this.getNomeUsuario()).equals(this.reduzEspaco(outro.getNomeUsuario()));

	}

	private String reduzEspaco(String palavras) {
		return palavras.toLowerCase().replace(" ", "");
	}

	@Override
	public String toString() {
		return "Perfil: " + this.getNomeUsuario() + ".";
	}

}
