package br.jus.tjms.sgpd.service.remuneracaoservices;
import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.jus.tjms.sgpd.entity.Rubrica;
import br.jus.tjms.sgpd.entity.RubricaFuncionario;
import br.jus.tjms.sgpd.service.GenericService;

/**
 * @version 1.0
 * @created 11-dez-2015 18:15:46
 */
@Stateless
public class RubricaFuncionarioService extends GenericService<RubricaFuncionario, Long> implements Serializable {

	private static final long serialVersionUID = 9036472374755235712L;

	public List<Rubrica> buscarRubricasPorFuncionario(Long funcionarioId) {
		TypedQuery<Rubrica> query = getEm()
				.createNamedQuery("rubricaFuncionario.buscarRubricasPorFuncionario", Rubrica.class)
				.setParameter("funcionarioId", funcionarioId);
		return query.getResultList();
	}
	
	public Long vincularRubricaAoFuncionario(Long funcionarioId, Long funcionarioIdCargo, Long idRubrica,
			Double quantidade, Double percentual, Double valor) {
		// TODO implementar
		return null;
	}
	
	public void desvincularRubricaDoFuncionario(Long idRubricaFuncionario) {
		// TODO implementar
	}
	
}