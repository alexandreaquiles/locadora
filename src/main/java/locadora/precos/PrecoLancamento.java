package locadora.precos;

public class PrecoLancamento implements Preco {
    @Override
    public double calcula(int diasDeAluguel) {
        double valorLancamento = 0.0;
        valorLancamento += diasDeAluguel * 3;
        return valorLancamento;
    }
}