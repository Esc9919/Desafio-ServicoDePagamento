package Modelo.Servicos;

public class ServicoPaypal implements ServicoDePagamentoOnline {

	@Override
	public Double taxaDePagamento(Double quantia) {
		return quantia * 0.02;
	}

	@Override
	public Double juros(Double quantia, Integer meses) {
		return quantia * 0.01 * meses;
	}

	
	
}
