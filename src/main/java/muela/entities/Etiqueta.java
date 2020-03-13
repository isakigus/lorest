package muela.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "etiqueta")
@Component
@Scope("prototype")
public class Etiqueta {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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
		return "etiqueta [idEtiqueta=" + idEtiqueta + ", filas=" + filas + ", columnas=" + columnas + ", idFormato="
				+ idFormato + "]";
	}

}
