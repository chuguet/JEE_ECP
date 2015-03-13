package es.upm.miw.jeeecp.models.daos.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import es.upm.miw.jeeecp.models.daos.VotoDAO;
import es.upm.miw.jeeecp.models.entities.VotoEntity;
import es.upm.miw.jeeecp.models.utils.NivelEstudios;

public class VotoDAOJdbc extends GenericDAOJdbc<VotoEntity, Integer> implements
		VotoDAO {

	private static final Logger LOG = LogManager.getLogger(VotoDAOJdbc.class);

	private static final String SQL_CREATE_TABLE = "CREATE TABLE %s (%s INT NOT NULL, %s INT, %s VARCHAR(255), %s VARCHAR(255), PRIMARY KEY (%s))";

	private static final String INSERT_QUERY = "INSERT INTO %s (%d,%d,%s,%s) VALUES (%d,'%s','%s','%s')";

	private static final String QUERY_UPDATE = "UPDATE %s SET %d='%d', %s='%s', %s='%s' WHERE ID=%d";

	public static String sqlToCreateTable() {
		return String.format(SQL_CREATE_TABLE, VotoEntity.TABLE, VotoEntity.ID,
				VotoEntity.IP, VotoEntity.NIVELESTUDIOS, VotoEntity.VALORACION,
				VotoEntity.ID);
	}

	@Override
	public void create(VotoEntity votoEntity) {
		this.updateSql(String.format(INSERT_QUERY, VotoEntity.TABLE,
				VotoEntity.ID, VotoEntity.VALORACION, VotoEntity.IP,
				VotoEntity.NIVELESTUDIOS, votoEntity.getId(),
				votoEntity.getValoracion(), votoEntity.getIp(),
				votoEntity.getNivelEstudios()));
	}

	@Override
	public VotoEntity read(Integer id) {
		ResultSet resultSet = this.query(String.format(SQL_SELECT_ID,
				VotoEntity.TABLE, id));
		return this.mapperResultSet(resultSet);
	}

	@Override
	public void update(VotoEntity votoEntity) {
		this.updateSql(String.format(QUERY_UPDATE, VotoEntity.TABLE,
				VotoEntity.ID, VotoEntity.VALORACION, VotoEntity.IP,
				VotoEntity.NIVELESTUDIOS, votoEntity.getId(),
				votoEntity.getValoracion(), votoEntity.getIp(),
				votoEntity.getNivelEstudios()));
	}

	@Override
	public void deleteById(Integer id) {
		this.updateSql(String.format(SQL_DELETE_ID, VotoEntity.TABLE, id));
	}

	@Override
	public List<VotoEntity> findAll() {
		ResultSet resultSet = this.query(String.format(SQL_SELECT_ALL,
				VotoEntity.TABLE));
		return this.mapperListResultSet(resultSet);
	}

	private List<VotoEntity> mapperListResultSet(ResultSet resultSet) {
		List<VotoEntity> result = new ArrayList<VotoEntity>();
		try {
			while (resultSet != null && resultSet.next()) {
				result.add(new VotoEntity(resultSet.getInt(VotoEntity.ID),
						resultSet.getInt(VotoEntity.VALORACION), resultSet
								.getString(VotoEntity.IP), NivelEstudios
								.valueOf(resultSet
										.getString(VotoEntity.NIVELESTUDIOS))));
			}
		} catch (SQLException e) {
			LOG.error(e.getMessage());
		}
		return result;
	}

	private VotoEntity mapperResultSet(ResultSet resultSet) {
		VotoEntity result = null;
		try {
			if (resultSet != null && resultSet.next()) {
				result = new VotoEntity(resultSet.getInt(VotoEntity.ID),
						resultSet.getInt(VotoEntity.VALORACION),
						resultSet.getString(VotoEntity.IP),
						NivelEstudios.valueOf(resultSet
								.getString(VotoEntity.NIVELESTUDIOS)));
			}
		} catch (SQLException e) {
			LOG.error(e.getMessage());
		}
		return result;
	}

}
