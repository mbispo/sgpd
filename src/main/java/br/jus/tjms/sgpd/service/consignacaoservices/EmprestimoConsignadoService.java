package br.jus.tjms.sgpd.service.consignacaoservices;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;

import br.jus.tjms.sgpd.entity.EmprestimoConsignado;
import br.jus.tjms.sgpd.entity.Funcionario;
import br.jus.tjms.sgpd.entity.ParcelaEmprestimoConsignado;
import br.jus.tjms.sgpd.enumerators.SituacaoEmprestimoConsignado;
import br.jus.tjms.sgpd.enumerators.SituacaoParcelaEmprestimoConsignado;
import br.jus.tjms.sgpd.service.GenericService;

/**
 * @version 1.0
 * @created 11-dez-2015 18:15:39
 */
@Stateless
public class EmprestimoConsignadoService extends GenericService<EmprestimoConsignado, Long> implements Serializable {
	
	private static final long serialVersionUID = 1209657096487937368L;
	
	private static List<EmprestimoConsignado> TEST_DATA = new ArrayList<>();
	private static Boolean TESTING = false;
	
	public static void setTestingMode(Boolean testing, List<EmprestimoConsignado> testData) {
		TESTING = testing;
		TEST_DATA = testing?testData:null;
	}

	public List<ParcelaEmprestimoConsignado> obterParcelasEmprestimoConsigandoEmAbertoNoPeriodo(final Funcionario funcionario,
			final Date periodoInicio, final Date periodoFim) {

		if (TESTING) {
			List<EmprestimoConsignado> dados = TEST_DATA;

			List<ParcelaEmprestimoConsignado> retorno = new ArrayList<>();
			/* usando guava */

			if (dados != null) {
				for (EmprestimoConsignado emprestimoConsignado : dados) {
					Collection<ParcelaEmprestimoConsignado> c = Collections2.filter(emprestimoConsignado.getParcelas(), new Predicate<ParcelaEmprestimoConsignado>() {
						@Override
						public boolean apply(ParcelaEmprestimoConsignado p) {
							return (p.getEmprestimoConsignado().getFuncionario().equals(funcionario)&&p.getEmprestimoConsignado().getSituacao().equals(SituacaoEmprestimoConsignado.ATIVO)&&p.getSituacao().equals(SituacaoParcelaEmprestimoConsignado.PENDENTE)&&p.getVencimento().after(periodoInicio)&&p.getVencimento().before(periodoFim));
						}
					});
					
					retorno.addAll(c);
				}
			}

			return retorno;			
			
		}

		// TODO implementar EmprestimoConsignadoService.obterParcelasEmprestimoConsigandoEmAbertoNoPeriodo
		return null;
		
	}

	public void pagarParcela(ParcelaEmprestimoConsignado p, Date dataPagamento, Double valorPago) {
		// não é necessário persistir, se o método for transacional a persistência é feita automaticamente
		p.setPagamento(dataPagamento);
		p.setValorPago(valorPago);
		p.pagar();
	}

	public List<EmprestimoConsignado> buscarPorFuncionario(Long funcionarioId) {
		TypedQuery<EmprestimoConsignado> query = getEm()
				.createNamedQuery("emprestimoConsignado.buscarEmprestimosPorFuncionario", EmprestimoConsignado.class)
				.setParameter("funcionarioId", funcionarioId);
		return query.getResultList();
	}
	

}