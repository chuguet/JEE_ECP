package es.upm.miw.jeeecp.views.web.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import es.upm.miw.jeeecp.controllers.VotarController;
import es.upm.miw.jeeecp.models.entities.TemaEntity;
import es.upm.miw.jeeecp.models.entities.VotoEntity;
import es.upm.miw.jeeecp.models.utils.NivelEstudios;

@ManagedBean
@ViewScoped
public class VotarBean extends ViewBean {

    private static final long serialVersionUID = -4958143950068508158L;

    public VotarBean() {
    }

    private String nivelEstudios;

    private List<String> nivelEstudiosList = new ArrayList<String>();

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
            this.setNivelEstudiosList(votarController.recuperaNivelEstudios());
        } else {
            if (this.getTema().getId() == null) {
                this.setTemas(votarController.recuperaTemas());
            } else {
                this.setTema(votarController.buscaTema(this.getTema().getId()));
                this.setNivelEstudiosList(votarController.recuperaNivelEstudios());
            }
        }
        return null;
    }

    public String seleccionarTema() {
        VotarController votarController = this.getControllerFactory().getVotarController();
        if (this.getTemaId() != null) {
            this.setTema(votarController.buscaTema(this.getTemaId()));
            this.getVoto().setValoracion(0);
        }
        return null;
    }

    public String votar() {
        VotarController votarController = this.getControllerFactory().getVotarController();
        this.getVoto().setNivelEstudios(NivelEstudios.valueOf(this.getNivelEstudios()));
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance()
                .getExternalContext().getRequest();
        String ipAddress = request.getHeader("X-FORWARDED-FOR");
        if (ipAddress == null) {
            ipAddress = request.getRemoteAddr();
        }
        this.getVoto().setIp(ipAddress);
        votarController.votar(this.getTema(), this.getVoto());
        this.setVoto(new VotoEntity());
        this.setTema(new TemaEntity());
        this.setTemaId(null);
        return null;
    }

    public void update() {
        VotarController votarController = this.getControllerFactory().getVotarController();
        this.setTemas(votarController.recuperaTemas());
        this.setNivelEstudiosList(votarController.recuperaNivelEstudios());
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

    public String getNivelEstudios() {
        return nivelEstudios;
    }

    public void setNivelEstudios(String nivelEstudios) {
        this.nivelEstudios = nivelEstudios;
    }

    public Integer getTemaId() {
        return temaId;
    }

    public void setTemaId(Integer temaId) {
        this.temaId = temaId;
    }

    public List<String> getNivelEstudiosList() {
        return nivelEstudiosList;
    }

    public void setNivelEstudiosList(List<String> nivelEstudiosList) {
        this.nivelEstudiosList = nivelEstudiosList;
    }

}
