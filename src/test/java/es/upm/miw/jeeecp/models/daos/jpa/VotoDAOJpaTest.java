package es.upm.miw.jeeecp.models.daos.jpa;

import org.junit.Before;
import org.junit.BeforeClass;

import es.upm.miw.jeeecp.models.daos.DAOFactory;
import es.upm.miw.jeeecp.models.daos.VotoDAO;
import es.upm.miw.jeeecp.models.daos.jpa.data.TemaDAOJpaTestData;

public class VotoDAOJpaTest {

	private VotoDAO daoVoto = DAOJpaFactory.getFactory().getVotoDAO();

	private TemaDAOJpaTestData data;

	@BeforeClass
	public static void beforeClass() {
		DAOFactory.setFactory(new DAOJpaFactory());
		DAOJpaFactory.dropAndCreateTables();
	}

	@Before
	public void inti() {
		data = new TemaDAOJpaTestData();
	}

}
