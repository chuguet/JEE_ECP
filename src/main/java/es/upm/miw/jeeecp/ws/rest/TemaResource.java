package es.upm.miw.jeeecp.ws.rest;

import java.net.URI;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
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

}
