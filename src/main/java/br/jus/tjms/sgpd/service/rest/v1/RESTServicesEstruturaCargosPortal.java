package br.jus.tjms.sgpd.service.rest.v1;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import br.jus.tjms.sgpd.entity.Cargo;
import br.jus.tjms.sgpd.entity.CargoArea;
import br.jus.tjms.sgpd.entity.CargoAreaEstoque;
import br.jus.tjms.sgpd.entity.CargoAreaMovimento;
import br.jus.tjms.sgpd.entity.CargoEspecialidade;
import br.jus.tjms.sgpd.entity.CargoFormaProvimento;
import br.jus.tjms.sgpd.entity.CargoHistoricoNome;
import br.jus.tjms.sgpd.entity.CargoOcupacao;
import br.jus.tjms.sgpd.entity.CargoRegimeJuridico;
import br.jus.tjms.sgpd.entity.CargoTipoProvimento;
import br.jus.tjms.sgpd.entity.Certificacao;
import br.jus.tjms.sgpd.entity.EntidadeCertificadora;
import br.jus.tjms.sgpd.entity.EntidadePrevidenciaria;
import br.jus.tjms.sgpd.entity.Especialidade;
import br.jus.tjms.sgpd.entity.EstruturaCargo;
import br.jus.tjms.sgpd.entity.GrupoCargo;
import br.jus.tjms.sgpd.entity.Ocupacao;
import br.jus.tjms.sgpd.entity.OrgaoRegionalClasse;
import br.jus.tjms.sgpd.entity.PlanoCargo;
import br.jus.tjms.sgpd.entity.PreRequisitoAtitude;
import br.jus.tjms.sgpd.entity.PreRequisitoCertificacao;
import br.jus.tjms.sgpd.entity.PreRequisitoCompetencia;
import br.jus.tjms.sgpd.entity.PreRequisitoConhecimento;
import br.jus.tjms.sgpd.entity.PreRequisitoCurso;
import br.jus.tjms.sgpd.entity.PreRequisitoExperiencia;
import br.jus.tjms.sgpd.entity.PreRequisitoFormacaoAcademica;
import br.jus.tjms.sgpd.entity.PreRequisitoHabilidade;
import br.jus.tjms.sgpd.entity.PreRequisitoRegistroOrgaoClasse;
import br.jus.tjms.sgpd.entity.QuadroPessoal;
import br.jus.tjms.sgpd.entity.Referencia;
import br.jus.tjms.sgpd.entity.ReferenciaValor;
import br.jus.tjms.sgpd.entity.RegimeJuridico;
import br.jus.tjms.sgpd.entity.RegimeJuridicoRegimePrevidencia;
import br.jus.tjms.sgpd.entity.RegimePrevidencia;
import br.jus.tjms.sgpd.entity.Turno;
import br.jus.tjms.sgpd.entity.TurnoCargo;
import br.jus.tjms.sgpd.enumerators.FormaProvimento;
import br.jus.tjms.sgpd.enumerators.TipoFormacaoAcademica;
import br.jus.tjms.sgpd.enumerators.TipoProvimento;
import br.jus.tjms.sgpd.service.ServicesPortal;
import br.jus.tjms.sgpd.service.estruturacargosservices.CargoAreaEstoqueService;
import br.jus.tjms.sgpd.service.estruturacargosservices.CargoAreaMovimentoService;
import br.jus.tjms.sgpd.service.estruturacargosservices.CargoAreaService;
import br.jus.tjms.sgpd.service.estruturacargosservices.CargoEspecialidadeService;
import br.jus.tjms.sgpd.service.estruturacargosservices.CargoFormaProvimentoService;
import br.jus.tjms.sgpd.service.estruturacargosservices.CargoHistoricoNomeService;
import br.jus.tjms.sgpd.service.estruturacargosservices.CargoOcupacaoService;
import br.jus.tjms.sgpd.service.estruturacargosservices.CargoRegimeJuridicoService;
import br.jus.tjms.sgpd.service.estruturacargosservices.CargoService;
import br.jus.tjms.sgpd.service.estruturacargosservices.CargoTipoProvimentoService;
import br.jus.tjms.sgpd.service.estruturacargosservices.CertificacaoService;
import br.jus.tjms.sgpd.service.estruturacargosservices.EntidadeCertificadoraService;
import br.jus.tjms.sgpd.service.estruturacargosservices.EntidadePrevidenciariaService;
import br.jus.tjms.sgpd.service.estruturacargosservices.EspecialidadeService;
import br.jus.tjms.sgpd.service.estruturacargosservices.EstruturaCargoService;
import br.jus.tjms.sgpd.service.estruturacargosservices.GrupoCargoService;
import br.jus.tjms.sgpd.service.estruturacargosservices.OcupacaoService;
import br.jus.tjms.sgpd.service.estruturacargosservices.OrgaoRegionalClasseService;
import br.jus.tjms.sgpd.service.estruturacargosservices.PlanoCargoService;
import br.jus.tjms.sgpd.service.estruturacargosservices.PreRequisitoAtitudeService;
import br.jus.tjms.sgpd.service.estruturacargosservices.PreRequisitoCertificacaoService;
import br.jus.tjms.sgpd.service.estruturacargosservices.PreRequisitoCompetenciaService;
import br.jus.tjms.sgpd.service.estruturacargosservices.PreRequisitoConhecimentoService;
import br.jus.tjms.sgpd.service.estruturacargosservices.PreRequisitoCursoService;
import br.jus.tjms.sgpd.service.estruturacargosservices.PreRequisitoExperienciaService;
import br.jus.tjms.sgpd.service.estruturacargosservices.PreRequisitoFormacaoAcademicaService;
import br.jus.tjms.sgpd.service.estruturacargosservices.PreRequisitoHabilidadeService;
import br.jus.tjms.sgpd.service.estruturacargosservices.PreRequisitoRegistroOrgaoClasseService;
import br.jus.tjms.sgpd.service.estruturacargosservices.QuadroPessoalService;
import br.jus.tjms.sgpd.service.estruturacargosservices.ReferenciaService;
import br.jus.tjms.sgpd.service.estruturacargosservices.ReferenciaValorService;
import br.jus.tjms.sgpd.service.estruturacargosservices.TurnoCargoService;
import br.jus.tjms.sgpd.service.frequenciaservices.TurnoService;
import br.jus.tjms.sgpd.service.funcionarioservices.FuncionarioService;
import br.jus.tjms.sgpd.service.regimejuridicoservices.RegimeJuridicoRegimePrevidenciaService;
import br.jus.tjms.sgpd.service.regimejuridicoservices.RegimeJuridicoService;
import br.jus.tjms.sgpd.service.regimejuridicoservices.RegimePrevidenciaService;
import br.jus.tjms.sgpd.service.rest.v1.to.AtitudeTO;
import br.jus.tjms.sgpd.service.rest.v1.to.CargoAreaEstoqueTO;
import br.jus.tjms.sgpd.service.rest.v1.to.CargoAreaMovimentoTO;
import br.jus.tjms.sgpd.service.rest.v1.to.CargoAreaTO;
import br.jus.tjms.sgpd.service.rest.v1.to.CargoHistoricoNomeTO;
import br.jus.tjms.sgpd.service.rest.v1.to.CargoTO;
import br.jus.tjms.sgpd.service.rest.v1.to.CertificacaoTO;
import br.jus.tjms.sgpd.service.rest.v1.to.CompetenciaTO;
import br.jus.tjms.sgpd.service.rest.v1.to.ConhecimentoTO;
import br.jus.tjms.sgpd.service.rest.v1.to.CursoTO;
import br.jus.tjms.sgpd.service.rest.v1.to.EntidadeCertificadoraTO;
import br.jus.tjms.sgpd.service.rest.v1.to.EntidadePrevidenciariaTO;
import br.jus.tjms.sgpd.service.rest.v1.to.EspecialidadeTO;
import br.jus.tjms.sgpd.service.rest.v1.to.EstruturaCargoTO;
import br.jus.tjms.sgpd.service.rest.v1.to.ExperienciaTO;
import br.jus.tjms.sgpd.service.rest.v1.to.GrupoCargoTO;
import br.jus.tjms.sgpd.service.rest.v1.to.HabilidadeTO;
import br.jus.tjms.sgpd.service.rest.v1.to.OcupacaoTO;
import br.jus.tjms.sgpd.service.rest.v1.to.OrgaoRegionalClasseTO;
import br.jus.tjms.sgpd.service.rest.v1.to.PlanoCargoTO;
import br.jus.tjms.sgpd.service.rest.v1.to.QuadroPessoalTO;
import br.jus.tjms.sgpd.service.rest.v1.to.ReferenciaTO;
import br.jus.tjms.sgpd.service.rest.v1.to.ReferenciaValorTO;
import br.jus.tjms.sgpd.service.rest.v1.to.RegimeJuridicoRegimePrevidenciaTO;
import br.jus.tjms.sgpd.service.rest.v1.to.RegimeJuridicoTO;
import br.jus.tjms.sgpd.service.rest.v1.to.RegimePrevidenciaTO;
import br.jus.tjms.sgpd.service.rest.v1.to.TurnoCargoTO;
import br.jus.tjms.sgpd.service.rest.v1.to.TurnoTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @version 1.0
 * @created 11-dez-2015 18:15:46
 */
@Path("/rest/v1")
public class RESTServicesEstruturaCargosPortal extends RESTServicesBasePortalV1 implements ServicesPortal {

	private static final long serialVersionUID = -1100479052640377086L;
    private static Logger logger = LoggerFactory.getLogger(RESTServicesEstruturaCargosPortal.class);
	
	@EJB
	private FuncionarioService funcionarioService;
	
	@EJB
	private CargoService cargoService;
	
	@EJB
	private CargoAreaService cargoAreaService;
	
	@EJB
	private CargoAreaEstoqueService cargoAreaEstoqueService;
	
	@EJB
	private CargoAreaMovimentoService cargoAreaMovimentoService; 
	
	@EJB
	private CargoEspecialidadeService cargoEspecialidadeService;
	
	@EJB
	private EspecialidadeService especialidadeService;

	@EJB
	private CargoFormaProvimentoService cargoFormaProvimentoService; 
	
	@EJB
	private CargoHistoricoNomeService cargoHistoricoNomeService;
	
	@EJB
	private CargoOcupacaoService cargoOcupacaoService;
	
	@EJB
	private OcupacaoService ocupacaoService;
	
	@EJB
	private CargoRegimeJuridicoService cargoRegimeJuridicoService;
	
	@EJB
	private CargoTipoProvimentoService cargoTipoProvimentoService;
	
	@EJB
	private PreRequisitoAtitudeService preRequisitoAtitudeService;
	
	@EJB
	private PreRequisitoCertificacaoService preRequisitoCertificacaoService;
	
	@EJB
	private EntidadeCertificadoraService entidadeCertificadoraService;
	
	@EJB
	private CertificacaoService certificacaoService;
	
	@EJB
	private PreRequisitoCompetenciaService preRequisitoCompetenciaService;
	
	@EJB
	private PreRequisitoConhecimentoService preRequisitoConhecimentoService;
	
	@EJB
	private PreRequisitoCursoService preRequisitoCursoService;
	
	@EJB
	private PreRequisitoExperienciaService preRequisitoExperienciaService;
	
	@EJB
	private PreRequisitoFormacaoAcademicaService preRequisitoFormacaoAcademicaService; 
	
	@EJB
	private PreRequisitoHabilidadeService preRequisitoHabilidadeService;

	@EJB
	private PreRequisitoRegistroOrgaoClasseService preRequisitoRegistroOrgaoClasseService;
	
	@EJB
	private OrgaoRegionalClasseService orgaoRegionalClasseService;
	
	@EJB
	private TurnoCargoService turnoCargoService;
	
	@EJB
	private TurnoService turnoService;
	
	@EJB
	private QuadroPessoalService quadroPessoalService;
	
	@EJB
	private GrupoCargoService grupoCargoService;
	
	@EJB
	private PlanoCargoService planoCargoService;
	
	@EJB
	private EstruturaCargoService estruturaCargoService;	
	
	@EJB
	private ReferenciaService referenciaService;
	
	@EJB
	private ReferenciaValorService referenciaValorService;
	
	@EJB
	private RegimeJuridicoService regimeJuridicoService;
	
	@EJB
	private EntidadePrevidenciariaService entidadePrevidenciariaService;
	
	@EJB
	private RegimePrevidenciaService regimePrevidenciaService;
	
	@EJB
	private RegimeJuridicoRegimePrevidenciaService regimeJuridicoRegimePrevidenciaService;
	
