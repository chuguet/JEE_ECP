package es.upm.miw.jeeecp.models.daos.jdbc;

import java.util.List;

import es.upm.miw.jeeecp.models.daos.TemaDAO;
import es.upm.miw.jeeecp.models.entities.TemaEntity;

public class TemaDAOJdbc extends GenericDAOJdbc<TemaEntity, Integer> implements TemaDAO {

    @Override
    public Long countVotos(Integer idTema) {
        // TODO Auto-generated method stub
        return null;
    }

    private static final String SQL_CREATE_TABLE = "CREATE TABLE %s (%s INT NOT NULL, %s VARCHAR(255), %s VARCHAR(255), PRIMARY KEY (%s))";

    public static String sqlToCreateTable() {
        return String.format(SQL_CREATE_TABLE, TemaEntity.TABLE, TemaEntity.ID, TemaEntity.NOMBRE,
                TemaEntity.PREGUNTA, TemaEntity.ID);
    }

    @Override
    public void create(TemaEntity temaEntity) {
        // TODO Auto-generated method stub
    }

    @Override
    public TemaEntity read(Integer id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void update(TemaEntity entity) {
        // TODO Auto-generated method stub

    }

    @Override
    public void deleteById(Integer id) {
        // TODO Auto-generated method stub

    }

    @Override
    public List<TemaEntity> findAll() {
        // TODO Auto-generated method stub
        return null;
    }

}
