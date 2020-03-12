package test.empresa;

import java.util.List;

import BO.GestorEmpresa;
import DAO.DaoEmpresa;
import VO.Empresa;

public class ListadoTestEmpresa {
	
	public static void main(String[] args) {

		DaoEmpresa dao = new DaoEmpresa();

		List<Empresa> listado = dao.listarEmpresas();

		System.out.println(listado);

		GestorEmpresa gestor = new GestorEmpresa();

		List<Empresa> listado2 = gestor.listarEmpresas();

		System.out.println(listado2);

	}

}
