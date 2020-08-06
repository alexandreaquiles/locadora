package locadora;

public class GeradorDeRecibo {

    public String gera(Cliente cliente) {
        double totalGeral = 0.0;
        String recibo = "Recibo para " + cliente.getNome() + ":\n";
        for (Locacao locacao : cliente.getLocacoes()) {
            double totalParcial = 0.0;
            switch (locacao.getFilme().getCategoria()) {
                case NORMAL:
                    totalParcial += 2.0;
                    if (locacao.getDiasDeAluguel() > 2) {
                        totalParcial += (locacao.getDiasDeAluguel() - 2) * 1.5;
                    }
                    break;
                case LANCAMENTO:
                    totalParcial += locacao.getDiasDeAluguel() * 3;
                    break;
                case INFANTIL:
                    totalParcial += 1.0;
                    if (locacao.getDiasDeAluguel() > 3) {
                        totalParcial += (locacao.getDiasDeAluguel() - 3) * 1.5;
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
