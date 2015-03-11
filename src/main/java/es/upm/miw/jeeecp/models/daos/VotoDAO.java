package es.upm.miw.jeeecp.models.daos;

import es.upm.miw.jeeecp.models.entities.VotoEntity;
import es.upm.miw.jeeecp.models.utils.NivelEstudios;

public interface VotoDAO extends GenericDAO<VotoEntity, Integer> {

    Double recuperarMediaVotacionesPorNivelDeEstudiosYTema(Integer idTema,
            NivelEstudios nivelEstudios);

}
