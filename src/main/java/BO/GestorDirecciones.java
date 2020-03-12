package BO;

import java.util.List;

import javax.transaction.Transactional;


import org.springframework.stereotype.Service;
import DAO.DaoDirecciones;
import VO.Direcciones;

@Service
public class GestorDirecciones {

	public GestorDirecciones() {
		super();
	}

	// @Autowired
	DaoDirecciones daoDirecciones = new DaoDirecciones();

	@Transactional
	public boolean crearDireccion(Direcciones direccion) {

		return daoDirecciones.crearDireccion(direccion);

	}

	@Transactional
	public boolean modificarDireccion(Direcciones direccion) {

		return daoDirecciones.modificarDireccion(direccion);
	}

	@Transactional
	public boolean borrarDireccion(Direcciones direccion) {

		return daoDirecciones.borrarDireccion(direccion);
	}

	public Direcciones obtenerDireccion(int idDireccion) {

		return daoDirecciones.obtenerDireccion(idDireccion);

	}

	public List<Direcciones> listarDirecciones() {

		return daoDirecciones.listarTodasDirecciones();
	}

}
