package br.jus.tjms.sgpd.service.bancoservices;
import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.jus.tjms.sgpd.entity.AgenciaBancaria;
import br.jus.tjms.sgpd.entity.Banco;
import br.jus.tjms.sgpd.service.GenericService;

/**
 * @version 1.0
 * @created 11-dez-2015 18:15:35
 */
@Stateless
public class BancoService extends GenericService<Banco, Long> implements Serializable {

	private static final long serialVersionUID = -8456307737881593685L;

	public List<Banco> buscarBancosPorNome(String nome) {
		//FIXME Busca parcial?
		TypedQuery<Banco> query = getEm().createNamedQuery("banco.buscarPorNome", Banco.class)
				.setParameter("nome", nome);
		return query.getResultList();
	}
	
	public List<AgenciaBancaria> listarAgencias(Long bancoId) {
		TypedQuery<AgenciaBancaria> query = getEm().createNamedQuery("agenciaBancaria.buscarPorBanco", AgenciaBancaria.class)
				.setParameter("bancoId", bancoId);
		return query.getResultList();
	}
	
	public AgenciaBancaria buscarAgenciaBancariaPorId(Long id) {
		TypedQuery<AgenciaBancaria> query = getEm().createNamedQuery("agenciaBancaria.buscarPorId", AgenciaBancaria.class)
				.setParameter("id", id);
		return query.getSingleResult();
	}
	
	public List<AgenciaBancaria> buscarAgenciasPorBancoENome(Long bancoId, String nome) {
		TypedQuery<AgenciaBancaria> query = getEm().createNamedQuery("agenciaBancaria.buscarPorBancoENome", AgenciaBancaria.class)
				.setParameter("bancoId", bancoId)
				.setParameter("nome", nome);
		return query.getResultList();
	}
	
	public void excluirAgenciaBancaria(AgenciaBancaria agenciaBancaria) {
		getEm().remove(agenciaBancaria);
	}

	public AgenciaBancaria salvarAgenciaBancaria(AgenciaBancaria agenciaBancaria) {
		return getEm().merge(agenciaBancaria);
	}

}