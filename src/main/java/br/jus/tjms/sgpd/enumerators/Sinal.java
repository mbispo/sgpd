package br.jus.tjms.sgpd.enumerators;

public enum Sinal {
	
	POSITIVO("+"), NEGATIVO("-");
	
	private final String sinal;
	
	private Sinal(String sinal) {
		this.sinal = sinal;
	}

	@Override
	public String toString() {
		return sinal;
	}

	public String getSinal() {
		return sinal;
	}
	

}
