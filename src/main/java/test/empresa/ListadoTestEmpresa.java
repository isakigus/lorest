package test.empresa;

import java.util.List;

import muela.BO.GestorEmpresa;
import muela.DAO.DaoEmpresa;
import muela.VO.Empresa;

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
