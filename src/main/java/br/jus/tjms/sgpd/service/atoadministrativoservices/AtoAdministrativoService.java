package br.jus.tjms.sgpd.service.atoadministrativoservices;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;

import br.jus.tjms.sgpd.entity.AtoAdministrativo;
import br.jus.tjms.sgpd.service.GenericService;



/**
 * @version 1.0
 * @created 11-dez-2015 18:15:34
 */
@Stateless
public class AtoAdministrativoService extends GenericService<AtoAdministrativo, Long> implements Serializable {

	private static final long serialVersionUID = 5713675666861693694L;

	public List<AtoAdministrativo> buscarPorNumero(String numero) {
		// TODO implementar busca por numero
		return null;
	}

	public void anexarDocumento(byte[] bytes, String nomeDoArquivo, Long atoAdministrativoId) {
		// TODO implementar anexo de documento ao ato		
	}

}