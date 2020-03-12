package test.direcciones;

import BO.GestorDirecciones;
import DAO.DaoDirecciones;
import VO.Direcciones;

public class ModificarTestDireccion {
	public static void main(String[] args) {

		DaoDirecciones dao = new DaoDirecciones();

		Direcciones prueba = new Direcciones();

		prueba.setIdDireccion(12);
		prueba.setDireccion("modificado Dao");
		prueba.setCodigoPostal("cpDao");
		prueba.setDestino("Dao");

		boolean modificar = dao.modificarDireccion(prueba);

		System.out.println(modificar);
		

		GestorDirecciones gestor = new GestorDirecciones();

		Direcciones prueba2 = new Direcciones();

		prueba2.setIdDireccion(13);
		prueba2.setDireccion("modificado Gestor");
		prueba2.setCodigoPostal("cpGes");
		prueba2.setDestino("Gestor");

		boolean modificar2 = gestor.modificarDireccion(prueba2);

		System.out.println(modificar2);

	}

}
