/*
 * Fecha: 16/03/2021 y 22/03/2021
 * 
 * @author Andrei, Mar�a y Edu
 * 
 * @version 1.0
 */

package tools;

import java.util.Scanner;

public class Lector {

	static Scanner sn = new Scanner(System.in, "ISO-8859-1");

	@SuppressWarnings("resource")
	public static String str(String msg) {
		Escritor.str(msg);
		return new Scanner(System.in).nextLine();
	}

	public static int pedirInt() {
		while (sn.hasNextInt() == false) {
			Escritor.str("debes introducir un entero, vuelve a intentarlo");
			sn.next();
		}
		return sn.nextInt();
	}

	public static double pedirDouble() {
		while (sn.hasNextDouble() == false) {
			Escritor.str("debes introducir un n�mero, vuelve a intentarlo");
			sn.next();
		}
		return sn.nextDouble();
	}

	public static int pedirInt(String msg) {
		Escritor.str(msg);
		while (sn.hasNextInt() == false) {
			Escritor.str(msg);
			sn.next();
		}
		return sn.nextInt();
	}

	public static double pedirDouble(String msg) {
		Escritor.str(msg);
		while (sn.hasNextDouble() == false) {
			Escritor.str(msg);
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
			Escritor.str(msg);
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
			Escritor.str(msg);
			x = (short) Lector.pedirInt();
			if (x >= a && x <= b) {
				salir = true;
			}
		}
		return x;
	}

}