	// estrutura de cargos
	/*
	 * Cargo:
	 * listarCargos 								GET		/cargos/
	 * pesquisarCargosPorNome						GET		/pesquisas/cargos/nome/
	 * obterCargo  									GET		/cargos/1
	 * criarCargo    								POST 	/cargos/...
	 * alterarCargo  								PUT 	/cargos/1/...
	 * removerCargo  								DELETE 	/cargos/1
	 * 
	 * CargoArea: (áreas vinculadas ao cargo)
	 * listarAreasDoCargo							GET		/cargos/1/areas/
	 * obterCargoArea								GET		/cargos/1/areas/1
	 * criarCargoArea								POST	/cargos/1/areas/...
	 * alterarCargoArea								PUT		/cargos/1/areas/1/...
	 * removerCargoArea								DELETE	/cargos/1/areas/1
	 * 
	 * CargoAreaEstoque: (estoque do cargo vinculado à área)
	 * listarEstoqueDoCargoArea						GET		/cargos/1/areas/1/estoques/
	 * obterCargoAreaEstoque						GET		/cargos/1/areas/1/estoques/1
	 * criarCargoAreaEstque							POST	/cargos/1/areas/1/estoques/...
	 * alterarCargoArea								PUT		/cargos/1/areas/1/estoques/1/...
	 * removerCargoArea								DELETE	/cargos/1/areas/1/estoques/1
	 * 
	 * CargoAreaMovimento: (movimentos do cargo vinculado à area)
	 * listarMovimentosDoCargoArea					GET		/cargos/1/areas/1/movimentos/
	 * obterCargoAreaMovimento						GET		/cargos/1/areas/1/movimentos/1
	 * criarCargoAreaMovimento						POST	/cargos/1/areas/1/movimentos/...
	 * alterarCargoAreaMovimento					PUT		/cargos/1/areas/1/movimentos/1/...
	 * removerCargoAreaMovimento					DELETE	/cargos/1/areas/1/movimentos/1
	 * 
	 * CargoEspecialidade: (especialidades do cargo)
	 * listarEspecialidadesDoCargo					GET		/cargos/1/especialidades/
	 * obterCargoEspecialidade						GET		/cargos/1/especialidades/1
	 * criarCargoEspecialidade						POST	/cargos/1/especialidades/...
	 * alterarCargoEspecialidade					PUT		/cargos/1/especialidades/1/...
	 * removerCargoEspecialidade					DELETE	/cargos/1/especialidades/1
	 * 
	 * Especialidade:
	 * listarEspecialidades							GET		/especialidades/
	 * pesquisarEspecialidadesPorNome				GET		/pesquisas/especialidades/nome/
	 * obterEspecialidade  							GET		/especialidades/1
	 * criarEspecialidade   						POST 	/especialidades/...
	 * alterarEspecialidade 						PUT 	/especialidades/1/...
	 * removerEspecialidade 						DELETE 	/especialidades/1
	 * 
	 * CargoFormaProvimento:
	 * listarFormasProvimentoDoCargo				GET		/cargos/1/formas-provimento/
	 * obterCargoFormaProvimento					GET		/cargos/1/formas-provimento/1
	 * criarCargoFormaProvimento					POST	/cargos/1/formas-provimento/...
	 * alterarCargoFormaProvimento					PUT		/cargos/1/formas-provimento/1/...
	 * removerCargoFormaProvimento					DELETE	/cargos/1/formas-provimento/1
	 * 
	 * CargoHistoricoNome:
	 * listarHistoricoNomeDoCargo					GET		/cargos/1/historicos-nome/
	 * obterHistoricoNomeCargo						GET		/cargos/1/historicos-nome/1
	 * criarHistoricoNomeCargo						POST	/cargos/1/historicos-nome/...
	 * alterarHistoricoNomeCargo					PUT		/cargos/1/historicos-nome/1/...
	 * removerHistoricoNomeCargo					DELETE	/cargos/1/historicos-nome/1
	 * 
	 * CargoOcupacao:
	 * listarOcupacoesDoCargo						GET		/cargos/1/ocupacoes/
	 * obterCargoOcupacao							GET		/cargos/1/ocupacoes/1
	 * criarCargoOcupacao							POST	/cargos/1/ocupacoes/...
	 * alterarCargoOcupacao							PUT		/cargos/1/ocupacoes/1/...
	 * removerCargoOcupacao							DELETE	/cargos/1/ocupacoes/1
	 * 
	 * Ocupacao:
	 * listarOcupacoes								GET		/ocupacoes/
	 * pesquisarOcupacoesPorNome					GET		/pesquisas/ocupacoes/nome/
	 * obterOcupacao  								GET		/ocupacoes/1
	 * criarOcupacao   								POST 	/ocupacoes/...
	 * alterarOcupacao 								PUT 	/ocupacoes/1/...
	 * removerOcupacao		 						DELETE 	/ocupacoes/1
	 * 
	 * CargoRegimeJuridico:
	 * listarRegimeJuridicoDoCargo					GET		/cargos/1/regimes-juridicos/
	 * obterCargoRegimeJuridico						GET		/cargos/1/regimes-juridicos/1
	 * criarCargoRegimeJuridico						POST	/cargos/1/regimes-juridicos/...
	 * alterarCargoRegimeJuridico					PUT		/cargos/1/regimes-juridicos/1/...
	 * removerCargoRegimeJuridico					DELETE	/cargos/1/regimes-juridicos/1
	 * 
	 * CargoTipoProvimento:
	 * listarTiposProvimentoDoCargo					GET		/cargos/1/tipos-provimento/
	 * obterCargoTipoProvimento						GET		/cargos/1/tipos-provimento/1
	 * criarCargoTipoProvimento						POST	/cargos/1/tipos-provimento/...
	 * alterarCargoTipoProvimento					PUT		/cargos/1/tipos-provimento/1/...
	 * removerCargoTipoProvimento					DELETE	/cargos/1/tipos-provimento/1
	 * 
	 * PreRequisitoAtitude:
	 * listarPreRequisitosDeAtitudeDoCargo			GET		/cargos/1/pre-requisitos-atitude/
	 * obterPreRequisitoAtitude						GET		/cargos/1/pre-requisitos-atitude/1
	 * criarPreRequisitoAtitude						POST	/cargos/1/pre-requisitos-atitude/...
	 * alterarPreRequisitoAtitude					PUT		/cargos/1/pre-requisitos-atitude/1/...
	 * removerPreRequisitoAtitude					DELETE	/cargos/1/pre-requisitos-atitude/1
	 * 
	 * PreRequisitoCertificacao
	 * listarPreRequisitosDeCertificacaoDoCargo		GET		/cargos/1/pre-requisitos-certificacao/
	 * obterPreRequisitoCertificacao				GET		/cargos/1/pre-requisitos-certificacao/1
	 * criarPreRequisitoCertificacao				POST	/cargos/1/pre-requisitos-certificacao/...
	 * alterarPreRequisitoCertificacao				PUT		/cargos/1/pre-requisitos-certificacao/1/...
	 * removerPreRequisitoCertificacao				DELETE	/cargos/1/pre-requisitos-certificacao/1
	 * 
	 * EntidadeCertificadora:
	 * listarEntidadesCertificadoras				GET		/entidades-certificadoras/
	 * pesquisarEntidadeCertificadoraPorNome		GET		/pesquisas/entidades-certificadoras/nome/
	 * obterEntidadeCertificadora  					GET		/entidades-certificadoras/1
	 * criarEntidadeCertificadora  					POST 	/entidades-certificadoras/...
	 * alterarEntidadeCertificadora					PUT 	/entidades-certificadoras/1/...
	 * removerEntidadeCertificadora					DELETE 	/entidades-certificadoras/1
	 *
	 * Certificacao:
	 * listarCertificacoesDaEntidade				GET		/entidades-certificadoras/1/certificacoes/
	 * pesquisarCertificacoesPorNome				GET		/pesquisas/certificacoes/nome/
	 * obterCertificacaoDaEntidade  				GET		/entidades-certificadoras/1/certificacoes/1
	 * criarCertificacaoDaEntidade  				POST 	/entidades-certificadoras/1/certificacoes/...
	 * alterarCertificacaoDaEntidade				PUT 	/entidades-certificadoras/1/certificacoes/1/...
	 * removerCertificacaoDaEntidade				DELETE 	/entidades-certificadoras/1/certificacoes/1
	 * 
	 * PreRequisitoCompetencia: 
	 * listarPreRequisitosDeCompetenciaDoCargo		GET		/cargos/1/pre-requisitos-competencia/
	 * obterPreRequisitoCompetencia					GET		/cargos/1/pre-requisitos-competencia/1
	 * criarPreRequisitoCompetencia					POST	/cargos/1/pre-requisitos-competencia/
	 * alterarPreRequisitoCompetencia				PUT		/cargos/1/pre-requisitos-competencia/1
	 * removerPreRequisitoCompetencia				DELETE	/cargos/1/pre-requisitos-competencia/1
	 * 
	 * PreRequisitoConhecimento:
	 * listarPreRequisitosDeConhecimentoDoCargo		GET		/cargos/1/pre-requisitos-conhecimento/
	 * obterPreRequisitoConhecimento				GET		/cargos/1/pre-requisitos-conhecimento/1
	 * criarPreRequisitoConhecimento				POST	/cargos/1/pre-requisitos-conhecimento/
	 * alterarPreRequisitoConhecimento				PUT		/cargos/1/pre-requisitos-conhecimento/1
	 * removerPreRequisitoConhecimento				DELETE	/cargos/1/pre-requisitos-conhecimento/1
 
	 * PreRequisitoCurso:
	 * listarPreRequisitosDeCursoDoCargo			GET		/cargos/1/pre-requisitos-curso/
	 * obterPreRequisitoCurso						GET		/cargos/1/pre-requisitos-curso/1
	 * criarPreRequisitoCurso						POST	/cargos/1/pre-requisitos-curso/
	 * alterarPreRequisitoCurso						PUT		/cargos/1/pre-requisitos-curso/1
	 * removerPreRequisitoCurso						DELETE	/cargos/1/pre-requisitos-curso/1
	 * 
	 * PreRequisitoExperiencia:
	 * listarPreRequisitosDeExperienciaDoCargo		GET		/cargos/1/pre-requisitos-experiencia/
	 * obterPreRequisitoExperiencia					GET		/cargos/1/pre-requisitos-experiencia/1
	 * criarPreRequisitoExperiencia					POST	/cargos/1/pre-requisitos-experiencia/
	 * alterarPreRequisitoExperiencia				PUT		/cargos/1/pre-requisitos-experiencia/1
	 * removerPreRequisitoExperiencia				DELETE	/cargos/1/pre-requisitos-experiencia/1
	 * 
	 * PreRequisitoFormacaoAcademica:
	 * listarPreRequisitosDeFormacaoAcademicaDoCargo		GET		/cargos/1/pre-requisitos-formacao-academica/
	 * obterPreRequisitoFormacaoAcademica					GET		/cargos/1/pre-requisitos-formacao-academica/1
	 * criarPreRequisitoFormacaoAcademica					POST	/cargos/1/pre-requisitos-formacao-academica/
	 * alterarPreRequisitoFormacaoAcademica					PUT		/cargos/1/pre-requisitos-formacao-academica/1
	 * removerPreRequisitoFormacaoAcademica					DELETE	/cargos/1/pre-requisitos-formacao-academica/1
	 * 
	 * PreRequisitoHabilidade:
	 * listarPreRequisitosDeHabilidadesDoCargo				GET		/cargos/1/pre-requisitos-habilidades/
	 * obterPreRequisitoHabilidade							GET		/cargos/1/pre-requisitos-habilidades/1
	 * criarPreRequisitoHabilidade							POST	/cargos/1/pre-requisitos-habilidades/
	 * alterarPreRequisitoHabilidade						PUT		/cargos/1/pre-requisitos-habilidades/1
	 * removerPreRequisitoHabilidade						DELETE	/cargos/1/pre-requisitos-habilidades/1
	 * 
	 * PreRequisitoRegistroOrgaoClasse:
	 * listarPreRequisitosDeRegistroOrgaoClasseDoCargo		GET		/cargos/1/pre-requisitos-registro-orgao-classe/
	 * obterPreRequisitoRegistroOrgaoClasse					GET		/cargos/1/pre-requisitos-registro-orgao-classe/1
	 * criarPreRequisitoRegistroOrgaoClasse					POST	/cargos/1/pre-requisitos-registro-orgao-classe/
	 * alterarPreRequisitoRegistroOrgaoClasse				PUT		/cargos/1/pre-requisitos-registro-orgao-classe/1
	 * removerPreRequisitoRegistroOrgaoClasse				DELETE	/cargos/1/pre-requisitos-registro-orgao-classe/1
	 * 
	 * OrgaoRegionalClasse:
	 * listarOrgaoRegionalClasse					GET		/orgaos-regionais-classe/
	 * obterOrgaoRegionalClasse						GET		/orgaos-regionais-classe/1
	 * criarOrgaoRegionalClasse						POST	/orgaos-regionais-classe/...
	 * alterarOrgaoRegionalClasse					PUT		/orgaos-regionais-classe/1/...
	 * removerOrgaoRegionalClasse					DELETE	/orgaos-regionais-classe/1
	 * 
	 * TurnoCargo:
	 * listarTurnoCargo								GET		/cargos/1/turnos/
	 * obterTurnoCargo								GET		/cargos/1/turnos/1
	 * criarTurnoCargo								POST	/cargos/1/turnos/
	 * alterarTurnoCargo							PUT		/cargos/1/turnos/1
	 * removerTurnoCargo							DELETE	/cargos/1/turnos/1
	 * 
	 * Turno:
	 * listarTurnos									GET		/turnos/
	 * obterTurno									GET		/turnos/1
	 * criarTurno									POST	/turnos/...
	 * alterarTurno									PUT		/turnos/1/...
	 * removerTurno									DELETE	/turnos/1
	 *
	 * QuadroPessoal:
	 * listarQuadroPessoal							GET		/quadros-pessoal/
	 * obterQuadroPessoal							GET		/quadros-pessoal/1
	 * criarQuadroPessoal							POST	/quadros-pessoal/...
	 * alterarQuadroPessoal							PUT		/quadros-pessoal/1/...
	 * removerQuadroPessoal							DELETE	/quadros-pessoal/1
	 * 
	 * GrupoCargo:
	 * listarGruposCargoDoQuadroPessoal				GET		/quadros-pessoal/1/grupos-cargo/
	 * obterGrupoCargo								GET		/quadros-pessoal/1/grupos-cargo/1
	 * criarGrupoCargo								POST	/quadros-pessoal/1/grupos-cargo/
	 * alterarGrupoCargo							PUT		/quadros-pessoal/1/grupos-cargo/1
	 * removerGrupoCargo							DELETE	/quadros-pessoal/1/grupos-cargo/1
	 * 
	 * PlanoCargo:
	 * listarPlanoCargo								GET		/planos-cargo/
	 * obterPlanoCargo								GET		/planos-cargo/1
	 * criarPlanoCargo								POST	/planos-cargo/...
	 * alterarPlanoCargo							PUT		/planos-cargo/1/...
	 * removerPlanoCargo							DELETE	/planos-cargo/1
	 * 
	 * Referencia (referências do cargo):
	 * listarReferenciasDoCargo						GET		/cargos/1/referencias/
	 * obterReferencia								GET		/cargos/1/referencias/1
	 * criarReferencia								POST	/cargos/1/referencias/
	 * alterarReferencia							PUT		/cargos/1/referencias/1
	 * removerReferencia							DELETE	/cargos/1/referencias/1
	 * 
	 * ReferenciaValor (valores da referência):
	 * listarValoresDaReferenciaDoCargo				GET		/cargos/1/referencias/1/valores/
	 * obterReferenciaValor							GET		/cargos/1/referencias/1/valores/1
	 * criarReferenciaValor							POST	/cargos/1/referencias/1/valores/...
	 * alterarReferenciaValor						PUT		/cargos/1/referencias/1/valores/1/...
	 * removerReferenciaValor						DELETE	/cargos/1/referencias/1/valores/1
	 * 
	 * RegimeJuridico:
	 * listarRegimeJuridico							GET		/regimes-juridicos/
	 * obterRegimeJuridico							GET		/regimes-juridicos/1
	 * criarRegimeJuridico							POST	/regimes-juridicos/...
	 * alterarRegimeJuridico						PUT		/regimes-juridicos/1/...
	 * removerRegimeJuridico						DELETE	/regimes-juridicos/1
	 * 
	 * EntidadePrevidenciaria:
	 * listarEntidadePrevidenciaria					GET		/entidades-previdenciarias/
	 * obterEntidadePrevidenciaria					GET		/entidades-previdenciarias/1
	 * criarEntidadePrevidenciaria					POST	/entidades-previdenciarias/...
	 * alterarEntidadePrevidenciaria				PUT		/entidades-previdenciarias/1/...
	 * removerEntidadePrevidenciaria				DELETE	/entidades-previdenciarias/1
	 * 
	 * RegimePrevidencia:
	 * listarRegimesDePrevidencia					GET		/regimes-previdencia/
	 * listarRegimesDePrevidenciaPorEntidade		GET		/entidades-previdenciarias/1/regimes-previdencia/
	 * listarRegimesDePrevidenciaPorRegimeJuridico	GET		/regimes-juridicos/1/regimes-previdencia/
	 * obterRegimePrevidencia						GET		/regimes-previdencia/1/
	 * criarRegimePrevidencia						POST	/regimes-previdencia/...
	 * alterarRegimePrevidencia						PUT		/regimes-previdencia/1/...
	 * removerRegimePrevidencia						DELETE	/regimes-previdencia/1
	 * 
	 * RegimeJuridicoRegimePrevidencia
	 * listarRegimesJuridicosPorRegimeDePrevidencia	GET		/regimes-previdencia/1/regimes-juridicos/
	 * listarRegimesDePrevidenciaPorRegimeJuridico	GET		/regimes-juridicos/1/regimes-previdencia/
	 * listarRegimeJuridicoRegimePrevidencia		GET		/regimes-juridicos-regimes-previdencia/
	 * obterRegimeJuridicoRegimePrevidencia			GET		/regimes-juridicos-regimes-previdencia/1/
	 * criarRegimeJuridicoRegimePrevidencia			POST	/regimes-juridicos-regimes-previdencia/...
	 * alterarRegimeJuridicoRegimePrevidencia		PUT		/regimes-juridicos-regimes-previdencia/1/...
	 * removerRegimeJuridicoRegimePrevidencia		DELETE	/regimes-juridicos-regimes-previdencia/1 
	 * 
	 */

	@GET()
	@Path("/cargos/")
	@Produces("application/json")
	public Response listarCargos(@HeaderParam("token") String token) {
		validarToken(token);
		List<Cargo> cargos = cargoService.buscarTodos();
		return ok(cargos);
	}

	@GET()
	@Path("/pesquisas/cargos/nome/{nome}")
	@Produces("application/json")
	public Response pesquisarCargosPorNome(@PathParam("nome") String nome, @HeaderParam("token") String token) {
		validarToken(token);
		List<Cargo> cargos = cargoService.buscarPorNome(nome);
		return ok(cargos);
	}

