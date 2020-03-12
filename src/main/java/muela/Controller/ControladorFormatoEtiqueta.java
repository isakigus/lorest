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

import BO.GestorFormatoEtiquetas;
import VO.EtiquetasEnvio;
import VO.FormatoEtiqueta;

@RestController
public class ControladorFormatoEtiqueta {

	GestorFormatoEtiquetas gestorFormatoEtiquetas = new GestorFormatoEtiquetas();

	@PostMapping(path = "formatoEtiqueta/crear", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<FormatoEtiqueta> crear(@RequestBody FormatoEtiqueta formatoEtiqueta) {

		boolean formatoEtiquetacreado = gestorFormatoEtiquetas.crearFormatoEtiqueta(formatoEtiqueta);
		if (formatoEtiquetacreado) {

			return new ResponseEntity<FormatoEtiqueta>(formatoEtiqueta, HttpStatus.CREATED);
		} else {

			return new ResponseEntity<FormatoEtiqueta>(formatoEtiqueta, HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping(path = "formatoEtiqueta/modificar/{idFormatoEtiqueta}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)

	public ResponseEntity<FormatoEtiqueta> modificar(@RequestBody FormatoEtiqueta formatoEtiqueta,
			@PathVariable Integer idFormatoEtiqueta) {

		boolean formatoEtiquetaModificado = gestorFormatoEtiquetas.modificarFormatoEtiqueta(formatoEtiqueta);
		if (formatoEtiquetaModificado) {

			return new ResponseEntity<FormatoEtiqueta>(formatoEtiqueta, HttpStatus.OK);
		} else {

			return new ResponseEntity<FormatoEtiqueta>(formatoEtiqueta, HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping(path = "formatoEtiqueta/borrar/{idFormatoEtiqueta}")
	public ResponseEntity<FormatoEtiqueta> borrar(@PathVariable Integer idFormatoEtiqueta) {

		FormatoEtiqueta formatoEtiqueta = new FormatoEtiqueta();
		formatoEtiqueta.setIdFormato(idFormatoEtiqueta);

		boolean formatoEtiquetaEnvioBorrada = gestorFormatoEtiquetas.borrarFormatoEtiqueta(formatoEtiqueta);
		if (formatoEtiquetaEnvioBorrada) {

			return new ResponseEntity<FormatoEtiqueta>(HttpStatus.OK);
		} else {
			return new ResponseEntity<FormatoEtiqueta>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping(path = "formatoEtiqueta/obtener/{idFormatoEtiqueta}", produces = MediaType.APPLICATION_JSON_VALUE)

	public ResponseEntity<FormatoEtiqueta> obtener(@PathVariable("idFormatoEtiqueta") Integer idFormatoEtiqueta) {

		FormatoEtiqueta formatoEtiquetaObtenida = gestorFormatoEtiquetas.obtenerFormatoEtiqueta(idFormatoEtiqueta);
		if (formatoEtiquetaObtenida != null) {

			return new ResponseEntity<FormatoEtiqueta>(HttpStatus.OK);
		} else {
			return new ResponseEntity<FormatoEtiqueta>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping(path = "formatosEtiqueta", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<FormatoEtiqueta> listar() {

		List<FormatoEtiqueta> listaFormatoEtiquetas = gestorFormatoEtiquetas.listarFormatoEtiquetas();
		return new ResponseEntity<FormatoEtiqueta>(HttpStatus.OK);
	}

}
