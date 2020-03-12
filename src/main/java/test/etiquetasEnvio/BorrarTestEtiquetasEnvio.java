package test.etiquetasEnvio;

import BO.GestorEtiquetasEnvio;
import DAO.DaoEtiquetasEnvio;
import VO.EtiquetasEnvio;

public class BorrarTestEtiquetasEnvio {
	
	public static void main(String[] args) {

		DaoEtiquetasEnvio dao = new DaoEtiquetasEnvio();

		EtiquetasEnvio objetoBorrar = new EtiquetasEnvio();

		objetoBorrar.setIdEtiquetaEnvio(11);

		boolean borrado = dao.borrarEtiquetaEnvio(objetoBorrar);

		System.out.println(borrado);
		

		GestorEtiquetasEnvio gestor = new GestorEtiquetasEnvio();

		EtiquetasEnvio entidad = new EtiquetasEnvio();

		entidad.setIdEtiquetaEnvio(12);
		boolean borrada = gestor.borrarEtiquetaEnvio(entidad);

		System.out.println(borrada);
	}

}
