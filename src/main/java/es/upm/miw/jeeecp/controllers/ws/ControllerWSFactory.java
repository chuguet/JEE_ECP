package es.upm.miw.jeeecp.controllers.ws;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import es.upm.miw.jeeecp.controllers.AnadirTemaController;
import es.upm.miw.jeeecp.controllers.ControllerFactory;
import es.upm.miw.jeeecp.controllers.EliminarTemaController;
import es.upm.miw.jeeecp.controllers.VerVotacionesController;
import es.upm.miw.jeeecp.controllers.VotarController;

@ManagedBean
@ApplicationScoped
public class ControllerWSFactory extends ControllerFactory {

    private AnadirTemaController anadirTemaController;

    private EliminarTemaController eliminarTemaController;

    private VotarController votarController;

    private VerVotacionesController verVotacionesController;

    @Override
    public AnadirTemaController getAnadirTemaController() {
        if (this.anadirTemaController == null) {
            this.anadirTemaController = new AnadirTemaWSController();
        }
        return anadirTemaController;
    }

    @Override
    public EliminarTemaController getEliminarTemaController() {
        if (this.eliminarTemaController == null) {
            this.eliminarTemaController = new EliminarTemaWSController();
        }
        return eliminarTemaController;
    }

    @Override
    public VerVotacionesController getVerVotacionesController() {
        if (this.verVotacionesController == null) {
            this.verVotacionesController = new VerVotacionesWSController();
        }
        return verVotacionesController;
    }

    @Override
    public VotarController getVotarController() {
        if (this.votarController == null) {
            this.votarController = new VotarWSController();
        }
        return votarController;
    }

}
