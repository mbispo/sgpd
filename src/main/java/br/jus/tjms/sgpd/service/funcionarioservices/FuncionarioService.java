package br.jus.tjms.sgpd.service.funcionarioservices;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.jus.tjms.sgpd.entity.Funcionario;
import br.jus.tjms.sgpd.service.GenericService;

/**
 * @version 1.0
 * @created 11-dez-2015 18:15:40
 */
@Stateless
public class FuncionarioService extends GenericService<Funcionario,Long> implements Serializable {

	private static final long serialVersionUID = -512834988461662319L;

	public List<Funcionario> buscarPorNome(String nome) {
		TypedQuery<Funcionario> query = getEm().createNamedQuery("funcionario.buscarPorNome", Funcionario.class)
				.setParameter("nome", nome);
		return query.getResultList();
	}

	public Funcionario buscarPorMatricula(Integer matricula) {
		TypedQuery<Funcionario> query = getEm().createNamedQuery("funcionario.buscarPorMatricula", Funcionario.class)
				.setParameter("matricula", matricula);
		return query.getSingleResult();
	}

}