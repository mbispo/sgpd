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

import br.jus.tjms.sgpd.entity.Area;
import br.jus.tjms.sgpd.entity.AreaHistoricoClassificacaoNivelTipo;
import br.jus.tjms.sgpd.entity.AreaHistoricoNome;
import br.jus.tjms.sgpd.entity.AreaLocalidade;
import br.jus.tjms.sgpd.entity.AreaResponsavel;
import br.jus.tjms.sgpd.entity.AreaSuperior;
import br.jus.tjms.sgpd.entity.Localidade;
import br.jus.tjms.sgpd.entity.TurnoArea;
import br.jus.tjms.sgpd.service.ServicesPortal;
import br.jus.tjms.sgpd.service.dadosbasicosservices.LocalidadeService;
import br.jus.tjms.sgpd.service.estruturaadministrativaservices.AreaHistoricoClassificacaoNivelTipoService;
import br.jus.tjms.sgpd.service.estruturaadministrativaservices.AreaHistoricoNomeService;
import br.jus.tjms.sgpd.service.estruturaadministrativaservices.AreaLocalidadeService;
import br.jus.tjms.sgpd.service.estruturaadministrativaservices.AreaResponsavelService;
import br.jus.tjms.sgpd.service.estruturaadministrativaservices.AreaService;
import br.jus.tjms.sgpd.service.estruturaadministrativaservices.AreaSuperiorService;
import br.jus.tjms.sgpd.service.estruturaadministrativaservices.TurnoAreaService;
import br.jus.tjms.sgpd.service.funcionarioservices.FuncionarioService;
import br.jus.tjms.sgpd.service.rest.v1.to.AreaHistoricoClassificacaoNivelTipoTO;
import br.jus.tjms.sgpd.service.rest.v1.to.AreaHistoricoNomeTO;
import br.jus.tjms.sgpd.service.rest.v1.to.AreaLocalidadeTO;
import br.jus.tjms.sgpd.service.rest.v1.to.AreaResponsavelTO;
import br.jus.tjms.sgpd.service.rest.v1.to.AreaSuperiorTO;
import br.jus.tjms.sgpd.service.rest.v1.to.AreaTO;
import br.jus.tjms.sgpd.service.rest.v1.to.TurnoAreaTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @version 1.0
 * @created 11-dez-2015 18:15:46
 */
@Path("/rest/v1")
public class RESTServicesEstruturaAdministrativaPortal extends RESTServicesBasePortalV1 implements ServicesPortal {

	private static final long serialVersionUID = -157097789268734721L;
    private static Logger logger = LoggerFactory.getLogger(RESTServicesEstruturaAdministrativaPortal.class);
	
	@EJB
	private FuncionarioService funcionarioService;
	
	@EJB
	private AreaService areaService;
	
	@EJB
	private AreaHistoricoNomeService areaHistoricoNomeService;
	
	@EJB
	private AreaHistoricoClassificacaoNivelTipoService areaHistoricoClassificacaoNivelTipoService;
	
	@EJB
	private LocalidadeService localidadeService;
	
	@EJB
	private AreaLocalidadeService areaLocalidadeService;
	
	@EJB
	private AreaResponsavelService areaResponsavelService;
	
	@EJB
	private AreaSuperiorService areaSuperiorService;
	
	@EJB
	private TurnoAreaService turnoAreaService;
	
