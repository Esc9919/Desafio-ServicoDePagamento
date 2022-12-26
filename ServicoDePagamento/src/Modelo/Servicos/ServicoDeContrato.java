package Modelo.Servicos;

import java.time.LocalDate;

import Modelo.Entidades.Contrato;
import Modelo.Entidades.Parcela;

public class ServicoDeContrato {

	private ServicoDePagamentoOnline servicoDePagamento;
	
	public ServicoDeContrato(ServicoDePagamentoOnline servicoDePagamento) {
		this.servicoDePagamento = servicoDePagamento;
	}

	public void processoDeContrato(Contrato contrato, Integer meses) {
		
		double quotaBasica = contrato.getValorTotal() / meses;
		
		for (int i=1; i <= meses; i++) {
			LocalDate venciData = contrato.getData().plusMonths(i);
			
			double juros = servicoDePagamento.juros(quotaBasica, i);
			double taxa = servicoDePagamento.taxaDePagamento(quotaBasica + juros);
			double quota = quotaBasica + juros + taxa;
			
			contrato.getParcela().add(new Parcela(venciData, quota));
			
		}
		
	}
	
}
