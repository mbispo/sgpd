package br.jus.tjms.sgpd.service.adicionalqualificacaoservices;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;

import br.jus.tjms.sgpd.entity.ConcessaoAdicionalQualificacao;
import br.jus.tjms.sgpd.entity.Funcionario;
import br.jus.tjms.sgpd.service.GenericService;

/**
 * @version 1.0
 * @created 11-dez-2015 18:15:36
 */
@Stateless
public class ConcessaoAdicionalQualificacaoService extends GenericService<ConcessaoAdicionalQualificacao, Long> implements Serializable {
	
	private static final long serialVersionUID = -8655220666621984978L;

	public List<ConcessaoAdicionalQualificacao> obterConcessoesAdicionalQualificacaoVigentesNoPeriodo(
			Funcionario funcionario, Date periodoInicio, Date periodoFim) {
		// TODO Auto-generated method stub
		return null;
	}
	

}