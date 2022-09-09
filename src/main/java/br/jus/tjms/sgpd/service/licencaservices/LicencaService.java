package br.jus.tjms.sgpd.service.licencaservices;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;

import br.jus.tjms.sgpd.entity.Funcionario;
import br.jus.tjms.sgpd.entity.Licenca;
import br.jus.tjms.sgpd.service.GenericService;

/**
 * @version 1.0
 * @created 11-dez-2015 18:15:41
 */
@Stateless
public class LicencaService extends GenericService<Licenca, Long> implements Serializable {
	
	private static final long serialVersionUID = 6175904090526196329L;

	public List<Licenca> obterLicencasNoPeriodo(Funcionario funcionario, Date periodoInicio, Date periodoFim) {
		// TODO Auto-generated method stub
		return null;
	}


}