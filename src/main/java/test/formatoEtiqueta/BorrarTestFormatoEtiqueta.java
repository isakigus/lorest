package test.formatoEtiqueta;

import BO.GestorFormatoEtiquetas;
import DAO.DaoFormatoEtiqueta;
import VO.FormatoEtiqueta;

public class BorrarTestFormatoEtiqueta {
	
	public static void main(String[] args) {

		DaoFormatoEtiqueta dao = new DaoFormatoEtiqueta();

		FormatoEtiqueta objetoBorrar = new FormatoEtiqueta();

		objetoBorrar.setIdFormato(7);

		boolean borrado = dao.borrarFormatoEtiqueta(objetoBorrar);

		System.out.println(borrado);
		

		GestorFormatoEtiquetas gestor = new GestorFormatoEtiquetas();

		FormatoEtiqueta entidad = new FormatoEtiqueta();

		entidad.setIdFormato(8);
		boolean borrada = gestor.borrarFormatoEtiqueta(entidad);

		System.out.println(borrada);
	}

}
