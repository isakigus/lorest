package test.etiquetaEnvio;

import java.util.List;

import muela.BO.GestorEtiquetaEnvio;
import muela.DAO.DaoEtiquetaEnvio;
import muela.VO.EtiquetaEnvio;



public class ListadoTestEtiquetaEnvio {

	public static void main(String[] args) {

		DaoEtiquetaEnvio dao = new DaoEtiquetaEnvio();

		List<EtiquetaEnvio> listado = dao.listarTodasEtiquetaEnvio();

		System.out.println(listado);

		GestorEtiquetaEnvio gestor = new GestorEtiquetaEnvio();

		List<EtiquetaEnvio> listado2 = gestor.listarEtiquetaEnvio();

		System.out.println(listado2);

	}

}
