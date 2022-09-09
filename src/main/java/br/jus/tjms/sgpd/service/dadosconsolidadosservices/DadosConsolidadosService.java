package br.jus.tjms.sgpd.service.dadosconsolidadosservices;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.jus.tjms.sgpd.entity.ContaRecebimento;
import br.jus.tjms.sgpd.entity.DadosConsolidadosDoFuncionario;
import br.jus.tjms.sgpd.entity.Funcionario;
import br.jus.tjms.sgpd.entity.FuncionarioCargo;
import br.jus.tjms.sgpd.enumerators.TipoContaRecebimento;
import br.jus.tjms.sgpd.enumerators.TipoProvimento;
import br.jus.tjms.sgpd.service.GenericService;
import br.jus.tjms.sgpd.service.funcionarioservices.FuncionarioService;

/**
 * @version 1.0
 * @created 11-dez-2015 18:15:37
 */
@Stateless
public class DadosConsolidadosService extends GenericService<DadosConsolidadosDoFuncionario, Long> implements Serializable {

	private static final long serialVersionUID = 5896838852582025142L;
	
	@EJB
	FuncionarioService funcionarioService;
	
	public DadosConsolidadosDoFuncionario consolidar(Long funcionarioId) {
		Funcionario f = funcionarioService.buscarPorId(funcionarioId);
		
		DadosConsolidadosDoFuncionario d = new DadosConsolidadosDoFuncionario();
		d.setFuncionario(f);

		List<TipoProvimento> tiposProvimentoCargosComissionados = Arrays.asList(
			new TipoProvimento[]{
					TipoProvimento.COMISSIONADO,
					TipoProvimento.FUNCAO_DE_CONFIANCA,
					TipoProvimento.FUNCAO_GRATIFICADA
			}
		);

		List<FuncionarioCargo> cargosAtivos = f.getCargosAtivos(new Date());
		
		if (cargosAtivos!=null) {
			if (cargosAtivos.size()==1) {
				d.setFuncionarioCargoPrincipal(cargosAtivos.get(0));
			} else if (cargosAtivos.size()>1) {
				List<FuncionarioCargo> cargosAtivosEfetivos = f.getCargosAtivosPorExclusaoTiposProvimento(new Date(),tiposProvimentoCargosComissionados);
				
				d.setFuncionarioCargoPrincipal(cargosAtivosEfetivos!=null&&cargosAtivosEfetivos.size()>0?cargosAtivosEfetivos.get(0):null);
				
				List<FuncionarioCargo> cargosAtivosComissionados = f.getCargosAtivosPorTiposProvimento(new Date(),tiposProvimentoCargosComissionados);		
				
				d.setFuncionarioCargoAcumulado1(cargosAtivosComissionados!=null&&cargosAtivosComissionados.size()>0?cargosAtivosComissionados.get(0):null);
				d.setFuncionarioCargoAcumulado2(cargosAtivosComissionados!=null&&cargosAtivosComissionados.size()>1?cargosAtivosComissionados.get(1):null);
			}
		}
		
		d.setCargoPrincipal(d.getFuncionarioCargoPrincipal()!=null?d.getFuncionarioCargoPrincipal().getCargo().getNome():null);
		d.setCargoAcumulado1(d.getFuncionarioCargoAcumulado1()!=null?d.getFuncionarioCargoAcumulado1().getCargo().getNome():null);
		d.setCargoAcumulado2(d.getFuncionarioCargoAcumulado2()!=null?d.getFuncionarioCargoAcumulado2().getCargo().getNome():null);
		
		List<ContaRecebimento> contas = f.getPessoa().getContasRecebimentoAtivasPorTipo(TipoContaRecebimento.SALARIO);
		
		d.setContaRecebimento(contas!=null&&contas.size()>0?contas.get(0):null);
		
		if (f.getAreas()!=null&&f.getAreas().size()>0) {
			d.setFuncionarioArea(f.getAreas().get(0));
		}
		
		if (d.getFuncionarioArea()!=null) {
			d.setLotacao(d.getFuncionarioArea().getArea().getNomeCompleto());
		}
		
		d.setObservacoes("");
		
		d.setDataConsolidacao(new Date());
		d = salvar(d);
		
		System.out.println("Consolidação de dados criada: "+d.toString());
		
		return d;
	}
	
	public DadosConsolidadosDoFuncionario obterUltimaConsolidacao(Long funcionarioId) {
		
		return obterUltimaConsolidacaoAteDataLimite(funcionarioId, new Date());
		
	}
	
	public DadosConsolidadosDoFuncionario obterUltimaConsolidacaoAteDataLimite(Long funcionarioId, Date dataLimite) {
		
		// dadosConsolidadosDoFuncionario.buscarPorFuncionarioIdAteADataLimite
		// SELECT d FROM DadosConsolidadosDoFuncionario d WHERE d.funcionario.id = :id and d.dataConsolidacao <= :dataLimite order by d.id desc
		
		TypedQuery<DadosConsolidadosDoFuncionario> query = getEm()
				.createNamedQuery("dadosConsolidadosDoFuncionario.buscarPorFuncionarioIdAteADataLimite", DadosConsolidadosDoFuncionario.class)
				.setParameter("funcionarioId", funcionarioId)
				.setParameter("dataLimite", dataLimite);
		
		query.setMaxResults(1);
		
		List<DadosConsolidadosDoFuncionario> lista =  query.getResultList();
		
		if (lista!=null&&lista.size()>0) {
			return lista.get(0);
		}
		
		return null;
		
	}	

}