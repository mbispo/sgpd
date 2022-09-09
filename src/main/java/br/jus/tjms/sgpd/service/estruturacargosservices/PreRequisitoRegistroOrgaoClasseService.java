package br.jus.tjms.sgpd.service.estruturacargosservices;
import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.jus.tjms.sgpd.entity.PreRequisitoRegistroOrgaoClasse;
import br.jus.tjms.sgpd.service.GenericService;

@Stateless
public class PreRequisitoRegistroOrgaoClasseService extends GenericService<PreRequisitoRegistroOrgaoClasse, Long> implements Serializable {

	private static final long serialVersionUID = 363509518667256460L;

	public List<PreRequisitoRegistroOrgaoClasse> buscarPorCargo(Long cargoId) {
		TypedQuery<PreRequisitoRegistroOrgaoClasse> query = getEm().
				createNamedQuery("preRequisitoRegistroOrgaoClasse.buscarPorCargo", PreRequisitoRegistroOrgaoClasse.class)
				.setParameter("cargoId", cargoId);
		return query.getResultList();
 	}
}