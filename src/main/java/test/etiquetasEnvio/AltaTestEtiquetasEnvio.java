package test.etiquetaEnvio;

import muela.BO.GestorEtiquetaEnvio;
import muela.DAO.DaoEtiquetaEnvio;
import muela.VO.EtiquetaEnvio;

public class AltaTestEtiquetaEnvio {

	public static void main(String[] args) {

		DaoEtiquetaEnvio dao = new DaoEtiquetaEnvio();

		EtiquetaEnvio entidad = new EtiquetaEnvio();

		entidad.setIdEmpresaMensajes(5);
		entidad.setIdEmpresaEmisora(8);
		entidad.setIdEmpresaReceptora(5);
		entidad.setExpedicion("alta dao");
		entidad.setReferencia("Alta dao");
		entidad.setKilos("45");
		entidad.setBultos("4");
		entidad.setReembolso(20);

		boolean testAlta = dao.crearEtiquetaEnvio(entidad);

		System.out.println(testAlta);

		GestorEtiquetaEnvio gestor = new GestorEtiquetaEnvio();
		EtiquetaEnvio entidad2 = new EtiquetaEnvio();

		entidad2.setIdEmpresaMensajes(5);
		entidad2.setIdEmpresaEmisora(8);
		entidad2.setIdEmpresaReceptora(5);
		entidad2.setExpedicion("alta gestor");
		entidad2.setReferencia("Alta gestor");
		entidad2.setKilos("45");
		entidad2.setBultos("4");
		entidad2.setReembolso(20);

		boolean testGestorAlta = gestor.crearEtiquetaEnvio(entidad2);

		System.out.println(testGestorAlta);

	}

}
