package sp2fy;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe representa um album de musicas. Este album possui um titulo, o nome do
 * artista, ano que foi lançado e uma colecao de musicas.
 * 
 * @author Wallyngson Guedes
 *
 */
public class Album {

	private String titulo;
	private String artista;
	private String ano;
	private int duracaoAlbum = 0;
	private List<Musica> musicas;

	public Album(String titulo, String artista, String ano) {
		this.titulo = titulo;
		this.artista = artista;
		this.ano = ano;

		if (titulo == null || artista == null || ano == null)
			throw new NullPointerException("");

		if (titulo.equals("") || artista.equals("") || ano.equals(""))
			throw new IllegalArgumentException("");

		this.musicas = new ArrayList<>();

	}

	public String adicionaMusica(String titulo, int duracao, String genero) {
		if (validaMusica(new Musica(titulo, duracao, genero)))
			return "Musica ja cadastrada!";

		this.musicas.add(new Musica(titulo, duracao, genero));
		return "Musica cadastrada com sucesso!";
	}

	private boolean validaMusica(Musica musica) {
		for (int i = 0; i < musicas.size(); i++) {
			if (this.musicas != null && this.musicas.get(i).equals(musica))
				return true;
		}
		return false;
	}

	public String retiraMusica(int posicao) {
		if (this.validaMusica(posicao) != null) {
			duracaoAlbum -= this.musicas.get(posicao - 1).getDuracao();
			this.musicas.remove(posicao - 1);
			return "Musica removida com sucesso!";

		}
		return "Nao possivel fazer esta operacao, musica nao encontrada.";

	}

	public Musica pesquisaMusica(int posicao) {
		return this.validaMusica(posicao);
	}

	public Musica tocarMusica(String nome) {
		for (int i = 0; i < musicas.size(); i++) {
			if (this.musicas != null && this.musicas.get(i).getTitulo().equals(nome))
				return this.musicas.get(i);
		}
		return null;
	}

	private Musica validaMusica(int posicao) {
		if (this.musicas.get(posicao - 1) != null)
			return this.musicas.get(posicao - 1);
		return null;

	}

	public String getArtista() {
		return this.artista;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public int duracaoAlbum() {
		return this.duracaoAlbum;
	}

	@Override
	public String toString() {
		return titulo + "\n" + "Artista: " + artista + "\n" + "Ano da musica: " + ano + "\n";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ano == null) ? 0 : ano.hashCode());
		result = prime * result + ((artista == null) ? 0 : artista.hashCode());
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		Album novoAlbum = (Album) obj;
		return this.getArtista().equals(novoAlbum.getArtista()) && this.getTitulo().equals(novoAlbum.getTitulo());

	}

}
