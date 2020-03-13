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

import muela.BO.GestorEtiqueta;
import muela.VO.Etiqueta;


@RestController
public class ControladorEtiqueta {

	GestorEtiqueta gestorEtiqueta = new GestorEtiqueta();

	@PostMapping(path = "etiqueta/crear", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Etiqueta> crear(@RequestBody Etiqueta etiqueta) {

		boolean etiquetaCreada = gestorEtiqueta.crearEtiqueta(etiqueta);

		if (etiquetaCreada) {

			return new ResponseEntity<Etiqueta>(etiqueta, HttpStatus.CREATED);
		} else {

			return new ResponseEntity<Etiqueta>(etiqueta, HttpStatus.NOT_FOUND);
		}

	}

	@PutMapping(path = "etiqueta/modificar/{idEtiqueta}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)

	public ResponseEntity<Etiqueta> modificar(@RequestBody Etiqueta etiqueta, @PathVariable Integer idEtiqueta) {

		boolean EtiquetaModificada = gestorEtiqueta.modificarEtiqueta(etiqueta);
		if (EtiquetaModificada) {

			return new ResponseEntity<Etiqueta>(etiqueta, HttpStatus.OK);
		} else {

			return new ResponseEntity<Etiqueta>(etiqueta, HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping(path = "etiqueta/borrar/{idEtiqueta}")
	public ResponseEntity<Etiqueta> borrar(@PathVariable Integer idEtiqueta) {

		Etiqueta etiqueta = new Etiqueta();
		etiqueta.setIdEtiqueta(idEtiqueta);

		boolean EtiquetaBorrada = gestorEtiqueta.borrarEtiqueta(etiqueta);

		if (EtiquetaBorrada) {

			return new ResponseEntity<Etiqueta>(HttpStatus.OK);
		} else {
			return new ResponseEntity<Etiqueta>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping(path = "etiqueta/obtener/{idEtiqueta}", produces = MediaType.APPLICATION_JSON_VALUE)

	public ResponseEntity<Etiqueta> obtener(@PathVariable("idEtiqueta") Integer idEtiqueta) {

		Etiqueta etiquetaObtenida = gestorEtiqueta.obtenerEtiqueta(idEtiqueta);
		if (etiquetaObtenida != null) {

			return new ResponseEntity<Etiqueta>(HttpStatus.OK);
		} else {
			return new ResponseEntity<Etiqueta>(HttpStatus.NOT_FOUND);
		}

	}

	@GetMapping(path = "etiqueta", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Etiqueta> listar() {

		List<Etiqueta> listaEtiqueta = gestorEtiqueta.listaEtiqueta();

		return new ResponseEntity<Etiqueta>(HttpStatus.OK);
	}

}
