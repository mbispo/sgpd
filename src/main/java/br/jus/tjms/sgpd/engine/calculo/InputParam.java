package br.jus.tjms.sgpd.engine.calculo;

public interface InputParam {

	String getNome();

	Object getValor();
	
	void setValor(Object valor);
	
	String getClasse();

}