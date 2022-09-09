package br.jus.tjms.sgpd.service.planosaudeservices;
import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.jus.tjms.sgpd.entity.OperadoraPlanoSaude;
import br.jus.tjms.sgpd.entity.PlanoSaude;
import br.jus.tjms.sgpd.entity.RubricaPlanoSaude;
import br.jus.tjms.sgpd.service.GenericService;
import br.jus.tjms.sgpd.service.rest.v1.to.PlanoSaudeTO;

/**
 * @version 1.0
 * @created 11-dez-2015 18:15:43
 */
@Stateless
public class PlanoSaudeService extends GenericService<PlanoSaude, Long> implements Serializable {

	private static final long serialVersionUID = -214975911646547132L;
	
	@EJB
	OperadoraPlanoSaudeService operadoraPlanoSaudeService;

	public List<RubricaPlanoSaude> listarRubricasPlanoDeSaude(Long operadoraId, Long id) {
		PlanoSaude plano = buscarPorId(id);
		return plano.getRubricas();
	}

	public PlanoSaude criarPlanoSaude(Long operadoraId, PlanoSaudeTO planoSaudeTO) {
		OperadoraPlanoSaude operadora = operadoraPlanoSaudeService.buscarPorId(operadoraId);
		PlanoSaude plano = new PlanoSaude(planoSaudeTO, operadora);
		return salvar(plano);
	}

	public PlanoSaude alterarPlanoSaude(Long operadoraId, PlanoSaudeTO planoSaudeTO) {
		OperadoraPlanoSaude operadora = operadoraPlanoSaudeService.buscarPorId(operadoraId);
		PlanoSaude plano = new PlanoSaude(planoSaudeTO, operadora);
		return salvar(plano);
	}

}