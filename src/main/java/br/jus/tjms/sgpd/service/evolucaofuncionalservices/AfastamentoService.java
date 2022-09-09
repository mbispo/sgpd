package br.jus.tjms.sgpd.service.evolucaofuncionalservices;

import java.io.Serializable;

import javax.ejb.Stateless;

import br.jus.tjms.sgpd.entity.Afastamento;
import br.jus.tjms.sgpd.service.GenericService;

/**
 * @version 1.0
 * @created 11-dez-2015 18:15:33
 */
@Stateless
public class AfastamentoService extends GenericService<Afastamento, Long> implements Serializable {

	private static final long serialVersionUID = 5377357554941194603L;

}