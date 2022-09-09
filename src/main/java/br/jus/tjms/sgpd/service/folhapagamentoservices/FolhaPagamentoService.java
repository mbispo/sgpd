package br.jus.tjms.sgpd.service.folhapagamentoservices;
import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.jus.tjms.sgpd.entity.FolhaPagamento;
import br.jus.tjms.sgpd.enumerators.SituacaoFolhaPagamento;
import br.jus.tjms.sgpd.enumerators.TipoFolhaPagamento;
import br.jus.tjms.sgpd.service.GenericService;
import br.jus.tjms.sgpd.service.rest.v1.to.PagamentoTO;

/**
 * @version 1.0
 * @created 11-dez-2015 18:15:39
 */
@Stateless
public class FolhaPagamentoService extends GenericService<FolhaPagamento, Long> implements Serializable {

	private static final long serialVersionUID = -893589717727463354L;

	public Long criarFolha(Integer ano, Integer mes, String descricao, TipoFolhaPagamento tipoFolhaPagamento, Long idGrupoFolhaPagamento) {
		//TODO implementar 
		return null;
	}
	
	public void definirSituacaoDaFolha(Long idFolha, SituacaoFolhaPagamento situacao) {
		//TODO implementar 
	}

	public List<FolhaPagamento> buscarPorAnoMes(Integer ano, Integer mes) {
		TypedQuery<FolhaPagamento> query = getEm()
				.createNamedQuery("folhaPagamento.buscarFolhasPorAnoMes", FolhaPagamento.class)
				.setParameter("ano", ano)
				.setParameter("mes", mes);
		return query.getResultList();
	}

	public Double obterTotalLiquidoDaFolha(Long id) {
		return buscarPorId(id).getTotalLiquido();
	}

	public List<PagamentoTO> obterPagamentosTO(Long id) {
		FolhaPagamento fp = buscarPorId(id);
		
		List<PagamentoTO> pagamentos = null;
		
		if (fp!=null) {
			pagamentos = fp.toTO().getPagamentos();
		}
		
		return pagamentos;
	}
	
}