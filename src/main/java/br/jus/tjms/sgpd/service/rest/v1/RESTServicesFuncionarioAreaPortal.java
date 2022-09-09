package br.jus.tjms.sgpd.service.rest.v1;

import br.jus.tjms.sgpd.entity.Area;
import br.jus.tjms.sgpd.entity.Funcionario;
import br.jus.tjms.sgpd.entity.FuncionarioArea;
import br.jus.tjms.sgpd.service.ServicesPortal;
import br.jus.tjms.sgpd.service.funcionarioservices.FuncionarioService;
import br.jus.tjms.sgpd.service.lotacaoservices.FuncionarioAreaService;
import br.jus.tjms.sgpd.service.rest.v1.to.FuncionarioAreaTO;
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
public class RESTServicesFuncionarioAreaPortal extends RESTServicesBasePortalV1 implements ServicesPortal {

	private static final long serialVersionUID = -8284173367625167645L;
    private static Logger logger = LoggerFactory.getLogger(RESTServicesFuncionarioAreaPortal.class);
	
	@EJB
	private FuncionarioService funcionarioService;
	
	@EJB
	private FuncionarioAreaService funcionarioAreaService;

	// área do funcionário (lotação)
	/*
	 * FuncionarioArea
	 * 
	 * listarFuncionariosDaArea						GET		/areas/1/funcionarios/
	 * listarAreasDoFuncionario						GET		/funcionarios/1/areas/
	 * obterFuncionarioArea							GET		/funcionarios/1/areas/1
	 * criarFuncionarioArea							POST	/funcionarios/1/areas/
	 * alterarFuncionarioArea						PUT		/funcionarios/1/areas/1/
	 * removerFuncionarioArea						DELETE	/funcionarios/1/areas/1
	 * 
	 */
	
	@GET()
	@Path("/areas/{areaId}/funcionarios/")
	@Produces("application/json")
	public Response listarFuncionariosDaArea(@PathParam("areaId") Long areaId, @HeaderParam("token") String token) {
		validarToken(token);
		List<Funcionario> funcionarios = funcionarioAreaService.buscarFuncionariosPorArea(areaId);
		return ok(funcionarios);
	}

	@GET()
	@Path("/funcionarios/{funcionarioId}/areas/")
	@Produces("application/json")
	public Response listarAreasDoFuncionario(@PathParam("funcionarioId") Long funcionarioId, @HeaderParam("token") String token) {
		validarToken(token);
		List<Area> areas = funcionarioAreaService.buscarAreasPorFuncionario(funcionarioId);
		return ok(areas);
	}

	@GET()
	@Path("/funcionarios/{funcionarioId}/areas/{id}/")
	@Produces("application/json")
	public Response obterFuncionarioArea(@PathParam("funcionarioId") Long funcionarioId, @PathParam("id") Long id, 
			@HeaderParam("token") String token) {
		validarToken(token);
		FuncionarioArea funcionarioArea = funcionarioAreaService.buscarPorId(id);
		return ok(funcionarioArea);
	}

	@POST()
	@Path("/funcionarios/{funcionarioId}/areas/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response criarFuncionarioArea(@PathParam("funcionarioId") Long funcionarioId, FuncionarioAreaTO funcionarioAreaTO, @HeaderParam("token") String token) {
		validarToken(token);
		FuncionarioArea funcionarioArea = new FuncionarioArea(funcionarioAreaTO);
		try {
			funcionarioArea = funcionarioAreaService.salvar(funcionarioArea);
			return created(funcionarioArea.toTO());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return internalServerError("Falha ao criar funcionarioArea: "+e.getMessage());			
		}
	}

	@PUT()
	@Path("/funcionarios/{funcionarioId}/areas/{id}/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response alterarFuncionarioArea(@PathParam("funcionarioId") Long funcionarioId, @PathParam("id") Long id, 
			FuncionarioAreaTO funcionarioAreaTO, @HeaderParam("token") String token) {
		validarToken(token);

		FuncionarioArea funcionarioArea = funcionarioAreaService.buscarPorId(id);
		if (funcionarioArea == null) {
			return notFound();
		}
		
		funcionarioArea.alterar(funcionarioAreaTO);
		try {
			funcionarioArea = funcionarioAreaService.salvar(funcionarioArea);
			return ok(funcionarioArea);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return internalServerError("Falha ao alterar funcionarioArea: "+e.getMessage());			
		}
	}

	@DELETE()
	@Path("/funcionarios/{funcionarioId}/areas/{id}/")
	@Produces("application/json")
	public Response removerFuncionarioArea(@PathParam("funcionarioId") Long funcionarioId, @PathParam("id") Long id, 
			@HeaderParam("token") String token) {
		validarToken(token);
		
		FuncionarioArea funcionarioArea = funcionarioAreaService.buscarPorId(id);
		if ( funcionarioArea == null) {
			return notFound();
		}
		
		funcionarioAreaService.excluir(funcionarioArea);
		return ok();
	}

}