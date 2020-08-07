package locadora;

import java.util.List;
import java.util.stream.Collectors;

public class Recibo {

    private Cliente cliente;

    public Recibo(Cliente cliente){
        this.cliente = cliente;
    }

    public String emTexto(){
        String texto = "Recibo para " + cliente.getNome() + ":\n";
        List<DetalheDoRecibo> detalheDoRecibos = valorTotalDaLocacao();

        double totalGeral = detalheDoRecibos.stream()
                .mapToDouble(DetalheDoRecibo::getValorTotal)
                .sum();

        texto += detalheDoRecibos
                .stream()
                .map(DetalheDoRecibo::getDescricao)
                .collect(Collectors.joining());

        texto += "Total: " + String.valueOf(totalGeral) + "\n";
        return texto;
    }

    public List<DetalheDoRecibo> valorTotalDaLocacao(){
        return this.cliente.getLocacoes()
                .stream()
                .map(DetalheDoRecibo::new)
                .collect(Collectors.toList());
    }
}
