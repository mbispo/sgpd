package br.jus.tjms.sgpd.service.regimejuridicoservices;
import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.jus.tjms.sgpd.entity.RegimeJuridico;
import br.jus.tjms.sgpd.service.GenericService;

/**
 * @version 1.0
 * @created 11-dez-2015 18:15:44
 */
@Stateless
public class RegimeJuridicoService extends GenericService<RegimeJuridico, Long> implements Serializable {

	private static final long serialVersionUID = 7391863403455010298L;

	public List<RegimeJuridico> buscarPorRegimePrevidencia(Long regimePrevidenciaId) {
		TypedQuery<RegimeJuridico> query = getEm()
				.createNamedQuery("regimeJuridico.buscarPorRegimePrevidencia", RegimeJuridico.class)
				.setParameter("regimePrevidenciaId", regimePrevidenciaId);
		return query.getResultList();
	}
}