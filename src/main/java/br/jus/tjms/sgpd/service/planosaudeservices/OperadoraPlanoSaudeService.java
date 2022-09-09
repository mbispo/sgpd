package br.jus.tjms.sgpd.service.planosaudeservices;
import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.jus.tjms.sgpd.entity.OperadoraPlanoSaude;
import br.jus.tjms.sgpd.entity.PlanoSaude;
import br.jus.tjms.sgpd.service.GenericService;

/**
 * @version 1.0
 * @created 11-dez-2015 18:15:42
 */
@Stateless
public class OperadoraPlanoSaudeService extends GenericService<OperadoraPlanoSaude, Long> implements Serializable {

	private static final long serialVersionUID = -1540831347364566458L;

	public List<PlanoSaude> listarPlanosDaOperadora(Long operadoraId) {		
		return buscarPorId(operadoraId).getPlanos();
	}

	public List<PlanoSaude> buscarPlanosPorDescricao(String descricao) {
		TypedQuery<PlanoSaude> query = getEm().createNamedQuery("planoSaude.buscarPorDescricao", PlanoSaude.class)
				.setParameter("descricao", "%"+descricao+"%");
		return query.getResultList();

	}

}