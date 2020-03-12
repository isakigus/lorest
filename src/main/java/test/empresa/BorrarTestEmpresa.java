package test.empresa;

import BO.GestorEmpresa;
import DAO.DaoEmpresa;
import VO.Empresa;

public class BorrarTestEmpresa {

	public static void main(String[] args) {

		DaoEmpresa dao = new DaoEmpresa();

		Empresa objetoBorrar = new Empresa();

		objetoBorrar.setIdEmpresa(12);

		boolean borrado = dao.borrarEmpresa(objetoBorrar);

		System.out.println(borrado);
		
		
		 
		GestorEmpresa gestor = new GestorEmpresa();

		Empresa entidad = new Empresa();

		entidad.setIdEmpresa(14);
		boolean borrada = gestor.borrarEmpresa(entidad);

		System.out.println(borrada);
	}

}
