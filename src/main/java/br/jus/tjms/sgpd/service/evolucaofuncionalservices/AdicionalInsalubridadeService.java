package br.jus.tjms.sgpd.service.evolucaofuncionalservices;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;

import br.jus.tjms.sgpd.entity.ConcessaoAdicionalInsalubridade;
import br.jus.tjms.sgpd.entity.Funcionario;
import br.jus.tjms.sgpd.service.GenericService;

/**
 * @version 1.0
 * @created 11-dez-2015 18:15:33
 */
@Stateless
public class AdicionalInsalubridadeService extends GenericService<ConcessaoAdicionalInsalubridade, Long> implements Serializable {
	
	private static final long serialVersionUID = 5322175293948222931L;

	public List<ConcessaoAdicionalInsalubridade> obterConcessoesAdicionalInsalubridadeVigentesNoPeriodo(
			Funcionario funcionario, Date periodoInicio, Date periodoFim) {
		// TODO Auto-generated method stub
		return null;
	}
	

}