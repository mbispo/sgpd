package br.jus.tjms.sgpd.util;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtilz {
	
	public static Date primeiroDiaDoMes(Integer mes, Integer ano) {
		return criaData(1,mes,ano);
	}
	
	public static Date primeiroDiaDoMesAoFinalDoDia(Integer mes, Integer ano) {
		return criaDataAoFinalDoDia(1,mes,ano);
	}
	
	public static Date ultimoDiaDoMes(Integer mes, Integer ano) {
		return criaData(retornaUltimoDiaMes(mes, ano),mes,ano);
	}
	
	public static Date ultimoDiaDoMesAoFinalDoDia(Integer mes, Integer ano) {
		return criaDataAoFinalDoDia(retornaUltimoDiaMes(mes, ano),mes,ano);
	}	
	
	public static Date criaData(Integer dia, Integer mes, Integer ano) {
		return criaCalendar(dia, mes, ano).getTime();
	}
	
	private static Calendar criaCalendar(Integer dia, Integer mes, Integer ano) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_MONTH, dia);
		cal.set(Calendar.MONTH, mes - 1);
		cal.set(Calendar.YEAR, ano);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal;
	}	
	
	public static Date criaData(Date data) {
		if (data == null)
			return null;
		return criaCalendar(data).getTime();
	}
	
	private static Calendar criaCalendar(Date data) {
		if (data == null)
			return null;
		Calendar cal = Calendar.getInstance();
		cal.setTime(data);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal;
	}
	
	public static Date criaDataAoFinalDoDia(Integer dia, Integer mes, Integer ano) {
		return criaCalendarAoFinalDoDia(dia,mes,ano).getTime();
	}
	
	private static Calendar criaCalendarAoFinalDoDia(Integer dia, Integer mes, Integer ano) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_MONTH, dia);
		cal.set(Calendar.MONTH, mes - 1);
		cal.set(Calendar.YEAR, ano);
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		cal.set(Calendar.MILLISECOND, 998);
		return cal;
	}

	public static Date criaDataAoFinalDoDia(Date data) {
		if (data == null) return null;
		return criaCalendarAoFinalDoDia(data).getTime();
	}
	
	private static Calendar criaCalendarAoFinalDoDia(Date data) {
		if (data == null)
			return null;
		Calendar cal = Calendar.getInstance();
		cal.setTime(data);
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		cal.set(Calendar.MILLISECOND, 998);
		return cal;
	}	
	
	private static Integer retornaUltimoDiaMes(Integer mes, Integer ano) {
		Calendar cal = new GregorianCalendar(ano, mes - 1, 1);
		return cal.getActualMaximum(Calendar.DAY_OF_MONTH);
	}
	
	public static Integer diasEntre(Date dataInicial, Date dataFinal) {
		Long dias = (criaDataAoFinalDoDia(dataFinal).getTime() - criaData(dataInicial).getTime()) / 86400000L;
		return dias.intValue();
	}
	
	
	public static Date adicionaDiasNaData(Date data, int dias, Boolean endOfDay) {
		if (data != null) {
			Calendar dataTemp = endOfDay?criaCalendarAoFinalDoDia(data):criaCalendar(data);
			dataTemp.add(Calendar.DAY_OF_MONTH, dias);
			return dataTemp.getTime();
		} else {
			return null;
		}
	}
	
	public static Date adicionaMesesNaData(Date data, int meses, Boolean endOfDay) {
		if (data != null) {
			Calendar dataTemp = endOfDay?criaCalendarAoFinalDoDia(data):criaCalendar(data);
			dataTemp.add(Calendar.MONTH, meses);
			return dataTemp.getTime();
		} else {
			return null;
		}
	}
	
	public static Date adicionaAnosNaData(Date data, int anos, Boolean endOfDay) {
		if (data != null) {
			Calendar dataTemp = endOfDay?criaCalendarAoFinalDoDia(data):criaCalendar(data);
			dataTemp.add(Calendar.YEAR, anos);
			return dataTemp.getTime();
		} else {
			return null;
		}
	}	
	
	
	public static void main(String[] args) {

		/*System.out.println(diasEntre(criaData(1, 2, 2016), criaData(29, 2, 2016)));
		System.out.println(diasEntre(criaData(1, 2, 2015), criaData(1, 2, 2015)));
		System.out.println(diasEntre(criaData(1, 1, 2015), criaDataAoFinalDoDia(31, 12, 2015)));
		*/
		
		
		Date data = criaDataAoFinalDoDia(1,1,2016);
		Date data2 = adicionaAnosNaData(data, -1, false);
		
		System.out.println(data2);
		System.out.println(diasEntre(data2, data));
		

	}
	
	public static LocalDate converterDateParaLocalDate(Date data) {
		return Instant.ofEpochMilli(data.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
	}
	
	public static Date converterLocalDateParaDate(LocalDate localDate) {
		return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
	}
	
}