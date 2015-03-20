package es.upm.miw.jeeecp.controllers.ejb;

import es.upm.miw.jeeecp.controllers.EliminarTemaController;
import es.upm.miw.jeeecp.models.daos.DAOFactory;
import es.upm.miw.jeeecp.models.daos.TemaDAO;
import es.upm.miw.jeeecp.models.daos.jpa.DAOJpaFactory;
import es.upm.miw.jeeecp.models.entities.TemaEntity;

public class EliminarTemaEJBController implements EliminarTemaController {

	private static final String CLAVE = "666";
	
    @Override
    public void eliminarTema(TemaEntity temaEntity) {
        DAOFactory.setFactory(new DAOJpaFactory());
        TemaDAO dao = DAOFactory.getFactory().getTemaDAO();
        dao.deleteById(temaEntity.getId());
    }

	@Override
	public Boolean autorizar(String autorizacion) {
		return CLAVE.equals(autorizacion);
	}

}
