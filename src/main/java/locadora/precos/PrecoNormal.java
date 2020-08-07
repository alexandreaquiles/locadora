package locadora.precos;

public class PrecoNormal implements Preco {
    @Override
    public double calcula(int diasDeAluguel) {
        double valorNormal = 0.0;
        valorNormal += 2.0;
        if (diasDeAluguel > 2) {
            valorNormal += (diasDeAluguel - 2) * 1.5;
        }
        return valorNormal;
    }
}