	@GET()
	@Path("/cargos/{id}/")
	@Produces("application/json")
	public Response obterCargo(@PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);
		Cargo cargo = cargoService.buscarPorId(id);
		return ok(cargo);
	}

	@POST()
	@Path("/cargos/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response criarCargo(CargoTO cargoTO, @HeaderParam("token") String token) {
		validarToken(token);
		Cargo cargo = new Cargo(cargoTO);
		
		try {			
			cargo = cargoService.salvar(cargo);
			return created(cargo.toTO());
		} catch (Exception e) {   
			logger.error(e.getMessage(), e);
			return internalServerError("Falha ao criar cargo: "+e.getMessage());
		}
	}

	@PUT()	
	@Path("/cargos/{id}/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response alterarCargo(@PathParam("id") Long id, CargoTO cargoTO, @HeaderParam("token") String token) {
		validarToken(token);
		
		Cargo cargo = cargoService.buscarPorId(id);
		if (cargo == null) {
			return notFound();
		}
		
		cargo.alterar(cargoTO);
		cargo = cargoService.salvar(cargo);
		return ok(cargo);
	}

	@DELETE()
	@Path("/cargos/{id}/")
	@Produces("application/json")
	public Response removerCargo(@PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);
		
		Cargo cargo = cargoService.buscarPorId(id);
		if (cargo == null) {
			return notFound();
		}
		
		cargoService.excluir(cargo);
		return ok();
	}

	@GET()
	@Path("/cargos/{id}/areas/")
	@Produces("application/json")
	public Response listarAreasDoCargo(@PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);
		List<CargoArea> cargoAreas = cargoAreaService.buscarPorCargo(id);
		return ok(cargoAreas);
	}

	@GET()
	@Path("/cargos/{cargoId}/areas/{cargoAreaId}/")
	@Produces("application/json")
	public Response obterCargoArea(@PathParam("cargoId") Long cargoId, @PathParam("cargoAreaId") Long cargoAreaId, 
			@HeaderParam("token") String token) {
		validarToken(token);
		CargoArea cargoArea = cargoAreaService.buscarPorId(cargoAreaId);
		return ok(cargoArea);
	}
	
	@POST()
	@Path("/cargos/{cargoId}/areas/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response criarCargoArea(@PathParam("cargoId") Long cargoId, CargoAreaTO cargoAreaTO, @HeaderParam("token") String token) {
		validarToken(token);
		CargoArea cargoArea = new CargoArea(cargoAreaTO);
		cargoArea = cargoAreaService.salvar(cargoArea);
		return ok(cargoArea);
	}

	@PUT()	
	@Path("/cargos/{cargoId}/areas/{cargoAreaId}/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response alterarCargoArea(@PathParam("cargoId") Long cargoId, @PathParam("cargoAreaId") Long cargoAreaId, CargoAreaTO cargoAreaTO, 
			@HeaderParam("token") String token) {
		validarToken(token);

		CargoArea cargoArea = cargoAreaService.buscarPorId(cargoAreaId);
		if (cargoArea == null) {
			return notFound();
		}
		
		cargoArea.alterar(cargoAreaTO);
		cargoArea = cargoAreaService.salvar(cargoArea);
		return ok(cargoArea);
	}

	@DELETE()
	@Path("/cargos/{cargoId}/areas/{cargoAreaId}/")
	@Produces("application/json")
	public Response removerCargoArea(@PathParam("cargoId") Long cargoId, @PathParam("cargoAreaId") Long cargoAreaId, 
			@HeaderParam("token") String token) {
		validarToken(token);

		CargoArea cargoArea = cargoAreaService.buscarPorId(cargoAreaId);
		if (cargoArea == null) {
			return notFound();
		}
		
		cargoAreaService.excluir(cargoArea);
		return ok();
	}

	@GET()
	@Path("/cargos/{cargoId}/areas/{cargoAreaId}/estoques/")
	@Produces("application/json")
	public Response listarEstoqueDoCargoArea(@PathParam("cargoId") Long cargoId, @PathParam("cargoAreaId") Long cargoAreaId, 
			@HeaderParam("token") String token) {
		validarToken(token);
		List<CargoAreaEstoque> cargoAreaEstoques = cargoAreaEstoqueService.buscarPorCargoArea(cargoAreaId);
		return ok(cargoAreaEstoques);
	}

	@GET()
	@Path("/cargos/{cargoId}/areas/{cargoAreaId}/estoques/{cargoAreaEstoqueId}/")
	@Produces("application/json")
	public Response obterCargoAreaEstoque(@PathParam("cargoId") Long cargoId, @PathParam("cargoAreaId") Long cargoAreaId, 
			@PathParam("cargoAreaEstoqueId") Long cargoAreaEstoqueId, @HeaderParam("token") String token) {
		validarToken(token);
		CargoAreaEstoque cargoAreaEstoque = cargoAreaEstoqueService.buscarPorId(cargoAreaEstoqueId);
		return ok(cargoAreaEstoque);
	}

	@POST()
	@Path("/cargos/{cargoId}/areas/{cargoAreaId}/estoques/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response criarCargoAreaEstoque(@PathParam("cargoId") Long cargoId, @PathParam("cargoAreaId") Long cargoAreaId, 
			CargoAreaEstoqueTO cargoAreaEstoqueTO, @HeaderParam("token") String token) {
		validarToken(token);
		CargoAreaEstoque cargoAreaEstoque = new CargoAreaEstoque(cargoAreaEstoqueTO);
		cargoAreaEstoque = cargoAreaEstoqueService.salvar(cargoAreaEstoque);
		return ok(cargoAreaEstoque);
	}

	@PUT()
	@Path("/cargos/{cargoId}/areas/{cargoAreaId}/estoques/{cargoAreaEstoqueId}/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response alterarCargoAreaEstoque(@PathParam("cargoId") Long cargoId, @PathParam("cargoAreaId") Long cargoAreaId,
			@PathParam("cargoAreaEstoqueId") Long cargoAreaEstoqueId, CargoAreaEstoqueTO cargoAreaEstoqueTO,
			@HeaderParam("token") String token) {
		validarToken(token);
		
		CargoAreaEstoque cargoAreaEstoque = cargoAreaEstoqueService.buscarPorId(cargoAreaEstoqueId);
		if (cargoAreaEstoque == null) {
			return notFound();
		}
		
		cargoAreaEstoque.alterar(cargoAreaEstoqueTO);
		cargoAreaEstoque = cargoAreaEstoqueService.salvar(cargoAreaEstoque);
		return ok(cargoAreaEstoque);
	}

	@DELETE()
	@Path("/cargos/{cargoId}/areas/{cargoAreaId}/estoques/{cargoAreaEstoqueId}/")
	@Produces("application/json")
	public Response removerCargoAreaEstoque(@PathParam("cargoId") Long cargoId, @PathParam("cargoAreaId") Long cargoAreaId,
			@PathParam("cargoAreaEstoqueId") Long cargoAreaEstoqueId, @HeaderParam("token") String token) {
		validarToken(token);

		CargoAreaEstoque cargoAreaEstoque = cargoAreaEstoqueService.buscarPorId(cargoAreaEstoqueId);
		if (cargoAreaEstoque == null) {
			return notFound();
		}
		
		cargoAreaEstoqueService.excluir(cargoAreaEstoque);
		return ok();
	}
	
	@GET()
	@Path("/cargos/{cargoId}/areas/{cargoAreaId}/movimentos/")
	@Produces("application/json")
	public Response listarMovimentosDoCargoArea(@PathParam("cargoId") Long cargoId, @PathParam("cargoAreaId") Long cargoAreaId, 
			@HeaderParam("token") String token) {
		validarToken(token);
		List<CargoAreaMovimento> cargoAreaMovimentos = cargoAreaMovimentoService.buscarPorCargoArea(cargoAreaId);
		return ok(cargoAreaMovimentos);
	}

	@GET()
	@Path("/cargos/{cargoId}/areas/{cargoAreaId}/movimentos/{id}/")
	@Produces("application/json")
	public Response obterCargoAreaMovimento(@PathParam("cargoId") Long cargoId, @PathParam("cargoAreaId") Long cargoAreaId, 
			@PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);
		CargoAreaMovimento cargoAreaMovimento = cargoAreaMovimentoService.buscarPorId(id);
		return ok(cargoAreaMovimento);
	}

	@POST()	
	@Path("/cargos/{cargoId}/areas/{cargoAreaId}/movimentos/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response criarCargoAreaMovimento(@PathParam("cargoId") Long cargoId, @PathParam("cargoAreaId") Long cargoAreaId, 
			CargoAreaMovimentoTO cargoAreaMovimentoTO, @HeaderParam("token") String token) {
		validarToken(token);
		CargoAreaMovimento cargoAreaMovimento = new CargoAreaMovimento(cargoAreaMovimentoTO);
		cargoAreaMovimento = cargoAreaMovimentoService.salvar(cargoAreaMovimento);
		return ok(cargoAreaMovimento);
	}

	@PUT()
	@Path("/cargos/{cargoId}/areas/{cargoAreaId}/movimentos/{cargoAreaMovimentoId}/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response alterarCargoAreaMovimento(@PathParam("cargoId") Long cargoId, @PathParam("cargoAreaId") Long cargoAreaId, 
			@PathParam("cargoAreaMovimentoId") Long cargoAreaMovimentoId, CargoAreaMovimentoTO cargoAreaMovimentoTO, 
			@HeaderParam("token") String token) {
		validarToken(token);

		CargoAreaMovimento cargoAreaMovimento = cargoAreaMovimentoService.buscarPorId(cargoAreaMovimentoId);
		if (cargoAreaMovimento == null) {
			return notFound();
		}
		
		cargoAreaMovimento.alterar(cargoAreaMovimentoTO);
		cargoAreaMovimento = cargoAreaMovimentoService.salvar(cargoAreaMovimento);
		return ok(cargoAreaMovimento);
	}

	@DELETE()
	@Path("/cargos/{cargoId}/areas/{cargoAreaId}/movimentos/{cargoAreaMovimentoId}/")
	@Produces("application/json")
	public Response removerCargoAreaMovimento(@PathParam("cargoId") Long cargoId, @PathParam("cargoAreaId") Long cargoAreaId, 
			@PathParam("cargoAreaMovimentoId") Long cargoAreaMovimentoId, @HeaderParam("token") String token) {
		validarToken(token);
		
		CargoAreaMovimento cargoAreaMovimento = cargoAreaMovimentoService.buscarPorId(cargoAreaMovimentoId);
		if (cargoAreaMovimento == null) {
			return notFound();
		}
		
		cargoAreaMovimentoService.excluir(cargoAreaMovimento);
		return ok();
	}

	@GET()
	@Path("/cargos/{cargoId}/especialidades/")
	@Produces("application/json")
	public Response listarEspecialidadesDoCargo(@PathParam("cargoId") Long cargoId, @HeaderParam("token") String token) {
		validarToken(token);
		List<CargoEspecialidade> cargoEspecialidades = cargoEspecialidadeService.buscarPorCargo(cargoId);
		return ok(cargoEspecialidades);
	}

	@GET()
	@Path("/cargos/{cargoId}/especialidades/{cargoEspecialidadeId}/")
	@Produces("application/json")
	public Response obterCargoEspecialidade(@PathParam("cargoId") Long cargoId, @PathParam("cargoEspecialidadeId") Long cargoEspecialidadeId, 
			@HeaderParam("token") String token) {
		validarToken(token);
		CargoEspecialidade cargoEspecialidade = cargoEspecialidadeService.buscarPorId(cargoEspecialidadeId);
		return ok(cargoEspecialidade);
	}

	@POST()
	@Path("/cargos/{cargoId}/especialidades/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response criarCargoEspecialidade(@PathParam("cargoId") Long cargoId, EspecialidadeTO especialidadeTO, 
			@HeaderParam("token") String token) {
		validarToken(token);
		
		Cargo cargo = cargoService.buscarPorId(cargoId);
		if (cargo == null) {
			return notFound();
		}
		
		try {
			CargoEspecialidade cargoEspecialidade = new CargoEspecialidade(cargo, especialidadeTO);
			cargoEspecialidade = cargoEspecialidadeService.salvar(cargoEspecialidade);
			return created(cargoEspecialidade);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return internalServerError("Falha ao criar especialidade do cargo: "+e.getMessage()); 			
		}
	}

	@PUT()
	@Path("/cargos/{cargoId}/especialidades/{cargoEspecialidadeId}/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response alterarCargoEspecialidade(@PathParam("cargoId") Long cargoId, 
			@PathParam("cargoEspecialidadeId") Long cargoEspecialidadeId, EspecialidadeTO especialidadeTO,
			@HeaderParam("token") String token) {
		validarToken(token);

		CargoEspecialidade cargoEspecialidade = cargoEspecialidadeService.buscarPorId(cargoEspecialidadeId);
		if (cargoEspecialidade == null) {
			return notFound();
		}
		
		cargoEspecialidade.alterar(especialidadeTO);
		cargoEspecialidade = cargoEspecialidadeService.salvar(cargoEspecialidade);
		return ok(cargoEspecialidade);
	}

	@DELETE()
	@Path("/cargos/{cargoId}/especialidades/{cargoEspecialidadeId}/")
	@Produces("application/json")
	public Response removerCargoEspecialidade(@PathParam("cargoId") Long cargoId, 
			@PathParam("cargoEspecialidadeId") Long cargoEspecialidadeId, 
			@HeaderParam("token") String token) {
		validarToken(token);
	
		CargoEspecialidade cargoEspecialidade = cargoEspecialidadeService.buscarPorId(cargoEspecialidadeId);
		if (cargoEspecialidade == null) {
			return notFound();
		}
		
		cargoEspecialidadeService.excluir(cargoEspecialidade);
		return ok();
	}

	@GET()
	@Path("/especialidades/")
	@Produces("application/json")
	public Response listarEspecialidades(@HeaderParam("token") String token) {
		validarToken(token);
		List<Especialidade> especialidades = especialidadeService.buscarTodos();
		return ok(especialidades);
	}

	@GET()
	@Path("/pesquisas/especialidades/nome/{nome}")
	@Produces("application/json")
	public Response pesquisarEspecialidadesPorNome(@PathParam("nome") String nome, @HeaderParam("token") String token) {
		validarToken(token);
		List<Especialidade> especialidades = especialidadeService.buscarPorNome(nome);
		return ok(especialidades);
	}
	
	@GET()
	@Path("/especialidades/{id}/")
	@Produces("application/json")
	public Response obterEspecialidade(@PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);
		Especialidade especialidade = especialidadeService.buscarPorId(id);
		return ok(especialidade);
	}

	@POST()
	@Path("/especialidades/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response criarEspecialidade(EspecialidadeTO especialidadeTO, @HeaderParam("token") String token) {
		validarToken(token);
		Especialidade especialidade = new Especialidade(especialidadeTO);
		try {
			especialidade = especialidadeService.salvar(especialidade);
			return created(especialidade);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return internalServerError("Falha ao criar especialidade: "+e.getMessage());
		}
	}

	@PUT()
	@Path("/especialidades/{id}/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response alterarEspecialidade(@PathParam("id") Long id, EspecialidadeTO especialidadeTO, @HeaderParam("token") String token) {
		validarToken(token);
		
		Especialidade especialidade = especialidadeService.buscarPorId(id);
		if (especialidade == null) {
			return notFound();
		}
		
		especialidade.alterar(especialidadeTO);
		especialidade = especialidadeService.salvar(especialidade);
		return ok(especialidade);
	}

	@DELETE()
	@Path("/especialidades/{id}/")
	@Produces("application/json")
	public Response removerEspecialidade(@PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);
		
		Especialidade especialidade = especialidadeService.buscarPorId(id);
		if (especialidade == null) {
			return notFound();
		}
		
		especialidadeService.excluir(especialidade);
		return ok();
	}

	@GET()
	@Path("/cargos/{cargoId}/formas-provimento/")
	@Produces("application/json")
	public Response listarFormasProvimentoDoCargo(@PathParam("cargoId") Long cargoId, @HeaderParam("token") String token) {
		validarToken(token);
		List<CargoFormaProvimento> cargoFormasProvimento = cargoFormaProvimentoService.buscarPorCargo(cargoId);
		return ok(cargoFormasProvimento);
	}

	@GET()
	@Path("/cargos/{cargoId}/formas-provimento/{id}/")
	@Produces("application/json")
	public Response obterCargoFormaProvimento(@PathParam("cargoId") Long cargoId, @PathParam("id") Long id, 
			@HeaderParam("token") String token) {
		validarToken(token);
		CargoFormaProvimento cargoFormaProvimento = cargoFormaProvimentoService.buscarPorId(id);
		return ok(cargoFormaProvimento);
	}

	@POST()
	@Path("/cargos/{cargoId}/formas-provimento/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response criarCargoFormaProvimento(@PathParam("cargoId") Long cargoId, FormaProvimento formaProvimento, @HeaderParam("token") String token) {
		validarToken(token);
		
		Cargo cargo = cargoService.buscarPorId(cargoId);
		if (cargo == null) {
			return notFound();
		}
		
		CargoFormaProvimento cargoFormaProvimento = new CargoFormaProvimento(cargo, formaProvimento);
		cargoFormaProvimento = cargoFormaProvimentoService.salvar(cargoFormaProvimento);
		return ok(cargoFormaProvimento);
	}

	@PUT()
	@Consumes("application/json")
	@Path("/cargos/{cargoId}/formas-provimento/{id}/")
	@Produces("application/json")
	public Response alterarCargoFormaProvimento(@PathParam("cargoId") Long cargoId, @PathParam("id") Long id, 
			FormaProvimento formaProvimento, @HeaderParam("token") String token) {
		validarToken(token);
		
		CargoFormaProvimento cargoFormaProvimento = cargoFormaProvimentoService.buscarPorId(id);
		Cargo cargo = cargoService.buscarPorId(cargoId);
		if (cargoFormaProvimento == null || cargo== null) {
			return notFound();
		}
		
		cargoFormaProvimento.alterar(cargo, formaProvimento);
		cargoFormaProvimento = cargoFormaProvimentoService.salvar(cargoFormaProvimento);
		return ok(cargoFormaProvimento);
	}

	@DELETE()
	@Path("/cargos/{cargoId}/formas-provimento/{id}/")
	@Produces("application/json")
	public Response removerCargoFormaProvimento(@PathParam("cargoId") Long cargoId, @PathParam("id") Long id, 
			@HeaderParam("token") String token) {
		validarToken(token);

		CargoFormaProvimento cargoFormaProvimento = cargoFormaProvimentoService.buscarPorId(id);
		if (cargoFormaProvimento == null) {
			return notFound();
		}
		
		cargoFormaProvimentoService.excluir(cargoFormaProvimento);
		return ok();
	}

	@GET()
	@Path("/cargos/{cargoId}/historicos-nome/")
	@Produces("application/json")
	public Response listarHistoricoNomeDoCargo(@PathParam("cargoId") Long cargoId, @HeaderParam("token") String token) {
		validarToken(token);
		List<CargoHistoricoNome> cargoHistoricosNome = cargoHistoricoNomeService.buscarPorCargo(cargoId);
		return ok(cargoHistoricosNome);
	}

	@GET()
	@Path("/cargos/{cargoId}/historicos-nome/{id}/")
	@Produces("application/json")
	public Response obterHistoricoNomeCargo(@PathParam("cargoId") Long cargoId, @PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);
		CargoHistoricoNome cargoHistoricoNome = cargoHistoricoNomeService.buscarPorId(id);
		return ok(cargoHistoricoNome);
	}

	@POST()
	@Path("/cargos/{cargoId}/historicos-nome/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response criarHistoricoNomeCargo(@PathParam("cargoId") Long cargoId, CargoHistoricoNomeTO cargoHistoricoNomeTO,  @HeaderParam("token") String token) {
		validarToken(token);
		CargoHistoricoNome cargoHistoricoNome = new CargoHistoricoNome(cargoHistoricoNomeTO);
		cargoHistoricoNome = cargoHistoricoNomeService.salvar(cargoHistoricoNome);
		return ok(cargoHistoricoNome);
	}

	@PUT()	
	@Path("/cargos/{cargoId}/historicos-nome/{id}/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response alterarHistoricoNomeCargo(@PathParam("cargoId") Long cargoId, @PathParam("id") Long id, 
			CargoHistoricoNomeTO cargoHistoricoNomeTO, @HeaderParam("token") String token) {
		validarToken(token);

		CargoHistoricoNome cargoHistoricoNome = cargoHistoricoNomeService.buscarPorId(id);
		if (cargoHistoricoNome == null) {
			return notFound();
		}
		
		cargoHistoricoNome.alterar(cargoHistoricoNomeTO);
		cargoHistoricoNome = cargoHistoricoNomeService.salvar(cargoHistoricoNome);
		return ok(cargoHistoricoNome);
	}

	@DELETE()
	@Path("/cargos/{cargoId}/historicos-nome/{id}/")
	@Produces("application/json")
	public Response removerHistoricoNomeCargo(@PathParam("cargoId") Long cargoId, @PathParam("id") Long id, 
			@HeaderParam("token") String token) {
		validarToken(token);

		CargoHistoricoNome cargoHistoricoNome = cargoHistoricoNomeService.buscarPorId(id);
		if (cargoHistoricoNome == null) {
			return notFound();
		}
		
		cargoHistoricoNomeService.excluir(cargoHistoricoNome);
		return ok();
	}

	@GET()
	@Path("/cargos/{cargoId}/ocupacoes/")
	@Produces("application/json")
	public Response listarOcupacoesDoCargo(@PathParam("cargoId") Long cargoId, @HeaderParam("token") String token) {
		validarToken(token);
		List<CargoOcupacao> ocupacoes = cargoOcupacaoService.buscarPorCargo(cargoId);
		return ok(ocupacoes);
	}
	
	@GET()
	@Path("/cargos/{cargoId}/ocupacoes/{id}/")
	@Produces("application/json")
	public Response obterCargoOcupacao(@PathParam("cargoId") Long cargoId, @PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);
		CargoOcupacao cargoOcupacao = cargoOcupacaoService.buscarPorId(id);
		return ok(cargoOcupacao);
	}

	@POST()
	@Path("/cargos/{cargoId}/ocupacoes/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response criarCargoOcupacao(@PathParam("cargoId") Long cargoId, OcupacaoTO ocupacaoTO, @HeaderParam("token") String token) {
		validarToken(token);
		
		Cargo cargo = cargoService.buscarPorId(cargoId);
		if (cargo == null) {
			return notFound();
		}
		
		CargoOcupacao cargoOcupacao = new CargoOcupacao(cargo, ocupacaoTO);
		cargoOcupacao = cargoOcupacaoService.salvar(cargoOcupacao);
		return ok(cargoOcupacao);
	}

	@PUT()
	@Path("/cargos/{cargoId}/ocupacoes/{id}/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response alterarCargoOcupacao(@PathParam("cargoId") Long cargoId, @PathParam("id") Long id, OcupacaoTO ocupacaoTO, @HeaderParam("token") String token) {
		validarToken(token);
		
		Cargo cargo = cargoService.buscarPorId(cargoId);
		CargoOcupacao cargoOcupacao = cargoOcupacaoService.buscarPorId(id);
		if (cargo == null || cargoOcupacao == null) {
			return notFound();
		}
		
		cargoOcupacao.alterar(cargo, ocupacaoTO);
		cargoOcupacao = cargoOcupacaoService.salvar(cargoOcupacao);
		return ok(cargoOcupacao);
	}

	@DELETE()
	@Path("/cargos/{cargoId}/ocupacoes/{id}/")
	@Produces("application/json")
	public Response removerCargoOcupacao(@PathParam("cargoId") Long cargoId, @PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);

		CargoOcupacao cargoOcupacao = cargoOcupacaoService.buscarPorId(id);
		if (cargoOcupacao == null) {
			return notFound();
		}
		
		cargoOcupacaoService.excluir(cargoOcupacao);
		return ok();
	}

	@GET()
	@Path("/ocupacoes/")
	@Produces("application/json")
	public Response listarOcupacoes(@HeaderParam("token") String token) {
		validarToken(token);
		List<CargoOcupacao> ocupacoes = cargoOcupacaoService.buscarTodos();
		return ok(ocupacoes);
	}

	@GET()
	@Path("/pesquisas/ocupacoes/nome/{nome}")
	@Produces("application/json")
	public Response pesquisarOcupacoesPorNome(@PathParam("nome") String nome, @HeaderParam("token") String token) {
		validarToken(token);
		List<Ocupacao> ocupacoes = ocupacaoService.buscarPorNome(nome);
		return ok(ocupacoes);
	}

	@GET()
	@Path("/ocupacoes/{id}/")
	@Produces("application/json")
	public Response obterOcupacao(@PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);
		Ocupacao ocupacao = ocupacaoService.buscarPorId(id);
		return ok(ocupacao);
	}

	@POST()
	@Path("/ocupacoes/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response criarOcupacao(OcupacaoTO ocupacaoTO, @HeaderParam("token") String token) {
		validarToken(token);
		
		try {
			Ocupacao ocupacao = new Ocupacao(ocupacaoTO);
			ocupacao = ocupacaoService.salvar(ocupacao);
			return created(ocupacao);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return internalServerError("Falha ao criar ocupação: "+e.getMessage());
			
		}
	}

	@PUT()
	@Path("/ocupacoes/{id}/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response alterarOcupacao(@PathParam("id") Long id, OcupacaoTO ocupacaoTO, @HeaderParam("token") String token) {
		validarToken(token);

		Ocupacao ocupacao = ocupacaoService.buscarPorId(id);
		if (ocupacao == null) {
			return notFound();
		}
		
		ocupacao.alterar(ocupacaoTO);
		ocupacao = ocupacaoService.salvar(ocupacao);
		return ok(ocupacao);
	}

	@DELETE()
	@Path("/ocupacoes/{id}/")
	@Produces("application/json")
	public Response removerOcupacao(@PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);

		Ocupacao ocupacao = ocupacaoService.buscarPorId(id);
		if (ocupacao == null) {
			return notFound();
		}
		
		ocupacaoService.excluir(ocupacao);
		return ok();
	}

	@GET()
	@Path("/cargos/{cargoId}/regimes-juridicos/")
	@Produces("application/json")
	public Response listarRegimeJuridicoDoCargo(@PathParam("cargoId") Long cargoId, @HeaderParam("token") String token) {
		validarToken(token);
		List<CargoRegimeJuridico> regimesJuridicos = cargoRegimeJuridicoService.buscarPorCargo(cargoId);
		return ok(regimesJuridicos);
	}

	@GET()
	@Path("/cargos/{cargoId}/regimes-juridicos/{id}/")
	@Produces("application/json")
	public Response obterCargoRegimeJuridico(@PathParam("cargoId") Long cargoId, @PathParam("id") Long id, 
			@HeaderParam("token") String token) {
		validarToken(token);
		CargoRegimeJuridico cargoRegimeJuridico = cargoRegimeJuridicoService.buscarPorId(id);
		return ok(cargoRegimeJuridico);
	}

	@POST()
	@Path("/cargos/{cargoId}/regimes-juridicos/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response criarCargoRegimeJuridico(@PathParam("cargoId") Long cargoId, RegimeJuridicoTO regimeJuridicoTO, 
			@HeaderParam("token") String token) {
		validarToken(token);
		
		Cargo cargo = cargoService.buscarPorId(cargoId);
		if (cargo == null) {
			return notFound();
		}
		
		CargoRegimeJuridico cargoRegimeJuridico = new CargoRegimeJuridico(cargo, regimeJuridicoTO);
		cargoRegimeJuridico = cargoRegimeJuridicoService.salvar(cargoRegimeJuridico);
		return ok(cargoRegimeJuridico);
	}

	@PUT()
	@Path("/cargos/{cargoId}/regimes-juridicos/{id}/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response alterarCargoRegimeJuridico(@PathParam("cargoId") Long cargoId, @PathParam("id") Long id, 
			RegimeJuridicoTO regimeJuridicoTO, @HeaderParam("token") String token) {
		validarToken(token);

		CargoRegimeJuridico cargoRegimeJuridico = cargoRegimeJuridicoService.buscarPorId(id);
		Cargo cargo = cargoService.buscarPorId(cargoId);
		if (cargoRegimeJuridico == null || cargo == null) {
			return notFound();
		}
		
		cargoRegimeJuridico.alterar(cargo, regimeJuridicoTO);
		cargoRegimeJuridico = cargoRegimeJuridicoService.salvar(cargoRegimeJuridico);
		return ok(cargoRegimeJuridico);
	}

	@DELETE()
	@Path("/cargos/{cargoId}/regimes-juridicos/{id}/")
	@Produces("application/json")
	public Response removerCargoRegimeJuridico(@PathParam("cargoId") Long cargoId, @PathParam("id") Long id, 
			@HeaderParam("token") String token) {
		validarToken(token);
		
		CargoRegimeJuridico cargoRegimeJuridico = cargoRegimeJuridicoService.buscarPorId(id);
		if (cargoRegimeJuridico == null) {
			return notFound();
		}
		
		cargoRegimeJuridicoService.excluir(cargoRegimeJuridico);
		return ok();
	}

	@GET()
	@Path("/cargos/{cargoId}/tipos-provimento/")
	@Produces("application/json")
	public Response listarTiposProvimentoDoCargo(@PathParam("cargoId") Long cargoId, @HeaderParam("token") String token) {
		validarToken(token);
		List<CargoTipoProvimento> tiposProvimento = cargoTipoProvimentoService.buscarPorCargo(cargoId);
		return ok(tiposProvimento);
	}

	@GET()
	@Path("/cargos/{cargoId}/tipos-provimento/{id}/")
	@Produces("application/json")
	public Response obterCargoTipoProvimento(@PathParam("cargoId") Long cargoId, @PathParam("id") Long id, 
			@HeaderParam("token") String token) {
		validarToken(token);
		CargoTipoProvimento cargoTipoProvimento = cargoTipoProvimentoService.buscarPorId(id);
		return ok(cargoTipoProvimento);
	}

	@POST()	
	@Path("/cargos/{cargoId}/tipos-provimento/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response criarCargoTipoProvimento(@PathParam("cargoId") Long cargoId, TipoProvimento tipoProvimento, @HeaderParam("token") String token) {
		validarToken(token);
		
		Cargo cargo = cargoService.buscarPorId(cargoId);
		if (cargo == null) {
			return notFound();
		}
		
		CargoTipoProvimento cargoTipoProvimento = new CargoTipoProvimento(cargo, tipoProvimento);
		cargoTipoProvimento = cargoTipoProvimentoService.salvar(cargoTipoProvimento);
		return ok(cargoTipoProvimento);
	}

	@PUT()	
	@Path("/cargos/{cargoId}/tipos-provimento/{id}/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response alterarCargoTipoProvimento(@PathParam("cargoId") Long cargoId, @PathParam("id") Long id, TipoProvimento tipoProvimento, 
			@HeaderParam("token") String token) {
		validarToken(token);

		CargoTipoProvimento cargoTipoProvimento = cargoTipoProvimentoService.buscarPorId(id);
		Cargo cargo = cargoService.buscarPorId(cargoId);
		if (cargo == null || cargoTipoProvimento == null) {
			return notFound();
		}
		
		cargoTipoProvimento.alterar(cargo, tipoProvimento);
		cargoTipoProvimento = cargoTipoProvimentoService.salvar(cargoTipoProvimento);
		return ok(cargoTipoProvimento);
	}

	@DELETE()
	@Path("/cargos/{cargoId}/tipos-provimento/{id}/")
	@Produces("application/json")
	public Response removerCargoTipoProvimento(@PathParam("cargoId") Long cargoId, @PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);

		CargoTipoProvimento cargoTipoProvimento = cargoTipoProvimentoService.buscarPorId(id);
		if (cargoTipoProvimento == null) {
			return notFound();
		}
		
		cargoTipoProvimentoService.excluir(cargoTipoProvimento);
		return ok();
	}

	@GET()
	@Path("/cargos/{cargoId}/pre-requisitos-atitude/")
	@Produces("application/json")
	public Response listarPreRequisitosDeAtitudeDoCargo(@PathParam("cargoId") Long cargoId, @HeaderParam("token") String token) {
		validarToken(token);
		List<PreRequisitoAtitude> preRequisitosAtitude = preRequisitoAtitudeService.buscarPorCargo(cargoId);
		return ok(preRequisitosAtitude);
	}

	@GET()
	@Path("/cargos/{cargoId}/pre-requisitos-atitude/{id}/")
	@Produces("application/json")
	public Response obterPreRequisitoAtitude(@PathParam("cargoId") Long cargoId, @PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);
		PreRequisitoAtitude preRequisitoAtitude = preRequisitoAtitudeService.buscarPorId(id);
		return ok(preRequisitoAtitude);
	}

	@POST()
	@Path("/cargos/{cargoId}/pre-requisitos-atitude/")	
	@Produces("application/json")
	@Consumes("application/json")
	public Response criarPreRequisitoAtitude(@PathParam("cargoId") Long cargoId, AtitudeTO atitudeTO, @HeaderParam("token") String token) {
		validarToken(token);
		
		Cargo cargo = cargoService.buscarPorId(cargoId);
		if (cargo == null) {
			return notFound();
		}
		
		PreRequisitoAtitude preRequisitoAtitude = new PreRequisitoAtitude(cargo, atitudeTO);
		preRequisitoAtitude = preRequisitoAtitudeService.salvar(preRequisitoAtitude);
		return ok(preRequisitoAtitude);
	}

	@PUT()
	@Path("/cargos/{cargoId}/pre-requisitos-atitude/{id}/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response alterarPreRequisitoAtitude(@PathParam("cargoId") Long cargoId, @PathParam("id") Long id, AtitudeTO atitudeTO, 
			@HeaderParam("token") String token) {
		validarToken(token);

		PreRequisitoAtitude preRequisitoAtitude = preRequisitoAtitudeService.buscarPorId(id);
		Cargo cargo = cargoService.buscarPorId(cargoId);
		if (cargo == null || preRequisitoAtitude == null) {
			return notFound();
		}
		
		preRequisitoAtitude.alterar(cargo, atitudeTO);
		preRequisitoAtitude = preRequisitoAtitudeService.salvar(preRequisitoAtitude);
		return ok(preRequisitoAtitude);
	}

	@DELETE()
	@Path("/cargos/{cargoId}/pre-requisitos-atitude/{id}/")
	@Produces("application/json")
	public Response removerPreRequisitoAtitude(@PathParam("cargoId") Long cargoId, @PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);

		PreRequisitoAtitude preRequisitoAtitude = preRequisitoAtitudeService.buscarPorId(id);
		if (preRequisitoAtitude == null) {
			return notFound();
		}
		
		preRequisitoAtitudeService.excluir(preRequisitoAtitude);
		return ok();
	}

	@GET()
	@Path("/cargos/{cargoId}/pre-requisitos-certificacao/")
	@Produces("application/json")
	public Response listarPreRequisitosDeCertificacaoDoCargo(@PathParam("cargoId") Long cargoId,
			@HeaderParam("token") String token) {
		validarToken(token);
		List<PreRequisitoCertificacao> preRequisitosCertificacao = preRequisitoCertificacaoService.buscarPorCargo(cargoId);
		return ok(preRequisitosCertificacao);
	}

	@GET()
	@Path("/cargos/{cargoId}/pre-requisitos-certificacao/{id}/")
	@Produces("application/json")
	public Response obterPreRequisitoCertificacao(@PathParam("cargoId") Long cargoId, @PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);
		PreRequisitoCertificacao preRequisitoCertificacao = preRequisitoCertificacaoService.buscarPorId(id);
		return ok(preRequisitoCertificacao);
	}

	@POST()
	@Path("/cargos/{cargoId}/pre-requisitos-certificacao/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response criarPreRequisitoCertificacao(@PathParam("cargoId") Long cargoId, CertificacaoTO certificacaoTO, @HeaderParam("token") String token) {
		validarToken(token);
		
		Cargo cargo = cargoService.buscarPorId(cargoId);
		if (cargo == null) {
			return notFound();
		}
		
		PreRequisitoCertificacao preRequisitoCertificacao = new PreRequisitoCertificacao(cargo, certificacaoTO);
		preRequisitoCertificacao = preRequisitoCertificacaoService.salvar(preRequisitoCertificacao);
		return ok(preRequisitoCertificacao);
	}

	@PUT()
	@Path("/cargos/{cargoId}/pre-requisitos-certificacao/{id}/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response alterarPreRequisitoCertificacao(@PathParam("cargoId") Long cargoId, @PathParam("id") Long id, 
			CertificacaoTO certificacaoTO, @HeaderParam("token") String token) {
		validarToken(token);

		Cargo cargo = cargoService.buscarPorId(cargoId);
		PreRequisitoCertificacao preRequisitoCertificacao = preRequisitoCertificacaoService.buscarPorId(id);
		if (cargo == null || preRequisitoCertificacao == null) {
			return notFound();
		}
		
		preRequisitoCertificacao.alterar(cargo, certificacaoTO);
		return ok(preRequisitoCertificacao);
	}

	@DELETE()
	@Path("/cargos/{cargoId}/pre-requisitos-certificacao/{id}/")
	@Produces("application/json")
	public Response removerPreRequisitoCertificacao(@PathParam("cargoId") Long cargoId, @PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);

		PreRequisitoCertificacao preRequisitoCertificacao = preRequisitoCertificacaoService.buscarPorId(id);
		if (preRequisitoCertificacao == null) {
			return notFound();
		}
		
		preRequisitoCertificacaoService.excluir(preRequisitoCertificacao);
		return ok();
	}

	@GET()
	@Path("/entidades-certificadoras/")
	@Produces("application/json")
	public Response listarEntidadesCertificadoras(@HeaderParam("token") String token) {
		validarToken(token);
		List<EntidadeCertificadora> entidadesCertificadoras = entidadeCertificadoraService.buscarTodos();
		return ok(entidadesCertificadoras);
	}

	@GET()
	@Path("/pesquisas/entidades-certificadoras/nome/{nome}")
	@Produces("application/json")
	public Response pesquisarEntidadeCertificadoraPorNome(@PathParam("nome") String nome, @HeaderParam("token") String token) {
		validarToken(token);
		List<EntidadeCertificadora> entidadesCertificadoras = entidadeCertificadoraService.buscarPorNome(nome);
		return ok(entidadesCertificadoras);
	}

	@GET()
	@Path("/entidades-certificadoras/{id}/")
	@Produces("application/json")
	public Response obterEntidadeCertificadora(@PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);
		EntidadeCertificadora entidadeCertificadora = entidadeCertificadoraService.buscarPorId(id);
		return ok(entidadeCertificadora);
	}
	
	@POST()	
	@Path("/entidades-certificadoras/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response criarEntidadeCertificadora(EntidadeCertificadoraTO entidadeCertificadoraTO, @HeaderParam("token") String token) {
		validarToken(token);
		EntidadeCertificadora entidadeCertificadora = new EntidadeCertificadora(entidadeCertificadoraTO);
		entidadeCertificadora =  entidadeCertificadoraService.salvar(entidadeCertificadora);
		return ok(entidadeCertificadora);
	}

	@PUT()
	@Path("/entidades-certificadoras/{id}/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response alterarEntidadeCertificadora(@PathParam("id") Long id, EntidadeCertificadoraTO entidadeCertificadoraTO, @HeaderParam("token") String token) {
		validarToken(token);

		EntidadeCertificadora entidadeCertificadora = entidadeCertificadoraService.buscarPorId(id);
		if (entidadeCertificadora == null) {
			return notFound();
		}
		
		entidadeCertificadora.alterar(entidadeCertificadoraTO);
		entidadeCertificadora =  entidadeCertificadoraService.salvar(entidadeCertificadora);
		return ok(entidadeCertificadora);
	}

	@DELETE()
	@Path("/entidades-certificadoras/{id}/")
	@Produces("application/json")
	public Response removerEntidadeCertificadora(@PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);

		EntidadeCertificadora entidadeCertificadora = entidadeCertificadoraService.buscarPorId(id);
		if (entidadeCertificadora == null) {
			return notFound();
		}
		
		entidadeCertificadoraService.excluir(entidadeCertificadora);
		return ok();
	}

	@GET()
	@Path("/entidades-certificadoras/{entidadeCertificadoraId}/certificacoes/")
	@Produces("application/json")
	public Response listarCertificacoesDaEntidade(@PathParam("entidadeCertificadoraId") Long entidadeCertificadoraId, @HeaderParam("token") String token) {
		validarToken(token);
		List<Certificacao> certificicacoes = certificacaoService.buscarPorEntidadeCertificadora(entidadeCertificadoraId);
		return ok(certificicacoes);
	}

	@GET()
	@Path("/pesquisas/certificacoes/nome/{nome}")
	@Produces("application/json")
	public Response pesquisarCertificacoesPorNome(@PathParam("nome") String nome, @HeaderParam("token") String token) {
		validarToken(token);
		List<Certificacao> certificicacoes = certificacaoService.buscarPorNome(nome);
		return ok(certificicacoes);
	}

	@GET()
	@Path("/entidades-certificadoras/{entidadeCertificadoraId}/certificacoes/{id}/")
	@Produces("application/json")
	public Response obterCertificacaoDaEntidade(@PathParam("entidadeCertificadoraId") Long entidadeCertificadoraId, 
			@PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);
		Certificacao certificacao = certificacaoService.buscarPorId(id);
		return ok(certificacao);
	}

	@POST()	
	@Path("/entidades-certificadoras/{id}/certificacoes/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response criarCertificacaoDaEntidade(@PathParam("id") Long id, CertificacaoTO certificacaoTO, @HeaderParam("token") String token) {
		validarToken(token);
		Certificacao certificacao = new Certificacao(certificacaoTO);
		certificacao = certificacaoService.salvar(certificacao);
		return ok(certificacao);
	}

	@PUT()
	@Path("/entidades-certificadoras/{entidadeCertificadoraId}/certificacoes/{id}/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response alterarCertificacaoDaEntidade(@PathParam("entidadeCertificadoraId") Long entidadeCertificadoraId, 
			@PathParam("id") Long id, CertificacaoTO certificacaoTO, @HeaderParam("token") String token) {
		validarToken(token);

		Certificacao certificacao = certificacaoService.buscarPorId(id);
		if (certificacao == null) {
			return notFound();
		}
		
		certificacao.alterar(certificacaoTO);
		certificacao = certificacaoService.salvar(certificacao);
		return ok(certificacao);
	}

	@DELETE()
	@Path("/entidades-certificadoras/{entidadeCertificadoraId}/certificacoes/{id}/")
	@Produces("application/json")
	public Response removerCertificacaoDaEntidade(@PathParam("entidadeCertificadoraId") Long entidadeCertificadoraId, 
			@PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);

		Certificacao certificacao = certificacaoService.buscarPorId(id);
		if (certificacao == null) {
			return notFound();
		}
		
		certificacaoService.excluir(certificacao);
		return ok();
	}

	@GET()
	@Path("/cargos/{cargoId}/pre-requisitos-competencia/")
	@Produces("application/json")
	public Response listarPreRequisitosDeCompetenciaDoCargo(@PathParam("cargoId") Long cargoId, @HeaderParam("token") String token) {
		validarToken(token);
		List<PreRequisitoCompetencia> preRequisitosCompetencia = preRequisitoCompetenciaService.buscarPorCargo(cargoId);
		return ok(preRequisitosCompetencia);
	}

	@GET()
	@Path("/cargos/{cargoId}/pre-requisitos-competencia/{id}/")
	@Produces("application/json")
	public Response obterPreRequisitoCompetencia(@PathParam("cargoId") Long cargoId, @PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);
		PreRequisitoCompetencia preRequisitosCompetencia = preRequisitoCompetenciaService.buscarPorId(id);
		return ok(preRequisitosCompetencia);
	}

	@POST()
	@Path("/cargos/{cargoId}/pre-requisitos-competencia/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response criarPreRequisitoCompetencia(@PathParam("cargoId") Long cargoId, CompetenciaTO competenciaTO, @HeaderParam("token") String token) {
		validarToken(token);
		
		Cargo cargo = cargoService.buscarPorId(cargoId);
		if (cargo == null) {
			return notFound();
		}
		
		PreRequisitoCompetencia preRequisitosCompetencia = new PreRequisitoCompetencia(cargo, competenciaTO);
		preRequisitosCompetencia = preRequisitoCompetenciaService.salvar(preRequisitosCompetencia);
		return ok(preRequisitosCompetencia);
	}

	@PUT()
	@Path("/cargos/{cargoId}/pre-requisitos-competencia/{id}/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response alterarPreRequisitoCompetencia(@PathParam("cargoId") Long cargoId, @PathParam("id") Long id, 
			CompetenciaTO competenciaTO, @HeaderParam("token") String token) {
		validarToken(token);

		Cargo cargo = cargoService.buscarPorId(cargoId);
		PreRequisitoCompetencia preRequisitosCompetencia = preRequisitoCompetenciaService.buscarPorId(id);
		if (cargo == null || preRequisitosCompetencia == null) {
			return notFound();
		}
		
		preRequisitosCompetencia.alterar(cargo, competenciaTO);
		preRequisitosCompetencia = preRequisitoCompetenciaService.salvar(preRequisitosCompetencia);
		return ok(preRequisitosCompetencia);
	}

	@DELETE()
	@Path("/cargos/{cargoId}/pre-requisitos-competencia/{id}/")
	@Produces("application/json")
	public Response removerPreRequisitoCompetencia(@PathParam("cargoId") Long cargoId, @PathParam("id") Long id, 
			@HeaderParam("token") String token) {
		validarToken(token);

		PreRequisitoCompetencia preRequisitosCompetencia = preRequisitoCompetenciaService.buscarPorId(id);
		if (preRequisitosCompetencia == null) {
			return notFound();
		}
		
		preRequisitoCompetenciaService.excluir(preRequisitosCompetencia);
		return ok();
	}

	@GET()
	@Path("/cargos/{cargoId}/pre-requisitos-conhecimento/")
	@Produces("application/json")
	public Response listarPreRequisitosDeConhecimentoDoCargo(@PathParam("cargoId") Long cargoId,
			@HeaderParam("token") String token) {
		validarToken(token);
		List<PreRequisitoConhecimento> preRequisitosConhecimento = preRequisitoConhecimentoService.buscarPorCargo(cargoId);
		return ok(preRequisitosConhecimento);
	}

	@GET()
	@Path("/cargos/{cargoId}/pre-requisitos-conhecimento/{id}/")
	@Produces("application/json")
	public Response obterPreRequisitoConhecimento(@PathParam("cargoId") Long cargoId, @PathParam("id") Long id, 
			@HeaderParam("token") String token) {
		validarToken(token);
		PreRequisitoConhecimento preRequisitoConhecimento = preRequisitoConhecimentoService.buscarPorId(id);
		return ok(preRequisitoConhecimento);
	}

	@POST()
	@Path("/cargos/{cargoId}/pre-requisitos-conhecimento/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response criarPreRequisitoConhecimento(@PathParam("cargoId") Long cargoId, ConhecimentoTO conhecimentoTO, 
			@HeaderParam("token") String token) {
		validarToken(token);
		
		Cargo cargo = cargoService.buscarPorId(cargoId);
		if (cargo == null) {
			return notFound();
		}
		PreRequisitoConhecimento preRequisitoConhecimento = new PreRequisitoConhecimento(cargo, conhecimentoTO);
		preRequisitoConhecimento = preRequisitoConhecimentoService.salvar(preRequisitoConhecimento);
		return ok(preRequisitoConhecimento);
	}

	@PUT()
	@Path("/cargos/{cargoId}/pre-requisitos-conhecimento/{id}/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response alterarPreRequisitoConhecimento(@PathParam("cargoId") Long cargoId, @PathParam("id") Long id, 
			ConhecimentoTO conhecimentoTO, @HeaderParam("token") String token) {
		validarToken(token);
		
		Cargo cargo = cargoService.buscarPorId(cargoId);
		PreRequisitoConhecimento preRequisitoConhecimento = preRequisitoConhecimentoService.buscarPorId(id);
		if (cargo == null || preRequisitoConhecimento == null) {
			return notFound();
		}
		
		preRequisitoConhecimento.alterar(cargo, conhecimentoTO);
		preRequisitoConhecimento = preRequisitoConhecimentoService.salvar(preRequisitoConhecimento);
		return ok(preRequisitoConhecimento);
	}

	@DELETE()
	@Path("/cargos/{cargoId}/pre-requisitos-conhecimento/{id}/")
	@Produces("application/json")
	public Response removerPreRequisitoConhecimento(@PathParam("cargoId") Long cargoId, @PathParam("id") Long id, 
			@HeaderParam("token") String token) {
		validarToken(token);

		PreRequisitoConhecimento preRequisitoConhecimento = preRequisitoConhecimentoService.buscarPorId(id);
		if (preRequisitoConhecimento == null) {
			return notFound();
		}
		
		preRequisitoConhecimentoService.excluir(preRequisitoConhecimento);
		return ok();
	}

	@GET()
	@Path("/cargos/{cargoId}/pre-requisitos-curso/")
	@Produces("application/json")
	public Response listarPreRequisitosDeCursoDoCargo(@PathParam("cargoId") Long cargoId, @HeaderParam("token") String token) {
		validarToken(token);
		List<PreRequisitoCurso> preRequisitosCurso = preRequisitoCursoService.buscarPorCargo(cargoId); 
		return ok(preRequisitosCurso);
	}

	@GET()
	@Path("/cargos/{cargoId}/pre-requisitos-curso/{id}/")
	@Produces("application/json")
	public Response obterPreRequisitoCurso(@PathParam("cargoId") Long cargoId, @PathParam("id") Long id, 
			@HeaderParam("token") String token) {
		validarToken(token);
		PreRequisitoCurso preRequisitoCurso = preRequisitoCursoService.buscarPorId(id);
		return ok(preRequisitoCurso);
	}

	@POST()
	@Path("/cargos/{cargoId}/pre-requisitos-curso/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response criarPreRequisitoCurso(@PathParam("cargoId") Long cargoId, CursoTO cursoTO, @HeaderParam("token") String token) {
		validarToken(token);

		Cargo cargo = cargoService.buscarPorId(cargoId);
		if (cargo == null) {
			return notFound();
		}
		
		PreRequisitoCurso preRequisitoCurso = new PreRequisitoCurso(cargo, cursoTO);
		preRequisitoCurso = preRequisitoCursoService.salvar(preRequisitoCurso);
		return ok(preRequisitoCurso);
	}

	@PUT()	
	@Path("/cargos/{cargoId}/pre-requisitos-curso/{id}/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response alterarPreRequisitoCurso(@PathParam("cargoId") Long cargoId, @PathParam("id") Long id, 
			CursoTO cursoTO, @HeaderParam("token") String token) {
		validarToken(token);

		Cargo cargo = cargoService.buscarPorId(cargoId);
		PreRequisitoCurso preRequisitoCurso = preRequisitoCursoService.buscarPorId(id);
		if (cargo == null || preRequisitoCurso == null) {
			return notFound();
		}
		
		preRequisitoCurso.alterar(cargo, cursoTO);
		preRequisitoCurso = preRequisitoCursoService.salvar(preRequisitoCurso);
		return ok(preRequisitoCurso);
	}

	@DELETE()
	@Path("/cargos/{cargoId}/pre-requisitos-curso/{id}/")
	@Produces("application/json")
	public Response removerPreRequisitoCurso(@PathParam("cargoId") Long cargoId, @PathParam("id") Long id, 
			@HeaderParam("token") String token) {
		validarToken(token);

		PreRequisitoCurso preRequisitoCurso = preRequisitoCursoService.buscarPorId(id);
		if (preRequisitoCurso == null) {
			return notFound();
		}
		
		preRequisitoCursoService.excluir(preRequisitoCurso);
		return ok();
	}

	@GET()
	@Path("/cargos/{cargoId}/pre-requisitos-experiencia/")
	@Produces("application/json")
	public Response listarPreRequisitosDeExperienciaDoCargo(@PathParam("cargoId") Long cargoId,
			@HeaderParam("token") String token) {
		validarToken(token);
		List<PreRequisitoExperiencia> preRequisitosExperiencia = preRequisitoExperienciaService.buscarPorCargo(cargoId);
		return ok(preRequisitosExperiencia);
	}

	@GET()
	@Path("/cargos/{cargoId}/pre-requisitos-experiencia/{id}/")
	@Produces("application/json")
	public Response obterPreRequisitoExperiencia(@PathParam("cargoId") Long cargoId, @PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);
		PreRequisitoExperiencia preRequisitoExperiencia = preRequisitoExperienciaService.buscarPorId(id);
		return ok(preRequisitoExperiencia);
	}

	@POST()
	@Path("/cargos/{cargoId}/pre-requisitos-experiencia/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response criarPreRequisitoExperiencia(@PathParam("cargoId") Long cargoId, ExperienciaTO experienciaTO, @HeaderParam("token") String token) {
		validarToken(token);
		
		Cargo cargo = cargoService.buscarPorId(cargoId);
		if (cargo == null) {
			return notFound();
		}
		
		PreRequisitoExperiencia preRequisitoExperiencia = new PreRequisitoExperiencia(cargo, experienciaTO);
		preRequisitoExperiencia = preRequisitoExperienciaService.salvar(preRequisitoExperiencia);
		return ok(preRequisitoExperiencia);
	}

	@PUT()
	@Path("/cargos/{cargoId}/pre-requisitos-experiencia/{id}/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response alterarPreRequisitoExperiencia(@PathParam("cargoId") Long cargoId, @PathParam("id") Long id, 
			ExperienciaTO experienciaTO, @HeaderParam("token") String token) {
		validarToken(token);
		
		PreRequisitoExperiencia preRequisitoExperiencia = preRequisitoExperienciaService.buscarPorId(id);
		Cargo cargo = cargoService.buscarPorId(cargoId);
		if (cargo == null || preRequisitoExperiencia == null) {
			return notFound();
		}
		
		preRequisitoExperiencia.alterar(cargo, experienciaTO);
		preRequisitoExperiencia = preRequisitoExperienciaService.salvar(preRequisitoExperiencia);
		return ok(preRequisitoExperiencia);
	}

	@DELETE()
	@Path("/cargos/{cargoId}/pre-requisitos-experiencia/{id}/")
	@Produces("application/json")
	public Response removerPreRequisitoExperiencia(@PathParam("cargoId") Long cargoId, @PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);

		PreRequisitoExperiencia preRequisitoExperiencia = preRequisitoExperienciaService.buscarPorId(id);
		if (preRequisitoExperiencia == null) {
			return notFound();
		}
		
		preRequisitoExperienciaService.excluir(preRequisitoExperiencia);
		return ok();
	}
	
	@GET()
	@Path("/cargos/{cargoId}/pre-requisitos-formacao-academica/")
	@Produces("application/json")
	public Response listarPreRequisitosDeFormacaoAcademicaDoCargo(@PathParam("cargoId") Long cargoId,
			@HeaderParam("token") String token) {
		validarToken(token);
		List<PreRequisitoFormacaoAcademica> preRequisitosFormacaoAcademica = preRequisitoFormacaoAcademicaService.buscarPorCargo(cargoId);
		return ok(preRequisitosFormacaoAcademica);
	}

	@GET()
	@Path("/cargos/{cargoId}/pre-requisitos-formacao-academica/{id}/")
	@Produces("application/json")
	public Response obterPreRequisitoFormacaoAcademica(@PathParam("cargoId") Long cargoId, @PathParam("id") Long id, 
			@HeaderParam("token") String token) {
		validarToken(token);
		PreRequisitoFormacaoAcademica preRequisitoFormacaoAcademica = preRequisitoFormacaoAcademicaService.buscarPorId(id);
		return ok(preRequisitoFormacaoAcademica);
	}

	@POST()
	@Path("/cargos/{cargoId}/pre-requisitos-formacao-academica/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response criarPreRequisitoFormacaoAcademica(@PathParam("cargoId") Long cargoId, 
			TipoFormacaoAcademica tipoFormacaoAcademica, @HeaderParam("token") String token) {
		validarToken(token);
		
		Cargo cargo = cargoService.buscarPorId(cargoId);
		if (cargo == null) {
			return notFound();
		}
		
		PreRequisitoFormacaoAcademica preRequisitoFormacaoAcademica = new PreRequisitoFormacaoAcademica(cargo, tipoFormacaoAcademica);
		preRequisitoFormacaoAcademica = preRequisitoFormacaoAcademicaService.salvar(preRequisitoFormacaoAcademica);
		return ok(preRequisitoFormacaoAcademica);
	}

	@PUT()
	@Consumes("application/json")
	@Path("/cargos/{cargoId}/pre-requisitos-formacao-academica/{id}/")
	@Produces("application/json")
	public Response alterarPreRequisitoFormacaoAcademica(@PathParam("cargoId") Long cargoId, @PathParam("id") Long id, 
			TipoFormacaoAcademica tipoFormacaoAcademica, @HeaderParam("token") String token) {
		validarToken(token);

		Cargo cargo = cargoService.buscarPorId(cargoId);
		PreRequisitoFormacaoAcademica preRequisitoFormacaoAcademica = preRequisitoFormacaoAcademicaService.buscarPorId(id);
		if (cargo == null || preRequisitoFormacaoAcademica == null) {
			return notFound();
		}
		
		preRequisitoFormacaoAcademica.alterar(cargo, tipoFormacaoAcademica);
		preRequisitoFormacaoAcademica = preRequisitoFormacaoAcademicaService.salvar(preRequisitoFormacaoAcademica);
		return ok(preRequisitoFormacaoAcademica);
	}

	@DELETE()
	@Path("/cargos/{cargoId}/pre-requisitos-formacao-academica/{id}/")
	@Produces("application/json")
	public Response removerPreRequisitoFormacaoAcademica(@PathParam("cargoId") Long cargoId, @PathParam("id") Long id, 
			@HeaderParam("token") String token) {
		validarToken(token);

		PreRequisitoFormacaoAcademica preRequisitoFormacaoAcademica = preRequisitoFormacaoAcademicaService.buscarPorId(id);
		if (preRequisitoFormacaoAcademica == null) {
			return notFound();
		}
		
		preRequisitoFormacaoAcademicaService.excluir(preRequisitoFormacaoAcademica);
		return ok();
	}

	@GET()
	@Path("/cargos/{cargoId}/pre-requisitos-habilidades/")
	@Produces("application/json")
	public Response listarPreRequisitosDeHabilidadesDoCargo(@PathParam("cargoId") Long cargoId,
			@HeaderParam("token") String token) {
		validarToken(token);
		List<PreRequisitoHabilidade> preRequisitosHabilidades = preRequisitoHabilidadeService.buscarPorCargo(cargoId);
		return ok(preRequisitosHabilidades);
	}

	@GET()
	@Path("/cargos/{cargoId}/pre-requisitos-habilidades/{id}/")
	@Produces("application/json")
	public Response obterPreRequisitoHabilidade(@PathParam("cargoId") Long cargoId, @PathParam("id") Long id, 
			@HeaderParam("token") String token) {
		validarToken(token);
		PreRequisitoHabilidade preRequisitoHabilidade = preRequisitoHabilidadeService.buscarPorId(id);
		return ok(preRequisitoHabilidade);
	}

	@POST()
	@Path("/cargos/{cargoId}/pre-requisitos-habilidades/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response criarPreRequisitoHabilidade(@PathParam("cargoId") Long cargoId, HabilidadeTO habilidadeTO, @HeaderParam("token") String token) {
		validarToken(token);
		
		Cargo cargo = cargoService.buscarPorId(cargoId);
		if (cargo == null) {
			return notFound();
		}
		
		PreRequisitoHabilidade preRequisitoHabilidade = new PreRequisitoHabilidade(cargo, habilidadeTO);
		preRequisitoHabilidade = preRequisitoHabilidadeService.salvar(preRequisitoHabilidade);
		return ok(preRequisitoHabilidade);
	}

	@PUT()
	@Path("/cargos/{cargoId}/pre-requisitos-habilidades/{id}/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response alterarPreRequisitoHabilidade(@PathParam("cargoId") Long cargoId, @PathParam("id") Long id, HabilidadeTO habilidadeTO, @HeaderParam("token") String token) {
		validarToken(token);

		Cargo cargo = cargoService.buscarPorId(cargoId);
		PreRequisitoHabilidade preRequisitoHabilidade = preRequisitoHabilidadeService.buscarPorId(id);
		if (cargo == null || preRequisitoHabilidade == null) {
			return notFound();
		}
		
		preRequisitoHabilidade.alterar(cargo, habilidadeTO);
		preRequisitoHabilidade = preRequisitoHabilidadeService.salvar(preRequisitoHabilidade);
		return ok(preRequisitoHabilidade);
	}

	@DELETE()
	@Path("/cargos/{cargoId}/pre-requisitos-habilidades/{id}/")
	@Produces("application/json")
	public Response removerPreRequisitoHabilidade(@PathParam("cargoId") Long cargoId, @PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);

		PreRequisitoHabilidade preRequisitoHabilidade = preRequisitoHabilidadeService.buscarPorId(id);
		if (preRequisitoHabilidade == null) {
			return notFound();
		}
		
		preRequisitoHabilidadeService.excluir(preRequisitoHabilidade);
		return ok();
	}
	
	@GET()
	@Path("/cargos/{cargoId}/pre-requisitos-registro-orgao-classe/")
	@Produces("application/json")
	public Response listarPreRequisitosDeRegistroOrgaoClasseDoCargo(@PathParam("cargoId") Long cargoId,
			@HeaderParam("token") String token) {
		validarToken(token);
		List<PreRequisitoRegistroOrgaoClasse> preRequisitosRegristroOrgaoClasse = preRequisitoRegistroOrgaoClasseService.buscarPorCargo(cargoId);
		return ok(preRequisitosRegristroOrgaoClasse);
	}

	@GET()
	@Path("/cargos/{cargoId}/pre-requisitos-registro-orgao-classe/{id}/")
	@Produces("application/json")
	public Response obterPreRequisitoRegistroOrgaoClasse(@PathParam("cargoId") Long cargoId, @PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);
		PreRequisitoRegistroOrgaoClasse preRequisitoRegistroOrgaoClasse = preRequisitoRegistroOrgaoClasseService.buscarPorId(id);
		return ok(preRequisitoRegistroOrgaoClasse);
	}

	@POST()
	@Path("/cargos/{cargoId}/pre-requisitos-registro-orgao-classe/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response criarPreRequisitoRegistroOrgaoClasse(@PathParam("cargoId") Long cargoId, OrgaoRegionalClasseTO orgaoRegionalClasseTO, @HeaderParam("token") String token) {
		validarToken(token);
		
		Cargo cargo = cargoService.buscarPorId(cargoId);
		if (cargo == null){
			return notFound();
		}
		
		PreRequisitoRegistroOrgaoClasse preRequisitoRegistroOrgaoClasse = new PreRequisitoRegistroOrgaoClasse(cargo, orgaoRegionalClasseTO);
		preRequisitoRegistroOrgaoClasse = preRequisitoRegistroOrgaoClasseService.salvar(preRequisitoRegistroOrgaoClasse);
		return ok(preRequisitoRegistroOrgaoClasse);
	}

	@PUT()	
	@Path("/cargos/{cargoId}/pre-requisitos-registro-orgao-classe/{id}/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response alterarPreRequisitoRegistroOrgaoClasse(@PathParam("cargoId") Long cargoId, @PathParam("id") Long id, OrgaoRegionalClasseTO orgaoRegionalClasseTO, @HeaderParam("token") String token) {
		validarToken(token);

		Cargo cargo = cargoService.buscarPorId(cargoId);
		PreRequisitoRegistroOrgaoClasse preRequisitoRegistroOrgaoClasse = preRequisitoRegistroOrgaoClasseService.buscarPorId(id);
		if (cargo == null || preRequisitoRegistroOrgaoClasse ==  null) {
			return notFound();
		}
		
		preRequisitoRegistroOrgaoClasse.alterar(cargo, orgaoRegionalClasseTO);
		preRequisitoRegistroOrgaoClasse = preRequisitoRegistroOrgaoClasseService.salvar(preRequisitoRegistroOrgaoClasse);
		return ok(preRequisitoRegistroOrgaoClasse);
	}

	@DELETE()
	@Path("/cargos/{cargoId}/pre-requisitos-registro-orgao-classe/{id}/")
	@Produces("application/json")
	public Response removerPreRequisitoRegistroOrgaoClasse(@PathParam("cargoId") Long cargoId, @PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);

		PreRequisitoRegistroOrgaoClasse preRequisitoRegistroOrgaoClasse = preRequisitoRegistroOrgaoClasseService.buscarPorId(id);
		if (preRequisitoRegistroOrgaoClasse ==  null) {
			return notFound();
		}
		
		preRequisitoRegistroOrgaoClasseService.excluir(preRequisitoRegistroOrgaoClasse);
		return ok();
	}

	@GET()
	@Path("/orgaos-regionais-classe/")
	@Produces("application/json")
	public Response listarOrgaoRegionalClasse(@HeaderParam("token") String token) {
		validarToken(token);
		List<OrgaoRegionalClasse> orgaoesRegionaisClasse = orgaoRegionalClasseService.buscarTodos();
		return ok(orgaoesRegionaisClasse);
	}

	@GET()
	@Path("/orgaos-regionais-classe/{id}/")
	@Produces("application/json")
	public Response obterOrgaoRegionalClasse(@PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);
		OrgaoRegionalClasse orgaoRegionalClasse = orgaoRegionalClasseService.buscarPorId(id);
		return ok(orgaoRegionalClasse);
	}

	@POST()
	@Path("/orgaos-regionais-classe/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response criarOrgaoRegionalClasse(OrgaoRegionalClasseTO orgaoRegionalClasseTO, @HeaderParam("token") String token) {
		validarToken(token);
		OrgaoRegionalClasse orgaoRegionalClasse = new OrgaoRegionalClasse(orgaoRegionalClasseTO);
		orgaoRegionalClasse = orgaoRegionalClasseService.salvar(orgaoRegionalClasse);
		return ok(orgaoRegionalClasse);
	}

	@PUT()
	@Path("/orgaos-regionais-classe/{id}/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response alterarOrgaoRegionalClasse(@PathParam("id") Long id, OrgaoRegionalClasseTO orgaoRegionalClasseTO, @HeaderParam("token") String token) {
		validarToken(token);
		
		OrgaoRegionalClasse orgaoRegionalClasse = orgaoRegionalClasseService.buscarPorId(id);
		if (orgaoRegionalClasse == null) {
			return notFound();
		}
		
		orgaoRegionalClasse.alterar(orgaoRegionalClasseTO);
		orgaoRegionalClasse = orgaoRegionalClasseService.salvar(orgaoRegionalClasse);
		return ok(orgaoRegionalClasse);
	}

	@DELETE()
	@Path("/orgaos-regionais-classe/{id}/")
	@Produces("application/json")
	public Response removerOrgaoRegionalClasse(@PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);

		OrgaoRegionalClasse orgaoRegionalClasse = orgaoRegionalClasseService.buscarPorId(id);
		if (orgaoRegionalClasse == null) {
			return notFound();
		}
		
		orgaoRegionalClasseService.excluir(orgaoRegionalClasse);
		return ok();
	}
	
	@GET()
	@Path("/cargos/{cargoId}/turnos/")
	@Produces("application/json")
	public Response listarTurnoCargo(@PathParam("cargoId") Long cargoId, @HeaderParam("token") String token) {
		validarToken(token);
		List<TurnoCargo> turnosCargo = turnoCargoService.buscarTodos();
		return ok(turnosCargo);
	}

	@GET()
	@Path("/cargos/{cargoId}/turnos/{id}/")
	@Produces("application/json")
	public Response obterTurnoCargo(@PathParam("cargoId") Long cargoId, @PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);
		TurnoCargo turnoCargo = turnoCargoService.buscarPorId(id);
		return ok(turnoCargo);
	}

	@POST()
	@Path("/cargos/{cargoId}/turnos/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response criarTurnoCargo(@PathParam("cargoId") Long cargoId, TurnoCargoTO turnoCargoTO, @HeaderParam("token") String token) {
		validarToken(token);
		
		Cargo cargo = cargoService.buscarPorId(cargoId);
		if (cargo == null) {
			return notFound();
		}
		
		TurnoCargo turnoCargo = new TurnoCargo(cargo, turnoCargoTO);
		turnoCargo = turnoCargoService.salvar(turnoCargo);
		return ok(turnoCargo);
	}

	@PUT()
	@Path("/cargos/{cargoId}/turnos/{id}/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response alterarTurnoCargo(@PathParam("cargoId") Long cargoId, @PathParam("id") Long id, TurnoCargoTO turnoCargoTO, @HeaderParam("token") String token) {
		validarToken(token);

		Cargo cargo = cargoService.buscarPorId(cargoId);
		TurnoCargo turnoCargo = turnoCargoService.buscarPorId(id);
		if (cargo == null || turnoCargo == null) {
			return notFound();
		}
		
		turnoCargo.alterar(cargo, turnoCargoTO);
		turnoCargo = turnoCargoService.salvar(turnoCargo);
		return ok(turnoCargo);
	}

	@DELETE()
	@Path("/cargos/{cargoId}/turnos/{id}/")
	@Produces("application/json")
	public Response removerTurnoCargo(@PathParam("cargoId") Long cargoId, @PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);

		TurnoCargo turnoCargo = turnoCargoService.buscarPorId(id);
		if (turnoCargo == null) {
			return notFound();
		}
		
		turnoCargoService.excluir(turnoCargo);
		return ok();
	}

	@GET()
	@Path("/turnos/")
	@Produces("application/json")
	public Response listarTurnos(@HeaderParam("token") String token) {
		validarToken(token);
		List<Turno> turnos = turnoService.buscarTodos();
		return ok(turnos);
	}

	@GET()
	@Path("/turnos/{id}/")
	@Produces("application/json")
	public Response obterTurno(@PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);
		Turno turno = turnoService.buscarPorId(id);
		return ok(turno);
	}

	@POST()
	@Path("/turnos/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response criarTurno(TurnoTO turnoTO, @HeaderParam("token") String token) {
		validarToken(token);
		Turno turno = new Turno(turnoTO);
		turno = turnoService.salvar(turno);
		return ok(turno);
	}

	@PUT()
	@Consumes("application/json")
	@Path("/turnos/{id}/")
	@Produces("application/json")
	public Response alterarTurno(@PathParam("id") Long id, TurnoTO turnoTO, @HeaderParam("token") String token) {
		validarToken(token);

		Turno turno = turnoService.buscarPorId(id);
		if (turno == null) {
			return notFound();
		}
		
		turno.alterar(turnoTO);
		turno = turnoService.salvar(turno);
		return ok(turno);
	}

	@DELETE()
	@Path("/turnos/{id}/")
	@Produces("application/json")
	public Response removerTurno(@PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);

		Turno turno = turnoService.buscarPorId(id);
		if (turno == null) {
			return notFound();
		}
		
		turnoService.excluir(turno);
		return ok();
	}

	@GET()
	@Path("/quadros-pessoal/")
	@Produces("application/json")
	public Response listarQuadroPessoal(@HeaderParam("token") String token) {
		validarToken(token);
		List<QuadroPessoal> quadrosPessoal = quadroPessoalService.buscarTodos();
		return ok(quadrosPessoal);
	}

	@GET()
	@Path("/quadros-pessoal/{id}/")
	@Produces("application/json")
	public Response obterQuadroPessoal(@PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);
		QuadroPessoal quadroPessoal = quadroPessoalService.buscarPorId(id);
		return ok(quadroPessoal);
	}

	@POST()
	@Path("/quadros-pessoal/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response criarQuadroPessoal(QuadroPessoalTO quadroPessoalTO, @HeaderParam("token") String token) {
		validarToken(token);
		try {
			QuadroPessoal quadroPessoal = new QuadroPessoal(quadroPessoalTO);
			quadroPessoal = quadroPessoalService.salvar(quadroPessoal);
			return created(quadroPessoal);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return internalServerError("Falha ao criar quadro de pessoal: "+e.getMessage());
		}
	}

	@PUT()
	@Path("/quadros-pessoal/{id}/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response alterarQuadroPessoal(@PathParam("id") Long id, QuadroPessoalTO quadroPessoalTO, @HeaderParam("token") String token) {
		validarToken(token);
		QuadroPessoal quadroPessoal = quadroPessoalService.buscarPorId(id);
		quadroPessoal.alterar(quadroPessoalTO);
		quadroPessoal = quadroPessoalService.salvar(quadroPessoal);
		return ok(quadroPessoal);
	}

	@DELETE()
	@Path("/quadros-pessoal/{id}/")
	@Produces("application/json")
	public Response removerQuadroPessoal(@PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);

		QuadroPessoal quadroPessoal = quadroPessoalService.buscarPorId(id);
		if (quadroPessoal == null) {
			return notFound();
		}
		
		quadroPessoalService.excluir(quadroPessoal);
		return ok();
	}
	
	@GET()
	@Path("/quadros-pessoal/{quadroPessoalId}/grupos-cargo/")
	@Produces("application/json")
	public Response listarGruposCargoDoQuadroPessoal(@PathParam("quadroPessoalId") Long quadroPessoalId, @HeaderParam("token") String token) {
		validarToken(token);
		List<GrupoCargo> gruposCargo = grupoCargoService.buscarTodos();
		return ok(gruposCargo);
	}

	@GET()
	@Path("/quadros-pessoal/{quadroPessoalId}/grupos-cargo/{id}/")
	@Produces("application/json")
	public Response obterGrupoCargo(@PathParam("quadroPessoalId") Long quadroPessoalId, @PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);
		GrupoCargo grupoCargo = grupoCargoService.buscarPorId(id);
		return ok(grupoCargo);
	}

	@POST()
	@Path("/quadros-pessoal/{quadroPessoalId}/grupos-cargo/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response criarGrupoCargo(@PathParam("quadroPessoalId") Long quadroPessoalId, GrupoCargoTO grupoCargoTO, @HeaderParam("token") String token) {
		validarToken(token);

		QuadroPessoal quadroPessoal = quadroPessoalService.buscarPorId(quadroPessoalId);
		if (quadroPessoal == null) {
			return notFound("Quadro de pessoal não encontrado!");
		}
		
		GrupoCargo grupoCargo = new GrupoCargo(quadroPessoal, grupoCargoTO);
		try {
			grupoCargo = grupoCargoService.salvar(grupoCargo);
			return created(grupoCargo);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return internalServerError("Falha ao criar grupo de cargos: "+e.getMessage()); 			
		}
	}

	@PUT()
	@Path("/quadros-pessoal/{quadroPessoalId}/grupos-cargo/{id}/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response alterarGrupoCargo(@PathParam("quadroPessoalId") Long quadroPessoalId, @PathParam("id") Long id, GrupoCargoTO grupoCargoTO, @HeaderParam("token") String token) {
		validarToken(token);

		QuadroPessoal quadroPessoal = quadroPessoalService.buscarPorId(quadroPessoalId);
		GrupoCargo grupoCargo = grupoCargoService.buscarPorId(id);
		if (quadroPessoal == null || grupoCargo == null) {
			return notFound();
		}
		
		grupoCargo.alterar(quadroPessoal, grupoCargoTO);
		grupoCargo = grupoCargoService.salvar(grupoCargo);
		return ok(grupoCargo);
	}

	@DELETE()
	@Path("/quadros-pessoal/{quadroPessoalId}/grupos-cargo/{id}/")
	@Produces("application/json")
	public Response removerGrupoCargo(@PathParam("quadroPessoalId") Long quadroPessoalId, @PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);

		GrupoCargo grupoCargo = grupoCargoService.buscarPorId(id);
		if (grupoCargo == null) {
			return notFound();
		}
		
		grupoCargoService.excluir(grupoCargo);
		return ok();
	}

	@GET()
	@Path("/planos-cargo/")
	@Produces("application/json")
	public Response listarPlanoCargo(@HeaderParam("token") String token) {
		validarToken(token);
		List<PlanoCargo> planosCargos = planoCargoService.buscarTodos();
		return ok(planosCargos);
	}

	@GET()
	@Path("/planos-cargo/{id}/")
	@Produces("application/json")
	public Response obterPlanoCargo(@PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);
		PlanoCargo planoCargo = planoCargoService.buscarPorId(id);
		return ok(planoCargo);
	}

	@POST()
	@Path("/planos-cargo/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response criarPlanoCargo(PlanoCargoTO planoCargoTO, @HeaderParam("token") String token) {
		validarToken(token);
		try {
			PlanoCargo planoCargo = new PlanoCargo(planoCargoTO);
			planoCargo = planoCargoService.salvar(planoCargo);
			return created(planoCargo);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return internalServerError("Falha ao criar plano de cargos: "+e.getMessage());
			
		}
	}

	@PUT()
	@Path("/planos-cargo/{id}/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response alterarPlanoCargo(@PathParam("id") Long id, PlanoCargoTO planoCargoTO, @HeaderParam("token") String token) {
		validarToken(token);

		PlanoCargo planoCargo = planoCargoService.buscarPorId(id);
		if (planoCargo == null) {
			return notFound();
		}
		
		planoCargo.alterar(planoCargoTO);
		planoCargo = planoCargoService.salvar(planoCargo);
		return ok(planoCargo);
	}

	@DELETE()
	@Path("/planos-cargo/{id}/")
	@Produces("application/json")
	public Response removerPlanoCargo(@PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);

		PlanoCargo planoCargo = planoCargoService.buscarPorId(id);
		if (planoCargo == null) {
			return notFound();
		}
		
		planoCargoService.excluir(planoCargo);
		return ok();
	}

	@Path("/estruturas-cargo/")
	@Produces("application/json")
	public Response listarEstruturaCargo(@HeaderParam("token") String token) {
		validarToken(token);
		List<EstruturaCargo> estruturasCargos = estruturaCargoService.buscarTodos();
		return ok(estruturasCargos);
	}

	@GET()
	@Path("/estruturas-cargo/{id}/")
	@Produces("application/json")
	public Response obterEstruturaCargo(@PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);
		EstruturaCargo estrutura = estruturaCargoService.buscarPorId(id);
		return ok(estrutura);
	}

	@POST()
	@Path("/estruturas-cargo/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response criarEstruturaCargo(EstruturaCargoTO estruturaCargoTO, @HeaderParam("token") String token) {
		validarToken(token);
		EstruturaCargo estrutura = new EstruturaCargo(estruturaCargoTO);
		try {
			estrutura = estruturaCargoService.salvar(estrutura);
			return created(estrutura);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return internalServerError("Falha ao criar estrutura de cargos: "+e.getMessage()); 			
		}
	}

	@PUT()
	@Path("/estruturas-cargo/{id}/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response alterarEstruturaCargo(@PathParam("id") Long id, EstruturaCargoTO estruturaCargoTO, @HeaderParam("token") String token) {
		validarToken(token);

		EstruturaCargo estrutura = estruturaCargoService.buscarPorId(id);
		if (estrutura == null) {
			return notFound();
		}
		
		estrutura.alterar(estruturaCargoTO);
		estrutura = estruturaCargoService.salvar(estrutura);
		return ok(estrutura);
	}

	@DELETE()
	@Path("/estruturas-cargo/{id}/")
	@Produces("application/json")
	public Response removerEstruturaCargo(@PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);

		EstruturaCargo estrutura = estruturaCargoService.buscarPorId(id);
		if (estrutura == null) {
			return notFound();
		}
		
		estruturaCargoService.excluir(estrutura);
		return ok();
	}	

	@GET()
	@Path("/cargos/{cargoId}/referencias/")
	@Produces("application/json")
	public Response listarReferenciasDoCargo(@PathParam("cargoId") Long cargoId, @HeaderParam("token") String token) {
		validarToken(token);
		List<Referencia> referencias = referenciaService.buscarTodos();
		return ok(referencias);
	}

	@GET()
	@Path("/cargos/{cargoId}/referencias/{id}/")
	@Produces("application/json")
	public Response obterReferencia(@PathParam("cargoId") Long cargoId, @PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);
		Referencia referencia = referenciaService.buscarPorId(id);
		return ok(referencia);
	}

	@POST()
	@Path("/cargos/{cargoId}/referencias/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response criarReferencia(@PathParam("cargoId") Long cargoId, ReferenciaTO referenciaTO, @HeaderParam("token") String token) {
		validarToken(token);
		
		Cargo cargo = cargoService.buscarPorId(cargoId);
		if (cargo == null) {
			return notFound();
		}
		
		Referencia referencia = new Referencia(cargo, referenciaTO);
		referencia = referenciaService.salvar(referencia);
		return ok(referencia);
	}

	@PUT()
	@Path("/cargos/{cargoId}/referencias/{id}/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response alterarReferencia(@PathParam("cargoId") Long cargoId, @PathParam("id") Long id, ReferenciaTO referenciaTO, @HeaderParam("token") String token) {
		validarToken(token);

		Cargo cargo = cargoService.buscarPorId(cargoId);
		Referencia referencia = referenciaService.buscarPorId(id);
		if (cargo == null || referencia == null) {
			return notFound();
		}
		
		referencia.alterar(cargo, referenciaTO);
		referencia = referenciaService.salvar(referencia);
		return ok(referencia);
	}

	@DELETE()
	@Path("/cargos/{cargoId}/referencias/{id}/")
	@Produces("application/json")
	public Response removerReferencia(@PathParam("cargoId") Long cargoId, @PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);

		Referencia referencia = referenciaService.buscarPorId(id);
		if (referencia == null) {
			return notFound();
		}
		
		referenciaService.excluir(referencia);
		return ok();
	}

	@GET()
	@Path("/cargos/{cargoId}/referencias/{referenciaId}/valores/")
	@Produces("application/json")
	public Response listarValoresDaReferenciaDoCargo(@PathParam("cargoId") Long cargoId, @PathParam("referenciaId") Long referenciaId, @HeaderParam("token") String token) {
		validarToken(token);
		List<ReferenciaValor> referenciasValor = referenciaValorService.buscarPorCargo(cargoId);
		return ok(referenciasValor);
	}

	@GET()
	@Path("/cargos/{cargoId}/referencias/{referenciaId}/valores/{id}/")
	@Produces("application/json")
	public Response obterReferenciaValor(@PathParam("cargoId") Long cargoId, @PathParam("referenciaId") Long referenciaId, @PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);
		ReferenciaValor referenciaValor = referenciaValorService.buscarPorId(id);
		return ok(referenciaValor);
	}

	@POST()
	@Path("/cargos/{cargoId}/referencias/{referenciaId}/valores/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response criarReferenciaValor(@PathParam("cargoId") Long cargoId, @PathParam("referenciaId") Long referenciaId, ReferenciaValorTO referenciaValorTO, @HeaderParam("token") String token) {
		validarToken(token);
		ReferenciaValor referenciaValor = new ReferenciaValor(referenciaValorTO);
		referenciaValor = referenciaValorService.salvar(referenciaValor);
		return ok(referenciaValor);
	}

	@PUT()
	@Consumes("application/json")
	@Path("/cargos/{cargoId}/referencias/{referenciaId}/valores/{id}/")
	@Produces("application/json")
	public Response alterarReferenciaValor(@PathParam("cargoId") Long cargoId, @PathParam("referenciaId") Long referenciaId, 
			@PathParam("id") Long id, ReferenciaValorTO referenciaValorTO, @HeaderParam("token") String token) {
		validarToken(token);

		ReferenciaValor referenciaValor = referenciaValorService.buscarPorId(id);
		if (referenciaValor == null) {
			return notFound();
		}
		
		referenciaValor.alterar(referenciaValorTO);
		referenciaValor = referenciaValorService.salvar(referenciaValor);
		return ok(referenciaValor);
	}

	@DELETE()
	@Path("/cargos/{cargoId}/referencias/{referenciaId}/valores/{id}/")
	@Produces("application/json")
	public Response removerReferenciaValor(@PathParam("cargoId") Long cargoId, @PathParam("referenciaId") Long referenciaId, 
			@PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);

		ReferenciaValor referenciaValor = referenciaValorService.buscarPorId(id);
		if (referenciaValor == null) {
			return notFound();
		}
		
		referenciaValorService.excluir(referenciaValor);
		return ok();
	}
	
	@GET()
	@Path("/referencias/{id}/")
	@Produces("application/json")
	public Response obterReferencia(@PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);
		Referencia referencia = referenciaService.buscarPorId(id);
		return ok(referencia);
	}

	@POST()
	@Path("/referencias/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response criarReferencia(ReferenciaTO referenciaTO, @HeaderParam("token") String token) {
		validarToken(token);
		
		Referencia referencia = new Referencia(referenciaTO);
		referencia = referenciaService.salvar(referencia);
		
		if (referenciaTO.getValores() != null) {
			for (ReferenciaValorTO referenciaValorTO : referenciaTO.getValores()) {
				referenciaValorTO.setRefererenciaId(referencia.getId());
				referencia.getValores().add(new ReferenciaValor(referenciaValorTO));	
			}
		}
		
		try {
			referencia = referenciaService.salvar(referencia);
			return created(referencia);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return internalServerError("Falha ao criar Referência: "+e.getMessage()); 						
		}
	}

	@PUT()
	@Path("/referencias/{id}/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response alterarReferencia(@PathParam("id") Long id, ReferenciaTO referenciaTO, @HeaderParam("token") String token) {
		validarToken(token);

		Referencia referencia = referenciaService.buscarPorId(id);
		if (referencia == null) {
			return notFound();
		}
		
		referencia.alterar(referenciaTO);
		referencia = referenciaService.salvar(referencia);
		return ok(referencia);
	}

	@DELETE()
	@Path("/referencias/{id}/")
	@Produces("application/json")
	public Response removerReferencia(@PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);

		Referencia referencia = referenciaService.buscarPorId(id);
		if (referencia == null) {
			return notFound();
		}
		
		referenciaService.excluir(referencia);
		return ok();
	}
	
	@GET()
	@Path("/regimes-juridicos/")
	@Produces("application/json")
	public Response listarRegimeJuridico(@HeaderParam("token") String token) {
		validarToken(token);
		List<RegimeJuridico> regimesJuridicos = regimeJuridicoService.buscarTodos();
		return ok(regimesJuridicos);
	}

	@GET()
	@Path("/regimes-juridicos/{id}/")
	@Produces("application/json")
	public Response obterRegimeJuridico(@PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);
		RegimeJuridico regimeJuridico = regimeJuridicoService.buscarPorId(id);
		return ok(regimeJuridico);
	}

	@POST()
	@Path("/regimes-juridicos/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response criarRegimeJuridico(RegimeJuridicoTO regimeJuridicoTO, @HeaderParam("token") String token) {
		validarToken(token);
		RegimeJuridico regimeJuridico = new RegimeJuridico(regimeJuridicoTO);
		regimeJuridico = regimeJuridicoService.salvar(regimeJuridico);
		return ok(regimeJuridico);
	}

	@PUT()
	@Path("/regimes-juridicos/{id}/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response alterarRegimeJuridico(@PathParam("id") Long id, RegimeJuridicoTO regimeJuridicoTO, @HeaderParam("token") String token) {
		validarToken(token);

		RegimeJuridico regimeJuridico = regimeJuridicoService.buscarPorId(id);
		if (regimeJuridico == null) {
			return notFound();
		}
		
		regimeJuridico.alterar(regimeJuridicoTO);
		regimeJuridico = regimeJuridicoService.salvar(regimeJuridico);
		return ok(regimeJuridico);
	}

	@DELETE()
	@Path("/regimes-juridicos/{id}/")
	@Produces("application/json")
	public Response removerRegimeJuridico(@PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);

		RegimeJuridico regimeJuridico = regimeJuridicoService.buscarPorId(id);
		if (regimeJuridico == null) {
			return notFound();
		}
		
		regimeJuridicoService.excluir(regimeJuridico);
		return ok();
	}

	@GET()
	@Path("/entidades-previdenciarias/")
	@Produces("application/json")
	public Response listarEntidadePrevidenciaria(@HeaderParam("token") String token) {
		validarToken(token);
		List<EntidadePrevidenciaria> entidadesPrevidenciarias = entidadePrevidenciariaService.buscarTodos();
		return ok(entidadesPrevidenciarias);
	}

	@GET()
	@Path("/entidades-previdenciarias/{id}/")
	@Produces("application/json")
	public Response obterEntidadePrevidenciaria(@PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);
		EntidadePrevidenciaria entidadePrevidenciaria = entidadePrevidenciariaService.buscarPorId(id);
		return ok(entidadePrevidenciaria);
	}

	@POST()
	@Path("/entidades-previdenciarias/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response criarEntidadePrevidenciaria(EntidadePrevidenciariaTO entidadePrevidenciariaTO, @HeaderParam("token") String token) {
		validarToken(token);
		EntidadePrevidenciaria entidadePrevidenciaria = new EntidadePrevidenciaria(entidadePrevidenciariaTO);
		entidadePrevidenciaria = entidadePrevidenciariaService.salvar(entidadePrevidenciaria);
		return ok(entidadePrevidenciaria);
	}

	@PUT()
	@Consumes("application/json")
	@Path("/entidades-previdenciarias/{id}/")
	@Produces("application/json")
	public Response alterarEntidadePrevidenciaria(@PathParam("id") Long id, EntidadePrevidenciariaTO entidadePrevidenciariaTO, @HeaderParam("token") String token) {
		validarToken(token);

		EntidadePrevidenciaria entidadePrevidenciaria = entidadePrevidenciariaService.buscarPorId(id);
		if (entidadePrevidenciaria == null) {
			return notFound();
		}
		
		entidadePrevidenciaria.alterar(entidadePrevidenciariaTO);
		entidadePrevidenciaria = entidadePrevidenciariaService.salvar(entidadePrevidenciaria);
		return ok(entidadePrevidenciaria);
	}

	@DELETE()
	@Path("/entidades-previdenciarias/{id}/")
	@Produces("application/json")
	public Response removerEntidadePrevidenciaria(@PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);

		EntidadePrevidenciaria entidadePrevidenciaria = entidadePrevidenciariaService.buscarPorId(id);
		if (entidadePrevidenciaria == null) {
			return notFound();
		}
		
		entidadePrevidenciariaService.excluir(entidadePrevidenciaria);
		return ok();
	}

	@GET()
	@Path("/regimes-previdencia/")
	@Produces("application/json")
	public Response listarRegimesDePrevidencia(@HeaderParam("token") String token) {
		validarToken(token);
		List<RegimePrevidencia> regimesPrevidencia = regimePrevidenciaService.buscarTodos();
		return ok(regimesPrevidencia);
	}

	@GET()
	@Path("/entidades-previdenciarias/{entidadePrevidenciariaId}/regimes-previdencia/")
	@Produces("application/json")
	public Response listarRegimesDePrevidenciaPorEntidade(@PathParam("entidadePrevidenciariaId") Long entidadePrevidenciariaId, 
			@HeaderParam("token") String token) {
		validarToken(token);
		List<RegimePrevidencia> regimesPrevidencia = regimePrevidenciaService.buscarPorEntidade(entidadePrevidenciariaId);
		return ok(regimesPrevidencia);
	}

	@GET()
	@Path("/regimes-juridicos/{regimeJuridicoId}/regimes-previdencia/")
	@Produces("application/json")
	public Response listarRegimesDePrevidenciaPorRegimeJuridico(@PathParam("regimeJuridicoId") Long regimeJuridicoId,
			@HeaderParam("token") String token) {
		validarToken(token);
		List<RegimePrevidencia> regimesPrevidencia = regimePrevidenciaService.buscarPorRegimeJuridico(regimeJuridicoId);
		return ok(regimesPrevidencia);
	}

	@GET()
	@Path("/regimes-previdencia/{id}/")
	@Produces("application/json")
	public Response obterRegimePrevidencia(@PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);
		RegimePrevidencia regimePrevidencia = regimePrevidenciaService.buscarPorId(id);
		return ok(regimePrevidencia);
	}

	@POST()
	@Path("/regimes-previdencia/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response criarRegimePrevidencia(RegimePrevidenciaTO regimePrevidenciaTO, @HeaderParam("token") String token) {
		validarToken(token);
		RegimePrevidencia regimePrevidencia = new RegimePrevidencia(regimePrevidenciaTO);
		regimePrevidencia = regimePrevidenciaService.salvar(regimePrevidencia);
		return ok(regimePrevidencia);
	}

	@PUT()
	@Path("/regimes-previdencia/{id}/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response alterarRegimePrevidencia(@PathParam("id") Long id, RegimePrevidenciaTO regimePrevidenciaTO, @HeaderParam("token") String token) {
		validarToken(token);
		RegimePrevidencia regimePrevidencia = regimePrevidenciaService.buscarPorId(id);
		regimePrevidencia.alterar(regimePrevidenciaTO);
		regimePrevidencia = regimePrevidenciaService.salvar(regimePrevidencia);
		return ok(regimePrevidencia);
	}

	@DELETE()
	@Path("/regimes-previdencia/{id}/")
	@Produces("application/json")
	public Response removerRegimePrevidencia(@PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);
		RegimePrevidencia regimePrevidencia = regimePrevidenciaService.buscarPorId(id);
		regimePrevidenciaService.excluir(regimePrevidencia);
		return ok();
	}

	@GET()
	@Path("/regimes-previdencia/{regimePrevidenciaId}/regimes-juridicos/")
	@Produces("application/json")
	public Response listarRegimesJuridicosPorRegimeDePrevidencia(@PathParam("regimePrevidenciaId") Long regimePrevidenciaId,
			@HeaderParam("token") String token) {
		validarToken(token);
		List<RegimeJuridico> regimesJuridicos = regimeJuridicoService.buscarPorRegimePrevidencia(regimePrevidenciaId);
		return ok(regimesJuridicos);
	}

	@GET()
	@Path("/regimes-juridicos-regimes-previdencia/")
	@Produces("application/json")
	public Response listarRegimeJuridicoRegimePrevidencia(@HeaderParam("token") String token) {
		validarToken(token);
		List<RegimeJuridicoRegimePrevidencia> regimesJuridicosRegimesPrevidencia = regimeJuridicoRegimePrevidenciaService.buscarTodos();
		return ok(regimesJuridicosRegimesPrevidencia);
	}

	@GET()
	@Path("/regimes-juridicos-regimes-previdencia/{id}/")
	@Produces("application/json")
	public Response obterRegimeJuridicoRegimePrevidencia(@PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);
		RegimeJuridicoRegimePrevidencia regimeJuridicoRegimePrevidencia = regimeJuridicoRegimePrevidenciaService.buscarPorId(id);
		return ok(regimeJuridicoRegimePrevidencia);
	}

	@POST()
	@Path("/regimes-juridicos-regimes-previdencia/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response criarRegimeJuridicoRegimePrevidencia(RegimeJuridicoRegimePrevidenciaTO regimeJuridicoRegimePrevidenciaTO, 
			@HeaderParam("token") String token) {
		validarToken(token);
		RegimeJuridicoRegimePrevidencia regimeJuridicoRegimePrevidencia = new RegimeJuridicoRegimePrevidencia(regimeJuridicoRegimePrevidenciaTO);
		regimeJuridicoRegimePrevidencia = regimeJuridicoRegimePrevidenciaService.salvar(regimeJuridicoRegimePrevidencia);
		return ok(regimeJuridicoRegimePrevidencia);
	}

	@PUT()
	@Path("/regimes-juridicos-regimes-previdencia/{id}/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response alterarRegimeJuridicoRegimePrevidencia(@PathParam("id") Long id, RegimeJuridicoRegimePrevidenciaTO regimeJuridicoRegimePrevidenciaTO, 
			@HeaderParam("token") String token) {
		validarToken(token);
		
		RegimeJuridicoRegimePrevidencia regimeJuridicoRegimePrevidencia = regimeJuridicoRegimePrevidenciaService.buscarPorId(id);
		if (regimeJuridicoRegimePrevidencia == null) {
			return notFound();
		}
		
		regimeJuridicoRegimePrevidencia = regimeJuridicoRegimePrevidenciaService.salvar(regimeJuridicoRegimePrevidencia);
		return ok(regimeJuridicoRegimePrevidencia);
	}

	@DELETE()
	@Path("/regimes-juridicos-regimes-previdencia/{id}/")
	@Produces("application/json")
	public Response removerRegimeJuridicoRegimePrevidencia(@PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);
		
		RegimeJuridicoRegimePrevidencia regimeJuridicoRegimePrevidencia = regimeJuridicoRegimePrevidenciaService.buscarPorId(id);
		if (regimeJuridicoRegimePrevidencia == null) {
			return notFound();
		}
		
		regimeJuridicoRegimePrevidenciaService.excluir(regimeJuridicoRegimePrevidencia);
		return ok();
	}

}