package locadora.builder;

import locadora.Locacao;

public class LocacaoBuilder {

    private Locacao locacao;
    private FilmeBuilder filme;

    private LocacaoBuilder(Locacao locacao) {
        this.locacao = locacao;
    }

    public static LocacaoBuilder umaLocacao() {
        return new LocacaoBuilder(new Locacao());
    }

    public LocacaoBuilder comDuracaoMinima() {
        locacao.setDiasDeAluguel(1);
        return this;
    }

    public LocacaoBuilder comDuracaoEmDias(int dias) {
        locacao.setDiasDeAluguel(dias);
        return this;
    }

    public LocacaoBuilder comDuracaoMenorQueOValorLimite(int dias) {
        locacao.setDiasDeAluguel(dias);
        return this;
    }

    public LocacaoBuilder comDuracaoNoValorLimite(int dias) {
        locacao.setDiasDeAluguel(dias);
        return this;
    }

    public LocacaoBuilder comDuracaoMaiorQueOValorLimite(int dias) {
        locacao.setDiasDeAluguel(dias);
        return this;
    }

    public LocacaoBuilder de(FilmeBuilder filme) {
        this.filme = filme;
        return this;
    }

    public Locacao build() {
        assert locacao.getDiasDeAluguel() > 0;
        locacao.setFilme(filme.build());
        return this.locacao;
    }

}
