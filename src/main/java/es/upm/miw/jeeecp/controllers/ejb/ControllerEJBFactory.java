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

    @Override
    public AnadirTemaController getAnadirTemaController() {
        return new AnadirTemaEJBController();
    }

    @Override
    public EliminarTemaController getEliminarTemaController() {
        return new EliminarTemaEJBController();
    }

    @Override
    public VerVotacionesController getVerVotacionesController() {
        return new VerVotacionesEJBController();
    }

    @Override
    public VotarController getVotarController() {
        return new VotarEJBController();
    }

}
