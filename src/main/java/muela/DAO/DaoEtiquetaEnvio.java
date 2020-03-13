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

import muela.VO.EtiquetaEnvio;

@Repository
public class DaoEtiquetaEnvio {

	public DaoEtiquetaEnvio() {
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

	public boolean crearEtiquetaEnvio(EtiquetaEnvio etiquetaEnvio) {
		if (!abrirConexion()) {
			return false;
		}
		String query = "insert into etiquetaEnvio (idEmpresaMensajes, idEmpresaEmisora,idEmpresaReceptora,expedicion,referencia,kilos,bultos,reembolso) values(?,?,?,?,?,?,?,?)";

		try {
			PreparedStatement ps = conexion.prepareStatement(query);

			ps.setInt(1, etiquetaEnvio.getIdEmpresaMensajes());
			ps.setInt(2, etiquetaEnvio.getIdEmpresaEmisora());
			ps.setInt(3, etiquetaEnvio.getIdEmpresaReceptora());
			ps.setString(4, etiquetaEnvio.getExpedicion());
			ps.setString(5, etiquetaEnvio.getReferencia());
			ps.setString(6, etiquetaEnvio.getKilos());
			ps.setString(7, etiquetaEnvio.getBultos());
			ps.setInt(8, etiquetaEnvio.getReembolso());

			int numeroFilas = ps.executeUpdate();
			if (numeroFilas == 0) {
				return false;
			} else {
				return true;
			}
		} catch (SQLException e) {
			System.out.println("Error al crear la etiquetaEnvio");
			e.printStackTrace();
			return false;
		} finally {
			cerrarConexion();
		}
	}

	public boolean modificarEtiquetaEnvio(EtiquetaEnvio etiquetaEnvio) {
		if (!abrirConexion()) {
			return false;
		}
		String query = "update etiquetaEnvio set idEmpresaMensajes=?, idEmpresaEmisora=?, idEmpresaReceptora=?, expedicion=?, referencia=?, kilos=?, bultos=?, reembolso=? where idEtiquetaEnvio=?";

		try {
			PreparedStatement ps = conexion.prepareStatement(query);

			ps.setInt(1, etiquetaEnvio.getIdEmpresaMensajes());
			ps.setInt(2, etiquetaEnvio.getIdEmpresaEmisora());
			ps.setInt(3, etiquetaEnvio.getIdEmpresaReceptora());
			ps.setString(4, etiquetaEnvio.getExpedicion());
			ps.setString(5, etiquetaEnvio.getReferencia());
			ps.setString(6, etiquetaEnvio.getKilos());
			ps.setString(7, etiquetaEnvio.getBultos());
			ps.setInt(8, etiquetaEnvio.getReembolso());
			ps.setInt(9, etiquetaEnvio.getIdEtiquetaEnvio());

			int numeroFilas = ps.executeUpdate();
			if (numeroFilas == 0) {
				return false;
			} else {
				return true;
			}
		} catch (SQLException e) {
			System.out.println("Error al modificar la etiqueta de Envio");
			e.printStackTrace();
			return false;
		} finally {
			cerrarConexion();
		}
	}

	public boolean borrarEtiquetaEnvio(EtiquetaEnvio etiquetaEnvio) {
		if (!abrirConexion()) {
			return false;
		}

		String query = "delete from etiquetaEnvio where idEtiquetaEnvio=?";

		try {

			PreparedStatement ps = conexion.prepareStatement(query);

			ps.setInt(1, etiquetaEnvio.getIdEtiquetaEnvio());

			int numeroFilas = ps.executeUpdate();
			if (numeroFilas == 0) {
				return false;
			} else {
				return true;
			}
		} catch (SQLException e) {
			System.out.println("Error al borrar etiqueta de envio");
			e.printStackTrace();
			return false;
		} finally {
			cerrarConexion();
		}
	}

	public EtiquetaEnvio obtenerEtiquetaEnvio(int idEtiquetaEnvio) {
		if (!abrirConexion()) {
			return null;
		}

		String query = "select idEtiquetaEnvio,idEmpresaMensajes,idEmpresaEmisora,idEmpresaReceptora,expedicion,referencia,kilos,bultos,reembolso from etiquetaEnvio where idEtiquetaEnvio=?";

		try {

			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setInt(1, idEtiquetaEnvio);

			ResultSet rs = ps.executeQuery();
			EtiquetaEnvio etiquetaEnvio = null;

			while (rs.next()) {

				etiquetaEnvio = new EtiquetaEnvio();

				etiquetaEnvio.setIdEtiquetaEnvio(rs.getInt(1));
				etiquetaEnvio.setIdEmpresaMensajes(rs.getInt(2));
				etiquetaEnvio.setIdEmpresaEmisora(rs.getInt(3));
				etiquetaEnvio.setIdEmpresaReceptora(rs.getInt(4));
				etiquetaEnvio.setExpedicion(rs.getString(5));
				etiquetaEnvio.setReferencia(rs.getString(6));
				etiquetaEnvio.setKilos(rs.getString(7));
				etiquetaEnvio.setBultos(rs.getString(8));
				etiquetaEnvio.setReembolso(rs.getInt(9));

			}
			return etiquetaEnvio;
		} catch (SQLException e) {
			System.out.println("Error al obtener la etiqueta de envio");
			e.printStackTrace();
			return null;
		} finally {
			cerrarConexion();
		}

	}

	public List<EtiquetaEnvio> listarTodasEtiquetaEnvio() {
		if (!abrirConexion()) {
			return null;
		}

		String query = "select idEtiquetaEnvio,idEmpresaMensajes,idEmpresaEmisora,idEmpresaReceptora,expedicion,referencia,kilos,bultos,reembolso from etiquetaEnvio";

		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			EtiquetaEnvio etiquetaEnvio = null;

			List<EtiquetaEnvio> listadoEtiquetaEnvio = new ArrayList<EtiquetaEnvio>();

			while (rs.next()) {

				etiquetaEnvio = new EtiquetaEnvio();

				etiquetaEnvio.setIdEtiquetaEnvio(rs.getInt(1));
				etiquetaEnvio.setIdEmpresaMensajes(rs.getInt(2));
				etiquetaEnvio.setIdEmpresaEmisora(rs.getInt(3));
				etiquetaEnvio.setIdEmpresaReceptora(rs.getInt(4));
				etiquetaEnvio.setExpedicion(rs.getString(5));
				etiquetaEnvio.setReferencia(rs.getString(6));
				etiquetaEnvio.setKilos(rs.getString(7));
				etiquetaEnvio.setBultos(rs.getString(8));
				etiquetaEnvio.setReembolso(rs.getInt(9));

				listadoEtiquetaEnvio.add(etiquetaEnvio);
			}
			return listadoEtiquetaEnvio;

		} catch (SQLException e) {
			System.out.println("Error al mostrar listado de etiqueta de envio");
			e.printStackTrace();
			return null;
		} finally {
			cerrarConexion();
		}

	}

}
