package VO;

public class Direcciones {
	private int idDireccion;
	private String direccion;
	private String codigoPostal;
	private String destino;

	public int getIdDireccion() {
		return idDireccion;
	}

	public void setIdDireccion(int idDireccion) {
		this.idDireccion = idDireccion;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	@Override
	public String toString() {
		return "Direcciones [idDireccion=" + idDireccion + ", direccion=" + direccion + ", codigoPostal=" + codigoPostal
				+ ", destino=" + destino + "]";
	}

}
