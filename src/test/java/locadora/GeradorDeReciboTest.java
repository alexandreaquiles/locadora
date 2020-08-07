package locadora;

import static locadora.builder.ClienteBuilder.umCliente;
import static locadora.builder.FilmeBuilder.umFilme;
import static locadora.builder.LocacaoBuilder.umaLocacao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GeradorDeReciboTest {

    @Test
    @DisplayName("Locação de filme NORMAL com duração MÍNIMA (1 dia) tem custo fixo")
    public void minimaPraNormalDeveTerCustoFixo() {
        Cliente cliente = umCliente().chamado("Fulano")
                .com(umaLocacao().comDuracaoMinima()
                        .de(umFilme().chamado("De Volta para o Futuro")))
                .build();

        GeradorDeRecibo geradorDeRecibo = new GeradorDeRecibo();

        String recibo = geradorDeRecibo.gera(cliente);

        Assertions.assertEquals("Recibo para Fulano:\nDe Volta para o Futuro\t2.0\nTotal: 2.0\n", recibo);
    }

    @Test
    @DisplayName("Locação de filme NORMAL com duração CURTA no valor limite ainda tem custo fixo")
    public void curtaPraNormalDeveTerCustoFixo() {
        Cliente cliente = umCliente().chamado("Fulano")
                .com(umaLocacao().comDuracaoNoValorLimite(2)
                        .de(umFilme().chamado("De Volta para o Futuro")))
                .build();

        GeradorDeRecibo geradorDeRecibo = new GeradorDeRecibo();

        String recibo = geradorDeRecibo.gera(cliente);

        Assertions.assertEquals("Recibo para Fulano:\nDe Volta para o Futuro\t2.0\nTotal: 2.0\n", recibo);
    }

    @Test
    @DisplayName("Locação de filme NORMAL com duração LONGA tem acréscimo por dia")
    public void longaPraNormalDeveTerCustoPorDia() {
        Cliente cliente = umCliente().chamado("Fulano")
                .com(umaLocacao().comDuracaoMaiorQueOValorLimite(3)
                        .de(umFilme().chamado("De Volta para o Futuro")))
                .build();

        GeradorDeRecibo geradorDeRecibo = new GeradorDeRecibo();

        String recibo = geradorDeRecibo.gera(cliente);

        Assertions.assertEquals("Recibo para Fulano:\nDe Volta para o Futuro\t3.5\nTotal: 3.5\n", recibo);
    }

    @Test
    @DisplayName("Locação de LANÇAMENTO com duração MÍNIMA (1 dia) tem custo por dia")
    public void minimaPraLancamentoDeveTerCustoPorDia() {
        Cliente cliente = umCliente().chamado("Fulano")
                .com(umaLocacao().comDuracaoMinima()
                        .de(umFilme().lancamento().chamado("Rocky XV")))
                .build();

        GeradorDeRecibo geradorDeRecibo = new GeradorDeRecibo();

        String recibo = geradorDeRecibo.gera(cliente);

        Assertions.assertEquals("Recibo para Fulano:\nRocky XV\t3.0\nTotal: 3.0\n", recibo);
    }

    @Test
    @DisplayName("Locação de LANÇAMENTO com duração CURTA tem custo por dia")
    public void curtaPraLancamentoDeveTerCustoPorDia() {
        Cliente cliente = umCliente().chamado("Fulano")
                .com(umaLocacao().comDuracaoEmDias(2)
                        .de(umFilme().lancamento().chamado("Rocky XV")))
                .build();

        GeradorDeRecibo geradorDeRecibo = new GeradorDeRecibo();

        String recibo = geradorDeRecibo.gera(cliente);

        Assertions.assertEquals("Recibo para Fulano:\nRocky XV\t6.0\nTotal: 6.0\n", recibo);
    }

    @Test
    @DisplayName("Locação de LANÇAMENTO com duração LONGA tem custo por dia")
    public void longaPraLancamentoDeveTerCustoPorDia() {
        Cliente cliente = umCliente().chamado("Fulano")
                .com(umaLocacao().comDuracaoEmDias(3)
                        .de(umFilme().lancamento().chamado("Rocky XV")))
                .build();

        GeradorDeRecibo geradorDeRecibo = new GeradorDeRecibo();

        String recibo = geradorDeRecibo.gera(cliente);

        Assertions.assertEquals("Recibo para Fulano:\nRocky XV\t9.0\nTotal: 9.0\n", recibo);
    }

    @Test
    @DisplayName("Locação de filme INFANTIL com duração MÍNIMA (1 dia) tem custo fixo")
    public void minimaPraInfantilDeveTerCustoFixo() {
        Cliente cliente = umCliente().chamado("Fulano")
                .com(umaLocacao().comDuracaoMinima()
                        .de(umFilme().infantil().chamado("Galinha Pintadinha")))
                .build();

        GeradorDeRecibo geradorDeRecibo = new GeradorDeRecibo();

        String recibo = geradorDeRecibo.gera(cliente);

        Assertions.assertEquals("Recibo para Fulano:\nGalinha Pintadinha\t1.0\nTotal: 1.0\n", recibo);
    }

    @Test
    @DisplayName("Locação de filme INFANTIL com duração CURTA tem custo fixo")
    public void curtaPraInfantilDeveTerCustoFixo() {
        Cliente cliente = umCliente().chamado("Fulano")
                .com(umaLocacao().comDuracaoMenorQueOValorLimite(2)
                        .de(umFilme().infantil().chamado("Galinha Pintadinha")))
                .build();

        GeradorDeRecibo geradorDeRecibo = new GeradorDeRecibo();

        String recibo = geradorDeRecibo.gera(cliente);

        Assertions.assertEquals("Recibo para Fulano:\nGalinha Pintadinha\t1.0\nTotal: 1.0\n", recibo);
    }

    @Test
    @DisplayName("Locação de filme INFANTIL com duração CURTA no valor limite tem custo fixo")
    public void curtaNoLimitePraInfantilDeveTerCustoFixo() {
        Cliente cliente = umCliente().chamado("Fulano")
                .com(umaLocacao().comDuracaoNoValorLimite(3)
                        .de(umFilme().infantil().chamado("Galinha Pintadinha")))
                .build();

        GeradorDeRecibo geradorDeRecibo = new GeradorDeRecibo();

        String recibo = geradorDeRecibo.gera(cliente);

        Assertions.assertEquals("Recibo para Fulano:\nGalinha Pintadinha\t1.0\nTotal: 1.0\n", recibo);
    }

    @Test
    @DisplayName("Locação de filme INFANTIL com duração LONGA tem acréscimo por dia")
    public void longaPraInfantilDeveTerCustoPorDia() {
        Cliente cliente = umCliente().chamado("Fulano")
                .com(umaLocacao().comDuracaoMaiorQueOValorLimite(5)
                        .de(umFilme().infantil().chamado("Galinha Pintadinha")))
                .build();

        GeradorDeRecibo geradorDeRecibo = new GeradorDeRecibo();

        String recibo = geradorDeRecibo.gera(cliente);

        Assertions.assertEquals("Recibo para Fulano:\nGalinha Pintadinha\t4.0\nTotal: 4.0\n", recibo);
    }

    @Test
    @DisplayName("Mais de uma locação deve usar regras apropriadas")
    public void multiplasLocacoes() {
        Cliente cliente = umCliente().chamado("Fulano")
                .com(umaLocacao().comDuracaoMinima()
                        .de(umFilme().chamado("De Volta para o Futuro")))
                .com(umaLocacao().comDuracaoMinima()
                        .de(umFilme().lancamento().chamado("Rocky XV")))
                .build();

        GeradorDeRecibo geradorDeRecibo = new GeradorDeRecibo();

        String recibo = geradorDeRecibo.gera(cliente);

        Assertions.assertEquals("Recibo para Fulano:" +
                "\nDe Volta para o Futuro\t2.0" +
                "\nRocky XV\t3.0" +
                "\nTotal: 5.0\n", recibo);
    }

}
