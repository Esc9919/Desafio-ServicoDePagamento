package Modelo.Servicos;

public interface ServicoDePagamentoOnline {

	Double taxaDePagamento(Double quantia);
	
	Double juros(Double quantia, Integer meses);
	
}
