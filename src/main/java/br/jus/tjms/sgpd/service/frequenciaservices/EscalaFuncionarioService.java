package br.jus.tjms.sgpd.service.frequenciaservices;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.jus.tjms.sgpd.entity.EscalaFuncionario;
import br.jus.tjms.sgpd.service.GenericService;

@Stateless
public class EscalaFuncionarioService extends GenericService<EscalaFuncionario, Long> implements Serializable {

	private static final long serialVersionUID = 8424103844065030540L;

	public List<EscalaFuncionario> buscarEscalasPorFuncionario(Long funcionarioId) {
		TypedQuery<EscalaFuncionario> query = getEm()
				.createNamedQuery("escalaFuncionario.buscarEscalasFuncionarioPorFuncionario", EscalaFuncionario.class)
				.setParameter("funcionarioId", funcionarioId);
		return query.getResultList();
	}

}