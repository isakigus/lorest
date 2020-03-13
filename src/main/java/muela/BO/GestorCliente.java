package muela.BO;

import java.util.List;

import javax.transaction.Transactional;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import muela.DAO.DaoCliente;
import muela.VO.Cliente;

@Service
public class GestorCliente {

	DaoCliente daoCliente = new DaoCliente();

	// @Autowired
	public GestorCliente() {
		super();

	}

	@Transactional
	public boolean crearCliente(Cliente cliente) {

		return daoCliente.crearCliente(cliente);
	}

	@Transactional
	public boolean modificarCliente(Cliente cliente) {

		return daoCliente.modificarCliente(cliente);
	}

	@Transactional
	public boolean borrarCliente(Cliente cliente) {

		return daoCliente.borrarCliente(cliente);
	}

	public Cliente obtenerCliente(int idCliente) {

		return daoCliente.obtenerCliente(idCliente);
	}

	public List<Cliente> listarClientes() {

		return daoCliente.listarTodosClientes();
	}

}
