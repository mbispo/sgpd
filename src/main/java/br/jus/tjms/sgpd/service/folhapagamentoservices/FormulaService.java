package br.jus.tjms.sgpd.service.folhapagamentoservices;
import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.jus.tjms.sgpd.entity.Formula;
import br.jus.tjms.sgpd.enumerators.TipoFormula;
import br.jus.tjms.sgpd.service.GenericService;

/**
 * @version 1.0
 * @created 11-dez-2015 18:15:40
 */
@Stateless
public class FormulaService extends GenericService<Formula, Long> implements Serializable {
	
	private static final long serialVersionUID = -6787147616770145654L;

	public Long criarFormula(String nome, String expressao, Long idFormulaBase, Long idGrupoFormula, TipoFormula tipoFormula) {
		//TODO implementar
		return null;
	}

	public List<Formula> buscarPorGrupo(Long grupoId) {
		TypedQuery<Formula> query = getEm()
				.createNamedQuery("formula.buscarPorGrupo", Formula.class)
				.setParameter("grupoId", grupoId);
		return query.getResultList();
	}

	public List<Formula> buscarPorNome(String nome) {
		TypedQuery<Formula> query = getEm()
				.createNamedQuery("formula.buscarPorNome", Formula.class)
				.setParameter("nome", nome);
		return query.getResultList();
	}

}