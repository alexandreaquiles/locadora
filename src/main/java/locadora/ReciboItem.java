package locadora;

public class ReciboItem {

    private String titulo;
    private double custiFixo;

    public ReciboItem(String titulo, double custiFixo) {
        this.titulo = titulo;
        this.custiFixo = custiFixo;
    }

    public String getTitulo() {
        return titulo;
    }

    public double getCustiFixo() {
        return custiFixo;
    }
}
