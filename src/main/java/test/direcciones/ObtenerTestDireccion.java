package test.direcciones;

import BO.GestorDirecciones;
import DAO.DaoDirecciones;
import VO.Direcciones;

public class ObtenerTestDireccion {

	public static void main(String[] args) {

		DaoDirecciones dao = new DaoDirecciones();

		Direcciones selecionado = dao.obtenerDireccion(3);

		System.out.println(selecionado);

		GestorDirecciones gestor = new GestorDirecciones();

		Direcciones selecionado2 = gestor.obtenerDireccion(3);

		System.out.println(selecionado2);

	}
}
