package VO;

public class Etiquetas {
	private int idEtiqueta;
	private int filas;
	private int columnas;
	private int idFormato;

	public int getIdEtiqueta() {
		return idEtiqueta;
	}

	public void setIdEtiqueta(int idEtiqueta) {
		this.idEtiqueta = idEtiqueta;
	}

	public int getFilas() {
		return filas;
	}

	public void setFilas(int filas) {
		this.filas = filas;
	}

	public int getColumnas() {
		return columnas;
	}

	public void setColumnas(int columnas) {
		this.columnas = columnas;
	}

	public int getIdFormato() {
		return idFormato;
	}

	public void setIdFormato(int idFormato) {
		this.idFormato = idFormato;
	}

	@Override
	public String toString() {
		return "etiquetas [idEtiqueta=" + idEtiqueta + ", filas=" + filas + ", columnas=" + columnas + ", idFormato="
				+ idFormato + "]";
	}

}
