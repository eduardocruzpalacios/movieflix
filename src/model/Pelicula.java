/*@Author Andrei
 * Fecha 22 03 
 * Crear la classe con los setters getters y to string
 * Crear los metodos
 * Realizar la prueba de calidad
 *
 */
package model;

import utilidades.Escritor;
import utilidades.Lector;

public class Pelicula {

	private String titulo;
	private Short anyoEstreno;
	private Short categoria;

	public Pelicula() {
		////////////////////
	}

	public Pelicula(String titulo, short anyoEstreno, short categoria) {

		this.titulo = titulo;
		this.anyoEstreno = anyoEstreno;
		this.categoria = categoria;

	}

	public static Pelicula crearYRellenarPelicula() {

		Pelicula p = new Pelicula();

		Escritor.str("vamos a a�adir una nueva pelicula, voy a pedirte los datos");
		p.setTitulo(Lector.str("dime el titulo"));
		p.setAnyoEstreno((short)Lector.pedirInt("dime el a�o de estreno"));
		p.setCategoria((short)Lector.pedirInt("dime que categoria es"));

		return p;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public short getAnyoEstreno() {
		return anyoEstreno;
	}

	public void setAnyoEstreno(short anyoEstreno) {
		this.anyoEstreno = anyoEstreno;
	}

	public short getCategoria() {
		return categoria;
	}

	public void setCategoria(short categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "Pelicula [titulo=" + titulo + ", anyoEstreno=" + anyoEstreno + ", categoria=" + categoria + "]";
	}
}

	