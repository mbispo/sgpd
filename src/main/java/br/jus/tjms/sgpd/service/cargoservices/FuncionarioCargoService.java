package br.jus.tjms.sgpd.service.cargoservices;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.jus.tjms.sgpd.entity.Cargo;
import br.jus.tjms.sgpd.entity.FuncionarioCargo;
import br.jus.tjms.sgpd.entity.ProgressaoFuncional;
import br.jus.tjms.sgpd.service.GenericService;

/**
 * @version 1.0
 * @created 11-dez-2015 18:15:40
 */
@Stateless
public class FuncionarioCargoService extends GenericService<FuncionarioCargo, Long> implements Serializable {

	private static final long serialVersionUID = 905906193824713820L;

	public List<Cargo> buscarCargosPorFuncionario(Long funcionarioId) {
		TypedQuery<Cargo> query = getEm().createNamedQuery("funcionarioCargo.buscarCargosPorFuncionario", Cargo.class)
				.setParameter("funcionarioId", funcionarioId);
		return query.getResultList();
	}
	
	public List<ProgressaoFuncional> buscarProgressoesPorFuncionario(Long funcionarioId) {
		TypedQuery<ProgressaoFuncional> query = getEm()
				.createNamedQuery("funcionarioCargo.buscarProgressoesPorFuncionario", ProgressaoFuncional.class)
				.setParameter("funcionarioId", funcionarioId);
		return query.getResultList();
	}

	public List<FuncionarioCargo> buscarFuncionarioCargosPorFuncionario(Long funcionarioId) {
		TypedQuery<FuncionarioCargo> query = getEm().createNamedQuery("funcionarioCargo.buscarFuncionarioCargosPorFuncionario", FuncionarioCargo.class)
				.setParameter("funcionarioId", funcionarioId);
		return query.getResultList();
	}

}