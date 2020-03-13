package muela.BO;

import java.util.List;

import javax.transaction.Transactional;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import muela.DAO.DaoEtiqueta;
import muela.VO.Etiqueta;

@Service
public class GestorEtiqueta {

	// @Autowired
	DaoEtiqueta daoEtiqueta = new DaoEtiqueta();

	public GestorEtiqueta() {
		super();
	}

	@Transactional
	public boolean crearEtiqueta(Etiqueta etiqueta) {
		return daoEtiqueta.crearEtiqueta(etiqueta);
	}

	@Transactional
	public boolean modificarEtiqueta(Etiqueta etiqueta) {
		return daoEtiqueta.modificarEtiqueta(etiqueta);
	}

	@Transactional
	public boolean borrarEtiqueta(Etiqueta etiqueta) {
		return daoEtiqueta.borrarEtiqueta(etiqueta);

	}

	public Etiqueta obtenerEtiqueta(int idEtiqueta) {

		return daoEtiqueta.obtenerEtiqueta(idEtiqueta);
	}

	public List<Etiqueta> listaEtiqueta() {

		return daoEtiqueta.listarTodasEtiqueta();

	}

}
