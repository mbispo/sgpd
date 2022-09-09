package br.jus.tjms.sgpd.service.evolucaofuncionalservices;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;

import br.jus.tjms.sgpd.entity.DesignacaoAdicionalTempoIntegral;
import br.jus.tjms.sgpd.entity.Funcionario;
import br.jus.tjms.sgpd.service.GenericService;

/**
 * @version 1.0
 * @created 11-dez-2015 18:15:33
 */
@Stateless
public class AdicionalTempoIntegralService extends GenericService<DesignacaoAdicionalTempoIntegral,Long> implements Serializable {

	private static final long serialVersionUID = -633144276694224064L;

	public List<DesignacaoAdicionalTempoIntegral> obterDesignacoesAdicionalTempoIntegralVigentesNoPeriodo(
			Funcionario funcionario, Date periodoInicio, Date periodoFim) {
		// TODO Auto-generated method stub
		return null;
	}
	

}