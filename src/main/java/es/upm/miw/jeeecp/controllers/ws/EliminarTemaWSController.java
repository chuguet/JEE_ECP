package es.upm.miw.jeeecp.controllers.ws;

import es.upm.miw.jeeecp.controllers.EliminarTemaController;
import es.upm.miw.jeeecp.models.entities.TemaEntity;
import es.upm.miw.jeeecp.ws.TemaUris;

public class EliminarTemaWSController implements EliminarTemaController {

    @Override
    public void eliminarTema(TemaEntity temaEntity) {
        ControllerWs.buildWebServiceManager(TemaUris.PATH_TEMAS, temaEntity.getId().toString())
                .delete();
    }

    @Override
    public Boolean autorizar(String autorizacion) {
        WsManager webServicesManager = ControllerWs.buildWebServiceManager(TemaUris.PATH_TEMAS,
                TemaUris.PATH_AUTHORIZE);
        webServicesManager.addParams("code", autorizacion);
        return webServicesManager.entityBoolean();
    }

}
