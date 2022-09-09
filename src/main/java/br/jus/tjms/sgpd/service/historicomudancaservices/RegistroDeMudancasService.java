package br.jus.tjms.sgpd.service.historicomudancaservices;

import java.util.Date;

import br.jus.tjms.sgpd.service.Service;

/**
 * @version 1.0
 * @created 11-dez-2015 18:15:52
 */
public interface RegistroDeMudancasService extends Service {
	
	void registrarMudanca(String entidade, String campo, String classe, byte[] valorSerializado, String usuario, Date dataHora);

}