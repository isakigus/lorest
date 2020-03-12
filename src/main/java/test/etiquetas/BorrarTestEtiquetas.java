package test.etiquetas;

import BO.GestorEtiquetas;
import DAO.DaoEtiquetas;
import VO.Etiquetas;

public class BorrarTestEtiquetas {

	public static void main(String[] args) {

		DaoEtiquetas dao = new DaoEtiquetas();

		Etiquetas objetoBorrar = new Etiquetas();

		objetoBorrar.setIdEtiqueta(4);

		boolean borrado = dao.borrarEtiqueta(objetoBorrar);

		System.out.println(borrado);
		

		GestorEtiquetas gestor = new GestorEtiquetas();

		Etiquetas entidad = new Etiquetas();

		entidad.setIdEtiqueta(5);
		boolean borrada = gestor.borrarEtiqueta(entidad);

		System.out.println(borrada);
	}

}
