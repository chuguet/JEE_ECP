package es.upm.miw.jeeecp.models.entities.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import es.upm.miw.jeeecp.models.entities.TemaEntity;
import es.upm.miw.jeeecp.models.entities.VotoEntity;
import es.upm.miw.jeeecp.models.utils.NivelEstudios;

public class ArrayToListTransformer {

	public static Iterator<TemaEntity> transform(Integer[] id, String[] nombre,
			String[] pregunta, String[][][] votos) {
		VotoEntity votoEntity;
		List<TemaEntity> temasEntities = new ArrayList<TemaEntity>();
		List<VotoEntity> votosEntities;
		for (int i = 0; i < id.length; i++) {
			if (votos[i] != null) {
				votosEntities = new ArrayList<VotoEntity>();
				for (int j = 0; j < votos[i].length; j++) {
					votoEntity = new VotoEntity(
							Integer.parseInt(votos[i][j][0]), votos[i][j][1],
							NivelEstudios.valueOf(votos[i][j][2]));
					votosEntities.add(votoEntity);
				}
			} else {
				votosEntities = null;
			}
			temasEntities.add(new TemaEntity(id[i], nombre[i], pregunta[i],
					votosEntities));
		}
		return temasEntities.iterator();
	}

	public static Iterator<VotoEntity> transform(Integer[] valoracion,
			String[] ip, NivelEstudios[] nivelEstudios) {
		List<VotoEntity> votosEntities = new ArrayList<VotoEntity>();
		for (int i = 0; i < valoracion.length; i++) {
			votosEntities.add(new VotoEntity(valoracion[i], ip[i], nivelEstudios[i]));
		}
		return votosEntities.iterator();
	}
}
