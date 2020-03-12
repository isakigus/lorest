package muela.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import BO.GestorEtiquetas;
import VO.Etiquetas;


@RestController
public class ControladorEtiquetas {

	GestorEtiquetas gestorEtiquetas = new GestorEtiquetas();

	@PostMapping(path = "etiquetas/crear", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Etiquetas> crear(@RequestBody Etiquetas etiqueta) {

		boolean etiquetaCreada = gestorEtiquetas.crearEtiqueta(etiqueta);

		if (etiquetaCreada) {

			return new ResponseEntity<Etiquetas>(etiqueta, HttpStatus.CREATED);
		} else {

			return new ResponseEntity<Etiquetas>(etiqueta, HttpStatus.NOT_FOUND);
		}

	}

	@PutMapping(path = "etiquetas/modificar/{idEtiqueta}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)

	public ResponseEntity<Etiquetas> modificar(@RequestBody Etiquetas etiqueta, @PathVariable Integer idEtiqueta) {

		boolean EtiquetaModificada = gestorEtiquetas.modificarEtiqueta(etiqueta);
		if (EtiquetaModificada) {

			return new ResponseEntity<Etiquetas>(etiqueta, HttpStatus.OK);
		} else {

			return new ResponseEntity<Etiquetas>(etiqueta, HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping(path = "etiquetas/borrar/{idEtiquetas}")
	public ResponseEntity<Etiquetas> borrar(@PathVariable Integer idEtiqueta) {

		Etiquetas etiqueta = new Etiquetas();
		etiqueta.setIdEtiqueta(idEtiqueta);

		boolean EtiquetaBorrada = gestorEtiquetas.borrarEtiqueta(etiqueta);

		if (EtiquetaBorrada) {

			return new ResponseEntity<Etiquetas>(HttpStatus.OK);
		} else {
			return new ResponseEntity<Etiquetas>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping(path = "etiquetas/obtener/{idEtiqueta}", produces = MediaType.APPLICATION_JSON_VALUE)

	public ResponseEntity<Etiquetas> obtener(@PathVariable("idEtiqueta") Integer idEtiqueta) {

		Etiquetas etiquetaObtenida = gestorEtiquetas.obtenerEtiqueta(idEtiqueta);
		if (etiquetaObtenida != null) {

			return new ResponseEntity<Etiquetas>(HttpStatus.OK);
		} else {
			return new ResponseEntity<Etiquetas>(HttpStatus.NOT_FOUND);
		}

	}

	@GetMapping(path = "etiquetas", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Etiquetas> listar() {

		List<Etiquetas> listaEtiquetas = gestorEtiquetas.listaEtiquetas();

		return new ResponseEntity<Etiquetas>(HttpStatus.OK);
	}

}
