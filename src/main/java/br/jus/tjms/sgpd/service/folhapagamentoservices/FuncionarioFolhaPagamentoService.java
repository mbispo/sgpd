package br.jus.tjms.sgpd.service.folhapagamentoservices;
import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.jus.tjms.sgpd.entity.Funcionario;
import br.jus.tjms.sgpd.entity.FuncionarioFolhaPagamento;
import br.jus.tjms.sgpd.service.GenericService;

@Stateless
public class FuncionarioFolhaPagamentoService extends GenericService<FuncionarioFolhaPagamento, Long> implements Serializable {

	private static final long serialVersionUID = -9046706994911747311L;

	public List<Funcionario> buscarFuncionariosPorFolha(Long folhaPagamentoId) {
		TypedQuery<Funcionario> query = getEm()
				.createNamedQuery("funcionarioFolhaPagamento.buscarFuncionariosPorFolhaPagamentoId", Funcionario.class)
				.setParameter("folhaPagamentoId", folhaPagamentoId);
		return query.getResultList();
	}
	
}