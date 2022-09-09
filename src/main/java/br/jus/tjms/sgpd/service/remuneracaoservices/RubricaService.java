package br.jus.tjms.sgpd.service.remuneracaoservices;
import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.jus.tjms.sgpd.entity.Rubrica;
import br.jus.tjms.sgpd.entity.RubricaParametro;
import br.jus.tjms.sgpd.enumerators.Sinal;
import br.jus.tjms.sgpd.enumerators.TipoRubrica;
import br.jus.tjms.sgpd.service.GenericService;
import br.jus.tjms.sgpd.service.rest.v1.to.RubricaTO;

/**
 * @version 1.0
 * @created 11-dez-2015 18:15:46
 */
@Stateless
public class RubricaService extends GenericService<Rubrica, Long> implements Serializable {
	
	private static final long serialVersionUID = 5537743354638303076L;

	public Long criarRubrica(Integer sequenciaCalculo, String sigla, String descricao, Sinal sinal, Boolean ativa,
			Boolean visivel, Double valor, Double percentual, Double quantidade, TipoRubrica tipo,
			Long idGrupoRubrica) {
		// TODO implementar
		return null;
	}
	
	public List<RubricaParametro> obterParametrosDaRubrica(Long id) {
		//TODO implementar
		return null;
	}

	public List<Rubrica> buscarPorGrupo(Long grupoId) {
		TypedQuery<Rubrica> query = getEm()
				.createNamedQuery("rubrica.buscarPorGrupo", Rubrica.class)
				.setParameter("grupoId", grupoId);
		return query.getResultList();
	}

	public List<Rubrica> buscarPorNome(String nome) {
		TypedQuery<Rubrica> query = getEm()
				.createNamedQuery("rubrica.buscarPorNome", Rubrica.class)
				.setParameter("nome", nome);
		return query.getResultList();
	}

	public Rubrica alterar(RubricaTO rubricaTO, Long rubricaId) {
		Rubrica rubrica = getEm().find(Rubrica.class, rubricaId);
		rubrica.alterar(rubricaTO);		
		rubrica = salvar(rubrica);
		return rubrica;		
	}

}