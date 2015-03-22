package es.upm.miw.jeeecp.controllers.ws;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.GenericType;

import es.upm.miw.jeeecp.controllers.VotarController;
import es.upm.miw.jeeecp.models.entities.TemaEntity;
import es.upm.miw.jeeecp.models.entities.VotoEntity;
import es.upm.miw.jeeecp.models.utils.ListStringWrapper;
import es.upm.miw.jeeecp.ws.TemaUris;
import es.upm.miw.jeeecp.ws.VotoUris;

public class VotarWSController implements VotarController {

    @Override
    public List<TemaEntity> recuperaTemas() {
        GenericType<List<TemaEntity>> genericType = new GenericType<List<TemaEntity>>() {
        };
        return ControllerWs.buildWebServiceManager(TemaUris.PATH_TEMAS).entities(genericType);
    }

    @Override
    public TemaEntity buscaTema(Integer id) {
        return ControllerWs.buildWebServiceManager(TemaUris.PATH_TEMAS, id.toString()).entity(
                TemaEntity.class);
    }

    @Override
    public void votar(TemaEntity tema, VotoEntity voto) {
        tema.addVoto(voto);
        ControllerWs.buildWebServiceManager(TemaUris.PATH_TEMAS).update(tema);

    }

    @Override
    public List<String> recuperaNivelEstudios() {
        ListStringWrapper listStringWrapper = ControllerWs.buildWebServiceManager(
                VotoUris.PATH_VOTOS, VotoUris.PATH_STUDIES_LEVEL).entity(ListStringWrapper.class);
        List<String> list = listStringWrapper.getListString();
        if (list == null) {
            list = new ArrayList<String>();
        }
        return list;
    }

}
