package locadora.preco;

public class PrecoInfantil implements Preco {

	public double calcula(int diasDeAluguel) {
		double valor = 1.0;
		if(diasDeAluguel > 3) {
			valor += (diasDeAluguel - 3) * 1.5;
		}
		return valor;
	}

}
