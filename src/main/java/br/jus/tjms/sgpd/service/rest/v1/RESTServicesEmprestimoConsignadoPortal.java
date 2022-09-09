package br.jus.tjms.sgpd.service.rest.v1;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import br.jus.tjms.sgpd.entity.AprovacaoEmprestimoConsignado;
import br.jus.tjms.sgpd.entity.EmprestimoConsignado;
import br.jus.tjms.sgpd.entity.ParcelaEmprestimoConsignado;
import br.jus.tjms.sgpd.entity.SimulacaoEmprestimoConsignado;
import br.jus.tjms.sgpd.entity.SolicitacaoEmprestimoConsignado;
import br.jus.tjms.sgpd.enumerators.SituacaoAprovacaoEmprestimoConsignado;
import br.jus.tjms.sgpd.enumerators.SituacaoSimulacaoEmprestimoConsignado;
import br.jus.tjms.sgpd.service.ServicesPortal;
import br.jus.tjms.sgpd.service.consignacaoservices.AprovacaoEmprestimoConsignadoService;
import br.jus.tjms.sgpd.service.consignacaoservices.EmprestimoConsignadoService;
import br.jus.tjms.sgpd.service.consignacaoservices.ParcelaEmprestimoConsignadoService;
import br.jus.tjms.sgpd.service.consignacaoservices.SimulacaoEmprestimoConsignadoService;
import br.jus.tjms.sgpd.service.consignacaoservices.SolicitacaoEmprestimoConsignadoService;
import br.jus.tjms.sgpd.service.funcionarioservices.FuncionarioService;
import br.jus.tjms.sgpd.service.rest.v1.to.AprovacaoEmprestimoConsignadoTO;
import br.jus.tjms.sgpd.service.rest.v1.to.EmprestimoConsignadoTO;
import br.jus.tjms.sgpd.service.rest.v1.to.EstornoParcelaEmprestimoConsignadoTO;
import br.jus.tjms.sgpd.service.rest.v1.to.MudancaSituacaoEmprestimoConsignadoTO;
import br.jus.tjms.sgpd.service.rest.v1.to.MudancaSituacaoParcelaEmprestimoConsignadoTO;
import br.jus.tjms.sgpd.service.rest.v1.to.PagamentoParcelaEmprestimoConsignadoTO;
import br.jus.tjms.sgpd.service.rest.v1.to.ParcelaEmprestimoConsignadoTO;
import br.jus.tjms.sgpd.service.rest.v1.to.QuitacaoEmprestimoConsignadoTO;
import br.jus.tjms.sgpd.service.rest.v1.to.RenegociacaoEmprestimoConsignadoTO;
import br.jus.tjms.sgpd.service.rest.v1.to.SimulacaoEmprestimoConsignadoTO;
import br.jus.tjms.sgpd.service.rest.v1.to.SolicitacaoEmprestimoConsignadoTO;

/**
 * @version 1.0
 * @created 11-dez-2015 18:15:46
 */
public class RESTServicesEmprestimoConsignadoPortal extends RESTServicesBasePortalV1 implements ServicesPortal {

	private static final long serialVersionUID = -8230335923925326677L;
	
	@EJB
	private FuncionarioService funcionarioService;
	
	@EJB
	private EmprestimoConsignadoService emprestimoConsignadoService;
	
	@EJB
	private SolicitacaoEmprestimoConsignadoService solicitacaoEmprestimoConsignadoService;

	@EJB
	private SimulacaoEmprestimoConsignadoService simulacaoEmprestimoConsignadoService;
	
	@EJB
	private AprovacaoEmprestimoConsignadoService aprovacaoEmprestimoConsignadoService;
	
	@EJB
	private ParcelaEmprestimoConsignadoService parcelaEmprestimoConsignadoService;
	