	// estrutura administrativa
	/*
	 * Area:
	 * listarAreas 									GET		/areas/
	 * pesquisarAreasPorNome						GET		/pesquisas/areas/nome/
	 * obterArea  									GET		/areas/1
	 * criarArea    								POST 	/areas/...
	 * alterarArea  								PUT 	/areas/1/...
	 * removerArea  								DELETE 	/areas/1
 
	 * AreaHistoricoNome:
	 * listarHistoricoNomeDaArea					GET		/areas/1/historicos-nome/
	 * obterHistoricoNomeDaArea						GET		/areas/1/historicos-nome/1
	 * criarHistoricoNomeDaArea						POST	/areas/1/historicos-nome/...
	 * alterarHistoricoNomeDaArea					PUT		/areas/1/historicos-nome/1/...
	 * removerHistoricoNomeDaArea					DELETE	/areas/1/historicos-nome/1
	 * 
	 * AreaHistoricoClassificacaoNivelTipo:
	 * listarHistoricoClassificacaoNivelTipoDaArea		GET		/areas/1/historicos-classificacao-nivel-tipo/
	 * obterHistoricoClassificacaoNivelTipoDaArea		GET		/areas/1/historicos-classificacao-nivel-tipo/1
	 * criarHistoricoClassificacaoNivelTipoDaArea		POST	/areas/1/historicos-classificacao-nivel-tipo/...
	 * alterarHistoricoClassificacaoNivelTipoDaArea		PUT		/areas/1/historicos-classificacao-nivel-tipo/1/...
	 * removerHistoricoClassificacaoNivelTipoDaArea		DELETE	/areas/1/historicos-classificacao-nivel-tipo/1
	 * 
	 * TODO
	 * ClassificacaoAreaNivelTipo
	 * ClassificacaoAreaNivel
	 * 
	 * AreaLocalidade:
	 * listarLocalidadesDaArea						GET		/areas/1/localidades/
	 * obterAreaLocalidade							GET		/areas/1/localidades/1
	 * criarAreaLocalidade							POST	/areas/1/localidades/...
	 * alterarAreaLocalidade						PUT		/areas/1/localidades/1/...
	 * removerAreaLocalidade						DELETE	/areas/1/localidades/1
	 * 
	 * AreaResponsavel:
	 * listarAreaResponsavel						GET		/areas/1/responsaveis/
	 * obterAreaResponsavel							GET		/areas/1/responsaveis/1
	 * criarAreaResponsavel							POST	/areas/1/responsaveis/...
	 * alterarAreaResponsavel						PUT		/areas/1/responsaveis/1/...
	 * removerAreaResponsavel						DELETE	/areas/1/responsaveis/1
	 *  
	 * AreaSuperior:
	 * listarAreaSuperior							GET		/areas/1/areas-superiores/
	 * obterAreaSuperior							GET		/areas/1/areas-superiores/1
	 * criarAreaSuperior							POST	/areas/1/areas-superiores/...
	 * alterarAreaSuperior							PUT		/areas/1/areas-superiores/1/...
	 * removerAreaSuperior							DELETE	/areas/1/areas-superiores/1
	 *  
	 * TurnoArea:
	 * listarTurnosDaArea							GET		/areas/1/turnos/
	 * obterTurnoArea								GET		/areas/1/turnos/1
	 * criarTurnoArea								POST	/areas/1/turnos/...
	 * alterarTurnoArea								PUT		/areas/1/turnos/1/...
	 * removerTurnoArea								DELETE	/areas/1/turnos/1
	 *  
	 */

	@GET()
	@Path("/areas/")
	@Produces("application/json")
	public Response listarAreas(@HeaderParam("token") String token) {
		validarToken(token);
		List<Area> areas = areaService.buscarTodos();
		return ok(areas);
	}

	@GET()
	@Path("/pesquisas/areas/nome/{nome}")
	@Produces("application/json")
	public Response pesquisarAreasPorNome(@PathParam("nome") String nome, @HeaderParam("token") String token) {
		validarToken(token);
		List<Area> areas = areaService.buscarPorNome(nome);
		return ok(areas);
	}

