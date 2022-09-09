package br.jus.tjms.sgpd.service.evolucaofuncionalservices;
import java.io.Serializable;

import javax.ejb.Stateless;

import br.jus.tjms.sgpd.entity.RequerimentoAuxilioFuneral;
import br.jus.tjms.sgpd.service.GenericService;

/**
 * @version 1.0
 * @created 11-dez-2015 18:15:35
 */
@Stateless
public class AuxilioFuneralService extends GenericService<RequerimentoAuxilioFuneral, Long> implements Serializable {

	private static final long serialVersionUID = -4568027285067797794L;

}