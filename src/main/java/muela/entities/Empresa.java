package muela.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "empresa")
@Component
@Scope("prototype")
public class Empresa {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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
