package es.upm.miw.jeeecp.models.daos.jpa;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import es.upm.miw.jeeecp.models.daos.TemaDAO;
import es.upm.miw.jeeecp.models.daos.VotoDAO;
import es.upm.miw.jeeecp.models.daos.jpa.data.TemaDAOJpaTestData;
import es.upm.miw.jeeecp.models.entities.TemaEntity;
import es.upm.miw.jeeecp.models.entities.VotoEntity;
import es.upm.miw.jeeecp.models.utils.NivelEstudios;

public class VotoDAOJpaTest {

    private VotoDAO daoVoto = DAOJpaFactory.getFactory().getVotoDAO();

    private TemaDAO daoTema = DAOJpaFactory.getFactory().getTemaDAO();

    private TemaDAOJpaTestData data;

    @Before
    public void inti() {
        data = new TemaDAOJpaTestData();
    }

    // @Test
    public void createVotoTest() {
        VotoEntity voto;

        voto = new VotoEntity(3, "192.168.1.1", NivelEstudios.BACHILLERATO);
        daoVoto.create(voto);
        voto = new VotoEntity(4, "192.168.1.1", NivelEstudios.BACHILLERATO);
        daoVoto.create(voto);
        voto = new VotoEntity(2, "192.168.1.1", NivelEstudios.LICENCIADO);
        daoVoto.create(voto);
        voto = new VotoEntity(5, "192.168.1.1", NivelEstudios.DIPLOMADO);
        daoVoto.create(voto);
        voto = new VotoEntity(9, "192.168.1.1", NivelEstudios.DIPLOMADO);
        daoVoto.create(voto);
        voto = new VotoEntity(7, "192.168.1.1", NivelEstudios.DIPLOMADO);
        daoVoto.create(voto);

        assertEquals(new Double(3.5), daoVoto.recuperarMediaVotacionesPorNivelDeEstudiosYTema(1,
                NivelEstudios.BACHILLERATO));
        assertEquals(new Double(7),
                daoVoto.recuperarMediaVotacionesPorNivelDeEstudiosYTema(1, NivelEstudios.DIPLOMADO));
        assertEquals(new Double(2), daoVoto.recuperarMediaVotacionesPorNivelDeEstudiosYTema(1,
                NivelEstudios.LICENCIADO));
    }

    @Test
    public void testCreate() {
        List<TemaEntity> temasData = this.saveData();
        for (TemaEntity tema : temasData) {
            assertEquals(this.calculateMedia(tema.getVotos(), NivelEstudios.BACHILLERATO),
                    daoVoto.recuperarMediaVotacionesPorNivelDeEstudiosYTema(tema.getId(),
                            NivelEstudios.BACHILLERATO));
        }
    }

    private Double calculateMedia(List<VotoEntity> votos, NivelEstudios nivelEstudios) {
        Double result = 0d;
        Integer total = 0;
        for (VotoEntity voto : votos) {
            if (nivelEstudios.equals(voto.getNivelEstudios())) {
                result += voto.getValoracion();
                total++;
            }
        }
        if (total == 0) {
            return null;
        }
        return result / total;
    }

    private List<TemaEntity> saveData() {
        List<TemaEntity> temasData = new ArrayList<TemaEntity>();
        while (data.hasNextTemas()) {
            if (data.getTema() != null) {
                daoTema.create(data.getTema());
                temasData.add(data.getTema());
            }
            data.nextTema();
        }
        daoTema.create(data.getTema());
        temasData.add(data.getTema());
        return temasData;
    }
}
