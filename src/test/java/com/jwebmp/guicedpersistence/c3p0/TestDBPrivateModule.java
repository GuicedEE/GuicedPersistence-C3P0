package com.jwebmp.guicedpersistence.c3p0;

import com.jwebmp.guicedpersistence.db.DatabaseModule;
import com.jwebmp.guicedpersistence.db.ConnectionBaseInfo;
import com.jwebmp.guicedpersistence.jpa.JPAConnectionBaseInfo;
import com.oracle.jaxb21.PersistenceUnit;

import javax.validation.constraints.NotNull;
import java.lang.annotation.Annotation;
import java.util.Properties;

public class TestDBPrivateModule
		extends DatabaseModule<TestDBPrivateModule>
{

	@NotNull
	@Override
	protected String getPersistenceUnitName()
	{
		return "guiceinjectionh2test";
	}

	@NotNull
	@Override
	protected ConnectionBaseInfo getConnectionBaseInfo(PersistenceUnit unit, Properties filteredProperties)
	{
		return new JPAConnectionBaseInfo().setPersistenceUnitName(unit.getName());
	}

	@NotNull
	@Override
	protected String getJndiMapping()
	{
		return "jdbc/jndi";
	}

	@NotNull
	@Override
	protected Class<? extends Annotation> getBindingAnnotation()
	{
		return TestCustomPersistenceLoader.class;
	}
}
