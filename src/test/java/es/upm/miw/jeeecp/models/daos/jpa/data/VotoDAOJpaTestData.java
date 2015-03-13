package es.upm.miw.jeeecp.models.daos.jpa.data;

import java.util.Iterator;

import es.upm.miw.jeeecp.models.entities.VotoEntity;
import es.upm.miw.jeeecp.models.entities.utils.ArrayToListTransformer;
import es.upm.miw.jeeecp.models.utils.NivelEstudios;

public class VotoDAOJpaTestData {

	private Integer[] valoracion = { 5, 6, 8, 1, 7, 2, 1 };
	private String[] ip = { "192.168.1.1", "192.168.1.12", "192.168.1.32",
			"192.168.1.23", "192.168.1.2", "192.168.1.14", "192.168.1.51",
			"192.168.1.22" };
	private NivelEstudios[] nivelEstudios = { NivelEstudios.BACHILLERATO,
			NivelEstudios.BACHILLERATO, NivelEstudios.DIPLOMADO,
			NivelEstudios.LICENCIADO, NivelEstudios.BACHILLERATO,
			NivelEstudios.DIPLOMADO, NivelEstudios.LICENCIADO,
			NivelEstudios.BACHILLERATO };

	private Iterator<VotoEntity> votosIterator;

	private VotoEntity voto;

	public VotoDAOJpaTestData() {
		votosIterator = ArrayToListTransformer.transform(valoracion, ip, nivelEstudios);
		this.nextVoto();
	}

	public boolean hasNextVotos() {
		return votosIterator.hasNext();
	}

	public void nextVoto() {
		voto = votosIterator.next();
	}

	public VotoEntity getVoto() {
		return voto;
	}

}
