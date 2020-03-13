package test.direccion;

import muela.BO.GestorDireccion;
import muela.DAO.DaoDireccion;
import muela.VO.Direccion;

public class ObtenerTestDireccion {

	public static void main(String[] args) {

		DaoDireccion dao = new DaoDireccion();

		Direccion selecionado = dao.obtenerDireccion(3);

		System.out.println(selecionado);

		GestorDireccion gestor = new GestorDireccion();

		Direccion selecionado2 = gestor.obtenerDireccion(3);

		System.out.println(selecionado2);

	}
}
