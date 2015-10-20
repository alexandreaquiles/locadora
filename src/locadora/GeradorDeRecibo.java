package locadora;

public class GeradorDeRecibo {

	public String gera(Cliente cliente) {
		double totalGeral = 0.0;
		String recibo = "Recibo para " + cliente.getNome() + ":\n";
		for (Locacao locacao : cliente.getLocacoes()) {
			double totalParcial = 0.0;
			Filme filme = locacao.getFilme();
			int diasDeAluguel = locacao.getDiasDeAluguel();
			totalParcial = calculaValorLocacao(totalParcial, filme, diasDeAluguel);
			recibo += locacao.getFilme().getTitulo() + "\t" + String.valueOf(totalParcial) + "\n";
			totalGeral += totalParcial;
		}
		recibo += "Total: " + String.valueOf(totalGeral) + "\n";
		return recibo;
	}

	private double calculaValorLocacao(double valor, Filme filme, int diasDeAluguel) {
		switch (filme.getCategoria()) {

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
