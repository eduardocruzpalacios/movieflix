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
		Escritor.string("\n********** MEN� PRINCIPAL **********\n");
		Escritor.string("1. Gestionar Usuarios");
		Escritor.string("2. Gestionar Pel�culas");
		Escritor.string("3. Salir del programa");
	}

	public static void usuarios() {
		Escritor.string("\n********** GESTI�N DE USUARIOS **********\n");
		Escritor.string("1. Listar todos los usuarios");
		Escritor.string("2. A�adir un usuario");
		Escritor.string("3. Eliminar un usuario");
		Escritor.string("4. Modificar un usuario");
		Escritor.string("5. Volver al men� principal");
	}

	public static void modificarUsuario() {
		Escritor.string("\n********** MODIFICAR USUARIO **********\n");
		Escritor.string("1. Nombre");
		Escritor.string("2. Ciudad de residencia");
		Escritor.string("3. Fecha de nacimiento");
	}

	public static void peliculas() {
		Escritor.string("\n********** GESTI�N DE PEL�CULAS **********\n");
		Escritor.string("1. Listar todas las pel�culas");
		Escritor.string("2. A�adir una pel�cula");
		Escritor.string("3. Eliminar una pel�cula");
		Escritor.string("4. Modificar una pel�cula");
		Escritor.string("5. Filtrar pel�culas por categor�a");
		Escritor.string("6. Mostrar las pel�culas m�s valoradas");
		Escritor.string("7. Mostrar las pel�culas cuya valoraci�n est� por encima de la media");
		Escritor.string("8. Mostrar las pel�culas peor valoradas");
		Escritor.string("9. Mostrar las pel�culas m�s vistas");
		Escritor.string("10. Volver al men� principal");
	}

	public static void modificarPelicula() {
		Escritor.string("\n********** MODIFICAR PEL�CULA **********\n");
		Escritor.string("1. T�tulo");
		Escritor.string("2. A�o");
		Escritor.string("3. Categor�a");
	}

	public static void categorias() {
		Escritor.string("\n********** CATEGOR�AS **********\n");
		Escritor.string("1. Policiaca");
		Escritor.string("2. Rom�ntica");
		Escritor.string("3. Aventuras");
		Escritor.string("4. Comedia");
		Escritor.string("5. Animaci�n");
		Escritor.string("6. Thriller");
	}

}
