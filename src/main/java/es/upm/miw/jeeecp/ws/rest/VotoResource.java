package es.upm.miw.jeeecp.ws.rest;

import java.net.URI;
import java.util.ArrayList;
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
import es.upm.miw.jeeecp.models.entities.VotoEntity;
import es.upm.miw.jeeecp.models.utils.ListStringWrapper;
import es.upm.miw.jeeecp.models.utils.NivelEstudios;
import es.upm.miw.jeeecp.ws.VotoUris;

@Path(VotoUris.PATH_VOTOS)
public class VotoResource {

    private final static Logger LOG = LogManager.getLogger(VotoResource.class);

    @POST
    @Consumes(MediaType.APPLICATION_XML)
    public Response create(VotoEntity voto) {
        DAOFactory.setFactory(new DAOJpaFactory());
        Response result;
        DAOFactory.getFactory().getVotoDAO().create(voto);
        result = Response.created(URI.create(VotoUris.PATH_VOTOS + "/" + voto.getId()))
                .entity(String.valueOf(voto.getId())).build();
        LOG.debug("POST: " + VotoUris.PATH_VOTOS + ": " + voto);
        return result;
    }

    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public Response update(VotoEntity voto) {
        DAOFactory.setFactory(new DAOJpaFactory());
        Response result;
        DAOFactory.getFactory().getVotoDAO().update(voto);
        result = Response.created(URI.create(VotoUris.PATH_VOTOS + "/" + voto.getId()))
                .entity(String.valueOf(voto.getId())).build();
        LOG.debug("PUT: " + VotoUris.PATH_VOTOS + ": " + voto);
        return result;
    }

    @GET
    @Path(VotoUris.PATH_ID_PARAM)
    @Produces(MediaType.APPLICATION_XML)
    public VotoEntity get(@PathParam("id") Integer id) {
        DAOFactory.setFactory(new DAOJpaFactory());
        VotoEntity voto = DAOFactory.getFactory().getVotoDAO().read(id);
        if (voto == null) {
            throw new NotFoundException();
        } else {
            LOG.debug("GET: " + VotoUris.PATH_VOTOS + "/" + id + ": " + voto);
            return voto;
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<VotoEntity> getAll() {
        DAOFactory.setFactory(new DAOJpaFactory());
        List<VotoEntity> votos = DAOFactory.getFactory().getVotoDAO().findAll();
        LOG.debug("GET: " + VotoUris.PATH_VOTOS + ": " + votos);
        return votos;
    }

    @GET
    @Path(VotoUris.PATH_STUDIES_LEVEL)
    @Produces(MediaType.APPLICATION_XML)
    public ListStringWrapper getStudiesLevel() {
        NivelEstudios[] nivelEstudios = NivelEstudios.values();
        List<String> nivelEstudiosList = new ArrayList<String>();
        for (NivelEstudios nivelEstudiosIt : nivelEstudios) {
            nivelEstudiosList.add(nivelEstudiosIt.toString());
        }
        LOG.debug("GET: " + VotoUris.PATH_VOTOS + "/" + VotoUris.PATH_STUDIES_LEVEL + ": "
                + nivelEstudiosList);
        return new ListStringWrapper(nivelEstudiosList);
    }

}
