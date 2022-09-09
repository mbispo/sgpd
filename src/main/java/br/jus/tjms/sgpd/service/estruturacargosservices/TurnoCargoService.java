package br.jus.tjms.sgpd.service.estruturacargosservices;
import java.io.Serializable;

import javax.ejb.Stateless;

import br.jus.tjms.sgpd.entity.TurnoCargo;
import br.jus.tjms.sgpd.service.GenericService;

@Stateless
public class TurnoCargoService extends GenericService<TurnoCargo, Long> implements Serializable {

	private static final long serialVersionUID = 5926166116636441298L;

}