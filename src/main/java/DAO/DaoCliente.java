package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

import org.springframework.stereotype.Repository;

import VO.Cliente;

@Repository
public class DaoCliente {

	public DaoCliente() {
		super();
	}

	private Connection conexion;



	public boolean abrirConexion() {
		String url = "jdbc:mysql://localhost:3306/muela?serverTimezone=" + TimeZone.getDefault().getID();
		String usuario = "muela";
		String password = "Muela2000";
		try {
			conexion = DriverManager.getConnection(url, usuario, password);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public boolean cerrarConexion() {
		try {
			conexion.close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public boolean crearCliente(Cliente cliente) {
		if (!abrirConexion()) {
			return false;
		}
		String query = "insert into clientes (eanColumn1, codigoCliente, codigoBarras, idEmpresa) values(?,?,?,?)";

		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setString(1, cliente.getEanColumn1());
			ps.setString(2, cliente.getCodigoCliente());
			ps.setBlob(3, cliente.getCodigoBarras());
			ps.setInt(4, cliente.getIdEmpresa());
			int numeroFilas = ps.executeUpdate();
			if (numeroFilas == 0) {
				return false;
			} else {
				return true;
			}
		} catch (SQLException e) {
			System.out.println("Error al crear cliente");
			e.printStackTrace();
			return false;
		} finally {
			cerrarConexion();
		}
	}

	public boolean modificarCliente(Cliente cliente) {
		if (!abrirConexion()) {
			return false;
		}
		String query = "update clientes set eanColumn1=?, codigoCliente=?, codigoBarras=?, idEmpresa=?  where idCliente=?";

		try {
			PreparedStatement ps = conexion.prepareStatement(query);

			ps.setString(1, cliente.getEanColumn1());
			ps.setString(2, cliente.getCodigoCliente());
			ps.setBlob(3, cliente.getCodigoBarras());
			ps.setInt(4, cliente.getIdEmpresa());
			ps.setInt(5, cliente.getIdCliente());

			int numeroFilas = ps.executeUpdate();
			if (numeroFilas == 0) {
				return false;
			} else {
				return true;
			}
		} catch (SQLException e) {
			System.out.println("Error al modificar cliente");
			e.printStackTrace();
			return false;
		} finally {
			cerrarConexion();
		}
	}

	public boolean borrarCliente(Cliente cliente) {
		if (!abrirConexion()) {
			return false;
		}

		String query = "delete from clientes where idCliente=?";

		try {

			PreparedStatement ps = conexion.prepareStatement(query);

			ps.setInt(1, cliente.getIdCliente());

			int numeroFilas = ps.executeUpdate();
			if (numeroFilas == 0) {
				return false;
			} else {
				return true;
			}
		} catch (SQLException e) {
			System.out.println("Error al borrar cliente");
			e.printStackTrace();
			return false;
		} finally {
			cerrarConexion();
		}
	}

	public Cliente obtenerCliente(int idCliente) {
		if (!abrirConexion()) {
			return null;
		}

		String query = "select idCliente,eanColumn1,codigoCliente,codigoBarras,idEmpresa from clientes where idCliente=?";

		try {

			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setInt(1, idCliente);

			ResultSet rs = ps.executeQuery();
			Cliente cliente = null;

			while (rs.next()) {
				cliente = new Cliente();
				cliente.setIdCliente(rs.getInt(1));
				cliente.setEanColumn1(rs.getString(2));
				cliente.setCodigoCliente(rs.getString(3));
				cliente.setCodigoBarras(rs.getBlob(4));
				cliente.setIdEmpresa(rs.getInt(5));

			}
			return cliente;
		} catch (SQLException e) {
			System.out.println("Error al obtener cliente");
			e.printStackTrace();
			return null;
		} finally {
			cerrarConexion();
		}

	}

	public List<Cliente> listarTodosClientes() {
		if (!abrirConexion()) {
			return null;
		}

		String query = "select idCliente,eanColumn1,codigoCliente,codigoBarras,idEmpresa from clientes";

		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			Cliente cliente = null;
			List<Cliente> listadoClientes = new ArrayList<Cliente>();
			while (rs.next()) {

				cliente = new Cliente();
				cliente.setIdCliente(rs.getInt(1));
				cliente.setEanColumn1(rs.getString(2));
				cliente.setCodigoCliente(rs.getString(3));
				cliente.setCodigoBarras(rs.getBlob(4));
				cliente.setIdEmpresa(rs.getInt(5));

				listadoClientes.add(cliente);
			}
			return listadoClientes;
		} catch (SQLException e) {
			System.out.println("Error al listar los clientes");
			e.printStackTrace();
			return null;
		} finally {
			cerrarConexion();
		}

	}

	public Connection getConexion() {
		return conexion;
	}

	public void setConexion(Connection conexion) {
		this.conexion = conexion;
	}

}
