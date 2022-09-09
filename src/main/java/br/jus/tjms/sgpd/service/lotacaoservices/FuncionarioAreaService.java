package br.jus.tjms.sgpd.service.lotacaoservices;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.jus.tjms.sgpd.entity.Area;
import br.jus.tjms.sgpd.entity.Funcionario;
import br.jus.tjms.sgpd.entity.FuncionarioArea;
import br.jus.tjms.sgpd.service.GenericService;

/**
 * @version 1.0
 * @created 11-dez-2015 18:15:40
 */
@Stateless
public class FuncionarioAreaService extends GenericService<FuncionarioArea, Long> implements Serializable {

	private static final long serialVersionUID = -6521605173007521378L;

	public List<Funcionario> buscarFuncionariosPorArea(Long areaId) {
		TypedQuery<Funcionario> query = getEm()
				.createNamedQuery("funcionarioArea.buscarFuncionariosPorArea", Funcionario.class)
				.setParameter("areaId", areaId);
		return query.getResultList();
	}

	public List<Area> buscarAreasPorFuncionario(Long funcionarioId) {
		TypedQuery<Area> query = getEm()
				.createNamedQuery("funcionarioArea.buscarAreasPorFuncionario", Area.class)
				.setParameter("funcionarioId", funcionarioId);
		return query.getResultList();
	}

}