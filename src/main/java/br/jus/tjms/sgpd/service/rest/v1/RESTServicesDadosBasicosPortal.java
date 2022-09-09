package br.jus.tjms.sgpd.service.rest.v1;


import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
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

import br.jus.tjms.sgpd.entity.AgenciaBancaria;
import br.jus.tjms.sgpd.entity.AreaConhecimento;
import br.jus.tjms.sgpd.entity.Atitude;
import br.jus.tjms.sgpd.entity.Bairro;
import br.jus.tjms.sgpd.entity.Banco;
import br.jus.tjms.sgpd.entity.Cidade;
import br.jus.tjms.sgpd.entity.Competencia;
import br.jus.tjms.sgpd.entity.Conhecimento;
import br.jus.tjms.sgpd.entity.ContaCorrente;
import br.jus.tjms.sgpd.entity.ContaRecebimento;
import br.jus.tjms.sgpd.entity.Contato;
import br.jus.tjms.sgpd.entity.Curso;
import br.jus.tjms.sgpd.entity.DeclaracaoBens;
import br.jus.tjms.sgpd.entity.Documento;
import br.jus.tjms.sgpd.entity.Endereco;
import br.jus.tjms.sgpd.entity.Estado;
import br.jus.tjms.sgpd.entity.FormacaoAcademica;
import br.jus.tjms.sgpd.entity.Habilidade;
import br.jus.tjms.sgpd.entity.InstituicaoEnsino;
import br.jus.tjms.sgpd.entity.Localidade;
import br.jus.tjms.sgpd.entity.Logradouro;
import br.jus.tjms.sgpd.entity.OrgaoEmissor;
import br.jus.tjms.sgpd.entity.Pais;
import br.jus.tjms.sgpd.entity.Pessoa;
import br.jus.tjms.sgpd.entity.PessoaAtitude;
import br.jus.tjms.sgpd.entity.PessoaCompetencia;
import br.jus.tjms.sgpd.entity.PessoaConhecimento;
import br.jus.tjms.sgpd.entity.PessoaEndereco;
import br.jus.tjms.sgpd.entity.PessoaFormacao;
import br.jus.tjms.sgpd.entity.PessoaHabilidade;
import br.jus.tjms.sgpd.entity.Regiao;
import br.jus.tjms.sgpd.entity.RelacaoDependencia;
import br.jus.tjms.sgpd.entity.RelacaoHierarquica;
import br.jus.tjms.sgpd.entity.RelacaoSocial;
import br.jus.tjms.sgpd.entity.Veiculo;
import br.jus.tjms.sgpd.service.ServicesPortal;
import br.jus.tjms.sgpd.service.bancoservices.BancoService;
import br.jus.tjms.sgpd.service.bancoservices.ContaCorrenteService;
import br.jus.tjms.sgpd.service.dadosbasicosservices.AreaConhecimentoService;
import br.jus.tjms.sgpd.service.dadosbasicosservices.AtitudeService;
import br.jus.tjms.sgpd.service.dadosbasicosservices.BairroService;
import br.jus.tjms.sgpd.service.dadosbasicosservices.CidadeService;
import br.jus.tjms.sgpd.service.dadosbasicosservices.CompetenciaService;
import br.jus.tjms.sgpd.service.dadosbasicosservices.ConhecimentoService;
import br.jus.tjms.sgpd.service.dadosbasicosservices.ContatoService;
import br.jus.tjms.sgpd.service.dadosbasicosservices.CursoService;
import br.jus.tjms.sgpd.service.dadosbasicosservices.DeclaracaoBensService;
import br.jus.tjms.sgpd.service.dadosbasicosservices.DocumentoService;
import br.jus.tjms.sgpd.service.dadosbasicosservices.EnderecoService;
import br.jus.tjms.sgpd.service.dadosbasicosservices.EstadoService;
import br.jus.tjms.sgpd.service.dadosbasicosservices.FormacaoAcademicaService;
import br.jus.tjms.sgpd.service.dadosbasicosservices.HabilidadeService;
import br.jus.tjms.sgpd.service.dadosbasicosservices.InstituicaoEnsinoService;
import br.jus.tjms.sgpd.service.dadosbasicosservices.LocalidadeService;
import br.jus.tjms.sgpd.service.dadosbasicosservices.LogradouroService;
import br.jus.tjms.sgpd.service.dadosbasicosservices.OrgaoEmissorService;
import br.jus.tjms.sgpd.service.dadosbasicosservices.PaisService;
import br.jus.tjms.sgpd.service.dadosbasicosservices.PessoaService;
import br.jus.tjms.sgpd.service.dadosbasicosservices.RegiaoService;
import br.jus.tjms.sgpd.service.dadosbasicosservices.RelacaoDependenciaService;
import br.jus.tjms.sgpd.service.dadosbasicosservices.RelacaoHierarquicaService;
import br.jus.tjms.sgpd.service.dadosbasicosservices.RelacaoSocialService;
import br.jus.tjms.sgpd.service.dadosbasicosservices.VeiculoService;
import br.jus.tjms.sgpd.service.funcionarioservices.ContaRecebimentoService;
import br.jus.tjms.sgpd.service.funcionarioservices.FuncionarioService;
import br.jus.tjms.sgpd.service.rest.v1.to.AgenciaBancariaTO;
import br.jus.tjms.sgpd.service.rest.v1.to.AreaConhecimentoTO;
import br.jus.tjms.sgpd.service.rest.v1.to.AtitudeTO;
import br.jus.tjms.sgpd.service.rest.v1.to.BairroTO;
import br.jus.tjms.sgpd.service.rest.v1.to.BancoTO;
import br.jus.tjms.sgpd.service.rest.v1.to.CidadeTO;
import br.jus.tjms.sgpd.service.rest.v1.to.CompetenciaTO;
import br.jus.tjms.sgpd.service.rest.v1.to.ConhecimentoTO;
import br.jus.tjms.sgpd.service.rest.v1.to.ContaCorrenteTO;
import br.jus.tjms.sgpd.service.rest.v1.to.ContaRecebimentoTO;
import br.jus.tjms.sgpd.service.rest.v1.to.ContatoTO;
import br.jus.tjms.sgpd.service.rest.v1.to.CursoTO;
import br.jus.tjms.sgpd.service.rest.v1.to.DeclaracaoBensTO;
import br.jus.tjms.sgpd.service.rest.v1.to.DocumentoTO;
import br.jus.tjms.sgpd.service.rest.v1.to.EnderecoTO;
import br.jus.tjms.sgpd.service.rest.v1.to.EstadoTO;
import br.jus.tjms.sgpd.service.rest.v1.to.FormacaoAcademicaTO;
import br.jus.tjms.sgpd.service.rest.v1.to.HabilidadeTO;
import br.jus.tjms.sgpd.service.rest.v1.to.InstituicaoEnsinoTO;
import br.jus.tjms.sgpd.service.rest.v1.to.LocalidadeTO;
import br.jus.tjms.sgpd.service.rest.v1.to.LogradouroTO;
import br.jus.tjms.sgpd.service.rest.v1.to.OrgaoEmissorTO;
import br.jus.tjms.sgpd.service.rest.v1.to.PaisTO;
import br.jus.tjms.sgpd.service.rest.v1.to.PessoaCompetenciaTO;
import br.jus.tjms.sgpd.service.rest.v1.to.PessoaEnderecoTO;
import br.jus.tjms.sgpd.service.rest.v1.to.PessoaFormacaoTO;
import br.jus.tjms.sgpd.service.rest.v1.to.PessoaTO;
import br.jus.tjms.sgpd.service.rest.v1.to.RegiaoTO;
import br.jus.tjms.sgpd.service.rest.v1.to.RelacaoDependenciaTO;
import br.jus.tjms.sgpd.service.rest.v1.to.RelacaoHierarquicaTO;
import br.jus.tjms.sgpd.service.rest.v1.to.RelacaoSocialTO;
import br.jus.tjms.sgpd.service.rest.v1.to.VeiculoTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @version 1.0
 * @created 11-dez-2015 18:15:46
 */
@Path("/rest/v1")
public class RESTServicesDadosBasicosPortal extends RESTServicesBasePortalV1 implements ServicesPortal {

	private static final long serialVersionUID = 2799157152750732848L;
    private static Logger logger = LoggerFactory.getLogger(RESTServicesDadosBasicosPortal.class);
	
	@EJB
	private FuncionarioService funcionarioService;
	
	@EJB
	private RelacaoDependenciaService relacaoDependenciaService;
	
	@EJB
	private CompetenciaService competenciaService;
	
	@EJB
	private InstituicaoEnsinoService instituicaoEnsinoService;
	
	@EJB
	private AreaConhecimentoService areaConhecimentoService;
	
	@EJB 
	private EnderecoService enderecoService;
	
	@EJB
	private BancoService bancoService;
	
	@EJB
	private RelacaoSocialService relacaoSocialService;
	
	@EJB
	private VeiculoService veiculoService;
	
	@EJB
	private ContaRecebimentoService contaRecebimentoService;
	
	@EJB
	private RelacaoHierarquicaService relacaoHierarquicaService;
	
	@EJB
	private ContatoService contatoService;
	
	@EJB
	private DocumentoService documentoService;
	
	@EJB
	private CursoService cursoService;
	
	@EJB
	private DeclaracaoBensService declaracaoBensService;
	
	@EJB
	private ContaCorrenteService contaCorrenteService;
	
	@EJB
	private FormacaoAcademicaService formacaoAcademicaService; 
	
	@EJB
	private OrgaoEmissorService orgaoEmissorService; 
	
	@EJB
	private AtitudeService atitudeService;
	
	@EJB
	private ConhecimentoService conhecimentoService;
	
	@EJB
	private HabilidadeService habilidadeService;
	
	@EJB
	private LocalidadeService localidadeService;

	@EJB
	private LogradouroService logradouroService;

	@EJB
	private BairroService bairroService;
	
	@EJB
	private CidadeService cidadeService;
	
	@EJB
	private EstadoService estadoService;
	
	@EJB
	private RegiaoService regiaoService;
	
	@EJB
	private PaisService paisService;
	
	// pessoa
	
