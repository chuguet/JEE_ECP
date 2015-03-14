package es.upm.miw.jeeecp.controllers;

import java.util.List;

import es.upm.miw.jeeecp.models.entities.TemaEntity;

public interface VotarController {

    List<TemaEntity> recuperaTemas();

}
