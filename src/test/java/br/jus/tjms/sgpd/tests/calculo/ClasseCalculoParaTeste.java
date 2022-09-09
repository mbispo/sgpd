package br.jus.tjms.sgpd.tests.calculo;

import br.jus.tjms.sgpd.engine.calculo.ClasseCalculo;
import br.jus.tjms.sgpd.engine.to.Contexto;

public class ClasseCalculoParaTeste implements ClasseCalculo {

	private static final long serialVersionUID = -6535610930325970398L;
	
	static ClasseCalculo instance;
	
	public static ClasseCalculo newInstance() {
		return new ClasseCalculoParaTeste();
	}
	
	// este método é requerido pela engine de execução de classes
	public static ClasseCalculo instance() {
		if (instance == null) {
			instance = new ClasseCalculoParaTeste(); 
		}		
		return instance;
	}

	// método deve obedecer à interface
	@Override
	public Object calcular(Contexto contexto) {
		// nesse exemplo pegamos os inputs (que são informados pela fórmula) ano, mes e valor, calculamos e retornamos o bonus
		Double valor = (Double)contexto.input("valor").getValor();
		Integer ano = (Integer)contexto.input("ano").getValor();
		Integer mes = (Integer)contexto.input("mes").getValor();
		
		Double bonus = valor*ano*mes;

		contexto.output("bonus").setValor(bonus);
		
		return bonus;		
	}
	
	// método estático deve retornar Object e possuir um parâmetro do tipo Contexto
	public static Object metodoEstaticoParaTeste(Contexto contexto) {
		return newInstance().calcular(contexto);
	}

}