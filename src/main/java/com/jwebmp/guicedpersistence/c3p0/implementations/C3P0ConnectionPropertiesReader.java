package com.jwebmp.guicedpersistence.c3p0.implementations;

import com.jwebmp.guicedpersistence.services.PropertiesEntityManagerReader;
import com.oracle.jaxb21.PersistenceUnit;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Adds in the necessary properties to enable C3P0 for Hibernate
 */
public class C3P0ConnectionPropertiesReader
		implements PropertiesEntityManagerReader
{
	private static final String minSize = "hibernate.c3p0.min_size";
	private static final String maxSize = "hibernate.c3p0.max_size";
	private static final String acquireIncrement = "hibernate.c3p0.acquire_increment";
	private static final String idleTestPeriod = "hibernate.c3p0.idle_test_period";
	private static final String max_statements = "hibernate.c3p0.max_statements";
	private static final String timeout = "hibernate.c3p0.timeout";

	private static int defaultMinSize = 10;
	private static int defaultMaxSize = 20;
	private static int defaultIncrementSize = 1;
	private static int defaultIdleTestPeriod = 3000;
	private static int defaultMaxStatements = 50;
	private static int defaultTimeout = 1800;

	public static int getDefaultMinSize()
	{
		return C3P0ConnectionPropertiesReader.defaultMinSize;
	}

	public static void setDefaultMinSize(int defaultMinSize)
	{
		C3P0ConnectionPropertiesReader.defaultMinSize = defaultMinSize;
	}

	public static int getDefaultMaxSize()
	{
		return C3P0ConnectionPropertiesReader.defaultMaxSize;
	}

	public static void setDefaultMaxSize(int defaultMaxSize)
	{
		C3P0ConnectionPropertiesReader.defaultMaxSize = defaultMaxSize;
	}

	public static int getDefaultIncrementSize()
	{
		return C3P0ConnectionPropertiesReader.defaultIncrementSize;
	}

	public static void setDefaultIncrementSize(int defaultIncrementSize)
	{
		C3P0ConnectionPropertiesReader.defaultIncrementSize = defaultIncrementSize;
	}

	public static int getDefaultIdleTestPeriod()
	{
		return C3P0ConnectionPropertiesReader.defaultIdleTestPeriod;
	}

	public static void setDefaultIdleTestPeriod(int defaultIdleTestPeriod)
	{
		C3P0ConnectionPropertiesReader.defaultIdleTestPeriod = defaultIdleTestPeriod;
	}

	public static int getDefaultMaxStatements()
	{
		return C3P0ConnectionPropertiesReader.defaultMaxStatements;
	}

	public static void setDefaultMaxStatements(int defaultMaxStatements)
	{
		C3P0ConnectionPropertiesReader.defaultMaxStatements = defaultMaxStatements;
	}

	public static int getDefaultTimeout()
	{
		return C3P0ConnectionPropertiesReader.defaultTimeout;
	}

	public static void setDefaultTimeout(int defaultTimeout)
	{
		C3P0ConnectionPropertiesReader.defaultTimeout = defaultTimeout;
	}

	@Override
	public Map<String, String> processProperties(PersistenceUnit persistenceUnit, Properties properties)
	{
		Map<String, String> props = new HashMap<>();
		if (!properties.containsKey(C3P0ConnectionPropertiesReader.minSize))
		{
			props.put(C3P0ConnectionPropertiesReader.minSize, Integer.toString(C3P0ConnectionPropertiesReader.defaultMinSize));
		}
		if (!properties.containsKey(C3P0ConnectionPropertiesReader.maxSize))
		{
			props.put(C3P0ConnectionPropertiesReader.maxSize, Integer.toString(C3P0ConnectionPropertiesReader.defaultMaxSize));
		}
		if (!properties.containsKey(C3P0ConnectionPropertiesReader.acquireIncrement))
		{
			props.put(C3P0ConnectionPropertiesReader.acquireIncrement, Integer.toString(C3P0ConnectionPropertiesReader.defaultIncrementSize));
		}
		if (!properties.containsKey(C3P0ConnectionPropertiesReader.idleTestPeriod))
		{
			props.put(C3P0ConnectionPropertiesReader.idleTestPeriod, Integer.toString(C3P0ConnectionPropertiesReader.defaultIdleTestPeriod));
		}
		if (!properties.containsKey(C3P0ConnectionPropertiesReader.max_statements))
		{
			props.put(C3P0ConnectionPropertiesReader.max_statements, Integer.toString(C3P0ConnectionPropertiesReader.defaultMaxStatements));
		}
		if (!properties.containsKey(C3P0ConnectionPropertiesReader.minSize))
		{
			props.put(C3P0ConnectionPropertiesReader.timeout, Integer.toString(C3P0ConnectionPropertiesReader.defaultTimeout));
		}
		return props;
	}
}
