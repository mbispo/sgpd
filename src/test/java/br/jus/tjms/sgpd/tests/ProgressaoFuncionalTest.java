package br.jus.tjms.sgpd.tests;

import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import javax.persistence.Persistence;

import org.junit.Test;

import br.jus.tjms.sgpd.entity.ProgressaoFuncional;
import br.jus.tjms.sgpd.service.evolucaofuncionalservices.ProgressaoFuncionalService;
import br.jus.tjms.sgpd.util.DateUtilz;

public class ProgressaoFuncionalTest {

	@Test
	public void calcularPrevisaoPrimeriaProgressao() {
		
		//
		ProgressaoFuncionalService progressaoFuncionalService =  new ProgressaoFuncionalService();
		progressaoFuncionalService.setEm(Persistence.createEntityManagerFactory("default").createEntityManager());
		
		//Cenário
		LocalDate dataInicioPrimeiroCargo = LocalDate.of(2016, 8, 15);
		ProgressaoFuncional ultimaProgressao = null;
		
		LocalDate resultado = progressaoFuncionalService.calcularPrevisaoProgressaoFuncional(ultimaProgressao, dataInicioPrimeiroCargo);
		LocalDate resultadoEsperado = LocalDate.of(2018, 8, 14);
		assertTrue(resultado.equals(resultadoEsperado));
	}
	
	@Test
	public void calcularPrevisaoProximaProgressao() {
		ProgressaoFuncionalService progressaoFuncionalService =  new ProgressaoFuncionalService();
		progressaoFuncionalService.setEm(Persistence.createEntityManagerFactory("default").createEntityManager());
		
		//progressaoFuncionalService.calcularPrevisaoProximaProgressao(2246l);
		
		//Cenário
		LocalDate dataInicioPrimeiroCargo = LocalDate.of(2006, 10, 20);
		ProgressaoFuncional ultimaProgressao = new ProgressaoFuncional();
		LocalDate dataUltimaProgressao = LocalDate.of(2016, 10, 18);
		ultimaProgressao.setDataProgressao(DateUtilz.converterLocalDateParaDate(dataUltimaProgressao));
		
		LocalDate resultado = progressaoFuncionalService.calcularPrevisaoProgressaoFuncional(ultimaProgressao, dataInicioPrimeiroCargo);
		
		LocalDate resultadoEsperado = LocalDate.of(2018, 10, 18);
		assertTrue(resultado.equals(resultadoEsperado));
	}
}
