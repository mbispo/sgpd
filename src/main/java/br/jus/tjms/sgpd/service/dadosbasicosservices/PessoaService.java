package br.jus.tjms.sgpd.service.dadosbasicosservices;
import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.jus.tjms.sgpd.entity.Pessoa;
import br.jus.tjms.sgpd.service.GenericService;

/**
 * @version 1.0
 * @created 11-dez-2015 18:15:43
 */
@Stateless
public class PessoaService extends GenericService<Pessoa, Long> implements Serializable {

	private static final long serialVersionUID = -1005056080847380029L;

	public List<Pessoa> buscarPessoasPorNome(String nome) {
		
		//FIXME Busca parcial?
		TypedQuery<Pessoa> query = getEm().createNamedQuery("pessoa.buscarPorNome", Pessoa.class)
				.setParameter("nome", nome);
		return query.getResultList();
	}
}