package es.upm.miw.jeeecp.views.web.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import es.upm.miw.jeeecp.controllers.VotarController;
import es.upm.miw.jeeecp.models.entities.TemaEntity;
import es.upm.miw.jeeecp.models.entities.VotoEntity;

@ManagedBean
public class VotarBean extends ViewBean {

    public VotarBean() {
        this.voto = new VotoEntity();
        this.tema = new TemaEntity();
        this.temas = new ArrayList<TemaEntity>();
    }

    private VotoEntity voto;

    private TemaEntity tema;

    private List<TemaEntity> temas;

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

}
