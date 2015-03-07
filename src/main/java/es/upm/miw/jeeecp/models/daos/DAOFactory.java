package es.upm.miw.jeeecp.models.daos;

import es.upm.miw.jeeecp.models.daos.jpa.DAOJpaFactory;

public abstract class DAOFactory {
	public static DAOFactory factory = null;

	public static void setFactory(DAOFactory factory) {
		DAOFactory.factory = factory;
	}

	// TODO romper esta referencia a DaoJpaFactory pq crea una dependencia
	// bidireccional
	public static DAOFactory getFactory() {
		if (factory == null) {
			factory = new DAOJpaFactory();
		}
		return factory;
	}

	public abstract TemaDAO getTemaDAO();

	public abstract VotoDAO getVotoDAO();

}
