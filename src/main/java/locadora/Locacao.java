package locadora;

public class Locacao {

    private Filme filme;
    private int diasDeAluguel;

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public int getDiasDeAluguel() {
        return diasDeAluguel;
    }

    public void setDiasDeAluguel(int diasDeAluguel) {
        this.diasDeAluguel = diasDeAluguel;
    }

    public double getCustoFixo() {
        return filme.getCategoria().calcula(diasDeAluguel);
    }

    public String getTitulo() {
        return filme.getTitulo();
    }

}
