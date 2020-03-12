package test.etiquetasEnvio;

import BO.GestorEtiquetasEnvio;
import DAO.DaoEtiquetasEnvio;
import VO.EtiquetasEnvio;

public class ObtenerTestEtiquetaEnvio {
	public static void main(String[] args) {

		DaoEtiquetasEnvio dao = new DaoEtiquetasEnvio();

		EtiquetasEnvio selecionado = dao.obtenerEtiquetaEnvio(4);

		System.out.println(selecionado);

		GestorEtiquetasEnvio gestor = new GestorEtiquetasEnvio();

		EtiquetasEnvio selecionado2 = gestor.obtenerEtiquetaEnvio(4);

		System.out.println(selecionado2);

	}

}
