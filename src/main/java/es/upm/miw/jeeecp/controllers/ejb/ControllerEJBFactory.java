package es.upm.miw.jeeecp.controllers.ejb;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import es.upm.miw.jeeecp.controllers.AnadirTemaController;
import es.upm.miw.jeeecp.controllers.ControllerFactory;
import es.upm.miw.jeeecp.controllers.EliminarTemaController;
import es.upm.miw.jeeecp.controllers.VerVotacionesController;
import es.upm.miw.jeeecp.controllers.VotarController;

@ManagedBean
@ApplicationScoped
public class ControllerEJBFactory extends ControllerFactory {

    private AnadirTemaController anadirTemaController;

    private EliminarTemaController eliminarTemaController;

    private VotarController votarController;

    private VerVotacionesController verVotacionesController;

    @Override
    public AnadirTemaController getAnadirTemaController() {
        if (this.anadirTemaController == null) {
            this.anadirTemaController = new AnadirTemaEJBController();
        }
        return anadirTemaController;
    }

    @Override
    public EliminarTemaController getEliminarTemaController() {
        if (this.eliminarTemaController == null) {
            this.eliminarTemaController = new EliminarTemaEJBController();
        }
        return eliminarTemaController;
    }

    @Override
    public VerVotacionesController getVerVotacionesController() {
        if (this.verVotacionesController == null) {
            this.verVotacionesController = new VerVotacionesEJBController();
        }
        return verVotacionesController;
    }

    @Override
    public VotarController getVotarController() {
        if (this.votarController == null) {
            this.votarController = new VotarEJBController();
        }
        return votarController;
    }

}
