package test.empresa;

import BO.GestorEmpresa;
import DAO.DaoEmpresa;

import VO.Empresa;

public class AltaTestEmpresa {

	public static void main(String[] args) {

		DaoEmpresa dao = new DaoEmpresa();

		Empresa altaEntidad = new Empresa();

		altaEntidad.setNombreEmpresa("Alta dao");
		altaEntidad.setIdDireccion(5);

		boolean testAlta = dao.crearEmpresa(altaEntidad);

		System.out.println(testAlta);

		GestorEmpresa gestor = new GestorEmpresa();
		Empresa entidad = new Empresa();

		entidad.setNombreEmpresa("Alta gestor");
		entidad.setIdDireccion(4);

		boolean testGestorAlta = gestor.crearEmpresa(entidad);

		System.out.println(testGestorAlta);

	}

}
