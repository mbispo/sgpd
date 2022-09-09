package br.jus.tjms.sgpd.service.rest.v1;

import br.jus.tjms.sgpd.entity.*;
import br.jus.tjms.sgpd.enumerators.TipoClassificacaoContabil;
import br.jus.tjms.sgpd.service.ServicesPortal;
import br.jus.tjms.sgpd.service.folhapagamentoservices.*;
import br.jus.tjms.sgpd.service.funcionarioservices.FuncionarioService;
import br.jus.tjms.sgpd.service.remuneracaoservices.*;
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
public class RESTServicesEstruturaCalculoFolhaPagamentoPortal extends RESTServicesBasePortalV1 implements ServicesPortal {

	private static final long serialVersionUID = -4199086868219247220L;
    private static Logger logger = LoggerFactory.getLogger(RESTServicesEstruturaCalculoFolhaPagamentoPortal.class);
	
	@EJB
	private FuncionarioService funcionarioService;
	
	@EJB
	private GrupoFormulaService grupoFormulaService;
	
	@EJB
	private FormulaService formulaService;
	
	@EJB
	private FormulaInputService formulaInputService;
	
	@EJB
	private FormulaOutputService formulaOutputService;
	
	@EJB
	private GrupoRubricaService grupoRubricaService;
	
	@EJB
	private RubricaService rubricaService;
	
	@EJB
	private RubricaParametroService rubricaParametroService;
	
	@EJB
	private RubricaFormulaService rubricaFormulaService;
	
	@EJB
	private RubricaBaseService rubricaBaseService;
	
	@EJB
	private RubricaUtilizaBaseCalculoService rubricaUtilizaBaseCalculoService;

	@EJB
	private LancamentoAgendadoService lancamentoAgendadoService;
	
	@EJB
	private LancamentoRecorrenteService lancamentoRecorrenteService;
	
	@EJB
	private LancamentoAvulsoService lancamentoAvulsoService;
	
	@EJB
	private RubricaFuncionarioService rubricaFuncionarioService;
	
	@EJB
	private RubricaCargoService rubricaCargoService;
	
	@EJB
	private RubricaTipoClassificacaoContabilService rubricaTipoClassificacaoContabilService;
	
	@EJB
	private RubricaCompoeBaseCalculoService rubricaCompoeBaseCalculoService;
	
	// Rubricas e fórmulas
	/*
	 * GrupoFormula:
	 * listarGrupoFormula							GET		/grupos-formula/
	 * obterGrupoFormula							GET		/grupos-formula/1
	 * criarGrupoFormula							POST	/grupos-formula/...
	 * alterarGrupoFormula							PUT		/grupos-formula/1/...
	 * removerGrupoFormula							DELETE	/grupos-formula/1
	 * 
	 * Formula:
	 * listarFormulas								GET		/formulas/
	 * listarFormulasPorGrupo						GET		/grupos-formula/1/formulas/
	 * pesquisarFormulasPorNome						GET		/pesquisas/formulas/nome/
	 * obterFormula									GET		/formulas/1
	 * criarFormula									POST	/formulas/...
	 * alterarFormula								PUT		/formulas/1/...
	 * removerFormula								DELETE	/formulas/1
	 * 
	 * FormulaInput:
	 * listarInputsDaFormula						GET		/formulas/1/inputs/
	 * obterFormulaInput							GET		/formulas/1/inputs/1
	 * criarFormulaInput							POST	/formulas/1/inputs/...
	 * alterarFormulaInput							PUT		/formulas/1/inputs/1/...
	 * removerFormulaInput							DELETE	/formulas/1/inputs/1
	 * 
	 * FormulaOutput:
	 * listarOutputsDaFormula						GET		/formulas/1/outputs/
	 * obterFormulaOutput							GET		/formulas/1/outputs/1
	 * criarFormulaOutput							POST	/formulas/1/outputs/...
	 * alterarFormulaOutput							PUT		/formulas/1/outputs/1/...
	 * removerFormulaOutput							DELETE	/formulas/1/outputs/1
	 * 
	 * GrupoRubrica:
	 * listarGrupoRubrica							GET		/grupos-rubrica/
	 * obterGrupoRubrica							GET		/grupos-rubrica/1
	 * criarGrupoRubrica							POST	/grupos-rubrica/...
	 * alterarGrupoRubrica							PUT		/grupos-rubrica/1/...
	 * removerGrupoRubrica							DELETE	/grupos-rubrica/1 
	 * 
	 * Rubrica:
	 * listarRubricas								GET		/rubricas/
	 * listarRubricasPorGrupo						GET		/grupos-rubrica/1/rubricas/
	 * pesquisarRubricasPorNome						GET		/pesquisas/rubricas/nome/
	 * obterRubrica									GET		/rubricas/1
	 * criarRubrica									POST	/rubricas/...
	 * alterarRubrica								PUT		/rubricas/1/...
	 * removerRubrica								DELETE	/rubricas/1
	 * 
	 * RubricaParametro:
	 * listarParametrosDaRubrica					GET		/rubricas/1/parametros/
	 * obterRubricaParametro						GET		/rubricas/1/parametros/1
	 * criarRubricaParametro						POST	/rubricas/1/parametros/...
	 * alterarRubricaParametro						PUT		/rubricas/1/parametros/1/...
	 * removerRubricaParametro						DELETE	/rubricas/1/parametros/1
	 * 
	 * RubricaFormula (fórmulas da rubrica): 
	 * listarFormulasDaRubrica						GET		/rubricas/1/formulas/
	 * vincularFormulaARubrica						POST	/rubricas/1/formulas/...
	 * desvincularFormulaDaRubrica					DELETE	/rubricas/1/formulas/1
	 * 
	 * RubricaBase:
	 * listarRubricasBasesDaRubrica					GET		/rubricas/1/rubricasBase/
	 * vincularRubricaBaseARubrica					POST	/rubricas/1/rubricasBase/...
	 * desvincularRubricaBaseDaRubrica				DELETE	/rubricas/1/rubricasBase/1
	 * 
	 * RubricaUtilizaBaseCalculo:
	 * listarTiposBaseCalculoUtilizadosPelaRubrica		GET		/rubricas/1/utiliza-tipos-base-calculo/
	 * vincularUtilizacaoTipoBaseCalculoARubrica		POST	/rubricas/1/utiliza-tipos-base-calculo/...
	 * desvincularUtilizacaoTipoBaseCalculoDaRubrica	DELETE	/rubricas/1/utiliza-tipos-base-calculo/1
	 * 
	 * RubricaCompoeBaseCalculo:
	 * listarComposicaoTiposBaseCalculoDaRubrica		GET		/rubricas/1/compoe-tipos-base-calculo/
	 * vincularComposicaoTipoBaseCalculoARubrica		POST	/rubricas/1/compoe-tipos-base-calculo/...
	 * desvincularComposicaoTipoBaseCalculoDaRubrica	DELETE	/rubricas/1/compoe-tipos-base-calculo/1
	 * 
	 * RubricaTipoClassificacaoContabil:
	 * listarTipoClassificacaoContabilDaRubrica			GET		/rubricas/1/tipos-classificacao-contabil/
	 * vincularTipoClassificacaoContabilARubrica		POST	/rubricas/1/tipos-classificacao-contabil/...
	 * desvincularTipoClassificacaoContabilDaRubrica	DELETE	/rubricas/1/tipos-classificacao-contabil/1
	 *
	 * Rubricas do funcionário:
	 * 
	 * listarRubricasDoFuncionario					GET		/funcionarios/1/rubricas/					
	 * obterRubricaDoFuncionario					GET		/funcionarios/1/rubricas/1
	 * adicionarRubricaDoFuncionario				POST	/funcionarios/1/rubricas/...
	 * alterarRubricaDoFuncionario					PUT		/funcionarios/1/rubricas/1/...
	 * removerRubricaDoFuncionario					DELETE	/funcionarios/1/rubricas/1
	 * 
	 * 
	 * Lançamentos avulsos/agendados/recorrentes:
	 * 
	 * listarLancamentosAvulsosDoFuncionario		GET		/funcionarios/1/lancamentos-avulsos/
	 * obterLancamentoAvulso						GET		/funcionarios/1/lancamentos-avulsos/1
	 * adicionarLancamentoAvulso					POST	/funcionarios/1/lancamentos-avulsos/...
	 * alterarLancamentoAvulso						PUT		/funcionarios/1/lancamentos-avulsos/1/...
	 * removerLancamentoAvulso						DELETE	/funcionarios/1/lancamentos-avulsos/1
	 * pagarLancamentoAvulso						POST	/pagamento-lancamento-avulso/1/...
	 * 
	 * listarLancamentosAgendadosDoFuncionario		GET		/funcionarios/1/lancamentos-agendados/
	 * obterLancamentoAgendado						GET		/funcionarios/1/lancamentos-agendados/1
	 * adicionarLancamentoAgendado					POST	/funcionarios/1/lancamentos-agendados/... 
	 * alterarLancamentoAgendado					PUT		/funcionarios/1/lancamentos-agendados/1/...
	 * removerLancamentoAgendado					DELETE	/funcionarios/1/lancamentos-agendados/1
	 * pagarLancamentoAgendado						POST	/pagamento-lancamento-agendado/1/...
	 * 
	 * listarLancamentosRecorrentesDoFuncionario	GET		/funcionarios/1/lancamentos-recorrentes/
	 * obterLancamentoRecorrente					GET		/funcionarios/1/lancamentos-recorrentes/1
	 * adicionarLancamentoRecorrente				POST	/funcionarios/1/lancamentos-recorrentes/... 
	 * alterarLancamentoRecorrente					PUT		/funcionarios/1/lancamentos-recorrentes/1/...
	 * removerLancamentoRecorrente					DELETE	/funcionarios/1/lancamentos-recorrentes/1
	 * ativarLancamentoRecorrente					POST	/ativacao-lancamento-recorrente/1/... 
	 * desativarLancamentoRecorrente				POST	/desativacao-lancamento-recorrente/1/...
	 * 
	 * RubricaCargo:
	 * listarRubricasDoCargo						GET		/cargos/1/rubricas/
	 * obterRubricaCargo							GET		/cargos/1/rubricas/1
	 * criarRubricaCargo							POST	/cargos/1/rubricas/
	 * alterarRubricaCargo							PUT		/cargos/1/rubricas/1
	 * removerRubricaCargo							DELETE	/cargos/1/rubricas/1
	 * 
	 */
	
