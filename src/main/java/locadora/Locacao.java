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

    public Categoria getCategoria(){
        return getFilme().getCategoria();
    }

    public String getTitulo(){
        return getFilme().getTitulo();
    }

    public double valorTotalDaLocacao(){
        return getCategoria().calculaValorTotal(this);
    }

}
