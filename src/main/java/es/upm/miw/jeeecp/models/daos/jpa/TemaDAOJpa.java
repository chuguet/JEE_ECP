package es.upm.miw.jeeecp.models.daos.jpa;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import es.upm.miw.jeeecp.models.daos.TemaDAO;
import es.upm.miw.jeeecp.models.entities.TemaEntity;

public class TemaDAOJpa extends GenericDAOJpa<TemaEntity, Integer> implements TemaDAO {

    public TemaDAOJpa() {
        super(TemaEntity.class);
    }

    @Override
    public Long countVotos(Integer id) {
        EntityManager entityManager = DAOJpaFactory.getEntityManagerFactory().createEntityManager();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> query = builder.createQuery(Long.class);
        Root<TemaEntity> root = query.from(TemaEntity.class);
        query.select(builder.count(root.get("votos")));
        Predicate predicate = builder.equal(root.get("id").as(Integer.class), id);
        query.where(predicate);
        TypedQuery<Long> typedQuery = entityManager.createQuery(query);
        Long result = typedQuery.getSingleResult();
        entityManager.close();
        return result;
    }

}
