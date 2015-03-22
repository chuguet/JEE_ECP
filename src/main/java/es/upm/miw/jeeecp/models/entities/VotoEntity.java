package es.upm.miw.jeeecp.models.entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

import es.upm.miw.jeeecp.models.utils.NivelEstudios;

@Entity
@XmlRootElement
public class VotoEntity {

    public static final String TABLE = "votoentity";

    public static final String ID = "ID";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    public static final String VALORACION = "VALORACION";

    private Integer valoracion;

    public static final String IP = "IP";

    private String ip;

    public static final String NIVELESTUDIOS = "NIVELESTUDIOS";

    @Enumerated(EnumType.STRING)
    private NivelEstudios nivelEstudios;

    public VotoEntity() {

    }

    public VotoEntity(Integer valoracion) {
        this.valoracion = valoracion;
    }

    public VotoEntity(Integer id, Integer valoracion, String ip, NivelEstudios nivelEstudios) {
        this(valoracion, ip, nivelEstudios);
        this.id = id;
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((ip == null) ? 0 : ip.hashCode());
        result = prime * result + ((nivelEstudios == null) ? 0 : nivelEstudios.hashCode());
        result = prime * result + ((valoracion == null) ? 0 : valoracion.hashCode());
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
        VotoEntity other = (VotoEntity) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (ip == null) {
            if (other.ip != null)
                return false;
        } else if (!ip.equals(other.ip))
            return false;
        if (nivelEstudios != other.nivelEstudios)
            return false;
        if (valoracion == null) {
            if (other.valoracion != null)
                return false;
        } else if (!valoracion.equals(other.valoracion))
            return false;
        return true;
    }

}
