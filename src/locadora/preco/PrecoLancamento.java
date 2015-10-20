package locadora.preco;

public class PrecoLancamento implements Preco {

	public double calcula(int diasDeAluguel) {
		return diasDeAluguel * 3;
	}

}
