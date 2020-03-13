package test.cliente;

import java.util.List;

import muela.BO.GestorCliente;
import muela.DAO.DaoCliente;
import muela.VO.Cliente;

public class ListadoTestCliente {

	public static void main(String[] args) {

		DaoCliente dao = new DaoCliente();

		List<Cliente> listado = dao.listarTodosClientes();

		System.out.println(listado);

		GestorCliente gestor = new GestorCliente();

		List<Cliente> listado2 = gestor.listarClientes();

		System.out.println(listado2);

	}

}