	/* 
	 * listarPessoas								GET		/pessoas/
	 * pesquisarPessoasPorNome						GET		/pesquisas/pessoas/nome/
	 * obterPessoa									GET		/pessoas/1							
	 * criarPessoa									POST	/pessoas/...
	 * alterarPessoa								PUT		/pessoas/1/...
	 * removerPessoa								DELETE	/pessoas/1
	 * 
	 * listarRelacoesDeDependenciaDaPessoa			GET		/pessoas/1/relacoes-dependencia/
	 * obterRelacaoDeDependencia					GET		/pessoas/1/relacoes-dependencia/1
	 * adicionarRelacaoDeDependencia				POST	/pessoas/1/relacoes-dependencia/...
	 * alterarRelacaoDeDependencia					PUT		/pessoas/1/relacoes-dependencia/1/...
	 * removerRelacaoDeDependencia					DELETE	/pessoas/1/relacoes-dependencia/1
	 * 
	 * listarRelacoesHierarquicasDaPessoa			GET		/pessoas/1/relacoes-hierarquicas/
	 * obterRelacaoHierarquica						GET		/pessoas/1/relacoes-hierarquicas/1
	 * adicionarRelacaoHierarquica					POST	/pessoas/1/relacoes-hierarquicas/...
	 * alterarRelacaoHierarquica					PUT		/pessoas/1/relacoes-hierarquicas/1/...
	 * removerRelacaoHierarquica					DELETE	/pessoas/1/relacoes-hierarquicas/1
	 *  
	 * listarRelacoesSociaisDaPessoa				GET		/pessoas/1/relacoes-sociais/
	 * obterRelacaoSocial							GET		/pessoas/1/relacoes-sociais/1
	 * adicionarRelacaoSocial						POST	/pessoas/1/relacoes-sociais/...
	 * alterarRelacaoSocial							PUT		/pessoas/1/relacoes-sociais/1/...
	 * removerRelacaoSocial 						DELETE	/pessoas/1/relacoes-sociais/1
	 * 
	 * listarContatosDaPessoa						GET		/pessoas/1/contatos/						
	 * obterContato									GET		/pessoas/1/contatos/1
	 * adicionarContato								POST	/pessoas/1/contatos/...
	 * alterarContato								PUT		/pessoas/1/contatos/1/...
	 * removerContato								DELETE	/pessoas/1/contatos/1
	 * 
	 * listarDocumentosDaPessoa						GET		/pessoas/1/documentos/
	 * obterDocumento								GET		/pessoas/1/documentos/1
	 * adicionarDocumento							POST	/pessoas/1/documentos/...
	 * alterarDocumento								PUT		/pessoas/1/documentos/1/...
	 * removerDocumento								DELETE	/pessoas/1/documentos/1
	 * 
	 * listarOrgaosEmissores						GET		/orgaos-emissores/
	 * obterOrgaoEmissor							GET		/orgaos-emissores/1
	 * adicionarOrgaoEmissor						POST	/orgaos-emissores/...
	 * alterarOrgaoEmissor							PUT		/orgaos-emissores/1/...
	 * removerOrgaoEmissor							DELETE	/orgaos-emissores/1
	 * 
	 * listarAtitudesDaPessoa						GET		/pessoas/1/atitudes/
	 * adicionarAtitudeAPessoa						POST	/pessoas/1/atitudes/...
	 * alterarAtitudeDaPessoa						PUT		/pessoas/1/atitudes/1/...
	 * removerAtitudeDaPessoa						DELETE	/pessoas/1/atitudes/1
	 * 
	 * listarAtitudes								GET		/atitudes/
	 * pesquisarAtitudesPorNome						GET		/pesquisas/atitudes/nome/
	 * obterAtitude									GET		/atitudes/1
	 * adicionarAtitude								POST	/atitudes/...
	 * alterarAtitude								PUT		/atitudes/1/...
	 * removerAtitude								DELETE	/atitudes/1
	 * 
	 * listarCompetenciasDaPessoa					GET		/pessoas/1/competencias/				
	 * adicionarCompetenciaAPessoa					POST	/pessoas/1/competencias/...
	 * alterarCompetenciaDaPessoa					PUT		/pessoas/1/competencias/1/...
	 * removerCompetenciaDaPessoa					DELETE	/pessoas/1/competencias/1
	 * 
	 * listarCompetencias							GET		/competencias/
	 * pesquisarCompetenciasPorNome					GET		/pesquisas/competencias/nome/
	 * obterCompetencia								GET		/competencias/1
	 * adicionarCompetencia							POST	/competencias/...
	 * alterarCompetencia							PUT		/competencias/1/...
	 * removerCompetencia							DELETE	/competencias/1
	 * 
	 * listarConhecimentosDaPessoa					GET		/pessoas/1/conhecimentos/
	 * adicionarConhecimentoAPessoa					POST	/pessoas/1/conhecimentos/...
	 * alterarConhecimentoDaPessoa					PUT		/pessoas/1/conhecimentos/1/...
	 * removerConhecimentoDaPessoa					DELETE	/pessoas/1/conhecimentos/1
	 * 
	 * listarConhecimentos							GET		/conhecimentos/
	 * pesquisarConhecimentos						GET		/pesquisas/conhecimentos/nome/
	 * obterConhecimento							GET		/conhecimentos/1
	 * adicionarConhecimento						POST	/conhecimentos/...
	 * alterarConhecimento							PUT		/conhecimentos/1/...
	 * removerConhecimento							DELETE	/conhecimentos/1
	 * 
	 * listarCursosDaPessoa							GET		/pessoas/1/cursos/
	 * adicionarCursoAPessoa						POST	/pessoas/1/cursos/...
	 * alterarCursoDaPessoa							PUT		/pessoas/1/cursos/1/...
	 * removerCursoDaPessoa							DELETE	/pessoas/1/cursos/1
	 * 
	 * listarInstituicoesEnsino						GET		/instituicoes-ensino/
	 * pesquisarInstituicoesEnsinoPorNome			GET		/pesquisas/instituicoes-ensino/nome/
	 * obterInstituicaoEnsino						GET		/instituicoes-ensino/1
	 * adicionarInstituicaoEnsino					POST	/instituicoes-ensino/...
	 * alterarInstituicaoEnsino						PUT		/instituicoes-ensino/1/...
	 * removerInstituicaoEnsino						DELETE	/instituicoes-ensino/1
	 * 
	 * AreaConhecimento:
	 * listarAreaConhecimento						GET		/areas-conhecimento/
	 * obterAreaConhecimento						GET		/areas-conhecimento/1
	 * criarAreaConhecimento						POST	/areas-conhecimento/...
	 * alterarAreaConhecimento						PUT		/areas-conhecimento/1/...
	 * removerAreaConhecimento						DELETE	/areas-conhecimento/1
	 * 
	 * listarCursosDaInstituicaoDeEnsino			GET		/instituicoes-ensino/1/cursos/
	 * pesquisarCursos								GET		/pesquisas/cursos/nome
	 * obterCurso									GET		/instituicoes-ensino/1/cursos/1
	 * adicionarCurso								POST	/instituicoes-ensino/1/cursos/...		
	 * alterarCurso									PUT		/instituicoes-ensino/1/cursos/1/...
	 * removerCurso									DELETE	/instituicoes-ensino/1/cursos/1
	 * 
	 * listarFormacoesDaPessoa						GET		/pessoas/1/formacoes/
	 * adicionarFormacaoAPessoa						POST	/pessoas/1/formacoes/...
	 * alterarFormacaoDaPessoa						PUT		/pessoas/1/formacoes/1/...
	 * removerFormacaoDaPessoa						DELETE	/pessoas/1/formacoes/1
	 * 
	 * listarFormacoesAcademicas					GET		/instituicoes-ensino/1/formacoes/
	 * pesquisarFormacoesAcademicas					GET		/pesquisas/formacoes/nome
	 * obterFormacaoAcademica						GET		/instituicoes-ensino/1/formacoes/1
	 * adicionarFormacaoAcademica					POST	/instituicoes-ensino/1/formacoes/...	
	 * alterarFormacaoAcademica						PUT		/instituicoes-ensino/1/formacoes/1/...
	 * removerFormacaoAcademica						DELETE	/instituicoes-ensino/1/formacoes/1
	 * 
	 * listarHabilidadesDaPessoa					GET		/pessoas/1/habilidades/
	 * adicionarHabilidadeAPessoa					POST	/pessoas/1/habilidades/...
	 * alterarHabilidadeDaPessoa					PUT		/pessoas/1/habilidades/1/...
	 * removerHabilidadeDaPessoa					DELETE	/pessoas/1/habilidades/1
	 * 
	 * listarHabilidades							GET		/habilidades/
	 * pesquisarHabilidades							GET		/pesquisas/habilidades/nome/
	 * obterHabilidade								GET		/habilidades/1
	 * adicionarHabilidade							POST	/habilidades/...
	 * alterarHabilidade							PUT		/habilidades/1/...
	 * removerHabilidade							DELETE	/habilidades/1
	 * 
	 * listarEnderecosDaPessoa						GET		/pessoas/1/enderecos/
	 * adicionarEnderecoAPessoa						POST	/pessoas/1/enderecos/...
	 * alterarEnderecoDaPessoa						PUT		/pessoas/1/enderecos/1/...
	 * removerEnderecoDaPessoa						DELETE	/pessoas/1/enderecos/1
	 * 
	 * listarEnderecos								GET		/enderecos/
	 * pesquisarEnderecos							GET		/pesquisas/enderecos/nome/
	 * obterEndereco								GET		/enderecos/1
	 * adicionarEndereco							POST	/enderecos/...
	 * alterarEndereco								PUT		/enderecos/1/...
	 * removerEndereco								DELETE	/enderecos/1
	 * 
	 * listarLocalidades							GET		/localidades/
	 * pesquisarLocalidades							GET		/pesquisas/localidades/nome/					
	 * obterLocalidade								GET		/localidades/1
	 * adicionarLocalidade							POST	/localidades/...
	 * alterarLocalidade							PUT		/localidades/1/...
	 * removerLocalidade							DELETE	/localidades/1
	 * 
	 * listarCidadesDoEstado						GET		/estados/1/cidades/
	 * pesquisarCidades								GET		/pesquisas/cidades/nome
	 * obterCidade									GET		/estados/1/cidades/1
	 * adicionarCidade								POST	/estados/1/cidades/...
	 * alterarCidade								PUT		/estados/1/cidades/1/...
	 * removerCidade								DELETE	/estados/1/cidades/1
	 * 
	 * listarEstados								GET		/estados/
	 * pesquisarEstados								GET		/pesquisas/estados/nome
	 * obterEstado									GET		/estados/1
	 * adicionarEstado								POST	/estados/...
	 * alterarEstado								PUT		/estados/1/...
	 * removerEstado								DELETE	/estados/1
	 *  
	 * listarRegioes								GET		/regioes/
	 * pesquisarRegioes								GET		/pesquisas/regioes/nome
	 * obterRegiao									GET		/regioes/1
	 * adicionarRegiao								POST	/regioes/...
	 * alterarRegiao								PUT		/regioes/1/...
	 * removerRegiao								DELETE	/regioes/1
	 * 
	 * listarPaises									GET		/paises/
	 * pesquisarPaises								GET		/pesquisas/paises/nome
	 * obterPais									GET		/paises/1
	 * adicionarPais								POST	/paises/...
	 * alterarPais									PUT		/paises/1/...
	 * removerPais									DELETE	/paises/1
	 * 
	 * listarVeiculosDaPessoa						GET		/pessoas/1/veiculos/
	 * obterVeiculoDaPessoa							GET		/pessoas/1/veiculos/1
	 * adicionarVeiculoAPessoa						POST	/pessoas/1/veiculos/...
	 * alterarVeiculoDaPessoa						PUT		/pessoas/1/veiculos/1/...
	 * removerVeiculoDaPessoa						DELETE	/pessoas/1/veiculos/1
	 * 
	 * listarDeclaracaoBensDaPessoa					GET		/pessoas/1/declaracoes-bens/
	 * obterDeclaracaoBensDaPessoa					GET		/pessoas/1/declaracoes-bens/1
	 * adicionarDeclaracaoBensAPessoa				POST	/pessoas/1/declaracoes-bens/...
	 * alterarDeclaracaoBensDaPessoa				PUT		/pessoas/1/declaracoes-bens/1/...
	 * removerDeclaracaoBensDaPessoa				DELETE	/pessoas/1/declaracoes-bens/1
 
	 * listarBancos									GET		/bancos/
	 * pesquisarBancos								GET		/pesquisas/bancos/nome
	 * obterBanco									GET		/bancos/1
	 * adicionarBanco								POST	/bancos/...
	 * alterarBanco									PUT		/bancos/1/...
	 * removerBanco									DELETE	/bancos/1
	 *  
	 * listarAgenciasBancarias						GET		/bancos/1/agencias/
	 * pesquisarAgenciasBancarias					GET		/pesquisas/bancos/1/agencias
	 * obterAgenciaBancaria							GET		/bancos/1/agencias/1
	 * adicionarAgenciaBancaria						POST	/bancos/1/agencias/...
	 * alterarAgenciaBancaria						PUT		/bancos/1/agencias/1/...
	 * removerAgenciaBancaria						DELETE	/bancos/1/agencias/1
  
	 * listarContasCorrentes						GET		/bancos/1/agencias/1/contas/
	 * pesquisarContasCorrentes						GET		/pesquisas/bancos/1/contas
	 * obterContaCorrente							GET		/bancos/1/agencias/1/contas/1
	 * adicionarContaCorrente						POST	/bancos/1/agencias/1/contas/...
	 * alterarContaCorrente							PUT		/bancos/1/agencias/1/contas/1/...
	 * removerContaCorrente							DELETE	/bancos/1/agencias/1/contas/1
	 * 
	 * listarContasRecebimentoDaPessoa				GET		/pessoas/1/contas-recebimento/
	 * obterContaRecebimento						GET		/pessoas/1/contas-recebimento/1
	 * adicionarContaRecebimento					POST	/pessoas/1/contas-recebimento/...
	 * alterarContaRecebimento						PUT		/pessoas/1/contas-recebimento/1/...
	 * removerContaRecebimento 						DELETE	/pessoas/1/contas-recebimento/1
	 * 
	 */
	

	@EJB
	private PessoaService pessoaService;
	
	@GET()
	@Path("/pessoas/")
	@Produces("application/json")
	public Response listarPessoas(@HeaderParam("token") String token) {
		validarToken(token);
		List<Pessoa> pessoas = pessoaService.buscarTodos();
		return ok(pessoas);
	}

	@GET()
	@Path("/pesquisas/pessoas/nome/{nome}")
	@Produces("application/json")
	public Response pesquisarPessoasPorNome(@PathParam("nome") String nome, @HeaderParam("token") String token) {
		
		try {
			nome = URLDecoder.decode(nome, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			logger.error(e.getMessage(), e);
		}
		
		validarToken(token);
		List<Pessoa> pessoas = pessoaService.buscarPessoasPorNome(nome);
		return ok(pessoas);
	}

	@GET()
	@Path("/pessoas/{id}")
	@Produces("application/json")
	public Response obterPessoa(@PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);
		Pessoa pessoa = pessoaService.buscarPorId(id);
		return ok(pessoa);
	}

