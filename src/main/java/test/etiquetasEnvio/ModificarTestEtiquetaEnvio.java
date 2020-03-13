package test.etiquetaEnvio;

import muela.BO.GestorEtiquetaEnvio;
import muela.DAO.DaoEtiquetaEnvio;
import muela.VO.EtiquetaEnvio;

public class ModificarTestEtiquetaEnvio {

	public static void main(String[] args) {

		DaoEtiquetaEnvio dao = new DaoEtiquetaEnvio();

		EtiquetaEnvio prueba = new EtiquetaEnvio();

		prueba.setIdEtiquetaEnvio(4);
		prueba.setIdEmpresaMensajes(5);
		prueba.setIdEmpresaEmisora(8);
		prueba.setIdEmpresaReceptora(9);
		prueba.setExpedicion("modifDao");
		prueba.setReferencia("modDao");
		prueba.setKilos("23");
		prueba.setBultos("5");
		prueba.setReembolso(56);

		boolean modificar = dao.modificarEtiquetaEnvio(prueba);

		System.out.println(modificar);

		GestorEtiquetaEnvio gestor = new GestorEtiquetaEnvio();

		EtiquetaEnvio prueba2 = new EtiquetaEnvio();

		prueba2.setIdEtiquetaEnvio(5);
		prueba2.setIdEmpresaMensajes(5);
		prueba2.setIdEmpresaEmisora(8);
		prueba2.setIdEmpresaReceptora(9);
		prueba2.setExpedicion("modifGes");
		prueba2.setReferencia("modGest");
		prueba2.setKilos("56");
		prueba2.setBultos("5");
		prueba2.setReembolso(56);

		boolean modificar2 = gestor.modificarEtiquetaEnvio(prueba2);

		System.out.println(modificar2);

	}
}
