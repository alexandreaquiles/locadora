package locadora.builder;

import locadora.Locacao;

public class LocacaoBuilder {

    private Locacao locacao;
    private FilmeBuilder filme;

    private LocacaoBuilder(Locacao locacao) {
        this.locacao = locacao;
        this.locacao.setDiasDeAluguel(3);
    }

    public static LocacaoBuilder umaLocacao() {
        return new LocacaoBuilder(new Locacao());
    }

    public LocacaoBuilder curta(int dias) {
        locacao.setDiasDeAluguel(dias);
        return this;
    }

    public LocacaoBuilder longa(int dias) {
        locacao.setDiasDeAluguel(dias);
        return this;
    }

    public LocacaoBuilder de(FilmeBuilder filme) {
        this.filme = filme;
        return this;
    }

    public Locacao build() {
        locacao.setFilme(filme.build());
        return this.locacao;
    }

}
