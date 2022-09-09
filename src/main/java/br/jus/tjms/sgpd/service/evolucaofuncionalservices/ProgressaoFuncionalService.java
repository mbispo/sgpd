package br.jus.tjms.sgpd.service.evolucaofuncionalservices;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.jus.tjms.sgpd.entity.ProgressaoFuncional;
import br.jus.tjms.sgpd.service.GenericService;
import br.jus.tjms.sgpd.util.DateUtilz;

/**
 * @version 1.0
 * @created 11-dez-2015 18:15:44
 */
@Stateless
public class ProgressaoFuncionalService extends GenericService<ProgressaoFuncional, Long> implements Serializable {

	private static final long serialVersionUID = -212561778236630983L;
	private static final long DIAS_PROGRESSAO = 730;
	
	public LocalDate calcularPrevisaoProximaProgressao(Long funcionarioId) {
		ProgressaoFuncional ultimaProgressao = buscarUltimaProgressaoFuncional(funcionarioId);
		LocalDate dataInicioPrimeiroCargo = buscarDataInicioPrimeiroCargo(funcionarioId);

		return calcularPrevisaoProgressaoFuncional(ultimaProgressao, dataInicioPrimeiroCargo);
	}

	public LocalDate calcularPrevisaoProgressaoFuncional(ProgressaoFuncional ultimaProgressao,
			LocalDate dataInicioPrimeiroCargo) {
		if (dataInicioPrimeiroCargo == null) {
			throw new IllegalArgumentException("dataInicioPrimeiroCargo é obrigatório");
		}
			
		if (ultimaProgressao != null) {
			return DateUtilz.converterDateParaLocalDate(ultimaProgressao.getDataProgressao())
					.plusDays(DIAS_PROGRESSAO); //exclusivo
		} else {
			return dataInicioPrimeiroCargo.plusDays(DIAS_PROGRESSAO - 1); //inclusivo 
		}
	}

	private LocalDate buscarDataInicioPrimeiroCargo(Long funcionarioId) {
		TypedQuery<Date> query = getEm().createNamedQuery("funcionarioCargo.buscarDataInicioPrimeiroCargo", Date.class)
				.setParameter("funcionarioId", funcionarioId);
		
		Date dataInicioPrimeiroCargo = query.getSingleResult();

		return DateUtilz.converterDateParaLocalDate(dataInicioPrimeiroCargo);
	}

	private ProgressaoFuncional buscarUltimaProgressaoFuncional(Long funcionarioId) {
		TypedQuery<ProgressaoFuncional> query = getEm().createNamedQuery("progressaoFuncional.buscarProgressaoFuncional", ProgressaoFuncional.class)
				.setParameter("funcionarioId", funcionarioId);
		
		List<ProgressaoFuncional> list = query.getResultList();
		 if (list.isEmpty()) {
		        return null;
		 }
		 
		 return list.get(0);
	}

}