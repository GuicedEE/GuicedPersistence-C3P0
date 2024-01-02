package com.guicedee.guicedpersistence.c3p0;

import com.google.inject.Key;
import com.guicedee.guicedinjection.GuiceContext;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;

import javax.sql.DataSource;

public class GuicedPersistenceBindingTest
{
	@Test
	public void testMe() throws InterruptedException
	{
		GuiceContext.registerModule(new TestC3P0DBPrivateModule());
		GuiceContext.registerModule(new TestC3P0DBTest2PrivateModule());
		GuiceContext.inject();

		EntityManager em = GuiceContext.get(Key.get(EntityManager.class, TestCustomPersistenceLoader.class));
		EntityManager em2 = GuiceContext.get(Key.get(EntityManager.class, TestCustomPersistenceLoader2.class));

		DataSource ds1 = GuiceContext.get(Key.get(DataSource.class, TestCustomPersistenceLoader.class));
		DataSource ds2 = GuiceContext.get(Key.get(DataSource.class, TestCustomPersistenceLoader2.class));
	}
}
