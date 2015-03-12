package es.upm.miw.jeeecp.models.daos.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import es.upm.miw.jeeecp.models.daos.TemaDAO;
import es.upm.miw.jeeecp.models.entities.TemaEntity;

public class TemaDAOJdbc extends GenericDAOJdbc<TemaEntity, Integer> implements TemaDAO {

    private static final Logger LOG = LogManager.getLogger(TemaDAOJdbc.class);

    private static final String SQL_CREATE_TABLE = "CREATE TABLE %s (%s INT NOT NULL, %s VARCHAR(255), %s VARCHAR(255), PRIMARY KEY (%s))";

    private static final String INSERT_QUERY = "INSERT INTO %s (%s,%s,%s) VALUES (%d,'%s','%s')";

    private static final String QUERY_UPDATE = "UPDATE %s SET %s='%s', %s='%s' WHERE ID=%d";

    public static String sqlToCreateTable() {
        return String.format(SQL_CREATE_TABLE, TemaEntity.TABLE, TemaEntity.ID, TemaEntity.NOMBRE,
                TemaEntity.PREGUNTA, TemaEntity.ID);
    }

    @Override
    public void create(TemaEntity temaEntity) {
        this.updateSql(String.format(INSERT_QUERY, TemaEntity.TABLE, TemaEntity.ID,
                TemaEntity.NOMBRE, TemaEntity.PREGUNTA, temaEntity.getId(), temaEntity.getNombre(),
                temaEntity.getPregunta()));
    }

    @Override
    public TemaEntity read(Integer id) {
        ResultSet resultSet = this.query(String.format(SQL_SELECT_ID, TemaEntity.TABLE, id));
        return this.mapperResultSet(resultSet);
    }

    @Override
    public void update(TemaEntity temaEntity) {
        this.updateSql(String.format(QUERY_UPDATE, TemaEntity.TABLE, TemaEntity.ID,
                TemaEntity.NOMBRE, TemaEntity.PREGUNTA, temaEntity.getId(), temaEntity.getNombre(),
                temaEntity.getPregunta()));
    }

    @Override
    public void deleteById(Integer id) {
        this.updateSql(String.format(SQL_DELETE_ID, TemaEntity.TABLE, id));
    }

    @Override
    public List<TemaEntity> findAll() {
        ResultSet resultSet = this.query(String.format(SQL_SELECT_ALL, TemaEntity.TABLE));
        return this.mapperListResultSet(resultSet);
    }

    @Override
    public Long countVotos(Integer idTema) {
        return (long) this.read(idTema).getVotos().size();
    }

    private List<TemaEntity> mapperListResultSet(ResultSet resultSet) {
        List<TemaEntity> result = new ArrayList<TemaEntity>();
        try {
            while (resultSet != null && resultSet.next()) {
                result.add(new TemaEntity(resultSet.getInt(TemaEntity.ID), resultSet
                        .getString(TemaEntity.NOMBRE), resultSet.getString(TemaEntity.PREGUNTA),
                        null));
            }
        } catch (SQLException e) {
            LOG.error(e.getMessage());
        }
        return result;
    }

    private TemaEntity mapperResultSet(ResultSet resultSet) {
        TemaEntity result = null;
        try {
            if (resultSet != null && resultSet.next()) {
                result = new TemaEntity(resultSet.getInt(TemaEntity.ID),
                        resultSet.getString(TemaEntity.NOMBRE),
                        resultSet.getString(TemaEntity.PREGUNTA), null);
            }
        } catch (SQLException e) {
            LOG.error(e.getMessage());
        }
        return result;
    }

}
