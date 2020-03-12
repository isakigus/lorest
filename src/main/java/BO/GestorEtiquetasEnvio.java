package BO;

import java.util.List;

import javax.transaction.Transactional;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DAO.DaoEtiquetasEnvio;
import VO.EtiquetasEnvio;

@Service
public class GestorEtiquetasEnvio {

	// @Autowired
	DaoEtiquetasEnvio daoEtiquetasEnvio = new DaoEtiquetasEnvio();

	public GestorEtiquetasEnvio() {
		super();
	}

	@Transactional
	public boolean crearEtiquetasEnvio(EtiquetasEnvio etiquetaEnvio) {

		return daoEtiquetasEnvio.crearEtiquetaEnvio(etiquetaEnvio);
	}

	@Transactional
	public boolean modificarEtiquetaEnvio(EtiquetasEnvio etiquetaEnvio) {

		return daoEtiquetasEnvio.modificarEtiquetaEnvio(etiquetaEnvio);
	}

	@Transactional
	public boolean borrarEtiquetaEnvio(EtiquetasEnvio etiquetaEnvio) {

		return daoEtiquetasEnvio.borrarEtiquetaEnvio(etiquetaEnvio);

	}

	public EtiquetasEnvio obtenerEtiquetaEnvio(int idEtiquetaEnvio) {

		return daoEtiquetasEnvio.obtenerEtiquetaEnvio(idEtiquetaEnvio);
	}

	public List<EtiquetasEnvio> listarEtiquetasEnvio() {

		return daoEtiquetasEnvio.listarTodasEtiquetasEnvio();
	}

}
