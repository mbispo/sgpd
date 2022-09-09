package br.jus.tjms.sgpd.enumerators;

import java.util.List;

/**
 * @version 1.0
 * @created 06-nov-2015 16:31:06
 */
public enum TipoLicenca {
	ATIVIDADE_POLITICA,
	COMPULSORIA,
	ESTUDO_MISSAO_OFICIAL,
	EXERCICIO_MANDATO_CLASSISTA,
	MATERNIDADE,
	MOTIVO_AFASTAMENTO_CONJUGE,
	MOTIVO_DOENCA_FAMILIA,
	PATERNIDADE,
	PREMIO,
	PRESTACAO_SERVICO_MILITAR,
	SERVIR_OUTRO_ORGAO,
	TRATAMENTO_SAUDE,
	TRATO_INTERESSE_PARTICULAR;

	public List<TipoLicenca>[] listaTiposComRemuneracao(){
		return null;
	}

	public List<TipoLicenca>[] listaTiposComPermissaoExercicio(){
		return null;
	}
}