package test.etiqueta;

import muela.BO.GestorEtiqueta;
import muela.DAO.DaoEtiqueta;
import muela.VO.Etiqueta;

public class AltaTestEtiqueta {

	public static void main(String[] args) {

		DaoEtiqueta dao = new DaoEtiqueta();

		Etiqueta entidad = new Etiqueta();

		entidad.setFilas(3);
		entidad.setColumnas(5);
		entidad.setIdFormato(1);

		boolean testAlta = dao.crearEtiqueta(entidad);

		System.out.println(testAlta);

		GestorEtiqueta gestor = new GestorEtiqueta();
		Etiqueta entidad2 = new Etiqueta();

		entidad2.setFilas(3);
		entidad2.setColumnas(5);
		entidad2.setIdFormato(1);

		boolean testGestorAlta = gestor.crearEtiqueta(entidad2);

		System.out.println(testGestorAlta);

	}
}
