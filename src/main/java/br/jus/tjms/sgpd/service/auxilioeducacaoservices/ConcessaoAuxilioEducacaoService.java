package br.jus.tjms.sgpd.service.auxilioeducacaoservices;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;

import br.jus.tjms.sgpd.entity.ConcessaoAuxilioEducacaoInfantil;
import br.jus.tjms.sgpd.entity.Funcionario;
import br.jus.tjms.sgpd.service.GenericService;

/**
 * @version 1.0
 * @created 11-dez-2015 18:15:36
 */
@Stateless
public class ConcessaoAuxilioEducacaoService extends GenericService<ConcessaoAuxilioEducacaoInfantil, Long> implements Serializable {
	
	private static final long serialVersionUID = 3463274776406481201L;

	public List<ConcessaoAuxilioEducacaoInfantil> obterConcessoesAuxilioEducacaoInfantilVigentesNoPeriodo(
			Funcionario funcionario, Date periodoInicio, Date periodoFim) {
		// TODO Auto-generated method stub
		return null;
	}
	

}