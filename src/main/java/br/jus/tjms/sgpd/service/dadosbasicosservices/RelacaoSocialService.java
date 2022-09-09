package br.jus.tjms.sgpd.service.dadosbasicosservices;
import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.jus.tjms.sgpd.entity.RelacaoSocial;
import br.jus.tjms.sgpd.service.GenericService;

/**
 * @version 1.0
 * @created 11-dez-2015 18:15:45
 */
@Stateless
public class RelacaoSocialService extends GenericService<RelacaoSocial, Long> implements Serializable {

	private static final long serialVersionUID = 354338450761641586L;
	
	public List<RelacaoSocial> buscarRelacoesSociaisPorPessoa(Long idPessoa) {
		TypedQuery<RelacaoSocial> query = getEm()
				.createNamedQuery("relacaoSocial.buscarRelacoesSociaisPorPessoa", RelacaoSocial.class)
				.setParameter("idPessoa", idPessoa);
		return query.getResultList();
	}

}