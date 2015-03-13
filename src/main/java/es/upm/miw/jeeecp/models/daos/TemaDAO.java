package es.upm.miw.jeeecp.models.daos;

import java.util.List;

import es.upm.miw.jeeecp.models.entities.TemaEntity;
import es.upm.miw.jeeecp.models.entities.VotoEntity;
import es.upm.miw.jeeecp.models.utils.NivelEstudios;

public interface TemaDAO extends GenericDAO<TemaEntity, Integer> {

	List<VotoEntity> retrieveVotosFromTema(Integer idTema);

	List<VotoEntity> retrieveVotosByNivelDeEstudiosAndTema(Integer idTema,
			NivelEstudios nivelEstudios);

}
