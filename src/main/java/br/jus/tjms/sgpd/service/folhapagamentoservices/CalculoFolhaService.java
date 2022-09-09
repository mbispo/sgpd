package br.jus.tjms.sgpd.service.folhapagamentoservices;

import br.jus.tjms.sgpd.engine.calculo.FolhaCalculo;
import br.jus.tjms.sgpd.engine.to.Contexto;
import br.jus.tjms.sgpd.entity.FolhaPagamento;
import br.jus.tjms.sgpd.exception.SGPException;
import br.jus.tjms.sgpd.service.GenericService;
import org.jboss.ejb3.annotation.TransactionTimeout;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.AccessTimeout;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.io.Serializable;
import java.util.concurrent.TimeUnit;

/**
 * @version 1.0
 * @created 11-dez-2015 18:15:35
 */
@Stateless
@TransactionTimeout(value = 9999999)
public class CalculoFolhaService extends GenericService<FolhaPagamento, Long> implements Serializable {
	
	private static final long serialVersionUID = -5827270601981460934L;
    private static transient Logger logger = LoggerFactory.getLogger(CalculoFolhaService.class);
	
	@EJB(beanName="FolhaNormalCalculo")
	private FolhaCalculo folhaNormalCalculo;
	
	@EJB
	private FolhaPagamentoService folhaPagamentoService;

	@TransactionTimeout(value=9999999)
	@AccessTimeout(unit=TimeUnit.MINUTES,value=30)
	public Boolean calcularFolha(Long idFolha) {
		//TODO assíncrono
		//TODO consolidação dos dados de funcionários
		//TODO validação de conta-recebimento
		
		FolhaPagamento folhaPagamento = folhaPagamentoService.buscarPorId(idFolha);
		
		if (folhaPagamento!=null) {

			Contexto contextoGlobal = new Contexto(getEm());
			contextoGlobal.setFolha(folhaPagamento);
			folhaNormalCalculo.calcular(contextoGlobal, folhaPagamento);
	
			Double total = folhaPagamento.getTotalLiquido();

            logger.info("Folha calculada, total líquido: "+total);
			
			return true;
			
		} else {
			throw new SGPException("Folha de pagamento não encontrada!");
		}

	}
	
	public Boolean excluirCalculoDaFolha(Long idFolha) {
		
		// TODO implementar exclusão/extorno do cálculo
		
		return true;
		
	}

}