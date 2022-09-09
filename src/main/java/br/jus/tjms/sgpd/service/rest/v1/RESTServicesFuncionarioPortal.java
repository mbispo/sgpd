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

import br.jus.tjms.sgpd.entity.Funcionario;
import br.jus.tjms.sgpd.service.ServicesPortal;
import br.jus.tjms.sgpd.service.funcionarioservices.FuncionarioService;
import br.jus.tjms.sgpd.service.rest.v1.to.FuncionarioTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @version 1.0
 * @created 11-dez-2015 18:15:46
 */
@Path("/rest/v1")
public class RESTServicesFuncionarioPortal extends RESTServicesBasePortalV1 implements ServicesPortal {

	private static final long serialVersionUID = -2131882908384399282L;
    private static Logger logger = LoggerFactory.getLogger(RESTServicesFuncionarioPortal.class);
	
	@EJB
	private FuncionarioService funcionarioService;
	
	// funcionario
	/*
	 * listarFuncionarios							GET		/funcionarios/
	 * pesquisarFuncionarios						GET		/pesquisas/funcionarios/nome, ...
	 * obterFuncionario								GET		/funcionarios/1
	 * criarFuncionario								POST	/funcionarios/...
	 * alterarFuncionario							PUT		/funcionarios/1/...
	 * removerFuncionario							DELETE	/funcionarios/1
	 * 
	 */
	
	@GET()
	@Path("/funcionarios/")
	@Produces("application/json")
	public Response listarFuncionarios(@HeaderParam("token") String token) {
		validarToken(token);
		Object o = funcionarioService.buscarTodos();
		return ok(o);
	}

	@GET()
	@Path("/pesquisas/funcionarios/nome/{nome}")
	@Produces("application/json")
	public Response pesquisarFuncionariosPorNome(@PathParam("nome") String nome, @HeaderParam("token") String token) {
		validarToken(token);
		List<Funcionario> funcionarios = funcionarioService.buscarPorNome(nome);
		return ok(funcionarios);
	}
	
	@GET()
	@Path("/pesquisas/funcionarios/matricula/{matricula}")
	@Produces("application/json")
	public Response pesquisarFuncionariosPorMatricula(@PathParam("matricula") Integer matricula, @HeaderParam("token") String token) {
		validarToken(token);
		Funcionario funcionario = funcionarioService.buscarPorMatricula(matricula);
		return ok(funcionario);
	}
	

	@GET()
	@Path("/funcionarios/{id}/")
	@Produces("application/json")
	public Response obterFuncionario(@PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);
		Funcionario funcionario = funcionarioService.buscarPorId(id);

		if (funcionario == null) {
			return notFound("Funcionário não encontrado!");
		}
		
		return ok(funcionario.toTO());
	}

	@POST()
	@Path("/funcionarios/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response criarFuncionario(FuncionarioTO funcionarioTO, @HeaderParam("token") String token) {
		validarToken(token);
		
		Funcionario funcionario = new Funcionario(funcionarioTO);
		
		try {
			funcionario = funcionarioService.salvar(funcionario);
			return created(funcionario);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return internalServerError("Falha ao criar funcionário: "+e.getMessage()); 			
		}

	}

	@PUT()
	@Path("/funcionarios/{id}/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response alterarFuncionario(@PathParam("id") Long id, FuncionarioTO funcionarioTO, @HeaderParam("token") String token) {
		validarToken(token);
		
		Funcionario funcionario = funcionarioService.buscarPorId(id);
		if (funcionario == null) {
			return notFound();
		}
		
		funcionario.alterar(funcionarioTO);
		funcionarioService.salvar(funcionario);
		return ok(funcionario);
	}

	@DELETE()
	@Path("/funcionarios/{id}/")
	@Produces("application/json")
	public Response removerFuncionario(@PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);
		
		Funcionario funcionario = funcionarioService.buscarPorId(id);
		if (funcionario == null) {
			return notFound();
		}
		
		funcionarioService.excluir(funcionario);
		return ok();
	}

}