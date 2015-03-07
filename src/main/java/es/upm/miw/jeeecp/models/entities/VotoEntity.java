package es.upm.miw.jeeecp.models.entities;

import es.upm.miw.jeeecp.models.utils.NivelEstudios;

public class VotoEntity {

	private Integer valoracion;
	private String ip;
	private NivelEstudios nivelEstudios;

	public Integer getValoracion() {
		return valoracion;
	}

	public void setValoracion(Integer valoracion) {
		this.valoracion = valoracion;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public NivelEstudios getNivelEstudios() {
		return nivelEstudios;
	}

	public void setNivelEstudios(NivelEstudios nivelEstudios) {
		this.nivelEstudios = nivelEstudios;
	}

}
