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

import BO.GestorEmpresa;
import VO.Empresa;

@RestController
public class ControladorEmpresa {

	GestorEmpresa gestorEmpresa = new GestorEmpresa();

	@PostMapping(path = "empresa/crear", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Empresa> crear(@RequestBody Empresa empresa) {

		boolean empresaCreada = gestorEmpresa.crearEmpresa(empresa);

		if (empresaCreada) {

			return new ResponseEntity<Empresa>(empresa, HttpStatus.CREATED);
		} else {

			return new ResponseEntity<Empresa>(empresa, HttpStatus.NOT_FOUND);
		}

	}

	@PutMapping(path = "empresa/modificar/{idEmpresa}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)

	public ResponseEntity<Empresa> modificar(@RequestBody Empresa empresa, @PathVariable Integer idEmpresa) {

		boolean empresaModificada = gestorEmpresa.modificarEmpresa(empresa);

		if (empresaModificada) {

			return new ResponseEntity<Empresa>(empresa, HttpStatus.OK);
		} else {

			return new ResponseEntity<Empresa>(empresa, HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping(path = "empresa/borrar/{idEmpresa}")
	public ResponseEntity<Empresa> borrar(@PathVariable Integer idEmpresa) {

		Empresa empresa = new Empresa();
		empresa.setIdEmpresa(idEmpresa);

		boolean empresaBorrada = gestorEmpresa.borrarEmpresa(empresa);

		if (empresaBorrada) {

			return new ResponseEntity<Empresa>(HttpStatus.OK);
		} else {
			return new ResponseEntity<Empresa>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping(path = "empresa/obtener/{idEmpresa}", produces = MediaType.APPLICATION_JSON_VALUE)

	public ResponseEntity<Empresa> obtener(@PathVariable("idEmpresa") Integer idEmpresa) {

		Empresa empresaObtenida = gestorEmpresa.obtenerEmpresa(idEmpresa);

		if (empresaObtenida != null) {

			return new ResponseEntity<Empresa>(HttpStatus.OK);
		} else {
			return new ResponseEntity<Empresa>(HttpStatus.NOT_FOUND);
		}

	}

	@GetMapping(path = "empresas", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Empresa> listar() {

		List<Empresa> listaEmpresas = gestorEmpresa.listarEmpresas();

		return new ResponseEntity<Empresa>(HttpStatus.OK);
	}

}
