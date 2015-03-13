package es.upm.miw.jeeecp.models.daos.jpa;

import es.upm.miw.jeeecp.models.daos.VotoDAO;
import es.upm.miw.jeeecp.models.entities.VotoEntity;

public class VotoDAOJpa extends GenericDAOJpa<VotoEntity, Integer> implements VotoDAO {

    public VotoDAOJpa() {
        super(VotoEntity.class);
    }

}
