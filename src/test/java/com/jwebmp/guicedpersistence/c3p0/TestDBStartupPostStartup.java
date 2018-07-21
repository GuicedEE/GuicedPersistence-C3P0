package com.jwebmp.guicedpersistence.c3p0;

import com.google.inject.Inject;
import com.google.inject.persist.PersistService;
import com.jwebmp.guicedpersistence.services.IDBStartup;

public class TestDBStartupPostStartup
		implements IDBStartup
{
	@Inject
	public TestDBStartupPostStartup(@TestCustomPersistenceLoader PersistService ps)
	{
		ps.start();
	}

}