	@GET()
	@Path("/grupos-formula/")
	@Produces("application/json")
	public Response listarGrupoFormula(@HeaderParam("token") String token) {
		validarToken(token);
		List<GrupoFormula> gruposFormula = grupoFormulaService.buscarTodos();
		return ok(gruposFormula);
	}

	@GET()
	@Path("/grupos-formula/{id}/")
	@Produces("application/json")
	public Response obterGrupoFormula(@PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);
		GrupoFormula grupoFormula = grupoFormulaService.buscarPorId(id);
		return ok(grupoFormula);
	}

	@POST() @Consumes("application/json")
	@Path("/grupos-formula/")
	@Produces("application/json")
	public Response criarGrupoFormula(GrupoFormulaTO grupoFormulaTO, @HeaderParam("token") String token) {
		validarToken(token);
		GrupoFormula grupoFormula = new GrupoFormula(grupoFormulaTO);
		grupoFormula = grupoFormulaService.salvar(grupoFormula);
		return ok(grupoFormula);
	}

	@PUT() @Consumes("application/json")
	@Path("/grupos-formula/{id}/")
	@Produces("application/json")
	public Response alterarGrupoFormula(@PathParam("id") Long id, GrupoFormulaTO grupoFormulaTO, @HeaderParam("token") String token) {
		validarToken(token);

		GrupoFormula grupoFormula = grupoFormulaService.buscarPorId(id);
		if (grupoFormula == null) {
			return notFound();
		}
		
		grupoFormula.alterar(grupoFormulaTO);
		grupoFormula = grupoFormulaService.salvar(grupoFormula);
		return ok(grupoFormula);
	}
	
	@DELETE()
	@Path("/grupos-formula/{id}/")
	@Produces("application/json")
	public Response removerGrupoFormula(@PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);

		GrupoFormula grupoFormula = grupoFormulaService.buscarPorId(id);
		if (grupoFormula == null) {
			return notFound();
		}
		
		grupoFormulaService.excluir(grupoFormula);
		return ok();
	}

	@GET()
	@Path("/formulas/")
	@Produces("application/json")
	public Response listarFormulas(@HeaderParam("token") String token) {
		validarToken(token);
		List<Formula> formulas = formulaService.buscarTodos();
		return ok(formulas);
	}

	@GET()
	@Path("/grupos-formula/{id}/formulas/")
	@Produces("application/json")
	public Response listarFormulasPorGrupo(@PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);
		List<Formula> formulas = formulaService.buscarPorGrupo(id);
		return ok(formulas);
	}

	@GET()
	@Path("/pesquisas/formulas/nome/{nome}")
	@Produces("application/json")
	public Response pesquisarFormulasPorNome(@PathParam("nome") String nome, @HeaderParam("token") String token) {
		validarToken(token);
		List<Formula> formulas = formulaService.buscarPorNome(nome);
		return ok(formulas);
	}

	@GET()
	@Path("/formulas/{id}/")
	@Produces("application/json")
	public Response obterFormula(@PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);
		Formula formula = formulaService.buscarPorId(id);
		return ok(formula);
	}

	@POST() 
	@Path("/formulas/")
	@Consumes("application/json")
	@Produces("application/json")
	public Response criarFormula(FormulaTO formulaTO, @HeaderParam("token") String token) {
		validarToken(token);
		Formula formula = new Formula(formulaTO);
		try {
			formula = formulaService.salvar(formula);
			return created(formula.toTO());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return internalServerError("Falha ao criar fórmula: "+e.getMessage()); 			
		}		
	}

	@PUT() 
	@Path("/formulas/{id}/")
	@Consumes("application/json")
	@Produces("application/json")
	public Response alterarFormula(@PathParam("id") Long id, FormulaTO formulaTO, @HeaderParam("token") String token) {
		validarToken(token);

		Formula formula = formulaService.buscarPorId(id);
		if (formula == null) {
			return notFound();
		}
		
		formula.alterar(formulaTO);
		formula = formulaService.salvar(formula);
		return ok(formula);
	}

	@DELETE()
	@Path("/formulas/{id}/")
	@Produces("application/json")
	public Response removerFormula(@PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);

		Formula formula = formulaService.buscarPorId(id);
		if (formula == null) {
			return notFound();
		}
		
		formulaService.excluir(formula);
		return ok();
	}

	@GET()
	@Path("/formulas/{formulaId}/inputs/")
	@Produces("application/json")
	public Response listarInputsDaFormula(@PathParam("formulaId") Long formulaId, @HeaderParam("token") String token) {
		validarToken(token);
		List<FormulaInput> formulaInputs = formulaInputService.buscarPorFormula(formulaId);
		return ok(formulaInputs);
	}
	
	@GET()
	@Path("/formulas/{formulaId}/inputs/{id}/")
	@Produces("application/json")
	public Response obterFormulaInput(@PathParam("formulaId") Long formulaId, @PathParam("id") Long id, 
			@HeaderParam("token") String token) {
		validarToken(token);
		FormulaInput formulaInput = formulaInputService.buscarPorId(id);
		return ok(formulaInput);
	}

	@POST() @Consumes("application/json")
	@Path("/formulas/{formulaId}/inputs/")
	@Produces("application/json")
	public Response criarFormulaInput(@PathParam("formulaId") Long formulaId, FormulaInputTO formulaInputTO, 
			@HeaderParam("token") String token) {
		validarToken(token);
		FormulaInput formulaInput = new FormulaInput(formulaInputTO);
		formulaInput = formulaInputService.salvar(formulaInput);
		return ok(formulaInput);
	}

	@PUT() @Consumes("application/json") 
	@Path("/formulas/{formulaId}/inputs/{id}/")
	@Produces("application/json")
	public Response alterarFormulaInput(@PathParam("formulaId") Long formulaId, @PathParam("id") Long id, 
			FormulaInputTO formulaInputTO, @HeaderParam("token") String token) {
		validarToken(token);

		FormulaInput formulaInput = formulaInputService.buscarPorId(id);
		if (formulaInput == null) {
			return notFound();
		}
		
		formulaInput.alterar(formulaInputTO);
		formulaInput = formulaInputService.salvar(formulaInput);
		return ok(formulaInput);
	}

	@DELETE()
	@Path("/formulas/{formulaId}/inputs/{id}/")
	@Produces("application/json")
	public Response removerFormulaInput(@PathParam("formulaId") Long formulaId, @PathParam("id") Long id, 
			@HeaderParam("token") String token) {
		validarToken(token);

		FormulaInput formulaInput = formulaInputService.buscarPorId(id);
		if (formulaInput == null) {
			return notFound();
		}
		
		formulaInputService.excluir(formulaInput);
		return ok();
	}

	@GET()
	@Path("/formulas/{formulaId}/outputs/")
	@Produces("application/json")
	public Response listarOutputsDaFormula(@PathParam("formulaId") Long formulaId, @HeaderParam("token") String token) {
		validarToken(token);
		List<FormulaOutput> formulaOutputs = formulaOutputService.buscarPorFormula(formulaId);
		return ok(formulaOutputs);
	}

	@GET()
	@Path("/formulas/{formulaId}/outputs/{id}/")
	@Produces("application/json")
	public Response obterFormulaOutput(@PathParam("formulaId") Long formulaId, @PathParam("id") Long id, 
			@HeaderParam("token") String token) {
		validarToken(token);
		FormulaOutput formulaOutput = formulaOutputService.buscarPorId(id);
		return ok(formulaOutput);
	}

	@POST() @Consumes("application/json")
	@Path("/formulas/{formulaId}/outputs/")
	@Produces("application/json")
	public Response criarFormulaOutput(@PathParam("formulaId") Long formulaId, FormulaOutputTO formulaOutputTO, 
			@HeaderParam("token") String token) {
		validarToken(token);
		FormulaOutput formulaOutput = new FormulaOutput(formulaOutputTO);
		formulaOutput = formulaOutputService.salvar(formulaOutput);
		return ok(formulaOutput);
	}

	@PUT() @Consumes("application/json")
	@Path("/formulas/{formulaId}/outputs/{id}/")
	@Produces("application/json")
	public Response alterarFormulaOutput(@PathParam("formulaId") Long formulaId, @PathParam("id") Long id, 
			FormulaOutputTO formulaOutputTO, @HeaderParam("token") String token) {
		validarToken(token);

		FormulaOutput formulaOutput = formulaOutputService.buscarPorId(id);
		if (formulaOutput == null) {
			return notFound();
		}
		
		formulaOutput.alterar(formulaOutputTO);
		formulaOutput = formulaOutputService.salvar(formulaOutput);
		return ok(formulaOutput);
	}

	@DELETE()
	@Path("/formulas/{formulaId}/outputs/{id}/")
	@Produces("application/json")
	public Response removerFormulaOutput(@PathParam("formulaId") Long formulaId, @PathParam("id") Long id, 
			@HeaderParam("token") String token) {
		validarToken(token);

		FormulaOutput formulaOutput = formulaOutputService.buscarPorId(id);
		if (formulaOutput == null) {
			return notFound();
		}
		
		formulaOutputService.excluir(formulaOutput);
		return ok(formulaOutput);
	}

	@GET()
	@Path("/grupos-rubrica/")
	@Produces("application/json")
	public Response listarGrupoRubrica(@HeaderParam("token") String token) {
		validarToken(token);
		List<GrupoRubrica> gruposRubrica = grupoRubricaService.buscarTodos();
		return ok(gruposRubrica);
	}

	@GET()
	@Path("/grupos-rubrica/{id}/")
	@Produces("application/json")
	public Response obterGrupoRubrica(@PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);
		GrupoRubrica grupoRubrica = grupoRubricaService.buscarPorId(id);
		return ok(grupoRubrica);
	}

	@POST() @Consumes("application/json")
	@Path("/grupos-rubrica/")
	@Produces("application/json")
	public Response criarGrupoRubrica(GrupoRubricaTO grupoRubricaTO, @HeaderParam("token") String token) {
		validarToken(token);
		GrupoRubrica grupoRubrica = new GrupoRubrica(grupoRubricaTO);
		grupoRubrica = grupoRubricaService.salvar(grupoRubrica);
		return ok(grupoRubrica);
	}

	@PUT() @Consumes("application/json")
	@Path("/grupos-rubrica/{id}/")
	@Produces("application/json")
	public Response alterarGrupoRubrica(@PathParam("id") Long id, GrupoRubricaTO grupoRubricaTO, 
			@HeaderParam("token") String token) {
		validarToken(token);

		GrupoRubrica grupoRubrica = grupoRubricaService.buscarPorId(id);
		if (grupoRubrica == null) {
			return notFound();
		}
		
		grupoRubrica = grupoRubricaService.salvar(grupoRubrica);
		return ok(grupoRubrica);
	}

	@DELETE()
	@Path("/grupos-rubrica/{id}/")
	@Produces("application/json")
	public Response removerGrupoRubrica(@PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);

		GrupoRubrica grupoRubrica = grupoRubricaService.buscarPorId(id);
		if (grupoRubrica == null) {
			return notFound();
		}
		
		grupoRubricaService.excluir(grupoRubrica);
		return ok();
	}

	@GET()
	@Path("/rubricas/")
	@Produces("application/json")
	public Response listarRubricas(@HeaderParam("token") String token) {
		validarToken(token);
		List<Rubrica> rubricas = rubricaService.buscarTodos();
		return ok(rubricas);
	}

	@GET()
	@Path("/grupos-rubrica/{id}/rubricas/")
	@Produces("application/json")
	public Response listarRubricasPorGrupo(@PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);
		List<Rubrica> rubricas = rubricaService.buscarPorGrupo(id);
		return ok(rubricas);
	}

	@GET()
	@Path("/pesquisas/rubricas/nome/{descricao}")
	@Produces("application/json")
	public Response pesquisarRubricasPorNome(@PathParam("descricao") String descricao, @HeaderParam("token") String token) {
		validarToken(token);
		List<Rubrica> rubricas = rubricaService.buscarPorNome(descricao);
		return ok(rubricas);
	}

	@GET()
	@Path("/rubricas/{id}/")
	@Produces("application/json")
	public Response obterRubrica(@PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);
		Rubrica rubrica = rubricaService.buscarPorId(id);
		return ok(rubrica);
	}

	@POST() @Consumes("application/json")
	@Path("/rubricas/")
	@Produces("application/json")
	public Response criarRubrica(RubricaTO rubricaTO, @HeaderParam("token") String token) {
		validarToken(token);
		Rubrica rubrica = new Rubrica(rubricaTO);
		try {
			rubrica = rubricaService.salvar(rubrica);		
			return created(rubrica.toTO());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return internalServerError("Falha ao criar rubrica: "+e.getMessage());
		}
	}

	@PUT() @Consumes("application/json")
	@Path("/rubricas/{id}/")
	@Produces("application/json")
	public Response alterarRubrica(@PathParam("id") Long id, RubricaTO rubricaTO, @HeaderParam("token") String token) {
		validarToken(token);

		Rubrica rubrica = rubricaService.buscarPorId(id);
		if (rubrica == null) {
			return notFound();
		}

		rubrica = rubricaService.alterar(rubricaTO,id);
		return ok(rubrica.toTO());
	}

	@DELETE()
	@Path("/rubricas/{id}/")
	@Produces("application/json")
	public Response removerRubrica(@PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);

		Rubrica rubrica = rubricaService.buscarPorId(id);
		if (rubrica == null) {
			return notFound();
		}
		
		rubricaService.excluir(rubrica);
		return ok();
	}

	@GET()
	@Path("/rubricas/{id}/parametros/")
	@Produces("application/json")
	public Response listarParametrosDaRubrica(@PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);
		List<RubricaParametro> parametros = rubricaParametroService.buscarPorRubrica(id);
		return ok(parametros);
	}

	@GET()
	@Path("/rubricas/{rubricaId}/parametros/{id}/")
	@Produces("application/json")
	public Response obterRubricaParametro(@PathParam("rubricaId") Long rubricaId, @PathParam("id") Long id, 
			@HeaderParam("token") String token) {
		validarToken(token);
		RubricaParametro rubricaParametro = rubricaParametroService.buscarPorId(id);
		return ok(rubricaParametro);
	}

	
	@POST() @Consumes("application/json")
	@Path("/rubricas/{rubricaId}/parametros/")
	@Produces("application/json")
	public Response criarRubricaParametro(@PathParam("rubricaId") Long rubricaId, RubricaParametroTO rubricaParametroTO, 
			@HeaderParam("token") String token) {
		validarToken(token);
		RubricaParametro rubricaParametro = new RubricaParametro(rubricaParametroTO);
		rubricaParametro = rubricaParametroService.salvar(rubricaParametro);
		return ok(rubricaParametro);
	}

	@PUT() @Consumes("application/json")
	@Path("/rubricas/{rubricaId}/parametros/{id}/")
	@Produces("application/json")
	public Response alterarRubricaParametro(@PathParam("rubricaId") Long rubricaId, @PathParam("id") Long id, 
			RubricaParametroTO rubricaParametroTO, @HeaderParam("token") String token) {
		validarToken(token);

		RubricaParametro rubricaParametro = rubricaParametroService.buscarPorId(id);
		if (rubricaParametro == null) {
			return notFound();
		}
		
		rubricaParametro.alterar(rubricaParametroTO);
		rubricaParametro = rubricaParametroService.salvar(rubricaParametro);
		return ok(rubricaParametro);
	}

	@DELETE()
	@Path("/rubricas/{rubricaId}/parametros/{id}/")
	@Produces("application/json")
	public Response removerRubricaParametro(@PathParam("rubricaId") Long rubricaId, @PathParam("id") Long id, 
			@HeaderParam("token") String token) {
		validarToken(token);

		RubricaParametro rubricaParametro = rubricaParametroService.buscarPorId(id);
		if (rubricaParametro == null) {
			return notFound();
		}
		
		rubricaParametroService.excluir(rubricaParametro);
		return ok();
	}

	@GET()
	@Path("/rubricas/{rubricaId}/formulas/")
	@Produces("application/json")
	public Response listarFormulasDaRubrica(@PathParam("rubricaId") Long rubricaId, @HeaderParam("token") String token) {
		validarToken(token);
		List<Formula> formulas = rubricaFormulaService.buscarFormulasPorRubrica(rubricaId);
		return ok(formulas);
	}

	@POST() @Consumes("application/json")
	@Path("/rubricas/{rubricaId}/formulas/")
	@Produces("application/json")
	public Response vincularFormulaARubrica(@PathParam("rubricaId") Long rubricaId, RubricaFormulaTO rubricaFormulaTO,  @HeaderParam("token") String token) {
		validarToken(token);
		RubricaFormula rubricaFormula = new RubricaFormula(rubricaFormulaTO);
		rubricaFormula = rubricaFormulaService.salvar(rubricaFormula);
		return ok(rubricaFormula);
	}

	@DELETE()
	@Path("/rubricas/{rubricaId}/formulas/{id}/")
	@Produces("application/json")
	public Response desvincularFormulaDaRubrica(@PathParam("rubricaId") Long rubricaId, @PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);
		RubricaFormula rubricaFormula = rubricaFormulaService.buscarRubricaFormulaPorRubricaEFormula(rubricaId, id);
		rubricaFormulaService.excluir(rubricaFormula);
		return ok();
	}

	@GET()
	@Path("/rubricas/{rubricaId}/rubricasBase/")
	@Produces("application/json")
	public Response listarRubricasBasesDaRubrica(@PathParam("rubricaId") Long rubricaId, @HeaderParam("token") String token) {
		validarToken(token);
		List<RubricaBase> rubricasBase = rubricaBaseService.buscarPorRubrica(rubricaId);
		return ok(rubricasBase);
	}

	@POST() @Consumes("application/json")
	@Path("/rubricas/{rubricaId}/rubricasBase/")
	@Produces("application/json")
	public Response vincularRubricaBaseARubrica(@PathParam("rubricaId") Long rubricaId, RubricaBaseTO rubricaBaseTO, @HeaderParam("token") String token) {
		validarToken(token);

		RubricaBase rubricaBase = new RubricaBase(rubricaBaseTO);
		rubricaBase = rubricaBaseService.salvar(rubricaBase);
		return ok(rubricaBase);
	}

	@DELETE()
	@Path("/rubricas/{rubricaId}/rubricasBase/{id}/")
	@Produces("application/json")
	public Response desvincularRubricaBaseDaRubrica(@PathParam("rubricaId") Long rubricaId, @PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);
		RubricaBase rubricaBase = rubricaBaseService.buscarPorId(id);
		rubricaBaseService.excluir(rubricaBase);
		return ok();
	}

	@GET()
	@Path("/rubricas/{rubricaId}/utiliza-tipos-base-calculo/")
	@Produces("application/json")
	public Response listarTiposBaseCalculoUtilizadosPelaRubrica(@PathParam("rubricaId") Long rubricaId,
			@HeaderParam("token") String token) {
		validarToken(token);
		List<RubricaUtilizaBaseCalculo> basesCalcula = rubricaUtilizaBaseCalculoService.buscarPorRubrica(rubricaId);
		return ok(basesCalcula);
	}

	@POST() @Consumes("application/json")
	@Path("/rubricas/{rubricaId}/utiliza-tipos-base-calculo/")
	@Produces("application/json")
	public Response vincularUtilizacaoTipoBaseCalculoARubrica(@PathParam("rubricaId") Long rubricaId, 
			RubricaUtilizaBaseCalculoTO rubricaUtilizaBaseCalculoTO,
			@HeaderParam("token") String token) {
		validarToken(token);
		RubricaUtilizaBaseCalculo rubricaUtilizaBaseCalculo = new RubricaUtilizaBaseCalculo(rubricaUtilizaBaseCalculoTO);
		rubricaUtilizaBaseCalculo.setRubrica(rubricaService.buscarPorId(rubricaUtilizaBaseCalculoTO.getRubricaId()));
		rubricaUtilizaBaseCalculo = rubricaUtilizaBaseCalculoService.salvar(rubricaUtilizaBaseCalculo);
		return created(rubricaUtilizaBaseCalculo);
	}

	@DELETE()
	@Path("/rubricas/{rubricaId}/utiliza-tipos-base-calculo/{id}/")
	@Produces("application/json")
	public Response desvincularUtilizacaoTipoBaseCalculoDaRubrica(@PathParam("rubricaId") Long rubricaId, @PathParam("id") Long id,
			@HeaderParam("token") String token) {
		validarToken(token);
		RubricaUtilizaBaseCalculo rubricaUtilizaBaseCalculo = rubricaUtilizaBaseCalculoService.buscarPorId(id);
		rubricaUtilizaBaseCalculoService.excluir(rubricaUtilizaBaseCalculo);
		return ok();
	}

	@GET()
	@Path("/rubricas/{rubricaId}/compoe-tipos-base-calculo/")
	@Produces("application/json")
	public Response listarComposicaoTiposBaseCalculoDaRubrica(@PathParam("rubricaId") Long rubricaId,
			@HeaderParam("token") String token) {
		validarToken(token);
		List<RubricaCompoeBaseCalculo> compoeTiposBaseCalculo = rubricaCompoeBaseCalculoService.buscarPorRubrica(rubricaId);
		return ok(compoeTiposBaseCalculo);
	}

	@POST() @Consumes("application/json")
	@Path("/rubricas/{rubricaId}/compoe-tipos-base-calculo/")
	@Produces("application/json")
	public Response vincularComposicaoTipoBaseCalculoARubrica(@PathParam("rubricaId") Long rubricaId,
			RubricaCompoeBaseCalculoTO rubricaCompoeBaseCalculoTO,
			@HeaderParam("token") String token) {
		validarToken(token);
		RubricaCompoeBaseCalculo rubricaCompoeBaseCalculo = new RubricaCompoeBaseCalculo(rubricaCompoeBaseCalculoTO);
		rubricaCompoeBaseCalculo = rubricaCompoeBaseCalculoService.salvar(rubricaCompoeBaseCalculo);
		return ok(rubricaCompoeBaseCalculo);
	}

	@DELETE()
	@Path("/rubricas/{rubricaId}/compoe-tipos-base-calculo/{id}/")
	@Produces("application/json")
	public Response desvincularComposicaoTipoBaseCalculoDaRubrica(@PathParam("rubricaId") Long rubricaId, 
			@PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);
		RubricaCompoeBaseCalculo rubricaCompoeBaseCalculo = rubricaCompoeBaseCalculoService.buscarPorId(id);
		rubricaCompoeBaseCalculoService.excluir(rubricaCompoeBaseCalculo);
		return ok();
	}

	@GET()
	@Path("/rubricas/{rubricaId}/tipos-classificacao-contabil/")
	@Produces("application/json")
	public Response listarTipoClassificacaoContabilDaRubrica(@PathParam("rubricaId") Long rubricaId,
			@HeaderParam("token") String token) {
		validarToken(token);
		List<TipoClassificacaoContabil> tiposClassificacaoContabil = rubricaTipoClassificacaoContabilService
				.buscarTipoClassificacaoContabilPorRubrica(rubricaId);
		return ok(tiposClassificacaoContabil);
	}
	
	@POST() @Consumes("application/json")
	@Path("/rubricas/{rubricaId}/tipos-classificacao-contabil/")
	@Produces("application/json")
	public Response vincularTipoClassificacaoContabilARubrica(@PathParam("rubricaId") Long rubricaId,
			RubricaTipoClassificacaoContabilTO rubricaTipoClassificacaoContabilTO,
			@HeaderParam("token") String token) {
		validarToken(token);
		
		RubricaTipoClassificacaoContabil rubricaTipoClassificacaoContabil = 
				new RubricaTipoClassificacaoContabil(rubricaTipoClassificacaoContabilTO); 
		
		rubricaTipoClassificacaoContabil = rubricaTipoClassificacaoContabilService.salvar(rubricaTipoClassificacaoContabil);
		return ok(rubricaTipoClassificacaoContabil);
	}

	@DELETE()
	@Path("/rubricas/{rubricaId}/tipos-classificacao-contabil/{id}/")
	@Produces("application/json")
	public Response desvincularTipoClassificacaoContabilDaRubrica(@PathParam("rubricaId") Long rubricaId, 
			@PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);

		RubricaTipoClassificacaoContabil rubricaTipoClassificacaoContabil = 
				rubricaTipoClassificacaoContabilService.buscarPorId(id);
		
		rubricaTipoClassificacaoContabilService.excluir(rubricaTipoClassificacaoContabil);
		return ok();
	}

	@GET()
	@Path("/funcionarios/{id}/lancamentos-avulsos/")
	@Produces("application/json")
	public Response listarLancamentosAvulsosDoFuncionario(@PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);
		List<LancamentoAvulso> lancamentosAvulsos = lancamentoAvulsoService.buscarPorFuncionario(id);
		
		if (lancamentosAvulsos == null) {
			return notFound();
		}
		
		List<LancamentoAvulsoTO> tos = new ArrayList<LancamentoAvulsoTO>();
		
		for (LancamentoAvulso l : lancamentosAvulsos) {
			tos.add(l.toTO());
		}
		
		return ok(tos);
	}

	@GET()
	@Path("/funcionarios/{funcionarioId}/lancamentos-avulsos/{id}/")
	@Produces("application/json")
	public Response obterLancamentoAvulso(@PathParam("funcionarioId") Long funcionarioId, @PathParam("id") Long id, 
			@HeaderParam("token") String token) {
		validarToken(token);
		LancamentoAvulso lancamentoAvulso = lancamentoAvulsoService.buscarPorId(id);
		
		if (lancamentoAvulso == null) {
			return notFound();
		}
		
		return ok(lancamentoAvulso.toTO());
	}

	@POST()
	@Path("/funcionarios/{funcionarioId}/lancamentos-avulsos/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response adicionarLancamentoAvulso(@PathParam("funcionarioId") Long funcionarioId, LancamentoAvulsoTO lancamentoAvulsoTO, @HeaderParam("token") String token) {
		validarToken(token);
		LancamentoAvulso lancamentoAvulso = new LancamentoAvulso(lancamentoAvulsoTO);
		try {
			lancamentoAvulso = lancamentoAvulsoService.salvar(lancamentoAvulso);
			return created(lancamentoAvulso.toTO());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return internalServerError("Falha ao adicionar lançamento avulso para o funcionário: "+e.getMessage()); 			
		}
		
	}

	@PUT()
	@Path("/funcionarios/{funcionarioId}/lancamentos-avulsos/{id}/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response alterarLancamentoAvulso(@PathParam("funcionarioId") Long funcionarioId, @PathParam("id") Long id,
			LancamentoAvulsoTO lancamentoAvulsoTO, @HeaderParam("token") String token) {
		validarToken(token);
		LancamentoAvulso lancamentoAvulso = lancamentoAvulsoService.buscarPorId(id);
		lancamentoAvulso.alterar(lancamentoAvulsoTO);
		lancamentoAvulso = lancamentoAvulsoService.salvar(lancamentoAvulso); 
		return ok(lancamentoAvulso);
	}

	@DELETE()
	@Path("/funcionarios/{funcionarioId}/lancamentos-avulsos/{id}/")
	@Produces("application/json")
	public Response removerLancamentoAvulso(@PathParam("funcionarioId") Long funcionarioId, @PathParam("id") Long id, 
			@HeaderParam("token") String token) {
		validarToken(token);

		LancamentoAvulso lancamentoAvulso = lancamentoAvulsoService.buscarPorId(id);
		if (lancamentoAvulso == null) {
			return notFound();
		}
		
		lancamentoAvulsoService.excluir(lancamentoAvulso);
		return ok();
	}

	@POST() @Consumes("application/json")
	@Path("/pagamento-lancamento-avulso/{id}/")
	@Produces("application/json")
	public Response pagarLancamentoAvulso(@PathParam("id") Long id, PagamentoLancamentoAvulsoTO pagamentoLancamentoAvulsoTO, 
			@HeaderParam("token") String token) {
		validarToken(token);

		LancamentoAgendado lancamentoAgendado = lancamentoAgendadoService.buscarPorId(id);
		if (lancamentoAgendado == null) {
			return notFound();
		}
		
		lancamentoAgendado.pagar(pagamentoLancamentoAvulsoTO);
		lancamentoAgendado = lancamentoAgendadoService.salvar(lancamentoAgendado); 
		return ok(lancamentoAgendado);
	}

	@GET()
	@Path("/funcionarios/{funcionarioId}/lancamentos-agendados/")
	@Produces("application/json")
	public Response listarLancamentosAgendadosDoFuncionario(@PathParam("funcionarioId") Long funcionarioId,
			@HeaderParam("token") String token) {
		validarToken(token);
		List<LancamentoAgendado> lancamentosAgendados = lancamentoAgendadoService.buscarPorFuncionario(funcionarioId);
		return ok(lancamentosAgendados);
	}

	@GET()
	@Path("/funcionarios/{funcionarioId}/lancamentos-agendados/{id}/")
	@Produces("application/json")
	public Response obterLancamentoAgendado(@PathParam("funcionarioId") Long funcionarioId, @PathParam("id") Long id, 
			@HeaderParam("token") String token) {
		validarToken(token);
		LancamentoAgendado lancamentoAgendado = lancamentoAgendadoService.buscarPorId(id);
		return ok(lancamentoAgendado);
	}

	@POST() @Consumes("application/json")
	@Path("/funcionarios/{funcionarioId}/lancamentos-agendados/")
	@Produces("application/json")
	public Response adicionarLancamentoAgendado(@PathParam("funcionarioId") Long funcionarioId, 
			LancamentoAgendadoTO lancamentoAgendadoTO, @HeaderParam("token") String token) {
		validarToken(token);
		LancamentoAgendado lancamentoAgendado = new LancamentoAgendado(lancamentoAgendadoTO);
		
		try {
			lancamentoAgendado = lancamentoAgendadoService.salvar(lancamentoAgendado);
			return created(lancamentoAgendado.toTO());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return internalServerError("Falha ao adicionar lançamento agendado para o funcionário: "+e.getMessage()); 			
		}
		
	}

	@PUT() @Consumes("application/json")
	@Path("/funcionarios/{funcionarioId}/lancamentos-agendados/{id}/")
	@Produces("application/json")
	public Response alterarLancamentoAgendado(@PathParam("funcionarioId") Long funcionarioId, @PathParam("id") Long id, 
			LancamentoAgendadoTO lancamentoAgendadoTO, @HeaderParam("token") String token) {
		validarToken(token);
		LancamentoAgendado lancamentoAgendado = lancamentoAgendadoService.buscarPorId(id);
		lancamentoAgendado.alterar(lancamentoAgendadoTO);
		lancamentoAgendado = lancamentoAgendadoService.salvar(lancamentoAgendado);
		return ok(lancamentoAgendado);
	}

	@DELETE()
	@Path("/funcionarios/{funcionarioId}/lancamentos-agendados/{id}/")
	@Produces("application/json")
	public Response removerLancamentoAgendado(@PathParam("funcionarioId") Long funcionarioId, @PathParam("id") Long id, 
			@HeaderParam("token") String token) {
		validarToken(token);

		LancamentoAgendado lancamentoAgendado = lancamentoAgendadoService.buscarPorId(id);
		if (lancamentoAgendado == null) {
			return notFound();
		}
		
		lancamentoAgendadoService.excluir(lancamentoAgendado);
		return ok();
	}

	@POST() @Consumes("application/json")
	@Path("/pagamento-lancamento-agendado/{id}/")
	@Produces("application/json")
	public Response pagarLancamentoAgendado(@PathParam("id") Long id, PagamentoLancamentoAgendadoTO pagamentoLancamentoAgendadoTO,
			@HeaderParam("token") String token) {
		validarToken(token);

		LancamentoAgendado lancamentoAgendado = lancamentoAgendadoService.buscarPorId(id);
		if (lancamentoAgendado == null) {
			return notFound();
		}
		
		lancamentoAgendado.pagar(pagamentoLancamentoAgendadoTO);
		lancamentoAgendado = lancamentoAgendadoService.salvar(lancamentoAgendado);
		return ok(lancamentoAgendado);
	}

	@GET()
	@Path("/funcionarios/{funcionarioId}/lancamentos-recorrentes/")
	@Produces("application/json")
	public Response listarLancamentosRecorrentesDoFuncionario(@PathParam("funcionarioId") Long funcionarioId,
			@HeaderParam("token") String token) {
		validarToken(token);
		List<LancamentoRecorrente> lancamentosRecorrentes = lancamentoRecorrenteService.buscarPorFuncionario(funcionarioId);
		return ok(lancamentosRecorrentes);
	}

	@GET()
	@Path("/funcionarios/{funcionarioId}/lancamentos-recorrentes/{id}/")
	@Produces("application/json")
	public Response obterLancamentoRecorrente(@PathParam("funcionarioId") Long funcionarioId, @PathParam("id") Long id, 
			@HeaderParam("token") String token) {
		validarToken(token);
		LancamentoRecorrente lancamentoRecorrente = lancamentoRecorrenteService.buscarPorId(id);
		return ok(lancamentoRecorrente);
	}

	@POST() @Consumes("application/json")
	@Path("/funcionarios/{funcionarioId}/lancamentos-recorrentes/")
	@Produces("application/json")
	public Response adicionarLancamentoRecorrente(@PathParam("funcionarioId") Long funcionarioId, 
			LancamentoRecorrenteTO lancamentoRecorrenteTO, @HeaderParam("token") String token) {
		validarToken(token);
		LancamentoRecorrente lancamentoRecorrente = new LancamentoRecorrente(lancamentoRecorrenteTO);
		try {
			lancamentoRecorrente = lancamentoRecorrenteService.salvar(lancamentoRecorrente);
			return created(lancamentoRecorrente.toTO());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return internalServerError("Falha ao adicionar lançamento recorrente para o funcionário: "+e.getMessage()); 			
		}
	}

	@PUT() @Consumes("application/json")
	@Path("/funcionarios/{funcionarioId}/lancamentos-recorrentes/{id}/")
	@Produces("application/json")
	public Response alterarLancamentoRecorrente(@PathParam("funcionarioId") Long funcionarioId, @PathParam("id") Long id, 
			LancamentoRecorrenteTO lancamentoRecorrenteTO, @HeaderParam("token") String token) {
		validarToken(token);

		LancamentoRecorrente lancamentoRecorrente = lancamentoRecorrenteService.buscarPorId(id);
		if (lancamentoRecorrente == null) {
			return notFound();
		}
		
		lancamentoRecorrente.alterar(lancamentoRecorrenteTO);
		lancamentoRecorrente = lancamentoRecorrenteService.salvar(lancamentoRecorrente);
		return ok(lancamentoRecorrente);
	}

	@DELETE()
	@Path("/funcionarios/{funcionarioId}/lancamentos-recorrentes/{id}/")
	@Produces("application/json")
	public Response removerLancamentoRecorrente(@PathParam("funcionarioId") Long funcionarioId, @PathParam("id") Long id, 
			@HeaderParam("token") String token) {
		validarToken(token);

		LancamentoRecorrente lancamentoRecorrente = lancamentoRecorrenteService.buscarPorId(id);
		if (lancamentoRecorrente == null) {
			return notFound();
		}
		
		lancamentoRecorrenteService.excluir(lancamentoRecorrente);
		return ok();
	}

	@POST() @Consumes("application/json")
	@Path("/ativacao-lancamento-recorrente/{id}/")
	@Produces("application/json")
	public Response ativarLancamentoRecorrente(@PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);

		LancamentoRecorrente lancamentoRecorrente = lancamentoRecorrenteService.buscarPorId(id);
		if (lancamentoRecorrente == null) {
			return notFound();
		}
		
		lancamentoRecorrente.ativar();
		lancamentoRecorrente = lancamentoRecorrenteService.salvar(lancamentoRecorrente);
		return ok(lancamentoRecorrente);
	}

	@POST() @Consumes("application/json")
	@Path("/desativacao-lancamento-recorrente/{id}/")
	@Produces("application/json")
	public Response desativarLancamentoRecorrente(@PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);

		LancamentoRecorrente lancamentoRecorrente = lancamentoRecorrenteService.buscarPorId(id);
		if (lancamentoRecorrente == null) {
			return notFound();
		}
		
		lancamentoRecorrente.desativar();
		lancamentoRecorrente = lancamentoRecorrenteService.salvar(lancamentoRecorrente);
		return ok(lancamentoRecorrente);
	}
	
	@GET()
	@Path("/funcionarios/{funcionarioId}/rubricas/")
	@Produces("application/json")
	public Response listarRubricasDoFuncionario(@PathParam("funcionarioId") Long funcionarioId, @HeaderParam("token") String token) {
		validarToken(token);
		List<Rubrica> rubricas = rubricaFuncionarioService.buscarRubricasPorFuncionario(funcionarioId);
		return ok(rubricas);
	}

	@GET()
	@Path("/funcionarios/{funcionarioId}/rubricas/{id}/")
	@Produces("application/json")
	public Response obterRubricaFuncionario(@PathParam("funcionarioId") Long funcionarioId, @PathParam("id") Long id, 
			@HeaderParam("token") String token) {
		validarToken(token);
		RubricaFuncionario rubricaFuncionario =  rubricaFuncionarioService.buscarPorId(id);
		return ok(rubricaFuncionario);
	}

	@POST() @Consumes("application/json")
	@Path("/funcionarios/{funcionarioId}/rubricas/")
	@Produces("application/json")
	public Response adicionarRubricaFuncionario(@PathParam("funcionarioId") Long funcionarioId, 
			RubricaFuncionarioTO rubricaFuncionarioTO, @HeaderParam("token") String token) {
		validarToken(token);
		RubricaFuncionario rubricaFuncionario = new RubricaFuncionario(rubricaFuncionarioTO);
		
		try {
			rubricaFuncionario = rubricaFuncionarioService.salvar(rubricaFuncionario);
			return created(rubricaFuncionario);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return internalServerError("Falha ao adicionar rubrica para o funcionário: "+e.getMessage()); 			
		}

	}

	@PUT() @Consumes("application/json")
	@Path("/funcionarios/{funcionarioId}/rubricas/{id}/")
	@Produces("application/json")
	public Response alterarRubricaFuncionario(@PathParam("funcionarioId") Long funcionarioId, 
			@PathParam("id") Long id, RubricaFuncionarioTO rubricaFuncionarioTO, 
			@HeaderParam("token") String token) {
		validarToken(token);

		RubricaFuncionario rubricaFuncionario =  rubricaFuncionarioService.buscarPorId(id);
		if (rubricaFuncionario == null) {
			return notFound();
		}
		
		rubricaFuncionario.alterar(rubricaFuncionarioTO);
		rubricaFuncionario = rubricaFuncionarioService.salvar(rubricaFuncionario);
		return ok(rubricaFuncionario);
	}

	@DELETE()
	@Path("/funcionarios/{funcionarioId}/rubricas/{id}/")
	@Produces("application/json")
	public Response removerRubricaFuncionario(@PathParam("funcionarioId") Long funcionarioId, 
			@PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);

		RubricaFuncionario rubricaFuncionario =  rubricaFuncionarioService.buscarPorId(id);
		if (rubricaFuncionario == null) {
			return notFound();
		}
		
		rubricaFuncionarioService.excluir(rubricaFuncionario);
		return ok();
	}
	
	@GET()
	@Path("/cargos/{cargoId}/rubricas/")
	@Produces("application/json")
	public Response listarRubricasDoCargo(@PathParam("cargoId") Long cargoId, @HeaderParam("token") String token) {
		validarToken(token);
		List<Rubrica> rubricas = rubricaCargoService.buscarRubricasPorCargo(cargoId);
		return ok(rubricas);
	}

	@GET()
	@Path("/cargos/{cargoId}/rubricas/{id}/")
	@Produces("application/json")
	public Response obterRubricaCargo(@PathParam("cargoId") Long cargoId, @PathParam("id") Long id, 
			@HeaderParam("token") String token) {
		validarToken(token);
		RubricaCargo rubricaCargo = rubricaCargoService.buscarPorId(id);
		return ok(rubricaCargo);
	}

	@POST() @Consumes("application/json")
	@Path("/cargos/{cargoId}/rubricas/")
	@Produces("application/json")
	public Response criarRubricaCargo(@PathParam("cargoId") Long cargoId, RubricaCargoTO rubricaCargoTO, 
			@HeaderParam("token") String token) {
		validarToken(token);
		RubricaCargo rubricaCargo = new RubricaCargo(rubricaCargoTO);
		rubricaCargo = rubricaCargoService.salvar(rubricaCargo);
		return ok(rubricaCargo);
	}

	@PUT() @Consumes("application/json")
	@Path("/cargos/{cargoId}/rubricas/{id}/")
	@Produces("application/json")
	public Response alterarRubricaCargo(@PathParam("cargoId") Long cargoId, @PathParam("id") Long id, 
			RubricaCargoTO rubricaCargoTO, @HeaderParam("token") String token) {
		validarToken(token);
		
		RubricaCargo rubricaCargo = rubricaCargoService.buscarPorId(id);
		if (rubricaCargo == null) {
			return notFound();
		}
		
		rubricaCargo.alterar(rubricaCargoTO);
		rubricaCargo = rubricaCargoService.salvar(rubricaCargo);
		return ok(rubricaCargo);
	}

	@DELETE()
	@Path("/cargos/{cargoId}/rubricas/{id}/")
	@Produces("application/json")
	public Response removerRubricaCargo(@PathParam("cargoId") Long cargoId, @PathParam("id") Long id, 
			@HeaderParam("token") String token) {
		validarToken(token);

		RubricaCargo rubricaCargo = rubricaCargoService.buscarPorId(id);
		if (rubricaCargo == null) {
			return notFound();
		}
		
		rubricaCargoService.excluir(rubricaCargo);
		return ok();
	}
	
}