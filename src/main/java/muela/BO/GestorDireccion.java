package muela.BO;

import java.util.List;

import javax.transaction.Transactional;


import org.springframework.stereotype.Service;
import muela.DAO.DaoDireccion;
import muela.VO.Direccion;

@Service
public class GestorDireccion {

	public GestorDireccion() {
		super();
	}

	// @Autowired
	DaoDireccion daoDireccion = new DaoDireccion();

	@Transactional
	public boolean crearDireccion(Direccion direccion) {

		return daoDireccion.crearDireccion(direccion);

	}

	@Transactional
	public boolean modificarDireccion(Direccion direccion) {

		return daoDireccion.modificarDireccion(direccion);
	}

	@Transactional
	public boolean borrarDireccion(Direccion direccion) {

		return daoDireccion.borrarDireccion(direccion);
	}

	public Direccion obtenerDireccion(int idDireccion) {

		return daoDireccion.obtenerDireccion(idDireccion);

	}

	public List<Direccion> listarDireccion() {

		return daoDireccion.listarTodasDireccion();
	}

}
