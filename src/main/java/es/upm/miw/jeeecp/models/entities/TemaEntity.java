package es.upm.miw.jeeecp.models.entities;

import java.util.List;

public class TemaEntity {

	private Integer id;
	private String pregunta;
	private List<VotoEntity> votos;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPregunta() {
		return pregunta;
	}

	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}

	public List<VotoEntity> getVotos() {
		return votos;
	}

	public void setVotos(List<VotoEntity> votos) {
		this.votos = votos;
	}

}
