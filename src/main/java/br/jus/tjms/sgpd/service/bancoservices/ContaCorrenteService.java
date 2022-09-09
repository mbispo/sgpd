package br.jus.tjms.sgpd.service.bancoservices;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.jus.tjms.sgpd.entity.ContaCorrente;
import br.jus.tjms.sgpd.service.GenericService;

/**
 * @version 1.0
 * @created 11-dez-2015 18:15:37
 */
@Stateless
public class ContaCorrenteService extends GenericService<ContaCorrente, Long> implements Serializable {

	private static final long serialVersionUID = 7006178165602913319L;

	public List<ContaCorrente> buscarContasCorrentePorAgencia(Long agenciaId) {
		TypedQuery<ContaCorrente> query = getEm().createNamedQuery("contaCorrente.buscarContasCorrentePorAgencia", ContaCorrente.class)
				.setParameter("agenciaId", agenciaId);
		return query.getResultList();
	}
	
	public List<ContaCorrente> buscarContasCorrentePorNumero(String numero) {
		TypedQuery<ContaCorrente> query = getEm().createNamedQuery("contaCorrente.buscarContasCorrentePorNumero", ContaCorrente.class)
				.setParameter("numero", numero);
		return query.getResultList();
	}
}