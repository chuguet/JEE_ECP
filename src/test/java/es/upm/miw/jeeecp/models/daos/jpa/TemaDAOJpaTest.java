package es.upm.miw.jeeecp.models.daos.jpa;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import es.upm.miw.jeeecp.models.daos.DAOFactory;
import es.upm.miw.jeeecp.models.daos.TemaDAO;
import es.upm.miw.jeeecp.models.entities.TemaEntity;

public class TemaDAOJpaTest {

    @Test
    public void createTemaTest() {
        TemaEntity tema = new TemaEntity();
        tema.setId(1);
        tema.setNombre("Futbol");
        tema.setPregunta("");
        TemaDAO temaDAO = DAOFactory.getFactory().getTemaDAO();
        temaDAO.create(tema);
        TemaEntity temaBD = temaDAO.read(1);
        assertTrue(temaBD.getVotos().isEmpty());
    }

}
