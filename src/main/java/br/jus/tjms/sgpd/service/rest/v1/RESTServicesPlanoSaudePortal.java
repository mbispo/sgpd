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

import br.jus.tjms.sgpd.entity.OperadoraPlanoSaude;
import br.jus.tjms.sgpd.entity.PlanoSaude;
import br.jus.tjms.sgpd.entity.RubricaPlanoSaude;
import br.jus.tjms.sgpd.enumerators.SituacaoPessoaInclusaContratoPlanoSaude;
import br.jus.tjms.sgpd.service.ServicesPortal;
import br.jus.tjms.sgpd.service.planosaudeservices.OperadoraPlanoSaudeService;
import br.jus.tjms.sgpd.service.planosaudeservices.PlanoSaudeService;
import br.jus.tjms.sgpd.service.rest.v1.to.ContratoPlanoSaudeTO;
import br.jus.tjms.sgpd.service.rest.v1.to.OperadoraPlanoSaudeTO;
import br.jus.tjms.sgpd.service.rest.v1.to.PlanoSaudeTO;
import br.jus.tjms.sgpd.service.rest.v1.to.RubricaPlanoSaudeTO;

/**
 * @version 1.0
 * @created 11-dez-2015 18:15:46
 */
public class RESTServicesPlanoSaudePortal extends RESTServicesBasePortalV1 implements ServicesPortal {

	private static final long serialVersionUID = -9196467754367961644L;
	
	@EJB
	OperadoraPlanoSaudeService operadoraPlanoSaudeService;
	
	@EJB
	PlanoSaudeService planoSaudeService;
	
	/*
		planos de saúde
		
		#PlanoSaude:
		listarPlanosDeSaude							GET		/operadoras-plano-saude/1/planos/
		pesquisarPlanosDeSaude						GET		/pesquisas/operadoras-plano-saude/planos/nome
		obterPlanoDeSaude							GET		/operadoras-plano-saude/1/planos/1
		criarPlanoDeSaude							POST	/operadoras-plano-saude/1/planos/...
		alterarPlanoDeSaude							PUT		/operadoras-plano-saude/1/planos/1/...
		removerPlanoDeSaude							DELETE	/operadoras-plano-saude/1/planos/1
		
		#RubricaPlanoSaude:
		listarRubricasPlanoDeSaude					GET		/operadoras-plano-saude/1/planos/1/rubricas/
		obterRubricaPlanoDeSaude					GET		/operadoras-plano-saude/1/planos/1/rubricas/1					
		vincularRubricaAoPlanoDeSaude				POST	/operadoras-plano-saude/1/planos/1/rubricas/...
		desvincularRubricaDoPlanoDeSaude			DELETE	/operadoras-plano-saude/1/planos/1/rubricas/1
		
		#OperadoraPlanoSaude:
		listarOperadoraPlanoSaude					GET		/operadoras-plano-saude/
		pesquisarOperadoraPlanoSaude				GET		/pesquisas/operadoras-plano-saude/nome/
		obterOperadoraPlanoSaude					GET		/operadoras-plano-saude/1
		criarOperadoraPlanoSaude					POST	/operadoras-plano-saude/...
		alterarOperadoraPlanoSaude					PUT		/operadoras-plano-saude/1/...
		removerOperadoraPlanoSaude					DELETE	/operadoras-plano-saude/1
		
		#ContratoPlanoSaude:
		listarContratoPlanoSaudePorPlano					GET		/operadoras-plano-saude/1/planos/1/contratos-plano-saude/
		listarContratoPlanoSaudePorResponsavelFinanceiro	GET		/funcionarios/1/contratos-plano-saude/
		pesquisarContratoPlanoSaude							GET		/pesquisas/contratos-plano-saude/...
		obterContratoPlanoSaude								GET		/funcionarios/1/contratos-plano-saude/1
		criarContratoPlanoSaude								POST	/funcionarios/1/contratos-plano-saude/...
		atualizarContratoPlanoSaude							PUT		/funcionarios/1/contratos-plano-saude/1/...
		removerContratoPlanoSaude							DELETE	/funcionarios/1/contratos-plano-saude/1
		
		#PessoaInclusaContratoPlanoSaude:
		listarPessoasInclusasNoContratoPlanoSaude			GET		/funcionarios/1/contratos-plano-saude/1/pessoas-inclusas/
		obterPessoaInclusaContratoPlanoSaude				GET		/funcionarios/1/contratos-plano-saude/1/pessoas-inclusas/1
		incluirPessoaNoContratoPlanoSaude					POST	/funcionarios/1/contratos-plano-saude/1/pessoas-inclusas/...
		removerPessoaDoContratoPlanoSaude					DELETE	/funcionarios/1/contratos-plano-saude/1/pessoas-inclusas/1
		definirSituacaoDaPessoaNoContratoPlanoSaude			POST	/mudanca-situacao-pessoa-inclusa-contrato-plano-saude/1/...

	 */

