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
		Preco preco = null;
		switch (getCategoria()) {
	
		case NORMAL:
			preco = new PrecoNormal();
			break;
			
		case LANCAMENTO:
			preco = new PrecoLancamento();
			break;
			
		case INFANTIL:
			preco = new PrecoInfantil();
			break;
			
		default:
			throw new RuntimeException("Categoria Inválida");

		}
		return preco.calcula(diasDeAluguel);
	}

}
