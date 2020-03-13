package test.etiquetaEnvio;

import muela.BO.GestorEtiquetaEnvio;
import muela.DAO.DaoEtiquetaEnvio;
import muela.VO.EtiquetaEnvio;

public class BorrarTestEtiquetaEnvio {

	public static void main(String[] args) {

		DaoEtiquetaEnvio dao = new DaoEtiquetaEnvio();

		EtiquetaEnvio objetoBorrar = new EtiquetaEnvio();

		objetoBorrar.setIdEtiquetaEnvio(11);

		boolean borrado = dao.borrarEtiquetaEnvio(objetoBorrar);

		System.out.println(borrado);


		GestorEtiquetaEnvio gestor = new GestorEtiquetaEnvio();

		EtiquetaEnvio entidad = new EtiquetaEnvio();

		entidad.setIdEtiquetaEnvio(12);
		boolean borrada = gestor.borrarEtiquetaEnvio(entidad);

		System.out.println(borrada);
	}

}
