package es.upm.miw.jeeecp.models.daos.jpa;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import es.upm.miw.jeeecp.models.daos.TemaDAO;
import es.upm.miw.jeeecp.models.daos.jpa.data.TemaDAOJpaTestData;
import es.upm.miw.jeeecp.models.entities.TemaEntity;

public class TemaDAOJpaTest {

    private TemaDAO dao = DAOJpaFactory.getFactory().getTemaDAO();

    private TemaDAOJpaTestData data;

    @Before
    public void inti() {
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
    public void testCountVotos() {
        List<TemaEntity> temasData = this.saveData();
        for (TemaEntity tema : temasData) {
            assertTrue(tema.getVotos().size() == dao.countVotos(tema.getId()));
        }
    }

}
