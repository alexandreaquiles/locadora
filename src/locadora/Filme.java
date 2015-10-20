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
		double valor = 0.0;
	
		switch (getCategoria()) {
	
		case NORMAL:
			valor += 2.0;
			if(diasDeAluguel > 2) {
				valor += (diasDeAluguel - 2) * 1.5;
			}
			break;
	
		case LANCAMENTO:
			valor += diasDeAluguel * 3;
			break;
	
		case INFANTIL:
			valor += 1.0;
			if(diasDeAluguel > 3) {
				valor += (diasDeAluguel - 3) * 1.5;
			}
			break;
		}
		return valor;
	}
	
}