	@GET()
	@Path("/operadoras-plano-saude/{operadoraId}/planos/")
	@Produces("application/json")
	public Response listarPlanosDeSaude(@PathParam("operadoraId") Long operadoraId, @HeaderParam("token") String token) {
		validarToken(token);
		List<PlanoSaude> planos = operadoraPlanoSaudeService.listarPlanosDaOperadora(operadoraId);
		return ok(planos);
	}

	@GET()
	@Path("/pesquisas/operadoras-plano-saude/planos/descricao/{descricao}")
	@Produces("application/json")
	public Response pesquisarPlanosDeSaude(@PathParam("descricao") String descricao, @HeaderParam("token") String token) {
		validarToken(token);
		List<PlanoSaude> planos = operadoraPlanoSaudeService.buscarPlanosPorDescricao(descricao);
		return ok(planos);
	}

	@GET()
	@Path("/operadoras-plano-saude/{operadoraId}/planos/{id}/")
	@Produces("application/json")
	public Response obterPlanoDeSaude(@PathParam("operadoraId") Long operadoraId, @PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);
		Object o = planoSaudeService.buscarPorId(id);
		return ok(o);
	}

	@POST()
	@Path("/operadoras-plano-saude/{operadoraId}/planos/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response criarPlanoDeSaude(@PathParam("operadoraId") Long operadoraId, PlanoSaudeTO planoSaudeTO, @HeaderParam("token") String token) {
		validarToken(token);		
		PlanoSaude plano = planoSaudeService.criarPlanoSaude(operadoraId,planoSaudeTO);
		return ok(plano);
	}

	@PUT()
	@Path("/operadoras-plano-saude/{operadoraId}/planos/{id}/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response alterarPlanoDeSaude(@PathParam("operadoraId") Long operadoraId, @PathParam("id") Long id, 
			PlanoSaudeTO planoSaudeTO, @HeaderParam("token") String token) {
		validarToken(token);
		PlanoSaude plano = planoSaudeService.alterarPlanoSaude(operadoraId,planoSaudeTO);
		return ok(plano);
	}

	@DELETE()
	@Path("/operadoras-plano-saude/{operadoraId}/planos/{id}/")
	@Produces("application/json")
	public Response removerPlanoDeSaude(@PathParam("operadoraId") Long operadoraId, @PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);
		PlanoSaude plano = planoSaudeService.buscarPorId(id);
		planoSaudeService.excluir(plano);
		return ok();
	}

	@GET()
	@Path("/operadoras-plano-saude/{operadoraId}/planos/{id}/rubricas/")
	@Produces("application/json")
	public Response listarRubricasPlanoDeSaude(@PathParam("operadoraId") Long operadoraId, @PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);
		List<RubricaPlanoSaude> o = planoSaudeService.listarRubricasPlanoDeSaude(operadoraId, id);
		return ok(o);
	}
	
	@GET()
	@Path("/operadoras-plano-saude/{operadoraId}/planos/{planoId}/rubricas/{id}/")
	@Produces("application/json")
	public Response obterRubricaPlanoDeSaude(@PathParam("operadoraId") Long operadoraId, @PathParam("planoId") Long planoId, 
			@PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);
		// TODO chamada de service
		// HELLO ME, ITS ME AGAIN
		Object o = null;
		return ok(o);
	}

	@POST()
	@Path("/operadoras-plano-saude/{operadoraId}/planos/{planoId}/rubricas/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response vincularRubricaAoPlanoDeSaude(@PathParam("operadoraId") Long operadoraId, @PathParam("planoId") Long planoId, 
			RubricaPlanoSaudeTO rubricaPlanoSaudeTO, @HeaderParam("token") String token) {
		validarToken(token);
		// TODO chamada de service
		Object o = null;
		return ok(o);
	}
	
	@DELETE()
	@Path("/operadoras-plano-saude/{operadoraId}/planos/{planoId}/rubricas/{id}/")
	@Produces("application/json")
	public Response desvincularRubricaDoPlanoDeSaude(@PathParam("operadoraId") Long operadoraId, @PathParam("planoId") Long planoId,
			@PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);
		// TODO chamada de service
		Object o = null;
		return ok(o);
	}

	@GET()
	@Path("/operadoras-plano-saude/")
	@Produces("application/json")
	public Response listarOperadoraPlanoSaude(@HeaderParam("token") String token) {
		validarToken(token);
		// TODO chamada de service
		List<OperadoraPlanoSaude> o = operadoraPlanoSaudeService.buscarTodos();
		return ok(o);
	}

	@GET()
	@Path("/pesquisas/operadoras-plano-saude/nome/{nome}")
	@Produces("application/json")
	public Response pesquisarOperadoraPlanoSaude(@PathParam("nome") String nome, @HeaderParam("token") String token) {
		validarToken(token);
		// TODO chamada de service
		Object o = null;
		return ok(o);
	}

	@GET()
	@Path("/operadoras-plano-saude/{id}/")
	@Produces("application/json")
	public Response obterOperadoraPlanoSaude(@PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);
		Object o = operadoraPlanoSaudeService.buscarPorId(id);
		return ok(o);
	}

	@POST()
	@Path("/operadoras-plano-saude/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response criarOperadoraPlanoSaude(OperadoraPlanoSaudeTO operadoraPlanoSaudeTO, @HeaderParam("token") String token) {
		validarToken(token);
		// TODO chamada de service
		Object o = null;
		return ok(o);
	}

	@PUT()
	@Path("/operadoras-plano-saude/{id}/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response alterarOperadoraPlanoSaude(@PathParam("id") Long id, OperadoraPlanoSaudeTO operadoraPlanoSaudeTO, @HeaderParam("token") String token) {
		validarToken(token);
		// TODO chamada de service
		Object o = null;
		return ok(o);
	}

	@DELETE()
	@Path("/operadoras-plano-saude/{id}/")
	@Produces("application/json")
	public Response removerOperadoraPlanoSaude(@PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);
		// TODO chamada de service
		Object o = null;
		return ok(o);
	}

	@GET()
	@Path("/operadoras-plano-saude/{operadoraId}/planos/{planoId}/contratos-plano-saude/")
	@Produces("application/json")
	public Response listarContratoPlanoSaudePorPlano(@PathParam("operadoraId") Long operadoraId, @PathParam("planoId") Long planoId, @HeaderParam("token") String token) {
		validarToken(token);
		// TODO chamada de service
		Object o = null;
		return ok(o);
	}

	@GET()
	@Path("/funcionarios/{funcionarioId}/contratos-plano-saude/")
	@Produces("application/json")
	public Response listarContratoPlanoSaudePorResponsavelFinanceiro(@PathParam("funcionarioId") Long funcionarioId,
			@HeaderParam("token") String token) {
		validarToken(token);
		// TODO chamada de service
		Object o = null;
		return ok(o);
	}

	@GET()
	@Path("/funcionarios/{funcionarioId}/contratos-plano-saude/{id}/")
	@Produces("application/json")
	public Response obterContratoPlanoSaude(@PathParam("funcionarioId") Long funcionarioId, @PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);
		// TODO chamada de service
		Object o = null;
		return ok(o);
	}

	@POST()
	@Path("/funcionarios/{funcionarioId}/contratos-plano-saude/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response criarContratoPlanoSaude(@PathParam("funcionarioId") Long funcionarioId, ContratoPlanoSaudeTO contratoPlanoSaudeTO, @HeaderParam("token") String token) {
		validarToken(token);
		// TODO chamada de service
		Object o = null;
		return ok(o);
	}

	@PUT()
	@Path("/funcionarios/{funcionarioId}/contratos-plano-saude/{id}/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response atualizarContratoPlanoSaude(@PathParam("funcionarioId") Long funcionarioId, @PathParam("id") Long id, 
			ContratoPlanoSaudeTO contratoPlanoSaudeTO, @HeaderParam("token") String token) {
		validarToken(token);
		// TODO chamada de service
		Object o = null;
		return ok(o);
	}

	@DELETE()
	@Path("/funcionarios/{funcionarioId}/contratos-plano-saude/{contratoId}/")
	@Produces("application/json")
	public Response removerContratoPlanoSaude(@PathParam("funcionarioId") Long funcionarioId, 
			@PathParam("contratoId") Long contratoId, @HeaderParam("token") String token) {
		validarToken(token);
		// TODO chamada de service
		Object o = null;
		return ok(o);
	}

	@GET()
	@Path("/funcionarios/{funcionarioId}/contratos-plano-saude/{contratoId}/pessoas-inclusas/")
	@Produces("application/json")
	public Response listarPessoasInclusasNoContratoPlanoSaude(@PathParam("funcionarioId") Long funcionarioId, 
			@PathParam("contratoId") Long contratoId, @HeaderParam("token") String token) {
		validarToken(token);
		// TODO chamada de service
		Object o = null;
		return ok(o);
	}

	@GET()
	@Path("/funcionarios/{funcionarioId}/contratos-plano-saude/{contratoId}/pessoas-inclusas/{pessoaId}/")
	@Produces("application/json")
	public Response obterPessoaInclusaContratoPlanoSaude(@PathParam("funcionarioId") Long funcionarioId, 
			@PathParam("contratoId") Long contratoId, @PathParam("pessoaId") Long pessoaId, @HeaderParam("token") String token) {
		validarToken(token);
		// TODO chamada de service
		Object o = null;
		return ok(o);
	}

	@POST()
	@Path("/funcionarios/{funcionarioId}/contratos-plano-saude/{contratoId}/pessoas-inclusas/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response incluirPessoaNoContratoPlanoSaude(@PathParam("funcionarioId") Long funcionarioId, 
			@PathParam("contratoId") Long contratoId, @HeaderParam("token") String token) {
		validarToken(token);
		// TODO chamada de service
		Object o = null;
		return ok(o);
	}

	@DELETE()
	@Path("/funcionarios/{funcionarioId}/contratos-plano-saude/{contratoId}/pessoas-inclusas/{pessoaId}/")
	@Produces("application/json")
	public Response removerPessoaDoContratoPlanoSaude(@PathParam("funcionarioId") Long funcionarioId, 
			@PathParam("contratoId") Long contratoId, @PathParam("pessoaId") Long pessoaId, @HeaderParam("token") String token) {
		validarToken(token);
		// TODO chamada de service
		Object o = null;
		return ok(o);
	}

	@POST()
	@Path("/mudanca-situacao-pessoa-inclusa-contrato-plano-saude/contratos-plano-saude/{contratoId}/pessoas-inclusas/{pessoaId}/")
	@Produces("application/json")
	public Response definirSituacaoDaPessoaNoContratoPlanoSaude(
			@PathParam("contratoId") Long contratoId, @PathParam("pessoaId") Long pessoaId,
			@FormParam("situacao") SituacaoPessoaInclusaContratoPlanoSaude situacao, @FormParam("parecer") String parecer,			
			@HeaderParam("token") String token) {
		validarToken(token);
		// TODO chamada de service
		Object o = null;
		return ok(o);
	}

}