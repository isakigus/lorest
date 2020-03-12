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

import BO.GestorCliente;
import VO.Cliente;

@RestController
public class ControladorCliente {

	GestorCliente gestorCliente = new GestorCliente();

	@PostMapping(path = "cliente/crear", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cliente> crear(@RequestBody Cliente cliente) {

		boolean ClienteCreado = gestorCliente.crearCliente(cliente);

		if (ClienteCreado) {

			return new ResponseEntity<Cliente>(cliente, HttpStatus.CREATED);
		} else {

			return new ResponseEntity<Cliente>(cliente, HttpStatus.NOT_FOUND);
		}

	}

	@PutMapping(path = "cliente/modificar/{idCliente}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)

	public ResponseEntity<Cliente> modificar(@RequestBody Cliente cliente, @PathVariable Integer idCliente) {

		boolean ClienteModificado = gestorCliente.modificarCliente(cliente);

		if (ClienteModificado) {

			return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
		} else {

			return new ResponseEntity<Cliente>(cliente, HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping(path = "Cliente/borrar/{idCliente}")
	public ResponseEntity<Cliente> borrar(@PathVariable Integer idCliente) {

		Cliente cliente = new Cliente();
		cliente.setIdCliente(idCliente);

		boolean ClienteBorrado = gestorCliente.borrarCliente(cliente);

		if (ClienteBorrado) {

			return new ResponseEntity<Cliente>(HttpStatus.OK);
		} else {
			return new ResponseEntity<Cliente>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping(path = "cliente/obtener/{idCliente}", produces = MediaType.APPLICATION_JSON_VALUE)

	public ResponseEntity<Cliente> obtener(@PathVariable("idCliente") Integer idCliente) {

		Cliente clienteObtenido = gestorCliente.obtenerCliente(idCliente);

		if (clienteObtenido != null) {

			return new ResponseEntity<Cliente>(HttpStatus.OK);
		} else {
			return new ResponseEntity<Cliente>(HttpStatus.NOT_FOUND);
		}

	}

	@GetMapping(path = "clientes", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cliente> listar() {

		List<Cliente> listaClientes = gestorCliente.listarClientes();

		return new ResponseEntity<Cliente>(HttpStatus.OK);
	}
}
