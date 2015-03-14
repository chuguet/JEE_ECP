package es.upm.miw.jeeecp.models.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class TemaEntity {

    @Id
    private Integer id;

    private String nombre;

    private String pregunta;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<VotoEntity> votos;

    public TemaEntity() {
    }

    public TemaEntity(Integer id, String nombre, String pregunta) {
        this.id = id;
        this.nombre = nombre;
        this.pregunta = pregunta;
    }

    public TemaEntity(Integer id, String nombre, String pregunta, List<VotoEntity> votos) {
        this(id, nombre, pregunta);
        this.votos = votos;
    }

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

    public void addVoto(VotoEntity voto) {
        if (this.votos == null) {
            this.votos = new ArrayList<VotoEntity>();
        }
        this.votos.add(voto);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        TemaEntity other = (TemaEntity) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (nombre == null) {
            if (other.nombre != null)
                return false;
        } else if (!nombre.equals(other.nombre))
            return false;
        return true;
    }

}
