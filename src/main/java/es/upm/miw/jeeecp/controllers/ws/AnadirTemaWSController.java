package es.upm.miw.jeeecp.controllers.ws;

import es.upm.miw.jeeecp.controllers.AnadirTemaController;
import es.upm.miw.jeeecp.models.entities.TemaEntity;
import es.upm.miw.jeeecp.ws.TemaUris;

public class AnadirTemaWSController implements AnadirTemaController {

    @Override
    public void anadirTema(TemaEntity temaEntity) {
        ControllerWs.buildWebServiceManager(TemaUris.PATH_TEMAS).create(temaEntity);
    }

    @Override
    public Boolean existeTema(TemaEntity temaEntity) {
        return ControllerWs.buildWebServiceManager(TemaUris.PATH_TEMAS,
                temaEntity.getId().toString(), TemaUris.PATH_CREATED_TEMA).entityBoolean();
    }

}
