package test.etiquetas;

import BO.GestorEtiquetas;
import DAO.DaoEtiquetas;
import VO.Etiquetas;

public class AltaTestEtiquetas {

	public static void main(String[] args) {

		DaoEtiquetas dao = new DaoEtiquetas();

		Etiquetas entidad = new Etiquetas();

		entidad.setFilas(3);
		entidad.setColumnas(5);
		entidad.setIdFormato(1);

		boolean testAlta = dao.crearEtiqueta(entidad);

		System.out.println(testAlta);

		GestorEtiquetas gestor = new GestorEtiquetas();
		Etiquetas entidad2 = new Etiquetas();

		entidad2.setFilas(3);
		entidad2.setColumnas(5);
		entidad2.setIdFormato(1);

		boolean testGestorAlta = gestor.crearEtiqueta(entidad2);

		System.out.println(testGestorAlta);

	}
}
