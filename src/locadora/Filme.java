package locadora;


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
			return precoNormal(diasDeAluguel);
	
		case LANCAMENTO:
			return precoLancamento(diasDeAluguel);
	
		case INFANTIL:
			return precoInfantil(diasDeAluguel);
			
		default:
			throw new RuntimeException("Categoria Inválida");
		}
	}

	private double precoNormal(int diasDeAluguel) {
		double valor = 2.0;
		if(diasDeAluguel > 2) {
			valor += (diasDeAluguel - 2) * 1.5;
		}
		return valor;
	}

	private double precoLancamento(int diasDeAluguel) {
		return diasDeAluguel * 3;
	}

	private double precoInfantil(int diasDeAluguel) {
		double valor = 1.0;
		if(diasDeAluguel > 3) {
			valor += (diasDeAluguel - 3) * 1.5;
		}
		return valor;
	}

}
