package muela.BO;

import java.util.List;

import javax.transaction.Transactional;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import muela.DAO.DaoFormatoEtiqueta;
import muela.VO.FormatoEtiqueta;

@Service
public class GestorFormatoEtiqueta {

	// @Autowired
	DaoFormatoEtiqueta daoFormatoEtiqueta = new DaoFormatoEtiqueta();

	public GestorFormatoEtiqueta() {
		super();
	}

	@Transactional
	public boolean crearFormatoEtiqueta(FormatoEtiqueta formatoEtiqueta) {

		return daoFormatoEtiqueta.crearFormatoEtiqueta(formatoEtiqueta);
	}

	@Transactional
	public boolean modificarFormatoEtiqueta(FormatoEtiqueta formatoEtiqueta) {

		return daoFormatoEtiqueta.modificarFormatoEtiqueta(formatoEtiqueta);
	}

	@Transactional
	public boolean borrarFormatoEtiqueta(FormatoEtiqueta formatoEtiqueta) {

		return daoFormatoEtiqueta.borrarFormatoEtiqueta(formatoEtiqueta);
	}

	public FormatoEtiqueta obtenerFormatoEtiqueta(int idFormato) {

		return daoFormatoEtiqueta.obtenerEtiquetaEnvio(idFormato);
	}

	public List<FormatoEtiqueta> listarFormatoEtiqueta() {

		return daoFormatoEtiqueta.listarFormatosEtiqueta();
	}

}
