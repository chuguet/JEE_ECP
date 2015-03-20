package es.upm.miw.jeeecp.views.web.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import es.upm.miw.jeeecp.controllers.VotarController;
import es.upm.miw.jeeecp.models.entities.TemaEntity;
import es.upm.miw.jeeecp.models.entities.VotoEntity;

@ManagedBean
@ViewScoped
public class VotarBean extends ViewBean {

    public VotarBean() {
    }

    private List<String> nivelEstudios = new ArrayList<String>();
    
    private VotoEntity voto = new VotoEntity();

    private TemaEntity tema = new TemaEntity();

    private List<TemaEntity> temas = new ArrayList<TemaEntity>();

    public List<TemaEntity> getTemas() {
        return temas;
    }

    public void setTemas(List<TemaEntity> temas) {
        this.temas = temas;
    }

    public String process() {
        VotarController votarController = this.getControllerFactory().getVotarController();
        if (voto.getValoracion() != null) {
            votarController.votar(this.getTema(), this.getVoto());
            this.setVoto(new VotoEntity());
            this.setTema(new TemaEntity());
            this.setTemas(votarController.recuperaTemas());
        } else {
            if (this.getTema().getId() == null) {
                this.setTemas(votarController.recuperaTemas());
            } else {
                this.setTema(votarController.buscaTema(this.getTema().getId()));
            }
        }
        this.setNivelEstudios(votarController.recuperaNivelEstudios());
        return null;
    }

    public void update() {
        VotarController votarController = this.getControllerFactory().getVotarController();
        this.setTemas(votarController.recuperaTemas());
        this.setTema(new TemaEntity());
        this.setVoto(new VotoEntity());
        this.setNivelEstudios(votarController.recuperaNivelEstudios());
    }

    public TemaEntity getTema() {
        return tema;
    }

    public void setTema(TemaEntity tema) {
        this.tema = tema;
    }

    public VotoEntity getVoto() {
        return voto;
    }

    public void setVoto(VotoEntity voto) {
        this.voto = voto;
    }

	public List<String> getNivelEstudios() {
		return nivelEstudios;
	}

	public void setNivelEstudios(List<String> nivelEstudios) {
		this.nivelEstudios = nivelEstudios;
	}

}
