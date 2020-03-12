package test.empresa;

import BO.GestorEmpresa;
import DAO.DaoEmpresa;
import VO.Empresa;

public class ObtenerTestEmpresa {
	
	public static void main(String[] args) {

		DaoEmpresa dao = new DaoEmpresa();

		Empresa selecionado = dao.obtenerEmpresa(8);

		System.out.println(selecionado);

		GestorEmpresa gestor = new GestorEmpresa();

		Empresa selecionado2 = gestor.obtenerEmpresa(8);

		System.out.println(selecionado2);

	}
}
