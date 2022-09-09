package br.jus.tjms.sgpd.service.frequenciaservices;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.jus.tjms.sgpd.entity.FrequenciaApuracaoDiaOcorrencia;
import br.jus.tjms.sgpd.service.GenericService;

/**
 * @version 1.0
 * @created 11-dez-2015 18:15:33
 */
@Stateless
public class FrequenciaApuracaoDiaOcorrenciaService extends GenericService<FrequenciaApuracaoDiaOcorrencia, Long> implements Serializable {

	private static final long serialVersionUID = 7715655627980113024L;

	public List<FrequenciaApuracaoDiaOcorrencia> buscarPorFrequenciaApuracaoDiaId(Long frequenciaApuracaoDiaId) {
		TypedQuery<FrequenciaApuracaoDiaOcorrencia> query = getEm().createNamedQuery("frequenciaApuracaoDiaOcorrencia.buscarPorFrequenciaApuracaoDiaId", FrequenciaApuracaoDiaOcorrencia.class)
				.setParameter("id", frequenciaApuracaoDiaId);
		return query.getResultList();
	}
	
}