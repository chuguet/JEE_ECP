package es.upm.miw.jeeecp.models.daos.jpa;

import es.upm.miw.jeeecp.models.daos.TemaDAO;
import es.upm.miw.jeeecp.models.entities.TemaEntity;

public class TemaDAOJpa extends GenericDAOJpa<TemaEntity, Integer> implements TemaDAO {

    public TemaDAOJpa() {
        super(TemaEntity.class);
    }

}
