package br.jus.tjms.sgpd.service.rest.v1;

import br.jus.tjms.sgpd.entity.Cargo;
import br.jus.tjms.sgpd.entity.FuncionarioCargo;
import br.jus.tjms.sgpd.entity.ProgressaoFuncional;
import br.jus.tjms.sgpd.service.ServicesPortal;
import br.jus.tjms.sgpd.service.cargoservices.FuncionarioCargoService;
import br.jus.tjms.sgpd.service.evolucaofuncionalservices.ProgressaoFuncionalService;
import br.jus.tjms.sgpd.service.funcionarioservices.FuncionarioService;
import br.jus.tjms.sgpd.service.rest.v1.to.FuncionarioCargoTO;
import br.jus.tjms.sgpd.service.rest.v1.to.ProgressaoFuncionalTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * @version 1.0
 * @created 11-dez-2015 18:15:46
 */
@Path("/rest/v1")
public class RESTServicesFuncionarioCargoPortal extends RESTServicesBasePortalV1 implements ServicesPortal {

	private static final long serialVersionUID = -4384824273827618673L;
    private static Logger logger = LoggerFactory.getLogger(RESTServicesFuncionarioCargoPortal.class);

	@EJB
	private FuncionarioService funcionarioService;

	@EJB
	private FuncionarioCargoService funcionarioCargoService;

	@EJB
	private ProgressaoFuncionalService progressaoFuncionalService;

	// cargo do funcionário
	/*
	 * FuncionarioCargo (cargos do funcionário):
	 * listarCargosDoFuncionario					GET		/funcionarios/1/cargos/
	 * obterFuncionarioCargo						GET		/funcionarios/1/cargos/1
	 * criarFuncionarioCargo						POST	/funcionarios/1/cargos/
	 * alterarFuncionarioCargo						PUT		/funcionarios/1/cargos/1
	 * removerFuncionarioCargo						DELETE	/funcionarios/1/cargos/1
	 * 
	 * ProgressaoFuncional (progressões do cargo do funcionário):
	 * listarProgressoesDoCargoDoFuncionario		GET		/funcionarios/1/cargos/1/progressoes/
	 * obterProgressaoFuncional						GET		/funcionarios/1/cargos/1/progressoes/1
	 * criarProgressaoFuncional						POST	/funcionarios/1/cargos/1/progressoes/
	 * alterarProgressaoFuncional					PUT		/funcionarios/1/cargos/1/progressoes/1/...
	 * removerProgressaoFuncional					DELETE	/funcionarios/1/cargos/1/progressoes/1
	 * 
	 */

	@GET()
	@Path("/funcionarios/{funcionarioId}/funcionario-cargos/")
	@Produces("application/json")
	public Response listarFuncionarioCargos(@PathParam("funcionarioId") Long funcionarioId, @HeaderParam("token") String token) {
		validarToken(token);
		List<FuncionarioCargo> funcionarioCargos = funcionarioCargoService.buscarFuncionarioCargosPorFuncionario(funcionarioId);
		return ok(funcionarioCargos);
	}

	@GET()
	@Path("/funcionarios/{funcionarioId}/cargos/")
	@Produces("application/json")
	public Response listarCargosDoFuncionario(@PathParam("funcionarioId") Long funcionarioId, @HeaderParam("token") String token) {
		validarToken(token);
		List<Cargo> cargos = funcionarioCargoService.buscarCargosPorFuncionario(funcionarioId);
		return ok(cargos);
	}

