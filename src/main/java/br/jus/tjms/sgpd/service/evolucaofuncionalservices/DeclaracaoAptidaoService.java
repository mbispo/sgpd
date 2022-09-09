package br.jus.tjms.sgpd.service.evolucaofuncionalservices;
import java.io.Serializable;

import javax.ejb.Stateless;

import br.jus.tjms.sgpd.entity.FuncionarioCargoDeclaracaoAptidao;
import br.jus.tjms.sgpd.service.GenericService;

/**
 * @version 1.0
 * @created 11-dez-2015 18:15:37
 */
@Stateless
public class DeclaracaoAptidaoService extends GenericService<FuncionarioCargoDeclaracaoAptidao, Long> implements Serializable {

	private static final long serialVersionUID = 4498192908144480881L;

}