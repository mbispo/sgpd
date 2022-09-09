package br.jus.tjms.sgpd.service.folhapagamentoservices;
import java.io.Serializable;

import javax.ejb.Stateless;

import br.jus.tjms.sgpd.entity.GrupoFormula;
import br.jus.tjms.sgpd.service.GenericService;

@Stateless
public class GrupoFormulaService extends GenericService<GrupoFormula, Long> implements Serializable {

	private static final long serialVersionUID = -2203696680577286275L;
}