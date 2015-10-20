package locadora;

public class GeradorDeRecibo {

	public String gera(Cliente cliente) {
		double totalGeral = 0.0;
		String recibo = "Recibo para " + cliente.getNome() + ":\n";
		for (Locacao locacao : cliente.getLocacoes()) {
			double totalParcial = 0.0;
			Filme filme = locacao.getFilme();
			int diasDeAluguel = locacao.getDiasDeAluguel();
			switch (filme.getCategoria()) {

			case NORMAL:
				totalParcial += 2.0;
				if(diasDeAluguel > 2) {
					totalParcial += (diasDeAluguel - 2) * 1.5;
				}
				break;

			case LANCAMENTO:
				totalParcial += diasDeAluguel * 3;
				break;

			case INFANTIL:
				totalParcial += 1.0;
				if(diasDeAluguel > 3) {
					totalParcial += (diasDeAluguel - 3) * 1.5;
				}
				break;
			}
			recibo += locacao.getFilme().getTitulo() + "\t" + String.valueOf(totalParcial) + "\n";
			totalGeral += totalParcial;
		}
		recibo += "Total: " + String.valueOf(totalGeral) + "\n";
		return recibo;
	}

}
