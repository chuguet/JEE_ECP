package es.upm.miw.jeeecp.controllers.ejb;

import java.util.List;

import es.upm.miw.jeeecp.controllers.VotarController;
import es.upm.miw.jeeecp.models.daos.DAOFactory;
import es.upm.miw.jeeecp.models.daos.TemaDAO;
import es.upm.miw.jeeecp.models.daos.jpa.DAOJpaFactory;
import es.upm.miw.jeeecp.models.entities.TemaEntity;

public class VotarEJBController implements VotarController {

    @Override
    public List<TemaEntity> recuperaTemas() {
        DAOFactory.setFactory(new DAOJpaFactory());
        TemaDAO dao = DAOFactory.getFactory().getTemaDAO();
        return dao.findAll();
    }

}
