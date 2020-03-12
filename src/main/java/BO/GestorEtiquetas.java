package BO;

import java.util.List;

import javax.transaction.Transactional;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DAO.DaoEtiquetas;
import VO.Etiquetas;

@Service
public class GestorEtiquetas {

	// @Autowired
	DaoEtiquetas daoEtiquetas = new DaoEtiquetas();

	public GestorEtiquetas() {
		super();
	}

	@Transactional
	public boolean crearEtiqueta(Etiquetas etiqueta) {
		return daoEtiquetas.crearEtiqueta(etiqueta);
	}

	@Transactional
	public boolean modificarEtiqueta(Etiquetas etiqueta) {
		return daoEtiquetas.modificarEtiqueta(etiqueta);
	}

	@Transactional
	public boolean borrarEtiqueta(Etiquetas etiqueta) {
		return daoEtiquetas.borrarEtiqueta(etiqueta);

	}

	public Etiquetas obtenerEtiqueta(int idEtiqueta) {

		return daoEtiquetas.obtenerEtiqueta(idEtiqueta);
	}

	public List<Etiquetas> listaEtiquetas() {

		return daoEtiquetas.listarTodasEtiquetas();

	}

}
