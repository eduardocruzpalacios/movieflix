package view;

import model.Pelicula;

public class PeliculaFormulario {

	public static Pelicula crear() {
		Pelicula pelicula = new Pelicula();
		MostrarDato.string("vamos a a�adir una nueva pelicula, voy a pedirte los datos");
		pelicula.setTitulo(DatoFormulario.str("dime el titulo"));
		pelicula.setAnyoEstreno((short) DatoFormulario.pedirInt("dime el a�o de estreno"));
		pelicula.setCategoria((short) DatoFormulario.pedirIntEntre(1, 6, "dime que categoria es"));
		pelicula.setVisualizaciones(0);
		pelicula.setValoracion(-1);
		return pelicula;
	}

}
