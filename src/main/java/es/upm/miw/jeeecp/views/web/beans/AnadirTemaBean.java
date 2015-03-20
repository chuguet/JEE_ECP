package es.upm.miw.jeeecp.views.web.beans;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import es.upm.miw.jeeecp.controllers.AnadirTemaController;
import es.upm.miw.jeeecp.models.entities.TemaEntity;

@ManagedBean
public class AnadirTemaBean extends ViewBean {

    private boolean error;

    private TemaEntity tema;

    @PostConstruct
    public void init() {
        this.tema = new TemaEntity();
    }

    public AnadirTemaBean() {
    }

    public AnadirTemaBean(TemaEntity tema) {
        this.tema = tema;
    }

    public TemaEntity getTema() {
        return tema;
    }

    public void setTema(TemaEntity tema) {
        this.tema = tema;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }
    
    public String process() {
        AnadirTemaController anadirTemaController = this.getControllerFactory()
                .getAnadirTemaController();
        if (anadirTemaController.existeTema(this.getTema())) {
            this.setError(true);
        } else {
            anadirTemaController.anadirTema(this.getTema());
            this.setTema(new TemaEntity());
            this.setError(false);
        }
        return null;
    }
}
