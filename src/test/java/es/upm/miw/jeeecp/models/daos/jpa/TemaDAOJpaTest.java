package es.upm.miw.jeeecp.models.daos.jpa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import es.upm.miw.jeeecp.models.daos.DAOFactory;
import es.upm.miw.jeeecp.models.daos.TemaDAO;
import es.upm.miw.jeeecp.models.daos.jpa.data.TemaDAOJpaTestData;
import es.upm.miw.jeeecp.models.entities.TemaEntity;
import es.upm.miw.jeeecp.models.utils.NivelEstudios;

public class TemaDAOJpaTest {

    private TemaDAO dao = DAOJpaFactory.getFactory().getTemaDAO();

    private TemaDAOJpaTestData data;

    @BeforeClass
    public static void beforeClass() {
        DAOFactory.setFactory(new DAOJpaFactory());
        DAOJpaFactory.dropAndCreateTables();
    }

    @Before
    public void init() {
        data = new TemaDAOJpaTestData();
    }

    private List<TemaEntity> saveData() {
        List<TemaEntity> temasData = new ArrayList<TemaEntity>();
        while (data.hasNextTemas()) {
            if (data.getTema() != null) {
                dao.create(data.getTema());
                temasData.add(data.getTema());
            }
            data.nextTema();
        }
        dao.create(data.getTema());
        temasData.add(data.getTema());
        return temasData;
    }

    @Test
    public void testCreate() {
        List<TemaEntity> temasData = this.saveData();
        List<TemaEntity> temas = dao.findAll();
        for (TemaEntity tema : temasData) {
            assertTrue(temas.contains(tema));
        }
        assertTrue(temas.size() == temasData.size());
    }

    @Test
    public void testRead() {
        List<TemaEntity> temasData = this.saveData();
        for (TemaEntity tema : temasData) {
            assertEquals(tema, dao.read(tema.getId()));
        }
    }

    @Test
    public void testUpdate() {
        TemaEntity temaTemporal;
        List<TemaEntity> temasData = this.saveData();
        for (TemaEntity tema : temasData) {
            temaTemporal = dao.read(tema.getId());
            temaTemporal.setNombre("TEMPORAL");
            dao.update(temaTemporal);
            assertNotEquals(tema, dao.read(tema.getId()));
        }
    }

    @Test
    public void testDeleteById() {
        List<TemaEntity> temasData = this.saveData();
        for (TemaEntity tema : temasData) {
            dao.deleteById(tema.getId());
        }
        assertTrue(dao.findAll().isEmpty());
    }

    @Test
    public void testFindAll() {
        List<TemaEntity> temasData = this.saveData();
        List<TemaEntity> temas = dao.findAll();
        for (TemaEntity tema : temasData) {
            assertTrue(temas.contains(tema));
        }
        assertTrue(temas.size() == temasData.size());
    }

    @Test
    public void testRetrieveVotosFromTema() {
        List<TemaEntity> temasData = this.saveData();
        for (TemaEntity tema : temasData) {
            assertTrue(tema.getVotos().size() == dao.retrieveVotosFromTema(tema.getId()).size());
        }
    }
    
    @Test
    public void testRetrieveVotosByNivelEstudiosAndTema() {
        List<TemaEntity> temasData = this.saveData();
        for (TemaEntity tema : temasData) {
//            assertTrue(tema.getVotos().size() == dao.retrieveVotosByNivelDeEstudiosAndTema(tema.getId(), NivelEstudios.BACHILLERATO));
        }
    }

}
