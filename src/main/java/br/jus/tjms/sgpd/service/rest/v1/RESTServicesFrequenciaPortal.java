package br.jus.tjms.sgpd.service.rest.v1;

import br.jus.tjms.sgpd.entity.*;
import br.jus.tjms.sgpd.service.ServicesPortal;
import br.jus.tjms.sgpd.service.frequenciaservices.*;
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
public class RESTServicesFrequenciaPortal extends RESTServicesBasePortalV1 implements ServicesPortal {

	private static final long serialVersionUID = -2648701591975362476L;
    private static Logger logger = LoggerFactory.getLogger(RESTServicesFrequenciaPortal.class);
	
	@EJB
	private FuncionarioService funcionarioService;
	
	@EJB
	private FrequenciaApuracaoDiaOcorrenciaService frequenciaApuracaoDiaOcorrenciaService;
	
	@EJB
	private FrequenciaApuracaoDiaCargaHorariaService frequenciaApuracaoDiaCargaHorariaService;
	
	@EJB
	private FrequenciaApuracaoDiaService frequenciaApuracaoDiaService;
	
	@EJB
	private FrequenciaApuracaoMesService frequenciaApuracaoMesService;
	
	@EJB
	private RegistroFrequenciaService registroFrequenciaService;
	
	@EJB
	private ApuracaoHorasService apuracaoHorasService;
	

	/*
	 * 
	 * FrequenciaApuracaoMes:
	 * 
	 * listarFrequenciaApuracaoMes							GET		/funcionarios/1/frequencia-apuracao-mes/
	 * pesquisarFrequenciaApuracaoMesPorAnoMes				GET		/pesquisas/funcionarios/1/frequencia-apuracao-mes/ano/mes/
	 * obterFrequenciaApuracaoMes							GET		/funcionarios/1/frequencia-apuracao-mes/1
	 * criarFrequenciaApuracaoMes							POST	/funcionarios/1/frequencia-apuracao-mes/...
	 * alterarFrequenciaApuracaoMes							PUT		/funcionarios/1/frequencia-apuracao-mes/1/...
	 * removerFrequenciaApuracaoMes							DELETE	/funcionarios/1/frequencia-apuracao-mes/1
	 * 
	 * FrequenciaApuracaoDia:
	 * 
	 * listarFrequenciaApuracaoDia							GET		/funcionarios/1/frequencia-apuracao-mes/1/frequencia-apuracao-dia/
	 * obterFrequenciaApuracaoDia							GET		/funcionarios/1/frequencia-apuracao-mes/1/frequencia-apuracao-dia/1
	 * criarFrequenciaApuracaoDia							POST	/funcionarios/1/frequencia-apuracao-mes/1/frequencia-apuracao-dia/...
	 * alterarFrequenciaApuracaoDia							PUT		/funcionarios/1/frequencia-apuracao-mes/1/frequencia-apuracao-dia/1/...
	 * removerFrequenciaApuracaoDia							DELETE	/funcionarios/1/frequencia-apuracao-mes/1/frequencia-apuracao-dia/1
	 * 
	 * FrequenciaApuracaoDiaOcorrencia:
	 * 
	 * listarFrequenciaApuracaoDiaOcorrencia				GET		/funcionarios/1/frequencia-apuracao-mes/1/frequencia-apuracao-dia/1/ocorrencias/
	 * obterFrequenciaApuracaoDiaOcorrencia					GET		/funcionarios/1/frequencia-apuracao-mes/1/frequencia-apuracao-dia/1/ocorrencias/1
	 * criarFrequenciaApuracaoDiaOcorrencia					POST	/funcionarios/1/frequencia-apuracao-mes/1/frequencia-apuracao-dia/1/ocorrencias/...
	 * alterarFrequenciaApuracaoDiaOcorrencia				PUT		/funcionarios/1/frequencia-apuracao-mes/1/frequencia-apuracao-dia/1/ocorrencias/1/...
	 * removerFrequenciaApuracaoDiaOcorrencia				DELETE	/funcionarios/1/frequencia-apuracao-mes/1/frequencia-apuracao-dia/1/ocorrencias/1
	 * 
	 * FrequenciaApuracaoDiaCargaHoraria:
	 * 
	 * listarFrequenciaApuracaoDiaCargaHoraria				GET		/funcionarios/1/frequencia-apuracao-mes/1/frequencia-apuracao-dia/1/carga-horaria/
	 * obterFrequenciaApuracaoDiaCargaHoraria				GET		/funcionarios/1/frequencia-apuracao-mes/1/frequencia-apuracao-dia/1/carga-horaria/1
	 * criarFrequenciaApuracaoDiaCargaHoraria				POST	/funcionarios/1/frequencia-apuracao-mes/1/frequencia-apuracao-dia/1/carga-horaria/...
	 * alterarFrequenciaApuracaoDiaCargaHoraria				PUT		/funcionarios/1/frequencia-apuracao-mes/1/frequencia-apuracao-dia/1/carga-horaria/1/...
	 * removerFrequenciaApuracaoDiaCargaHoraria				DELETE	/funcionarios/1/frequencia-apuracao-mes/1/frequencia-apuracao-dia/1/carga-horaria/1
	 * 
	 * RegistroFrequencia:
	 * 
	 * listarRegistroFrequencia								GET		/funcionarios/1/registro-frequencia/
	 * pesquisarRegistroFrequenciaPorAnoMes					GET		/pesquisas/funcionarios/1/registro-frequencia/ano/mes/
	 * obterRegistroFrequencia								GET		/funcionarios/1/registro-frequencia/1
	 * criarRegistroFrequencia								POST	/funcionarios/1/registro-frequencia/...
	 * alterarRegistroFrequencia							PUT		/funcionarios/1/registro-frequencia/1/...
	 * removerRegistroFrequencia							DELETE	/funcionarios/1/registro-frequencia/1 
	 *  
	 */
	
