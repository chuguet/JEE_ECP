package es.upm.miw.jeeecp.models.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class TemaEntity {

    @Id
    private Integer id;

    private String nombre;

    private String pregunta;

    @OneToMany
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
