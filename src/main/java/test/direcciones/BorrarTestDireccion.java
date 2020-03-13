package test.direccion;

import muela.BO.GestorDireccion;
import muela.DAO.DaoDireccion;
import muela.VO.Direccion;

public class BorrarTestDireccion {

	public static void main(String[] args) {

		DaoDireccion dao = new DaoDireccion();

		Direccion objetoBorrar = new Direccion();

		objetoBorrar.setIdDireccion(6);

		boolean borrado = dao.borrarDireccion(objetoBorrar);

		System.out.println(borrado);

		GestorDireccion gestor = new GestorDireccion();

		Direccion entidad = new Direccion();

		entidad.setIdDireccion(7);

		boolean borrada = gestor.borrarDireccion(entidad);

		System.out.println(borrada);
	}

}
