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
    
    private Integer temaId;

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
        return null;
    }
    
    public String seleccionarTema(){
        VotarController votarController = this.getControllerFactory().getVotarController();
    	if (this.getTemaId() == null) {
            this.setTemas(votarController.recuperaTemas());
        } else {
            this.setTema(votarController.buscaTema(this.getTemaId()));
        }
    	return null;
    }

    public String votar(){
    	
    	return null;
    }
    
    public void update() {
        VotarController votarController = this.getControllerFactory().getVotarController();
        this.setTemas(votarController.recuperaTemas());
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

	public Integer getTemaId() {
		return temaId;
	}

	public void setTemaId(Integer temaId) {
		this.temaId = temaId;
	}
	
}
