package br.jus.tjms.sgpd.service.horaextraservices;
import java.io.Serializable;

import javax.ejb.Stateless;

import br.jus.tjms.sgpd.entity.AutorizacaoHoraExtra;
import br.jus.tjms.sgpd.service.GenericService;

/**
 * @version 1.0
 * @created 11-dez-2015 18:15:35
 */
@Stateless
public class AutorizacaoHoraExtraService extends GenericService<AutorizacaoHoraExtra, Long> implements Serializable {

	private static final long serialVersionUID = -1909212653504224360L;

}