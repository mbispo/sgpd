package br.jus.tjms.sgpd.tests.util;

import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil {

	public static Double retornaTotalDaPlanilhaNaColuna(URI arquivo, int coluna) {
		List<String> lista = lerColunaDaPlanilha(arquivo, coluna);
		
		Double total = 0.0;
		
		for (String string : lista) {
			total = total + new Double(string);
		}
		
		return total;		
	}
	
	public static List<String> lerColunaDaPlanilha(URI arquivo, int coluna) {
		List<String> lista = new ArrayList<>();
		try {
			File f = new File(arquivo);
			Workbook wb = WorkbookFactory.create(f);
			Sheet mySheet = wb.getSheetAt(0);
			for (Iterator<Row> rowIterator = mySheet.rowIterator(); rowIterator.hasNext();) {
				lista.add(((Row) rowIterator.next()).getCell(coluna).toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (lista.size()>0) {
			lista.remove(0);
		}
		return lista;
	}
	

	public static List<List<String>> lerColunasDaPlanilha(URI arquivo, int[] colunas) {
		List<List<String>> lista = new ArrayList<>(); 
		try {
			File f = new File(arquivo);
			Workbook wb = WorkbookFactory.create(f);
			Sheet mySheet = wb.getSheetAt(0);
			for (Iterator<Row> rowIterator = mySheet.rowIterator(); rowIterator.hasNext();) {
				List<String> coles = new ArrayList<>();
				Row row = rowIterator.next();
				int[] cs = colunas;
				for (int i : cs) {
					coles.add(row.getCell(i).toString());	
				}				
				lista.add(coles);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (lista.size()>0) {
			lista.remove(0);
		}
		return lista;
	}
	
}