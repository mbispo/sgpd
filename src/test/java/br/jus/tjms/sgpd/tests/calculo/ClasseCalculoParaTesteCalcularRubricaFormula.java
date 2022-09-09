package br.jus.tjms.sgpd.tests.calculo;

import java.util.Date;

import br.jus.tjms.sgpd.engine.calculo.ClasseCalculo;
import br.jus.tjms.sgpd.engine.to.Contexto;
import br.jus.tjms.sgpd.entity.FuncionarioCargo;
import br.jus.tjms.sgpd.entity.ProgressaoFuncional;
import br.jus.tjms.sgpd.entity.ReferenciaValor;

public class ClasseCalculoParaTesteCalcularRubricaFormula implements ClasseCalculo {

	private static final long serialVersionUID = 3530003578905316826L;
	
	static ClasseCalculo instance;
	
	public static ClasseCalculo newInstance() {
		return new ClasseCalculoParaTesteCalcularRubricaFormula();
	}
	
	// este método é requerido pela engine de execução de classes
	public static ClasseCalculo instance() {
		if (instance == null) {
			instance = new ClasseCalculoParaTesteCalcularRubricaFormula(); 
		}		
		return instance;
	}

	// método deve obedecer à interface
	@Override
	public Object calcular(Contexto contexto) {
		/*
		 * Groovy:
		 * 
			funcionarioCargo = contexto.funcionarioCargo
			progressaoAtual = funcionarioCargo.progressaoAtual
			referenciaValor = progressaoAtual.referencia.getValorAtual(new Date())
			resultado = (referenciaValor.valor * (contexto.rubricaFuncionario != null ? contexto.rubricaFuncionario.percentual : contexto.rubrica.percentual)) / 100.0
			return resultado");
		 */

		FuncionarioCargo funcionarioCargo = contexto.getFuncionarioCargo();
		ProgressaoFuncional progressaoAtual = funcionarioCargo.getProgressaoAtual();
		ReferenciaValor referenciaValor = progressaoAtual.getReferencia().getValorAtual(new Date());
		Double resultado = (referenciaValor.getValor() * (contexto.getRubricaFuncionario() != null ? contexto.getRubricaFuncionario().getPercentual() : contexto.getRubrica().getPercentual())) / 100.0;
		
		return resultado;		
	}
	
	// método estático deve retornar Object e possuir um parâmetro do tipo Contexto
	public static Object metodoEstaticoParaTeste(Contexto contexto) {
		return newInstance().calcular(contexto);
	}

}