package es.upm.miw.jeeecp.controllers;

import es.upm.miw.jeeecp.models.entities.TemaEntity;

public interface EliminarTemaController {

    void eliminarTema(TemaEntity temaEntity);

	Boolean autorizar(String autorizacion);

}
