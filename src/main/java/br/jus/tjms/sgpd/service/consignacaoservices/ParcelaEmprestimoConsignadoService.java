package br.jus.tjms.sgpd.service.consignacaoservices;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.jus.tjms.sgpd.entity.ParcelaEmprestimoConsignado;
import br.jus.tjms.sgpd.service.GenericService;

@Stateless
public class ParcelaEmprestimoConsignadoService extends GenericService<ParcelaEmprestimoConsignado, Long> implements Serializable {
	
	private static final long serialVersionUID = 1209657096487937368L;
	
	public List<ParcelaEmprestimoConsignado> buscarPorEmprestimo(Long emprestimoId) {
		TypedQuery<ParcelaEmprestimoConsignado> query = getEm()
				.createNamedQuery("emprestimoConsignado.buscarParcelasPorEmprestimo", ParcelaEmprestimoConsignado.class)
				.setParameter("emprestimoId", emprestimoId);
		return query.getResultList();
	}
}