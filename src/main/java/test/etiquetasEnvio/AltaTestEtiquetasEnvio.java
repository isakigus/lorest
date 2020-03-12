package test.etiquetasEnvio;

import BO.GestorEtiquetasEnvio;
import DAO.DaoEtiquetasEnvio;
import VO.EtiquetasEnvio;

public class AltaTestEtiquetasEnvio {

	public static void main(String[] args) {

		DaoEtiquetasEnvio dao = new DaoEtiquetasEnvio();

		EtiquetasEnvio entidad = new EtiquetasEnvio();

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

		GestorEtiquetasEnvio gestor = new GestorEtiquetasEnvio();
		EtiquetasEnvio entidad2 = new EtiquetasEnvio();

		entidad2.setIdEmpresaMensajes(5);
		entidad2.setIdEmpresaEmisora(8);
		entidad2.setIdEmpresaReceptora(5);
		entidad2.setExpedicion("alta gestor");
		entidad2.setReferencia("Alta gestor");
		entidad2.setKilos("45");
		entidad2.setBultos("4");
		entidad2.setReembolso(20);

		boolean testGestorAlta = gestor.crearEtiquetasEnvio(entidad2);

		System.out.println(testGestorAlta);

	}

}
