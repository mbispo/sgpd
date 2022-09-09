package br.jus.tjms.sgpd.service.estruturacargosservices;
import java.io.Serializable;

import javax.ejb.Stateless;

import br.jus.tjms.sgpd.entity.Referencia;
import br.jus.tjms.sgpd.service.GenericService;

@Stateless
public class ReferenciaService extends GenericService<Referencia, Long> implements Serializable {

	private static final long serialVersionUID = -3800688508974560314L;
}