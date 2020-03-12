package test.cliente;

import BO.GestorCliente;
import DAO.DaoCliente;
import VO.Cliente;

public class ModificarTestCliente {

	public static void main(String[] args) {

		DaoCliente dao = new DaoCliente();

		Cliente prueba = new Cliente();
		
		prueba.setIdCliente(2);
		prueba.setEanColumn1("modDao");
		prueba.setCodigoCliente("modifDao");
		prueba.setIdEmpresa(5);
		
		boolean modificar = dao.modificarCliente(prueba);

		System.out.println(modificar);
		
		

		GestorCliente gestor = new GestorCliente();

		Cliente prueba2 = new Cliente();
		
		prueba2.setIdCliente(6);
		prueba2.setEanColumn1("modGest");
		prueba2.setCodigoCliente("modifGest");
		prueba2.setIdEmpresa(8);

		boolean modificar2 = gestor.modificarCliente(prueba2);

		System.out.println(modificar2);

	}

}
