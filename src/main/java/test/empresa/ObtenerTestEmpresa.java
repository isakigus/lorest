package test.empresa;

import muela.BO.GestorEmpresa;
import muela.DAO.DaoEmpresa;
import muela.VO.Empresa;

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
