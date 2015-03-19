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

    public String process() {
        AnadirTemaController anadirTemaController = this.getControllerFactory()
                .getAnadirTemaController();
        Boolean existeTema = anadirTemaController.existeTema(this.getTema());
        if (!existeTema) {
            anadirTemaController.anadirTema(this.getTema());
            this.setTema(new TemaEntity());
            this.setError(false);
        } else {
            this.setError(true);
        }
        return null;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }
}
