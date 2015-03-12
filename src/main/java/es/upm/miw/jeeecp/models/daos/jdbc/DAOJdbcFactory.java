package es.upm.miw.jeeecp.models.daos.jdbc;

import es.upm.miw.jeeecp.models.daos.DAOFactory;
import es.upm.miw.jeeecp.models.daos.TemaDAO;
import es.upm.miw.jeeecp.models.daos.VotoDAO;

public class DAOJdbcFactory extends DAOFactory {

    @Override
    public TemaDAO getTemaDAO() {
        return new TemaDAOJdbc();
    }

    @Override
    public VotoDAO getVotoDAO() {
        return null;
    }

}
