package br.jus.tjms.sgpd.enumerators;

/**
 * @version 1.0
 * @created 06-nov-2015 16:30:58
 */
public enum GrauInstrucao {
	/*
			1	Analfabeto
			2	Primário Incompleto
			3	Primário Completo
			4	Primeiro Grau Incompleto
			5	Primeiro Grau Completo
			6	Segundo Grau Incompleto
			7	Segundo Grau Completo
			8	Superior Incompleto
			9	Superior Completo
			10	Pós Graduando
			12	Mestrando
			13	Mestre
			14	Doutorando
			15	Doutor




	 */
	ANALFABETO,
	ATE_QUINTO_ANO_INCOMPLETO_ENSINO_FUNDAMENTAL,
	QUINTO_ANO_COMPLETO_ENSINO_FUNDAMENTAL,
	DO_SEXTO_AO_NONO_ANO_ENSINO_FUNDAMENTAL_INCOMPLETO,
	ENSINO_FUNDAMENTAL_COMPLETO,
	ENSINO_MEDIO_INCOMPLETO,
	ENSINO_MEDIO_COMPLETO,
	EDUCACAO_SUPERIOR_INCOMPLETA,
	EDUCACAO_SUPERIOR_COMPLETA,
	MESTRADO_COMPLETO,
	POS_GRADUACAO_COMPLETA,
	DOUTORADO_COMPLETO,	
	NAO_INFORMADO,
	NAO_PREVISTO_EM_LEI,
	POS_GRADUACAO_INCOMPLETA,
	MESTRADO_INCOMPLETO,
	DOUTORADO_INCOMPLETO,
	DISPENSA_PROVA_ESCOLARIDADE
}