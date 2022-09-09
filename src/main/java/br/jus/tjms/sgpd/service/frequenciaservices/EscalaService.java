package br.jus.tjms.sgpd.service.frequenciaservices;
import java.io.Serializable;
import java.util.Date;

import javax.ejb.Stateless;

import br.jus.tjms.sgpd.entity.Escala;
import br.jus.tjms.sgpd.service.GenericService;

/**
 * @version 1.0
 * @created 11-dez-2015 18:15:39
 */
@Stateless
public class EscalaService extends GenericService<Escala, Long> implements Serializable {
	
	private static final long serialVersionUID = -7466838592280370831L;

	public Long obterEscalasDePlantaoNormalCumpridasNoPeriodo(Long idFuncionario, Date dataInicial, Date dataFinal) {
		//TODO implementar
		return null;
	}
	
	public Long obterEscalasDePlantaoExtraordinarioCumpridasNoPeriodo(Long idFuncionario, Date dataInicial, Date dataFinal) {
		//TODO implementar
		return null;
	}

}