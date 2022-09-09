package br.jus.tjms.sgpd.service.workflowservices;
import java.util.Date;

import br.jus.tjms.sgpd.service.Service;

/**
 * @version 1.0
 * @created 11-dez-2015 18:15:52
 */
public interface TransicaoEstadoService extends Service {
	
	
	void registrarTransicao(String entidade, String estado, String usuario, Date dataHora, Long tempo);

}