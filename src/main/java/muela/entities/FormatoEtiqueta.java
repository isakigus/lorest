package muela.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "formatoetiqueta")
@Component
@Scope("prototype")
public class FormatoEtiqueta {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idFormato;
	private int codCliente;
	private String codClienteExtendido;
	private int codBarras;
	private int ean;
	private int direccion1;
	private int direccion2;

	public int getIdFormato() {
		return idFormato;
	}

	public void setIdFormato(int idFormato) {
		this.idFormato = idFormato;
	}

	public int getCodCliente() {
		return codCliente;
	}

	public void setCodCliente(int codCliente) {
		this.codCliente = codCliente;
	}

	public String getCodClienteExtendido() {
		return codClienteExtendido;
	}

	public void setCodClienteExtendido(String codClienteExtendido) {
		this.codClienteExtendido = codClienteExtendido;
	}

	public int getCodBarras() {
		return codBarras;
	}

	public void setCodBarras(int codBarras) {
		this.codBarras = codBarras;
	}

	public int getEan() {
		return ean;
	}

	public void setEan(int ean) {
		this.ean = ean;
	}

	public int getDireccion1() {
		return direccion1;
	}

	public void setDireccion1(int direccion1) {
		this.direccion1 = direccion1;
	}

	public int getDireccion2() {
		return direccion2;
	}

	public void setDireccion2(int direccion2) {
		this.direccion2 = direccion2;
	}

	@Override
	public String toString() {
		return "formatoEtiqueta [idFormato=" + idFormato + ", codCliente=" + codCliente + ", codClienteExtendido="
				+ codClienteExtendido + ", codBarras=" + codBarras + ", ean=" + ean + ", direccion1=" + direccion1
				+ ", direccion2=" + direccion2 + "]";
	}

}
