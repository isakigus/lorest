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

import VO.Empresa;

@Repository
public class DaoEmpresa {


	public DaoEmpresa() {
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

	public boolean crearEmpresa(Empresa empresa) {
		if (!abrirConexion()) {
			return false;
		}
		String query = "insert into empresas (nombreEmpresa, idDireccion) values(?,?)";

		try {
			PreparedStatement ps = conexion.prepareStatement(query);

			ps.setString(1, empresa.getNombreEmpresa());
			ps.setInt(2, empresa.getIdDireccion());

			int numeroFilas = ps.executeUpdate();
			if (numeroFilas == 0) {
				return false;
			} else {
				return true;
			}
		} catch (SQLException e) {
			System.out.println("Error al crear empresa");
			e.printStackTrace();
			return false;
		} finally {
			cerrarConexion();
		}
	}

	public boolean modificarEmpresa(Empresa empresa) {
		if (!abrirConexion()) {
			return false;
		}
		String query = "update empresas set nombreEmpresa=?" + ", idDireccion=? where idEmpresa=?";

		try {
			PreparedStatement ps = conexion.prepareStatement(query);

			ps.setString(1, empresa.getNombreEmpresa());
			ps.setInt(2, empresa.getIdDireccion());
			ps.setInt(3, empresa.getIdEmpresa());

			int numeroFilas = ps.executeUpdate();
			if (numeroFilas == 0) {
				return false;
			} else {
				return true;
			}
		} catch (SQLException e) {
			System.out.println("Error al modificar empresa");
			e.printStackTrace();
			return false;
		} finally {
			cerrarConexion();
		}
	}

	public boolean borrarEmpresa(Empresa empresa) {
		if (!abrirConexion()) {
			return false;
		}

		String query = "delete from empresas where idEmpresa=?";

		try {

			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setInt(1, empresa.getIdEmpresa());
			int numeroFilas = ps.executeUpdate();
			if (numeroFilas == 0) {
				return false;
			} else {
				return true;
			}
		} catch (SQLException e) {
			System.out.println("Error al borrar empresa");
			e.printStackTrace();
			return false;
		} finally {
			cerrarConexion();
		}
	}

	public Empresa obtenerEmpresa(int idEmpresa) {
		if (!abrirConexion()) {
			return null;
		}

		String query = "select idEmpresa,nombreEmpresa,idDireccion from empresas where idEmpresa=?";

		try {

			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setInt(1, idEmpresa);

			ResultSet rs = ps.executeQuery();
			Empresa empresa = null;

			while (rs.next()) {
				empresa = new Empresa();

				empresa.setIdEmpresa(rs.getInt(1));
				empresa.setNombreEmpresa(rs.getString(2));
				empresa.setIdDireccion(rs.getInt(3));

			}
			return empresa;
		} catch (SQLException e) {
			System.out.println("Error al otener empresa");
			e.printStackTrace();
			return null;
		} finally {
			cerrarConexion();
		}

	}

	public List<Empresa> listarEmpresas() {
		if (!abrirConexion()) {
			return null;
		}

		String query = "select idEmpresa,nombreEmpresa,idDireccion from empresas";

		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			Empresa empresa = null;
			List<Empresa> listadoEmpresas = new ArrayList<Empresa>();
			while (rs.next()) {
				empresa = new Empresa();
				empresa.setIdEmpresa(rs.getInt(1));
				empresa.setNombreEmpresa(rs.getString(2));
				empresa.setIdDireccion(rs.getInt(3));

				listadoEmpresas.add(empresa);
			}
			return listadoEmpresas;
		} catch (SQLException e) {
			System.out.println("Error al listar las empresas");
			e.printStackTrace();
			return null;
		} finally {
			cerrarConexion();
		}

	}

}
