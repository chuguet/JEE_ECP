package es.upm.miw.jeeecp.controllers;

import es.upm.miw.jeeecp.models.entities.TemaEntity;
import es.upm.miw.jeeecp.models.utils.NivelEstudios;

public interface VerVotacionesController {

    Integer recuperaNumeroVotos(TemaEntity tema);

    Double recuperaMediaDeVotosPorNivelEstuidos(TemaEntity tema, NivelEstudios nivelEstudios);

}
