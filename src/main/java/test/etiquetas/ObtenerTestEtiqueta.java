package test.etiqueta;

import muela.BO.GestorEtiqueta;
import muela.DAO.DaoEtiqueta;
import muela.VO.Etiqueta;

public class ObtenerTestEtiqueta {

	public static void main(String[] args) {


		DaoEtiqueta dao = new DaoEtiqueta();

		Etiqueta selecionado = dao.obtenerEtiqueta(5);

		System.out.println(selecionado);




		GestorEtiqueta gestor = new GestorEtiqueta();

		Etiqueta selecionado2 = gestor.obtenerEtiqueta(5);

		System.out.println(selecionado2);


		;

	}

}
