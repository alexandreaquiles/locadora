package locadora.builder;

import java.util.ArrayList;
import java.util.List;

import locadora.Cliente;

public class ClienteBuilder {

    private Cliente cliente;
    private List<LocacaoBuilder> locacoes = new ArrayList<>();

    private ClienteBuilder(Cliente cliente) {
        this.cliente = cliente;
    }

    public static ClienteBuilder umCliente() {
        return new ClienteBuilder(new Cliente());
    }

    public ClienteBuilder chamado(String nome) {
        this.cliente.setNome(nome);
        return this;
    }

    public ClienteBuilder com(LocacaoBuilder locacao) {
        this.locacoes.add(locacao);
        return this;
    }

    public Cliente build() {
        for (LocacaoBuilder locacao : locacoes) {
            this.cliente.aluga(locacao.build());
        }
        return this.cliente;
    }

}
