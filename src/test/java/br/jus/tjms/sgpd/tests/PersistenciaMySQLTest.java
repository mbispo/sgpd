package br.jus.tjms.sgpd.tests;

public class PersistenciaMySQLTest {


	/*
	@Test
	public void deveConectarNoBancoECriarOuAtualizarEstrutura() {
		
		Exception exception = null;

		try {
			
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysql");
			
			Map<String,Object> parametros = emf.getProperties();
			
			String auto = (String) parametros.get("hibernate.hbm2ddl.auto");
			
			assertTrue("Jovenzinho, o parâmetro 'hibernate.hbm2ddl.auto' não está definido no persistence.xml...", auto != null);
			assertTrue("Jovenzinho, o parâmetro 'hibernate.hbm2ddl.auto' precisar estar definido como 'create-drop' ou 'update' no persistence.xml...", auto.equalsIgnoreCase("update") || auto.equalsIgnoreCase("create-drop"));
			
			EntityManager em = emf.createEntityManager();

			@SuppressWarnings("unused")
			Pessoa p = em.find(Pessoa.class, 1L);

		} catch (Exception e) {
			e.printStackTrace();
			exception = e;
		}

		assertEquals(null, exception);

	}
	 */
}
