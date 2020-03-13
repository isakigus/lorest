package test.empresa;

import muela.BO.GestorEmpresa;
import muela.DAO.DaoEmpresa;
import muela.VO.Empresa;

public class ModificarTestEmpresa {
	public static void main(String[] args) {

		DaoEmpresa dao = new DaoEmpresa();

		Empresa prueba = new Empresa();

		prueba.setIdEmpresa(5);
		prueba.setNombreEmpresa("modDao");
		prueba.setIdDireccion(3);

		boolean modificar = dao.modificarEmpresa(prueba);

		System.out.println(modificar);

		GestorEmpresa gestor = new GestorEmpresa();

		Empresa prueba2 = new Empresa();

		prueba2.setIdEmpresa(8);
		prueba2.setNombreEmpresa("modGest");
		prueba2.setIdDireccion(1);

		boolean modificar2 = gestor.modificarEmpresa(prueba2);

		System.out.println(modificar2);

	}

}
