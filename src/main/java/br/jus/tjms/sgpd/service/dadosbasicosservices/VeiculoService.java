package br.jus.tjms.sgpd.service.dadosbasicosservices;
import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.jus.tjms.sgpd.entity.Veiculo;
import br.jus.tjms.sgpd.service.GenericService;

/**
 * @version 1.0
 * @created 11-dez-2015 18:15:52
 */
@Stateless
public class VeiculoService extends GenericService<Veiculo, Long> implements Serializable {

	private static final long serialVersionUID = -895733903179450471L;
	
	public List<Veiculo> buscarVeiculosPorPessoa(Long idPessoa) {
		TypedQuery<Veiculo> query = getEm()
				.createNamedQuery("veiculo.buscarVeiculosPorPessoa", Veiculo.class)
				.setParameter("idPessoa", idPessoa);
		return query.getResultList();
	}
}