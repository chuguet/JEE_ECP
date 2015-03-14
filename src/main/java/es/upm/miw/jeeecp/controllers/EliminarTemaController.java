package es.upm.miw.jeeecp.controllers;

import java.util.List;

import es.upm.miw.jeeecp.models.entities.TemaEntity;

public interface EliminarTemaController {

    void eliminarTema(TemaEntity temaEntity);

    List<TemaEntity> recuperaTemas();

}