	@GET()
	@Path("/funcionarios/{funcionarioId}/cargos/{id}/")
	@Produces("application/json")
	public Response obterFuncionarioCargo(@PathParam("funcionarioId") Long funcionarioId, @PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);
		FuncionarioCargo funcionarioCargo = funcionarioCargoService.buscarPorId(id);
		return ok(funcionarioCargo);
	}

	@POST()
	@Path("/funcionarios/{funcionarioId}/cargos/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response criarFuncionarioCargo(@PathParam("funcionarioId") Long funcionarioId, FuncionarioCargoTO funcionarioCargoTO, @HeaderParam("token") String token) {
		validarToken(token);

		FuncionarioCargo funcionarioCargo = new FuncionarioCargo(funcionarioCargoTO);

		try {
			funcionarioCargo = funcionarioCargoService.salvar(funcionarioCargo);
			return created(funcionarioCargo.toTO());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return internalServerError("Falha ao criar cargo do funcionário: "+e.getMessage());
		}
	}

	@PUT()
	@Path("/funcionarios/{funcionarioId}/cargos/{id}/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response alterarFuncionarioCargo(@PathParam("funcionarioId") Long funcionarioId, @PathParam("id") Long id, FuncionarioCargoTO funcionarioCargoTO, @HeaderParam("token") String token) {
		validarToken(token);

		FuncionarioCargo funcionarioCargo = funcionarioCargoService.buscarPorId(id);
		if (funcionarioCargo == null) {
			return notFound();
		}

		funcionarioCargo.alterar(funcionarioCargoTO);
		funcionarioCargo = funcionarioCargoService.salvar(funcionarioCargo);
		return ok(funcionarioCargo);
	}

	@DELETE()
	@Path("/funcionarios/{funcionarioId}/cargos/{id}/")
	@Produces("application/json")
	public Response removerFuncionarioCargo(@PathParam("funcionarioId") Long funcionarioId, @PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);

		FuncionarioCargo funcionarioCargo = funcionarioCargoService.buscarPorId(id);
		if (funcionarioCargo == null) {
			return notFound();
		}

		funcionarioCargoService.excluir(funcionarioCargo);
		return ok();
	}

	@GET()
	@Path("/funcionarios/{funcionarioId}/cargos/{id}/progressoes/")
	@Produces("application/json")
	public Response listarProgressoesDoCargoDoFuncionario(@PathParam("funcionarioId") Long funcionarioId, @PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);
		List<ProgressaoFuncional> progressos = funcionarioCargoService.buscarProgressoesPorFuncionario(funcionarioId);
		return ok(progressos);
	}

	@GET()
	@Path("/funcionarios/{funcionarioId}/cargos/{funcionarioCargoId}/progressoes/{progressaoId}/")
	@Produces("application/json")
	public Response obterProgressaoFuncional(@PathParam("funcionarioId") Long funcionarioId,
			@PathParam("funcionarioCargoId") Long funcionarioCargoId, @PathParam("progressaoId") Long progressaoId,
			@HeaderParam("token") String token) {
		validarToken(token);
		ProgressaoFuncional progressaoFuncional = progressaoFuncionalService.buscarPorId(progressaoId);
		return ok(progressaoFuncional);
	}

	@POST()
	@Path("/funcionarios/{funcionarioId}/cargos/{funcionarioCargoId}/progressoes/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response criarProgressaoFuncional(@PathParam("funcionarioId") Long funcionarioId,
			@PathParam("funcionarioCargoId") Long funcionarioCargoId, ProgressaoFuncionalTO progressaoFuncionalTO,
			@HeaderParam("token") String token) {
		validarToken(token);
		ProgressaoFuncional progressaoFuncional = new ProgressaoFuncional(progressaoFuncionalTO);
		try {
			progressaoFuncional = progressaoFuncionalService.salvar(progressaoFuncional);
			return created(progressaoFuncional);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return internalServerError("Falha ao criar progressão funcional: "+e.getMessage());
		}
	}

	@PUT()
	@Path("/funcionarios/{funcionarioId}/cargos/{funcionarioCargoId}/progressoes/{progressaoId}/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response alterarProgressaoFuncional(@PathParam("funcionarioId") Long funcionarioId,
			@PathParam("funcionarioCargoId") Long funcionarioCargoId, @PathParam("progressaoId") Long progressaoId,
			ProgressaoFuncionalTO progressaoFuncionalTO,
			@HeaderParam("token") String token) {
		validarToken(token);

		ProgressaoFuncional progressaoFuncional = progressaoFuncionalService.buscarPorId(progressaoId);
		if (progressaoFuncional == null) {
			return notFound();
		}

		progressaoFuncional.alterar(progressaoFuncionalTO);
		progressaoFuncional = progressaoFuncionalService.salvar(progressaoFuncional);
		return ok(progressaoFuncional);
	}

	@DELETE()
	@Path("/funcionarios/{funcionarioId}/cargos/{funcionarioCargoId}/progressoes/{progressaoId}/")
	@Produces("application/json")
	public Response removerProgressaoFuncional(@PathParam("funcionarioId") Long funcionarioId,
			@PathParam("funcionarioCargoId") Long funcionarioCargoId, @PathParam("progressaoId") Long progressaoId,
			@HeaderParam("token") String token) {
		validarToken(token);

		ProgressaoFuncional progressaoFuncional = progressaoFuncionalService.buscarPorId(progressaoId);
		if (progressaoFuncional == null) {
			return notFound();
		}

		progressaoFuncionalService.excluir(progressaoFuncional);
		return ok();
	}

}