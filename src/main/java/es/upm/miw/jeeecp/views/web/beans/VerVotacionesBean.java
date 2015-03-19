package es.upm.miw.jeeecp.views.web.beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import es.upm.miw.jeeecp.controllers.VerVotacionesController;
import es.upm.miw.jeeecp.controllers.VotarController;
import es.upm.miw.jeeecp.models.entities.TemaEntity;
import es.upm.miw.jeeecp.models.utils.NivelEstudios;

@ManagedBean
public class VerVotacionesBean extends ViewBean {

    public VerVotacionesBean() {
    }

    @PostConstruct
    public void init() {
        this.temas = new ArrayList<TemaEntity>();
        this.tema = new TemaEntity();
    }

    private List<TemaEntity> temas;

    private TemaEntity tema;

    private NivelEstudios nivelEstudios;

    private Double mediaVotos;

    private Integer numeroVotos;

    public TemaEntity getTema() {
        return tema;
    }

    public void setTema(TemaEntity tema) {
        this.tema = tema;
    }

    public NivelEstudios getNivelEstudios() {
        return nivelEstudios;
    }

    public void setNivelEstudios(NivelEstudios nivelEstudios) {
        this.nivelEstudios = nivelEstudios;
    }

    public Double getMediaVotos() {
        return mediaVotos;
    }

    public void setMediaVotos(Double mediaVotos) {
        this.mediaVotos = mediaVotos;
    }

    public Integer getNumeroVotos() {
        return numeroVotos;
    }

    public void setNumeroVotos(Integer numeroVotos) {
        this.numeroVotos = numeroVotos;
    }

    public List<TemaEntity> getTemas() {
        return temas;
    }

    public void setTemas(List<TemaEntity> temas) {
        this.temas = temas;
    }

    public String process() {
        VotarController votarController = this.getControllerFactory().getVotarController();
        VerVotacionesController verVotacionesController = this.getControllerFactory()
                .getVerVotacionesController();
        if (this.getNivelEstudios() == null) {
            if (this.getTema().getId() != null) {
                this.setTema(votarController.buscaTema(this.getTema().getId()));
                this.setNumeroVotos(verVotacionesController.recuperaNumeroVotos(this.getTema()));
            } else {
                this.setTemas(votarController.recuperaTemas());
            }
        } else {
            this.setTema(votarController.buscaTema(this.getTema().getId()));
            this.setNumeroVotos(verVotacionesController.recuperaNumeroVotos(this.getTema()));
            this.setMediaVotos(verVotacionesController.recuperaMediaDeVotosPorNivelEstuidos(
                    this.getTema(), this.getNivelEstudios()));
            this.setNivelEstudios(this.getNivelEstudios());
        }
        return null;
    }

    public String seleccionarTema() {
        System.out.println("LLEGO");
        return null;
    }

    public void update() {
        VotarController votarController = this.getControllerFactory().getVotarController();
        this.setTemas(votarController.recuperaTemas());
    }

}
