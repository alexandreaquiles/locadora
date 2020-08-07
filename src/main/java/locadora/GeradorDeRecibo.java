package locadora;

public class GeradorDeRecibo {

    public String gera(Cliente cliente) {
        return new Recibo(cliente).paraTexto();
    }

}
