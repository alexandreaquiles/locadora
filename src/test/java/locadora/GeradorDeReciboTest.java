package locadora;

import static locadora.builder.ClienteBuilder.umCliente;
import static locadora.builder.FilmeBuilder.umFilme;
import static locadora.builder.LocacaoBuilder.umaLocacao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GeradorDeReciboTest {

    @Test
    public void filmeNormalIntervaloCurto() {
        Cliente cliente = umCliente().chamado("Fulano")
                .com(umaLocacao().curta(2)
                        .de(umFilme().chamado("De Volta para o Futuro")))
                .build();

        GeradorDeRecibo geradorDeRecibo = new GeradorDeRecibo();

        String recibo = geradorDeRecibo.gera(cliente);

        Assertions.assertEquals("Recibo para Fulano:\nDe Volta para o Futuro\t2.0\nTotal: 2.0\n", recibo);
    }

    @Test
    public void filmeNormalIntervaloLongo() {
        Cliente cliente = umCliente().chamado("Fulano")
                .com(umaLocacao().longa(3)
                        .de(umFilme().chamado("De Volta para o Futuro")))
                .build();

        GeradorDeRecibo geradorDeRecibo = new GeradorDeRecibo();

        String recibo = geradorDeRecibo.gera(cliente);

        Assertions.assertEquals("Recibo para Fulano:\nDe Volta para o Futuro\t3.5\nTotal: 3.5\n", recibo);
    }

    @Test
    public void filmeLancamento() {
        Cliente cliente = umCliente().chamado("Fulano")
                .com(umaLocacao()
                        .de(umFilme().lancamento().chamado("Chappie")))
                .build();

        GeradorDeRecibo geradorDeRecibo = new GeradorDeRecibo();

        String recibo = geradorDeRecibo.gera(cliente);

        Assertions.assertEquals("Recibo para Fulano:\nChappie\t9.0\nTotal: 9.0\n", recibo);
    }

    @Test
    public void filmeInfantilIntervaloCurto() {
        Cliente cliente = umCliente().chamado("Fulano")
                .com(umaLocacao().curta(3)
                        .de(umFilme().infantil().chamado("Galinha Pintadinha")))
                .build();

        GeradorDeRecibo geradorDeRecibo = new GeradorDeRecibo();

        String recibo = geradorDeRecibo.gera(cliente);

        Assertions.assertEquals("Recibo para Fulano:\nGalinha Pintadinha\t1.0\nTotal: 1.0\n", recibo);
    }

    @Test
    public void filmeInfantilIntervaloLongo() {
        Cliente cliente = umCliente().chamado("Fulano")
                .com(umaLocacao().longa(5)
                        .de(umFilme().infantil().chamado("Galinha Pintadinha")))
                .build();

        GeradorDeRecibo geradorDeRecibo = new GeradorDeRecibo();

        String recibo = geradorDeRecibo.gera(cliente);

        Assertions.assertEquals("Recibo para Fulano:\nGalinha Pintadinha\t4.0\nTotal: 4.0\n", recibo);
    }

}
