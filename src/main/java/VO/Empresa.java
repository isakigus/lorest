package VO;

public class Empresa {
	private int idEmpresa;
	private String nombreEmpresa;
	private int idDireccion;

	public int getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(int idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public String getNombreEmpresa() {
		return nombreEmpresa;
	}

	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}

	public int getIdDireccion() {
		return idDireccion;
	}

	public void setIdDireccion(int idDireccion) {
		this.idDireccion = idDireccion;
	}

	@Override
	public String toString() {
		return "empresa [idEmpresa=" + idEmpresa + ", nombreEmpresa=" + nombreEmpresa + ", idDireccion=" + idDireccion
				+ "]";
	}

}
