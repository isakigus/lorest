package muela.VO;

public class EtiquetaEnvio {

	private int idEtiquetaEnvio;
	private int idEmpresaMensajes;
	private int idEmpresaEmisora;
	private int idEmpresaReceptora;
	private String expedicion;
	private String referencia;
	private String kilos;
	private String bultos;
	private int reembolso;

	public int getIdEmpresaEmisora() {
		return idEmpresaEmisora;
	}

	public void setIdEmpresaEmisora(int idEmpresaEmisora) {
		this.idEmpresaEmisora = idEmpresaEmisora;
	}

	public int getIdEmpresaReceptora() {
		return idEmpresaReceptora;
	}

	public void setIdEmpresaReceptora(int idEmpresaReceptora) {
		this.idEmpresaReceptora = idEmpresaReceptora;
	}

	public String getExpedicion() {
		return expedicion;
	}

	public void setExpedicion(String expedicion) {
		this.expedicion = expedicion;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public String getKilos() {
		return kilos;
	}

	public void setKilos(String kilos) {
		this.kilos = kilos;
	}

	public String getBultos() {
		return bultos;
	}

	public void setBultos(String bultos) {
		this.bultos = bultos;
	}

	public int getReembolso() {
		return reembolso;
	}

	public void setReembolso(int reembolso) {
		this.reembolso = reembolso;
	}

	public int getIdEmpresaMensajes() {
		return idEmpresaMensajes;
	}

	public void setIdEmpresaMensajes(int idEmpresaMensajes) {
		this.idEmpresaMensajes = idEmpresaMensajes;
	}

	public int getIdEtiquetaEnvio() {
		return idEtiquetaEnvio;
	}

	public void setIdEtiquetaEnvio(int idEtiquetaEnvio) {
		this.idEtiquetaEnvio = idEtiquetaEnvio;
	}

	@Override
	public String toString() {
		return "EtiquetaEnvio [idEtiquetaEnvio=" + idEtiquetaEnvio + ", idEmpresaMensajes=" + idEmpresaMensajes
				+ ", idEmpresaEmisora=" + idEmpresaEmisora + ", idEmpresaReceptora=" + idEmpresaReceptora
				+ ", expedicion=" + expedicion + ", referencia=" + referencia + ", kilos=" + kilos + ", bultos="
				+ bultos + ", reembolso=" + reembolso + "]";
	}

}
