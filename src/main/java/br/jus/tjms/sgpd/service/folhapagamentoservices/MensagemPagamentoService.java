package br.jus.tjms.sgpd.service.folhapagamentoservices;
import java.io.Serializable;

import javax.ejb.Stateless;

import br.jus.tjms.sgpd.entity.MensagemPagamento;
import br.jus.tjms.sgpd.service.GenericService;

/**
 * @version 1.0
 * @created 11-dez-2015 18:15:42
 */
@Stateless
public class MensagemPagamentoService extends GenericService<MensagemPagamento, Long> implements Serializable {

	private static final long serialVersionUID = -8098053272061436192L;

}