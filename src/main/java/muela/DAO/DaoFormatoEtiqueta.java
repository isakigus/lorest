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

import muela.VO.FormatoEtiqueta;

@Repository
public class DaoFormatoEtiqueta {

	public DaoFormatoEtiqueta() {
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

	public boolean crearFormatoEtiqueta(FormatoEtiqueta formatoEtiqueta) {
		if (!abrirConexion()) {
			return false;
		}
		String query = "insert into formatoEtiqueta (codCliente,codClienteExtendido,codBarras,ean,direccion1,direccion2) values(?,?,?,?,?,?)";

		try {
			PreparedStatement ps = conexion.prepareStatement(query);

			ps.setInt(1, formatoEtiqueta.getCodCliente());
			ps.setString(2, formatoEtiqueta.getCodClienteExtendido());
			ps.setInt(3, formatoEtiqueta.getCodBarras());
			ps.setInt(4, formatoEtiqueta.getEan());
			ps.setInt(5, formatoEtiqueta.getDireccion1());
			ps.setInt(6, formatoEtiqueta.getDireccion2());

			int numeroFilas = ps.executeUpdate();
			if (numeroFilas == 0) {
				return false;
			} else {
				return true;
			}
		} catch (SQLException e) {
			System.out.println("Error al crear el formato de etiqueta");
			e.printStackTrace();
			return false;
		} finally {
			cerrarConexion();
		}
	}

	public boolean modificarFormatoEtiqueta(FormatoEtiqueta formatoEtiqueta) {
		if (!abrirConexion()) {
			return false;
		}
		String query = "update formatoEtiqueta set codCliente=?, codClienteExtendido=?, codBarras=?, ean=?, direccion1=?, direccion2=? where idFormato=?";

		try {
			PreparedStatement ps = conexion.prepareStatement(query);

			ps.setInt(1, formatoEtiqueta.getCodCliente());
			ps.setString(2, formatoEtiqueta.getCodClienteExtendido());
			ps.setInt(3, formatoEtiqueta.getCodBarras());
			ps.setInt(4, formatoEtiqueta.getEan());
			ps.setInt(5, formatoEtiqueta.getDireccion1());
			ps.setInt(6, formatoEtiqueta.getDireccion2());
			ps.setInt(7, formatoEtiqueta.getIdFormato());

			int numeroFilas = ps.executeUpdate();
			if (numeroFilas == 0) {
				return false;
			} else {
				return true;
			}
		} catch (SQLException e) {
			System.out.println("Error al modificar el formato de etiqueta");
			e.printStackTrace();
			return false;
		} finally {
			cerrarConexion();
		}
	}

	public boolean borrarFormatoEtiqueta(FormatoEtiqueta formatoEtiqueta) {
		if (!abrirConexion()) {
			return false;
		}

		String query = "delete from formatoEtiqueta where idFormato=?";

		try {

			PreparedStatement ps = conexion.prepareStatement(query);

			ps.setInt(1, formatoEtiqueta.getIdFormato());

			int numeroFilas = ps.executeUpdate();
			if (numeroFilas == 0) {
				return false;
			} else {
				return true;
			}
		} catch (SQLException e) {
			System.out.println("Error al borrar el formato de etiqueta");
			e.printStackTrace();
			return false;
		} finally {
			cerrarConexion();
		}
	}

	public FormatoEtiqueta obtenerEtiquetaEnvio(int idFormato) {
		if (!abrirConexion()) {
			return null;
		}

		String query = "select idFormato,codCliente,codClienteExtendido,codBarras,ean,direccion1,direccion2 from formatoEtiqueta where idFormato=?";

		try {

			PreparedStatement ps = conexion.prepareStatement(query);

			ps.setInt(1, idFormato);

			ResultSet rs = ps.executeQuery();

			FormatoEtiqueta formatoEtiqueta = null;

			while (rs.next()) {

				formatoEtiqueta = new FormatoEtiqueta();

				formatoEtiqueta.setIdFormato(rs.getInt(1));
				formatoEtiqueta.setCodCliente(rs.getInt(2));
				formatoEtiqueta.setCodClienteExtendido(rs.getString(3));
				formatoEtiqueta.setCodBarras(rs.getInt(4));
				formatoEtiqueta.setEan(rs.getInt(5));
				formatoEtiqueta.setDireccion1(rs.getInt(6));
				formatoEtiqueta.setDireccion2(rs.getInt(7));

			}
			return formatoEtiqueta;
		} catch (SQLException e) {
			System.out.println("Error al obtener el formato de etiqueta");
			e.printStackTrace();
			return null;
		} finally {
			cerrarConexion();
		}

	}

	public List<FormatoEtiqueta> listarFormatosEtiqueta() {
		if (!abrirConexion()) {
			return null;
		}

		String query = "select idFormato,codCliente,codClienteExtendido,codBarras,ean,direccion1,direccion2 from formatoEtiqueta";

		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			ResultSet rs = ps.executeQuery();

			FormatoEtiqueta formatoEtiqueta = null;

			List<FormatoEtiqueta> listadoFormatoEtiqueta = new ArrayList<FormatoEtiqueta>();

			while (rs.next()) {

				formatoEtiqueta = new FormatoEtiqueta();

				formatoEtiqueta.setIdFormato(rs.getInt(1));
				formatoEtiqueta.setCodCliente(rs.getInt(2));
				formatoEtiqueta.setCodClienteExtendido(rs.getString(3));
				formatoEtiqueta.setCodBarras(rs.getInt(4));
				formatoEtiqueta.setEan(rs.getInt(5));
				formatoEtiqueta.setDireccion1(rs.getInt(6));
				formatoEtiqueta.setDireccion2(rs.getInt(7));

				listadoFormatoEtiqueta.add(formatoEtiqueta);
			}
			return listadoFormatoEtiqueta;

		} catch (SQLException e) {
			System.out.println("Error al mostrar listado de formatos de etiqueta");
			e.printStackTrace();
			return null;
		} finally {
			cerrarConexion();
		}

	}

}
