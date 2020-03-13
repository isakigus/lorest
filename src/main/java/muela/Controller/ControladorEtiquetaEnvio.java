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

import muela.BO.GestorEtiquetaEnvio;
import muela.VO.EtiquetaEnvio;

@RestController
public class ControladorEtiquetaEnvio {

	GestorEtiquetaEnvio gestorEtiquetaEnvio = new GestorEtiquetaEnvio();

	@PostMapping(path = "etiquetaEnvio/crear", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EtiquetaEnvio> crear(@RequestBody EtiquetaEnvio etiquetaEnvio) {

		boolean etiquetaEnvioCreada = gestorEtiquetaEnvio.crearEtiquetaEnvio(etiquetaEnvio);
		if (etiquetaEnvioCreada) {

			return new ResponseEntity<EtiquetaEnvio>(etiquetaEnvio, HttpStatus.CREATED);
		} else {

			return new ResponseEntity<EtiquetaEnvio>(etiquetaEnvio, HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping(path = "etiquetaEnvio/modificar/{idEtiquetaEnvio}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)

	public ResponseEntity<EtiquetaEnvio> modificar(@RequestBody EtiquetaEnvio etiquetaEnvio,
			@PathVariable Integer idEtiquetaEnvio) {

		boolean EtiquetaEnvioModificada = gestorEtiquetaEnvio.modificarEtiquetaEnvio(etiquetaEnvio);
		if (EtiquetaEnvioModificada) {

			return new ResponseEntity<EtiquetaEnvio>(etiquetaEnvio, HttpStatus.OK);
		} else {

			return new ResponseEntity<EtiquetaEnvio>(etiquetaEnvio, HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping(path = "etiquetaEnvio/borrar/{idEtiquetaEnvio}")
	public ResponseEntity<EtiquetaEnvio> borrar(@PathVariable Integer idEtiquetaEnvio) {

		EtiquetaEnvio etiquetaEnvio = new EtiquetaEnvio();
		etiquetaEnvio.setIdEtiquetaEnvio(idEtiquetaEnvio);

		boolean etiquetaEnvioBorrada = gestorEtiquetaEnvio.borrarEtiquetaEnvio(etiquetaEnvio);
		if (etiquetaEnvioBorrada) {

			return new ResponseEntity<EtiquetaEnvio>(HttpStatus.OK);
		} else {
			return new ResponseEntity<EtiquetaEnvio>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping(path = "etiquetaEnvio/obtener/{idEtiquetaEnvio}", produces = MediaType.APPLICATION_JSON_VALUE)

	public ResponseEntity<EtiquetaEnvio> obtener(@PathVariable("idEtiquetaEnvio") Integer idEtiquetaEnvio) {

		EtiquetaEnvio etiquetaEnvioObtenida = gestorEtiquetaEnvio.obtenerEtiquetaEnvio(idEtiquetaEnvio);
		if (etiquetaEnvioObtenida != null) {

			return new ResponseEntity<EtiquetaEnvio>(HttpStatus.OK);
		} else {
			return new ResponseEntity<EtiquetaEnvio>(HttpStatus.NOT_FOUND);
		}

	}

	@GetMapping(path = "etiquetaEnvio", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EtiquetaEnvio> listar() {

		List<EtiquetaEnvio> listaEtiquetaEnvio = gestorEtiquetaEnvio.listarEtiquetaEnvio();

		return new ResponseEntity<EtiquetaEnvio>(HttpStatus.OK);
	}

}
