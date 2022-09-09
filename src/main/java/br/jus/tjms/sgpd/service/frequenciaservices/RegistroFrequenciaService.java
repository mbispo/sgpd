package br.jus.tjms.sgpd.service.frequenciaservices;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.jus.tjms.sgpd.entity.RegistroFrequencia;
import br.jus.tjms.sgpd.service.GenericService;

/**
 * @version 1.0
 * @created 11-dez-2015 18:15:44
 */
@Stateless
public class RegistroFrequenciaService extends GenericService<RegistroFrequencia, Long> implements Serializable {

	private static final long serialVersionUID = -3858842554180961055L;

	public List<RegistroFrequencia> buscarPorFuncionario(Long funcionarioId) {
		TypedQuery<RegistroFrequencia> q = getEm().createNamedQuery("registroFrequencia.buscarPorFuncionarioId", RegistroFrequencia.class);
		q.setParameter("id", funcionarioId);
		return q.getResultList();
	}

}