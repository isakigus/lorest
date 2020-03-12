package test.formatoEtiqueta;

import BO.GestorFormatoEtiquetas;
import DAO.DaoFormatoEtiqueta;
import VO.FormatoEtiqueta;

public class AltaTestFormatoEtiquetas {

	public static void main(String[] args) {

		DaoFormatoEtiqueta dao = new DaoFormatoEtiqueta();

		FormatoEtiqueta entidad = new FormatoEtiqueta();

		entidad.setCodCliente(6);
		entidad.setCodClienteExtendido("dao");
		entidad.setCodBarras(3);
		entidad.setEan(1);
		entidad.setDireccion1(1);
		entidad.setDireccion2(3);

		boolean testAlta = dao.crearFormatoEtiqueta(entidad);

		System.out.println(testAlta);

		GestorFormatoEtiquetas gestor = new GestorFormatoEtiquetas();
		FormatoEtiqueta entidad2 = new FormatoEtiqueta();

		entidad2.setCodCliente(6);
		entidad2.setCodClienteExtendido("gesto");
		entidad2.setCodBarras(3);
		entidad2.setEan(1);
		entidad2.setDireccion1(1);
		entidad2.setDireccion2(3);

		boolean testGestorAlta = gestor.crearFormatoEtiqueta(entidad2);

		System.out.println(testGestorAlta);

	}

}
