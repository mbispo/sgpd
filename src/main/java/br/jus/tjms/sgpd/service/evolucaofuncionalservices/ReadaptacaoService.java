package br.jus.tjms.sgpd.service.evolucaofuncionalservices;
import java.io.Serializable;

import javax.ejb.Stateless;

import br.jus.tjms.sgpd.entity.Readaptacao;
import br.jus.tjms.sgpd.service.GenericService;

/**
 * @version 1.0
 * @created 11-dez-2015 18:15:44
 */
@Stateless
public class ReadaptacaoService extends GenericService<Readaptacao, Long> implements Serializable {

	private static final long serialVersionUID = 3803201484563280203L;

}