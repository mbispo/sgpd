package br.jus.tjms.sgpd.engine.calculo;

public interface OutputParam {

	String getNome();

	Object getValor();
	
	void setValor(Object valor);
	
	String getClasse();
	
	Boolean getResultadoDefault();

}