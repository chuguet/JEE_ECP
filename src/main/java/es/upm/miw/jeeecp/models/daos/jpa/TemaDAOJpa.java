package es.upm.miw.jeeecp.models.daos.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import es.upm.miw.jeeecp.models.daos.TemaDAO;
import es.upm.miw.jeeecp.models.entities.TemaEntity;
import es.upm.miw.jeeecp.models.entities.VotoEntity;
import es.upm.miw.jeeecp.models.utils.NivelEstudios;

public class TemaDAOJpa extends GenericDAOJpa<TemaEntity, Integer> implements
		TemaDAO {

	public TemaDAOJpa() {
		super(TemaEntity.class);
	}

	@Override
	public List<VotoEntity> retrieveVotosFromTema(Integer idTema) {
		EntityManager entityManager = DAOJpaFactory.getEntityManagerFactory()
				.createEntityManager();
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<VotoEntity> query = builder.createQuery(VotoEntity.class);
		Root<TemaEntity> root = query.from(TemaEntity.class);
		query.select(root.get("votos"));
		Predicate predicate = builder.equal(root.get("id").as(Integer.class),
				idTema);
		query.where(predicate);
		TypedQuery<VotoEntity> typedQuery = entityManager.createQuery(query);
		List<VotoEntity> result = typedQuery.getResultList();
		entityManager.close();
		return result;
	}

	@Override
	public List<VotoEntity> retrieveVotosByNivelDeEstudiosAndTema(
			Integer idTema, NivelEstudios nivelEstudios) {
		List<VotoEntity> resultBD;
		List<VotoEntity> result = new ArrayList<VotoEntity>();
		EntityManager entityManager = DAOJpaFactory.getEntityManagerFactory()
				.createEntityManager();
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<VotoEntity> query = builder.createQuery(VotoEntity.class);
		Root<TemaEntity> root = query.from(TemaEntity.class);
		query.select(root.get("votos"));
		Predicate predicate = builder.and(builder.equal(
				root.get("id").as(Integer.class), idTema));
		query.where(predicate);
		TypedQuery<VotoEntity> typedQuery = entityManager.createQuery(query);
		resultBD = typedQuery.getResultList();
		entityManager.close();
		for(VotoEntity voto : resultBD){
			if(voto.getNivelEstudios().equals(nivelEstudios)){
				result.add(voto);
			}
		}
		return result;
	}

}
