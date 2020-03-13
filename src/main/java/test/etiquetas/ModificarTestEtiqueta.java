package test.etiqueta;

import muela.BO.GestorEtiqueta;
import muela.DAO.DaoEtiqueta;
import muela.VO.Etiqueta;

public class ModificarTestEtiqueta {

	public static void main(String[] args) {

		DaoEtiqueta dao = new DaoEtiqueta();

		Etiqueta prueba = new Etiqueta();

		prueba.setIdEtiqueta(4);
		prueba.setFilas(10);
		prueba.setColumnas(10);
		prueba.setIdFormato(1);

		boolean modificar = dao.modificarEtiqueta(prueba);

		System.out.println(modificar);

		GestorEtiqueta gestor = new GestorEtiqueta();

		Etiqueta prueba2 = new Etiqueta();

		prueba2.setIdEtiqueta(5);
		prueba2.setFilas(15);
		prueba2.setColumnas(15);
		prueba2.setIdFormato(1);

		boolean modificar2 = gestor.modificarEtiqueta(prueba2);

		System.out.println(modificar2);

	}

}
