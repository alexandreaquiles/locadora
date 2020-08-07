package locadora;

public class DetalheDoRecibo {
    private String descricao;
    private double valorTotal;

    public DetalheDoRecibo(Locacao locacao){
        this.valorTotal = locacao.valorTotalDaLocacao();
        this.descricao =  locacao.getTitulo() + "\t" + String.valueOf(valorTotal) + "\n";
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
}
