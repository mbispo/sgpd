package br.jus.tjms.sgpd.service.socialservices;
import java.util.Date;

import br.jus.tjms.sgpd.service.Service;

/**
 * @version 1.0
 * @created 11-dez-2015 18:15:45
 */
public interface ComentarioService extends Service {
	
	void registrarComentario(String entidade, String usuario, String comentario, Date dataHora);

}