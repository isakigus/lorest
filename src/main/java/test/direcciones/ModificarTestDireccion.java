package test.direccion;

import muela.BO.GestorDireccion;
import muela.DAO.DaoDireccion;
import muela.VO.Direccion;

public class ModificarTestDireccion {
	public static void main(String[] args) {

		DaoDireccion dao = new DaoDireccion();

		Direccion prueba = new Direccion();

		prueba.setIdDireccion(12);
		prueba.setDireccion("modificado Dao");
		prueba.setCodigoPostal("cpDao");
		prueba.setDestino("Dao");

		boolean modificar = dao.modificarDireccion(prueba);

		System.out.println(modificar);


		GestorDireccion gestor = new GestorDireccion();

		Direccion prueba2 = new Direccion();

		prueba2.setIdDireccion(13);
		prueba2.setDireccion("modificado Gestor");
		prueba2.setCodigoPostal("cpGes");
		prueba2.setDestino("Gestor");

		boolean modificar2 = gestor.modificarDireccion(prueba2);

		System.out.println(modificar2);

	}

}
