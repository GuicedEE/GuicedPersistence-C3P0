package com.guicedee.guicedpersistence.c3p0.test;

import com.google.inject.Key;
import com.guicedee.client.*;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;

import javax.sql.DataSource;

public class GuicedPersistenceBindingTest
{
	@Test
	public void testMe() throws InterruptedException
	{
		IGuiceContext.registerModule(new TestC3P0DBPrivateModule());
		IGuiceContext.registerModule(new TestC3P0DBTest2PrivateModule());
		IGuiceContext.getContext().inject();

		EntityManager em = IGuiceContext.get(Key.get(EntityManager.class, TestCustomPersistenceLoader.class));
		EntityManager em2 = IGuiceContext.get(Key.get(EntityManager.class, TestCustomPersistenceLoader2.class));

		DataSource ds1 = IGuiceContext.get(Key.get(DataSource.class, TestCustomPersistenceLoader.class));
		DataSource ds2 = IGuiceContext.get(Key.get(DataSource.class, TestCustomPersistenceLoader2.class));
	}
}
