package com.guicedee.guicedpersistence.c3p0.test;

import com.guicedee.guicedpersistence.c3p0.*;
import com.guicedee.guicedpersistence.db.ConnectionBaseInfo;
import com.guicedee.guicedpersistence.db.DatabaseModule;
import org.hibernate.jpa.boot.internal.ParsedPersistenceXmlDescriptor;

import jakarta.validation.constraints.NotNull;
import java.lang.annotation.Annotation;
import java.util.Properties;

public class TestC3P0DBPrivateModule
		extends DatabaseModule<TestC3P0DBPrivateModule>
{
	@NotNull
	@Override
	protected String getPersistenceUnitName()
	{
		return "c3p0unittest";
	}

	@NotNull
	@Override
	protected ConnectionBaseInfo getConnectionBaseInfo(ParsedPersistenceXmlDescriptor unit, Properties filteredProperties)
	{
		return new C3P0ConnectionBaseInfo().setPersistenceUnitName(unit.getName());
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
