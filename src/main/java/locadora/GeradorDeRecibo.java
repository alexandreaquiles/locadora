package locadora;

public class GeradorDeRecibo {

    public String gera(Cliente cliente) {
        Recibo recibo = new Recibo(cliente);
        return recibo.emTexto();
    }
}
