package br.jus.tjms.sgpd.service.frequenciaservices;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.jus.tjms.sgpd.entity.FrequenciaApuracaoDiaCargaHoraria;
import br.jus.tjms.sgpd.service.GenericService;

/**
 * @version 1.0
 * @created 11-dez-2015 18:15:33
 */
@Stateless
public class FrequenciaApuracaoDiaCargaHorariaService extends GenericService<FrequenciaApuracaoDiaCargaHoraria, Long> implements Serializable {

	private static final long serialVersionUID = -2195243492501884668L;

	public List<FrequenciaApuracaoDiaCargaHoraria> buscarPorFrequenciaApuracaoDiaId(Long frequenciaApuracaoDiaId) {
		TypedQuery<FrequenciaApuracaoDiaCargaHoraria> query = getEm().createNamedQuery("frequenciaApuracaoDiaCargaHoraria.buscarPorFrequenciaApuracaoDiaId", FrequenciaApuracaoDiaCargaHoraria.class)
				.setParameter("id", frequenciaApuracaoDiaId);
		return query.getResultList();
	}
	
}