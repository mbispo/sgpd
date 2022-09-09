package br.jus.tjms.sgpd.service.rest.v1;

import java.util.ArrayList;
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

import br.jus.tjms.sgpd.entity.Indice;
import br.jus.tjms.sgpd.entity.ValorIndice;
import br.jus.tjms.sgpd.service.ServicesPortal;
import br.jus.tjms.sgpd.service.indiceservices.IndiceService;
import br.jus.tjms.sgpd.service.indiceservices.ValorIndiceService;
import br.jus.tjms.sgpd.service.rest.v1.to.IndiceTO;
import br.jus.tjms.sgpd.service.rest.v1.to.ValorIndiceTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @version 1.0
 * @created 11-dez-2015 18:15:46
 */
@Path("/rest/v1")
public class RESTServicesIndiceFinanceiroPortal extends RESTServicesBasePortalV1 implements ServicesPortal {

	private static final long serialVersionUID = -3452663179039466589L;
    private static Logger logger = LoggerFactory.getLogger(RESTServicesIndiceFinanceiroPortal.class);

	@EJB
	private IndiceService indiceService;
	
	@EJB
	private ValorIndiceService valorIndiceService;
	

	
	// Índices financeiros e valores históricos
	/*
	 * 
	 * Indice:
	 * 
	 * listarIndices								GET		/indices/ 
	 * pesquisarIndicesPorDescricao					GET		/pesquisas/indices/descricao/
	 * pesquisarIndicesPorSigla						GET		/pesquisas/indices/sigla/
	 * obterIndice									GET		/indices/1
	 * criarIndice									POST	/indices/...
	 * alterarIndice								PUT		/indices/1/...
	 * removerIndice								DELETE	/indices/1
	 * 
	 * 
	 * Valores:
	 * 
	 * listarValoresPorIndice						GET		/indices/1/valores/ 
	 * obterValorIndice								GET		/indices/1/valores/1
	 * criarValorIndice								POST	/indices/1/valores/...
	 * alterarValorIndice							PUT		/indices/1/valores/1/...
	 * removerValorIndice							DELETE	/indices/1/valores/1
	 * 
	 */
	
	@GET()
	@Path("/indices/")
	@Produces("application/json")
	public Response listarIndices(@HeaderParam("token") String token) {
		validarToken(token);
		List<Indice> indices = indiceService.buscarTodos();
		return ok(indicesToTO(indices));
	}
	
	@GET()
	@Path("/pesquisas/indices/descricao/{descricao}")
	@Produces("application/json")
	public Response pesquisarIndicesPorDescricao(@PathParam("descricao") String descricao, @HeaderParam("token") String token) {
		validarToken(token);
		List<Indice> indices = indiceService.buscarPorDescricao(descricao);
		return ok(indicesToTO(indices));
	}
	
	@GET()
	@Path("/pesquisas/indices/sigla/{sigla}")
	@Produces("application/json")
	public Response pesquisarIndicesPorSigla(@PathParam("sigla") String sigla, @HeaderParam("token") String token) {
		validarToken(token);
		List<Indice> indices = indiceService.buscarPorSigla(sigla);
		return ok(indicesToTO(indices));
	}

