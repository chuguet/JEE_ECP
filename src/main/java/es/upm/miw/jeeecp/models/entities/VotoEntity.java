package es.upm.miw.jeeecp.models.entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import es.upm.miw.jeeecp.models.utils.NivelEstudios;

@Entity
public class VotoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer valoracion;

    private String ip;

    @Enumerated(EnumType.STRING)
    private NivelEstudios nivelEstudios;

    public VotoEntity() {

    }

    public VotoEntity(Integer valoracion, String ip, NivelEstudios nivelEstudios) {
        this.valoracion = valoracion;
        this.ip = ip;
        this.nivelEstudios = nivelEstudios;
    }

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
