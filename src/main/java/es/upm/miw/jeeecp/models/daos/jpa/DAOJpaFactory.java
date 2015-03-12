package es.upm.miw.jeeecp.models.daos.jpa;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.logging.log4j.LogManager;
import org.eclipse.persistence.config.PersistenceUnitProperties;

import es.upm.miw.jeeecp.models.daos.DAOFactory;
import es.upm.miw.jeeecp.models.daos.TemaDAO;
import es.upm.miw.jeeecp.models.daos.VotoDAO;

public class DAOJpaFactory extends DAOFactory {
    private static final String PERSISTENCE_UNIT = "jee_ecp";

    private static EntityManagerFactory entityManagerFactory;

    public DAOJpaFactory() {
        LogManager.getLogger(DAOJpaFactory.class).debug("create Entity Manager Factory");
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        if (entityManagerFactory == null) {
            entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
            LogManager.getLogger(DAOJpaFactory.class).debug("create Entity Manager Factory");
        }
        return entityManagerFactory;
    }

    public static void dropAndCreateTables() {
        Map<String, String> properties = new HashMap<>();
        properties.put(PersistenceUnitProperties.DDL_GENERATION,
                PersistenceUnitProperties.DROP_AND_CREATE);
        entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT, properties);
    }

    @Override
    public TemaDAO getTemaDAO() {
        return new TemaDAOJpa();
    }

    @Override
    public VotoDAO getVotoDAO() {
        return new VotoDAOJpa();
    }

}
