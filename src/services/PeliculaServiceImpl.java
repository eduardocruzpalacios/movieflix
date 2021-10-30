/*
 * Fecha: 29/10/2021
 *
 * @author Edu
 *
 * @version: 2.0
 */

package services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dao.PeliculaDao;
import exceptions.ListadoVacioException;
import exceptions.PeliculaExistenteException;
import exceptions.PeliculaNoExistenteException;
import gui.Menu;
import model.Pelicula;
import tools.Escritor;
import tools.Lector;

public class PeliculaServiceImpl implements PeliculaService {

	private static Logger logger = LogManager.getLogger();

	private PeliculaDao peliculaDao = new PeliculaDao();

	@Override
	public void listarPeliculas() {
		try {
			List<Pelicula> peliculas = this.peliculaDao.getPeliculas();
			Escritor.str("Listado de Peliculas");
			Escritor.listPelicula(peliculas);
		} catch (ListadoVacioException e) {
			logger.error(e.toString());
		}
	}

	@Override
	public void addPeliculas() {
		Pelicula pelicula = Pelicula.crear();
		try {
			this.peliculaDao.addPelicula(pelicula);
			Escritor.str("Pel�cula creada correctamente");
		} catch (PeliculaExistenteException e) {
			logger.error(e.toString());
		}
	}

	@Override
	public void eliminarPeliculas() {
		String tituloPelicula = Lector.str("Dime el t�tulo de la pel�cula a borrar");
		try {
			this.peliculaDao.eliminarPelicula(tituloPelicula);
			Escritor.str("Pel�cula eliminada correctamente");
		} catch (PeliculaNoExistenteException e) {
			logger.error(e.toString());
		}
	}

	@Override
	public void modificarPeliculas() {
		String tituloPelicula = Lector.str("Dime el t�tulo de la pel�cula a modificar");
		try {
			Pelicula pelicula = this.peliculaDao.getPelicula(tituloPelicula);
			boolean cambiarTitulo = Lector.preguntarSiNo("�Quieres cambiar el t�tulo? Escribe si o no", "si", "no");
			if (cambiarTitulo) {
				pelicula.setTitulo(Lector.str("�Cual es el nuevo t�tulo?"));
			}
			boolean cambiarAnyoEstreno = Lector.preguntarSiNo("�Quieres cambiar el a�o de estreno? Escribe si o no",
					"si", "no");
			if (cambiarAnyoEstreno) {
				pelicula.setAnyoEstreno((short) Lector.pedirInt("�Cual es el nuevo a�o de estreno?"));
			}
			boolean cambiarCategoria = Lector.preguntarSiNo("�Quieres cambiar la categor�a? Escribe si o no", "si",
					"no");
			if (cambiarCategoria) {
				pelicula.setCategoria((short) Lector.pedirIntEntre(1, 6, "�Cual es la nueva categor�a?"));
			}
			this.peliculaDao.modificarPelicula(pelicula);
			if (cambiarTitulo || cambiarAnyoEstreno || cambiarCategoria) {
				Escritor.str("Pel�cula modificada correctamente");
			} else {
				Escritor.str("no se modific� ning�n dato");
			}
		} catch (PeliculaNoExistenteException e) {
			logger.error(e.toString());
		}
	}

	@Override
	public void importarPeliculas() {
		this.peliculaDao.importarPeliculas();
	}

	@Override
	public void listarPeliculasPorCategoria() {
		Menu.categorias();
		short categoria = Lector.pedirShortEntre(1, 6, "Elige una categor�a");
		try {
			List<Pelicula> peliculasCategorizadasList = this.peliculaDao.listarPeliculasPorCategoria(categoria);
			Escritor.listPelicula(peliculasCategorizadasList);
		} catch (ListadoVacioException e) {
			logger.error(e.toString());
		}
	}

	@Override
	public void guardarPeliculas() {
		this.peliculaDao.guardarPeliculas();
	}

	@Override
	public void listarPeliculasMasValoradas() {
		try {
			int limiteSuperior = this.peliculaDao.getPeliculas().size();
			String mensaje = "Hay " + limiteSuperior + " pel�culas, �cu�ntas de las m�s valoradas quieres ver?";
			int cuantas = Lector.pedirIntEntre(0, limiteSuperior, mensaje);
			this.peliculaDao.listarPeliculasMasValoradas(cuantas);
		} catch (ListadoVacioException e) {
			logger.error(e.toString());
		}
	}

	@Override
	public void listarPeliculasMenosValoradas() {
		this.peliculaDao.listarPeliculasMenosValoradas();
	}

	@Override
	public void listarPeliculasValoracionEncimaMedia() {
		this.peliculaDao.listarPeliculasValoracionEncimaMedia();
	}

	@Override
	public void listarPeliculasMasVistas() {
		this.peliculaDao.listarPeliculasMasVistas();
	}

}
