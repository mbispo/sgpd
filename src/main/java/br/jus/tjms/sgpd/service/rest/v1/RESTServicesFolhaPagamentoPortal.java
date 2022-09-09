package br.jus.tjms.sgpd.service.rest.v1;

import br.jus.tjms.sgpd.entity.*;
import br.jus.tjms.sgpd.enumerators.SituacaoFolhaPagamento;
import br.jus.tjms.sgpd.service.ServicesPortal;
import br.jus.tjms.sgpd.service.dadosconsolidadosservices.DadosConsolidadosService;
import br.jus.tjms.sgpd.service.folhapagamentoservices.*;
import br.jus.tjms.sgpd.service.funcionarioservices.FuncionarioService;
import br.jus.tjms.sgpd.service.rest.v1.to.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0
 * @created 11-dez-2015 18:15:46
 */
@Path("/rest/v1")
public class RESTServicesFolhaPagamentoPortal extends RESTServicesBasePortalV1 implements ServicesPortal {

	private static final long serialVersionUID = 3723019565535896402L;
    private static Logger logger = LoggerFactory.getLogger(RESTServicesFolhaPagamentoPortal.class);
	
	@EJB
	private FuncionarioService funcionarioService;
	
	@EJB
	private FolhaPagamentoService folhaPagamentoService;
	
	@EJB
	private CalculoFolhaService calculoFolhaService;
	
	@EJB
	private GrupoFolhaPagamentoService grupoFolhaPagamentoService;
	
	@EJB
	private FuncionarioFolhaPagamentoService funcionarioFolhaPagamentoService;
	
	@EJB
	private PagamentoService pagamentoService;
	
	@EJB
	private PagamentoItemService pagamentoItemService;
	
	@EJB
	private DadosConsolidadosService dadosConsolidadosService;
	

	// folhas:
	/*
	 * listarFolhasPagamento						GET		/folhas-pagamento/
	 * listarFolhasPagamentoPorAnoMes				GET		/pesquisas/folhas-pagamento/ano/{ano}/mes/{mes}/
	 * obterFolhaPagamento							GET		/folhas-pagamento/1
	 * criarFolhaPagamento							POST	/folhas-pagamento/...
	 * atualizarFolhaPagamento						PUT		/folhas-pagamento/1/...
	 * excluirFolhaPagamento						DELETE	/folhas-pagamento/1
	 * alterarSituacaoFolhaPagamento				POST	/alteracao-situacao-folha-pagamento/1/...
	 * calcularFolhaPagamento						POST	/calculo-folha-pagamento/1/...
	 * 
	 * listarGruposFolhaPagamento					GET		/grupos-folha-pagamento/
	 * obterGrupoFolhaPagamento						GET		/grupos-folha-pagamento/1
	 * criarGrupoFolhaPagamento						POST	/grupos-folha-pagamento/...
	 * atualizarGrupoFolhaPagamento					PUT		/grupos-folha-pagamento/1/...
	 * excluirGrupoFolhaPagamento					DELETE	/grupos-folha-pagamento/1
	 *  
	 * listarFuncionariosDaFolha					GET		/folhas-pagamento/1/funcionarios/
	 * obterFuncionarioDaFolha						GET		/folhas-pagamento/1/funcionarios/1
	 * adicionarFuncionarioNaFolha					POST	/folhas-pagamento/1/funcionarios/1/...
	 * removerFuncionarioDaFolha					DELETE	/folhas-pagamento/1/funcionarios/1
	 * 
	 * listarPagamentosDaFolha						GET		/folhas-pagamento/1/pagamentos/
	 * listarPagamentosDaFolhaEFuncionario			GET		/folhas-pagamento/1/funcionarios/1/pagamentos/
	 * listarPagamentosDoFuncionario				GET		/funcionarios/1/pagamentos/
	 * obterPagamento								GET		/funcionarios/1/pagamentos/1
	 * obterItensDoPagamento						GET		/funcionarios/1/pagamentos/1/itens/
	 * obterItemDoPagamento							GET		/funcionarios/1/pagamentos/1/itens/1
	 * 
	 * obterDadosConsolidadosDoFuncionario			GET		/funcionarios/1/dados-consolidados/
	 */

	@GET()
	@Path("/folhas-pagamento/")
	@Produces("application/json")
	public Response listarFolhasPagamento(@HeaderParam("token") String token) {
		validarToken(token);
		List<FolhaPagamento> folhasPagamento = folhaPagamentoService.buscarTodos();
		List<FolhaPagamentoTO> folhasPagamentoTO = new ArrayList<>();
		for (FolhaPagamento folhaPagamento : folhasPagamento) {
			folhasPagamentoTO.add(folhaPagamento.toTO());
		}
		return ok(folhasPagamentoTO);
	}

