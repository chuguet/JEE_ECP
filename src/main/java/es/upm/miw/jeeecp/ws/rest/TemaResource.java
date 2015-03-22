package es.upm.miw.jeeecp.ws.rest;

import java.net.URI;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import es.upm.miw.jeeecp.models.daos.DAOFactory;
import es.upm.miw.jeeecp.models.daos.jpa.DAOJpaFactory;
import es.upm.miw.jeeecp.models.entities.TemaEntity;
import es.upm.miw.jeeecp.ws.TemaUris;

@Path(TemaUris.PATH_TEMAS)
public class TemaResource {

    private final static Logger LOG = LogManager.getLogger(TemaResource.class);

    private static final String CODE = "666";

    @POST
    @Consumes(MediaType.APPLICATION_XML)
    public Response create(TemaEntity tema) {
        DAOFactory.setFactory(new DAOJpaFactory());
        Response result;
        DAOFactory.getFactory().getTemaDAO().create(tema);
        result = Response.created(URI.create(TemaUris.PATH_TEMAS + "/" + tema.getId()))
                .entity(String.valueOf(tema.getId())).build();
        LOG.debug("POST: " + TemaUris.PATH_TEMAS + ": " + tema);
        return result;
    }

    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public Response update(TemaEntity tema) {
        DAOFactory.setFactory(new DAOJpaFactory());
        Response result;
        DAOFactory.getFactory().getTemaDAO().update(tema);
        result = Response.created(URI.create(TemaUris.PATH_TEMAS + "/" + tema.getId()))
                .entity(String.valueOf(tema.getId())).build();
        LOG.debug("PUT: " + TemaUris.PATH_TEMAS + ": " + tema);
        return result;
    }

    @DELETE
    @Path(TemaUris.PATH_ID_PARAM)
    public void delete(@PathParam("id") Integer id) {
        DAOFactory.setFactory(new DAOJpaFactory());
        DAOFactory.getFactory().getTemaDAO().deleteById(id);
        LOG.debug("DELETE: " + TemaUris.PATH_TEMAS + ": " + id);
    }

    @GET
    @Path(TemaUris.PATH_ID_PARAM)
    @Produces(MediaType.APPLICATION_XML)
    public TemaEntity get(@PathParam("id") Integer id) {
        DAOFactory.setFactory(new DAOJpaFactory());
        TemaEntity tema = DAOFactory.getFactory().getTemaDAO().read(id);
        if (tema == null) {
            throw new NotFoundException();
        } else {
            LOG.debug("GET: " + TemaUris.PATH_TEMAS + "/" + id + ": " + tema);
            return tema;
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<TemaEntity> getAll() {
        DAOFactory.setFactory(new DAOJpaFactory());
        List<TemaEntity> temas = DAOFactory.getFactory().getTemaDAO().findAll();
        LOG.debug("GET: " + TemaUris.PATH_TEMAS + ": " + temas);
        return temas;
    }

    @GET
    @Path(TemaUris.PATH_ID_PARAM + TemaUris.PATH_CREATED_TEMA)
    public String createdTema(@PathParam("id") Integer id) {
        Boolean result;
        DAOFactory.setFactory(new DAOJpaFactory());
        TemaEntity tema = DAOFactory.getFactory().getTemaDAO().read(id);
        result = tema != null;
        LOG.debug("GET: " + TemaUris.PATH_TEMAS + "/" + id + "/" + TemaUris.PATH_CREATED_TEMA
                + ": " + result);
        return Boolean.toString(result);
    }

    @GET
    @Path(TemaUris.PATH_AUTHORIZE)
    public String authorize(@QueryParam("code") String code) {
        LOG.debug("GET: " + TemaUris.PATH_TEMAS + "/" + TemaUris.PATH_AUTHORIZE + ": " + code);
        return Boolean.toString(code.equals(CODE));
    }

}
