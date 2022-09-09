package br.jus.tjms.sgpd.engine.calculo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.jus.tjms.sgpd.engine.to.ItemCalculoResultado;
import br.jus.tjms.sgpd.entity.FolhaPagamento;
import br.jus.tjms.sgpd.entity.Pessoa;
import br.jus.tjms.sgpd.entity.Rubrica;
import br.jus.tjms.sgpd.entity.RubricaBase;
import br.jus.tjms.sgpd.entity.RubricaCompoeBaseCalculo;
import br.jus.tjms.sgpd.entity.RubricaFuncionario;
import br.jus.tjms.sgpd.entity.RubricaFuncionarioBase;
import br.jus.tjms.sgpd.enumerators.Sinal;
import br.jus.tjms.sgpd.enumerators.TipoBaseCalculo;

public class ItemCalculoResultadoRubricaFuncionarioFolhaCache implements Serializable {

	private static final long serialVersionUID = 333917075073939070L;

	private static ItemCalculoResultadoRubricaFuncionarioFolhaCache instance;
	
	private transient Map<FolhaPagamento, Map<Pessoa, List<ItemCache>>> mapaCache = new HashMap<>();
	
	private ItemCalculoResultadoRubricaFuncionarioFolhaCache() {
	}

	public static ItemCalculoResultadoRubricaFuncionarioFolhaCache instance() {
		if (instance == null) { 
			instance = new ItemCalculoResultadoRubricaFuncionarioFolhaCache();
		}
		return instance;
	}
	
	public static ItemCalculoResultadoRubricaFuncionarioFolhaCache cache() {
		return instance();
	}
	
	public ItemCalculoResultado obterResultado(FolhaPagamento folhaPagamento, Pessoa pessoa, Rubrica rubrica) {
		if (mapaCache.containsKey(folhaPagamento) && mapaCache.get(folhaPagamento).containsKey(pessoa)) {
			List<ItemCache> listaPessoa = mapaCache.get(folhaPagamento).get(pessoa);
			for (ItemCache itemCache : listaPessoa) {
				if (itemCache.getRubrica().equals(rubrica)) {
					return itemCache.getItemCalculoResultado();
				}
			}
		}
		return null;
	}
	
	public List<ItemCalculoResultado> obterResultadosPorRubricasFuncionarioBase(FolhaPagamento folhaPagamento, Pessoa pessoa, RubricaFuncionario rubricaFuncionario, Sinal sinal) {
        List<ItemCalculoResultado> retorno = new ArrayList<>();
        if (mapaCache.containsKey(folhaPagamento) && mapaCache.get(folhaPagamento).containsKey(pessoa)) {
			List<ItemCache> listaPessoa = mapaCache.get(folhaPagamento).get(pessoa);
			List<RubricaFuncionarioBase> rubricasBase = rubricaFuncionario.getRubricasBase();
			if (rubricasBase != null) {
				List<Rubrica> rubricas = new ArrayList<>();
				for(RubricaFuncionarioBase rubricaFuncionarioBase : rubricasBase) {
					rubricas.add(rubricaFuncionarioBase.getRubrica());
				}
				for (ItemCache itemCache : listaPessoa) {
					if (rubricas.contains(itemCache.getRubrica())&&itemCache.getRubrica().getSinal().equals(sinal)) {
						retorno.add(itemCache.getItemCalculoResultado());
					}
				}
			}
			return retorno;
		}
		return retorno;
	}

	public List<ItemCalculoResultado> obterResultadosPorRubricasBase(FolhaPagamento folhaPagamento, Pessoa pessoa, Rubrica rubrica, Sinal sinal) {
        List<ItemCalculoResultado> retorno = new ArrayList<>();
        if (mapaCache.containsKey(folhaPagamento) && mapaCache.get(folhaPagamento).containsKey(pessoa)) {
			List<ItemCache> listaPessoa = mapaCache.get(folhaPagamento).get(pessoa);
			List<RubricaBase> rubricasBase = rubrica.getRubricasBase();
			if (rubricasBase != null) {
				List<Rubrica> rubricas = new ArrayList<>();
				for(RubricaBase rb : rubricasBase) {
					rubricas.add(rb.getRubricaBase());
				}
				for (ItemCache itemCache : listaPessoa) {
					if (rubricas.contains(itemCache.getRubrica())&&itemCache.getRubrica().getSinal().equals(sinal)) {
						retorno.add(itemCache.getItemCalculoResultado());
					}
				}
			}
			return retorno;
		}
		return retorno;
	}

