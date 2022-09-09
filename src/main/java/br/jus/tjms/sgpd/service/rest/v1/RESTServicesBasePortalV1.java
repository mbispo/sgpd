package br.jus.tjms.sgpd.service.rest.v1;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

public abstract class RESTServicesBasePortalV1 {

	// TODO revisar métodos (GET/PUT/DELETE), pluralização, anti-patterns. 
	/*
	 * Artigos sobre o assunto:
	 * 
	 * Sobre como nomear os resources: 
	 * 	http://www.restapitutorial.com/lessons/restfulresourcenaming.html
	 * Sobre como modelar a API: 
	 * 	https://www.thoughtworks.com/pt/insights/blog/rest-api-design-resource-modeling
	 * 
	 * Mais aqui:
	 * 	http://www.restapitutorial.com/lessons/httpmethods.html
	 * 	http://www.restapitutorial.com/index.html
	 *  
	 */
	  
	/*
	 * TODO revisar métodos de regra de negócio, conforme abaixo:
	 * 
	 *  Pagamento de parcela de emprestimo consignado deve ser mapeada como um resource:
	 *  
	 *  Forma ERRADA (cria um subresource "pagar" no resource "lancamentoAgendado":
	 *  	POST	/funcionarios/1/lancamentosAgendados/1/pagar
	 *  
	 *  Forma correta (cria um resource "pagamento-lancamento-agendado" que representa uma transação ou regra de negócio):
	 *  	POST	/pagamento-lancamento-agendado/1
	 *  
	 */	
	
	
	public RESTServicesBasePortalV1() {
		super();
	}

	@GET()
	@Path("/versao/{token}")
	@Produces("application/json")
	public Response obterVersao(@PathParam("token") String token) {
		validarToken(token);
		String versao = "alfa";
		return ok(versao);
	}

	protected void validarToken(String token) throws WebApplicationException {
		// TODO autenticação/permissão para o método que chamou a validação de token, vide https://docs.jboss.org/resteasy/docs/2.2.0.GA/userguide/html/Securing_JAX-RS_and_RESTeasy.html
		// TODO autenticação usando o serviço de segurança com ApplicationInfo (autenticação retorna appInfo contendo token, permissão é feita usando token armazenado)

		// TODO validação de token de acesso
		// exemplo:
		// usuario+senha+url+aplicacao
		// marcos.bispoabcd123456/funcionario/1consultaHollerith
		// 8932475923KLTJWE9R8GUWE89RGUW89ERGUW89ERG98W
		
		if (!"abcd123456".equals(token)) {
			throw new WebApplicationException("Token inválido!");
		}
	}

	protected Response ok(Object entity) {
		CacheControl cc = new CacheControl();
		cc.setNoCache(true);
		cc.setMaxAge(0);	
		return Response.status(Status.OK).cacheControl(cc).entity(entity).build();
	}
	
	protected Response ok() {
		return Response.status(Status.OK).build();
	}
	
	protected Response internalServerError(String msg) {
		return Response.status(Status.INTERNAL_SERVER_ERROR).entity(msg).build();
	}
	
	protected Response forbidden() {
		return Response.status(Status.FORBIDDEN).build();
	}

	protected Response unauthorized() {
		return Response.status(Status.UNAUTHORIZED).build();
	}

	protected Response notImplemented() {
		return Response.status(Status.NOT_IMPLEMENTED).build();
	}
	
	protected Response notFound() {
		return Response.status(Status.NOT_FOUND).build();
	}
	
	protected Response notFound(String msg) {
		return Response.status(Status.NOT_FOUND).entity(msg).build();
	}
	
	protected Response found() {
		return Response.status(Status.FOUND).build();
	}

	protected Response found(Object o) {
		return Response.status(Status.FOUND).entity(o).build();
	}

	protected Response created() {
		return Response.status(Status.CREATED).build();
	}
	
	protected Response created(Object o) {
		return Response.status(Status.CREATED).entity(o).build();
	}
	
	protected Response noContent() {
		return Response.status(Status.NO_CONTENT).build();
	}
	
	protected Response noContent(String msg) {
		return Response.status(Status.NO_CONTENT).entity(msg).build();
	}
	
}