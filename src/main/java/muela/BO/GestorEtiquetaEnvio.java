package muela.BO;

import java.util.List;

import javax.transaction.Transactional;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import muela.DAO.DaoEtiquetaEnvio;
import muela.VO.EtiquetaEnvio;

@Service
public class GestorEtiquetaEnvio {

	// @Autowired
	DaoEtiquetaEnvio daoEtiquetaEnvio = new DaoEtiquetaEnvio();

	public GestorEtiquetaEnvio() {
		super();
	}

	@Transactional
	public boolean crearEtiquetaEnvio(EtiquetaEnvio etiquetaEnvio) {

		return daoEtiquetaEnvio.crearEtiquetaEnvio(etiquetaEnvio);
	}

	@Transactional
	public boolean modificarEtiquetaEnvio(EtiquetaEnvio etiquetaEnvio) {

		return daoEtiquetaEnvio.modificarEtiquetaEnvio(etiquetaEnvio);
	}

	@Transactional
	public boolean borrarEtiquetaEnvio(EtiquetaEnvio etiquetaEnvio) {

		return daoEtiquetaEnvio.borrarEtiquetaEnvio(etiquetaEnvio);

	}

	public EtiquetaEnvio obtenerEtiquetaEnvio(int idEtiquetaEnvio) {

		return daoEtiquetaEnvio.obtenerEtiquetaEnvio(idEtiquetaEnvio);
	}

	public List<EtiquetaEnvio> listarEtiquetaEnvio() {

		return daoEtiquetaEnvio.listarTodasEtiquetaEnvio();
	}

}
