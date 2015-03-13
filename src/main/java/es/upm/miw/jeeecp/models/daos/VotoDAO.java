package es.upm.miw.jeeecp.models.daos;

import java.util.List;

import es.upm.miw.jeeecp.models.entities.VotoEntity;
import es.upm.miw.jeeecp.models.utils.NivelEstudios;

public interface VotoDAO extends GenericDAO<VotoEntity, Integer> {

	List<VotoEntity> retrieveVotosByNivelDeEstudiosAndTema(
			Integer idTema, NivelEstudios nivelEstudios);

}

