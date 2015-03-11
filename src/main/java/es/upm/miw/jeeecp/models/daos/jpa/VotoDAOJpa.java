package es.upm.miw.jeeecp.models.daos.jpa;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;

import es.upm.miw.jeeecp.models.daos.VotoDAO;
import es.upm.miw.jeeecp.models.entities.VotoEntity;
import es.upm.miw.jeeecp.models.utils.NivelEstudios;

public class VotoDAOJpa extends GenericDAOJpa<VotoEntity, Integer> implements VotoDAO {

    public VotoDAOJpa() {
        super(VotoEntity.class);
    }

    @Override
    public Double recuperarMediaVotacionesPorNivelDeEstudiosYTema(Integer idTema,
            NivelEstudios nivelEstudios) {
        EntityManager entityManager = DAOJpaFactory.getEntityManagerFactory().createEntityManager();
        Metamodel metaModel = entityManager.getMetamodel();
        EntityType<VotoEntity> VotoEntity_ = metaModel.entity(VotoEntity.class);

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Double> query = builder.createQuery(Double.class);
        // Root<VotoEntity> root = query.from(VotoEntity_.getClass());

        // query.select(builder.avg(root.get(VotoEntity_.getv));
        // Predicate predicate =
        // builder.equal(root.get("nivelEstudios").as(NivelEstudios.class),
        // nivelEstudios);
        // query.where(predicate);

        TypedQuery<Double> typedQuery = entityManager.createQuery(query);
        Double result = typedQuery.getSingleResult();
        entityManager.close();
        return result;
    }
}
