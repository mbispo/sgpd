package br.jus.tjms.sgpd.service.regimejuridicoservices;
import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.jus.tjms.sgpd.entity.RegimePrevidencia;
import br.jus.tjms.sgpd.service.GenericService;

/**
 * @version 1.0
 * @created 11-dez-2015 18:15:44
 */
@Stateless
public class RegimePrevidenciaService extends GenericService<RegimePrevidencia, Long> implements Serializable {

	private static final long serialVersionUID = -1724306840905319220L;

	public List<RegimePrevidencia> buscarPorEntidade(Long entidadePrevidenciariaId) {
		TypedQuery<RegimePrevidencia> query = getEm()
				.createNamedQuery("regimePrecidencia.buscarPorEntidade", RegimePrevidencia.class)
				.setParameter("entidadePrevidenciariaId", entidadePrevidenciariaId);
		return query.getResultList();
	}

	public List<RegimePrevidencia> buscarPorRegimeJuridico(Long regimeJuridicoId) {
		TypedQuery<RegimePrevidencia> query = getEm()
				.createNamedQuery("regimePrecidencia.buscarPorRegimeJuridico", RegimePrevidencia.class)
				.setParameter("regimeJuridicoId", regimeJuridicoId);
		return query.getResultList();
	}
}