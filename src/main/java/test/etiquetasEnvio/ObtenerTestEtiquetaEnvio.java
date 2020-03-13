package test.etiquetaEnvio;

import muela.BO.GestorEtiquetaEnvio;
import muela.DAO.DaoEtiquetaEnvio;
import muela.VO.EtiquetaEnvio;

public class ObtenerTestEtiquetaEnvio {
	public static void main(String[] args) {

		DaoEtiquetaEnvio dao = new DaoEtiquetaEnvio();

		EtiquetaEnvio selecionado = dao.obtenerEtiquetaEnvio(4);

		System.out.println(selecionado);

		GestorEtiquetaEnvio gestor = new GestorEtiquetaEnvio();

		EtiquetaEnvio selecionado2 = gestor.obtenerEtiquetaEnvio(4);

		System.out.println(selecionado2);

	}

}
