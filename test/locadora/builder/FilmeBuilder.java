package locadora.builder;

import locadora.Categoria;
import locadora.Filme;

public class FilmeBuilder {
	
	private Filme filme;
	
	private FilmeBuilder(Filme filme) {
		this.filme = filme;
		this.filme.setCategoria(Categoria.NORMAL);
	}
	
	public static FilmeBuilder umFilme(){
		return new FilmeBuilder(new Filme());
	}

	public FilmeBuilder chamado(String titulo) {
		this.filme.setTitulo(titulo);
		return this;
	}

	public FilmeBuilder lancamento() {
		this.filme.setCategoria(Categoria.LANCAMENTO);
		return this;
	} 

	public FilmeBuilder infantil() {
		this.filme.setCategoria(Categoria.INFANTIL);
		return this;
	} 

	public Filme build() {
		return this.filme;
	}

}
