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
        VotoEntity voto;
        DAOFactory daoFactory = DAOFactory.getFactory();
        VotoDAO votoDAO = daoFactory.getVotoDAO();

        voto = new VotoEntity(3, "192.168.1.1", NivelEstudios.BACHILLERATO);
        votoDAO.create(voto);
        voto = new VotoEntity(4, "192.168.1.1", NivelEstudios.BACHILLERATO);
        votoDAO.create(voto);
        voto = new VotoEntity(2, "192.168.1.1", NivelEstudios.LICENCIADO);
        votoDAO.create(voto);
        voto = new VotoEntity(5, "192.168.1.1", NivelEstudios.DIPLOMADO);
        votoDAO.create(voto);
        voto = new VotoEntity(9, "192.168.1.1", NivelEstudios.DIPLOMADO);
        votoDAO.create(voto);
        voto = new VotoEntity(7, "192.168.1.1", NivelEstudios.DIPLOMADO);
        votoDAO.create(voto);

        assertEquals(new Double(3.5), votoDAO.recuperarMediaVotacionesPorNivelDeEstudiosYTema(1,
                NivelEstudios.BACHILLERATO));
        assertEquals(new Double(7),
                votoDAO.recuperarMediaVotacionesPorNivelDeEstudiosYTema(1, NivelEstudios.DIPLOMADO));
        assertEquals(new Double(2), votoDAO.recuperarMediaVotacionesPorNivelDeEstudiosYTema(1,
                NivelEstudios.LICENCIADO));
    }
}
