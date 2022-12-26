package Aplicacao;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import Modelo.Entidades.Contrato;
import Modelo.Entidades.Parcela;
import Modelo.Servicos.ServicoDeContrato;
import Modelo.Servicos.ServicoPaypal;

public class Programa {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		System.out.println("Entre com os dados do contrato:");
		System.out.print("Numero: ");
		int numero = sc.nextInt();
		System.out.print("Data (dd/MM/aaaa): ");
		LocalDate data = LocalDate.parse(sc.next(), fmt);
		System.out.print("Valor do contrato: ");
		double valorTotal = sc.nextDouble();
		
		Contrato contrato = new Contrato(numero, data, valorTotal);
		
		System.out.print ("Entre com o numero de parcelas: ");
		int n = sc.nextInt();
		
		ServicoDeContrato servicoDeContrato =  new ServicoDeContrato(new ServicoPaypal());
		
		servicoDeContrato.processoDeContrato(contrato, n);
		
		System.out.println("PARCELAS:");

		for (Parcela parcela : contrato.getParcela()) {
			System.out.println(parcela);
		}
		
		sc.close();
	}

}
