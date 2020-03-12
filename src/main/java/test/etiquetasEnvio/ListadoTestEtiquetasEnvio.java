package test.etiquetasEnvio;

import java.util.List;

import BO.GestorEtiquetasEnvio;
import DAO.DaoEtiquetasEnvio;
import VO.EtiquetasEnvio;



public class ListadoTestEtiquetasEnvio {
	
	public static void main(String[] args) {

		DaoEtiquetasEnvio dao = new DaoEtiquetasEnvio();

		List<EtiquetasEnvio> listado = dao.listarTodasEtiquetasEnvio();

		System.out.println(listado);

		GestorEtiquetasEnvio gestor = new GestorEtiquetasEnvio();

		List<EtiquetasEnvio> listado2 = gestor.listarEtiquetasEnvio();

		System.out.println(listado2);

	}

}
