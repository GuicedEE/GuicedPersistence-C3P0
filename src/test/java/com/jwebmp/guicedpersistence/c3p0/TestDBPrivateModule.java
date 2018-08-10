package com.jwebmp.guicedpersistence.c3p0;

import com.jwebmp.guicedpersistence.db.AbstractDatabaseProviderModule;
import com.jwebmp.guicedpersistence.db.ConnectionBaseInfo;
import com.jwebmp.guicedpersistence.jpa.JPAConnectionBaseInfo;
import com.oracle.jaxb21.PersistenceUnit;

import java.lang.annotation.Annotation;
import java.util.Properties;

public class TestDBPrivateModule
		extends AbstractDatabaseProviderModule
{

	@Override
	protected ConnectionBaseInfo getConnectionBaseInfo(PersistenceUnit unit, Properties filteredProperties)
	{
		return new JPAConnectionBaseInfo().setPersistenceUnitName(unit.getName());
	}

	@Override
	protected String getJndiMapping()
	{
		return "jdbc/jndi";
	}

	@Override
	protected String getPersistenceUnitName()
	{
		return "guiceinjectionh2test";
	}

	@Override
	protected Class<? extends Annotation> getBindingAnnotation()
	{
		return TestCustomPersistenceLoader.class;
	}
}
