/*
 * Fecha: 29/10/2021
 *
 * @author Edu
 *
 * @version: 2.0
 */

package service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dao.PeliculaDao;
import exception.ListadoVacioException;
import exception.PeliculaExistenteException;
import exception.PeliculaNoExistenteException;
import model.Pelicula;
import view.DatoFormulario;
import view.Menu;
import view.MostrarDato;
import view.PeliculaFormulario;

public class PeliculaServiceImpl implements PeliculaService {

	private static Logger logger = LogManager.getLogger();

	private PeliculaDao peliculaDao = new PeliculaDao();

	@Override
	public void listarPeliculas() {
		try {
			List<Pelicula> peliculas = this.peliculaDao.getPeliculas();
			MostrarDato.string("Listado de Peliculas");
			MostrarDato.peliculas(peliculas);
		} catch (ListadoVacioException e) {
			logger.error(e.toString());
		}
	}

	@Override
	public void addPeliculas() {
		Pelicula pelicula = PeliculaFormulario.crear();
		try {
			this.peliculaDao.addPelicula(pelicula);
			MostrarDato.string("Pel�cula creada correctamente");
		} catch (PeliculaExistenteException e) {
			logger.error(e.toString());
		}
	}

	@Override
	public void eliminarPeliculas() {
		String tituloPelicula = DatoFormulario.string("Dime el t�tulo de la pel�cula a borrar");
		try {
			this.peliculaDao.eliminarPelicula(tituloPelicula);
			MostrarDato.string("Pel�cula eliminada correctamente");
		} catch (PeliculaNoExistenteException e) {
			logger.error(e.toString());
		}
	}

	@Override
	public void modificarPeliculas() {
		String tituloPelicula = DatoFormulario.string("Dime el t�tulo de la pel�cula a modificar");
		try {
			Pelicula pelicula = this.peliculaDao.getPelicula(tituloPelicula);
			boolean cambiarTitulo = DatoFormulario.preguntarSiNo("�Quieres cambiar el t�tulo? Escribe si o no", "si", "no");
			if (cambiarTitulo) {
				pelicula.setTitulo(DatoFormulario.string("�Cual es el nuevo t�tulo?"));
			}
			boolean cambiarAnyoEstreno = DatoFormulario.preguntarSiNo("�Quieres cambiar el a�o de estreno? Escribe si o no",
					"si", "no");
			if (cambiarAnyoEstreno) {
				pelicula.setAnyoEstreno((short) DatoFormulario.pedirInt("�Cual es el nuevo a�o de estreno?"));
			}
			boolean cambiarCategoria = DatoFormulario.preguntarSiNo("�Quieres cambiar la categor�a? Escribe si o no", "si",
					"no");
			if (cambiarCategoria) {
				pelicula.setCategoria((short) DatoFormulario.pedirIntEntre(1, 6, "�Cual es la nueva categor�a?"));
			}
			if (cambiarTitulo || cambiarAnyoEstreno || cambiarCategoria) {
				this.peliculaDao.modificarPelicula(pelicula);
				MostrarDato.string("Pel�cula modificada correctamente");
			} else {
				MostrarDato.string("no se modific� ning�n dato");
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
		short categoria = DatoFormulario.pedirShortEntre(1, 6, "Elige una categor�a");
		try {
			List<Pelicula> peliculasCategorizadasList = this.peliculaDao.getPeliculasPorCategoria(categoria);
			MostrarDato.peliculas(peliculasCategorizadasList);
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
			int cuantas = DatoFormulario.pedirIntEntre(0, limiteSuperior, mensaje);
			List<Pelicula> peliculasMasValoradas = this.peliculaDao.getPeliculasMasValoradas(cuantas);
			mensaje = "Listado de " + cuantas + " peliculas m�s valoradas";
			MostrarDato.string(mensaje);
			MostrarDato.peliculas(peliculasMasValoradas);
		} catch (ListadoVacioException e) {
			logger.error(e.toString());
		}
	}

	@Override
	public void listarPeliculasMenosValoradas() {
		try {
			int limiteSuperior = this.peliculaDao.getPeliculas().size();
			String mensaje = "Hay " + limiteSuperior + " pel�culas, �cu�ntas de las menos valoradas quieres ver?";
			int cuantas = DatoFormulario.pedirIntEntre(0, limiteSuperior, mensaje);
			List<Pelicula> peliculasMenosValoradas = this.peliculaDao.getPeliculasMenosValoradas(cuantas);
			mensaje = "Listado de " + cuantas + " peliculas menos valoradas";
			MostrarDato.string(mensaje);
			MostrarDato.peliculas(peliculasMenosValoradas);
		} catch (ListadoVacioException e) {
			logger.error(e.toString());
		}
	}

	@Override
	public void listarPeliculasValoracionEncimaMedia() {
		try {
			List<Pelicula> peliculasValoracionEncimaMedia = this.peliculaDao.getPeliculasValoracionEncimaMedia();
			MostrarDato.string("Listado de peliculas cuya valoraci�n est� por encima de la media");
			MostrarDato.peliculas(peliculasValoracionEncimaMedia);
		} catch (ListadoVacioException e) {
			logger.error(e.toString());
		}
	}

	@Override
	public void listarPeliculasMasVistas() {
		try {
			int limiteSuperior = this.peliculaDao.getPeliculas().size();
			String mensaje = "Hay " + limiteSuperior + " pel�culas, �cu�ntas de las m�s vistas quieres ver?";
			int cuantas = DatoFormulario.pedirIntEntre(0, limiteSuperior, mensaje);
			List<Pelicula> peliculasMasVistas = this.peliculaDao.getPeliculasMasVistas(cuantas);
			mensaje = "Listado de " + cuantas + " peliculas m�s vistas";
			MostrarDato.string(mensaje);
			MostrarDato.peliculas(peliculasMasVistas);
		} catch (ListadoVacioException e) {
			logger.error(e.toString());
		}
	}

}
