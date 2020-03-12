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

import VO.Etiquetas;

@Repository
public class DaoEtiquetas {



	public DaoEtiquetas() {
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

	public boolean crearEtiqueta(Etiquetas etiqueta) {
		if (!abrirConexion()) {
			return false;
		}
		String query = "insert into etiquetas (filas, columnas, idFormato) values(?,?,?)";

		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setInt(1, etiqueta.getFilas());
			ps.setInt(2, etiqueta.getColumnas());
			ps.setInt(3, etiqueta.getIdFormato());

			int numeroFilas = ps.executeUpdate();
			if (numeroFilas == 0) {
				return false;
			} else {
				return true;
			}
		} catch (SQLException e) {
			System.out.println("Error al crear la etiqueta");
			e.printStackTrace();
			return false;
		} finally {
			cerrarConexion();
		}
	}

	public boolean modificarEtiqueta(Etiquetas etiqueta) {
		if (!abrirConexion()) {
			return false;
		}
		String query = "update etiquetas set filas=?, columnas=?, idFormato=? where idEtiqueta=?";

		try {
			PreparedStatement ps = conexion.prepareStatement(query);

			ps.setInt(1, etiqueta.getFilas());
			ps.setInt(2, etiqueta.getColumnas());
			ps.setInt(3, etiqueta.getIdFormato());
			ps.setInt(4, etiqueta.getIdEtiqueta());

			int numeroFilas = ps.executeUpdate();
			if (numeroFilas == 0) {
				return false;
			} else {
				return true;
			}
		} catch (SQLException e) {
			System.out.println("Error al modificar la etiqueta");
			e.printStackTrace();
			return false;
		} finally {
			cerrarConexion();
		}
	}

	public boolean borrarEtiqueta(Etiquetas etiqueta) {
		if (!abrirConexion()) {
			return false;
		}

		String query = "delete from clientes where idCliente=?";

		try {

			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setInt(1, etiqueta.getIdEtiqueta());
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

	public Etiquetas obtenerEtiqueta(int idEtiqueta) {
		if (!abrirConexion()) {
			return null;
		}

		String query = "select idEtiqueta,filas,columnas,idFormato from etiquetas where idEtiqueta=?";

		try {

			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setInt(1, idEtiqueta);

			ResultSet rs = ps.executeQuery();
			Etiquetas etiqueta = null;

			while (rs.next()) {
				etiqueta = new Etiquetas();
				etiqueta.setIdEtiqueta(rs.getInt(1));
				etiqueta.setFilas(rs.getInt(2));
				etiqueta.setColumnas(rs.getInt(3));
				etiqueta.setIdFormato(rs.getInt(4));
			}
			return etiqueta;
		} catch (SQLException e) {
			System.out.println("Error al obtener la etiqueta");
			e.printStackTrace();
			return null;
		} finally {
			cerrarConexion();
		}

	}

	public List<Etiquetas> listarTodasEtiquetas() {
		if (!abrirConexion()) {
			return null;
		}

		String query = "select idEtiqueta,filas,columnas,idFormato from etiquetas";

		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			Etiquetas etiqueta = null;
			List<Etiquetas> listadoEtiquetas = new ArrayList<Etiquetas>();
			while (rs.next()) {

				etiqueta = new Etiquetas();
				etiqueta.setIdEtiqueta(rs.getInt(1));
				etiqueta.setFilas(rs.getInt(2));
				etiqueta.setColumnas(rs.getInt(3));
				etiqueta.setIdFormato(rs.getInt(4));

				listadoEtiquetas.add(etiqueta);
			}
			return listadoEtiquetas;
		} catch (SQLException e) {
			System.out.println("Error al mostrar listado de etiquetas");
			e.printStackTrace();
			return null;
		} finally {
			cerrarConexion();
		}

	}

}
