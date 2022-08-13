/*
 * Fecha: 29/10/2021
 *
 * @author Edu
 *
 * @version: 2.0
 */

package view;

public class Menu {

	public static void principal() {
		MostrarDato.string("\n********** MEN� PRINCIPAL **********\n");
		MostrarDato.string("1. Gestionar Usuarios");
		MostrarDato.string("2. Gestionar Pel�culas");
		MostrarDato.string("3. Salir del programa");
	}

	public static void usuarios() {
		MostrarDato.string("\n********** GESTI�N DE USUARIOS **********\n");
		MostrarDato.string("1. Listar todos los usuarios");
		MostrarDato.string("2. A�adir un usuario");
		MostrarDato.string("3. Eliminar un usuario");
		MostrarDato.string("4. Modificar un usuario");
		MostrarDato.string("5. Volver al men� principal");
	}

	public static void modificarUsuario() {
		MostrarDato.string("\n********** MODIFICAR USUARIO **********\n");
		MostrarDato.string("1. Nombre");
		MostrarDato.string("2. Ciudad de residencia");
		MostrarDato.string("3. Fecha de nacimiento");
	}

	public static void peliculas() {
		MostrarDato.string("\n********** GESTI�N DE PEL�CULAS **********\n");
		MostrarDato.string("1. Listar todas las pel�culas");
		MostrarDato.string("2. A�adir una pel�cula");
		MostrarDato.string("3. Eliminar una pel�cula");
		MostrarDato.string("4. Modificar una pel�cula");
		MostrarDato.string("5. Filtrar pel�culas por categor�a");
		MostrarDato.string("6. Mostrar las pel�culas m�s valoradas");
		MostrarDato.string("7. Mostrar las pel�culas cuya valoraci�n est� por encima de la media");
		MostrarDato.string("8. Mostrar las pel�culas peor valoradas");
		MostrarDato.string("9. Mostrar las pel�culas m�s vistas");
		MostrarDato.string("10. Volver al men� principal");
	}

	public static void modificarPelicula() {
		MostrarDato.string("\n********** MODIFICAR PEL�CULA **********\n");
		MostrarDato.string("1. T�tulo");
		MostrarDato.string("2. A�o");
		MostrarDato.string("3. Categor�a");
	}

	public static void categorias() {
		MostrarDato.string("\n********** CATEGOR�AS **********\n");
		MostrarDato.string("1. Policiaca");
		MostrarDato.string("2. Rom�ntica");
		MostrarDato.string("3. Aventuras");
		MostrarDato.string("4. Comedia");
		MostrarDato.string("5. Animaci�n");
		MostrarDato.string("6. Thriller");
	}

}
