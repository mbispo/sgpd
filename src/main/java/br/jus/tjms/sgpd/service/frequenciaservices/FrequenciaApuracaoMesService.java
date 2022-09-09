package br.jus.tjms.sgpd.service.frequenciaservices;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.jus.tjms.sgpd.entity.FrequenciaApuracaoMes;
import br.jus.tjms.sgpd.service.GenericService;

/**
 * @version 1.0
 * @created 11-dez-2015 18:15:33
 */
@Stateless
public class FrequenciaApuracaoMesService extends GenericService<FrequenciaApuracaoMes, Long> implements Serializable {

	private static final long serialVersionUID = -458768498947584630L;
	

	public List<FrequenciaApuracaoMes> buscarPorFuncionario(Long funcionarioId) {
		TypedQuery<FrequenciaApuracaoMes> query = getEm().createNamedQuery("frequenciaApuracaoMes.buscarPorFuncionarioId", FrequenciaApuracaoMes.class)
				.setParameter("id", funcionarioId);
		return query.getResultList();
	}
	
	public List<FrequenciaApuracaoMes> buscarPorFuncionarioEAno(Long funcionarioId, Integer ano) {
		TypedQuery<FrequenciaApuracaoMes> query = getEm().createNamedQuery("frequenciaApuracaoMes.buscarPorFuncionarioIdAno", FrequenciaApuracaoMes.class)
				.setParameter("id", funcionarioId)
				.setParameter("ano", ano);
		return query.getResultList();
	}

	public List<FrequenciaApuracaoMes> buscarPorFuncionarioAnoMes(Long funcionarioId, Integer ano, Integer mes) {
		TypedQuery<FrequenciaApuracaoMes> query = getEm().createNamedQuery("frequenciaApuracaoMes.buscarPorFuncionarioIdAnoMes", FrequenciaApuracaoMes.class)
				.setParameter("id", funcionarioId)
				.setParameter("ano", ano)
				.setParameter("mes", mes);
		return query.getResultList();	}
	
	
}