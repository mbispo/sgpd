package br.jus.tjms.sgpd.service.estruturacargosservices;
import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.jus.tjms.sgpd.entity.PreRequisitoFormacaoAcademica;
import br.jus.tjms.sgpd.service.GenericService;

/**
 * @version 1.0
 * @created 11-dez-2015 18:15:36
 */
@Stateless
public class PreRequisitoFormacaoAcademicaService extends GenericService<PreRequisitoFormacaoAcademica, Long> implements Serializable {

	private static final long serialVersionUID = 363509518667256460L;

	public List<PreRequisitoFormacaoAcademica> buscarPorCargo(Long cargoId) {
		TypedQuery<PreRequisitoFormacaoAcademica> query = getEm().
				createNamedQuery("preRequisitoFormacaoAcademica.buscarPorCargo", PreRequisitoFormacaoAcademica.class)
				.setParameter("cargoId", cargoId);
		return query.getResultList();
 	}
}