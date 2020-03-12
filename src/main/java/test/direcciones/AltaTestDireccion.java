package test.direcciones;

import BO.GestorCliente;
import DAO.DaoDirecciones;
import VO.Cliente;
import VO.Direcciones;

public class AltaTestDireccion {
	public static void main(String[] args) {

		
		  DaoDirecciones dao = new DaoDirecciones();
		  
		  Direcciones altaEntidad = new Direcciones();
		  
		  altaEntidad.setDireccion("Alta dao");
		  altaEntidad.setCodigoPostal("cpDao");
		  altaEntidad.setDestino("dao");
		  boolean testAlta = dao.crearDireccion(altaEntidad);
		  
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
