package locadora;

import locadora.preco.Preco;
import locadora.preco.PrecoInfantil;
import locadora.preco.PrecoLancamento;
import locadora.preco.PrecoNormal;

public class Filme {

	private String titulo;
	private Categoria categoria;

	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public double calculaValorLocacao(int diasDeAluguel) {
		switch (getCategoria()) {
	
		case NORMAL:
			Preco precoNormal = new PrecoNormal();
			return precoNormal.calcula(diasDeAluguel);

		case LANCAMENTO:
			Preco precoLancamento = new PrecoLancamento();
			return precoLancamento.calcula(diasDeAluguel);
	
		case INFANTIL:
			Preco precoInfantil = new PrecoInfantil();
			return precoInfantil.calcula(diasDeAluguel);
			
		default:
			throw new RuntimeException("Categoria Inválida");
		}
	}

}
