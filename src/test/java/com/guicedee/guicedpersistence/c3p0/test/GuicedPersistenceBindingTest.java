package com.guicedee.guicedpersistence.c3p0.test;

import com.google.inject.Key;
import com.google.inject.name.Names;
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

		EntityManager em = IGuiceContext.get(Key.get(EntityManager.class, Names.named("c3p0unittest")));
		EntityManager em2 = IGuiceContext.get(Key.get(EntityManager.class, Names.named("c3p0unittest_2")));

		DataSource ds1 = IGuiceContext.get(Key.get(DataSource.class, Names.named("c3p0unittest")));
		DataSource ds2 = IGuiceContext.get(Key.get(DataSource.class, Names.named("c3p0unittest_2")));
	}
}
