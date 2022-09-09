package br.jus.tjms.sgpd.service.estruturacargosservices;
import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.jus.tjms.sgpd.entity.EntidadeCertificadora;
import br.jus.tjms.sgpd.service.GenericService;

/**
 * @version 1.0
 * @created 11-dez-2015 18:15:36
 */
@Stateless
public class EntidadeCertificadoraService extends GenericService<EntidadeCertificadora, Long> implements Serializable {

	private static final long serialVersionUID = -852606558990929090L;

	public List<EntidadeCertificadora> buscarPorNome(String nome) {
		TypedQuery<EntidadeCertificadora> query = getEm()
				.createNamedQuery("entidadeCertificadora.buscarEntidadesCertificadorasPorNome", EntidadeCertificadora.class)
				.setParameter("nome", nome);
		return query.getResultList();
	}


}