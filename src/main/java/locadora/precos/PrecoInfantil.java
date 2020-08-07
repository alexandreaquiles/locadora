package locadora.precos;

public class PrecoInfantil implements Preco {
    @Override
    public double calcula(int diasDeAluguel) {
        double valorInfantil = 0.0;
        valorInfantil += 1.0;
        if (diasDeAluguel > 3) {
            valorInfantil += (diasDeAluguel - 3) * 1.5;
        }
        return valorInfantil;
    }
}