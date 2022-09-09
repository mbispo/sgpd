package br.jus.tjms.sgpd.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CalcUtilz {
    private static Logger logger = LoggerFactory.getLogger(CalcUtilz.class);

	public static Double round(Double value, int decimais) {
		BigDecimal divisor = BigDecimal.valueOf(1.0);
		BigDecimal retorno = BigDecimal.ZERO;
		
		if (value != null && !BigDecimal.valueOf(value).equals(BigDecimal.ZERO)) {
			retorno = BigDecimal.valueOf(value).divide(divisor, decimais, RoundingMode.HALF_UP);
		}
		
		return retorno.doubleValue();
	}
	
	public static void main(String[] args) {
        String resultado = String.valueOf(round(Double.valueOf("369.03444445"),2));
		logger.info(resultado);
	}
	
}