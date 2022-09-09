package br.jus.tjms.sgpd.service.evolucaofuncionalservices;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;

import br.jus.tjms.sgpd.entity.ConcessaoGratificacaoEncargosEspeciais;
import br.jus.tjms.sgpd.entity.Funcionario;
import br.jus.tjms.sgpd.service.GenericService;

/**
 * @version 1.0
 * @created 11-dez-2015 18:15:35
 */
@Stateless
public class GratificacaoEncargosEspeciaisService extends GenericService<ConcessaoGratificacaoEncargosEspeciais,Long> implements Serializable {
	
	private static final long serialVersionUID = 350454680329520421L;

	public List<ConcessaoGratificacaoEncargosEspeciais> obterConcessoesGratificacaoEncargosEspeciaisVigentesNoPeriodo(
			Funcionario funcionario, Date periodoInicio, Date periodoFim) {
		// TODO Auto-generated method stub
		return null;
	}

	public void pagarGratificacao(ConcessaoGratificacaoEncargosEspeciais g, Date dataPagamento, Double valorPago) {
		// TODO Auto-generated method stub

	}
	

}