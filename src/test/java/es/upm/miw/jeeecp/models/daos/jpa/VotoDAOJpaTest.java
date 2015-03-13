package es.upm.miw.jeeecp.models.daos.jpa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import es.upm.miw.jeeecp.models.daos.DAOFactory;
import es.upm.miw.jeeecp.models.daos.VotoDAO;
import es.upm.miw.jeeecp.models.daos.jpa.data.VotoDAOJpaTestData;
import es.upm.miw.jeeecp.models.entities.VotoEntity;

public class VotoDAOJpaTest {

	private VotoDAO dao = DAOJpaFactory.getFactory().getVotoDAO();

	private VotoDAOJpaTestData data;

	@BeforeClass
	public static void beforeClass() {
		DAOFactory.setFactory(new DAOJpaFactory());
		DAOJpaFactory.dropAndCreateTables();
	}

	@Before
	public void init() {
		data = new VotoDAOJpaTestData();
	}
	
	@After
	public void finish() {
		List<VotoEntity> votos = dao.findAll();
		for(VotoEntity voto : votos){
			dao.deleteById(voto.getId());
		}
	}
	
	private List<VotoEntity> saveData() {
		List<VotoEntity> votosData = new ArrayList<VotoEntity>();
		while (data.hasNextVotos()) {
			if (data.getVoto() != null) {
				dao.create(data.getVoto());
				votosData.add(data.getVoto());
			}
			data.nextVoto();
		}
		dao.create(data.getVoto());
		votosData.add(data.getVoto());
		return votosData;
	}

	@Test
	public void testCreate() {
		List<VotoEntity> votosData = this.saveData();
		List<VotoEntity> votos = dao.findAll();
		for (VotoEntity voto : votosData) {
			assertTrue(votos.contains(voto));
		}
		assertTrue(votos.size() == votosData.size());
	}

	@Test
	public void testRead() {
		List<VotoEntity> votosData = this.saveData();
		for (VotoEntity voto : votosData) {
			assertEquals(voto, dao.read(voto.getId()));
		}
	}

	@Test
	public void testUpdate() {
		VotoEntity votoTemporal;
		List<VotoEntity> votosData = this.saveData();
		for (VotoEntity voto : votosData) {
			votoTemporal = dao.read(voto.getId());
			votoTemporal.setValoracion(0);
			dao.update(votoTemporal);
			assertNotEquals(voto, dao.read(voto.getId()));
		}
	}

	@Test
	public void testDeleteById() {
		List<VotoEntity> votosData = this.saveData();
		for (VotoEntity voto : votosData) {
			dao.deleteById(voto.getId());
		}
		assertTrue(dao.findAll().isEmpty());
	}

	@Test
	public void testFindAll() {
		List<VotoEntity> votosData = this.saveData();
		List<VotoEntity> votos = dao.findAll();
		for (VotoEntity voto : votosData) {
			assertTrue(votos.contains(voto));
		}
		assertTrue(votos.size() == votosData.size());
	}

}