	@GET()
	@Path("/funcionarios/{funcionarioId}/frequencia-apuracao-mes/")
	@Produces("application/json")
	public Response listarFrequenciaApuracaoMes(@PathParam("funcionarioId") Long funcionarioId, @HeaderParam("token") String token) {
		validarToken(token);

		try {
			validarFuncionario(funcionarioId);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
            return notFound(e.getMessage());
		}

		List<FrequenciaApuracaoMes> lista = frequenciaApuracaoMesService.buscarPorFuncionario(funcionarioId);
		return ok(listaFrequenciaApuracaoMesToTO(lista));
	}

	@GET()
	@Path("/pesquisas/funcionarios/{funcionarioId}/frequencia-apuracao-mes/{ano}/{mes}/")
	@Produces("application/json")
	public Response pesquisarFrequenciaApuracaoMesPorAnoMes(@PathParam("funcionarioId") Long funcionarioId, 
			@PathParam("ano") Integer ano, @PathParam("mes") Integer mes, @HeaderParam("token") String token) {
		validarToken(token);
		
		try {
			validarFuncionario(funcionarioId);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
            return notFound(e.getMessage());
		}

		List<FrequenciaApuracaoMes> lista = frequenciaApuracaoMesService.buscarPorFuncionarioAnoMes(funcionarioId, ano, mes);
		return ok(listaFrequenciaApuracaoMesToTO(lista));
	}
	

	@GET()
	@Path("/funcionarios/{funcionarioId}/frequencia-apuracao-mes/{id}/")
	@Produces("application/json")
	public Response obterFrequenciaApuracaoMes(@PathParam("funcionarioId") Long funcionarioId, @PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);

		try {
			validarFuncionario(funcionarioId);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
            return notFound(e.getMessage());
		}

