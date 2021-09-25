/*
 * Fecha: 22/03/2021
 *
 * @author Ra�l y Mar�a
 *
 * @version: 1.0
 */

package dao;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import excepciones.ListadoVacioException;
import excepciones.PeliculaExistenteException;
import gui.Menu;
import model.Pelicula;
import utilidades.Colecciones;
import utilidades.Escritor;
import utilidades.Files;
import utilidades.Lector;

public class PeliculaDao {

	private static Logger logger;
	static {
		try {
			logger = LogManager.getLogger(UsuarioDao.class);
		} catch (Throwable e) {
			System.out.println("Logger Don't work");
		}
	}

	private List<Pelicula> ListaPeliculas = new ArrayList<Pelicula>();

	public PeliculaDao() {

	}

	public List<Pelicula> getListaPeliculas() {
		return ListaPeliculas;
	}

	public void setListaPeliculas(List<Pelicula> ListaPeliculas) {
		this.ListaPeliculas = ListaPeliculas;
	}

	public void listarPeliculas() {
		try {
			if (ListaPeliculas.size() == 0) {
				Escritor.str("El listado est� vac�o");

				throw new excepciones.ListadoVacioException();
			} else {
				System.out.println("Listado de Peliculas");
				for (int i = 0; i < ListaPeliculas.size(); i++) {
					System.out.println(ListaPeliculas.get(i));
				}

			}

		} catch (ListadoVacioException e) {
			logger.error(e.toString());
		} finally {

		}

	}

	public void addPeliculas() {
		try {
			Pelicula p1 = Pelicula.crearYRellenarPelicula();

			for (int i = 0; i < ListaPeliculas.size(); i++) {
				if (ListaPeliculas.get(i).getTitulo().equals(p1.getTitulo())) {

					throw new excepciones.PeliculaExistenteException();
				}
			}
			ListaPeliculas.add(p1);
			Escritor.str("Pel�cula creada correctamente");
		} catch (PeliculaExistenteException e) {

			logger.error(e.toString());
		}
	}

	public void eliminarPeliculas() {
		String s = Lector.str("Dime el t�tulo de la pel�cula a borrar");
		for (int i = 0; i < ListaPeliculas.size(); i++) {
			if (s.equals(ListaPeliculas.get(i).getTitulo())) {
				ListaPeliculas.remove(ListaPeliculas.get(i));
			}
		}

	}

	public void modificarPeliculas() {
		String s = Lector.str("Dime el t�tulo de la pel�cula a modificar");
		Menu.modificarPelicula();
		int opcion = Lector.pedirIntEntre(1, 3);
		switch (opcion) {
		case 1:
			for (int i = 0; i < ListaPeliculas.size(); i++) {
				if (s.equals(ListaPeliculas.get(i).getTitulo())) {
					ListaPeliculas.get(i).setTitulo(Lector.str("�Cual es el nuevo t�tulo?"));
				}
			}
			break;
		case 2:
			for (int i = 0; i < ListaPeliculas.size(); i++) {
				if (s.equals(ListaPeliculas.get(i).getTitulo())) {
					ListaPeliculas.get(i).setAnyoEstreno((short) Lector.pedirInt("�Cual es el nuevo a�o de estreno?"));
				}
			}
			break;

		case 3:
			for (int i = 0; i < ListaPeliculas.size(); i++) {
				if (s.equals(ListaPeliculas.get(i).getTitulo())) {
					ListaPeliculas.get(i).setCategoria((short) Lector.pedirInt("Digame la nueva categor�a"));
				}
			}
			break;
		}
		Escritor.str("Esta pel�cula ha sido modificada");
	}

	public void importarPeliculas() {

		File fichero = new File("peliculas.txt");

		ArrayList<String> pelisRaw = Files.exportarAList(fichero);

		ArrayList<Pelicula> pelisTodas = Colecciones.leerListCadenasDevolverListObjetos(pelisRaw);

		ListaPeliculas = pelisTodas;
	}

}
