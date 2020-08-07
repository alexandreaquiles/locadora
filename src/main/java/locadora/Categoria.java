package locadora;

public enum Categoria {
    NORMAL(2.0, 2, 1.5),
    LANCAMENTO(0.0, 0, 3.0),
    INFANTIL(1.0, 3, 1.5);

    private final double valorInicial;
    private final int dias;
    private final double multiplicador;

    Categoria(double valorInicial, int dias, double multiplicador) {
        this.valorInicial = valorInicial;
        this.dias = dias;
        this.multiplicador = multiplicador;
    }

    public double calcula(int diasDeAluguel) {
        return valorInicial + Math.max(0, (diasDeAluguel - dias) * multiplicador);
    }
}
