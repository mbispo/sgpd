package br.jus.tjms.sgpd.service.rest.v1;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import br.jus.tjms.sgpd.service.ServicesPortal;
import br.jus.tjms.sgpd.service.funcionarioservices.FuncionarioService;

/**
 * @version 1.0
 * @created 11-dez-2015 18:15:46
 */
public class RESTServicesPortal extends RESTServicesBasePortalV1 implements ServicesPortal {

	private static final long serialVersionUID = 6637364790309885684L;
	
	@EJB
	private FuncionarioService funcionarioService;
	
	@GET()
	@Path("/entidades/{classe}/{id}")
	@Produces("application/json")
	public Response obterEntidadePorId(@PathParam("classe") String classe, @PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);
		Object o = "há!";
		// TODO deve retornar instancia de qualquer entidade pelo id+classe
		return ok(o);
	}

}