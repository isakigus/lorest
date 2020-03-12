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

import BO.GestorEtiquetasEnvio;
import VO.EtiquetasEnvio;

@RestController
public class ControladorEtiquetasEnvio {

	GestorEtiquetasEnvio gestorEtiquetasEnvio = new GestorEtiquetasEnvio();

	@PostMapping(path = "etiquetasEnvio/crear", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EtiquetasEnvio> crear(@RequestBody EtiquetasEnvio etiquetaEnvio) {

		boolean etiquetaEnvioCreada = gestorEtiquetasEnvio.crearEtiquetasEnvio(etiquetaEnvio);
		if (etiquetaEnvioCreada) {

			return new ResponseEntity<EtiquetasEnvio>(etiquetaEnvio, HttpStatus.CREATED);
		} else {

			return new ResponseEntity<EtiquetasEnvio>(etiquetaEnvio, HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping(path = "etiquetasEnvio/modificar/{idEtiquetaEnvio}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)

	public ResponseEntity<EtiquetasEnvio> modificar(@RequestBody EtiquetasEnvio etiquetaEnvio,
			@PathVariable Integer idEtiquetaEnvio) {

		boolean EtiquetaEnvioModificada = gestorEtiquetasEnvio.modificarEtiquetaEnvio(etiquetaEnvio);
		if (EtiquetaEnvioModificada) {

			return new ResponseEntity<EtiquetasEnvio>(etiquetaEnvio, HttpStatus.OK);
		} else {

			return new ResponseEntity<EtiquetasEnvio>(etiquetaEnvio, HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping(path = "etiquetasEnvio/borrar/{idEtiquetaEnvio}")
	public ResponseEntity<EtiquetasEnvio> borrar(@PathVariable Integer idEtiquetaEnvio) {

		EtiquetasEnvio etiquetaEnvio = new EtiquetasEnvio();
		etiquetaEnvio.setIdEtiquetaEnvio(idEtiquetaEnvio);

		boolean etiquetaEnvioBorrada = gestorEtiquetasEnvio.borrarEtiquetaEnvio(etiquetaEnvio);
		if (etiquetaEnvioBorrada) {

			return new ResponseEntity<EtiquetasEnvio>(HttpStatus.OK);
		} else {
			return new ResponseEntity<EtiquetasEnvio>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping(path = "etiquetasEnvio/obtener/{idEtiquetaEnvio}", produces = MediaType.APPLICATION_JSON_VALUE)

	public ResponseEntity<EtiquetasEnvio> obtener(@PathVariable("idEtiquetaEnvio") Integer idEtiquetaEnvio) {

		EtiquetasEnvio etiquetaEnvioObtenida = gestorEtiquetasEnvio.obtenerEtiquetaEnvio(idEtiquetaEnvio);
		if (etiquetaEnvioObtenida != null) {

			return new ResponseEntity<EtiquetasEnvio>(HttpStatus.OK);
		} else {
			return new ResponseEntity<EtiquetasEnvio>(HttpStatus.NOT_FOUND);
		}

	}

	@GetMapping(path = "etiquetasEnvio", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EtiquetasEnvio> listar() {

		List<EtiquetasEnvio> listaEtiquetasEnvio = gestorEtiquetasEnvio.listarEtiquetasEnvio();

		return new ResponseEntity<EtiquetasEnvio>(HttpStatus.OK);
	}

}
