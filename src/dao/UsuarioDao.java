/*
 * Fecha: 29/10/2021
 *
 * @author Edu
 *
 * @version: 2.0
 */

package dao;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import exception.ListadoVacioException;
import exception.UsuarioExistenteException;
import model.Usuario;
import view.DatoFormulario;
import view.Menu;
import view.MostrarDato;
import view.UsuarioFormulario;

public class UsuarioDao {

	private static Logger logger;

	static {
		try {
			logger = LogManager.getLogger(UsuarioDao.class);
		} catch (Throwable e) {
			System.out.println("Logger Don't work");
		}
	}

	private Map<String, Usuario> usuarioDao = new HashMap<String, Usuario>();

	public void listarUsuarios() {
		try {
			if (usuarioDao.size() == 0) {
				MostrarDato.string("El listado est� vac�o");
				throw new exception.ListadoVacioException();
			}
			String key;
			Iterator<String> iterator = usuarioDao.keySet().iterator();
			System.out.println("Listado de Usuarios");
			while (iterator.hasNext()) {
				key = iterator.next();
				System.out.println("[" + key + "]:" + usuarioDao.get(key));
			}
		} catch (ListadoVacioException e) {
			logger.error(e.toString());
		}
	}

	public void addUsuario() {
		try {
			Usuario usuario = UsuarioFormulario.crear();
			if (usuarioDao.containsKey(usuario.getNombre())) {
				MostrarDato.string("Ese usuario ya exist�a");
				throw new exception.UsuarioExistenteException();
			} else {
				usuarioDao.put(usuario.getNombre(), usuario);
				MostrarDato.string("Usuario creado correctamente");
			}
		} catch (UsuarioExistenteException e) {
			logger.error(e.toString());
		}
	}

	public void eliminarUsuario() {
		String nombreUsuario = DatoFormulario.string("dime el nombre de usuario a borrar");
		usuarioDao.remove(nombreUsuario);
	}

	public void modificarUsuario() {
		String nombreUsuario = DatoFormulario.string("Dame el nombre del usuario");
		Menu.modificarUsuario();
		int opcion = DatoFormulario.enteroEntre(1, 3);
		switch (opcion) {
		case 1:
			usuarioDao.get(nombreUsuario).setNombre(DatoFormulario.string("�Cual es el nuevo nombre?"));
			break;
		case 2:
			usuarioDao.get(nombreUsuario).setCiudadResidencia(DatoFormulario.string("�Cual es la nueva ciudad?"));
			break;

		case 3:
			int year = DatoFormulario.entero("dame nuevo a�o de nacimiento");
			int mes = DatoFormulario.entero("dame nuevo mes de nacimiento");
			int dia = DatoFormulario.entero("dame nuevo d�a de nacimiento");
			usuarioDao.get(nombreUsuario).setFechaNacimiento(LocalDate.of(year, mes, dia));
			break;
		}
		MostrarDato.string("Este usuario ha sido modificado");
	}

}
