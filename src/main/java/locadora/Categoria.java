package locadora;

public enum Categoria {

//    NORMAL() {
//        @Override
//        public double calcula(int diasDeAluguel){
//            double totalParcial = 0.0;
//            totalParcial += 2.0;
//            if (diasDeAluguel > 2) {
//                totalParcial += (diasDeAluguel - 2) * 1.5;
//            }
//            return totalParcial;
//        }
//    },
//    LANCAMENTO() {
//        @Override
//        public double calcula(int diasDeAluguel){
//            double totalParcial = 0.0;
//            totalParcial += diasDeAluguel * 3;
//            return totalParcial;
//        }
//    },
//    INFANTIL() {
//        @Override
//        public double calcula(int diasDeAluguel){
//            double totalParcial = 0.0;
//            totalParcial += 1.0;
//            if (diasDeAluguel > 3) {
//                totalParcial += (diasDeAluguel - 3) * 1.5;
//            }
//            return totalParcial;
//        }
//    };


    NORMAL(2.0, 2,  1.5),
    LANCAMENTO(0.0, 0,  3.0),
    INFANTIL(1, 3,  1.5);

    private final double custoFixo;
    private final int maximoDeDiasComCustoFixo;
    private final double taxaDeAcrescimo;

    Categoria(double custoFixo, int maximoDeDiasComCustoFixo, double taxaDeAcrescimo) {
        this.custoFixo = custoFixo;
        this.maximoDeDiasComCustoFixo = maximoDeDiasComCustoFixo;
        this.taxaDeAcrescimo = taxaDeAcrescimo;
    }

    public double calcula(int diasDeAluguel) {
        return this.custoFixo + Math.max(0, (diasDeAluguel - maximoDeDiasComCustoFixo) * taxaDeAcrescimo);
    }
}
