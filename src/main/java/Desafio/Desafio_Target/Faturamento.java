package Desafio.Desafio_Target;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Faturamento {

	private Long diaDoMes;
	private Double valorFaturado;

	public Long getDiaDoMes() {
		return diaDoMes;
	}

	public void setDiaDoMes(Long diaDoMes) {
		this.diaDoMes = diaDoMes;
	}

	public Double getValorFaturado() {
		return valorFaturado;
	}

	public void setValorFaturado(Double valorFaturado) {
		this.valorFaturado = valorFaturado;
	}

	public List<Faturamento> pegaDados(String caminho) throws IOException, ParseException {
		JSONParser parser = new JSONParser();
		List<Faturamento> list = new ArrayList<>();

		JSONArray array = (JSONArray) parser.parse(new FileReader(caminho));

		for (int i = 0; i < array.size(); i++) {
			JSONObject jsonObj = new JSONObject();
			jsonObj = (JSONObject) array.get(i);

			Faturamento faturamento = new Faturamento();

			faturamento.setDiaDoMes((Long) jsonObj.get("dia"));
			faturamento.setValorFaturado((Double) jsonObj.get("valor"));

			list.add(faturamento);

		}

		return list;

	}

	public static Double faturamentoMediaMensal() throws IOException, ParseException {
		List<Faturamento> dados = new Faturamento().pegaDados("src/main/resources/dados.json");

		Double media, valorBrutoMensal = 0.0;
		Long dia = 1l;

		for (Faturamento faturamento : dados) {

			if (faturamento.getValorFaturado() != 0.0) {
				valorBrutoMensal = valorBrutoMensal + faturamento.getValorFaturado();
				dia++;
			} else {
				dia--;
			}

		}
		media = valorBrutoMensal / dia;
		return media;
	}

	public static Faturamento pegaMenorFaturamento() throws IOException, ParseException {
		List<Faturamento> dados = new Faturamento().pegaDados("src/main/resources/dados.json");
		List<Double> valores = new ArrayList<>();
		Faturamento menorFaturamento = new Faturamento();
		Double min = 0.0;
		Long dia = 0l;

		for (Faturamento faturamento : dados) {
			if (faturamento.getValorFaturado() != 0.0) {
				valores.add(faturamento.getValorFaturado());
			}
		}

		min = Collections.min(valores);

		for (Faturamento faturamento2 : dados) {

			if (faturamento2.getValorFaturado() == min) {
				dia = faturamento2.getDiaDoMes();
			}
		}

		menorFaturamento.setDiaDoMes(dia);
		menorFaturamento.setValorFaturado(min);

		
		return menorFaturamento;

	}
	

	public static Faturamento pegaMaiorFaturamento() throws IOException, ParseException {
		List<Faturamento> dados = new Faturamento().pegaDados("src/main/resources/dados.json");
		List<Double> valores = new ArrayList<>();
		
		Faturamento menorFaturamento = new Faturamento();
		Double max = 0.0;
		Long dia = 0l;

		for (Faturamento faturamento : dados) {
			if (faturamento.getValorFaturado() != 0.0) {
				valores.add(faturamento.getValorFaturado());
			}
		}

		max = Collections.max(valores);

		for (Faturamento faturamento2 : dados) {

			if (faturamento2.getValorFaturado() == max) {
				dia = faturamento2.getDiaDoMes();
			}
		}

		menorFaturamento.setDiaDoMes(dia);
		menorFaturamento.setValorFaturado(max);

		
		return menorFaturamento;

	}
	
	public static List<Faturamento> diasComRendaSuperiorMedia() throws IOException, ParseException {
		List<Faturamento> dados = new Faturamento().pegaDados("src/main/resources/dados.json");
		Double MediaMensal = faturamentoMediaMensal();
		
		List<Faturamento> faturamentoAcimaDaMedia = new ArrayList<>();
		
		for (Faturamento faturamento : dados) {
			if(faturamento.getValorFaturado() > MediaMensal) {
				
				faturamentoAcimaDaMedia.add(faturamento);
			}
		}
		return faturamentoAcimaDaMedia;
		
	}
	
	@Override
 	public String toString() {
		return "Faturamento diaDoMes: " + diaDoMes + ", valorFaturado: " + valorFaturado;
	}

}
