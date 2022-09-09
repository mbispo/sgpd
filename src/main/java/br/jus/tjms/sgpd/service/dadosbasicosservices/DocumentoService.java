package br.jus.tjms.sgpd.service.dadosbasicosservices;
import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.jus.tjms.sgpd.entity.Documento;
import br.jus.tjms.sgpd.service.GenericService;

/**
 * @version 1.0
 * @created 11-dez-2015 18:15:38
 */
@Stateless
public class DocumentoService extends GenericService<Documento, Long> implements Serializable {

	private static final long serialVersionUID = -8027945389292003586L;
	
	public List<Documento> buscarDocumentosPorPessoa(Long idPessoa) {
		TypedQuery<Documento> query = getEm()
				.createNamedQuery("documento.buscarDocumentosPorPessoa", Documento.class)
				.setParameter("idPessoa", idPessoa);
		return query.getResultList();
	}
}