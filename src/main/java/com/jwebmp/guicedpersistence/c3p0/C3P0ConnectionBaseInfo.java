package com.jwebmp.guicedpersistence.c3p0;

import com.jwebmp.guicedpersistence.c3p0.implementations.C3P0ConnectionPropertiesReader;
import com.jwebmp.guicedpersistence.db.ConnectionBaseInfo;
import com.jwebmp.guicedpersistence.jpa.JPAConnectionBaseInfo;
import com.jwebmp.logger.LogFactory;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.oracle.jaxb21.PersistenceUnit;

import javax.sql.DataSource;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class C3P0ConnectionBaseInfo
		extends JPAConnectionBaseInfo
{
	private static final Logger log = LogFactory.getLog(C3P0ConnectionBaseInfo.class.getName());

	@Override
	public ConnectionBaseInfo populateFromProperties(PersistenceUnit unit, Properties filteredProperties)
	{
		ConnectionBaseInfo cbi = super.populateFromProperties(unit, filteredProperties);
		C3P0ConnectionPropertiesReader.getPersistenceUnitSpecificMappings()
		                              .put(unit.getName(), new C3P0ConnectionPropertiesReader());
		return cbi;
	}

	@Override
	public DataSource toPooledDatasource()
	{
		ComboPooledDataSource cpds = new ComboPooledDataSource();
		if (getDriverClass() == null)
		{
			try
			{
				cpds.setDriverClass(getDriverClass());
			}
			catch (Exception e)
			{
				log.log(Level.WARNING, "Cannot set driver class for C3P0 Combo Pooled Data Source", e);
			}
		}

		if (getUrl() != null)
		{
			cpds.setJdbcUrl(getUrl());
		}
		if (getUsername() != null)
		{
			cpds.setUser("root");
		}
		if (getPassword() != null)
		{
			cpds.setPassword("root");
		}

		// the settings below are optional -- c3p0 can work with defaults
		if (getMinPoolSize() != null)
		{
			cpds.setMinPoolSize(getMinPoolSize());
		}
		else
		{
			cpds.setMinPoolSize(5);
		}
		if (getAcquireIncrement() != null)
		{
			cpds.setAcquireIncrement(getAcquireIncrement());
		}
		else
		{
			cpds.setAcquireIncrement(5);
		}
		if (getMaxPoolSize() != null)
		{
			cpds.setMaxPoolSize(getMaxPoolSize());
		}
		else
		{
			cpds.setMaxPoolSize(20);
		}

		if (getPreparedStatementCacheSize() != null)
		{
			cpds.setMaxStatements(getPreparedStatementCacheSize());
		}
		else
		{
			cpds.setMaxStatements(180);
		}

		return cpds;
	}


}
