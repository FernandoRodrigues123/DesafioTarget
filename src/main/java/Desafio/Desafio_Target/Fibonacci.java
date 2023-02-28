package Desafio.Desafio_Target;

public class Fibonacci {
	public static void fibonacci(int numeroHaVerificar) {

		int a = 1;
		int b = 2;
		int c = 0;

		for (int i = 0; i <= numeroHaVerificar; i++) {

			c = a + b;

			if (c == numeroHaVerificar || numeroHaVerificar == 0 || numeroHaVerificar == 1 || numeroHaVerificar == 2) {
				System.out.println(numeroHaVerificar + " esta na sequencia de fibonacci");
				break;
			} else if (i == numeroHaVerificar) {
				System.out.println(numeroHaVerificar + " nao esta na sequencia de fibonacci");
			}

			a = b;
			b = c;
		}
	}

}