	// emprestimo consignado
	/*
	 * #SolicitacaoEmprestimoConsignado
	 * listarSolicitacaoEmprestimoConsignado		GET		/funcionarios/1/solicitacoes-emprestimo-consignado/
	 * obterSolicitacaoEmprestimoConsignado			GET		/funcionarios/1/solicitacoes-emprestimo-consignado/1
	 * criarSolicitacaoEmprestimoConsignado			POST	/funcionarios/1/solicitacoes-emprestimo-consignado/...
	 * alterarSolicitacaoEmprestimoConsignado		PUT		/funcionarios/1/solicitacoes-emprestimo-consignado/1/...
	 * removerSolicitacaoEmprestimoConsignado		DELETE	/funcionarios/1/solicitacoes-emprestimo-consignado/1
	 * 
	 * #SimulacaoEmprestimoConsignado: [PENDENTE,VISUALIZADA,APROVADA,RECUSADA,CANCELADA]
	 * listarSimulacaoEmprestimoConsignado			GET		/funcionarios/1/solicitacoes-emprestimo-consignado/1/simulacoes/
	 * obterSimulacaoEmprestimoConsignado			GET		/funcionarios/1/solicitacoes-emprestimo-consignado/1/simulacoes/1
	 * criarSimulacaoEmprestimoConsignado			POST	/funcionarios/1/solicitacoes-emprestimo-consignado/1/simulacoes/...
	 * alterarSimulacaoEmprestimoConsignado			PUT		/funcionarios/1/solicitacoes-emprestimo-consignado/1/simulacoes/1/...
	 * removerSimulacaoEmprestimoConsignado			DELETE	/funcionarios/1/solicitacoes-emprestimo-consignado/1/simulacoes/1
	 * aprovarSimulacaoEmprestimoConsignado			POST	/aprovacao-simulacao-emprestimo-consignado/1/...
	 * recusarSimulacaoEmprestimoConsignado			POST	/recusa-simulacao-emprestimo-consignado/1/...
	 * definirSituacaoSimulacaoEmprestimoConsignado	POST	/mudanca-situcao-simulacao-emprestimo-consignado/1/...
	 * 
	 * #AprovacaoEmprestimoConsignado: [PENDENTE,AVERBADO,INDEFERIDO] 
	 * listarAprovacaoEmprestimoConsignado			GET		/funcionarios/1/aprovacoes-emprestimos-consignados/
	 * obterAprovacaoEmprestimoConsignado			GET		/funcionarios/1/aprovacoes-emprestimos-consignados/1
	 * criarAprovacaoEmprestimoConsignado			POST	/funcionarios/1/aprovacoes-emprestimos-consignados/...
	 * alterarAprovacaoEmprestimoConsignado			PUT		/funcionarios/1/aprovacoes-emprestimos-consignados/1/...
	 * removerAprovacaoEmprestimoConsignado			DELETE	/funcionarios/1/aprovacoes-emprestimos-consignados/1
	 * averbarAprovacaoEmprestimoConsignado			POST	/averbacao-aprovacao-emprestimo-consignado/1/...
	 * indeferirAprovacaoEmprestimoConsignado		POST	/indeferimento-aprovacao-emprestimo-consignado/1/...
	 * definirSituacaoAprovacaoEmprestimoConsignado	POST	/mudanca-situacao-aprovacao-emprestimo-consignado/1/...
	 * 
	 * #EmprestimoConsignado: [PENDENTE,ATIVO,SUSPENSO,QUITADO,RENEGOCIADO,PORTADO,REFINANCIADO,INATIVO,CANCELADO]
	 * listarEmprestimoConsignado					GET		/funcionarios/1/emprestimos-consignados/
	 * obterEmprestimoConsignado					GET		/funcionarios/1/emprestimos-consignados/1
	 * criarEmprestimoConsignado					POST	/funcionarios/1/emprestimos-consignados/...
	 * alterarEmprestimoConsignado					PUT		/funcionarios/1/emprestimos-consignados/1/...
	 * removerEmprestimoConsignado					DELETE	/funcionarios/1/emprestimos-consignados/1
	 * quitarEmprestimoConsignado					POST	/quitacaoEmprestimoConsignado/1/...
	 * renegociarEmprestimoConsignado				POST	/renegociacaoEmprestimoConsignado/1/...
	 * definirSituacaoEmprestimoConsignado			POST	/mudancaSituacaoEmprestimoConsignado/1/...
	 * 
	 * ParcelaEmprestimoConsignado: [PENDENTE,PAGA,ESTORNADA,CANCELADA]
	 * listarParcelasEmprestimoConsignado			GET		/funcionarios/1/emprestimos-consignados/1/parcelas/
	 * obterParcelaEmprestimoConsignado				GET		/funcionarios/1/emprestimos-consignados/1/parcelas/1
	 * gerarParcelasEmprestimoConsignado			POST	/geracaoParcelasEmprestimoConsignado/1/...
	 * criarParcelaEmprestimoConsignado				POST	/funcionarios/1/emprestimos-consignados/1/parcelas/...
	 * alterarParcelaEmprestimoConsignado			PUT		/funcionarios/1/emprestimos-consignados/1/parcelas/1/...
	 * removerParcelaEmprestimoConsignado			DELETE	/funcionarios/1/emprestimos-consignados/1/parcelas/1	
	 * pagarParcelaEmprestimoConsignado				POST	/pagamento-parcela-emprestimo-consignado/1/...
	 * estornarParcelaEmprestimoConsignado			POST	/estorno-parcela-emprestimo-consignado/1/...
	 * cancelarParcelaEmprestimoConsignado			POST	/cancelamento-parcela-emprestimo-consignado/1/...
	 * definirSituacaoParcelaEmprestimoConsignado	POST	/mudanca-situacao-parcela-emprestimo-consignado/1/...
	 * 
	 */


	@GET()
	@Path("/funcionarios/{funcionarioId}/solicitacoes-emprestimo-consignado/")
	@Produces("application/json")
	public Response listarSolicitacaoEmprestimoConsignado(@PathParam("funcionarioId") Long funcionarioId, 
			@HeaderParam("token") String token) {
		validarToken(token);
		List<SolicitacaoEmprestimoConsignado> solicitacoesEmprestimoConsignado = solicitacaoEmprestimoConsignadoService.buscarPorFuncionario(funcionarioId);
		return ok(solicitacoesEmprestimoConsignado);
	}

