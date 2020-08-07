package locadora;

public enum Categoria {
    NORMAL{
        @Override
        public double calculaValorTotal(Locacao locacao) {
            double totalParcial = 2.0;
            if (locacao.getDiasDeAluguel() > 2) {
                totalParcial += (locacao.getDiasDeAluguel() - 2) * 1.5;
            }
            return totalParcial;
        }
    },
    LANCAMENTO{
        @Override
        public double calculaValorTotal(Locacao locacao) {
           return locacao.getDiasDeAluguel() * 3;
        }
    },
    INFANTIL{
        @Override
        public double calculaValorTotal(Locacao locacao) {
           double totalParcial = 1.0;
            if (locacao.getDiasDeAluguel() > 3) {
                totalParcial += (locacao.getDiasDeAluguel() - 3) * 1.5;
            }
            return totalParcial;
        }
    };

    public abstract double calculaValorTotal(Locacao locacao);
}