	@GET()
	@Path("/pesquisas/folhas-pagamento/ano/{ano}/mes/{mes}/")
	@Produces("application/json")
	public Response listarFolhasPagamentoPorAnoMes(@PathParam("ano") Integer ano, @PathParam("mes") Integer mes, @HeaderParam("token") String token) {
		validarToken(token);
		List<FolhaPagamento> folhasPagamento = folhaPagamentoService.buscarPorAnoMes(ano, mes);
		List<FolhaPagamentoTO> folhasPagamentoTO = new ArrayList<>();
		for (FolhaPagamento folhaPagamento : folhasPagamento) {
			folhasPagamentoTO.add(folhaPagamento.toTO());
		}
		return ok(folhasPagamentoTO);
	}

	@GET()
	@Path("/folhas-pagamento/{id}/")
	@Produces("application/json")
	public Response obterFolhaPagamento(@PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);
		
		FolhaPagamento folhaPagamento = folhaPagamentoService.buscarPorId(id);
		
		if (folhaPagamento == null) {
			return notFound("Folha de pagamento não encontrada!");
		}
		
		return ok(folhaPagamento.toTO());
	}
	
	@GET()
	@Path("/folhas-pagamento/{id}/total-liquido/")
	@Produces("application/json")
	public Response obterTotalLiquidoDaFolhaPagamento(@PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);
		Double totalLiquido = folhaPagamentoService.obterTotalLiquidoDaFolha(id); 
		return ok(totalLiquido);
	}	
	
	@POST()
	@Path("/folhas-pagamento/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response criarFolhaPagamento(FolhaPagamentoTO folhaPagamentoTO, @HeaderParam("token") String token) {
		validarToken(token);
		FolhaPagamento folhaPagamento = new FolhaPagamento(folhaPagamentoTO);
		try {
			folhaPagamento = folhaPagamentoService.salvar(folhaPagamento);
			return created(folhaPagamento);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return internalServerError("Falha ao criar folha de pagamento: "+e.getMessage()); 			
		}
	}

	@PUT()
	@Path("/folhas-pagamento/{id}/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response atualizarFolhaPagamento(@PathParam("id") Long id, FolhaPagamentoTO folhaPagamentoTO, @HeaderParam("token") String token) {
		validarToken(token);

		FolhaPagamento folhaPagamento = folhaPagamentoService.buscarPorId(id);
		if (folhaPagamento == null) {
			return notFound("Folha de pagamento não encontrada!");
		}
		
		try {
			folhaPagamento.alterar(folhaPagamentoTO);
			folhaPagamento = folhaPagamentoService.salvar(folhaPagamento);
			return ok(folhaPagamento);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return internalServerError("Falha ao atualizar folha de pagamento: "+e.getMessage());			
		}
	}

	@DELETE()
	@Path("/folhas-pagamento/{id}/")
	@Produces("application/json")
	public Response excluirFolhaPagamento(@PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);

		FolhaPagamento folhaPagamento = folhaPagamentoService.buscarPorId(id);
		if (folhaPagamento == null) {
			return notFound();
		}
		
		folhaPagamentoService.excluir(folhaPagamento);
		return ok();
	}

	@POST()
	@Path("/alteracao-situacao-folha-pagamento/{id}/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response alterarSituacaoFolhaPagamento(@PathParam("id") Long id, @HeaderParam("token") String token, 
			@FormParam("situacao") SituacaoFolhaPagamento situacao) {
		validarToken(token);

		FolhaPagamento folhaPagamento = folhaPagamentoService.buscarPorId(id);
		if (folhaPagamento == null) {
			return notFound();
		}
		
		folhaPagamento.alterarSituacao(situacao);
		folhaPagamento = folhaPagamentoService.salvar(folhaPagamento);
		return ok(folhaPagamento);
	}

	@POST()
	@Path("/calculo-folha-pagamento/{id}/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response calcularFolhaPagamento(@PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);
		// TODO implementar cálculo assíncrono
		try {
			Object o = calculoFolhaService.calcularFolha(id);
			return ok(o);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return internalServerError("Falha ao calcular folha "+id+":"+e.getMessage());
		}
	}

	@GET()
	@Path("/grupos-folha-pagamento/")
	@Produces("application/json")
	public Response listarGruposFolhaPagamento(@HeaderParam("token") String token) {
		validarToken(token);
		List<GrupoFolhaPagamento> grupos = grupoFolhaPagamentoService.buscarTodos();
		List<GrupoFolhaPagamentoTO> gruposTO = new ArrayList<>();
		for (GrupoFolhaPagamento grupoFolhaPagamento : grupos) {
			gruposTO.add(grupoFolhaPagamento.toTO());
		}
		return ok(gruposTO);
	}

	@GET()
	@Path("/grupos-folha-pagamento/{id}/")
	@Produces("application/json")
	public Response obterGrupoFolhaPagamento(@PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);
		GrupoFolhaPagamento grupoFolhaPagamento = grupoFolhaPagamentoService.buscarPorId(id);
		if (grupoFolhaPagamento==null) {
			return notFound();
		}
		return ok(grupoFolhaPagamento.toTO());
	}

	@POST()
	@Path("/grupos-folha-pagamento/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response criarGrupoFolhaPagamento(GrupoFolhaPagamentoTO grupoFolhaPagamentoTO, @HeaderParam("token") String token) {
		validarToken(token);
		GrupoFolhaPagamento grupoFolhaPagamento = new GrupoFolhaPagamento(grupoFolhaPagamentoTO);
		try {
			grupoFolhaPagamento = grupoFolhaPagamentoService.salvar(grupoFolhaPagamento);
			return created(grupoFolhaPagamento);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return internalServerError("Falha ao criar grupo de folha de pagamento: "+e.getMessage());
		}
	}

	@PUT()
	@Path("/grupos-folha-pagamento/{id}/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response atualizarGrupoFolhaPagamento(@PathParam("id") Long id, GrupoFolhaPagamentoTO grupoFolhaPagamentoTO, @HeaderParam("token") String token) {
		validarToken(token);

		GrupoFolhaPagamento grupoFolhaPagamento = grupoFolhaPagamentoService.buscarPorId(id);
		if (grupoFolhaPagamento == null) {
			return notFound();
		}
		
		grupoFolhaPagamento.alterar(grupoFolhaPagamentoTO);
		grupoFolhaPagamento = grupoFolhaPagamentoService.salvar(grupoFolhaPagamento);
		return ok(grupoFolhaPagamento);
	}

	@DELETE()
	@Path("/grupos-folha-pagamento/{id}/")
	@Produces("application/json")
	public Response excluirGrupoFolhaPagamento(@PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);

		GrupoFolhaPagamento grupoFolhaPagamento = grupoFolhaPagamentoService.buscarPorId(id);
		if (grupoFolhaPagamento == null) {
			return notFound();
		}
		
		grupoFolhaPagamentoService.excluir(grupoFolhaPagamento);
		return ok();
	}

	@GET()
	@Path("/folhas-pagamento/{folhaPagamentoId}/funcionarios/")
	@Produces("application/json")
	public Response listarFuncionariosDaFolha(@PathParam("folhaPagamentoId") Long folhaPagamentoId, @HeaderParam("token") String token) {
		validarToken(token);
		List<Funcionario> funcionarios = funcionarioFolhaPagamentoService.buscarFuncionariosPorFolha(folhaPagamentoId);
		List<FuncionarioTO> funcionariosTO = new ArrayList<>();
		for (Funcionario funcionario : funcionarios) {
			funcionariosTO.add(funcionario.toTO());
		}
		
		return ok(funcionariosTO);
	}

	@GET()
	@Path("/folhas-pagamento/{folhaPagamentoId}/funcionarios/{id}/")
	@Produces("application/json")
	public Response obterFuncionarioDaFolha(@PathParam("folhaPagamentoId") Long folhaPagamentoId, 
			@PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);
		FuncionarioFolhaPagamento funcionarioFolhaPagamento = funcionarioFolhaPagamentoService.buscarPorId(id);
		return funcionarioFolhaPagamento!=null?ok(funcionarioFolhaPagamento.toTO()):notFound();
	}

	@POST() @Consumes("application/json")
	@Path("/folhas-pagamento/{folhaPagamentoId}/funcionarios/{id}/")
	@Produces("application/json")
	public Response adicionarFuncionarioNaFolha(@PathParam("folhaPagamentoId") Long folhaPagamentoId, 
			@PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);
		
		FolhaPagamento folhaPagamento = folhaPagamentoService.buscarPorId(folhaPagamentoId);
		Funcionario funcionario = funcionarioService.buscarPorId(id);
		
		if (folhaPagamento == null) {
			return notFound("Folha de pagamento não encontrada!");
		}
		
		if (funcionario == null) {
			return notFound("Funcionário não encontrado!");
		}		
		
		FuncionarioFolhaPagamento funcionarioFolhaPagamento = new FuncionarioFolhaPagamento(funcionario, folhaPagamento);
		try {
			funcionarioFolhaPagamento = funcionarioFolhaPagamentoService.salvar(funcionarioFolhaPagamento);
			return created(funcionarioFolhaPagamento);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return internalServerError("Falha ao adicionar funcionário na folha: "+e.getMessage());			
		}
	}

	@DELETE()
	@Path("/folhas-pagamento/{folhaPagamentoId}/funcionarios/{id}/")
	@Produces("application/json")
	public Response removerFuncionarioDaFolha(@PathParam("folhaPagamentoId") Long folhaPagamentoId, 
			@PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);

		FolhaPagamento folhaPagamento = folhaPagamentoService.buscarPorId(folhaPagamentoId);
		FuncionarioFolhaPagamento funcionarioFolhaPagamento = funcionarioFolhaPagamentoService.buscarPorId(id);
		
		if (folhaPagamento == null || funcionarioFolhaPagamento == null) {
			return notFound();
		}
		
		folhaPagamento.getFuncionarios().remove(funcionarioFolhaPagamento);
		folhaPagamento = folhaPagamentoService.salvar(folhaPagamento);
		return ok(folhaPagamento);
	}

	@GET()
	@Path("/folhas-pagamento/{id}/pagamentos/")
	@Produces("application/json")
	public Response listarPagamentosDaFolha(@PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);

		List<PagamentoTO> pagamentosTO = folhaPagamentoService.obterPagamentosTO(id);
		if (pagamentosTO == null) {
			return notFound();
		}
		
		return ok(pagamentosTO);
	}

	@GET()
	@Path("/folhas-pagamento/{folhaPagamentoId}/funcionarios/{funcionarioId}/pagamentos/")
	@Produces("application/json")
	public Response listarPagamentosDaFolhaEFuncionario(@PathParam("folhaPagamentoId") Long folhaPagamentoId,
			@PathParam("funcionarioId") Long funcionarioId, @HeaderParam("token") String token) {
		validarToken(token);
		List<Pagamento> pagamentos = pagamentoService.buscarPorFolhaEFuncionario(folhaPagamentoId, funcionarioId);
		
		if (pagamentos == null) {
			return notFound();
		}
		
		List<PagamentoTO> pagamentosTO = new ArrayList<>();
		
		for (Pagamento pagamento : pagamentos) {
			pagamentosTO.add(pagamento.toTO());
		}
		
		return ok(pagamentosTO);
	}

	@GET()
	@Path("/funcionarios/{funcionarioId}/pagamentos/")
	@Produces("application/json")
	public Response listarPagamentosDoFuncionario(@PathParam("funcionarioId") Long funcionarioId, @HeaderParam("token") String token) {
		validarToken(token);
		List<Pagamento> pagamentos = pagamentoService.buscarPorFuncionario(funcionarioId);
		if (pagamentos == null) {
			return notFound();
		}
		
		List<PagamentoTO> pagamentosTO = new ArrayList<>();
		
		for (Pagamento pagamento : pagamentos) {
			pagamentosTO.add(pagamento.toTO());
		}
		
		return ok(pagamentosTO);

	}

	@GET()
	@Path("/funcionarios/{funcionarioId}/pagamentos/{id}/")
	@Produces("application/json")
	public Response obterPagamento(@PathParam("funcionarioId") Long funcionarioId, @PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);
		Pagamento pagamento = pagamentoService.buscarPorId(id);
		return pagamento!=null?ok(pagamento.toTO()):notFound();
	}

	@GET()
	@Path("/funcionarios/{funcionarioId}/pagamentos/{id}/itens/")
	@Produces("application/json")
	public Response obterItensDoPagamento(@PathParam("funcionarioId") Long funcionarioId, @PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);
		List<PagamentoItem> itensPagamento = pagamentoItemService.buscarPorPagamento(id);
		if (itensPagamento==null) {return notFound();}
		List<PagamentoItemTO> itensPagamentoTO = new ArrayList<>();
		for (PagamentoItem pagamentoItem : itensPagamento) {
			itensPagamentoTO.add(pagamentoItem.toTO());
		}
		return ok(itensPagamentoTO);
	}

	@GET()
	@Path("/funcionarios/{funcionarioId}/pagamentos/{pagamentoId}/itens/{id}/")
	@Produces("application/json")
	public Response obterItemDoPagamento(@PathParam("funcionarioId") Long funcionarioId, 
			@PathParam("pagamentoId") Long pagamentoId, @PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);
		PagamentoItem pagamentoItem = pagamentoItemService.buscarPorId(id);
		return pagamentoItem!=null?ok(pagamentoItem.toTO()):null;
	}
	
	@GET
	@Path("/funcionarios/{funcionarioId}/dados-consolidados/")
	@Produces("application/json")
	public Response obterDadosConsolidadosDoFuncionario(@PathParam("funcionarioId") Long funcionarioId,
			@HeaderParam("token") String token) {
		validarToken(token);
		DadosConsolidadosDoFuncionario d = dadosConsolidadosService.obterUltimaConsolidacao(funcionarioId);
		
		if (d==null) {
			dadosConsolidadosService.consolidar(funcionarioId);
			d = dadosConsolidadosService.obterUltimaConsolidacao(funcionarioId);
			
			if (d==null) {
				return notFound();
			}
		}

		return ok(d.toTO());		
	}

}