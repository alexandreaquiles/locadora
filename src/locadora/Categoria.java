package locadora;

import locadora.preco.Preco;
import locadora.preco.PrecoInfantil;
import locadora.preco.PrecoLancamento;
import locadora.preco.PrecoNormal;

public enum Categoria {
	NORMAL(new PrecoNormal()),
	LANCAMENTO(new PrecoLancamento()),
	INFANTIL(new PrecoInfantil());
	
	private final Preco preco;
	
	private Categoria(Preco preco) {
		this.preco = preco;
	}

	public Preco getPreco() {
		return preco;
	}
	
	
}
