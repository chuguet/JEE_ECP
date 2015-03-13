package es.upm.miw.jeeecp.models.daos.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.eclipse.persistence.jpa.JpaQuery;

import es.upm.miw.jeeecp.models.daos.VotoDAO;
import es.upm.miw.jeeecp.models.entities.TemaEntity;
import es.upm.miw.jeeecp.models.entities.VotoEntity;
import es.upm.miw.jeeecp.models.utils.NivelEstudios;

public class VotoDAOJpa extends GenericDAOJpa<VotoEntity, Integer> implements
		VotoDAO {

	public VotoDAOJpa() {
		super(VotoEntity.class);
	}

	@Override
	public List<VotoEntity> retrieveVotosByNivelDeEstudiosAndTema(
			Integer idTema, NivelEstudios nivelEstudios) {
		EntityManager entityManager = DAOJpaFactory.getEntityManagerFactory()
				.createEntityManager();
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<VotoEntity> query = builder.createQuery(VotoEntity.class);
		Root<VotoEntity> rootVoto = query.from(VotoEntity.class);
		Root<TemaEntity> rootTema = query.from(TemaEntity.class);
		rootTema.join("votos");
		query.select(rootVoto);
		Predicate predicate = builder.and(builder.equal(
				rootVoto.get("nivelEstudios").as(NivelEstudios.class),
				nivelEstudios), builder.equal(rootTema.get("id"), idTema));
		query.where(predicate);
		TypedQuery<VotoEntity> typedQuery = entityManager.createQuery(query);
		List<VotoEntity> result = typedQuery.getResultList();
		entityManager.close();
        System.out.println(typedQuery.unwrap(JpaQuery.class).getDatabaseQuery().getSQLString());
		return result;
	}

}
