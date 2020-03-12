package test.cliente;

import BO.GestorCliente;
import DAO.DaoCliente;
import VO.Cliente;

public class AltaTestCliente {

	public static void main(String[] args) {

		
		  DaoCliente dao = new DaoCliente();
		  
		  Cliente altaEntidad = new Cliente();
		  
		  altaEntidad.setEanColumn1("alta dao");
		  altaEntidad.setCodigoCliente("alta dao");
		  //altaEntidad.setCodigoBarras();
		  altaEntidad.setIdEmpresa(5);
		  boolean testAlta = dao.crearCliente(altaEntidad);
		  
		  System.out.println(testAlta);
		
		  
		 

		GestorCliente gestor = new GestorCliente();
		Cliente entidad = new Cliente();
		
		entidad.setEanColumn1("alta desde gestor");
		entidad.setCodigoCliente("alta gestor");
		//entidad.setCodigoBarras();
		entidad.setIdEmpresa(5);
		
		boolean testGestorAlta = gestor.crearCliente(entidad);		

		System.out.println(testGestorAlta);
		
		

	}

}
