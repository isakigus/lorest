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

import muela.BO.GestorCliente;
import muela.VO.Cliente;

@RestController
public class ControladorCliente {

	GestorCliente gestorCliente = new GestorCliente();

	@PostMapping(path = "clientes", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cliente> crear(@RequestBody Cliente cliente) {

		boolean clienteCreado = gestorCliente.crearCliente(cliente);

		HttpStatus httpStatus = (clienteCreado)? HttpStatus.OK: HttpStatus.NOT_FOUND;

		return new ResponseEntity<Cliente>(cliente, httpStatus);

	}

	@PutMapping(path = "clientes/{idCliente}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cliente> modificar(@RequestBody Cliente cliente, @PathVariable Integer idCliente) {

		boolean clienteModificado = gestorCliente.modificarCliente(cliente);

		HttpStatus httpStatus = (clienteModificado)? HttpStatus.OK: HttpStatus.NOT_FOUND;

		return new ResponseEntity<Cliente>(cliente, httpStatus);
	}

	@DeleteMapping(path = "clientes/{idCliente}")
	public ResponseEntity<Cliente> borrar(@PathVariable Integer idCliente) {

		Cliente cliente = new Cliente();
		cliente.setIdCliente(idCliente);

		boolean clienteBorrado = gestorCliente.borrarCliente(cliente);

		HttpStatus httpStatus = (clienteBorrado)? HttpStatus.OK: HttpStatus.NOT_FOUND;

		return new ResponseEntity<Cliente>(cliente, httpStatus);
	}

	@GetMapping(path = "clientes/{idCliente}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cliente> obtener(@PathVariable("idCliente") Integer idCliente) {

		Cliente clienteObtenido = gestorCliente.obtenerCliente(idCliente);

		HttpStatus httpStatus = (clienteObtenido != null)? HttpStatus.OK: HttpStatus.NOT_FOUND;

		return new ResponseEntity<Cliente>(clienteObtenido, httpStatus);

	}

	@GetMapping(path = "clientes", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Cliente>> listar() {

		List<Cliente> listaClientes = gestorCliente.listarClientes();

		return new ResponseEntity<List<Cliente>>(listaClientes, HttpStatus.OK);
	}
}
