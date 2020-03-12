package test.direcciones;

import java.util.List;

import BO.GestorDirecciones;
import DAO.DaoDirecciones;
import VO.Direcciones;

public class ListadoTestDirecciones {

	public static void main(String[] args) {

		DaoDirecciones dao = new DaoDirecciones();

		List<Direcciones> listado = dao.listarTodasDirecciones();

		System.out.println(listado);

		GestorDirecciones gestor = new GestorDirecciones();

		List<Direcciones> listado2 = gestor.listarDirecciones();

		System.out.println(listado2);

	}

}
