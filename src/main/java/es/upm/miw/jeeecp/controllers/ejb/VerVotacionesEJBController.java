package es.upm.miw.jeeecp.controllers.ejb;

import java.util.List;

import es.upm.miw.jeeecp.controllers.VerVotacionesController;
import es.upm.miw.jeeecp.models.daos.DAOFactory;
import es.upm.miw.jeeecp.models.daos.TemaDAO;
import es.upm.miw.jeeecp.models.daos.jpa.DAOJpaFactory;
import es.upm.miw.jeeecp.models.entities.TemaEntity;
import es.upm.miw.jeeecp.models.entities.VotoEntity;
import es.upm.miw.jeeecp.models.utils.NivelEstudios;

public class VerVotacionesEJBController implements VerVotacionesController {

    @Override
    public Integer recuperaNumeroVotos(TemaEntity tema) {
        DAOFactory.setFactory(new DAOJpaFactory());
        TemaDAO dao = DAOFactory.getFactory().getTemaDAO();
        return dao.retrieveVotosFromTema(tema.getId()).size();
    }

    @Override
    public Double recuperaMediaDeVotosPorNivelEstuidos(TemaEntity tema, NivelEstudios nivelEstudios) {
        Double resultado = 0d;
        DAOFactory.setFactory(new DAOJpaFactory());
        TemaDAO dao = DAOFactory.getFactory().getTemaDAO();
        List<VotoEntity> votos = dao.retrieveVotosFromTema(tema.getId());
        Double total = 0d;
        Double suma = 0d;
        for (VotoEntity voto : votos) {
            if (voto.getNivelEstudios().equals(nivelEstudios)) {
                total++;
                suma += voto.getValoracion();
            }
        }
        if (total != 0) {
            resultado = suma / total;
        }
        return resultado;
    }

}
