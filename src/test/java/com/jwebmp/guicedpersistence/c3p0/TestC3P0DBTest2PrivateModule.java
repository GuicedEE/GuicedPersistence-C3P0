package com.jwebmp.guicedpersistence.c3p0;

import com.jwebmp.guicedpersistence.db.ConnectionBaseInfo;
import com.jwebmp.guicedpersistence.db.DatabaseModule;
import com.jwebmp.guicedpersistence.jpa.JPAConnectionBaseInfo;
import com.oracle.jaxb21.PersistenceUnit;

import javax.validation.constraints.NotNull;
import java.lang.annotation.Annotation;
import java.util.Properties;

public class TestC3P0DBTest2PrivateModule
		extends DatabaseModule<TestC3P0DBTest2PrivateModule>
{
	@NotNull
	@Override
	protected String getPersistenceUnitName()
	{
		return "c3p0unittest_2";
	}

	@NotNull
	@Override
	protected ConnectionBaseInfo getConnectionBaseInfo(PersistenceUnit unit, Properties filteredProperties)
	{
		return new C3P0ConnectionBaseInfo().setPersistenceUnitName(unit.getName());
	}

	@NotNull
	@Override
	protected String getJndiMapping()
	{
		return "jdbc/jndi2";
	}

	@NotNull
	@Override
	protected Class<? extends Annotation> getBindingAnnotation()
	{
		return TestCustomPersistenceLoader2.class;
	}
}
