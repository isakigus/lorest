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
import muela.BO.GestorDireccion;
import muela.VO.Direccion;

@RestController
public class ControladorDireccion {

	// @Autowired
	GestorDireccion gestorDireccion = new GestorDireccion();

	// @RequestMapping(value = "/direccion", method = RequestMethod.GET)
	@PostMapping(path = "direccion/crear", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Direccion> crear(@RequestBody Direccion direccion) {

		boolean direccionCreada = gestorDireccion.crearDireccion(direccion);

		if (direccionCreada) {

			return new ResponseEntity<Direccion>(direccion, HttpStatus.CREATED);
		} else {

			return new ResponseEntity<Direccion>(direccion, HttpStatus.NOT_FOUND);
		}

	}

	@PutMapping(path = "direccion/modificar/{idDireccion}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)

	public ResponseEntity<Direccion> modificar(@RequestBody Direccion direccion,
			@PathVariable Integer idDireccion) {

		boolean direccionModificada = gestorDireccion.modificarDireccion(direccion);

		if (direccionModificada) {

			return new ResponseEntity<Direccion>(direccion, HttpStatus.OK);
		} else {

			return new ResponseEntity<Direccion>(direccion, HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping(path = "direccion/borrar/{idDireccion}")
	public ResponseEntity<Direccion> borrar(@PathVariable Integer idDireccion) {

		Direccion direccion = new Direccion();
		direccion.setIdDireccion(idDireccion);

		boolean direccionBorrada = gestorDireccion.borrarDireccion(direccion);

		if (direccionBorrada) {

			return new ResponseEntity<Direccion>(HttpStatus.OK);
		} else {
			return new ResponseEntity<Direccion>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping(path = "direccion/otener/{idDireccion}", produces = MediaType.APPLICATION_JSON_VALUE)

	public ResponseEntity<Direccion> obtener(@PathVariable("idDireccion") Integer idDireccion) {

		Direccion direccionObtenida = gestorDireccion.obtenerDireccion(idDireccion);

		if (direccionObtenida != null) {

			return new ResponseEntity<Direccion>(HttpStatus.OK);
		} else {
			return new ResponseEntity<Direccion>(HttpStatus.NOT_FOUND);
		}

	}

	@GetMapping(path = "direccion", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Direccion> listar() {

		List<Direccion> listaDireccion = gestorDireccion.listarDireccion();

		return new ResponseEntity<Direccion>(HttpStatus.OK);
	}
}

