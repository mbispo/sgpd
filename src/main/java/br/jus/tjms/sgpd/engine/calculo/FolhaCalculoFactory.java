package br.jus.tjms.sgpd.engine.calculo;

import br.jus.tjms.sgpd.engine.calculo.impl.FolhaDecimoTerceiroCalculo;
import br.jus.tjms.sgpd.engine.calculo.impl.FolhaFeriasCalculo;
import br.jus.tjms.sgpd.engine.calculo.impl.FolhaNormalCalculo;
import br.jus.tjms.sgpd.engine.calculo.impl.FolhaOutrosCalculo;
import br.jus.tjms.sgpd.engine.calculo.impl.FolhaRescisaoCalculo;
import br.jus.tjms.sgpd.enumerators.TipoFolhaPagamento;
import br.jus.tjms.sgpd.exception.SGPException;

public class FolhaCalculoFactory {

	private FolhaCalculoFactory() {
	}

	public static FolhaCalculo fabricar(TipoFolhaPagamento tipo) {
		switch (tipo) {
			case NORMAL: 			return FolhaNormalCalculo.instance();
			case DECIMO_TERCEIRO: 	return FolhaDecimoTerceiroCalculo.instance();
			case FERIAS: 			return FolhaFeriasCalculo.instance();
			case RESCISAO: 			return FolhaRescisaoCalculo.instance();
			case OUTROS: 			return FolhaOutrosCalculo.instance();
			default: 				throw new SGPException("Tipo de folha de pagamento não informado!");
		}
	}

}