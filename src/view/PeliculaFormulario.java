package view;

import model.Pelicula;

public class PeliculaFormulario {

	private final static short VISUALIZACIONES_POR_DEFECTO = 0;
	private final static short VALORACION_POR_DEFECTO = -1;

	public static Pelicula crear() {
		Pelicula pelicula = new Pelicula();
		MostrarDato.string("vamos a a�adir una nueva pelicula, voy a pedirte los datos");
		String titulo = DatoFormulario.string("dime el titulo");
		pelicula.setTitulo(titulo);
		short anyoEstreno = (short) DatoFormulario.entero("dime el a�o de estreno");
		pelicula.setAnyoEstreno(anyoEstreno);
		short categoria = (short) DatoFormulario.enteroEntre(1, 6, "dime que categoria es");
		pelicula.setCategoria(categoria);
		pelicula.setVisualizaciones(VISUALIZACIONES_POR_DEFECTO);
		pelicula.setValoracion(VALORACION_POR_DEFECTO);
		return pelicula;
	}

	public static Pelicula modificar(Pelicula pelicula) {
		boolean cambiarTitulo = DatoFormulario.booleanPreguntando("�Quieres cambiar el t�tulo?", "si");
		if (cambiarTitulo) {
			String titulo = DatoFormulario.string("�Cual es el nuevo t�tulo?");
			pelicula.setTitulo(titulo);
		}
		boolean cambiarAnyoEstreno = DatoFormulario.booleanPreguntando("�Quieres cambiar el a�o de estreno?", "si");
		if (cambiarAnyoEstreno) {
			short anyoEstreno = (short) DatoFormulario.entero("�Cual es el nuevo a�o de estreno?");
			pelicula.setAnyoEstreno(anyoEstreno);
		}
		boolean cambiarCategoria = DatoFormulario.booleanPreguntando("�Quieres cambiar la categor�a?", "si");
		if (cambiarCategoria) {
			short categoria = (short) DatoFormulario.enteroEntre(1, 6, "�Cual es la nueva categor�a?");
			pelicula.setCategoria(categoria);
		}
		return pelicula;
	}

}
