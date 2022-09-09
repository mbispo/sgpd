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

import br.jus.tjms.sgpd.entity.EscalaFuncionario;
import br.jus.tjms.sgpd.entity.Funcionario;
import br.jus.tjms.sgpd.service.ServicesPortal;
import br.jus.tjms.sgpd.service.frequenciaservices.EscalaFuncionarioService;
import br.jus.tjms.sgpd.service.funcionarioservices.FuncionarioService;
import br.jus.tjms.sgpd.service.rest.v1.to.EscalaFuncionarioTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @version 1.0
 * @created 11-dez-2015 18:15:46
 */
@Path("/rest/v1")
public class RESTServicesEscalaFuncionario extends RESTServicesBasePortalV1 implements ServicesPortal {

	private static final long serialVersionUID = -8284173367625167645L;
    private static Logger logger = LoggerFactory.getLogger(RESTServicesEscalaFuncionario.class);
	
	@EJB
	private FuncionarioService funcionarioService;
	
	@EJB
	private EscalaFuncionarioService escalaFuncionarioService;

	/*
	 * EscalaFuncionario
	 * 
	 * listarFuncionariosDaEscala						GET		/escalas/1/funcionarios/
	 * listarEscalasDoFuncionario						GET		/funcionarios/1/escalas/
	 * obterEscalaFuncionario							GET		/funcionarios/1/escalas/1
	 * criarEscalaFuncionario							POST	/funcionarios/1/escalas/
	 * alterarEscalaFuncionario						    PUT		/funcionarios/1/escalas/1/
	 * removerEscalaFuncionario						    DELETE	/funcionarios/1/escalas/1
	 * 
	 */
	
	@GET()
	@Path("/escalas/{escalaId}/funcionarios/")
	@Produces("application/json")
	public Response listarFuncionariosDaEscala(@PathParam("escalaId") Long escalaId, @HeaderParam("token") String token) {
		validarToken(token);
		//List<Funcionario> funcionarios = escalaFuncionarioService.buscarFuncionariosPorEscala(escalaId);
		return ok();
	}

	@GET()
	@Path("/funcionarios/{funcionarioId}/escalas/")
	@Produces("application/json")
	public Response listarEscalasDoFuncionario(@PathParam("funcionarioId") Long funcionarioId, @HeaderParam("token") String token) {
		validarToken(token);
		List<EscalaFuncionario> escalas = escalaFuncionarioService.buscarEscalasPorFuncionario(funcionarioId);
		return ok(escalas);
	}

	@GET()
	@Path("/funcionarios/{funcionarioId}/escalas/{id}/")
	@Produces("application/json")
	public Response obterEscalaFuncionario(@PathParam("funcionarioId") Long funcionarioId, @PathParam("id") Long id, 
			@HeaderParam("token") String token) {
		validarToken(token);
		EscalaFuncionario escalaFuncionario = escalaFuncionarioService.buscarPorId(id);
		return ok(escalaFuncionario);
	}

	@POST()
	@Path("/funcionarios/{funcionarioId}/escalas/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response criarEscalaFuncionario(@PathParam("funcionarioId") Long funcionarioId, EscalaFuncionarioTO escalaFuncionarioTO, @HeaderParam("token") String token) {
		validarToken(token);
		EscalaFuncionario escalaFuncionario = new EscalaFuncionario(escalaFuncionarioTO);
		try {
			
			Funcionario funcionario = funcionarioService.getEm().getReference(Funcionario.class, funcionarioId);
			escalaFuncionario.setFuncionario(funcionario);
			
			escalaFuncionario = escalaFuncionarioService.salvar(escalaFuncionario);
			return created(escalaFuncionario);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return internalServerError("Falha ao criar escalaFuncionario: "+e.getMessage());			
		}
	}

	@PUT()
	@Path("/funcionarios/{funcionarioId}/escalas/{id}/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response alterarEscalaFuncionario(@PathParam("funcionarioId") Long funcionarioId, @PathParam("id") Long id, 
			EscalaFuncionarioTO escalaFuncionarioTO, @HeaderParam("token") String token) {
		validarToken(token);
//TODO
//		EscalaFuncionario escalaFuncionario = escalaFuncionarioService.buscarPorId(id);
//		if (escalaFuncionario == null) {
//			return notFound();
//		}
//		
//		escalaFuncionario.alterar(escalaFuncionarioTO);
//		try {
//			escalaFuncionario = escalaFuncionarioService.salvar(escalaFuncionario);
//			return ok(escalaFuncionario);
//		} catch (Exception e) {
//			logger.error(e.getMessage(), e);
//			return internalServerError("Falha ao alterar escalaFuncionario: "+e.getMessage());			
//		}
		return ok();
	}

	@DELETE()
	@Path("/funcionarios/{funcionarioId}/escalas/{id}/")
	@Produces("application/json")
	public Response removerEscalaFuncionario(@PathParam("funcionarioId") Long funcionarioId, @PathParam("id") Long id, 
			@HeaderParam("token") String token) {
		validarToken(token);
		
		EscalaFuncionario escalaFuncionario = escalaFuncionarioService.buscarPorId(id);
		if ( escalaFuncionario == null) {
			return notFound();
		}
		
		escalaFuncionarioService.excluir(escalaFuncionario);
		return ok();
	}

}