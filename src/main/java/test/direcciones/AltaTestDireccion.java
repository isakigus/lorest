package test.direccion;

import muela.BO.GestorCliente;
import muela.DAO.DaoDireccion;
import muela.VO.Cliente;
import muela.VO.Direccion;

public class AltaTestDireccion {
	public static void main(String[] args) {


		  DaoDireccion dao = new DaoDireccion();

		  Direccion altaEntidad = new Direccion();

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
