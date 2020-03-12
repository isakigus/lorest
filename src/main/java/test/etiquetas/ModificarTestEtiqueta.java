package test.etiquetas;

import BO.GestorEtiquetas;
import DAO.DaoEtiquetas;
import VO.Etiquetas;

public class ModificarTestEtiqueta {

	public static void main(String[] args) {

		DaoEtiquetas dao = new DaoEtiquetas();

		Etiquetas prueba = new Etiquetas();

		prueba.setIdEtiqueta(4);
		prueba.setFilas(10);
		prueba.setColumnas(10);
		prueba.setIdFormato(1);

		boolean modificar = dao.modificarEtiqueta(prueba);

		System.out.println(modificar);

		GestorEtiquetas gestor = new GestorEtiquetas();

		Etiquetas prueba2 = new Etiquetas();

		prueba2.setIdEtiqueta(5);
		prueba2.setFilas(15);
		prueba2.setColumnas(15);
		prueba2.setIdFormato(1);

		boolean modificar2 = gestor.modificarEtiqueta(prueba2);

		System.out.println(modificar2);

	}

}
