package test.cliente;

import muela.BO.GestorCliente;
import muela.DAO.DaoCliente;
import muela.VO.Cliente;

public class BorrarTestCliente {

	public static void main(String[] args) {

		DaoCliente dao = new DaoCliente();

		Cliente objetoBorrar = new Cliente();

		objetoBorrar.setIdCliente(12);

		boolean borrado = dao.borrarCliente(objetoBorrar);

		System.out.println(borrado);



		GestorCliente gestor = new GestorCliente();

		Cliente entidad = new Cliente();

		entidad.setIdCliente(13);

		boolean borrada = gestor.borrarCliente(entidad);

		System.out.println(borrada);
	}

}
