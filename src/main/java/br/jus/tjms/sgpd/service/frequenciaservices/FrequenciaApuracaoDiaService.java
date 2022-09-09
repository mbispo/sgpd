package br.jus.tjms.sgpd.service.frequenciaservices;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.jus.tjms.sgpd.entity.FrequenciaApuracaoDia;
import br.jus.tjms.sgpd.service.GenericService;

/**
 * @version 1.0
 * @created 11-dez-2015 18:15:33
 */
@Stateless
public class FrequenciaApuracaoDiaService extends GenericService<FrequenciaApuracaoDia, Long> implements Serializable {

	private static final long serialVersionUID = 8066915267494446796L;

	public List<FrequenciaApuracaoDia> buscarPorFrequenciaApuracaoMesId(Long frequenciaApuracaoMesId) {
		TypedQuery<FrequenciaApuracaoDia> query = getEm().createNamedQuery("frequenciaApuracaoDia.buscarPorFrequenciaApuracaoMesId", FrequenciaApuracaoDia.class)
				.setParameter("id", frequenciaApuracaoMesId);
		return query.getResultList();
	}
	
}