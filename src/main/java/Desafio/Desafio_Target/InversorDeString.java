package Desafio.Desafio_Target;

public class InversorDeString {

	public static String inversor(String texto) {

		String result = "";
		int n = texto.length() - 1;
	
		for (int i = n; i >= 0; i--) {
			result = result + texto.charAt(i);
		}

		return result;
	}

}
