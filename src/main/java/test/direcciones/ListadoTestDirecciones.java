package test.direccion;

import java.util.List;

import muela.BO.GestorDireccion;
import muela.DAO.DaoDireccion;
import muela.VO.Direccion;

public class ListadoTestDireccion {

	public static void main(String[] args) {

		DaoDireccion dao = new DaoDireccion();

		List<Direccion> listado = dao.listarTodasDireccion();

		System.out.println(listado);

		GestorDireccion gestor = new GestorDireccion();

		List<Direccion> listado2 = gestor.listarDireccion();

		System.out.println(listado2);

	}

}
