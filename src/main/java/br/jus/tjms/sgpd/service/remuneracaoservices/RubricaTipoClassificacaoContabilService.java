package br.jus.tjms.sgpd.service.remuneracaoservices;
import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.jus.tjms.sgpd.entity.RubricaTipoClassificacaoContabil;
import br.jus.tjms.sgpd.enumerators.TipoClassificacaoContabil;
import br.jus.tjms.sgpd.service.GenericService;

@Stateless
public class RubricaTipoClassificacaoContabilService extends GenericService<RubricaTipoClassificacaoContabil, Long> implements Serializable {
	
	private static final long serialVersionUID = 1750027281086603018L;

	public List<TipoClassificacaoContabil> buscarTipoClassificacaoContabilPorRubrica(Long rubricaId) {
		TypedQuery<TipoClassificacaoContabil> query = getEm()
				.createNamedQuery("rubricaTipoClassificacaoContabil.buscarTipoClassificacaoContabilPorRubrica", TipoClassificacaoContabil.class)
				.setParameter("rubricaId", rubricaId);
		return query.getResultList();
	}

}