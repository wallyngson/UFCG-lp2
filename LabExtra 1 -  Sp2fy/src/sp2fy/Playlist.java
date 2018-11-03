package sp2fy;

import java.util.ArrayList;
import java.util.List;

/**
 * Esta classe representa uma playlist. Possui um nome e uma lista de musicas.
 * 
 * @author Wallyngson Guedes
 *
 */
public class Playlist {

	private String nomePlaylist;
	private List<Musica> musicasPlaylist;

	public Playlist(String nomePlaylist) {
		this.nomePlaylist = nomePlaylist;
		this.musicasPlaylist = new ArrayList<>();

	}

	public boolean adicionaMusicaPlaylist(Musica musica) {
		if (this.validaMusica(musica))
			return false;
		this.musicasPlaylist.add(musica);
		return true;

	}

	private boolean validaMusica(Musica novaMusica) {
		for (Musica musica : musicasPlaylist) {
			if (musica != null && musica.equals(novaMusica))
				return true;
		}
		return false;
	}

	public String getNomePlaylist() {
		return this.nomePlaylist;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nomePlaylist == null) ? 0 : nomePlaylist.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {

		Playlist outra = (Playlist) obj;
		return this.reduzEspaco(this.getNomePlaylist()).equals(outra.getNomePlaylist());
	}

	private String reduzEspaco(String palavras) {
		return palavras.toLowerCase().replace(" ", "");
	}

}
