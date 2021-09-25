/*
 * Fecha: 17/03/2021 y 18/03/2021
 * 
 * @author Miguel, Ra�l y Edu
 * 
 * @version 1.0
 */

package dao;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import excepciones.ListadoVacioException;
import excepciones.UsuarioExistenteException;
import gui.Menu;
import model.Usuario;
import utilidades.Escritor;
import utilidades.Lector;

public class UsuarioDao {

	private static Logger logger;
	static {
		try {
			logger = LogManager.getLogger(UsuarioDao.class);
		} catch (Throwable e) {
			System.out.println("Logger Don't work");
		}
	}

	private Map<String, Usuario> MapaUsuarios;

	public UsuarioDao() {
		MapaUsuarios = new HashMap<>();
	}

	public Map<String, Usuario> getMapaUsuarios() {
		return MapaUsuarios;
	}

	public void setMapaUsuarios(Map<String, Usuario> MapaUsuario) {
		this.MapaUsuarios = MapaUsuarios;
	}

	public void listarUsuarios() {

		try {
			if (MapaUsuarios.size() == 0) {
				Escritor.str("El listado est� vac�o");
				throw new excepciones.ListadoVacioException();
			} else {
				String key;
				Iterator<String> usuarios = MapaUsuarios.keySet().iterator();
				System.out.println("Listado de Usuarios");
				while (usuarios.hasNext()) {
					key = usuarios.next();
					System.out.println("[" + key + "]:" + MapaUsuarios.get(key));
				}
			}

		} catch (ListadoVacioException e) {
			logger.error(e.toString());
		} finally {

		}

	}

	public void addUsuarios() {

		try {
			Usuario u = Usuario.crearYRellenarUsuario();

			if (MapaUsuarios.containsKey(u.getNombre())) {
				Escritor.str("Ese usuario ya exist�a");

				throw new excepciones.UsuarioExistenteException();

			} else {
				MapaUsuarios.put(u.getNombre(), u);
				Escritor.str("Usuario creado correctamente");
			}
		} catch (UsuarioExistenteException e) {
			logger.error(e.toString());
		} finally {

		}

	}

	public void eliminarUsuarios() {
		String codigo = Lector.str("dime el nombre de usuario a borrar");
		MapaUsuarios.remove(codigo);
	}

	public void modificarUsuarios() {

		String codigo = Lector.str("Dame el c�digo del usuario");
		Menu.modificarUsuario();
		int opcion = Lector.pedirIntEntre(1, 3);
		switch (opcion) {
		case 1:
			MapaUsuarios.get(codigo).setNombre(Lector.str("�Cual es el nuevo nombre?"));
			break;
		case 2:
			MapaUsuarios.get(codigo).setCiudadResidencia(Lector.str("�Cual es la nueva ciudad?"));
			break;

		case 3:
			MapaUsuarios.get(codigo).setYear(Lector.pedirInt("Digame el nuevo a�o"));
			MapaUsuarios.get(codigo).setMes(Lector.pedirInt("Digame el nuevo mes"));
			MapaUsuarios.get(codigo).setDia(Lector.pedirInt("Digame el nuevo dia"));
			MapaUsuarios.get(codigo).generarFechaNac();
			break;
		}
		Escritor.str("Este usuario ha sido modificado");
	}

}
