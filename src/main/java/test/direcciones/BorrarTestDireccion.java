package test.direcciones;

import BO.GestorDirecciones;
import DAO.DaoDirecciones;
import VO.Direcciones;

public class BorrarTestDireccion {

	public static void main(String[] args) {

		DaoDirecciones dao = new DaoDirecciones();

		Direcciones objetoBorrar = new Direcciones();

		objetoBorrar.setIdDireccion(6);

		boolean borrado = dao.borrarDireccion(objetoBorrar);

		System.out.println(borrado);

		GestorDirecciones gestor = new GestorDirecciones();

		Direcciones entidad = new Direcciones();

		entidad.setIdDireccion(7);

		boolean borrada = gestor.borrarDireccion(entidad);

		System.out.println(borrada);
	}

}
