package br.jus.tjms.sgpd.service.planosaudeservices;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;

import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;

import br.jus.tjms.sgpd.entity.ContratoPlanoSaude;
import br.jus.tjms.sgpd.entity.Funcionario;
import br.jus.tjms.sgpd.service.GenericService;

/**
 * @version 1.0
 * @created 11-dez-2015 18:15:37
 */
@Stateless
public class ContratoPlanoSaudeService extends GenericService<ContratoPlanoSaude, Long> implements Serializable {

	private static final long serialVersionUID = -6962701244426698885L;

	private static List<ContratoPlanoSaude> TEST_DATA = new ArrayList<>();
	private static Boolean TESTING = false;
	
	public static void setTestingMode(Boolean testing, List<ContratoPlanoSaude> testData) {
		TESTING = testing;
		TEST_DATA = testing?testData:null;
	}
	
	public List<ContratoPlanoSaude> obterContratosPlanoSaudeAtivosDoFuncionario(final Funcionario funcionario,
			final Date periodoInicio, final Date periodoFim) {
		
		if (TESTING) {
			List<ContratoPlanoSaude> dados = TEST_DATA;

			List<ContratoPlanoSaude> retorno = new ArrayList<>();
			/* usando guava */

			if (dados != null) {
				
				Collection<ContratoPlanoSaude> c = Collections2.filter(dados, new Predicate<ContratoPlanoSaude>() {
					@Override
					public boolean apply(ContratoPlanoSaude c) {
						return (c.getResponsavelFinanceiro().equals(funcionario));
					}
				});
				
				retorno.addAll(c);

			}

			return retorno;			
		}
		
		// TODO implementar ContratoPlanoSaudeService.obterContratosPlanoSaudeAtivosDoFuncionario
		return null;
	}
}