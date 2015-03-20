package es.upm.miw.jeeecp.controllers;

import java.util.List;

import es.upm.miw.jeeecp.models.entities.TemaEntity;
import es.upm.miw.jeeecp.models.entities.VotoEntity;

public interface VotarController {

    List<TemaEntity> recuperaTemas();

    TemaEntity buscaTema(Integer id);

    void votar(TemaEntity tema, VotoEntity voto);

	List<String> recuperaNivelEstudios();

}
