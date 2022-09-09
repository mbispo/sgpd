package br.jus.tjms.sgpd.service.estruturacargosservices;
import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.jus.tjms.sgpd.entity.Certificacao;
import br.jus.tjms.sgpd.service.GenericService;

/**
 * @version 1.0
 * @created 11-dez-2015 18:15:36
 */
@Stateless
public class CertificacaoService extends GenericService<Certificacao, Long> implements Serializable {

	private static final long serialVersionUID = 363509518667256460L;

	public List<Certificacao> buscarPorNome(String nome) {
		TypedQuery<Certificacao> query = getEm().
				createNamedQuery("certificacao.buscarPorNome", Certificacao.class)
				.setParameter("nome", nome);
		return query.getResultList();
	}

	public List<Certificacao> buscarPorEntidadeCertificadora(Long entidadeCertificadoraId) {
		TypedQuery<Certificacao> query = getEm().
				createNamedQuery("certificacao.buscarPorEntidadeCertificadora", Certificacao.class)
				.setParameter("entidadeCertificadoraId", entidadeCertificadoraId);
		return query.getResultList();
	}
}