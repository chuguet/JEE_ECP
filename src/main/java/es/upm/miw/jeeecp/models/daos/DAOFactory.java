package es.upm.miw.jeeecp.models.daos;

public abstract class DAOFactory {
    public static DAOFactory factory = null;

    public static void setFactory(DAOFactory factory) {
        DAOFactory.factory = factory;
    }

    public static DAOFactory getFactory() {
        assert (factory != null);
        return factory;
    }

    public abstract TemaDAO getTemaDAO();

    public abstract VotoDAO getVotoDAO();

}
