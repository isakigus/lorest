package test.formatoEtiqueta;

import BO.GestorFormatoEtiquetas;
import DAO.DaoFormatoEtiqueta;
import VO.FormatoEtiqueta;

public class ObtenerTestFormatoEtiqueta {

	public static void main(String[] args) {

		DaoFormatoEtiqueta dao = new DaoFormatoEtiqueta();

		FormatoEtiqueta Selecionado = dao.obtenerEtiquetaEnvio(3);

		System.out.println(Selecionado);

		GestorFormatoEtiquetas gestor = new GestorFormatoEtiquetas();

		FormatoEtiqueta Selecionado2 = gestor.obtenerFormatoEtiqueta(3);

		System.out.println(Selecionado2);

	}

}