	@GET()
	@Path("/areas/{id}/")
	@Produces("application/json")
	public Response obterArea(@PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);
		Area area = areaService.buscarPorId(id);
		return ok(area);
	}

	@POST()
	@Path("/areas/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response criarArea(AreaTO areaTO, @HeaderParam("token") String token) {
		validarToken(token);
		
		Area area = new Area(areaTO);
		
		try {
			area = areaService.salvar(area);
			return created(area);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return internalServerError("Falha ao criar área: "+e.getMessage()); 			
		}
	}

	@PUT()
	@Path("/areas/{id}/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response alterarArea(@PathParam("id") Long id, AreaTO areaTO, @HeaderParam("token") String token) {
		validarToken(token);

		Area area = areaService.buscarPorId(id);
		if (area == null) {
			return notFound();
		}
		
		area.alterar(areaTO);
		area = areaService.salvar(area);
		return ok(area);
	}

	@DELETE()
	@Path("/areas/{id}/")
	@Produces("application/json")
	public Response removerArea(@PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);

		Area area = areaService.buscarPorId(id);
		if (area == null) {
			return notFound();
		}
		
		areaService.excluir(area);
		return ok();
	}
	
	@GET()
	@Path("/areas/{areaId}/historicos-nome/")
	@Produces("application/json")
	public Response listarHistoricoNomeDaArea(@PathParam("areaId") Long areaId, @HeaderParam("token") String token) {
		validarToken(token);
		List<AreaHistoricoNome> historicosNome = areaHistoricoNomeService.buscarPorArea(areaId);
		return ok(historicosNome);
	}

	@GET()
	@Path("/areas/{areaId}/historicos-nome/{id}/")
	@Produces("application/json")
	public Response obterHistoricoNomeDaArea(@PathParam("areaId") Long areaId, @PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);
		AreaHistoricoNome historicoNome = areaHistoricoNomeService.buscarPorId(id);
		return ok(historicoNome);
	}

	@POST()
	@Path("/areas/{areaId}/historicos-nome/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response criarHistoricoNomeDaArea(@PathParam("areaId") Long areaId, AreaHistoricoNomeTO areaHistoricoNomeTO, @HeaderParam("token") String token) {
		validarToken(token);
		
		Area area = areaService.buscarPorId(areaId);
		if (area == null) {
			return notFound();
		}
		
		AreaHistoricoNome historicoNome = new AreaHistoricoNome(area, areaHistoricoNomeTO);
		historicoNome = areaHistoricoNomeService.salvar(historicoNome);
		return ok(historicoNome);
	}

	@PUT()
	@Path("/areas/{areaId}/historicos-nome/{id}/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response alterarHistoricoNomeDaArea(@PathParam("areaId") Long areaId, @PathParam("id") Long id, AreaHistoricoNomeTO areaHistoricoNomeTO, @HeaderParam("token") String token) {
		validarToken(token);

		Area area = areaService.buscarPorId(areaId);
		AreaHistoricoNome historicoNome = areaHistoricoNomeService.buscarPorId(id);
		if (area == null || historicoNome == null) {
			return notFound();
		}
		
		historicoNome.alterar(area, areaHistoricoNomeTO);
		historicoNome = areaHistoricoNomeService.salvar(historicoNome);
		return ok(historicoNome);
	}
	
	@DELETE()
	@Path("/areas/{areaId}/historicos-nome/{id}/")
	@Produces("application/json")
	public Response removerHistoricoNomeDaArea(@PathParam("areaId") Long areaId, @PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);

		AreaHistoricoNome historicoNome = areaHistoricoNomeService.buscarPorId(id);
		if (historicoNome == null) {
			return notFound();
		}
		
		areaHistoricoNomeService.excluir(historicoNome);
		return ok();
	}

	@GET()
	@Path("/areas/{areaId}/historicos-classificacao-nivel-tipo/")
	@Produces("application/json")
	public Response listarHistoricoClassificacaoNivelTipoDaArea(@PathParam("areaId") Long areaId,
			@HeaderParam("token") String token) {
		validarToken(token);
		List<AreaHistoricoClassificacaoNivelTipo> historicosClassificacaoNivelTipo = areaHistoricoClassificacaoNivelTipoService.buscarPorArea(areaId);
		return ok(historicosClassificacaoNivelTipo);
	}
	
	@GET()
	@Path("/areas/{areaId}/historicos-classificacao-nivel-tipo/{id}/")
	@Produces("application/json")
	public Response obterHistoricoClassificacaoNivelTipoDaArea(@PathParam("areaId") Long areaId, @PathParam("id") Long id,
			@HeaderParam("token") String token) {
		validarToken(token);
		AreaHistoricoClassificacaoNivelTipo areaHistoricoClassificacaoNivelTipo = areaHistoricoClassificacaoNivelTipoService.buscarPorId(id);
		return ok(areaHistoricoClassificacaoNivelTipo);
	}

	@POST()
	@Path("/areas/{areaId}/historicos-classificacao-nivel-tipo/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response criarHistoricoClassificacaoNivelTipoDaArea(@PathParam("areaId") Long areaId, AreaHistoricoClassificacaoNivelTipoTO areaHistoricoClassificacaoNivelTipoTO,
			@HeaderParam("token") String token) {
		validarToken(token);
		
		Area area = areaService.buscarPorId(areaId);
		if (area == null) {
			return notFound();
		}
		
		AreaHistoricoClassificacaoNivelTipo areaHistoricoClassificacaoNivelTipo = new AreaHistoricoClassificacaoNivelTipo(area, areaHistoricoClassificacaoNivelTipoTO);
		areaHistoricoClassificacaoNivelTipo = areaHistoricoClassificacaoNivelTipoService.salvar(areaHistoricoClassificacaoNivelTipo);
		return ok(areaHistoricoClassificacaoNivelTipo);
	}

	@PUT()
	@Path("/areas/{areaId}/historicos-classificacao-nivel-tipo/{id}/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response alterarHistoricoClassificacaoNivelTipoDaArea(@PathParam("areaId") Long areaId, @PathParam("id") Long id,
			AreaHistoricoClassificacaoNivelTipoTO areaHistoricoClassificacaoNivelTipoTO,
			@HeaderParam("token") String token) {
		validarToken(token);

		Area area = areaService.buscarPorId(areaId);
		AreaHistoricoClassificacaoNivelTipo areaHistoricoClassificacaoNivelTipo = areaHistoricoClassificacaoNivelTipoService.buscarPorId(id);
		if (area == null || areaHistoricoClassificacaoNivelTipo == null) {
			return notFound();
		}
		
		areaHistoricoClassificacaoNivelTipo.alterar(area, areaHistoricoClassificacaoNivelTipoTO);
		areaHistoricoClassificacaoNivelTipo = areaHistoricoClassificacaoNivelTipoService.salvar(areaHistoricoClassificacaoNivelTipo);
		return ok(areaHistoricoClassificacaoNivelTipo);
	}

	@DELETE()
	@Path("/areas/{areaId}/historicos-classificacao-nivel-tipo/{id}/")
	@Produces("application/json")
	public Response removerHistoricoClassificacaoNivelTipoDaArea(@PathParam("areaId") Long areaId, @PathParam("id") Long id,
			@HeaderParam("token") String token) {
		validarToken(token);

		AreaHistoricoClassificacaoNivelTipo areaHistoricoClassificacaoNivelTipo = areaHistoricoClassificacaoNivelTipoService.buscarPorId(id);
		if (areaHistoricoClassificacaoNivelTipo == null) {
			return notFound();
		}
		
		areaHistoricoClassificacaoNivelTipoService.excluir(areaHistoricoClassificacaoNivelTipo);
		return ok();
	}

	@GET()
	@Path("/areas/{areaId}/localidades/")
	@Produces("application/json")
	public Response listarLocalidadesDaArea(@PathParam("areaId") Long areaId, @HeaderParam("token") String token) {
		validarToken(token);
		List<Localidade> localidades = areaLocalidadeService.buscarLocalidadePorArea(areaId);
		return ok(localidades);
	}

	@GET()
	@Path("/areas/{areaId}/localidades/{id}/")
	@Produces("application/json")
	public Response obterAreaLocalidade(@PathParam("areaId") Long areaId, @PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);
		AreaLocalidade areaLocalidade = areaLocalidadeService.buscarPorId(id); 
		return ok(areaLocalidade);
	}

	@POST()
	@Path("/areas/{id}/localidades/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response criarAreaLocalidade(@PathParam("id") Long id, AreaLocalidadeTO areaLocalidadeTO, @HeaderParam("token") String token) {
		validarToken(token);
		AreaLocalidade areaLocalidade = new AreaLocalidade(areaLocalidadeTO);
		areaLocalidade = areaLocalidadeService.salvar(areaLocalidade);
		return ok(areaLocalidade);
	}

	@PUT()
	@Path("/areas/{areaId}/localidades/{id}/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response alterarAreaLocalidade(@PathParam("areaId") Long areaId, @PathParam("id") Long id, AreaLocalidadeTO areaLocalidadeTO, @HeaderParam("token") String token) {
		validarToken(token);

		AreaLocalidade areaLocalidade = areaLocalidadeService.buscarPorId(id); 
		if (areaLocalidade == null) {
			return notFound();
		}
		
		areaLocalidade.alterar(areaLocalidadeTO);
		areaLocalidade = areaLocalidadeService.salvar(areaLocalidade);
		return ok(areaLocalidade);
	}

	@DELETE()
	@Path("/areas/{areaId}/localidades/{id}/")
	@Produces("application/json")
	public Response removerAreaLocalidade(@PathParam("areaId") Long areaId, @PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);

		AreaLocalidade areaLocalidade = areaLocalidadeService.buscarPorId(id); 
		if (areaLocalidade == null) {
			return notFound();
		}
		
		areaLocalidadeService.excluir(areaLocalidade);
		return ok();
	}

	@GET()
	@Path("/areas/{id}/responsaveis/")
	@Produces("application/json")
	public Response listarAreaResponsavel(@PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);
		List<AreaResponsavel> areaResponsaveis = areaResponsavelService.buscarTodos();
		return ok(areaResponsaveis);
	}

	@GET()
	@Path("/areas/{areaId}/responsaveis/{id}/")
	@Produces("application/json")
	public Response obterAreaResponsavel(@PathParam("areaId") Long areaId, @PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);
		AreaResponsavel areaResponsavel = areaResponsavelService.buscarPorId(id);
		return ok(areaResponsavel);
	}

	@POST()
	@Path("/areas/{areaId}/responsaveis/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response criarAreaResponsavel(@PathParam("areaId") Long areaId, AreaResponsavelTO areaResponsavelTO, @HeaderParam("token") String token) {
		validarToken(token);
		
		Area area = areaService.buscarPorId(areaId);
		if (area == null) {
			return notFound();
		}
		
		AreaResponsavel areaResponsavel = new AreaResponsavel(area, areaResponsavelTO);
		areaResponsavel = areaResponsavelService.salvar(areaResponsavel);
		return ok(areaResponsavel);
	}

	@PUT()
	@Path("/areas/{areaId}/responsaveis/{id}/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response alterarAreaResponsavel(@PathParam("areaId") Long areaId, @PathParam("id") Long id, AreaResponsavelTO areaResponsavelTO, 
			@HeaderParam("token") String token) {
		validarToken(token);

		Area area = areaService.buscarPorId(areaId);
		AreaResponsavel areaResponsavel = areaResponsavelService.buscarPorId(id);
		if (area == null || areaResponsavel == null) {
			return notFound();
		}
		
		areaResponsavel.alterar(area, areaResponsavelTO);
		areaResponsavel = areaResponsavelService.salvar(areaResponsavel);
		return ok(areaResponsavel);
	}

	@DELETE()
	@Path("/areas/{areaId}/responsaveis/{id}/")
	@Produces("application/json")
	public Response removerAreaResponsavel(@PathParam("areaId") Long areaId, @PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);

		AreaResponsavel areaResponsavel = areaResponsavelService.buscarPorId(id);
		if (areaResponsavel == null) {
			return notFound();
		}
		
		areaResponsavelService.excluir(areaResponsavel);
		return ok();
	}

	@GET()
	@Path("/areas/{id}/areas-superiores/")
	@Produces("application/json")
	public Response listarAreaSuperior(@PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);
		List<AreaSuperior> areasSuperiores = areaSuperiorService.buscarTodos();
		return ok(areasSuperiores);
	}

	@GET()
	@Path("/areas/{areaId}/areas-superiores/{id}/")
	@Produces("application/json")
	public Response obterAreaSuperior(@PathParam("areaId") Long areaId, @PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);
		AreaSuperior areaSuperior = areaSuperiorService.buscarPorId(id);
		return ok(areaSuperior);
	}

	@POST()
	@Path("/areas/{areaId}/areas-superiores/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response criarAreaSuperior(@PathParam("areaId") Long areaId, AreaSuperiorTO areaSuperiorTO, 
			@HeaderParam("token") String token) {
		validarToken(token);
		
		Area area = areaService.buscarPorId(areaId);
		if (area == null) {
			return notFound();
		}
		
		AreaSuperior areaSuperior = new AreaSuperior(area, areaSuperiorTO);
		
		try {
			areaSuperior = areaSuperiorService.salvar(areaSuperior);
			return created(areaSuperior);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return internalServerError("Falha ao criar área superior: "+e.getMessage()); 			
		}
	}

	@PUT()
	@Path("/areas/{areaId}/areas-superiores/{id}/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response alterarAreaSuperior(@PathParam("areaId") Long areaId, @PathParam("id") Long id, 
			AreaSuperiorTO areaSuperiorTO, @HeaderParam("token") String token) {
		validarToken(token);

		Area area = areaService.buscarPorId(areaId);
		AreaSuperior areaSuperior = areaSuperiorService.buscarPorId(id);
		if (area == null || areaSuperior == null) {
			return notFound();
		}
		
		areaSuperior.alterar(area, areaSuperiorTO);
		areaSuperior = areaSuperiorService.salvar(areaSuperior);
		return ok(areaSuperior);
	}

	@DELETE()
	@Path("/areas/{areaId}/areas-superiores/{id}/")
	@Produces("application/json")
	public Response removerAreaSuperior(@PathParam("areaId") Long areaId, @PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);

		AreaSuperior areaSuperior = areaSuperiorService.buscarPorId(id);
		if (areaSuperior == null) {
			return notFound();
		}
		
		areaSuperiorService.excluir(areaSuperior);
		return ok();
	}

	@GET()
	@Path("/areas/{areaId}/turnos/")
	@Produces("application/json")
	public Response listarTurnosDaArea(@PathParam("areaId") Long areaId, @HeaderParam("token") String token) {
		validarToken(token);
		List<TurnoArea> turnosArea = turnoAreaService.buscarPorArea(areaId);
		return ok(turnosArea);
	}

	@GET()
	@Path("/areas/{areaId}/turnos/{id}/")
	@Produces("application/json")
	public Response obterTurnoArea(@PathParam("areaId") Long areaId, @PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);
		TurnoArea turnoArea = turnoAreaService.buscarPorId(id);
		return ok(turnoArea);
	}

	@POST()
	@Path("/areas/{areaId}/turnos/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response criarTurnoArea(@PathParam("areaId") Long areaId, TurnoAreaTO turnoAreaTO, @HeaderParam("token") String token) {
		validarToken(token);
		
		Area area = areaService.buscarPorId(areaId);
		if (area == null) {
			return notFound();
		}
		
		TurnoArea turnoArea = new TurnoArea(area, turnoAreaTO);
		turnoArea = turnoAreaService.salvar(turnoArea);
		return ok(turnoArea);
	}

	@PUT()
	@Path("/areas/{areaId}/turnos/{id}/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response alterarTurnoArea(@PathParam("areaId") Long areaId, @PathParam("id") Long id, TurnoAreaTO turnoAreaTO, @HeaderParam("token") String token) {
		validarToken(token);

		Area area = areaService.buscarPorId(areaId);
		TurnoArea turnoArea = turnoAreaService.buscarPorId(id);
		if (area == null || turnoArea == null) {
			return notFound();
		}
		
		turnoArea.alterar(area, turnoAreaTO);
		turnoArea = turnoAreaService.salvar(turnoArea);
		return ok(turnoArea);
	}

	@DELETE()
	@Path("/areas/{areaId}/turnos/{id}/")
	@Produces("application/json")
	public Response removerTurnoArea(@PathParam("areaId") Long areaId, @PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);
		
		TurnoArea turnoArea = turnoAreaService.buscarPorId(id);
		if (turnoArea == null) {
			return notFound();
		}
		
		turnoAreaService.excluir(turnoArea);
		return ok();
	}

}