package es.upm.miw.jeeecp.controllers.ejb;

import es.upm.miw.jeeecp.controllers.AnadirTemaController;
import es.upm.miw.jeeecp.models.daos.DAOFactory;
import es.upm.miw.jeeecp.models.daos.TemaDAO;
import es.upm.miw.jeeecp.models.daos.jpa.DAOJpaFactory;
import es.upm.miw.jeeecp.models.entities.TemaEntity;

public class AnadirTemaEJBController implements AnadirTemaController {

	@Override
	public void anadirTema(TemaEntity temaEntity) {
		DAOFactory.setFactory(new DAOJpaFactory());
		TemaDAO dao = DAOFactory.getFactory().getTemaDAO();
		dao.create(temaEntity);
	}

}