		FrequenciaApuracaoMes freq = frequenciaApuracaoMesService.buscarPorId(id);
		return ok(freq.toTO());
	}

	@POST()
	@Path("/funcionarios/{funcionarioId}/frequencia-apuracao-mes/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response criarFrequenciaApuracaoMes(@PathParam("funcionarioId") Long funcionarioId, FrequenciaApuracaoMesTO frequenciaApuracaoMesTO, @HeaderParam("token") String token) {
		validarToken(token);
		
		try {
			validarFuncionario(funcionarioId);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
            return notFound(e.getMessage());
		}
		
		try {
			FrequenciaApuracaoMes freq = new FrequenciaApuracaoMes(frequenciaApuracaoMesTO);
			freq = frequenciaApuracaoMesService.salvar(freq);
			return created(freq.toTO());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return internalServerError("Falha ao criar FrequenciaApuracaoMes: "+e.getMessage()); 			
		}

	}

	@PUT()
	@Path("/funcionarios/{funcionarioId}/frequencia-apuracao-mes/{id}/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response alterarFrequenciaApuracaoMes(@PathParam("funcionarioId") Long funcionarioId, @PathParam("id") Long id, FrequenciaApuracaoMesTO frequenciaApuracaoMesTO, @HeaderParam("token") String token) {
		validarToken(token);
		
		try {
			validarFuncionario(funcionarioId);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
            return notFound(e.getMessage());
		}
		
		FrequenciaApuracaoMes freq = frequenciaApuracaoMesService.buscarPorId(id);
		if (freq == null) {
			return notFound("FrequenciaApuracaoMes não encontrado!");
		}
		
		freq.alterar(frequenciaApuracaoMesTO);
		frequenciaApuracaoMesService.salvar(freq);
		return ok(freq.toTO());
	}

	@DELETE()
	@Path("/funcionarios/{funcionarioId}/frequencia-apuracao-mes/{id}/")
	@Produces("application/json")
	public Response removerFrequenciaApuracaoMes(@PathParam("funcionarioId") Long funcionarioId, @PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);
		
		try {
			validarFuncionario(funcionarioId);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
            return notFound(e.getMessage());
		}
		
		FrequenciaApuracaoMes freq = frequenciaApuracaoMesService.buscarPorId(id);
		if (freq == null) {
			return notFound("FrequenciaApuracaoMes não encontrado!");
		}
		
		frequenciaApuracaoMesService.excluir(freq);

		return ok();
	}
	
	@GET()
	@Path("/funcionarios/{funcionarioId}/frequencia-apuracao-mes/{frequenciaApuracaoMesId}/frequencia-apuracao-dia/")
	@Produces("application/json")
	public Response listarFrequenciaApuracaoDia(@PathParam("funcionarioId") Long funcionarioId, 
			@PathParam("frequenciaApuracaoMesId") Long frequenciaApuracaoMesId, @HeaderParam("token") String token) {
		validarToken(token);

		try {
			validarFuncionario(funcionarioId);
			validarFrequenciaApuracaoMes(frequenciaApuracaoMesId);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
            return notFound(e.getMessage());
		}
				
		List<FrequenciaApuracaoDia> lista = frequenciaApuracaoDiaService.buscarPorFrequenciaApuracaoMesId(frequenciaApuracaoMesId);
		
		return ok(listaFrequenciaApuracaoDiaToTO(lista));
	}

	@GET()
	@Path("/funcionarios/{funcionarioId}/frequencia-apuracao-mes/{frequenciaApuracaoMesId}/frequencia-apuracao-dia/{id}/")
	@Produces("application/json")
	public Response obterFrequenciaApuracaoDia(@PathParam("funcionarioId") Long funcionarioId, 
			@PathParam("frequenciaApuracaoMesId") Long frequenciaApuracaoMesId, @PathParam("id") Long id, 
			@HeaderParam("token") String token) {
		validarToken(token);
		
		try {
			validarFuncionario(funcionarioId);
			validarFrequenciaApuracaoMes(frequenciaApuracaoMesId);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
            return notFound(e.getMessage());
		}		
				
		FrequenciaApuracaoDia freqApuracaoDia = frequenciaApuracaoDiaService.buscarPorId(id);
		
		return freqApuracaoDia!=null?ok(freqApuracaoDia.toTO()):notFound("FrequenciaApuracaoDia id = "+id+" não existe!");
		
	}

	@POST()
	@Path("/funcionarios/{funcionarioId}/frequencia-apuracao-mes/{frequenciaApuracaoMesId}/frequencia-apuracao-dia/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response criarFrequenciaApuracaoDia(@PathParam("funcionarioId") Long funcionarioId, 
			@PathParam("frequenciaApuracaoMesId") Long frequenciaApuracaoMesId, FrequenciaApuracaoDiaTO frequenciaApuracaoDiaTO, @HeaderParam("token") String token) {
		validarToken(token);

		try {
			validarFuncionario(funcionarioId);
			validarFrequenciaApuracaoMes(frequenciaApuracaoMesId);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
            return notFound(e.getMessage());
		}

		FrequenciaApuracaoDia freqApuracaoDia = new FrequenciaApuracaoDia(frequenciaApuracaoDiaTO);
		
		try {
			freqApuracaoDia = frequenciaApuracaoDiaService.salvar(freqApuracaoDia);
			return created(freqApuracaoDia.toTO());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return internalServerError("Falha ao criar FrequenciaApuracaoDia: "+e.getMessage());
		}				

	}

	@PUT()
	@Path("/funcionarios/{funcionarioId}/frequencia-apuracao-mes/{frequenciaApuracaoMesId}/frequencia-apuracao-dia/{id}/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response alterarFrequenciaApuracaoDia(@PathParam("funcionarioId") Long funcionarioId, 
			@PathParam("frequenciaApuracaoMesId") Long frequenciaApuracaoMesId, @PathParam("id") Long id, 
			FrequenciaApuracaoDiaTO frequenciaApuracaoDiaTO, @HeaderParam("token") String token) {
		validarToken(token);
		
		try {
			validarFuncionario(funcionarioId);
			validarFrequenciaApuracaoMes(frequenciaApuracaoMesId);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);			
		}

		FrequenciaApuracaoDia freqApuracaoDia = frequenciaApuracaoDiaService.buscarPorId(id);
		
		if (freqApuracaoDia != null) {
			
			try {
				freqApuracaoDia.alterar(frequenciaApuracaoDiaTO);
				freqApuracaoDia = frequenciaApuracaoDiaService.salvar(freqApuracaoDia);
				return ok(freqApuracaoDia.toTO());
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
				return internalServerError("Falha ao alterar FrequenciaApuracaoDia: "+e.getMessage()); 			
			}				
			
		} else {
			return notFound("FrequenciaApuracaoDia id = "+id+" não existe!");
		}
		
	}

	@DELETE()
	@Path("/funcionarios/{funcionarioId}/frequencia-apuracao-mes/{frequenciaApuracaoMesId}/frequencia-apuracao-dia/{id}/")
	@Produces("application/json")
	public Response removerFrequenciaApuracaoDia(@PathParam("funcionarioId") Long funcionarioId, 
			@PathParam("frequenciaApuracaoMesId") Long frequenciaApuracaoMesId, @PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);
		
		try {
			validarFuncionario(funcionarioId);
			validarFrequenciaApuracaoMes(frequenciaApuracaoMesId);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
            return notFound(e.getMessage());
		}

		FrequenciaApuracaoDia freqApuracaoDia = frequenciaApuracaoDiaService.buscarPorId(id);
		
		if (freqApuracaoDia != null) {
			
			try {
				frequenciaApuracaoDiaService.excluir(freqApuracaoDia);
				return ok();
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
				return internalServerError("Falha ao remover FrequenciaApuracaoDia: "+e.getMessage()); 			
			}				
			
		} else {
			return notFound("FrequenciaApuracaoDia id = "+id+" não existe!");
		}
		
	}
	
	@GET()
	@Path("/funcionarios/{funcionarioId}/frequencia-apuracao-mes/{frequenciaApuracaoMesId}/frequencia-apuracao-dia/{frequenciaApuracaoDiaId}/ocorrencias/")
	@Produces("application/json")
	public Response listarFrequenciaApuracaoDiaOcorrencia(@PathParam("funcionarioId") Long funcionarioId, 
			@PathParam("frequenciaApuracaoMesId") Long frequenciaApuracaoMesId, 
			@PathParam("frequenciaApuracaoDiaId") Long frequenciaApuracaoDiaId, @HeaderParam("token") String token) {
		
		validarToken(token);
		
		try {
			validarFuncionario(funcionarioId);
			validarFrequenciaApuracaoMes(frequenciaApuracaoMesId);
			validarFrequenciaApuracaoDia(frequenciaApuracaoDiaId);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
            return notFound(e.getMessage());
		}
				
		List<FrequenciaApuracaoDiaOcorrencia> lista = frequenciaApuracaoDiaOcorrenciaService.buscarPorFrequenciaApuracaoDiaId(frequenciaApuracaoDiaId);				
		return ok(listaFrequenciaApuracaoDiaOcorrenciaToTO(lista));
	}

	@GET()
	@Path("/funcionarios/{funcionarioId}/frequencia-apuracao-mes/{frequenciaApuracaoMesId}/frequencia-apuracao-dia/{frequenciaApuracaoDiaId}/ocorrencias/{id}/")
	@Produces("application/json")
	public Response obterFrequenciaApuracaoDiaOcorrencia(@PathParam("funcionarioId") Long funcionarioId, 
			@PathParam("frequenciaApuracaoMesId") Long frequenciaApuracaoMesId, 
			@PathParam("frequenciaApuracaoDiaId") Long frequenciaApuracaoDiaId, @PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);
		
		try {
			validarFuncionario(funcionarioId);
			validarFrequenciaApuracaoMes(frequenciaApuracaoMesId);
			validarFrequenciaApuracaoDia(frequenciaApuracaoDiaId);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
            return notFound(e.getMessage());
		}
				
		FrequenciaApuracaoDiaOcorrencia freqApuracaoDiaOcorrencia = frequenciaApuracaoDiaOcorrenciaService.buscarPorId(id);
		
		if (freqApuracaoDiaOcorrencia!=null)	{
			return ok(freqApuracaoDiaOcorrencia.toTO());
		} else {
			return notFound("FrequenciaApuracaoDiaOcorrencia id = "+id+" não existe!");	
		}
	}

	@POST()
	@Path("/funcionarios/{funcionarioId}/frequencia-apuracao-mes/{frequenciaApuracaoMesId}/frequencia-apuracao-dia/{frequenciaApuracaoDiaId}/ocorrencias/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response criarFrequenciaApuracaoDiaOcorrencia(@PathParam("funcionarioId") Long funcionarioId, 
			@PathParam("frequenciaApuracaoMesId") Long frequenciaApuracaoMesId, 
			@PathParam("frequenciaApuracaoDiaId") Long frequenciaApuracaoDiaId, 
			FrequenciaApuracaoDiaOcorrenciaTO frequenciaApuracaoDiaOcorrenciaTO, @HeaderParam("token") String token) {
		validarToken(token);

		try {
			validarFuncionario(funcionarioId);
			validarFrequenciaApuracaoMes(frequenciaApuracaoMesId);
			validarFrequenciaApuracaoDia(frequenciaApuracaoDiaId);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
            return notFound(e.getMessage());
		}

		FrequenciaApuracaoDiaOcorrencia freqApuracaoDiaOcorrencia = new FrequenciaApuracaoDiaOcorrencia(frequenciaApuracaoDiaOcorrenciaTO);
		
		try {
			freqApuracaoDiaOcorrencia = frequenciaApuracaoDiaOcorrenciaService.salvar(freqApuracaoDiaOcorrencia);
			return created(freqApuracaoDiaOcorrencia.toTO());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return internalServerError("Falha ao criar FrequenciaApuracaoDiaOcorrencia: "+e.getMessage()); 			
		}				

	}

	@PUT()
	@Path("/funcionarios/{funcionarioId}/frequencia-apuracao-mes/{frequenciaApuracaoMesId}/frequencia-apuracao-dia/{frequenciaApuracaoDiaId}/ocorrencias/{id}/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response alterarFrequenciaApuracaoDiaOcorrencia(@PathParam("funcionarioId") Long funcionarioId, 
			@PathParam("frequenciaApuracaoMesId") Long frequenciaApuracaoMesId, 
			@PathParam("frequenciaApuracaoDiaId") Long frequenciaApuracaoDiaId, @PathParam("id") Long id, 
			FrequenciaApuracaoDiaOcorrenciaTO frequenciaApuracaoDiaOcorrenciaTO, @HeaderParam("token") String token) {
		validarToken(token);
		
		try {
			validarFuncionario(funcionarioId);
			validarFrequenciaApuracaoMes(frequenciaApuracaoMesId);
			validarFrequenciaApuracaoDia(frequenciaApuracaoDiaId);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
            return notFound(e.getMessage());
		}

		FrequenciaApuracaoDiaOcorrencia freqApuracaoDiaOcorrencia = frequenciaApuracaoDiaOcorrenciaService.buscarPorId(id);
		
		if (freqApuracaoDiaOcorrencia != null) {
			
			try {
				freqApuracaoDiaOcorrencia.alterar(frequenciaApuracaoDiaOcorrenciaTO);
				freqApuracaoDiaOcorrencia = frequenciaApuracaoDiaOcorrenciaService.salvar(freqApuracaoDiaOcorrencia);
				return ok(freqApuracaoDiaOcorrencia.toTO());
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
				return internalServerError("Falha ao alterar FrequenciaApuracaoDiaOcorrencia: "+e.getMessage()); 			
			}				
			
		} else {
			return notFound("FrequenciaApuracaoDiaOcorrencia id = "+id+" não existe!");
		}
		
	}

	@DELETE()
	@Path("/funcionarios/{funcionarioId}/frequencia-apuracao-mes/{frequenciaApuracaoMesId}/frequencia-apuracao-dia/{frequenciaApuracaoDiaId}/ocorrencias/{id}/")
	@Produces("application/json")
	public Response removerFrequenciaApuracaoDia(@PathParam("funcionarioId") Long funcionarioId, 
			@PathParam("frequenciaApuracaoMesId") Long frequenciaApuracaoMesId, 
			@PathParam("frequenciaApuracaoDiaId") Long frequenciaApuracaoDiaId, @PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);
		
		try {
			validarFuncionario(funcionarioId);
			validarFrequenciaApuracaoMes(frequenciaApuracaoMesId);
			validarFrequenciaApuracaoDia(frequenciaApuracaoDiaId);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
            return notFound(e.getMessage());
		}

		FrequenciaApuracaoDiaOcorrencia freqApuracaoDiaOcorrencia = frequenciaApuracaoDiaOcorrenciaService.buscarPorId(id);
		
		if (freqApuracaoDiaOcorrencia != null) {
			
			try {
				frequenciaApuracaoDiaOcorrenciaService.excluir(freqApuracaoDiaOcorrencia);
				return ok();
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
				return internalServerError("Falha ao excluir FrequenciaApuracaoDiaOcorrencia: "+e.getMessage()); 			
			}				
			
		} else {
			return notFound("FrequenciaApuracaoDiaOcorrencia id = "+id+" não existe!");
		}
				
	}
	
	@GET()
	@Path("/funcionarios/{funcionarioId}/frequencia-apuracao-mes/{frequenciaApuracaoMesId}/frequencia-apuracao-dia/{frequenciaApuracaoDiaId}/carga-horaria/")
	@Produces("application/json")
	public Response listarFrequenciaApuracaoDiaCargaHoraria(@PathParam("funcionarioId") Long funcionarioId, 
			@PathParam("frequenciaApuracaoMesId") Long frequenciaApuracaoMesId, 
			@PathParam("frequenciaApuracaoDiaId") Long frequenciaApuracaoDiaId, @HeaderParam("token") String token) {
		
		validarToken(token);
		
		try {
			validarFuncionario(funcionarioId);
			validarFrequenciaApuracaoMes(frequenciaApuracaoMesId);
			validarFrequenciaApuracaoDia(frequenciaApuracaoDiaId);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
            return notFound(e.getMessage());
		}
				
		List<FrequenciaApuracaoDiaCargaHoraria> lista = frequenciaApuracaoDiaCargaHorariaService.buscarPorFrequenciaApuracaoDiaId(frequenciaApuracaoDiaId);				
		return ok(listaFrequenciaApuracaoDiaCargaHorariaToTO(lista));
	}

	@GET()
	@Path("/funcionarios/{funcionarioId}/frequencia-apuracao-mes/{frequenciaApuracaoMesId}/frequencia-apuracao-dia/{frequenciaApuracaoDiaId}/carga-horaria/{id}/")
	@Produces("application/json")
	public Response obterFrequenciaApuracaoDiaCargaHoraria(@PathParam("funcionarioId") Long funcionarioId, 
			@PathParam("frequenciaApuracaoMesId") Long frequenciaApuracaoMesId, 
			@PathParam("frequenciaApuracaoDiaId") Long frequenciaApuracaoDiaId, @PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);
		
		try {
			validarFuncionario(funcionarioId);
			validarFrequenciaApuracaoMes(frequenciaApuracaoMesId);
			validarFrequenciaApuracaoDia(frequenciaApuracaoDiaId);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
            return notFound(e.getMessage());
		}
				
		FrequenciaApuracaoDiaCargaHoraria freqApuracaoDiaCargaHoraria = frequenciaApuracaoDiaCargaHorariaService.buscarPorId(id);
		
		if (freqApuracaoDiaCargaHoraria!=null)	{
			return ok(freqApuracaoDiaCargaHoraria.toTO());
		} else {
			return notFound("FrequenciaApuracaoDiaCargaHoraria id = "+id+" não existe!");	
		}
	}

	@POST()
	@Path("/funcionarios/{funcionarioId}/frequencia-apuracao-mes/{frequenciaApuracaoMesId}/frequencia-apuracao-dia/{frequenciaApuracaoDiaId}/carga-horaria/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response criarFrequenciaApuracaoDiaCargaHoraria(@PathParam("funcionarioId") Long funcionarioId, 
			@PathParam("frequenciaApuracaoMesId") Long frequenciaApuracaoMesId, 
			@PathParam("frequenciaApuracaoDiaId") Long frequenciaApuracaoDiaId, 
			FrequenciaApuracaoDiaCargaHorariaTO frequenciaApuracaoDiaCargaHorariaTO, @HeaderParam("token") String token) {
		validarToken(token);

		try {
			validarFuncionario(funcionarioId);
			validarFrequenciaApuracaoMes(frequenciaApuracaoMesId);
			validarFrequenciaApuracaoDia(frequenciaApuracaoDiaId);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
            return notFound(e.getMessage());
		}

		FrequenciaApuracaoDiaCargaHoraria freqApuracaoDiaCargaHoraria = new FrequenciaApuracaoDiaCargaHoraria(frequenciaApuracaoDiaCargaHorariaTO);
		
		try {
			freqApuracaoDiaCargaHoraria = frequenciaApuracaoDiaCargaHorariaService.salvar(freqApuracaoDiaCargaHoraria);
			return created(freqApuracaoDiaCargaHoraria.toTO());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return internalServerError("Falha ao criar FrequenciaApuracaoDiaCargaHoraria: "+e.getMessage()); 			
		}				

	}

	@PUT()
	@Path("/funcionarios/{funcionarioId}/frequencia-apuracao-mes/{frequenciaApuracaoMesId}/frequencia-apuracao-dia/{frequenciaApuracaoDiaId}/carga-horaria/{id}/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response alterarFrequenciaApuracaoDiaCargaHoraria(@PathParam("funcionarioId") Long funcionarioId, 
			@PathParam("frequenciaApuracaoMesId") Long frequenciaApuracaoMesId, 
			@PathParam("frequenciaApuracaoDiaId") Long frequenciaApuracaoDiaId, @PathParam("id") Long id, 
			FrequenciaApuracaoDiaCargaHorariaTO frequenciaApuracaoDiaCargaHorariaTO, @HeaderParam("token") String token) {

		validarToken(token);
		
		try {
			validarFuncionario(funcionarioId);
			validarFrequenciaApuracaoMes(frequenciaApuracaoMesId);
			validarFrequenciaApuracaoDia(frequenciaApuracaoDiaId);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
            return notFound(e.getMessage());
		}

		FrequenciaApuracaoDiaCargaHoraria freqApuracaoDiaCargaHoraria = frequenciaApuracaoDiaCargaHorariaService.buscarPorId(id);
		
		if (freqApuracaoDiaCargaHoraria != null) {
			
			try {
				freqApuracaoDiaCargaHoraria.alterar(frequenciaApuracaoDiaCargaHorariaTO);
				freqApuracaoDiaCargaHoraria = frequenciaApuracaoDiaCargaHorariaService.salvar(freqApuracaoDiaCargaHoraria);
				return ok(freqApuracaoDiaCargaHoraria.toTO());
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
				return internalServerError("Falha ao alterar FrequenciaApuracaoDiaCargaHoraria: "+e.getMessage()); 			
			}				
			
		} else {
			return notFound("FrequenciaApuracaoDiaCargaHoraria id = "+id+" não existe!");
		}
		
	}

	@DELETE()
	@Path("/funcionarios/{funcionarioId}/frequencia-apuracao-mes/{frequenciaApuracaoMesId}/frequencia-apuracao-dia/{frequenciaApuracaoDiaId}/carga-horaria/{id}/")
	@Produces("application/json")
	public Response removerFrequenciaApuracaoDiaCargaHoraria(@PathParam("funcionarioId") Long funcionarioId, 
			@PathParam("frequenciaApuracaoMesId") Long frequenciaApuracaoMesId, 
			@PathParam("frequenciaApuracaoDiaId") Long frequenciaApuracaoDiaId, @PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);
		
		try {
			validarFuncionario(funcionarioId);
			validarFrequenciaApuracaoMes(frequenciaApuracaoMesId);
			validarFrequenciaApuracaoDia(frequenciaApuracaoDiaId);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
            return notFound(e.getMessage());
		}

		FrequenciaApuracaoDiaCargaHoraria freqApuracaoDiaCargaHoraria = frequenciaApuracaoDiaCargaHorariaService.buscarPorId(id);
		
		if (freqApuracaoDiaCargaHoraria != null) {
			
			try {
				frequenciaApuracaoDiaCargaHorariaService.excluir(freqApuracaoDiaCargaHoraria);
				return ok();
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
				return internalServerError("Falha ao excluir FrequenciaApuracaoDiaCargaHoraria: "+e.getMessage()); 			
			}				
			
		} else {
			return notFound("FrequenciaApuracaoDiaCargaHoraria id = "+id+" não existe!");
		}
				
	}	
	
	@GET()
	@Path("/funcionarios/{funcionarioId}/registro-frequencia/")
	@Produces("application/json")
	public Response listarRegistroFrequencia(@PathParam("funcionarioId") Long funcionarioId, @HeaderParam("token") String token) {
		validarToken(token);

		try {
			validarFuncionario(funcionarioId);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
            return notFound(e.getMessage());
		}

		List<RegistroFrequencia> lista = registroFrequenciaService.buscarPorFuncionario(funcionarioId);
		
		return ok(listaRegistroFrequenciaToTO(lista));
	}

	@GET()
	@Path("/funcionarios/{funcionarioId}/registro-frequencia/{id}/")
	@Produces("application/json")
	public Response obterRegistroFrequencia(@PathParam("funcionarioId") Long funcionarioId, @PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);

		try {
			validarFuncionario(funcionarioId);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
            return notFound(e.getMessage());
		}

		RegistroFrequencia freq = registroFrequenciaService.buscarPorId(id);
		
		return ok(freq.toTO());
	}

	@POST()
	@Path("/funcionarios/{funcionarioId}/registro-frequencia/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response criarRegistroFrequencia(@PathParam("funcionarioId") Long funcionarioId, RegistroFrequenciaTO registroFrequenciaTO, @HeaderParam("token") String token) {
		validarToken(token);
		
		try {
			validarFuncionario(funcionarioId);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
            return notFound(e.getMessage());
		}
		
		try {
			RegistroFrequencia freq = new RegistroFrequencia(registroFrequenciaTO);
			freq = registroFrequenciaService.salvar(freq);
			return created(freq.toTO());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return internalServerError("Falha ao criar Registro de frequência: "+e.getMessage()); 			
		}

	}

	@PUT()
	@Path("/funcionarios/{funcionarioId}/registro-frequencia/{id}/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response alterarRegistroFrequencia(@PathParam("funcionarioId") Long funcionarioId, @PathParam("id") Long id, 
			RegistroFrequenciaTO registroFrequenciaTO, @HeaderParam("token") String token) {
		validarToken(token);
		
		try {
			validarFuncionario(funcionarioId);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
            return notFound(e.getMessage());
		}
		
		RegistroFrequencia freq = registroFrequenciaService.buscarPorId(id);
		
		if (freq == null) {
			return notFound("Registro de frequência não encontrado!");
		}
		
		freq.alterar(registroFrequenciaTO);
		registroFrequenciaService.salvar(freq);
		return ok(freq.toTO());
	}

	@DELETE()
	@Path("/funcionarios/{funcionarioId}/registro-frequencia/{id}/")
	@Produces("application/json")
	public Response removerRegistroFrequencia(@PathParam("funcionarioId") Long funcionarioId, @PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);
		
		try {
			validarFuncionario(funcionarioId);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
            return notFound(e.getMessage());
		}
		
		RegistroFrequencia freq = registroFrequenciaService.buscarPorId(id);
		if (freq == null) {
			return notFound("Registro de frequência não encontrado!");
		}
		
		registroFrequenciaService.excluir(freq);

		return ok();
	}	
	
	
	// validações

	private Boolean validarFrequenciaApuracaoDia(Long frequenciaApuracaoDiaId) {
		FrequenciaApuracaoDia freqApuracaoDia = frequenciaApuracaoDiaService.buscarPorId(frequenciaApuracaoDiaId);
		if (freqApuracaoDia == null) {
			throw new NotFoundException("FrequenciaApuracaoDia id = "+frequenciaApuracaoDiaId+" não existe!");
		} 
		return true;
	}

	private Boolean validarFrequenciaApuracaoMes(Long frequenciaApuracaoMesId)  {
		FrequenciaApuracaoMes freqApuracaoMes = frequenciaApuracaoMesService.buscarPorId(frequenciaApuracaoMesId);
		if (freqApuracaoMes == null) {
			throw new NotFoundException("FrequenciaApuracaoMes id = "+frequenciaApuracaoMesId+" não existe!");
		} 
		return true;
	}

	private Boolean validarFuncionario(Long funcionarioId) {
		Funcionario funcionario = funcionarioService.buscarPorId(funcionarioId);		
		if (funcionario == null) {
			throw new NotFoundException("Funcionário id = "+funcionarioId+" não existe!");
		}

		return true;		
	}

	// converte listas para TOs
	
	private List<RegistroFrequenciaTO> listaRegistroFrequenciaToTO(List<RegistroFrequencia> lista) {
		List<RegistroFrequenciaTO> tos = new ArrayList<>();
		for (RegistroFrequencia registroFrequencia : lista) {
			tos.add(registroFrequencia.toTO());
		}
		return tos;
	}

	private List<FrequenciaApuracaoMesTO> listaFrequenciaApuracaoMesToTO(List<FrequenciaApuracaoMes> lista) {
		List<FrequenciaApuracaoMesTO> tos = new ArrayList<>();
		for (FrequenciaApuracaoMes frequenciaApuracaoMes : lista) {
			tos.add(frequenciaApuracaoMes.toTO());
		}
		return tos;
	}
	
	private List<FrequenciaApuracaoDiaTO> listaFrequenciaApuracaoDiaToTO(List<FrequenciaApuracaoDia> lista) {
		List<FrequenciaApuracaoDiaTO> tos = new ArrayList<>();
		for (FrequenciaApuracaoDia f : lista) {
			tos.add(f.toTO());
		}
		return tos;
	}	
	
	private List<FrequenciaApuracaoDiaOcorrenciaTO> listaFrequenciaApuracaoDiaOcorrenciaToTO(List<FrequenciaApuracaoDiaOcorrencia> lista) {
		List<FrequenciaApuracaoDiaOcorrenciaTO> tos = new ArrayList<>();
		for (FrequenciaApuracaoDiaOcorrencia f : lista) {
			tos.add(f.toTO());
		}
		return tos;
	}
	
	private List<FrequenciaApuracaoDiaCargaHorariaTO> listaFrequenciaApuracaoDiaCargaHorariaToTO(List<FrequenciaApuracaoDiaCargaHoraria> lista) {
		List<FrequenciaApuracaoDiaCargaHorariaTO> tos = new ArrayList<>();
		for (FrequenciaApuracaoDiaCargaHoraria f : lista) {
			tos.add(f.toTO());
		}
		return tos;
	}	
	
}