	@GET()
	@Path("/indices/{id}/")
	@Produces("application/json")
	public Response obterIndice(@PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);
		Indice indice = indiceService.buscarPorId(id);
		if (indice == null) {
			return notFound("Índice não encontrado!");
		}
		return ok(indice.toTO());
	}

	@POST()
	@Path("/indices/")
	@Consumes("application/json")
	@Produces("application/json")
	public Response criarIndice(IndiceTO indiceTO, @HeaderParam("token") String token) {
		validarToken(token);
		Indice indice = new Indice(indiceTO);
		try {
			indice = indiceService.salvar(indice);
			return created(indice.toTO());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return internalServerError("Falha ao criar índice: "+e.getMessage()); 						
		}
	}

	@PUT()
	@Path("/indices/{id}/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response alterarIndice(@PathParam("id") Long id, IndiceTO indiceTO, @HeaderParam("token") String token) {
		validarToken(token);
		Indice indice = indiceService.buscarPorId(id);
		if (indice == null) {
			return notFound("Índice não encontrado!");
		}
		indice.alterar(indiceTO);
		indice = indiceService.salvar(indice);
		return ok(indice.toTO());
	}
	
	@DELETE()
	@Path("/indices/{id}/")
	@Produces("application/json")
	public Response removerIndice(@PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);

		Indice indice = indiceService.buscarPorId(id);
		if (indice == null) {
			return notFound("Índice não encontrado!");
		}
		
		indiceService.excluir(indice);

		return ok();
	}

	@GET()
	@Path("/indices/{indiceId}/valores/")
	@Produces("application/json")
	public Response listarValoresPorIndice(@PathParam("indiceId") Long indiceId, @HeaderParam("token") String token) {
		validarToken(token);

		Indice indice = indiceService.buscarPorId(indiceId);
		if (indice == null) 
			return notFound("Índice não encontrado!");
		
		List<ValorIndice> valores = valorIndiceService.listarValoresDoIndice(indiceId);
		
		return ok(valoresIndiceToTO(valores));
	}

	@GET()
	@Path("/indices/{indiceId}/valores/{id}/")
	@Produces("application/json")
	public Response obterValorIndice(@PathParam("indiceId") Long indiceId, @PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);
		
		Indice indice = indiceService.buscarPorId(id);
		if (indice == null) 
			return notFound("Índice não encontrado!");
		
		ValorIndice v = valorIndiceService.buscarPorId(id);
		if (v == null) 
			return notFound("Valor não encontrado!");
		
		return ok(v.toTO());
	}

	@POST()
	@Path("/indices/{indiceId}/valores/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response criarValorIndice(@PathParam("indiceId") Long indiceId, ValorIndiceTO valorIndiceTO, @HeaderParam("token") String token) {
		validarToken(token);
		Indice indice = indiceService.buscarPorId(indiceId);
		if (indice == null) 
			return notFound("Índice não encontrado!");
		ValorIndice valor = new ValorIndice(valorIndiceTO);
		try {
			valor = valorIndiceService.salvar(valor);
			return created(valor.toTO());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return internalServerError("Falha ao criar valor: "+e.getMessage());
		}
	}

	@PUT()
	@Path("/indices/{indiceId}/valores/{id}/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response alterarValorIndice(@PathParam("indiceId") Long indiceId, @PathParam("id") Long id, 
			ValorIndiceTO valorIndiceTO, @HeaderParam("token") String token) {
		validarToken(token);

		Indice indice = indiceService.buscarPorId(indiceId);
		if (indice == null) 
			return notFound("Índice não encontrado!");
		
		ValorIndice v = valorIndiceService.buscarPorId(id);
		if (v == null) 
			return notFound("Valor não encontrado!");

		v.alterar(valorIndiceTO);
		v = valorIndiceService.salvar(v);
		return ok(v.toTO());
	}

	@DELETE()
	@Path("/indices/{indiceId}/valores/{id}/")
	@Produces("application/json")
	public Response removerValorIndice(@PathParam("indiceId") Long indiceId, @PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);

		Indice indice = indiceService.buscarPorId(indiceId);
		if (indice == null) 
			return notFound("Índice não encontrado!");
		
		ValorIndice v = valorIndiceService.buscarPorId(id);
		if (v == null) 
			return notFound("Valor não encontrado!");
		
		valorIndiceService.excluir(v);
		return ok();
	}
	
	private List<IndiceTO> indicesToTO(List<Indice> indices) {
        List<IndiceTO> indicesToTO = new ArrayList<>();
        if (indices != null) {
			for (Indice i : indices) {
                indicesToTO.add(i.toTO());
			}
		}
		return indicesToTO;
	}
	
	private List<ValorIndiceTO> valoresIndiceToTO(List<ValorIndice> valores) {
        List<ValorIndiceTO> valoresIndiceToTO = new ArrayList<>();
        if (valores != null) {
			for (ValorIndice v : valores) {
                valoresIndiceToTO.add(v.toTO());
			}
		}
		return valoresIndiceToTO;
	}	
	
}