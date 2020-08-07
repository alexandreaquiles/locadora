package locadora;

import locadora.precos.Preco;
import locadora.precos.PrecoInfantil;
import locadora.precos.PrecoLancamento;
import locadora.precos.PrecoNormal;

public enum Categoria {

    NORMAL(new PrecoNormal()),
    LANCAMENTO(new PrecoLancamento()),
    INFANTIL(new PrecoInfantil());

    private Preco preco;

    private Categoria(Preco preco) {
        this.preco = preco;
    }

    public Preco getPreco() {
        return preco;
    }
}
