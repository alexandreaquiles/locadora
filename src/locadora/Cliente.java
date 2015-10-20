package locadora;

import java.util.ArrayList;
import java.util.List;

public class Cliente {

	private String nome;
	private List<Locacao> locacoes = new ArrayList<>();

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Locacao> getLocacoes() {
		return locacoes;
	}

	public void aluga(Locacao locacao) {
		this.locacoes.add(locacao);
	}

}
