package br.jus.tjms.sgpd.service.rest.v1;

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

import br.jus.tjms.sgpd.entity.SolicitacaoAdicionalQualificacao;
import br.jus.tjms.sgpd.service.ServicesPortal;
import br.jus.tjms.sgpd.service.adicionalqualificacaoservices.AdicionalQualificacaoService;
import br.jus.tjms.sgpd.service.rest.v1.to.AdicionalQualificacaoTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @version 1.0
 * @created 11-dez-2015 18:15:46
 */
@Path("/rest/v1")
public class RESTServicesAdicionalQualificacao extends RESTServicesBasePortalV1 implements ServicesPortal {

	private static final long serialVersionUID = -2596289319841295299L;
    private static Logger logger = LoggerFactory.getLogger(RESTServicesAdicionalQualificacao.class);
	
	@EJB
	private AdicionalQualificacaoService adicionalQualificacaoService;
	
	// adicionalQualificacaos administrativos
	/* 
	 * listarAdicionaisQualificacao					    GET		/adicional-qualificacao/
	 * obterAdicionalQualificacao						GET		/adicional-qualificacao/1
	 * criarAdicionalQualificacao						POST	/adicional-qualificacao/...
	 * alterarAdicionalQualificacao						PUT		/adicional-qualificacao/1/...
	 * removerAdicionalQualificacao						DELETE	/adicional-qualificacao/1
	 * anexarDocumentoAoAdicionalQualificacao			POST	/adicional-qualificacao/1/documento/...
	 * 
	 */

	@GET()
	@Path("/adicional-qualificacao/")
	@Produces("application/json")
	public Response listarAdicionaisQualificacao(@HeaderParam("token") String token) {
		validarToken(token);
		return ok(adicionalQualificacaoService.buscarTodos());
	}
	
	@GET()
	@Path("/adicional-qualificacao/{id}/")
	@Produces("application/json")
	public Response obterAdicionalQualificacao(@PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);
		SolicitacaoAdicionalQualificacao o = adicionalQualificacaoService.buscarPorId(id);
		return ok(o);
	}

	@POST()
	@Path("/adicional-qualificacao/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response criarAdicionalQualificacao(AdicionalQualificacaoTO adicionalQualificacaoTO, @HeaderParam("token") String token) {
		validarToken(token);
		SolicitacaoAdicionalQualificacao adicionalQualificacao = new SolicitacaoAdicionalQualificacao(adicionalQualificacaoTO);
		try {
			adicionalQualificacao = adicionalQualificacaoService.salvar(adicionalQualificacao);
			return created(adicionalQualificacao);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return internalServerError("Falha ao criar adicionalQualificacao administrativo: "+e.getMessage()); 						
		}
	}

	@PUT()
	@Path("/adicional-qualificacao/{id}/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response alterarAdicionalQualificacao(@PathParam("id") Long id, AdicionalQualificacaoTO adicionalQualificacaoTO, @HeaderParam("token") String token) {
		validarToken(token);
		SolicitacaoAdicionalQualificacao adicionalQualificacao = adicionalQualificacaoService.buscarPorId(id);
		if (adicionalQualificacao == null) {
			return notFound();
		}
		adicionalQualificacao.alterar(adicionalQualificacaoTO);
		adicionalQualificacaoService.salvar(adicionalQualificacao);
		return ok(adicionalQualificacao);
	}

	@DELETE()
	@Path("/adicional-qualificacao/{id}/")
	@Produces("application/json")
	public Response removerAdicionalQualificacao(@PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);
		SolicitacaoAdicionalQualificacao adicionalQualificacao = adicionalQualificacaoService.buscarPorId(id);
		if (adicionalQualificacao == null) {
			return notFound();
		}
		
		adicionalQualificacaoService.excluir(adicionalQualificacao);
		return ok();
	}

}