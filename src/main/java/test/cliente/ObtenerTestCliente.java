package test.cliente;

import BO.GestorCliente;
import DAO.DaoCliente;
import VO.Cliente;

public class ObtenerTestCliente {

	public static void main(String[] args) {

		DaoCliente dao = new DaoCliente();

		Cliente selecionado = dao.obtenerCliente(6);

		System.out.println(selecionado);

		GestorCliente gestor = new GestorCliente();

		Cliente selecionado2 = gestor.obtenerCliente(6);

		System.out.println(selecionado2);

	}

}
