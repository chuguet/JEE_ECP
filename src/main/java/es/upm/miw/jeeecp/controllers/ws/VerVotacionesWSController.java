package es.upm.miw.jeeecp.controllers.ws;

import es.upm.miw.jeeecp.controllers.VerVotacionesController;
import es.upm.miw.jeeecp.models.entities.TemaEntity;
import es.upm.miw.jeeecp.models.utils.NivelEstudios;
import es.upm.miw.jeeecp.ws.TemaUris;

public class VerVotacionesWSController implements VerVotacionesController {

    @Override
    public Integer recuperaNumeroVotos(TemaEntity tema) {
        return ControllerWs.buildWebServiceManager(TemaUris.PATH_TEMAS, tema.getId().toString(),
                TemaUris.PATH_NUM_VOTES).entity(Integer.class);
    }

    @Override
    public Double recuperaMediaDeVotosPorNivelEstuidos(TemaEntity tema, NivelEstudios nivelEstudios) {
        WsManager wsManager = ControllerWs.buildWebServiceManager(TemaUris.PATH_TEMAS, tema.getId()
                .toString(), TemaUris.PATH_AVG_VOTES);
        wsManager.addParams("studiesLevel", nivelEstudios.toString());
        return wsManager.entity(Double.class);
    }

}
