package locadora;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class Recibo {

    private String nomeDoCliente;
    private List<ReciboItem> reciboItens;
    private double total;

    public Recibo(Cliente cliente) {
        this.nomeDoCliente = cliente.getNome();
        this.reciboItens = cliente.getLocacoes().stream().map(c -> new ReciboItem(c.getTitulo(), c.getCustoFixo())).collect(toList());
        this.total = cliente.getTotalGeralLocacoes();
    }

    public String paraTexto() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Recibo para " + nomeDoCliente + ":\n");
        reciboItens.stream().map(item -> item.getTitulo() + "\t" + String.valueOf(item.getCustiFixo()) + "\n").forEach(stringBuilder::append);
        stringBuilder.append("Total: " + String.valueOf(total) + "\n");
        return stringBuilder.toString();
    }
}
