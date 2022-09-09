package br.jus.tjms.sgpd.service.estruturacargosservices;
import java.io.Serializable;

import javax.ejb.Stateless;

import br.jus.tjms.sgpd.entity.PlanoCargo;
import br.jus.tjms.sgpd.service.GenericService;

@Stateless
public class PlanoCargoService extends GenericService<PlanoCargo, Long> implements Serializable {

	private static final long serialVersionUID = -2242254903991708676L;

}