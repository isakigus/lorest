package test.formatoEtiqueta;

import muela.BO.GestorFormatoEtiqueta;
import muela.DAO.DaoFormatoEtiqueta;
import muela.VO.FormatoEtiqueta;

public class ObtenerTestFormatoEtiqueta {

	public static void main(String[] args) {

		DaoFormatoEtiqueta dao = new DaoFormatoEtiqueta();

		FormatoEtiqueta Selecionado = dao.obtenerEtiquetaEnvio(3);

		System.out.println(Selecionado);

		GestorFormatoEtiqueta gestor = new GestorFormatoEtiqueta();

		FormatoEtiqueta Selecionado2 = gestor.obtenerFormatoEtiqueta(3);

		System.out.println(Selecionado2);

	}

}
