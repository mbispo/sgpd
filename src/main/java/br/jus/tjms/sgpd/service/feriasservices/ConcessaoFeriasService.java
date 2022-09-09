package br.jus.tjms.sgpd.service.feriasservices;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;

import br.jus.tjms.sgpd.entity.ConcessaoFerias;
import br.jus.tjms.sgpd.entity.Funcionario;
import br.jus.tjms.sgpd.service.GenericService;

/**
 * @version 1.0
 * @created 11-dez-2015 18:15:36
 */
@Stateless
public class ConcessaoFeriasService extends GenericService<ConcessaoFerias, Long> implements Serializable {

	private static final long serialVersionUID = -2085491888394552226L;

	public List<ConcessaoFerias> obterConcessoesFeriasNoPeriodo(Funcionario funcionario, Date periodoInicio,
			Date periodoFim) {
		// TODO Auto-generated method stub
		return null;
	}
	

}