package es.upm.miw.jeeecp.views.web.beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import es.upm.miw.jeeecp.controllers.EliminarTemaController;
import es.upm.miw.jeeecp.controllers.VotarController;
import es.upm.miw.jeeecp.models.entities.TemaEntity;

@ManagedBean
public class EliminarTemaBean extends ViewBean {

    private static final String CLAVE = "666";

    private String autorizacion;

    private TemaEntity tema;

    private List<TemaEntity> temas;

    public EliminarTemaBean() {
    }

    @PostConstruct
    public void init() {
        this.temas = new ArrayList<TemaEntity>();
        this.tema = new TemaEntity();
    }

    public EliminarTemaBean(String autorizacion, TemaEntity tema, List<TemaEntity> temas) {
        this.autorizacion = autorizacion;
        this.tema = tema;
        this.temas = temas;
    }

    public String getAutorizacion() {
        return autorizacion;
    }

    public void setAutorizacion(String autorizacion) {
        this.autorizacion = autorizacion;
    }

    public TemaEntity getTema() {
        return tema;
    }

    public void setTema(TemaEntity tema) {
        this.tema = tema;
    }

    public List<TemaEntity> getTemas() {
        return temas;
    }

    public void setTemas(List<TemaEntity> temas) {
        this.temas = temas;
    }

    public String process() {
        EliminarTemaController eliminarTemaController = this.getControllerFactory()
                .getEliminarTemaController();
        VotarController votarController = this.getControllerFactory().getVotarController();
        if (this.autorizacion.equals(CLAVE)) {
            if (this.getTema().getId() != null) {
                eliminarTemaController.eliminarTema(this.getTema());
            }
            this.setTemas(votarController.recuperaTemas());
            this.setTema(new TemaEntity());
        }
        return null;
    }

    public String eliminar() {
        EliminarTemaController eliminarTemaController = this.getControllerFactory()
                .getEliminarTemaController();
        VotarController votarController = this.getControllerFactory().getVotarController();
        if (this.getTema().getId() != null) {
            eliminarTemaController.eliminarTema(this.getTema());
        }
        this.setTemas(votarController.recuperaTemas());
        return null;
    }

    public String autorizar() {
        VotarController votarController = this.getControllerFactory().getVotarController();
        if (this.autorizacion.equals(CLAVE)) {
            this.setTemas(votarController.recuperaTemas());
        }
        return null;
    }

}
