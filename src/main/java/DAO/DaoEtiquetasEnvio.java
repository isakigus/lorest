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

import VO.EtiquetasEnvio;

@Repository
public class DaoEtiquetasEnvio {

	public DaoEtiquetasEnvio() {
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

	public boolean crearEtiquetaEnvio(EtiquetasEnvio etiquetaEnvio) {
		if (!abrirConexion()) {
			return false;
		}
		String query = "insert into etiquetasEnvio (idEmpresaMensajes, idEmpresaEmisora,idEmpresaReceptora,expedicion,referencia,kilos,bultos,reembolso) values(?,?,?,?,?,?,?,?)";

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

	public boolean modificarEtiquetaEnvio(EtiquetasEnvio etiquetaEnvio) {
		if (!abrirConexion()) {
			return false;
		}
		String query = "update etiquetasEnvio set idEmpresaMensajes=?, idEmpresaEmisora=?, idEmpresaReceptora=?, expedicion=?, referencia=?, kilos=?, bultos=?, reembolso=? where idEtiquetaEnvio=?";

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

	public boolean borrarEtiquetaEnvio(EtiquetasEnvio etiquetaEnvio) {
		if (!abrirConexion()) {
			return false;
		}

		String query = "delete from etiquetasEnvio where idEtiquetaEnvio=?";

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

	public EtiquetasEnvio obtenerEtiquetaEnvio(int idEtiquetaEnvio) {
		if (!abrirConexion()) {
			return null;
		}

		String query = "select idEtiquetaEnvio,idEmpresaMensajes,idEmpresaEmisora,idEmpresaReceptora,expedicion,referencia,kilos,bultos,reembolso from etiquetasEnvio where idEtiquetaEnvio=?";

		try {

			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setInt(1, idEtiquetaEnvio);

			ResultSet rs = ps.executeQuery();
			EtiquetasEnvio etiquetaEnvio = null;

			while (rs.next()) {

				etiquetaEnvio = new EtiquetasEnvio();

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

	public List<EtiquetasEnvio> listarTodasEtiquetasEnvio() {
		if (!abrirConexion()) {
			return null;
		}

		String query = "select idEtiquetaEnvio,idEmpresaMensajes,idEmpresaEmisora,idEmpresaReceptora,expedicion,referencia,kilos,bultos,reembolso from etiquetasEnvio";

		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			EtiquetasEnvio etiquetaEnvio = null;

			List<EtiquetasEnvio> listadoEtiquetasEnvio = new ArrayList<EtiquetasEnvio>();

			while (rs.next()) {

				etiquetaEnvio = new EtiquetasEnvio();

				etiquetaEnvio.setIdEtiquetaEnvio(rs.getInt(1));
				etiquetaEnvio.setIdEmpresaMensajes(rs.getInt(2));
				etiquetaEnvio.setIdEmpresaEmisora(rs.getInt(3));
				etiquetaEnvio.setIdEmpresaReceptora(rs.getInt(4));
				etiquetaEnvio.setExpedicion(rs.getString(5));
				etiquetaEnvio.setReferencia(rs.getString(6));
				etiquetaEnvio.setKilos(rs.getString(7));
				etiquetaEnvio.setBultos(rs.getString(8));
				etiquetaEnvio.setReembolso(rs.getInt(9));

				listadoEtiquetasEnvio.add(etiquetaEnvio);
			}
			return listadoEtiquetasEnvio;

		} catch (SQLException e) {
			System.out.println("Error al mostrar listado de etiquetas de envio");
			e.printStackTrace();
			return null;
		} finally {
			cerrarConexion();
		}

	}

}
