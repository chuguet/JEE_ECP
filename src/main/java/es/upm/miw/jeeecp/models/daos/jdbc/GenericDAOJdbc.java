package es.upm.miw.jeeecp.models.daos.jdbc;

import java.util.List;

import es.upm.miw.jeeecp.models.daos.GenericDAO;

public class GenericDAOJdbc<T, ID> implements GenericDAO<T, ID> {

    @Override
    public void create(T entity) {
        // TODO Auto-generated method stub

    }

    @Override
    public T read(ID id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void update(T entity) {
        // TODO Auto-generated method stub

    }

    @Override
    public void deleteById(ID id) {
        // TODO Auto-generated method stub

    }

    @Override
    public List<T> findAll() {
        // TODO Auto-generated method stub
        return null;
    }

}
