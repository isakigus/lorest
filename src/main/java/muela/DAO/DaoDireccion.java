package muela.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

import org.springframework.stereotype.Repository;

import muela.VO.Direccion;;

@Repository
public class DaoDireccion {

	public DaoDireccion() {
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

	public boolean crearDireccion(Direccion direccion) {
		if (!abrirConexion()) {
			return false;
		}
		String query = "insert into direccion (direccion, codigoPostal, destino) values(?,?,?)";

		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setString(1, direccion.getDireccion());
			ps.setString(2, direccion.getCodigoPostal());
			ps.setString(3, direccion.getDestino());
			int numeroFilas = ps.executeUpdate();
			if (numeroFilas == 0) {
				return false;
			} else {
				return true;
			}
		} catch (SQLException e) {
			System.out.println("Error al crear la direccion");
			e.printStackTrace();
			return false;
		} finally {
			cerrarConexion();
		}
	}

	public boolean modificarDireccion(Direccion direccion) {
		if (!abrirConexion()) {
			return false;
		}
		String query = "update direccion set direccion=?, codigoPostal=?, destino=?  where idDireccion=?";

		try {
			PreparedStatement ps = conexion.prepareStatement(query);

			ps.setString(1, direccion.getDireccion());
			ps.setString(2, direccion.getCodigoPostal());
			ps.setString(3, direccion.getDestino());
			ps.setInt(4, direccion.getIdDireccion());

			int numeroFilas = ps.executeUpdate();
			if (numeroFilas == 0) {
				return false;
			} else {
				return true;
			}
		} catch (SQLException e) {
			System.out.println("Error al modificar la direccion");
			e.printStackTrace();
			return false;
		} finally {
			cerrarConexion();
		}
	}

	public boolean borrarDireccion(Direccion direccion) {
		if (!abrirConexion()) {
			return false;
		}

		String query = "delete from direccion where idDireccion=?";

		try {

			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setInt(1, direccion.getIdDireccion());
			int numeroFilas = ps.executeUpdate();
			if (numeroFilas == 0) {
				return false;
			} else {
				return true;
			}
		} catch (SQLException e) {
			System.out.println("Error al borrar la direccion");
			e.printStackTrace();
			return false;
		} finally {
			cerrarConexion();
		}
	}

	public Direccion obtenerDireccion(int idDireccion) {
		if (!abrirConexion()) {
			return null;
		}

		String query = "select idDireccion, direccion, codigoPostal, destino from direccion where idDireccion=?";

		try {

			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setInt(1, idDireccion);

			ResultSet rs = ps.executeQuery();
			Direccion direccion = null;

			while (rs.next()) {

				direccion = new Direccion();
				direccion.setIdDireccion(rs.getInt(1));
				direccion.setDireccion(rs.getString(2));
				direccion.setCodigoPostal(rs.getString(3));
				direccion.setDestino(rs.getString(4));

			}
			return direccion;
		} catch (SQLException e) {
			System.out.println("Error al obtener cliente");
			e.printStackTrace();
			return null;
		} finally {
			cerrarConexion();
		}

	}

	public List<Direccion> listarTodasDireccion() {
		if (!abrirConexion()) {
			return null;
		}

		String query = "select idDireccion,direccion,codigoPostal,destino from direccion";

		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			Direccion direccion = null;
			List<Direccion> listadoDireccion = new ArrayList<Direccion>();
			while (rs.next()) {
				direccion = new Direccion();
				direccion.setIdDireccion(rs.getInt(1));
				direccion.setDireccion(rs.getString(2));
				direccion.setCodigoPostal(rs.getString(3));
				direccion.setDestino(rs.getString(4));
				listadoDireccion.add(direccion);
			}
			return listadoDireccion;
		} catch (SQLException e) {
			System.out.println("Error al listar las direccion");
			e.printStackTrace();
			return null;
		} finally {
			cerrarConexion();
		}

	}

}
