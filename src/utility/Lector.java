/*
 * Fecha: 29/10/2021
 *
 * @author Edu
 *
 * @version: 2.0
 */

package utility;

import java.util.Scanner;

import view.Escritor;

public class Lector {

	static Scanner sn = new Scanner(System.in, "ISO-8859-1");

	@SuppressWarnings("resource")
	public static String str(String msg) {
		Escritor.string(msg);
		return new Scanner(System.in).nextLine();
	}

	public static int pedirInt() {
		while (sn.hasNextInt() == false) {
			Escritor.string("debes introducir un entero, vuelve a intentarlo");
			sn.next();
		}
		return sn.nextInt();
	}

	public static double pedirDouble() {
		while (sn.hasNextDouble() == false) {
			Escritor.string("debes introducir un n�mero, vuelve a intentarlo");
			sn.next();
		}
		return sn.nextDouble();
	}

	public static int pedirInt(String msg) {
		Escritor.string(msg);
		while (sn.hasNextInt() == false) {
			Escritor.string(msg);
			sn.next();
		}
		return sn.nextInt();
	}

	public static double pedirDouble(String msg) {
		Escritor.string(msg);
		while (sn.hasNextDouble() == false) {
			Escritor.string(msg);
			sn.next();
		}
		return sn.nextDouble();
	}

	public static int pedirIntEntre(int a, int b) {
		boolean salir = false;
		int x = 0;
		while (!salir) {
			System.out.println("Dame un entero entre " + a + " y " + b);
			x = Lector.pedirInt();
			if (x >= a && x <= b) {
				salir = true;
			}
		}
		return x;
	}

	public static int pedirIntEntre(int a, int b, String msg) {
		boolean salir = false;
		int x = 0;
		while (!salir) {
			Escritor.string(msg);
			x = Lector.pedirInt();
			if (x >= a && x <= b) {
				salir = true;
			}
		}
		return x;
	}

	public static double pedirDoubleEntre(int a, int b) {
		boolean salir = false;
		double x = 0;
		while (!salir) {
			System.out.println("Dame un n�mero entre " + a + " y " + b);
			x = Lector.pedirDouble();
			if (x >= a && x <= b) {
				salir = true;
			}
		}
		return x;
	}

	public static short pedirShortEntre(int a, int b, String msg) {
		boolean salir = false;
		short x = 0;
		while (!salir) {
			Escritor.string(msg);
			x = (short) Lector.pedirInt();
			if (x >= a && x <= b) {
				salir = true;
			}
		}
		return x;
	}

	public static boolean preguntarSiNo(String pregunta, String respuestaSi, String respuestaNo) {
		String respuesta = Lector.str(pregunta);
		return respuesta.equals(respuestaSi) ? true : false;
	}

}
