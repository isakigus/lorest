package test.formatoEtiqueta;

import java.util.List;

import BO.GestorFormatoEtiquetas;
import DAO.DaoFormatoEtiqueta;
import VO.FormatoEtiqueta;



public class ListadoTestFormatoEtiqueta {
	
	public static void main(String[] args) {

		DaoFormatoEtiqueta dao = new DaoFormatoEtiqueta();

		List<FormatoEtiqueta> listado = dao.listarFormatosEtiqueta();

		System.out.println(listado);

		GestorFormatoEtiquetas gestor = new GestorFormatoEtiquetas();

		List<FormatoEtiqueta> listado2 = gestor.listarFormatoEtiquetas();

		System.out.println(listado2);

	}

}
