package test.etiqueta;

import muela.BO.GestorEtiqueta;
import muela.DAO.DaoEtiqueta;
import muela.VO.Etiqueta;

public class BorrarTestEtiqueta {

	public static void main(String[] args) {

		DaoEtiqueta dao = new DaoEtiqueta();

		Etiqueta objetoBorrar = new Etiqueta();

		objetoBorrar.setIdEtiqueta(4);

		boolean borrado = dao.borrarEtiqueta(objetoBorrar);

		System.out.println(borrado);


		GestorEtiqueta gestor = new GestorEtiqueta();

		Etiqueta entidad = new Etiqueta();

		entidad.setIdEtiqueta(5);
		boolean borrada = gestor.borrarEtiqueta(entidad);

		System.out.println(borrada);
	}

}
