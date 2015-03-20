package es.upm.miw.jeeecp.controllers.ejb;

import java.util.ArrayList;
import java.util.List;

import es.upm.miw.jeeecp.controllers.VotarController;
import es.upm.miw.jeeecp.models.daos.DAOFactory;
import es.upm.miw.jeeecp.models.daos.TemaDAO;
import es.upm.miw.jeeecp.models.daos.jpa.DAOJpaFactory;
import es.upm.miw.jeeecp.models.entities.TemaEntity;
import es.upm.miw.jeeecp.models.entities.VotoEntity;
import es.upm.miw.jeeecp.models.utils.NivelEstudios;

public class VotarEJBController implements VotarController {

    @Override
    public List<TemaEntity> recuperaTemas() {
        DAOFactory.setFactory(new DAOJpaFactory());
        TemaDAO dao = DAOFactory.getFactory().getTemaDAO();
        return dao.findAll();
    }

    @Override
    public TemaEntity buscaTema(Integer id) {
        DAOFactory.setFactory(new DAOJpaFactory());
        TemaDAO dao = DAOFactory.getFactory().getTemaDAO();
        return dao.read(id);
    }

    @Override
    public void votar(TemaEntity tema, VotoEntity voto) {
        DAOFactory.setFactory(new DAOJpaFactory());
        TemaDAO dao = DAOFactory.getFactory().getTemaDAO();
        TemaEntity temaBD = dao.read(tema.getId());
        temaBD.addVoto(voto);
        dao.update(temaBD);
    }

	@Override
	public List<String> recuperaNivelEstudios() {
		List<String> nivelEstudios = new ArrayList<String>();
		for(NivelEstudios nivelEstudiosIt : NivelEstudios.values()){
			nivelEstudios.add(nivelEstudiosIt.toString());
		}
		return nivelEstudios;
	}

}
