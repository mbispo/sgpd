package br.jus.tjms.sgpd.service.estruturacargosservices;
import java.io.Serializable;

import javax.ejb.Stateless;

import br.jus.tjms.sgpd.entity.GrupoCargo;
import br.jus.tjms.sgpd.service.GenericService;

@Stateless
public class GrupoCargoService extends GenericService<GrupoCargo, Long> implements Serializable {

	private static final long serialVersionUID = -3800688508974560314L;
}