	@GET()
	@Path("/funcionarios/{funcionarioId}/solicitacoes-emprestimo-consignado/{id}/")
	@Produces("application/json")
	public Response obterSolicitacaoEmprestimoConsignado(@PathParam("funcionarioId") Long funcionarioId, 
			@PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);
		SolicitacaoEmprestimoConsignado solicitacaoEmprestimoConsignado = solicitacaoEmprestimoConsignadoService.buscarPorId(id);
		return ok(solicitacaoEmprestimoConsignado);
	}

	@POST() @Consumes("application/json")
	@Path("/funcionarios/{funcionarioId}/solicitacoes-emprestimo-consignado/")
	@Produces("application/json")
	public Response criarSolicitacaoEmprestimoConsignado(@PathParam("funcionarioId") Long funcionarioId, 
			SolicitacaoEmprestimoConsignadoTO solicitacaoEmprestimoConsignadoTO, @HeaderParam("token") String token) {
		validarToken(token);
		SolicitacaoEmprestimoConsignado solicitacaoEmprestimoConsignado = new SolicitacaoEmprestimoConsignado(solicitacaoEmprestimoConsignadoTO);
		solicitacaoEmprestimoConsignado = solicitacaoEmprestimoConsignadoService.salvar(solicitacaoEmprestimoConsignado);
		return ok(solicitacaoEmprestimoConsignado);
	}
	
	@PUT() @Consumes("application/json")
	@Path("/funcionarios/{funcionarioId}/solicitacoes-emprestimo-consignado/{id}/")
	@Produces("application/json")
	public Response alterarSolicitacaoEmprestimoConsignado(@PathParam("funcionarioId") Long funcionarioId, @PathParam("id") Long id, 
			SolicitacaoEmprestimoConsignadoTO solicitacaoEmprestimoConsignadoTO, @HeaderParam("token") String token) {
		validarToken(token);


		SolicitacaoEmprestimoConsignado solicitacaoEmprestimoConsignado = solicitacaoEmprestimoConsignadoService.buscarPorId(id);
		if (solicitacaoEmprestimoConsignado == null) {
			return notFound();
		}
		
		solicitacaoEmprestimoConsignado.altarar(solicitacaoEmprestimoConsignadoTO);
		solicitacaoEmprestimoConsignado = solicitacaoEmprestimoConsignadoService.salvar(solicitacaoEmprestimoConsignado);
		return ok(solicitacaoEmprestimoConsignado);
	}

	@DELETE()
	@Path("/funcionarios/{funcionarioId}/solicitacoes-emprestimo-consignado/{id}/")
	@Produces("application/json")
	public Response removerSolicitacaoEmprestimoConsignado(@PathParam("funcionarioId") Long funcionarioId, 
			@PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);

		SolicitacaoEmprestimoConsignado solicitacaoEmprestimoConsignado = solicitacaoEmprestimoConsignadoService.buscarPorId(id);
		if (solicitacaoEmprestimoConsignado == null) {
			return notFound();
		}
		
		solicitacaoEmprestimoConsignadoService.excluir(solicitacaoEmprestimoConsignado);
		return ok();
	}

	@GET()
	@Path("/funcionarios/{funcionarioId}/solicitacoes-emprestimo-consignado/{solicitacaoId}/simulacoes/")
	@Produces("application/json")
	public Response listarSimulacaoEmprestimoConsignado(@PathParam("funcionarioId") Long funcionarioId, 
			@PathParam("solicitacaoId") Long solicitacaoId, @HeaderParam("token") String token) {
		validarToken(token);
		List<SimulacaoEmprestimoConsignado> simulacoes = simulacaoEmprestimoConsignadoService.buscarSimulacoesPorSolicitacaoEmsprestimoConsignado(solicitacaoId);
		return ok(simulacoes);
	}

	@GET()
	@Path("/funcionarios/{funcionarioId}/solicitacoes-emprestimo-consignado/{solicitacaoId}/simulacoes/{id}/")
	@Produces("application/json")
	public Response obterSimulacaoEmprestimoConsignado(@PathParam("funcionarioId") Long funcionarioId, 
			@PathParam("solicitacaoId") Long solicitacaoId, @PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);
		SimulacaoEmprestimoConsignado simulacao = simulacaoEmprestimoConsignadoService.buscarPorId(solicitacaoId);
		return ok(simulacao);
	}

	@POST() @Consumes("application/json")
	@Path("/funcionarios/{funcionarioId}/solicitacoes-emprestimo-consignado/{solicitacaoId}/simulacoes/")
	@Produces("application/json")
	public Response criarSimulacaoEmprestimoConsignado(@PathParam("funcionarioId") Long funcionarioId, 
			@PathParam("solicitacaoId") Long solicitacaoId, 
			SimulacaoEmprestimoConsignadoTO simulacaoEmprestimoConsignadoTO, @HeaderParam("token") String token) {
		validarToken(token);
		SimulacaoEmprestimoConsignado simulacao = new SimulacaoEmprestimoConsignado(simulacaoEmprestimoConsignadoTO);
		simulacao = simulacaoEmprestimoConsignadoService.salvar(simulacao);
		return ok(simulacao);
	}

	@PUT() @Consumes("application/json")
	@Path("/funcionarios/{funcionarioId}/solicitacoes-emprestimo-consignado/{solicitacaoId}/simulacoes/{id}/")
	@Produces("application/json")
	public Response alterarSimulacaoEmprestimoConsignado(@PathParam("funcionarioId") Long funcionarioId, 
			@PathParam("solicitacaoId") Long solicitacaoId, @PathParam("id") Long id, 
			SimulacaoEmprestimoConsignadoTO simulacaoEmprestimoConsignadoTO, @HeaderParam("token") String token) {
		validarToken(token);

		SimulacaoEmprestimoConsignado simulacao = simulacaoEmprestimoConsignadoService.buscarPorId(solicitacaoId);
		if (simulacao == null) {
			return notFound();
		}
		
		simulacao.alterar(simulacaoEmprestimoConsignadoTO);
		simulacao = simulacaoEmprestimoConsignadoService.salvar(simulacao);
		return ok(simulacao);
	}

	@DELETE()
	@Path("/funcionarios/{funcionarioId}/solicitacoes-emprestimo-consignado/{solicitacaoId}/simulacoes/{id}/")
	@Produces("application/json")
	public Response removerSimulacaoEmprestimoConsignado(@PathParam("funcionarioId") Long funcionarioId, 
			@PathParam("solicitacaoId") Long solicitacaoId, @PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);

		SimulacaoEmprestimoConsignado simulacao = simulacaoEmprestimoConsignadoService.buscarPorId(solicitacaoId);
		if (simulacao == null) {
			return notFound();
		}
		
		simulacaoEmprestimoConsignadoService.excluir(simulacao);
		return ok();
	}
	
	@POST()
	@Path("/aprovacao-simulacao-emprestimo-consignado/{simulacaoId}/")
	@Produces("application/json")
	public Response aprovarSimulacaoEmprestimoConsignado(@PathParam("simulacaoId") Long simulacaoId, 
			@FormParam("observacoes") String observacoes, @HeaderParam("token") String token) {
		validarToken(token);

		SimulacaoEmprestimoConsignado simulacao = simulacaoEmprestimoConsignadoService.buscarPorId(simulacaoId);
		if (simulacao == null) {
			return notFound();
		}
		
		simulacao.aprovar(observacoes);
		simulacao = simulacaoEmprestimoConsignadoService.salvar(simulacao);
		return ok(simulacao);
	}

	@POST()
	@Path("/recusa-simulacao-emprestimo-consignado/{simulacaoId}/")
	@Produces("application/json")
	public Response recusarSimulacaoEmprestimoConsignado(@PathParam("simulacaoId") Long simulacaoId, 
			@FormParam("observacoes") String observacoes, @HeaderParam("token") String token) {
		validarToken(token);

		SimulacaoEmprestimoConsignado simulacao = simulacaoEmprestimoConsignadoService.buscarPorId(simulacaoId);
		if (simulacao == null) {
			return notFound();
		}
		
		simulacao.recusar(observacoes);
		simulacao = simulacaoEmprestimoConsignadoService.salvar(simulacao);
		return ok(simulacao);
	}

	@POST()
	@Path("/mudanca-situcao-simulacao-emprestimo-consignado/{simulacaoId}/")
	@Produces("application/json")
	public Response definirSituacaoSimulacaoEmprestimoConsignado(@PathParam("simulacaoId") Long simulacaoId, 
			@FormParam("parecer") String parecer, 
			@FormParam("situacao") SituacaoSimulacaoEmprestimoConsignado situacao, 
			@HeaderParam("token") String token) {
		validarToken(token);

		SimulacaoEmprestimoConsignado simulacao = simulacaoEmprestimoConsignadoService.buscarPorId(simulacaoId);
		if (simulacao == null) {
			return notFound();
		}
		
		simulacao.definirSituacaoSimulacaoEmprestimoConsignado(situacao, parecer);
		simulacao = simulacaoEmprestimoConsignadoService.salvar(simulacao);
		return ok(simulacao);
	}

	@GET()
	@Path("/funcionarios/{funcionarioId}/aprovacoes-emprestimos-consignados/")
	@Produces("application/json")
	public Response listarAprovacaoEmprestimoConsignado(@PathParam("funcionarioId") Long funcionarioId, 
			@HeaderParam("token") String token) {
		validarToken(token);
		List<AprovacaoEmprestimoConsignado> aprovacoes = aprovacaoEmprestimoConsignadoService.buscarPorFuncionario(funcionarioId);
		return ok(aprovacoes);
	}

	@GET()
	@Path("/funcionarios/{funcionarioId}/aprovacoes-emprestimos-consignados/{id}/")
	@Produces("application/json")
	public Response obterAprovacaoEmprestimoConsignado(@PathParam("funcionarioId") Long funcionarioId, 
			@PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);
		AprovacaoEmprestimoConsignado aprovacaoEmprestimoConsignado = aprovacaoEmprestimoConsignadoService.buscarPorId(id);
		return ok(aprovacaoEmprestimoConsignado);
	}

	@POST() @Consumes("application/json")
	@Path("/funcionarios/{funcionarioId}/aprovacoes-emprestimos-consignados/")
	@Produces("application/json")
	public Response criarAprovacaoEmprestimoConsignado(@PathParam("funcionarioId") Long funcionarioId, 
			AprovacaoEmprestimoConsignadoTO aprovacaoEmprestimoConsignadoTO,
			@HeaderParam("token") String token) {
		validarToken(token);
		AprovacaoEmprestimoConsignado aprovacaoEmprestimoConsignado = new AprovacaoEmprestimoConsignado(aprovacaoEmprestimoConsignadoTO);
		aprovacaoEmprestimoConsignado = aprovacaoEmprestimoConsignadoService.salvar(aprovacaoEmprestimoConsignado);
		return ok(aprovacaoEmprestimoConsignado);
	}

	@PUT() @Consumes("application/json")
	@Path("/funcionarios/{funcionarioId}/aprovacoes-emprestimos-consignados/{id}/")
	@Produces("application/json")
	public Response alterarAprovacaoEmprestimoConsignado(@PathParam("funcionarioId") Long funcionarioId, 
			@PathParam("id") Long id, AprovacaoEmprestimoConsignadoTO aprovacaoEmprestimoConsignadoTO, 
			@HeaderParam("token") String token) {
		validarToken(token);

		AprovacaoEmprestimoConsignado aprovacaoEmprestimoConsignado = aprovacaoEmprestimoConsignadoService.buscarPorId(id);
		if (aprovacaoEmprestimoConsignado == null) {
			return notFound();
		}
		
		aprovacaoEmprestimoConsignado.alterar(aprovacaoEmprestimoConsignadoTO);
		aprovacaoEmprestimoConsignado = aprovacaoEmprestimoConsignadoService.salvar(aprovacaoEmprestimoConsignado);
		return ok(aprovacaoEmprestimoConsignado);
	}

	@DELETE()
	@Path("/funcionarios/{funcionarioId}/aprovacoes-emprestimos-consignados/{id}/")
	@Produces("application/json")
	public Response removerAprovacaoEmprestimoConsignado(@PathParam("funcionarioId") Long funcionarioId, 
			@PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);
		
		AprovacaoEmprestimoConsignado aprovacaoEmprestimoConsignado = aprovacaoEmprestimoConsignadoService.buscarPorId(id);
		if (aprovacaoEmprestimoConsignado == null) {
			return notFound();
		}
		
		aprovacaoEmprestimoConsignadoService.excluir(aprovacaoEmprestimoConsignado);
		return ok();
	}
	
	@POST()
	@Path("/averbacao-aprovacao-emprestimo-consignado/{aprovacaoId}/")
	@Produces("application/json")
	public Response averbarAprovacaoEmprestimoConsignado(@PathParam("aprovacaoId") Long aprovacaoId, 
			@FormParam("observacoes") String observacoes, @HeaderParam("token") String token) {
		validarToken(token);

		AprovacaoEmprestimoConsignado aprovacaoEmprestimoConsignado = aprovacaoEmprestimoConsignadoService.buscarPorId(aprovacaoId);
		if (aprovacaoEmprestimoConsignado == null) {
			return notFound();
		}
		
		aprovacaoEmprestimoConsignado.averbar(observacoes);
		aprovacaoEmprestimoConsignado = aprovacaoEmprestimoConsignadoService.salvar(aprovacaoEmprestimoConsignado);
		return ok(aprovacaoEmprestimoConsignado);
	}

	@POST()
	@Path("/indeferimento-aprovacao-emprestimo-consignado/{aprovacaoId}/")
	@Produces("application/json")
	public Response indeferirAprovacaoEmprestimoConsignado(@PathParam("aprovacaoId") Long aprovacaoId, 
			@FormParam("observacoes") String observacoes, @HeaderParam("token") String token) {
		validarToken(token);

		AprovacaoEmprestimoConsignado aprovacaoEmprestimoConsignado = aprovacaoEmprestimoConsignadoService.buscarPorId(aprovacaoId);
		if (aprovacaoEmprestimoConsignado == null) {
			return notFound();
		}
		
		aprovacaoEmprestimoConsignado.indeferir(observacoes);
		aprovacaoEmprestimoConsignado = aprovacaoEmprestimoConsignadoService.salvar(aprovacaoEmprestimoConsignado);
		return ok(aprovacaoEmprestimoConsignado);
	}

	@POST()
	@Path("/mudanca-situacao-aprovacao-emprestimo-consignado/{aprovacaoId}/")
	@Produces("application/json")
	public Response definirSituacaoAprovacaoEmprestimoConsignado(@PathParam("aprovacaoId") Long aprovacaoId,
			@FormParam("observacoes") String observacoes, 
			@FormParam("situacao") SituacaoAprovacaoEmprestimoConsignado situacao, 
			@HeaderParam("token") String token) {
		validarToken(token);

		AprovacaoEmprestimoConsignado aprovacaoEmprestimoConsignado = aprovacaoEmprestimoConsignadoService.buscarPorId(aprovacaoId);
		if (aprovacaoEmprestimoConsignado == null) {
			return notFound();
		}
		
		aprovacaoEmprestimoConsignado.definirSituacaoAprovacaoEmprestimoConsignado(observacoes, situacao);
		aprovacaoEmprestimoConsignado = aprovacaoEmprestimoConsignadoService.salvar(aprovacaoEmprestimoConsignado);
		return ok(aprovacaoEmprestimoConsignado);
	}

	@GET()
	@Path("/funcionarios/{funcionarioId}/emprestimos-consignados/")
	@Produces("application/json")
	public Response listarEmprestimoConsignado(@PathParam("funcionarioId") Long funcionarioId, 
			@HeaderParam("token") String token) {
		validarToken(token);
		List<EmprestimoConsignado> emprestimosConsignado = emprestimoConsignadoService.buscarPorFuncionario(funcionarioId);
		return ok(emprestimosConsignado);
	}

	@GET()
	@Path("/funcionarios/{funcionarioId}/emprestimos-consignados/{id}/")
	@Produces("application/json")
	public Response obterEmprestimoConsignado(@PathParam("funcionarioId") Long funcionarioId, @PathParam("id") Long id, 
			@HeaderParam("token") String token) {
		validarToken(token);
		EmprestimoConsignado emprestimoConsignado = emprestimoConsignadoService.buscarPorId(id);
		return ok(emprestimoConsignado);
	}

	@POST() @Consumes("application/json")
	@Path("/funcionarios/{funcionarioId}/emprestimos-consignados/")
	@Produces("application/json")
	public Response criarEmprestimoConsignado(@PathParam("funcionarioId") Long funcionarioId, 
			EmprestimoConsignadoTO emprestimoConsignadoTO, @HeaderParam("token") String token) {
		validarToken(token);
		EmprestimoConsignado emprestimoConsignado = new EmprestimoConsignado(emprestimoConsignadoTO);
		emprestimoConsignado = emprestimoConsignadoService.salvar(emprestimoConsignado);
		return ok(emprestimoConsignado);
	}

	@PUT() @Consumes("application/json")
	@Path("/funcionarios/{funcionarioId}/emprestimos-consignados/{id}/")
	@Produces("application/json")
	public Response alterarEmprestimoConsignado(@PathParam("funcionarioId") Long funcionarioId, 
			@PathParam("id") Long id, EmprestimoConsignadoTO emprestimoConsignadoTO, @HeaderParam("token") String token) {
		validarToken(token);

		EmprestimoConsignado emprestimoConsignado = emprestimoConsignadoService.buscarPorId(id);
		if (emprestimoConsignado == null) {
			return notFound();
		}
		
		emprestimoConsignado.alterar(emprestimoConsignadoTO);
		emprestimoConsignado = emprestimoConsignadoService.salvar(emprestimoConsignado);
		return ok(emprestimoConsignado);
	}

	@DELETE()
	@Path("/funcionarios/{funcionarioId}/emprestimos-consignados/{id}/")
	@Produces("application/json")
	public Response removerEmprestimoConsignado(@PathParam("funcionarioId") Long funcionarioId, @PathParam("id") Long id, 
			@HeaderParam("token") String token) {
		validarToken(token);

		EmprestimoConsignado emprestimoConsignado = emprestimoConsignadoService.buscarPorId(id);
		if (emprestimoConsignado == null) {
			return notFound();
		}
		
		emprestimoConsignadoService.excluir(emprestimoConsignado);
		return ok();
	}
	
	@POST() @Consumes("application/json")
	@Path("/quitacaoEmprestimoConsignado/{emprestimoConsignadoId}/")
	@Produces("application/json")
	public Response quitarEmprestimoConsignado(@PathParam("emprestimoConsignadoId") Long emprestimoConsignadoId, 
			QuitacaoEmprestimoConsignadoTO quitacaoEmprestimoConsignadoTO, @HeaderParam("token") String token) {
		validarToken(token);

		EmprestimoConsignado emprestimoConsignado = emprestimoConsignadoService.buscarPorId(emprestimoConsignadoId);
		if (emprestimoConsignado == null) {
			return notFound();
		}
		
		emprestimoConsignado.quitar(quitacaoEmprestimoConsignadoTO);
		emprestimoConsignado = emprestimoConsignadoService.salvar(emprestimoConsignado);
		return ok(emprestimoConsignado);
	}

	@POST() @Consumes("application/json")
	@Path("/renegociacaoEmprestimoConsignado/{emprestimoConsignadoId}/")
	@Produces("application/json")
	public Response renegociarEmprestimoConsignado(@PathParam("emprestimoConsignadoId") Long emprestimoConsignadoId, 
			RenegociacaoEmprestimoConsignadoTO renegociacaoEmprestimoConsignadoTO,
			@HeaderParam("token") String token) {
		validarToken(token);

		EmprestimoConsignado emprestimoConsignado = emprestimoConsignadoService.buscarPorId(emprestimoConsignadoId);
		if (emprestimoConsignado == null) {
			return notFound();
		}
		
		emprestimoConsignado.renegociar(renegociacaoEmprestimoConsignadoTO);
		emprestimoConsignado = emprestimoConsignadoService.salvar(emprestimoConsignado);
		return ok(emprestimoConsignado);
	}

	@POST() @Consumes("application/json")
	@Path("/mudancaSituacaoEmprestimoConsignado/{emprestimoConsignadoId}/")
	@Produces("application/json")
	public Response definirSituacaoEmprestimoConsignado(@PathParam("emprestimoConsignadoId") Long emprestimoConsignadoId, 
			MudancaSituacaoEmprestimoConsignadoTO mudancaSituacaoEmprestimoConsignadoTO, @HeaderParam("token") String token) {
		validarToken(token);

		EmprestimoConsignado emprestimoConsignado = emprestimoConsignadoService.buscarPorId(emprestimoConsignadoId);
		if (emprestimoConsignado == null) {
			return notFound();
		}
		
		emprestimoConsignado.definirSituacaoEmprestimoConsignado(mudancaSituacaoEmprestimoConsignadoTO);
		emprestimoConsignado = emprestimoConsignadoService.salvar(emprestimoConsignado);
		return ok(emprestimoConsignado);
	}

	@GET()
	@Path("/funcionarios/{funcionarioId}/emprestimos-consignados/{emprestimoId}/parcelas/")
	@Produces("application/json")
	public Response listarParcelasEmprestimoConsignado(@PathParam("funcionarioId") Long funcionarioId, 
			@PathParam("emprestimoId") Long emprestimoId, @HeaderParam("token") String token) {
		validarToken(token);
		List<ParcelaEmprestimoConsignado> parcelas = parcelaEmprestimoConsignadoService.buscarPorEmprestimo(emprestimoId);
		return ok(parcelas);
	}

	@GET()
	@Path("/funcionarios/{funcionarioId}/emprestimos-consignados/{emprestimoId}/parcelas/{id}/")
	@Produces("application/json")
	public Response obterParcelaEmprestimoConsignado(@PathParam("funcionarioId") Long funcionarioId, 
			@PathParam("emprestimoId") Long emprestimoId, @PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);
		ParcelaEmprestimoConsignado parcela = parcelaEmprestimoConsignadoService.buscarPorId(id);
		return ok(parcela);
	}

	@POST() @Consumes("application/json")
	@Path("/geracaoParcelasEmprestimoConsignado/{emprestimoId}/")
	@Produces("application/json")
	public Response gerarParcelasEmprestimoConsignado(@PathParam("emprestimoId") Long emprestimoId, 
			@HeaderParam("token") String token) {
		validarToken(token);
		Object o = null; // TODO revisar, creio que precise de outras informações
		return ok(o);
	}

	@POST() @Consumes("application/json")
	@Path("/funcionarios/{funcionarioId}/emprestimos-consignados/{emprestimoId}/parcelas/")
	@Produces("application/json")
	public Response criarParcelaEmprestimoConsignado(@PathParam("funcionarioId") Long funcionarioId, 
			@PathParam("emprestimoId") Long emprestimoId, ParcelaEmprestimoConsignadoTO parcelaEmprestimoConsignadoTO,
			@HeaderParam("token") String token) {
		validarToken(token);
		ParcelaEmprestimoConsignado parcelaEmprestimoConsignado = new ParcelaEmprestimoConsignado(parcelaEmprestimoConsignadoTO);
		parcelaEmprestimoConsignado = parcelaEmprestimoConsignadoService.salvar(parcelaEmprestimoConsignado);
		return ok(parcelaEmprestimoConsignado);
	}

	@PUT() @Consumes("application/json")
	@Path("/funcionarios/{funcionarioId}/emprestimos-consignados/{emprestimoId}/parcelas/{id}/")
	@Produces("application/json")
	public Response alterarParcelaEmprestimoConsignado(@PathParam("funcionarioId") Long funcionarioId, 
			@PathParam("emprestimoId") Long emprestimoId, @PathParam("id") Long id, 
			ParcelaEmprestimoConsignadoTO parcelaEmprestimoConsignadoTO, @HeaderParam("token") String token) {
		validarToken(token);

		ParcelaEmprestimoConsignado parcelaEmprestimoConsignado = parcelaEmprestimoConsignadoService.buscarPorId(id);
		if (parcelaEmprestimoConsignado == null) {
			return notFound();
		}
		
		parcelaEmprestimoConsignado.alterar(parcelaEmprestimoConsignadoTO);
		parcelaEmprestimoConsignado = parcelaEmprestimoConsignadoService.salvar(parcelaEmprestimoConsignado);
		return ok(parcelaEmprestimoConsignado);
	}

	@DELETE()
	@Path("/funcionarios/{funcionarioId}/emprestimos-consignados/{emprestimoId}/parcelas/{id}/")
	@Produces("application/json")
	public Response removerParcelaEmprestimoConsignado(@PathParam("funcionarioId") Long funcionarioId, 
			@PathParam("emprestimoId") Long emprestimoId, @PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);

		ParcelaEmprestimoConsignado parcelaEmprestimoConsignado = parcelaEmprestimoConsignadoService.buscarPorId(id);
		if (parcelaEmprestimoConsignado == null) {
			return notFound();
		}
		
		parcelaEmprestimoConsignadoService.excluir(parcelaEmprestimoConsignado);
		return ok();
	}
	
	@POST() @Consumes("application/json")
	@Path("/pagamento-parcela-emprestimo-consignado/{parcelaId}/")
	@Produces("application/json")
	public Response pagarParcelaEmprestimoConsignado(@PathParam("parcelaId") Long parcelaId, 
			PagamentoParcelaEmprestimoConsignadoTO pagamentoParcelaEmprestimoConsignadoTO, 
			@HeaderParam("token") String token) {
		validarToken(token);

		ParcelaEmprestimoConsignado parcelaEmprestimoConsignado = parcelaEmprestimoConsignadoService.buscarPorId(parcelaId);
		if (parcelaEmprestimoConsignado == null) {
			return notFound();
		}
		
		//TODO Revisar pagamentoParcelaEmprestimoConsignadoTO
		parcelaEmprestimoConsignado.pagar(pagamentoParcelaEmprestimoConsignadoTO);
		parcelaEmprestimoConsignado = parcelaEmprestimoConsignadoService.salvar(parcelaEmprestimoConsignado);
		return ok(parcelaEmprestimoConsignado);
	}

	@POST() @Consumes("application/json")
	@Path("/estorno-parcela-emprestimo-consignado/{parcelaId}/")
	@Produces("application/json")
	public Response estornarParcelaEmprestimoConsignado(@PathParam("parcelaId") Long parcelaId, 
			EstornoParcelaEmprestimoConsignadoTO estornoParcelaEmprestimoConsignadoTO, 
			@HeaderParam("token") String token) {
		validarToken(token);

		ParcelaEmprestimoConsignado parcelaEmprestimoConsignado = parcelaEmprestimoConsignadoService.buscarPorId(parcelaId);
		if (parcelaEmprestimoConsignado == null) {
			return notFound();
		}
		
		//TODO Revisar pagamentoParcelaEmprestimoConsignadoTO
		parcelaEmprestimoConsignado.estonar(estornoParcelaEmprestimoConsignadoTO);
		parcelaEmprestimoConsignado = parcelaEmprestimoConsignadoService.salvar(parcelaEmprestimoConsignado);
		return ok(parcelaEmprestimoConsignado);
	}

	@POST() @Consumes("application/json")
	@Path("/cancelamento-parcela-emprestimo-consignado/{parcelaId}/")
	@Produces("application/json")
	public Response cancelarParcelaEmprestimoConsignado(@PathParam("parcelaId") Long parcelaId, 
			@HeaderParam("token") String token) {
		validarToken(token);

		ParcelaEmprestimoConsignado parcelaEmprestimoConsignado = parcelaEmprestimoConsignadoService.buscarPorId(parcelaId);
		if (parcelaEmprestimoConsignado == null) {
			return notFound();
		}
		
		parcelaEmprestimoConsignado.cancelar();
		parcelaEmprestimoConsignado = parcelaEmprestimoConsignadoService.salvar(parcelaEmprestimoConsignado);
		return ok(parcelaEmprestimoConsignado);
	}

	@POST() @Consumes("application/json")
	@Path("/mudanca-situacao-parcela-emprestimo-consignado/{parcelaId}/")
	@Produces("application/json")
	public Response definirSituacaoParcelaEmprestimoConsignado(@PathParam("parcelaId") Long parcelaId,
			MudancaSituacaoParcelaEmprestimoConsignadoTO mudancaSituacaoParcelaEmprestimoConsignadoTO,
			@HeaderParam("token") String token) {
		validarToken(token);

		ParcelaEmprestimoConsignado parcelaEmprestimoConsignado = parcelaEmprestimoConsignadoService.buscarPorId(parcelaId);
		if (parcelaEmprestimoConsignado == null) {
			return notFound();
		}
		
		parcelaEmprestimoConsignado.definirSituacaoParcelaEmprestimoConsignado(mudancaSituacaoParcelaEmprestimoConsignadoTO);
		parcelaEmprestimoConsignado = parcelaEmprestimoConsignadoService.salvar(parcelaEmprestimoConsignado);
		return ok(parcelaEmprestimoConsignado);
	}

}