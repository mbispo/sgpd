package br.jus.tjms.sgpd.service.estruturacargosservices;

import java.io.Serializable;

import javax.ejb.Stateless;

import br.jus.tjms.sgpd.entity.EstruturaCargo;
import br.jus.tjms.sgpd.service.GenericService;

@Stateless
public class EstruturaCargoService extends GenericService<EstruturaCargo, Long> implements Serializable {

	private static final long serialVersionUID = -845635443493794859L;

}