package br.jus.tjms.sgpd.service.evolucaofuncionalservices;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;

import br.jus.tjms.sgpd.entity.ConcessaoAuxilioTransporte;
import br.jus.tjms.sgpd.entity.Funcionario;
import br.jus.tjms.sgpd.service.GenericService;

/**
 * @version 1.0
 * @created 11-dez-2015 18:15:35
 */
@Stateless
public class AuxilioTransporteService extends GenericService<ConcessaoAuxilioTransporte,Long> implements Serializable {

	private static final long serialVersionUID = -5312657236535397173L;

	public List<ConcessaoAuxilioTransporte> obterConcessoesAuxilioTransporteVigentesNoPeriodo(Funcionario funcionario,
			Date periodoInicio, Date periodoFim) {
		// TODO Auto-generated method stub
		return null;
	}
	

}