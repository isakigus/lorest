package muela.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import BO.GestorDirecciones;
import VO.Direcciones;

@RestController
public class ControladorDirecciones {

	// @Autowired
	GestorDirecciones gestorDireccion = new GestorDirecciones();

	// @RequestMapping(value = "/direccion", method = RequestMethod.GET)
	@PostMapping(path = "direccion/crear", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Direcciones> crear(@RequestBody Direcciones direccion) {

		boolean direccionCreada = gestorDireccion.crearDireccion(direccion);

		if (direccionCreada) {

			return new ResponseEntity<Direcciones>(direccion, HttpStatus.CREATED);
		} else {

			return new ResponseEntity<Direcciones>(direccion, HttpStatus.NOT_FOUND);
		}

	}

	@PutMapping(path = "direccion/modificar/{idDireccion}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)

	public ResponseEntity<Direcciones> modificar(@RequestBody Direcciones direccion,
			@PathVariable Integer idDireccion) {

		boolean direccionModificada = gestorDireccion.modificarDireccion(direccion);

		if (direccionModificada) {

			return new ResponseEntity<Direcciones>(direccion, HttpStatus.OK);
		} else {

			return new ResponseEntity<Direcciones>(direccion, HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping(path = "direccion/borrar/{idDireccion}")
	public ResponseEntity<Direcciones> borrar(@PathVariable Integer idDireccion) {

		Direcciones direccion = new Direcciones();
		direccion.setIdDireccion(idDireccion);

		boolean direccionBorrada = gestorDireccion.borrarDireccion(direccion);

		if (direccionBorrada) {

			return new ResponseEntity<Direcciones>(HttpStatus.OK);
		} else {
			return new ResponseEntity<Direcciones>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping(path = "direccion/otener/{idDireccion}", produces = MediaType.APPLICATION_JSON_VALUE)

	public ResponseEntity<Direcciones> obtener(@PathVariable("idDireccion") Integer idDireccion) {

		Direcciones direccionObtenida = gestorDireccion.obtenerDireccion(idDireccion);

		if (direccionObtenida != null) {

			return new ResponseEntity<Direcciones>(HttpStatus.OK);
		} else {
			return new ResponseEntity<Direcciones>(HttpStatus.NOT_FOUND);
		}

	}

	@GetMapping(path = "direcciones", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Direcciones> listar() {

		List<Direcciones> listaDirecciones = gestorDireccion.listarDirecciones();

		return new ResponseEntity<Direcciones>(HttpStatus.OK);
	}
}

