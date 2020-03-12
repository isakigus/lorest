package test.formatoEtiqueta;

import BO.GestorFormatoEtiquetas;
import DAO.DaoFormatoEtiqueta;
import VO.FormatoEtiqueta;

public class ModificarTestFormatoEtiqueta {

	public static void main(String[] args) {

		DaoFormatoEtiqueta dao = new DaoFormatoEtiqueta();

		FormatoEtiqueta prueba = new FormatoEtiqueta();

		prueba.setIdFormato(1);
		prueba.setCodCliente(1);
		prueba.setCodClienteExtendido("dao");
		prueba.setCodBarras(2);
		prueba.setEan(3);
		prueba.setDireccion1(3);
		prueba.setDireccion2(1);

		boolean modificar = dao.modificarFormatoEtiqueta(prueba);

		System.out.println(modificar);

		GestorFormatoEtiquetas gestor = new GestorFormatoEtiquetas();

		FormatoEtiqueta prueba2 = new FormatoEtiqueta();

		prueba2.setIdFormato(2);
		prueba2.setCodCliente(1);
		prueba2.setCodClienteExtendido("gest");
		prueba2.setCodBarras(2);
		prueba2.setEan(3);
		prueba2.setDireccion1(3);
		prueba2.setDireccion2(1);

		boolean modificar2 = gestor.modificarFormatoEtiqueta(prueba2);

		System.out.println(modificar2);

	}
}
