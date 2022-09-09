package br.jus.tjms.sgpd.service.rest.v1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;

import org.apache.commons.io.IOUtils;
import org.jboss.resteasy.annotations.GZIP;
import org.jboss.resteasy.plugins.providers.multipart.InputPart;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;

import br.jus.tjms.sgpd.entity.AtoAdministrativo;
import br.jus.tjms.sgpd.service.ServicesPortal;
import br.jus.tjms.sgpd.service.atoadministrativoservices.AtoAdministrativoService;
import br.jus.tjms.sgpd.service.rest.v1.to.AtoAdministrativoTO;
import br.jus.tjms.sgpd.util.RESTUtilz;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @version 1.0
 * @created 11-dez-2015 18:15:46
 */
@Path("/rest/v1")
public class RESTServicesAtoAdministrativoPortal extends RESTServicesBasePortalV1 implements ServicesPortal {

	private static final long serialVersionUID = -2596289319841295299L;
    private static Logger logger = LoggerFactory.getLogger(RESTServicesAtoAdministrativoPortal.class);

	@EJB
	private AtoAdministrativoService atoAdministrativoService;
	
	// atos administrativos
	/* 
	 * listarAtosAdministrativos					GET		/atos/
	 * obterAtoAdministrativo						GET		/atos/1
	 * criarAtoAdministrativo						POST	/atos/...
	 * alterarAtoAdministrativo						PUT		/atos/1/...
	 * removerAtoAdministrativo						DELETE	/atos/1
	 * anexarDocumentoAoAtoAdministrativo			POST	/atos/1/documento/...
	 * 
	 */

	@GET()
	@Path("/atos/")
	@Produces("application/json")
	public Response listarAtosAdministrativos(@HeaderParam("token") String token) {
		validarToken(token);
		return ok(toTO(atoAdministrativoService.buscarTodos()));
	}
	
	@GET()
	@Path("/pesquisas/atos/numero/{numero}")
	@Produces("application/json")
	public Response pesquisarAtosAdministrativosPorNumero(@PathParam("numero") String numero, @HeaderParam("token") String token) {
		validarToken(token);
		List<AtoAdministrativo> atosPorNumero = atoAdministrativoService.buscarPorNumero(numero);
		return ok(toTO(atosPorNumero));
	}	

	@GET()
	@Path("/atos/{id}/")
	@Produces("application/json")
	public Response obterAtoAdministrativo(@PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);
		AtoAdministrativo o = atoAdministrativoService.buscarPorId(id);
		return ok(toTO(o));
	}

	@POST()
	@Path("/atos/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response criarAtoAdministrativo(AtoAdministrativoTO atoAdministrativoTO, @HeaderParam("token") String token) {
		validarToken(token);
		AtoAdministrativo ato = new AtoAdministrativo(atoAdministrativoTO);
		try {
			ato = atoAdministrativoService.salvar(ato);
			return created(ato);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return internalServerError("Falha ao criar ato administrativo: "+e.getMessage()); 						
		}
	}

	@PUT()
	@Path("/atos/{id}/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response alterarAtoAdministrativo(@PathParam("id") Long id, AtoAdministrativoTO atoAdministrativoTO, @HeaderParam("token") String token) {
		validarToken(token);
		AtoAdministrativo ato = atoAdministrativoService.buscarPorId(id);
		if (ato == null) {
			return notFound();
		}
		ato.alterar(atoAdministrativoTO);
		atoAdministrativoService.salvar(ato);
		return ok(ato);
	}

	@DELETE()
	@Path("/atos/{id}/")
	@Produces("application/json")
	public Response removerAtoAdministrativo(@PathParam("id") Long id, @HeaderParam("token") String token) {
		validarToken(token);
		AtoAdministrativo ato = atoAdministrativoService.buscarPorId(id);
		if (ato == null) {
			return notFound();
		}
		
		atoAdministrativoService.excluir(ato);
		return ok();
	}
	
	@POST
	@Path("/atos/{id}/documento/")
	@Consumes("multipart/form-data")
	public Response anexarDocumentoAoAtoAdministrativo(MultipartFormDataInput input, @PathParam("id") Long atoAdministrativoId, 
			@HeaderParam("token") String token) {
		
		validarToken(token);
		
		String nomeDoArquivo = "";

		Map<String, List<InputPart>> uploadForm = input.getFormDataMap();
		List<InputPart> inputParts = uploadForm.get("uploadedFile");

		// itera nos arquivos enviados
		for (InputPart inputPart : inputParts) {

		 try {

			MultivaluedMap<String, String> header = inputPart.getHeaders();
			nomeDoArquivo = RESTUtilz.getFileName(header);

			//convert the uploaded file to inputstream
			InputStream inputStream = inputPart.getBody(InputStream.class,null);

			byte [] bytes = IOUtils.toByteArray(inputStream);
			
			// TODO chamada ao atoAdministrativoService.anexarArquivoAoAtoAdministrativo(bytes, filename)
			
			atoAdministrativoService.anexarDocumento(bytes,nomeDoArquivo,atoAdministrativoId);
			
		  } catch (IOException e) {
			logger.error(e.getMessage(), e);
		  }

		}

		return ok("OK: " + nomeDoArquivo);

	}	
	
	@GET()
	@Path("/atos/{atoId}/documento/{documentoId}")
	@Produces("application/octet-stream")
	@GZIP()
	public Response obterDocumentoDoAtoAdministrativo(@PathParam("atoId") Long atoAdministrativoId, 
			@PathParam("documentoId") Long documentoId, @HeaderParam("token") String token) {
		
		validarToken(token);

		// TODO chamada de serviço para pegar conteúdo do documento e nome do arquivo
		final byte[] conteudo = {'v','a','z','i','o'};
		String nomeArquivo = "";

		StreamingOutput stream = new StreamingOutput() {
			public void write(OutputStream output) throws IOException, WebApplicationException {
				try {
					output.write(conteudo);
				} catch (Exception e) {
					throw new WebApplicationException(e);
				}
			}
		};

		return Response.ok(stream, MediaType.APPLICATION_OCTET_STREAM)
				.header("content-disposition", "attachment; filename=\"" + nomeArquivo + "\"")
				.header("Content-Length", conteudo.length)
				.build();		
	}
	
	private AtoAdministrativoTO toTO(AtoAdministrativo ato) {
		return ato.toTO();
	}
	
	private List<AtoAdministrativoTO> toTO(List<AtoAdministrativo> atos) {
		if (atos!=null) {
			List<AtoAdministrativoTO> tos = new ArrayList<AtoAdministrativoTO>();
			for (AtoAdministrativo ato : atos) {
				tos.add(ato.toTO());
			}
		}
		return null;
	}

}