	@POST()
	@Path("/pessoas/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response criarPessoa(PessoaTO pessoa, @HeaderParam("token") String token) {
		validarToken(token);
		Pessoa novaPessoa = new Pessoa(pessoa);
		novaPessoa = pessoaService.salvar(novaPessoa);
		return ok(novaPessoa);
	}

	@PUT()
	@Path("/pessoas/{id}/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response alterarPessoa(@PathParam("id") Long id, PessoaTO pessoa, @HeaderParam("token") String token) {
		validarToken(token);
		
		Pessoa pessoaExistente = pessoaService.buscarPorId(id);
		if (pessoa == null) {
			return notFound();
		}
		
		pessoaExistente.atualizarDados(pessoa);
		pessoaService.salvar(pessoaExistente);
		
		return ok(pessoaExistente);
	}

	@DELETE()
	@Path("/pessoas/{id}")
	@Produces("application/json")	
	public Response removerPessoa(@PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);
		
		Pessoa pessoa = pessoaService.buscarPorId(id);
		if (pessoa == null) {
			return notFound();
		}
		
		pessoaService.excluir(pessoa);
		return ok();
	}
	
	@GET()
	@Path("/pessoas/{pessoaId}/relacoes-dependencia/")
	@Produces("application/json")
	public Response listarRelacoesDeDependenciaDaPessoa(@PathParam("pessoaId") Long pessoaId, @HeaderParam("token") String token) {
		validarToken(token);
		List<RelacaoDependencia> relacoesDeDependencia = relacaoDependenciaService.buscarRelacoesDeDependenciaPorPessoa(pessoaId);
		return ok(relacoesDeDependencia);
	}

	@GET()
	@Path("/pessoas/{pessoaId}/relacoes-dependencia/{id}/")
	@Produces("application/json")
	public Response obterRelacaoDeDependencia(@PathParam("pessoaId") Long pessoaId, @PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);
		RelacaoDependencia relacaoDependencia = relacaoDependenciaService.buscarPorId(id);
		return ok(relacaoDependencia);
	}

	@POST()
	@Path("/pessoas/{pessoaId}/relacoes-dependencia/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response adicionarRelacaoDeDependencia(@PathParam("pessoaId") Long pessoaId, RelacaoDependenciaTO relacaoDependenciaTO, @HeaderParam("token") String token) {
		validarToken(token);
		
		final Pessoa pessoa = pessoaService.buscarPorId(relacaoDependenciaTO.getPessoaId());
		final Pessoa pessoaRelacionada = pessoaService.buscarPorId(relacaoDependenciaTO.getPessoaRelacionadaId());
		if (pessoa == null || pessoaRelacionada == null) {
			return notFound();
		}
		
		RelacaoDependencia relacaoDependencia = new RelacaoDependencia(relacaoDependenciaTO);
		relacaoDependencia = relacaoDependenciaService.salvar(relacaoDependencia);
		return ok(relacaoDependencia);
	}

	@PUT()
	@Path("/pessoas/{pessoaId}/relacoes-dependencia/{id}/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response alterarRelacaoDeDependencia(@PathParam("pessoaId") Long pessoaId, @PathParam("id") Long id, RelacaoDependenciaTO relacaoDependenciaTO, @HeaderParam("token") String token) {
		validarToken(token);
		
		RelacaoDependencia relacaoDependencia = relacaoDependenciaService.buscarPorId(id);
		if (relacaoDependencia ==  null) {
			return notFound();
		}
		
		relacaoDependencia.alterar(relacaoDependenciaTO);
		relacaoDependencia = relacaoDependenciaService.salvar(relacaoDependencia);
		return ok(relacaoDependencia);
	}

	@DELETE()
	@Path("/pessoas/{pessoaId}/relacoes-dependencia/{id}/")
	@Produces("application/json")
	public Response removerRelacaoDeDependencia(@PathParam("pessoaId") Long pessoaId, @PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);
		
		RelacaoDependencia relacaoDependencia = relacaoDependenciaService.buscarPorId(id);
		if (relacaoDependencia == null) {
			return notFound();
		}
		
		relacaoDependenciaService.excluir(relacaoDependencia);
		return ok();
	}

	@GET()
	@Path("/pessoas/{pessoaId}/relacoes-hierarquicas/")
	@Produces("application/json")
	public Response listarRelacoesHierarquicasDaPessoa(@PathParam("pessoaId") Long pessoaId, @HeaderParam("token") String token) {
		validarToken(token);
		List<RelacaoHierarquica> relacoesHierarquicas = relacaoHierarquicaService.buscarRelacoesHierarquicasPorPessoa(pessoaId);
		return ok(relacoesHierarquicas);
	}

	@GET()
	@Path("/pessoas/{pessoaId}/relacoes-hierarquicas/{id}/")
	@Produces("application/json")
	public Response obterRelacaoHierarquica(@PathParam("pessoaId") Long pessoaId, @PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);
		RelacaoHierarquica relacaoHierarquica = relacaoHierarquicaService.buscarPorId(id);
		return ok(relacaoHierarquica);
	}

	@POST()
	@Path("/pessoas/{pessoaId}/relacoes-hierarquicas/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response adicionarRelacaoHierarquica(@PathParam("pessoaId") Long id, RelacaoHierarquicaTO relacaoHierarquicaTO, @HeaderParam("token") String token) {
		validarToken(token);
		
		final Pessoa pessoa = pessoaService.buscarPorId(relacaoHierarquicaTO.getPessoaId());
		final Pessoa pessoaRelacionada = pessoaService.buscarPorId(relacaoHierarquicaTO.getPessoaRelacionadaId());
		if (pessoa == null || pessoaRelacionada == null) {
			return notFound();
		}
		
		relacaoHierarquicaTO.setPessoa(pessoa);
		relacaoHierarquicaTO.setPessoaRelacionada(pessoaRelacionada);
		
		RelacaoHierarquica relacaoHierarquica = new RelacaoHierarquica(relacaoHierarquicaTO);
		relacaoHierarquica = relacaoHierarquicaService.salvar(relacaoHierarquica);
		return ok(relacaoHierarquica);
	}

	@PUT()
	@Path("/pessoas/{pessoaId}/relacoes-hierarquicas/{id}/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response alterarRelacaoHierarquica(@PathParam("pessoaId") Long pessoaId, @PathParam("id") Long id, RelacaoHierarquicaTO relacaoHierarquicaTO, @HeaderParam("token") String token) {
		validarToken(token);
		
		RelacaoHierarquica relacaoHierarquica = relacaoHierarquicaService.buscarPorId(id);
		if (relacaoHierarquica == null) {
			return notFound();
		}
		
		relacaoHierarquica.alterar(relacaoHierarquicaTO);
		relacaoHierarquica = relacaoHierarquicaService.salvar(relacaoHierarquica);
		return ok(relacaoHierarquica);
	}

	@DELETE()
	@Path("/pessoas/{pessoaId}/relacoes-hierarquicas/{id}/")
	@Produces("application/json")
	public Response removerRelacaoHierarquica(@PathParam("pessoaId") Long pessoaId, @PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);
		
		RelacaoHierarquica relacaoHierarquica = relacaoHierarquicaService.buscarPorId(id);
		if (relacaoHierarquica == null) {
			return notFound();
		}
		
		relacaoHierarquicaService.excluir(relacaoHierarquica);
		return ok();
	}

	@GET()
	@Path("/pessoas/{pessoaId}/relacoes-sociais/")
	@Produces("application/json")
	public Response listarRelacoesSociaisDaPessoa(@PathParam("pessoaId") Long pessoaId, @HeaderParam("token") String token) {
		validarToken(token);
		List<RelacaoSocial> relacoesSociais = relacaoSocialService.buscarRelacoesSociaisPorPessoa(pessoaId);
		return ok(relacoesSociais);
	}

	@GET()
	@Path("/pessoas/{pessoaId}/relacoes-sociais/{id}/")
	@Produces("application/json")
	public Response obterRelacaoSocial(@PathParam("pessoaId") Long pessoaId, @PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);
		RelacaoSocial relacaoSocial = relacaoSocialService.buscarPorId(id);
		return ok(relacaoSocial);
	}

	@POST()
	@Path("/pessoas/{pessoaId}/relacoes-sociais/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response adicionarRelacaoSocial(@PathParam("pessoaId") Long pessoaId, RelacaoSocialTO relacaoSocialTO, @HeaderParam("token") String token) {
		validarToken(token);
		
		final Pessoa pessoa = pessoaService.buscarPorId(relacaoSocialTO.getPessoaId());
		final Pessoa pessoaRelacionada = pessoaService.buscarPorId(relacaoSocialTO.getPessoaRelacionadaId());
		if (pessoa == null || pessoaRelacionada == null) {
			return notFound();
		}
		
		relacaoSocialTO.setPessoa(pessoa);
		relacaoSocialTO.setPessoaRelacionada(pessoaRelacionada);
		
		RelacaoSocial relacaoSocial = new RelacaoSocial(relacaoSocialTO);
		relacaoSocial = relacaoSocialService.salvar(relacaoSocial);
		return ok(relacaoSocial);
	}

	@PUT()
	@Path("/pessoas/{pessoaId}/relacoes-sociais/{id}/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response alterarRelacaoSocial(@PathParam("pessoaId") Long pessoaId, @PathParam("id") Long id, RelacaoSocialTO relacaoSocialTO, @HeaderParam("token") String token) {
		validarToken(token);
		
		RelacaoSocial relacaoSocial = relacaoSocialService.buscarPorId(id);
		if (relacaoSocial == null) {
			return notFound();
		}
		
		relacaoSocial.alterar(relacaoSocialTO);
		relacaoSocial = relacaoSocialService.salvar(relacaoSocial);
		return ok(relacaoSocial);
	}

	@DELETE()
	@Path("/pessoas/{pessoaId}/relacoes-sociais/{id}/")
	@Produces("application/json")
	public Response removerRelacaoSocial(@PathParam("pessoaId") Long pessoaId, @PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);
		
		RelacaoSocial relacaoSocial = relacaoSocialService.buscarPorId(id);
		if (relacaoSocial == null) {
			return notFound();
		}
		
		relacaoSocialService.excluir(relacaoSocial);
		return ok();
	}

	@GET()
	@Path("/pessoas/{id}/contatos/")
	@Produces("application/json")
	public Response listarContatosDaPessoa(@PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);
		List<Contato> contatos = contatoService.buscarContatosPorPessoa(id);
		return ok(contatos);
	}

	@GET()
	@Path("/pessoas/{pessoaId}/contatos/{id}/")
	@Produces("application/json")
	public Response obterContato(@PathParam("pessoaId") Long pessoaId, @PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);
		Contato contato = contatoService.buscarPorId(id);
		return ok(contato);
	}

	@POST()
	@Path("/pessoas/{id}/contatos/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response adicionarContato(@PathParam("id") Long id, ContatoTO contatoTO, @HeaderParam("token") String token) {
		validarToken(token);
		
		final Pessoa pessoa = pessoaService.buscarPorId(contatoTO.getPessoaId());
		final Pessoa pessoaRelacionada = pessoaService.buscarPorId(contatoTO.getPessoaRelacionadaId());
		if (pessoa == null || pessoaRelacionada == null) {
			return notFound();
		}
		
		contatoTO.setPessoa(pessoa);
		contatoTO.setPessoaRelacionada(pessoaRelacionada);
		
		Contato contato = new Contato(contatoTO);
		contato = contatoService.salvar(contato);
		return ok(contato);
	}

	@PUT()
	@Path("/pessoas/{pessoaId}/contatos/{id}/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response alterarContato(@PathParam("pessoaId") Long pessoaId, @PathParam("id") Long id, ContatoTO contatoTO, @HeaderParam("token") String token) {
		validarToken(token);

		Contato contato = contatoService.buscarPorId(id);
		if (contato == null) {
			return notFound();
		}
		
		contato.alterar(contatoTO);
		contato = contatoService.salvar(contato);
		return ok(contato);
	}

	@DELETE()
	@Path("/pessoas/{pessoaId}/contatos/{id}/")
	@Produces("application/json")
	public Response removerContato(@PathParam("pessoaId") Long pessoaId, @PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);
		
		Contato contato = contatoService.buscarPorId(id);
		if (contato == null) {
			return notFound();
		}
		
		contatoService.excluir(contato);
		return ok();
	}

	@GET()
	@Path("/pessoas/{id}/documentos/")
	@Produces("application/json")
	public Response listarDocumentosDaPessoa(@PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);
		List<Documento> documentos = documentoService.buscarDocumentosPorPessoa(id);
		return ok(documentos);
	}

	@GET()
	@Path("/pessoas/{pessoaId}/documentos/{id}/")
	@Produces("application/json")
	public Response obterDocumento(@PathParam("pessoaId") Long pessoaId, @PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);
		Documento documento = documentoService.buscarPorId(id);
		return ok(documento);
	}

	@POST()
	@Path("/pessoas/{pessoaId}/documentos/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response adicionarDocumento(@PathParam("pessoaId") Long pessoaId, DocumentoTO documentoTO, @HeaderParam("token") String token) {
		validarToken(token);
		
		final Pessoa pessoa = pessoaService.buscarPorId(documentoTO.getPessoaId());
		if (pessoa == null) {
			return notFound();
		}
		
		documentoTO.setPessoa(pessoa);
		
		Documento documento = new Documento(documentoTO);
		documento = documentoService.salvar(documento);
		return ok(documento);
	}

	@PUT()
	@Path("/pessoas/{pessoaId}/documentos/{id}/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response alterarDocumento(@PathParam("pessoaId") Long pessoaId, @PathParam("id") Long id, DocumentoTO documentoTO, @HeaderParam("token") String token) {
		validarToken(token);

		Documento documento = documentoService.buscarPorId(id);
		if(documento == null) {
			return notFound();
		}
		
		documento.alterar(documentoTO);
		documento = documentoService.salvar(documento);
		return ok(documento);
	}

	@DELETE()
	@Path("/pessoas/{pessoaId}/documentos/{id}/")
	@Produces("application/json")
	public Response removerDocumento(@PathParam("pessoaId") Long pessoaId, @PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);
		
		Documento documento = documentoService.buscarPorId(id);
		if (documento == null) {
			return notFound();
		}
		
		documentoService.excluir(documento);
		return ok();
	}

	@GET()
	@Path("/orgaos-emissores/")
	@Produces("application/json")
	public Response listarOrgaosEmissores(@HeaderParam("token") String token) {
		validarToken(token);
		List<OrgaoEmissor> orgaoesEmissores = orgaoEmissorService.buscarTodos();
		return ok(orgaoesEmissores);
	}

	@GET()
	@Path("/orgaos-emissores/{id}/")
	@Produces("application/json")
	public Response obterOrgaoEmissor(@PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);
		OrgaoEmissor orgaoEmissor = orgaoEmissorService.buscarPorId(id);
		return ok(orgaoEmissor);
	}

	@POST()
	@Path("/orgaos-emissores/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response adicionarOrgaoEmissor(OrgaoEmissorTO orgaoEmissorTO, @HeaderParam("token") String token) {
		validarToken(token);
		OrgaoEmissor orgaoEmissor = new OrgaoEmissor(orgaoEmissorTO);
		orgaoEmissor = orgaoEmissorService.salvar(orgaoEmissor);
		return ok(orgaoEmissor);
	}

	@PUT()
	@Path("/orgaos-emissores/{id}/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response alterarOrgaoEmissor(@PathParam("id") Long id, OrgaoEmissorTO orgaoEmissorTO, @HeaderParam("token") String token) {
		validarToken(token);

		OrgaoEmissor orgaoEmissor = orgaoEmissorService.buscarPorId(id);
		if (orgaoEmissor == null) {
			return notFound();
		}
		
		orgaoEmissor.alterar(orgaoEmissorTO);
		orgaoEmissor = orgaoEmissorService.salvar(orgaoEmissor);
		return ok(orgaoEmissor);
	}

	@DELETE()
	@Path("/orgaos-emissores/{id}/")
	@Produces("application/json")
	public Response removerOrgaoEmissor(@PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);
		
		OrgaoEmissor orgaoEmissor = orgaoEmissorService.buscarPorId(id);
		if (orgaoEmissor == null) {
			return notFound();
		}
		
		orgaoEmissorService.excluir(orgaoEmissor);
		return ok();
	}

	@GET()
	@Path("/pessoas/{pessoaId}/atitudes/")
	@Produces("application/json")
	public Response listarAtitudesDaPessoa(@PathParam("pessoaId") Long pessoaId, @HeaderParam("token") String token) {
		validarToken(token);
		List<Atitude> atitudes = atitudeService.buscarPorPessoa(pessoaId);
		return ok(atitudes);
	}

	@POST()
	@Path("/pessoas/{pessoaId}/atitudes/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response adicionarAtitudeAPessoa(@PathParam("pessoaId") Long pessoaId, AtitudeTO atitudeTO, @HeaderParam("token") String token) {
		validarToken(token);
		
		final Pessoa pessoa = pessoaService.buscarPorId(pessoaId);
		if (pessoa == null) {
			return notFound();
		}
		
		PessoaAtitude pessoaAtitude = new PessoaAtitude(atitudeTO, pessoa);
		pessoaAtitude = atitudeService.salvarPessoaAtitude(pessoaAtitude);
		return ok(pessoaAtitude);
	}

	@PUT()
	@Path("/pessoas/{pessoaId}/atitudes/{id}/")
	@Produces("application/json")
	public Response alterarAtitudeDaPessoa(@PathParam("pessoaId") Long pessoaId, @PathParam("id") Long id, AtitudeTO atitudeTO, @HeaderParam("token") String token) {
		validarToken(token);
		
		PessoaAtitude pessoaAtitude = atitudeService.buscarPessoaAtitudePorId(id);
		if (pessoaAtitude == null) {
			return notFound();
		}
		
		pessoaAtitude.alterar(atitudeTO);
		pessoaAtitude = atitudeService.salvarPessoaAtitude(pessoaAtitude);
		return ok(pessoaAtitude);
	}

	@DELETE()
	@Path("/pessoas/{pessoaId}/atitudes/{id}/")
	@Produces("application/json")
	public Response removerAtitudeDaPessoa(@PathParam("pessoaId") Long pessoaId, @PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);

		PessoaAtitude pessoaAtitude = atitudeService.buscarPessoaAtitudePorId(id);
		if (pessoaAtitude == null) {
			return notFound();
		}
		
		atitudeService.excluirPessoaAtitude(pessoaAtitude);
		return ok();
	}

	@GET()
	@Path("/atitudes/")
	@Produces("application/json")
	public Response listarAtitudes(@HeaderParam("token") String token) {
		validarToken(token);
		List<Atitude> atitudes = atitudeService.buscarTodos();
		return ok(atitudes);
	}

	@GET()
	@Path("/pesquisas/atitudes/nome/{nome}")
	@Produces("application/json")
	public Response pesquisarAtitudesPorNome(@PathParam("nome") String nome, @HeaderParam("token") String token) {
		validarToken(token);
		List<Atitude> atitudes = atitudeService.buscarPorNome(nome);
		return ok(atitudes);
	}

	@GET()
	@Path("/atitudes/{id}/")
	@Produces("application/json")
	public Response obterAtitude(@PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);
		Atitude atitude = atitudeService.buscarPorId(id);
		return ok(atitude);
	}

	@POST()
	@Path("/atitudes/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response adicionarAtitude(AtitudeTO atitudeTO, @HeaderParam("token") String token) {
		validarToken(token);
		Atitude atitude = new Atitude(atitudeTO);
		atitude = atitudeService.salvar(atitude);
		return ok(atitude);
	}

	@PUT()
	@Path("/atitudes/{id}/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response alterarAtitude(@PathParam("id") Long id, AtitudeTO atitudeTO, @HeaderParam("token") String token) {
		validarToken(token);
		
		Atitude atitude = atitudeService.buscarPorId(id);
		if (atitude == null) {
			return notFound();
		}
		
		atitude.alterar(atitudeTO);
		atitude = atitudeService.salvar(atitude);
		return ok(atitude);
	}

	@DELETE()
	@Path("/atitudes/{id}/")
	@Produces("application/json")
	public Response removerAtitude(@PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);

		Atitude atitude = atitudeService.buscarPorId(id);
		if (atitude == null) {
			return notFound();
		}
		
		atitudeService.excluir(atitude);
		return ok();
	}

	@GET()
	@Path("/pessoas/{pessoaId}/competencias/")
	@Produces("application/json")
	public Response listarCompetenciasDaPessoa(@PathParam("pessoaId") Long pessoaId, @HeaderParam("token") String token) {
		validarToken(token);
		List<Competencia> competencias = competenciaService.buscarCompetenciasPorPessoa(pessoaId);
		return ok(competencias);
	}

	@POST()
	@Path("/pessoas/{pessoaId}/competencias/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response adicionarCompetenciaAPessoa(@PathParam("pessoaId") Long pessoaId, PessoaCompetenciaTO pessoaCompetenciaTO, @HeaderParam("token") String token) {
		validarToken(token);
		
		final Pessoa pessoa = pessoaService.buscarPorId(pessoaId);
		if (pessoa == null) {
			return notFound();
		}
		
		pessoaCompetenciaTO.setPessoa(pessoa);
		PessoaCompetencia pessoaCompetencia =  new PessoaCompetencia(pessoaCompetenciaTO);
		pessoaCompetencia = competenciaService.salvarPessoaCompetencia(pessoaCompetencia);
		return ok(pessoaCompetencia);
	}

	@PUT()
	@Path("/pessoas/{pessoaId}/competencias/{id}/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response alterarCompetenciaDaPessoa(@PathParam("pessoaId") Long pessoaId, @PathParam("id") Long id, CompetenciaTO competenciaTO, @HeaderParam("token") String token) {
		validarToken(token);
		Object o = funcionarioService.buscarPorId(id);
		return ok(o);
	}

	@DELETE()
	@Path("/pessoas/{pessoaId}/competencias/{id}/")
	@Produces("application/json")
	public Response removerCompetenciaDaPessoa(@PathParam("pessoaId") Long pessoaId, @PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);
		Object o = funcionarioService.buscarPorId(id);
		return ok(o);
	}

	@GET()
	@Path("/competencias/")
	@Produces("application/json")
	public Response listarCompetencias(@HeaderParam("token") String token) {
		validarToken(token);
		List<Competencia> competencias = competenciaService.buscarTodos();
		return ok(competencias);
	}

	@GET()
	@Path("/pesquisas/competencias/nome/{nome}")
	@Produces("application/json")
	public Response pesquisarCompetenciasPorNome(@PathParam("nome") String nome, @HeaderParam("token") String token) {
		validarToken(token);
		Competencia competencia = competenciaService.buscarPorNome(nome);
		return ok(competencia);
	}

	@GET()
	@Path("/competencias/{id}/")
	@Produces("application/json")
	public Response obterCompetencia(@PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);
		Competencia competencia = competenciaService.buscarPorId(id);
		return ok(competencia);
	}

	@POST()
	@Path("/competencias/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response adicionarCompetencia(CompetenciaTO competenciaTO, @HeaderParam("token") String token) {
		validarToken(token);
		Competencia competencia = new Competencia(competenciaTO);
		competencia = competenciaService.salvar(competencia);
		return ok(competencia);
	}

	@PUT()
	@Path("/competencias/{id}/")
	@Produces("application/json")
	public Response alterarCompetencia(@PathParam("id") Long id, CompetenciaTO competenciaTO, @HeaderParam("token") String token) {
		validarToken(token);
		
		Competencia competencia = competenciaService.buscarPorId(id);
		if (competencia == null) {
			return notFound();
		}
		
		competencia.alterar(competenciaTO);
		competencia = competenciaService.salvar(competencia);
		return ok(competencia);
	}

	@DELETE()
	@Path("/competencias/{id}/")
	@Produces("application/json")
	public Response removerCompetencia(@PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);
		
		Competencia competencia = competenciaService.buscarPorId(id);
		if (competencia == null) {
			return notFound();
		}
		
		competenciaService.excluir(competencia);
		return ok();
	}

	@GET()
	@Path("/pessoas/{pessoaId}/conhecimentos/")
	@Produces("application/json")
	public Response listarConhecimentosDaPessoa(@PathParam("pessoaId") Long pessoaId, @HeaderParam("token") String token) {
		validarToken(token);
		List<Conhecimento> conhecimentos = conhecimentoService.buscarConhecimentosPorPessoa(pessoaId);
		return ok(conhecimentos);
	}

	@POST()
	@Path("/pessoas/{pessoaId}/conhecimentos/")
	@Produces("application/json")
	public Response adicionarConhecimentoAPessoa(@PathParam("pessoaId") Long pessoaId, ConhecimentoTO conhecimentoTO, @HeaderParam("token") String token) {
		validarToken(token);
		
		final Pessoa pessoa = pessoaService.buscarPorId(pessoaId);
		if (pessoa == null) {
			return notFound();
		}
		
		PessoaConhecimento pessoaConhecimento =  new PessoaConhecimento(conhecimentoTO, pessoa);
		pessoaConhecimento = conhecimentoService.salvarPessoaConhecimento(pessoaConhecimento);
		return ok(pessoaConhecimento);
	}

	@PUT()
	@Path("/pessoas/{pessoaId}/conhecimentos/{id}/")
	@Produces("application/json")
	public Response alterarConhecimentoDaPessoa(@PathParam("pessoaId") Long pessoaId, @PathParam("id") Long id, ConhecimentoTO conhecimentoTO, @HeaderParam("token") String token) {
		validarToken(token);

		PessoaConhecimento pessoaConhecimento = conhecimentoService.buscarPessoaConhecimentoPorId(id);
		if (pessoaConhecimento == null) {
			return notFound();
		}
		
		pessoaConhecimento.alterar(conhecimentoTO);
		pessoaConhecimento = conhecimentoService.salvarPessoaConhecimento(pessoaConhecimento);
		return ok(pessoaConhecimento);
	}

	@DELETE()
	@Path("/pessoas/{pessoaId}/conhecimentos/{id}/")
	@Produces("application/json")
	public Response removerConhecimentoDaPessoa(@PathParam("pessoaId") Long pessoaId, @PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);

		PessoaConhecimento pessoaConhecimento = conhecimentoService.buscarPessoaConhecimentoPorId(id);
		if (pessoaConhecimento == null) {
			return notFound();
		}
		
		conhecimentoService.excluirPessoaConhecimento(pessoaConhecimento);
		return ok();
	}

	@GET()
	@Path("/conhecimentos/")
	@Produces("application/json")
	public Response listarConhecimentos(@HeaderParam("token") String token) {
		validarToken(token);
		List<Conhecimento> conhecimentos = conhecimentoService.buscarTodos();
		return ok(conhecimentos);
	}

	@GET()
	@Path("/pesquisas/conhecimentos/nome/{nome}")
	@Produces("application/json")
	public Response pesquisarConhecimentos(@PathParam("nome") String nome, @HeaderParam("token") String token) {
		validarToken(token);
		List<Conhecimento> conhecimentos = conhecimentoService.buscarConhecimentosPorNome(nome);
		return ok(conhecimentos);
	}

	@GET()
	@Path("/conhecimentos/{id}/")
	@Produces("application/json")
	public Response obterConhecimento(@PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);
		Conhecimento conhecimento = conhecimentoService.buscarPorId(id);
		return ok(conhecimento);
	}

	@POST()
	@Path("/conhecimentos/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response adicionarConhecimento(ConhecimentoTO conhecimentoTO, @HeaderParam("token") String token) {
		validarToken(token);
		Conhecimento conhecimento = new Conhecimento(conhecimentoTO);
		conhecimento = conhecimentoService.salvar(conhecimento);
		return ok(conhecimento);
	}

	@PUT()
	@Path("/conhecimentos/{id}/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response alterarConhecimento(@PathParam("id") Long id, ConhecimentoTO conhecimentoTO, @HeaderParam("token") String token) {
		validarToken(token);
		
		Conhecimento conhecimento = conhecimentoService.buscarPorId(id);
		if (conhecimento == null) {
			return notFound();
		}
		
		conhecimento.alterar(conhecimentoTO);
		conhecimento = conhecimentoService.salvar(conhecimento);
		return ok(conhecimento);
	}

	@DELETE()
	@Path("/conhecimentos/{id}/")
	@Produces("application/json")
	public Response removerConhecimento(@PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);

		Conhecimento conhecimento = conhecimentoService.buscarPorId(id);
		if (conhecimento == null) {
			return notFound();
		}
		
		conhecimentoService.excluir(conhecimento);
		return ok();
	}

	@GET()
	@Path("/pessoas/{id}/cursos/")
	@Produces("application/json")
	public Response listarCursosDaPessoa(@PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);
		List<Curso> cursos = cursoService.buscarCursosPorPessoa(id);
		return ok(cursos);
	}

	@POST()
	@Path("/pessoas/{pessoaId}/cursos/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response adicionarCursoAPessoa(@PathParam("pessoaId") Long pessoaId, CursoTO cursoTO, @HeaderParam("token") String token) {
		validarToken(token);
		
		final Pessoa pessoa = pessoaService.buscarPorId(pessoaId);
		if (pessoa == null) {
			return notFound();
		}
		
		Curso curso = new Curso(cursoTO);
		//FIXME PessoaCurso pessoaCurso = new PessoaCurso(id, curso, pessoa, inicio, fim, cargaHoraria);
		//ta faltando campos e ta estranho, acho que o TO deveria ser PessoaCursoTO
		cursoService.salvar(curso);
		return ok(curso);
	}

	@PUT()
	@Path("/pessoas/{pessoaId}/cursos/{id}/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response alterarCursoDaPessoa(@PathParam("pessoaId") Long pessoaId, @PathParam("id") Long id, CursoTO cursoTO, @HeaderParam("token") String token) {
		validarToken(token);
		Object o = funcionarioService.buscarPorId(id);
		return ok(o);
	}

	@DELETE()
	@Path("/pessoas/{pessoaId}/cursos/{id}/")
	@Produces("application/json")
	public Response removerCursoDaPessoa(@PathParam("pessoaId") Long pessoaId, @PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);
		Object o = funcionarioService.buscarPorId(id);
		return ok(o);
	}

	@GET()
	@Path("/instituicoes-ensino/")
	@Produces("application/json")
	public Response listarInstituicoesEnsino(@HeaderParam("token") String token) {
		validarToken(token);
		List<InstituicaoEnsino> instituicoesEnsino = instituicaoEnsinoService.buscarTodos();
		return ok(instituicoesEnsino);
	}

	@GET()
	@Path("/pesquisas/instituicoes-ensino/nome/{nome}")
	@Produces("application/json")
	public Response pesquisarInstituicoesEnsinoPorNome(@PathParam("nome") String nome, @HeaderParam("token") String token) {
		validarToken(token);
		List<InstituicaoEnsino> instituicoesEnsino = instituicaoEnsinoService.buscarInstituicoesEnsinoPorNome(nome);
		return ok(instituicoesEnsino);
	}

	@GET()
	@Path("/instituicoes-ensino/{id}/")
	@Produces("application/json")
	public Response obterInstituicaoEnsino(@PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);
		InstituicaoEnsino instituicaoEnsino = instituicaoEnsinoService.buscarPorId(id);
		return ok(instituicaoEnsino);
	}

	@POST()
	@Path("/instituicoes-ensino/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response adicionarInstituicaoEnsino(InstituicaoEnsinoTO instituicaoEnsinoTO, @HeaderParam("token") String token) {
		validarToken(token);
		InstituicaoEnsino instituicaoEnsino = new InstituicaoEnsino(instituicaoEnsinoTO);
		instituicaoEnsino = instituicaoEnsinoService.salvar(instituicaoEnsino);
		return ok(instituicaoEnsino);
	}

	@PUT()
	@Path("/instituicoes-ensino/{id}/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response alterarInstituicaoEnsino(@PathParam("id") Long id, InstituicaoEnsinoTO instituicaoEnsinoTO, @HeaderParam("token") String token) {
		validarToken(token);
		
		InstituicaoEnsino instituicaoEnsino = instituicaoEnsinoService.buscarPorId(id);
		if (instituicaoEnsino == null) {
			return notFound();
		}
		
		instituicaoEnsino.alterar(instituicaoEnsinoTO);
		instituicaoEnsino = instituicaoEnsinoService.salvar(instituicaoEnsino);
		return ok(instituicaoEnsino);
	}

	@DELETE()
	@Path("/instituicoes-ensino/{id}/")
	@Produces("application/json")
	public Response removerInstituicaoEnsino(@PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);

		InstituicaoEnsino instituicaoEnsino = instituicaoEnsinoService.buscarPorId(id);
		if (instituicaoEnsino == null) {
			return notFound();
		}
		
		instituicaoEnsinoService.excluir(instituicaoEnsino);
		return ok();
	}
	
	@GET()
	@Path("/areas-conhecimento/")
	@Produces("application/json")
	public Response listarAreaConhecimento(@HeaderParam("token") String token) {
		validarToken(token);
		List<AreaConhecimento> areasConhecimento = areaConhecimentoService.buscarTodos();
		return ok(areasConhecimento);
	}

	@GET()
	@Path("/areas-conhecimento/{id}/")
	@Produces("application/json")
	public Response obterAreaConhecimento(@PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);
		AreaConhecimento areaConhecimento = areaConhecimentoService.buscarPorId(id);
		return ok(areaConhecimento);
	}

	@POST()
	@Path("/areas-conhecimento/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response criarAreaConhecimento(AreaConhecimentoTO areaConhecimentoTO, @HeaderParam("token") String token) {
		validarToken(token);
		AreaConhecimento areaConhecimento = new AreaConhecimento(areaConhecimentoTO);
		areaConhecimento = areaConhecimentoService.salvar(areaConhecimento);
		return ok(areaConhecimento);
	}

	@PUT()
	@Path("/areas-conhecimento/{id}/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response alterarAreaConhecimento(@PathParam("id") Long id, AreaConhecimentoTO areaConhecimentoTO, @HeaderParam("token") String token) {
		validarToken(token);

		AreaConhecimento areaConhecimento = areaConhecimentoService.buscarPorId(id);
		if (areaConhecimento == null) {
			return notFound();
		}
		
		areaConhecimento.alterar(areaConhecimentoTO);
		areaConhecimento =  areaConhecimentoService.salvar(areaConhecimento);
		return ok(areaConhecimento);
	}

	@DELETE()
	@Path("/areas-conhecimento/{id}/")
	@Produces("application/json")
	public Response removerAreaConhecimento(@PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);
		
		AreaConhecimento areaConhecimento = areaConhecimentoService.buscarPorId(id);
		if (areaConhecimento == null) {
			return notFound();
		}
		
		areaConhecimentoService.excluir(areaConhecimento);
		return ok();
	}	

	@GET()
	@Path("/instituicoes-ensino/{id}/cursos/")
	@Produces("application/json")
	public Response listarCursosDaInstituicaoDeEnsino(@PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);
		List<Curso> cursos = cursoService.buscarCursosPorInstituicaoDeEnsino(id);
		return ok(cursos);
	}

	@GET()
	@Path("/pesquisas/cursos/nome/{nome}")
	@Produces("application/json")
	public Response pesquisarCursos(@PathParam("nome") String nome, @HeaderParam("token") String token) {
		validarToken(token);
		List<Curso> cursos = cursoService.buscarCursosPorNome(nome);
		return ok(cursos);
	}

	@GET()
	@Path("/instituicoes-ensino/{instituicaoEnsinoId}/cursos/{id}/")
	@Produces("application/json")
	public Response obterCurso(@PathParam("instituicaoEnsinoId") Long instituicaoEnsinoId, @PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);
		Curso curso = cursoService.buscarPorId(id);
		return ok(curso);
	}

	@POST()
	@Path("/instituicoes-ensino/{instituicaoEnsinoId}/cursos/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response adicionarCurso(@PathParam("instituicaoEnsinoId") Long instituicaoEnsinoId, CursoTO cursoTO, @HeaderParam("token") String token) {
		validarToken(token);
		Curso curso = new Curso(cursoTO);
		curso = cursoService.salvar(curso);
		return ok(curso);
	}

	@PUT()
	@Path("/instituicoes-ensino/{instituicaoEnsinoId}/cursos/{id}/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response alterarCurso(@PathParam("instituicaoEnsinoId") Long instituicaoEnsinoId, @PathParam("id") Long id, CursoTO cursoTO, @HeaderParam("token") String token) {
		validarToken(token);

		Curso curso = cursoService.buscarPorId(id);
		if (curso == null) {
			return notFound();
		}
		
		curso.alterar(cursoTO);
		cursoService.salvar(curso);
		return ok();
	}

	@DELETE()
	@Path("/instituicoes-ensino/{instituicaoEnsinoId}/cursos/{id}/")
	@Produces("application/json")
	public Response removerCurso(@PathParam("instituicaoEnsinoId") Long instituicaoEnsinoId, @PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);

		Curso curso = cursoService.buscarPorId(id);
		if (curso == null) {
			return notFound();
		}
		
		cursoService.excluir(curso);
		return ok();
	}

	@GET()
	@Path("/pessoas/{pessoaId}/formacoes/")
	@Produces("application/json")
	public Response listarFormacoesDaPessoa(@PathParam("pessoaId") Long pessoaId, @HeaderParam("token") String token) {
		validarToken(token);
		List<FormacaoAcademica> formacoesAcademicas = formacaoAcademicaService.buscarFormacoesAcademicasPorPessoa(pessoaId);
		return ok(formacoesAcademicas);
	}

	@POST()
	@Path("/pessoas/{pessoaId}/formacoes/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response adicionarFormacaoAPessoa(@PathParam("pessoaId") Long pessoaId, PessoaFormacaoTO pessoaFormacaoTO, @HeaderParam("token") String token) {
		validarToken(token);

		Pessoa pessoa = pessoaService.buscarPorId(pessoaId);
		if (pessoa == null) {
			return notFound();
		}
		
		pessoaFormacaoTO.setPessoa(pessoa);
		PessoaFormacao pessoaFormacao = new PessoaFormacao(pessoaFormacaoTO);
		pessoaFormacao = formacaoAcademicaService.salvarPessoaFormacao(pessoaFormacao);
		return ok(pessoaFormacao);
	}

	@PUT()
	@Path("/pessoas/{pessoaId}/formacoes/{id}/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response alterarFormacaoDaPessoa(@PathParam("pessoaId") Long pessoaId, @PathParam("id") Long id, PessoaFormacaoTO pessoaFormacaoTO, @HeaderParam("token") String token) {
		validarToken(token);
		Object o = funcionarioService.buscarPorId(id);
		return ok(o);
	}

	@DELETE()
	@Path("/pessoas/{pessoaId}/formacoes/{id}/")
	@Produces("application/json")
	public Response removerFormacaoDaPessoa(@PathParam("pessoaId") Long pessoaId, @PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);
		Object o = funcionarioService.buscarPorId(id);
		return ok(o);
	}

	@GET()
	@Path("/instituicoes-ensino/{id}/formacoes/")
	@Produces("application/json")
	public Response listarFormacoesAcademicas(@PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);
		List<FormacaoAcademica> formacoesAcademicas = formacaoAcademicaService.buscarFormacoesAcademicasPorInstituicaoDeEnsino(id);
		return ok(formacoesAcademicas);
	}

	@GET()
	@Path("/pesquisas/formacoes/descricao/{descricao}")
	@Produces("application/json")
	public Response pesquisarFormacoesAcademicas(@PathParam("descricao") String descricao, @HeaderParam("token") String token) {
		validarToken(token);
		List<FormacaoAcademica> formacoesAcademicas = formacaoAcademicaService.buscarFormacoesAcademicasPorDescricao(descricao);
		return ok(formacoesAcademicas);
	}

	@GET()
	@Path("/instituicoes-ensino/{instituicaoEnsinoId}/formacoes/{id}/")
	@Produces("application/json")
	public Response obterFormacaoAcademica(@PathParam("instituicaoEnsinoId") Long instituicaoEnsinoId, @PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);
		FormacaoAcademica formacaoAcademica = formacaoAcademicaService.buscarPorId(id);
		return ok(formacaoAcademica);
	}

	@POST()
	@Path("/instituicoes-ensino/{instituicaoEnsinoId}/formacoes/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response adicionarFormacaoAcademica(@PathParam("instituicaoEnsinoId") Long instituicaoEnsinoId, FormacaoAcademicaTO formacaoAcademicaTO, @HeaderParam("token") String token) {
		validarToken(token);
		FormacaoAcademica formacaoAcademica = new FormacaoAcademica(formacaoAcademicaTO);
		formacaoAcademica = formacaoAcademicaService.salvar(formacaoAcademica);
		return ok(formacaoAcademica);
	}

	@PUT()
	@Path("/instituicoes-ensino/{instituicaoEnsinoId}/formacoes/{id}/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response alterarFormacaoAcademica(@PathParam("instituicaoEnsinoId") Long instituicaoEnsinoId, @PathParam("id") Long id, FormacaoAcademicaTO formacaoAcademicaTO, @HeaderParam("token") String token) {
		validarToken(token);

		FormacaoAcademica formacaoAcademica = formacaoAcademicaService.buscarPorId(id);
		if (formacaoAcademica == null) {
			return notFound();
		}
		
		formacaoAcademica.alterar(formacaoAcademicaTO);
		formacaoAcademica = formacaoAcademicaService.salvar(formacaoAcademica);
		return ok(formacaoAcademica);
	}

	@DELETE()
	@Path("/instituicoes-ensino/{instituicaoEnsinoId}/formacoes/{id}/")
	@Produces("application/json")
	public Response removerFormacaoAcademica(@PathParam("instituicaoEnsinoId") Long instituicaoEnsinoId, @PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);

		FormacaoAcademica formacaoAcademica = formacaoAcademicaService.buscarPorId(id);
		if (formacaoAcademica == null) {
			return notFound();
		}
		
		formacaoAcademicaService.excluir(formacaoAcademica);
		return ok();
	}

	@GET()
	@Path("/pessoas/{pessoaId}/habilidades/")
	@Produces("application/json")
	public Response listarHabilidadesDaPessoa(@PathParam("pessoaId") Long pessoaId, @HeaderParam("token") String token) {
		validarToken(token);
		List<Habilidade> habilidades = habilidadeService.buscarHabilidadesPorPessoa(pessoaId);
		return ok(habilidades);
	}

	@POST()
	@Path("/pessoas/{pessoaId}/habilidades/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response adicionarHabilidadeAPessoa(@PathParam("pessoaId") Long pessoaId, HabilidadeTO habilidadeTO, @HeaderParam("token") String token) {
		validarToken(token);
	
		Pessoa pessoa = pessoaService.buscarPorId(pessoaId);
		if (pessoa == null) {
			return notFound();
		}
		
		PessoaHabilidade pessoaHabilidade = new PessoaHabilidade(habilidadeTO, pessoa);
		pessoaHabilidade = habilidadeService.salvarPessoaHabilidade(pessoaHabilidade);
		return ok(pessoaHabilidade);
	}

	@PUT()
	@Path("/pessoas/{pessoaId}/habilidades/{id}/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response alterarHabilidadeDaPessoa(@PathParam("pessoaId") Long pessoaId, @PathParam("id") Long id, HabilidadeTO habilidadeTO, @HeaderParam("token") String token) {
		validarToken(token);
		
		PessoaHabilidade pessoaHabilidade = habilidadeService.buscarPessoaHabilidadePorId(id);
		if (pessoaHabilidade == null) {
			return notFound();
		}
		
		pessoaHabilidade.alterar(pessoaHabilidade);
		pessoaHabilidade = habilidadeService.salvarPessoaHabilidade(pessoaHabilidade);
		return ok(pessoaHabilidade);
	}

	@DELETE()
	@Path("/pessoas/{pessoaId}/habilidades/{id}/")
	@Produces("application/json")
	public Response removerHabilidadeDaPessoa(@PathParam("pessoaId") Long pessoaId, @PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);

		PessoaHabilidade pessoaHabilidade = habilidadeService.buscarPessoaHabilidadePorId(id);
		if (pessoaHabilidade == null) {
			return notFound();
		}
		
		habilidadeService.excluirPessoaHabilidade(pessoaHabilidade);
		return ok();
	}

	@GET()
	@Path("/habilidades/")
	@Produces("application/json")
	public Response listarHabilidades(@HeaderParam("token") String token) {
		validarToken(token);
		List<Habilidade> habilidades = habilidadeService.buscarTodos();
		return ok(habilidades);
	}

	
	@GET()
	@Path("/pesquisas/habilidades/nome/{nome}")
	@Produces("application/json")
	public Response pesquisarHabilidades(@PathParam("nome") String nome, @HeaderParam("token") String token) {
		validarToken(token);
		List<Habilidade> habilidades = habilidadeService.buscarHabilidadesPorNome(nome);
		return ok(habilidades);
	}

	@GET()
	@Path("/habilidades/{id}/")
	@Produces("application/json")
	public Response obterHabilidade(@PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);
		Habilidade habilidade = habilidadeService.buscarPorId(id);
		return ok(habilidade);
	}

	@POST()
	@Path("/habilidades/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response adicionarHabilidade(HabilidadeTO habilidadeTO, @HeaderParam("token") String token) {
		validarToken(token);
		Object o = null;//funcionarioService.buscarPorId(id);
		return ok(o);
	}

	@PUT()
	@Path("/habilidades/{id}/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response alterarHabilidade(@PathParam("id") Long id, HabilidadeTO habilidadeTO, @HeaderParam("token") String token) {
		validarToken(token);
		Object o = funcionarioService.buscarPorId(id);
		return ok(o);
	}

	@DELETE()
	@Path("/habilidades/{id}/")
	@Produces("application/json")
	public Response removerHabilidade(@PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);
		Object o = funcionarioService.buscarPorId(id);
		return ok(o);
	}

	@GET()
	@Path("/pessoas/{pessoaId}/enderecos/")
	@Produces("application/json")
	public Response listarEnderecosDaPessoa(@PathParam("pessoaId") Long pessoaId, @HeaderParam("token") String token) {
		validarToken(token);
		List<Endereco> enderecos = enderecoService.buscarEnderecosPorPessoa(pessoaId);
		return ok(enderecos);
	}

	@POST()
	@Path("/pessoas/{pessoaId}/enderecos/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response adicionarEnderecoAPessoa(@PathParam("pessoaId") Long pessoaId, PessoaEnderecoTO pessoaEnderecoTO, @HeaderParam("token") String token) {
		validarToken(token);
		
		final Pessoa pessoa = pessoaService.buscarPorId(pessoaId);
		if (pessoa == null) {
			return notFound();
		}
		
		PessoaEndereco pessoaEndereco = new PessoaEndereco(pessoaEnderecoTO);
		enderecoService.salvarPessoaEndereco(pessoaEndereco);
		return ok(pessoaEndereco);
	}

	@PUT()
	@Path("/pessoas/{pessoaId}/enderecos/{id}/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response alterarEnderecoDaPessoa(@PathParam("pessoaId") Long pessoaId, @PathParam("id") Long id, PessoaEnderecoTO pessoaEnderecoTO, @HeaderParam("token") String token) {
		validarToken(token);
		
		PessoaEndereco pessoaEndereco = enderecoService.buscarPessoaEnderecoPorId(id);
		final Pessoa pessoa = pessoaService.buscarPorId(pessoaId);
		if (pessoaEndereco == null || pessoa == null) {
			return notFound();
		}
		
		pessoaEndereco.alterar(pessoaEnderecoTO);
		enderecoService.salvarPessoaEndereco(pessoaEndereco);
		return ok(pessoaEndereco);
	}

	@DELETE()
	@Path("/pessoas/{pessoaId}/enderecos/{id}/")
	@Produces("application/json")
	public Response removerEnderecoDaPessoa(@PathParam("pessoaId") Long pessoaId, @PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);
		
		Documento documento = documentoService.buscarPorId(id);
		if (documento == null) {
			return notFound();
		}
		
		documentoService.excluir(documento);
		return ok();
	}

	@GET()
	@Path("/enderecos/")
	@Produces("application/json")
	public Response listarEnderecos(@HeaderParam("token") String token) {
		validarToken(token);
		List<Endereco> enderecos = enderecoService.buscarTodos();
		return ok(enderecos);
	}

	@GET()
	@Path("/pesquisas/enderecos/descricao/{descricao}")
	@Produces("application/json")
	public Response pesquisarEnderecos(@PathParam("descricao") String descricao, @HeaderParam("token") String token) {
		validarToken(token);
		List<Endereco> enderecos = enderecoService.buscarEnderecoPorDescricao(descricao);
		return ok(enderecos);
	}

	@GET()
	@Path("/enderecos/{id}/")
	@Produces("application/json")
	public Response obterEndereco(@PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);
		Endereco endereco = enderecoService.buscarPorId(id);
		return ok(endereco);
	}

	@POST()
	@Path("/enderecos/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response adicionarEndereco(EnderecoTO enderecoTO, @HeaderParam("token") String token) {
		validarToken(token);
		Endereco endereco = new Endereco(enderecoTO);
		endereco = enderecoService.salvar(endereco);
		return ok(endereco);
	}

	@PUT()
	@Path("/enderecos/{id}/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response alterarEndereco(@PathParam("id") Long id, EnderecoTO enderecoTO, @HeaderParam("token") String token) {
		validarToken(token);

		Endereco endereco = enderecoService.buscarPorId(id);
		if (endereco == null) {
			return notFound();
		}
		
		endereco.alterar(enderecoTO);
		endereco = enderecoService.salvar(endereco);
		return ok(endereco);
	}

	@DELETE()
	@Path("/enderecos/{id}/")
	@Produces("application/json")
	public Response removerEndereco(@PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);
		
		Endereco endereco = enderecoService.buscarPorId(id);
		if (endereco == null) {
			return notFound();
		}
		
		enderecoService.excluir(endereco);
		return ok();
	}
	
	@POST()
	@Path("/logradouros/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response adicionarLogradouro(LogradouroTO logradouroTO, @HeaderParam("token") String token) {
		validarToken(token);
		Logradouro logradouro = new Logradouro(logradouroTO);
		logradouro = logradouroService.salvar(logradouro);
		return ok(logradouro);
	}

	@POST()
	@Path("/bairros/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response adicionarBairro(BairroTO bairroTO, @HeaderParam("token") String token) {
		validarToken(token);
		Bairro bairro = new Bairro(bairroTO);
		bairro = bairroService.salvar(bairro);
		return ok(bairro);
	}
	

	@GET()
	@Path("/localidades/")
	@Produces("application/json")
	public Response listarLocalidades(@HeaderParam("token") String token) {
		validarToken(token);
		List<Localidade> localidades = localidadeService.buscarTodos();
		return ok(localidades);
	}

	@GET()
	@Path("/pesquisas/localidades/nome/{nome}")
	@Produces("application/json")
	public Response pesquisarLocalidades(@PathParam("nome") String nome, @HeaderParam("token") String token) {
		validarToken(token);
		List<Localidade> localidades = localidadeService.buscarPorNome(nome);
		return ok(localidades);
	}

	@GET()
	@Path("/localidades/{id}/")
	@Produces("application/json")
	public Response obterLocalidade(@PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);
		Localidade localidade = localidadeService.buscarPorId(id);
		return ok(localidade);
	}

	@POST()
	@Path("/localidades/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response adicionarLocalidade(LocalidadeTO localidadeTO, @HeaderParam("token") String token) {
		validarToken(token);
		Localidade localidade = new Localidade(localidadeTO);
		localidade = localidadeService.salvar(localidade);
		return ok(localidade);
	}

	@PUT()
	@Path("/localidades/{id}/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response alterarLocalidade(@PathParam("id") Long id, LocalidadeTO localidadeTO, @HeaderParam("token") String token) {
		validarToken(token);

		Localidade localidade = localidadeService.buscarPorId(id);
		if (localidade == null) {
			return notFound();
		}
		
		localidade.alterar(localidadeTO);
		localidade = localidadeService.salvar(localidade);
		return ok(localidade);
	}

	@DELETE()
	@Path("/localidades/{id}/")
	@Produces("application/json")
	public Response removerLocalidade(@PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);

		Localidade localidade = localidadeService.buscarPorId(id);
		if (localidade == null) {
			return notFound();
		}
		
		localidadeService.excluir(localidade);
		return ok();
	}

	@GET()
	@Path("/estados/{id}/cidades/")
	@Produces("application/json")
	public Response listarCidadesDoEstado(@PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);
		List<Cidade> cidades = cidadeService.buscarPorEstado(id);
		return ok(cidades);
	}

	@GET()
	@Path("/pesquisas/cidades/nome/{nome}")
	@Produces("application/json")
	public Response pesquisarCidades(@PathParam("nome") String nome, @HeaderParam("token") String token) {
		validarToken(token);
		List<Cidade> cidades = cidadeService.buscarPorNome(nome);
		return ok(cidades);
	}

	@GET()
	@Path("/estados/{estadoId}/cidades/{id}/")
	@Produces("application/json")
	public Response obterCidade(@PathParam("estadoId") Long estadoId, @PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);
		Cidade cidade = cidadeService.buscarPorId(id);
		return ok(cidade);
	}

	@POST()
	@Path("/estados/{estadoId}/cidades/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response adicionarCidade(@PathParam("estadoId") Long estadoId, CidadeTO cidadeTO, @HeaderParam("token") String token) {
		validarToken(token);
		Cidade cidade = new Cidade(cidadeTO);
		cidade = cidadeService.salvar(cidade);
		return ok(cidade);
	}

	@PUT()
	@Path("/estados/{estadoId}/cidades/{id}/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response alterarCidade(@PathParam("estadoId") Long estadoId, @PathParam("id") Long id, CidadeTO cidadeTO, @HeaderParam("token") String token) {
		validarToken(token);

		Cidade cidade = cidadeService.buscarPorId(id);
		if (cidade == null) {
			return notFound();
		}
		
		cidade.alterar(cidadeTO);
		cidade = cidadeService.salvar(cidade);
		return ok(cidade);
	}

	@DELETE()
	@Path("/estados/{estadoId}/cidades/{id}/")
	@Produces("application/json")
	public Response removerCidade(@PathParam("estadoId") Long estadoId, @PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);
		
		Cidade cidade = cidadeService.buscarPorId(id);
		if (cidade == null) {
			return notFound();
		}
		
		cidadeService.excluir(cidade);
		return ok();
	}

	@GET()
	@Path("/estados/")
	@Produces("application/json")
	public Response listarEstados(@HeaderParam("token") String token) {
		validarToken(token);
		List<Estado> estados = estadoService.buscarTodos();
		return ok(estados);
	}

	@GET()
	@Path("/pesquisas/estados/nome/{nome}")
	@Produces("application/json")
	public Response pesquisarEstados(@PathParam("nome") String nome, @HeaderParam("token") String token) {
		validarToken(token);
		List<Estado> estados = estadoService.buscarPorNome(nome);
		return ok(estados);
	}

	@GET()
	@Path("/estados/{id}/")
	@Produces("application/json")
	public Response obterEstado(@PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);
		Estado estado = estadoService.buscarPorId(id);
		return ok(estado);
	}

	@POST()
	@Path("/estados/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response adicionarEstado(EstadoTO estadoTO, @HeaderParam("token") String token) {
		validarToken(token);
		Estado estado = new Estado(estadoTO);
		estado = estadoService.salvar(estado);
		return ok(estado);
	}

	@PUT()
	@Path("/estados/{id}/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response alterarEstado(@PathParam("id") Long id, EstadoTO estadoTO, @HeaderParam("token") String token) {
		validarToken(token);

		Estado estado = estadoService.buscarPorId(id);
		if (estado == null) {
			return notFound();
		}
		
		estado.alterar(estadoTO);
		estado = estadoService.salvar(estado);
		return ok(estado);
	}

	@DELETE()
	@Path("/estados/{id}/")
	@Produces("application/json")
	public Response removerEstado(@PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);

		Estado estado = estadoService.buscarPorId(id);
		if (estado == null) {
			return notFound();
		}
		
		estadoService.excluir(estado);
		return ok();
	}

	@GET()
	@Path("/regioes/")
	@Produces("application/json")
	public Response listarRegioes(@HeaderParam("token") String token) {
		validarToken(token);
        List<Regiao> regioes = regiaoService.buscarTodos();
		return ok(regioes);
	}

	@GET()
	@Path("/pesquisas/regioes/nome/{nome}")
	@Produces("application/json")
	public Response pesquisarRegioes(@PathParam("nome") String nome, @HeaderParam("token") String token) {
		validarToken(token);
		List<Regiao> regioes = regiaoService.buscarPorNome(nome);
		return ok(regioes);
	}

	@GET()
	@Path("/regioes/{id}/")
	@Produces("application/json")
	public Response obterRegiao(@PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);
		Regiao regiao = regiaoService.buscarPorId(id);
		return ok(regiao);
	}

	@POST()
	@Path("/regioes/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response adicionarRegiao(RegiaoTO regiaoTO, @HeaderParam("token") String token) {
		validarToken(token);
		Regiao regiao = new Regiao(regiaoTO);
		regiao = regiaoService.salvar(regiao);
		return ok(regiao);
	}

	@PUT()
	@Path("/regioes/{id}/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response alterarRegiao(@PathParam("id") Long id, RegiaoTO regiaoTO, @HeaderParam("token") String token) {
		validarToken(token);
		
		Regiao regiao = regiaoService.buscarPorId(id);
		if (regiao == null) {
			return notFound();
		}
		
		regiao.alterar(regiaoTO);
		regiao = regiaoService.salvar(regiao);
		return ok(regiao);
	}

	@DELETE()
	@Path("/regioes/{id}/")
	@Produces("application/json")
	public Response removerRegiao(@PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);

		Regiao regiao = regiaoService.buscarPorId(id);
		if (regiao == null) {
			return notFound();
		}
		
		regiaoService.excluir(regiao);
		return ok();
	}

	@GET()
	@Path("/paises/")
	@Produces("application/json")
	public Response listarPaises(@HeaderParam("token") String token) {
		validarToken(token);
		List<Pais> paises = paisService.buscarTodos();
		return ok(paises);
	}

	@GET()
	@Path("/pesquisas/paises/nome/{nome}")
	@Produces("application/json")
	public Response pesquisarPaises(@PathParam("nome") String nome, @HeaderParam("token") String token) {
		validarToken(token);
		List<Pais> paises = paisService.buscarPorNome(nome);
		return ok(paises);
	}

	@GET()
	@Path("/paises/{id}/")
	@Produces("application/json")
	public Response obterPais(@PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);
		Pais pais = paisService.buscarPorId(id);
		return ok(pais);
	}

	@POST()
	@Path("/paises/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response adicionarPais(PaisTO paisTO, @HeaderParam("token") String token) {
		Pais pais = new Pais(paisTO);
		pais = paisService.salvar(pais);
		return ok(pais);
	}

	@PUT()
	@Path("/paises/{id}/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response alterarPais(@PathParam("id") Long id, PaisTO paisTO, @HeaderParam("token") String token) {
		validarToken(token);

		Pais pais = paisService.buscarPorId(id);
		if (pais == null) {
			return notFound();
		}
		
		pais.alterar(paisTO);
		pais = paisService.salvar(pais);
		return ok(pais);
	}

	@DELETE()
	@Path("/paises/{id}/")
	@Produces("application/json")
	public Response removerPais(@PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);
		
		Pais pais = paisService.buscarPorId(id);
		if (pais == null) {
			return notFound();
		}
		
		paisService.excluir(pais);
		return ok();
	}

	@GET()
	@Path("/pessoas/{pessoaId}/veiculos/")
	@Produces("application/json")
	public Response listarVeiculosDaPessoa(@PathParam("pessoaId") Long pessoaId, @HeaderParam("token") String token) {
		validarToken(token);
		List<Veiculo> veiculos = veiculoService.buscarVeiculosPorPessoa(pessoaId);
		return ok(veiculos);
	}

	@GET()
	@Path("/pessoas/{pessoaId}/veiculos/{id}/")
	@Produces("application/json")
	public Response obterVeiculoDaPessoa(@PathParam("pessoaId") Long pessoaId, @PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);
		Veiculo veiculo = veiculoService.buscarPorId(id);
		return ok(veiculo);
	}

	@POST()
	@Path("/pessoas/{pessoaId}/veiculos/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response adicionarVeiculoAPessoa(@PathParam("pessoaId") Long pessoaId, VeiculoTO veiculoTO, @HeaderParam("token") String token) {
		validarToken(token);
		
		final Pessoa pessoa = pessoaService.buscarPorId(veiculoTO.getPessoaId());
		if (pessoa == null) {
			return notFound();
		}
		
		veiculoTO.setPessoa(pessoa);
		
		Veiculo veiculo = new Veiculo(veiculoTO);
		veiculoService.salvar(veiculo);
		return ok(veiculo);
	}

	@PUT()
	@Path("/pessoas/{pessoaId}/veiculos/{id}/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response alterarVeiculoDaPessoa(@PathParam("pessoaId") Long pessoaId, @PathParam("id") Long id, VeiculoTO veiculoTO, @HeaderParam("token") String token) {
		validarToken(token);
		
		Veiculo veiculo = veiculoService.buscarPorId(id);
		if(veiculo == null) {
			return notFound();
		}
		
		veiculo.alterar(veiculoTO);
		veiculo = veiculoService.salvar(veiculo);
		return ok(veiculo);
	}

	@DELETE()
	@Path("/pessoas/{pessoaId}/veiculos/{id}/")
	@Produces("application/json")
	public Response removerVeiculoDaPessoa(@PathParam("pessoaId") Long pessoaId, @PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);
		
		Veiculo veiculo = veiculoService.buscarPorId(id);
		if (veiculo == null) {
			return notFound();
		}
		
		veiculoService.excluir(veiculo);
		return ok();
	}

	@GET()
	@Path("/pessoas/{pessoaId}/declaracoes-bens/")
	@Produces("application/json")
	public Response listarDeclaracaoBensDaPessoa(@PathParam("pessoaId") Long pessoaId, @HeaderParam("token") String token) {
		validarToken(token);
		List<DeclaracaoBens> declaracoesBens = declaracaoBensService.buscarDeclaracoesBensPorPessoa(pessoaId);
		return ok(declaracoesBens);
	}

	@GET()
	@Path("/pessoas/{pessoaId}/declaracoes-bens/{id}/")
	@Produces("application/json")
	public Response obterDeclaracaoBensDaPessoa(@PathParam("pessoaId") Long pessoaId, @PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);
		DeclaracaoBens declaracaoBens = declaracaoBensService.buscarPorId(pessoaId);
		return ok(declaracaoBens);
	}

	@POST()
	@Path("/pessoas/{pessoaId}/declaracoes-bens/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response adicionarDeclaracaoBensAPessoa(@PathParam("pessoaId") Long pessoaId, DeclaracaoBensTO declaracaoBensTO, @HeaderParam("token") String token) {
		validarToken(token);
		
		final Pessoa pessoa = pessoaService.buscarPorId(declaracaoBensTO.getPessoaId());
		if (pessoa == null) {
			return notFound();
		}
		
		declaracaoBensTO.setPessoa(pessoa);
		
		DeclaracaoBens declaracaoBens = new DeclaracaoBens(declaracaoBensTO);
		declaracaoBensService.salvar(declaracaoBens);
		return ok(declaracaoBens);
	}

	@PUT()
	@Path("/pessoas/{pessoaId}/declaracoes-bens/{id}/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response alterarDeclaracaoBensDaPessoa(@PathParam("pessoaId") Long pessoaId, @PathParam("id") Long id, DeclaracaoBensTO declaracaoBensTO, @HeaderParam("token") String token) {
		validarToken(token);
		Object o = funcionarioService.buscarPorId(id);
		return ok(o);
	}

	@DELETE()
	@Path("/pessoas/{pessoaId}/declaracoes-bens/{id}/")
	@Produces("application/json")
	public Response removerDeclaracaoBensDaPessoa(@PathParam("pessoaId") Long pessoaId, @PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);
		
		DeclaracaoBens declaracaoBens = declaracaoBensService.buscarPorId(pessoaId);
		if (declaracaoBens == null) {
			return notFound();
		}
		
		declaracaoBensService.excluir(declaracaoBens);
		return ok();
	}
	
	@GET()
	@Path("/bancos/")
	@Produces("application/json")
	public Response listarBancos(@HeaderParam("token") String token) {
		validarToken(token);
		List<Banco> bancos = bancoService.buscarTodos();
		return ok(bancos);
	}

	@GET()
	@Path("/pesquisas/bancos/nome/{nome}")
	@Produces("application/json")
	public Response pesquisarBancos(@PathParam("nome") String nome, @HeaderParam("token") String token) {
		validarToken(token);
		List<Banco> bancos = bancoService.buscarBancosPorNome(nome);
		return ok(bancos);
	}

	@GET()
	@Path("/bancos/{id}/")
	@Produces("application/json")
	public Response obterBanco(@PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);
		Banco banco = bancoService.buscarPorId(id);
		return ok(banco);
	}

	@POST()
	@Path("/bancos/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response adicionarBanco(BancoTO bancoTO, @HeaderParam("token") String token) {
		validarToken(token);
		Banco banco = new Banco(bancoTO);
		banco = bancoService.salvar(banco);
		return created(banco);
	}

	@PUT()
	@Path("/bancos/{id}/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response alterarBanco(@PathParam("id") Long id, BancoTO bancoTO, @HeaderParam("token") String token) {
		validarToken(token);
		
		Banco banco = bancoService.buscarPorId(id);
		if (banco == null) {
			return notFound();
		}
		
		banco.alterar(bancoTO);
		bancoService.salvar(banco);
		return ok(banco);
	}

	@DELETE()
	@Path("/bancos/{id}/")
	@Produces("application/json")
	public Response removerBanco(@PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);
		
		Banco banco = bancoService.buscarPorId(id);
		if (banco == null) {
			return notFound();
		}
		
		bancoService.excluir(banco);
		return ok();
	}
	
	@GET()
	@Path("/bancos/{bancoId}/agencias/")
	@Produces("application/json")
	public Response listarAgenciasBancarias(@PathParam("bancoId") Long bancoId, @HeaderParam("token") String token) {
		validarToken(token);
		List<AgenciaBancaria> agencias = bancoService.listarAgencias(bancoId);
		return ok(agencias);
	}

	@GET()
	@Path("/pesquisas/bancos/{bancoId}/agencias/{nome}")
	@Produces("application/json")
	public Response pesquisarAgenciasBancarias(@PathParam("bancoId") Long bancoId, @PathParam("nome") String nome, @HeaderParam("token") String token) {
		validarToken(token);
		List<AgenciaBancaria> agencias = bancoService.buscarAgenciasPorBancoENome(bancoId, nome);
		return ok(agencias);
	}

	@GET()
	@Path("/bancos/{bancoId}/agencias/{id}/")
	@Produces("application/json")
	public Response obterAgenciaBancaria(@PathParam("bancoId") Long bancoId, @PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);
		AgenciaBancaria agenciaBancaria = bancoService.buscarAgenciaBancariaPorId(id);
		return ok(agenciaBancaria);
	}

	@POST()
	@Path("/agencias/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response adicionarAgenciaBancaria(AgenciaBancariaTO agenciaBancariaTO, @HeaderParam("token") String token) {
		validarToken(token);
		AgenciaBancaria agenciaBancaria = new AgenciaBancaria(agenciaBancariaTO);
		agenciaBancaria = bancoService.salvarAgenciaBancaria(agenciaBancaria);
		return created(agenciaBancaria);
	}

	@PUT()
	@Path("/bancos/{bancoId}/agencias/{id}/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response alterarAgenciaBancaria(@PathParam("bancoId") Long bancoId, @PathParam("id") Long id, AgenciaBancariaTO agenciaBancariaTO, @HeaderParam("token") String token) {
		validarToken(token);

		AgenciaBancaria agenciaBancaria = bancoService.buscarAgenciaBancariaPorId(id);
		if (agenciaBancaria == null) {
			return notFound();
		}
		
		agenciaBancaria.alterar(agenciaBancariaTO);
		agenciaBancaria = bancoService.salvarAgenciaBancaria(agenciaBancaria);
		return ok(agenciaBancaria);
	}

	@DELETE()
	@Path("/bancos/{bancoId}/agencias/{id}/")
	@Produces("application/json")
	public Response removerAgenciaBancaria(@PathParam("bancoId") Long bancoId, @PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);

		AgenciaBancaria agenciaBancaria = bancoService.buscarAgenciaBancariaPorId(id);
		if (agenciaBancaria == null) {
			return notFound();
		}
		
		bancoService.excluirAgenciaBancaria(agenciaBancaria);
		return ok();
	}
	
	@GET()
	@Path("/bancos/{bancoId}/agencias/{agenciaId}/contas/")
	@Produces("application/json")
	public Response listarContasCorrentes(@PathParam("bancoId") Long bancoId, @PathParam("agenciaId") Long agenciaId, @HeaderParam("token") String token) {
		validarToken(token);
		List<ContaCorrente> contasCorrente = contaCorrenteService.buscarContasCorrentePorAgencia(agenciaId);
		return ok(contasCorrente);
	}

	@GET()
	@Path("/pesquisas/bancos/{bancoId}/contas/{numero}")
	@Produces("application/json")
	public Response pesquisarContasCorrentes(@PathParam("bancoId") Long bancoId, @PathParam("numero") String numero, @HeaderParam("token") String token) {
		validarToken(token);
		List<ContaCorrente> contasCorrente = contaCorrenteService.buscarContasCorrentePorNumero(numero);
		return ok(contasCorrente);
	}

	@GET()
	@Path("/bancos/{bancoId}/agencias/{agenciaId}/contas/{id}/")
	@Produces("application/json")
	public Response obterContaCorrente(@PathParam("bancoId") Long bancoId, @PathParam("agenciaId") Long agenciaId, @PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);
		ContaCorrente contaCorrente = contaCorrenteService.buscarPorId(id);
		return ok(contaCorrente);
	}

	@POST()
	@Path("/bancos/{bancoId}/agencias/{agenciaId}/contas/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response adicionarContaCorrente(@PathParam("bancoId") Long bancoId, @PathParam("agenciaId") Long agenciaId, 
			ContaCorrenteTO contaCorrenteTO, @HeaderParam("token") String token) {
		validarToken(token);
		
		Banco banco = bancoService.buscarPorId(bancoId);
		AgenciaBancaria agencia = bancoService.buscarAgenciaBancariaPorId(agenciaId);
		
		if (banco == null) {
			return notFound("Banco não encontrado!");
		}
		
		if (agencia == null) {
			return notFound("Agência bancária não encontrada!");
		}

		if (contaCorrenteTO.getAgenciaId() == null) {
			contaCorrenteTO.setAgenciaId(agenciaId);
		} else {
			if (!contaCorrenteTO.getAgenciaId().equals(agenciaId)) {
				return internalServerError("Identificador da agência bancária inválido!");	
			}
		}
		
		ContaCorrente contaCorrente = new ContaCorrente(contaCorrenteTO);
		try {
			contaCorrente = contaCorrenteService.salvar(contaCorrente);
			return created(contaCorrente);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return internalServerError("Falha ao adicionar conta corrente: "+e.getMessage());			
		}
	}

	@PUT()
	@Path("/bancos/{bancoId}/agencias/{agenciaId}/contas/{id}/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response alterarContaCorrente(@PathParam("bancoId") Long bancoId, @PathParam("agenciaId") Long agenciaId, @PathParam("id") Long id, 
			ContaCorrenteTO contaCorrenteTO, @HeaderParam("token") String token) {
		validarToken(token);
		ContaCorrente contaCorrente = contaCorrenteService.buscarPorId(id);
		contaCorrente.alterar(contaCorrenteTO);
		contaCorrenteService.salvar(contaCorrente);
		return ok(contaCorrente);
	}

	@DELETE()
	@Path("/bancos/{bancoId}/agencias/{agenciaId}/contas/{id}/")
	@Produces("application/json")
	public Response removerContaCorrente(@PathParam("bancoId") Long bancoId, @PathParam("agenciaId") Long agenciaId, @PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);
		
		ContaCorrente contaCorrente = contaCorrenteService.buscarPorId(id);
		if (contaCorrente == null) {
			return notFound();
		}
		
		contaCorrenteService.excluir(contaCorrente);
		return ok();
	}

	@GET()
	@Path("/pessoas/{pessoaId}/contas-recebimento/")
	@Produces("application/json")
	public Response listarContasRecebimentoDaPessoa(@PathParam("pessoaId") Long pessoaId, @HeaderParam("token") String token) {
		validarToken(token);
		List<ContaRecebimento> contasRecebimento = contaRecebimentoService.buscarContasRecebimentoPorPessoa(pessoaId);
		return ok(contasRecebimento);
	}

	@GET()
	@Path("/pessoas/{pessoaId}/contas-recebimento/{id}/")
	@Produces("application/json")
	public Response obterContaRecebimento(@PathParam("pessoaId") Long pessoaId, @PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);
		ContaRecebimento contaRecebimento = contaRecebimentoService.buscarPorId(id);
		return ok(contaRecebimento);
	}

	@POST()
	@Path("/pessoas/{pessoaId}/contas-recebimento/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response adicionarContaRecebimento(@PathParam("pessoaId") Long pessoaId, ContaRecebimentoTO contaRecebimentoTO, @HeaderParam("token") String token) {
		validarToken(token);
		
		final Pessoa pessoa = pessoaService.buscarPorId(pessoaId);
		if (pessoa == null) {
			return notFound();
		}
		
		if (contaRecebimentoTO.getPessoaId() == null) {
			contaRecebimentoTO.setPessoaId(pessoaId);
		}
		
		if (!contaRecebimentoTO.getPessoaId().equals(pessoaId)) {
			return internalServerError("Identificador de pessoa inválido!");
		}
		
		ContaRecebimento contaRecebimento = new ContaRecebimento(contaRecebimentoTO);
		
		try {
			contaRecebimento = contaRecebimentoService.salvar(contaRecebimento);
			return created(contaRecebimento);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return internalServerError("Falha ao adicionar conta de recebimento: "+e.getMessage());
		}
		
	}

	@PUT()
	@Path("/pessoas/{pessoaId}/contas-recebimento/{contaRecebimentoId}/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response alterarContaRecebimento(@PathParam("pessoaId") Long pessoaId, @PathParam("contaRecebimentoId") Long contaRecebimentoId, 
			ContaRecebimentoTO contaRecebimentoTO, @HeaderParam("token") String token) {
		validarToken(token);

		ContaRecebimento contaRecebimento = contaRecebimentoService.buscarPorId(contaRecebimentoId);
		if (contaRecebimento == null) {
			return notFound();
		}
		
		contaRecebimento.alterar(contaRecebimentoTO);
		contaRecebimento = contaRecebimentoService.salvar(contaRecebimento);
		return ok(contaRecebimento);
	}

	@DELETE()
	@Path("/pessoas/{pessoaId}/contas-recebimento/{contaRecebimentoId}/")
	@Produces("application/json")
	public Response removerContaRecebimento(@PathParam("pessoaId") Long pessoaId, @PathParam("contaRecebimentoId") Long contaRecebimentoId, @HeaderParam("token") String token) {
		validarToken(token);
		
		ContaRecebimento contaRecebimento = contaRecebimentoService.buscarPorId(contaRecebimentoId);
		if (contaRecebimento == null) {
			return notFound();
		}
		
		contaRecebimentoService.excluir(contaRecebimento);
		return ok();
	}

}