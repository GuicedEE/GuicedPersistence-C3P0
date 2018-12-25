package com.jwebmp.guicedpersistence.c3p0;

import com.jwebmp.guicedpersistence.jpa.JPAConnectionBaseInfo;
import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;

public class C3P0ConnectionBaseInfo
		extends JPAConnectionBaseInfo
{
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
				e.printStackTrace();
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
