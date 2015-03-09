package es.upm.miw.jeeecp.models.daos.jpa;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import es.upm.miw.jeeecp.models.daos.DAOFactory;
import es.upm.miw.jeeecp.models.daos.VotoDAO;
import es.upm.miw.jeeecp.models.entities.VotoEntity;
import es.upm.miw.jeeecp.models.utils.NivelEstudios;

public class VotoDAOJpaTest {

    @Test
    public void createVotoTest() {
        VotoEntity voto = new VotoEntity();
        voto.setId(1);
        voto.setIp("192.168.1.1");
        voto.setNivelEstudios(NivelEstudios.BACHILLERATO);
        voto.setValoracion(1);
        DAOFactory daoFactory = DAOFactory.getFactory();
        VotoDAO votoDAO = daoFactory.getVotoDAO();
        votoDAO.create(voto);
        VotoEntity votoBD = votoDAO.read(1);
        assertEquals(NivelEstudios.BACHILLERATO, votoBD.getNivelEstudios());
    }
}
