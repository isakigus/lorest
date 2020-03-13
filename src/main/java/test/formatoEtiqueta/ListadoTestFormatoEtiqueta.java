package test.formatoEtiqueta;

import java.util.List;

import muela.BO.GestorFormatoEtiqueta;
import muela.DAO.DaoFormatoEtiqueta;
import muela.VO.FormatoEtiqueta;



public class ListadoTestFormatoEtiqueta {

	public static void main(String[] args) {

		DaoFormatoEtiqueta dao = new DaoFormatoEtiqueta();

		List<FormatoEtiqueta> listado = dao.listarFormatosEtiqueta();

		System.out.println(listado);

		GestorFormatoEtiqueta gestor = new GestorFormatoEtiqueta();

		List<FormatoEtiqueta> listado2 = gestor.listarFormatoEtiqueta();

		System.out.println(listado2);

	}

}
