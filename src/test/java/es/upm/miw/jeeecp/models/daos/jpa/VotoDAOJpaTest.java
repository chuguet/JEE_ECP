package es.upm.miw.jeeecp.models.daos.jpa;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import es.upm.miw.jeeecp.models.daos.DAOFactory;
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

	@BeforeClass
	public static void beforeClass() {
		DAOFactory.setFactory(new DAOJpaFactory());
		DAOJpaFactory.dropAndCreateTables();
	}

	@Before
	public void inti() {
		data = new TemaDAOJpaTestData();
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
	
    @Test
    public void testRetrieveVotosByNivelEstudiosAndTema() {
        List<TemaEntity> temasData = this.saveData();
        for (TemaEntity tema : temasData) {
            assertEquals(this.getVotosByNivelEstudios(tema, NivelEstudios.BACHILLERATO), daoVoto.retrieveVotosByNivelDeEstudiosAndTema(tema.getId(), NivelEstudios.BACHILLERATO));
        }
    }

	private List<VotoEntity> getVotosByNivelEstudios(TemaEntity tema, NivelEstudios nivelEstudios) {
		List<VotoEntity> votos = new ArrayList<VotoEntity>();
		for(VotoEntity voto : tema.getVotos()) {
			if(voto.getNivelEstudios().equals(nivelEstudios)){
				votos.add(voto);
			}
		}
		return votos;
	}
	
}
