package locadora;


import locadora.precos.Preco;
import locadora.precos.PrecoInfantil;
import locadora.precos.PrecoLancamento;
import locadora.precos.PrecoNormal;

public class Filme {

    private String titulo;
    private Categoria categoria;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    double calculaValorLocacao(int diasDeAluguel) {
        return categoria.getPreco().calcula(diasDeAluguel);
    }

}
