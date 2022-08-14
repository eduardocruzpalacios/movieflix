/*
 * Fecha: 29/10/2021
 *
 * @author Edu
 *
 * @version: 2.0
 */

package service;

import java.util.List;

import dao.PeliculaDao;
import exception.ListadoVacioException;
import exception.PeliculaExistenteException;
import exception.PeliculaNoExistenteException;
import model.Pelicula;
import utility.Log;
import view.DatoFormulario;
import view.Menu;
import view.MostrarDato;
import view.PeliculaFormulario;

public class PeliculaServiceImpl implements PeliculaService {

	private PeliculaDao peliculaDao = new PeliculaDao();

	@Override
	public void listarPeliculas() {
		try {
			List<Pelicula> peliculas = this.peliculaDao.getPeliculas();
			MostrarDato.string("Listado de Peliculas");
			MostrarDato.peliculas(peliculas);
		} catch (ListadoVacioException e) {
			Log.error(e);
		}
	}

	@Override
	public void addPeliculas() {
		Pelicula pelicula = PeliculaFormulario.crear();
		try {
			this.peliculaDao.addPelicula(pelicula);
			MostrarDato.string("Pel�cula creada correctamente");
		} catch (PeliculaExistenteException e) {
			Log.error(e);
		}
	}

	@Override
	public void eliminarPeliculas() {
		String tituloPelicula = DatoFormulario.string("Dime el t�tulo de la pel�cula a borrar");
		try {
			this.peliculaDao.eliminarPelicula(tituloPelicula);
			MostrarDato.string("Pel�cula eliminada correctamente");
		} catch (PeliculaNoExistenteException e) {
			Log.error(e);
		}
	}

	@Override
	public void modificarPeliculas() {
		String tituloPelicula = DatoFormulario.string("Dime el t�tulo de la pel�cula a modificar");
		try {
			Pelicula pelicula = this.peliculaDao.getPelicula(tituloPelicula);
			Pelicula peliculaModificada = PeliculaFormulario.modificar(pelicula);
			this.peliculaDao.modificarPelicula(peliculaModificada);
			MostrarDato.string("Pel�cula modificada correctamente");
		} catch (PeliculaNoExistenteException e) {
			Log.error(e);
		}
	}

	@Override
	public void importarPeliculas() {
		this.peliculaDao.importarPeliculas();
	}

	@Override
	public void listarPeliculasPorCategoria() {
		Menu.categorias();
		short categoria = DatoFormulario.shortEntre(1, 6, "Elige una categor�a");
		try {
			List<Pelicula> peliculasCategorizadasList = this.peliculaDao.getPeliculasPorCategoria(categoria);
			MostrarDato.peliculas(peliculasCategorizadasList);
		} catch (ListadoVacioException e) {
			Log.error(e);
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
			int cuantas = DatoFormulario.enteroEntre(0, limiteSuperior, mensaje);
			List<Pelicula> peliculasMasValoradas = this.peliculaDao.getPeliculasMasValoradas(cuantas);
			mensaje = "Listado de " + cuantas + " peliculas m�s valoradas";
			MostrarDato.string(mensaje);
			MostrarDato.peliculas(peliculasMasValoradas);
		} catch (ListadoVacioException e) {
			Log.error(e);
		}
	}

	@Override
	public void listarPeliculasMenosValoradas() {
		try {
			int limiteSuperior = this.peliculaDao.getPeliculas().size();
			String mensaje = "Hay " + limiteSuperior + " pel�culas, �cu�ntas de las menos valoradas quieres ver?";
			int cuantas = DatoFormulario.enteroEntre(0, limiteSuperior, mensaje);
			List<Pelicula> peliculasMenosValoradas = this.peliculaDao.getPeliculasMenosValoradas(cuantas);
			mensaje = "Listado de " + cuantas + " peliculas menos valoradas";
			MostrarDato.string(mensaje);
			MostrarDato.peliculas(peliculasMenosValoradas);
		} catch (ListadoVacioException e) {
			Log.error(e);
		}
	}

	@Override
	public void listarPeliculasValoracionEncimaMedia() {
		try {
			List<Pelicula> peliculasValoracionEncimaMedia = this.peliculaDao.getPeliculasValoracionEncimaMedia();
			MostrarDato.string("Listado de peliculas cuya valoraci�n est� por encima de la media");
			MostrarDato.peliculas(peliculasValoracionEncimaMedia);
		} catch (ListadoVacioException e) {
			Log.error(e);
		}
	}

	@Override
	public void listarPeliculasMasVistas() {
		try {
			int limiteSuperior = this.peliculaDao.getPeliculas().size();
			String mensaje = "Hay " + limiteSuperior + " pel�culas, �cu�ntas de las m�s vistas quieres ver?";
			int cuantas = DatoFormulario.enteroEntre(0, limiteSuperior, mensaje);
			List<Pelicula> peliculasMasVistas = this.peliculaDao.getPeliculasMasVistas(cuantas);
			mensaje = "Listado de " + cuantas + " peliculas m�s vistas";
			MostrarDato.string(mensaje);
			MostrarDato.peliculas(peliculasMasVistas);
		} catch (ListadoVacioException e) {
			Log.error(e);
		}
	}

}
