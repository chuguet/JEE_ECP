package es.upm.miw.jeeecp.models.daos;

import java.util.List;

import es.upm.miw.jeeecp.models.entities.TemaEntity;
import es.upm.miw.jeeecp.models.entities.VotoEntity;

public interface TemaDAO extends GenericDAO<TemaEntity, Integer> {

	List<VotoEntity> retrieveVotosFromTema(Integer idTema);

}
