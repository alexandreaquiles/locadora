package locadora.preco;

public class PrecoNormal {

	public double precoNormal(int diasDeAluguel) {
		double valor = 2.0;
		if(diasDeAluguel > 2) {
			valor += (diasDeAluguel - 2) * 1.5;
		}
		return valor;
	}

}
