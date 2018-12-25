package com.jwebmp.guicedpersistence.c3p0;

import com.google.inject.Key;
import com.jwebmp.guicedinjection.GuiceContext;
import com.jwebmp.logger.LogFactory;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.logging.Level;

public class GuicedPersistenceBindingTest
{
	@Test
	public void testMe() throws InterruptedException
	{
		LogFactory.configureConsoleSingleLineOutput(Level.FINE);
		GuiceContext.inject();

		EntityManager em = GuiceContext.get(Key.get(EntityManager.class, TestCustomPersistenceLoader.class));
		EntityManager em2 = GuiceContext.get(Key.get(EntityManager.class, TestCustomPersistenceLoader2.class));

		DataSource ds1 = GuiceContext.get(Key.get(DataSource.class, TestCustomPersistenceLoader.class));
		DataSource ds2 = GuiceContext.get(Key.get(DataSource.class, TestCustomPersistenceLoader2.class));
	}
}