	public List<ItemCalculoResultado> obterResultadosPorComposicaoTipoBaseCalculo(FolhaPagamento folhaPagamento, Pessoa pessoa, TipoBaseCalculo tipoBaseCalculo, Sinal sinal) {
        List<ItemCalculoResultado> retorno = new ArrayList<>();
        if (mapaCache.containsKey(folhaPagamento) && mapaCache.get(folhaPagamento).containsKey(pessoa)) {
			List<ItemCache> listaPessoa = mapaCache.get(folhaPagamento).get(pessoa);
			for (ItemCache itemCache : listaPessoa) {
				List<RubricaCompoeBaseCalculo> composicao = itemCache.getRubrica().getCompoeTiposBaseCalculo();
				for (RubricaCompoeBaseCalculo rubricaCompoeBaseCalculo : composicao) {
					if (rubricaCompoeBaseCalculo.getTipoBaseCalculo().equals(tipoBaseCalculo)&&itemCache.getRubrica().getSinal().equals(sinal)) {
						retorno.add(itemCache.getItemCalculoResultado());
					}
				}
			}
			return retorno;
		}
		return retorno;
	}
	
	public List<ItemCalculoResultado> obterResultadosPorSinal(FolhaPagamento folhaPagamento, Pessoa pessoa, Sinal sinal) {
        List<ItemCalculoResultado> retorno = new ArrayList<>();
        if (mapaCache.containsKey(folhaPagamento) && mapaCache.get(folhaPagamento).containsKey(pessoa)) {
			List<ItemCache> listaPessoa = mapaCache.get(folhaPagamento).get(pessoa);
			for (ItemCache itemCache : listaPessoa) {
				if (itemCache.getRubrica().getSinal().equals(sinal)) {
					retorno.add(itemCache.getItemCalculoResultado());
				}
			}
			return retorno;
		}
		return retorno;
	}
	
	public ItemCalculoResultadoRubricaFuncionarioFolhaCache adicionar(FolhaPagamento folhaPagamento, Pessoa pessoa, Rubrica rubrica, ItemCalculoResultado itemCalculoResultado) {
		
		if (rubrica != null) {
			if (mapaCache.containsKey(folhaPagamento)) {
				if (mapaCache.get(folhaPagamento).containsKey(pessoa)) {
					mapaCache.get(folhaPagamento).get(pessoa).add(new ItemCache(rubrica, itemCalculoResultado));
				} else {
					List<ItemCache> listaPessoa = new ArrayList<>();
					listaPessoa.add(new ItemCache(rubrica, itemCalculoResultado));
					mapaCache.get(folhaPagamento).put(pessoa, listaPessoa);
				}
			} else {
				Map<Pessoa, List<ItemCache>> mapaPessoa = new HashMap<>();
				List<ItemCache> listaPessoa = new ArrayList<>();
				listaPessoa.add(new ItemCache(rubrica, itemCalculoResultado));
				mapaPessoa.put(pessoa, listaPessoa);
				mapaCache.put(folhaPagamento, mapaPessoa);
			}
		}
		return this;
	}
	
	public ItemCalculoResultadoRubricaFuncionarioFolhaCache limpar() {
		mapaCache = new HashMap<>();
		return this;
	}
	
	private class ItemCache implements Serializable {

		private static final long serialVersionUID = -5445812807956479168L;
		
		Rubrica rubrica = null;
		ItemCalculoResultado itemCalculoResultado = null;
		
		public ItemCache(Rubrica rubrica, ItemCalculoResultado itemCalculoResultado) {
			super();
			this.rubrica = rubrica;
			this.itemCalculoResultado = itemCalculoResultado;
		}

		public Rubrica getRubrica() {
			return rubrica;
		}
		
		public ItemCalculoResultado getItemCalculoResultado() {
			return itemCalculoResultado;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + ((itemCalculoResultado == null) ? 0 : itemCalculoResultado.hashCode());
			result = prime * result + ((rubrica == null) ? 0 : rubrica.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			ItemCache other = (ItemCache) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (itemCalculoResultado == null) {
				if (other.itemCalculoResultado != null)
					return false;
			} else if (!itemCalculoResultado.equals(other.itemCalculoResultado))
				return false;
			if (rubrica == null) {
				if (other.rubrica != null)
					return false;
			} else if (!rubrica.equals(other.rubrica))
				return false;
			return true;
		}

		private ItemCalculoResultadoRubricaFuncionarioFolhaCache getOuterType() {
			return ItemCalculoResultadoRubricaFuncionarioFolhaCache.this;
		}
		
	}

}