package muela.entities;

import java.sql.Blob;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "cliente")
@Component
@Scope("prototype")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idCliente;
	private String eanColumn1;
	private String codigoCliente;
	private Blob codigoBarras;
	private int idEmpresa;

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getEanColumn1() {
		return eanColumn1;
	}

	public void setEanColumn1(String eanColumn1) {
		this.eanColumn1 = eanColumn1;
	}

	public String getCodigoCliente() {
		return codigoCliente;
	}

	public void setCodigoCliente(String codigoCliente) {
		this.codigoCliente = codigoCliente;
	}

	public Blob getCodigoBarras() {
		return codigoBarras;
	}

	public void setCodigoBarras(Blob codigoBarras) {
		this.codigoBarras = codigoBarras;
	}

	public int getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(int idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", eanColumn1=" + eanColumn1 + ", codigoCliente=" + codigoCliente
				+ ", codigoBarras=" + codigoBarras + ", idEmpresa=" + idEmpresa + "]";
	}

}
