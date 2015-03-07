package es.upm.miw.jeeecp.models.daos.jpa;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.logging.log4j.LogManager;

import es.upm.miw.jeeecp.models.daos.DAOFactory;
import es.upm.miw.jeeecp.models.daos.TemaDAO;
import es.upm.miw.jeeecp.models.daos.VotoDAO;

public class DAOJpaFactory extends DAOFactory {
	private static final String PERSISTENCE_UNIT = "tictactoe";

	private static EntityManagerFactory entityManagerFactory = Persistence
			.createEntityManagerFactory(PERSISTENCE_UNIT);

	public DAOJpaFactory() {
		LogManager.getLogger(DAOJpaFactory.class).debug(
				"create Entity Manager Factory");
	}

	public static EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
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
