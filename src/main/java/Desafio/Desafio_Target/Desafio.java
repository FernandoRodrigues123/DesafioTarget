package Desafio.Desafio_Target;

import java.util.List;

public class Desafio {

	public static void main(String[] args) throws Exception {

		System.out.println("desfio 2:");
		Fibonacci.fibonacci(2584);// verificando um numero que esta na sequencia de fibonacci
		Fibonacci.fibonacci(2585);// verificando um numero que NÃo esta na sequencia de fibonacci

		System.out.println("\n\ndesfio 3:");

		System.out.println("dia com o menor faturamento: " + Faturamento.pegaMenorFaturamento());
		System.out.println("dia com o maior faturamento: " + Faturamento.pegaMaiorFaturamento());

		List<Faturamento> diasComRendaSuperiorMedia = Faturamento.diasComRendaSuperiorMedia();// pega lista de dias com
																								// faturamento maior que
																								// a media
		Double MediaMensal = Faturamento.faturamentoMediaMensal();

		System.out.println("\ndias com o faturamento acima da media mensal de: " + MediaMensal);
		for (Faturamento faturamento : diasComRendaSuperiorMedia) {
			System.out.println("\n" + faturamento);
		}

		System.out.println("\n\ndesfio 4:");
		System.out.println("percentual de cada cidade da distribuidora ARREDONDADOS" + ": \n");
		List<CidadeFaturamento> calculoPercentual = CidadeFaturamento.calculoPercentual();
		for (CidadeFaturamento cidadeFaturamento : calculoPercentual) {
			System.out.println(
					cidadeFaturamento.getCidade() + ":  " + Math.round(cidadeFaturamento.getPercentual()) + "%");

		}

		System.out.println("\n\ndesfio 5:");
		System.out.println(InversorDeString.inversor("aeiou"));

	}

}