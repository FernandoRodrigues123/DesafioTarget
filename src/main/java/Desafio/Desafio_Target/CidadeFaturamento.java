package Desafio.Desafio_Target;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class CidadeFaturamento {
	private String cidade;
	private Double faturamento;
	private Double percentual;
	
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public Double getFaturamento() {
		return faturamento;
	}
	public void setFaturamento(Double faturamento) {
		this.faturamento = faturamento;
	}
	
	public Double getPercentual() {
		return percentual;
	}
	public void setPercentual(Double percentual) {
		this.percentual = percentual;
	}


	public static List<CidadeFaturamento> pegaDados(String caminho) throws IOException, ParseException {

		JSONParser parser = new JSONParser();
		
		List<CidadeFaturamento> list = new ArrayList<>();

		JSONArray array = (JSONArray) parser.parse(new FileReader(caminho));

		for (int i = 0; i < array.size(); i++) {
			
			//pega elemento do array e transforma em um objeto json
			JSONObject jsonObj = new JSONObject();
			jsonObj = (JSONObject) array.get(i); 

			CidadeFaturamento cidades =  new CidadeFaturamento();

			//transforma Object json em um CidadeFaturamento e adciona a uma lista
			cidades.setCidade(((String) jsonObj.get("cidade")));
			cidades.setFaturamento(((Double) jsonObj.get("faturamento")));

			list.add(cidades);

		}

		return list;
	}
	
	public static List<CidadeFaturamento> calculoPercentual() throws IOException, ParseException {
		List<CidadeFaturamento> cidadesFaturamento = pegaDados("src/main/resources/cidades.json");
		
		Double valorTotal = 0.0;
		
		
		for (CidadeFaturamento cidadeFaturamento : cidadesFaturamento) {
			valorTotal = valorTotal + cidadeFaturamento.getFaturamento();
		}
		
		for (CidadeFaturamento cidadeFaturamento : cidadesFaturamento) {
			Double faturamentento = cidadeFaturamento.getFaturamento();
			Double x = (faturamentento * 100)/valorTotal;
			
			cidadeFaturamento.setPercentual(x);
		}
		
		return cidadesFaturamento;
		
	}
}
