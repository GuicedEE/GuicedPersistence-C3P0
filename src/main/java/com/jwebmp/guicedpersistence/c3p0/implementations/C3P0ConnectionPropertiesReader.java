package com.jwebmp.guicedpersistence.c3p0.implementations;

import com.jwebmp.guicedpersistence.db.PropertiesEntityManagerReader;

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

	@Override
	public Map<String, String> processProperties(Properties properties)
	{
		Map<String, String> props = new HashMap<>();
		if (!properties.containsKey(minSize))
		{
			props.put(minSize, Integer.toString(defaultMinSize));
		}
		if (!properties.containsKey(maxSize))
		{
			props.put(maxSize, Integer.toString(defaultMaxSize));
		}
		if (!properties.containsKey(acquireIncrement))
		{
			props.put(acquireIncrement, Integer.toString(defaultIncrementSize));
		}
		if (!properties.containsKey(idleTestPeriod))
		{
			props.put(idleTestPeriod, Integer.toString(defaultIdleTestPeriod));
		}
		if (!properties.containsKey(max_statements))
		{
			props.put(max_statements, Integer.toString(defaultMaxStatements));
		}
		if (!properties.containsKey(minSize))
		{
			props.put(timeout, Integer.toString(defaultTimeout));
		}
		return props;
	}

	public static int getDefaultMinSize()
	{
		return defaultMinSize;
	}

	public static void setDefaultMinSize(int defaultMinSize)
	{
		C3P0ConnectionPropertiesReader.defaultMinSize = defaultMinSize;
	}

	public static int getDefaultMaxSize()
	{
		return defaultMaxSize;
	}

	public static void setDefaultMaxSize(int defaultMaxSize)
	{
		C3P0ConnectionPropertiesReader.defaultMaxSize = defaultMaxSize;
	}

	public static int getDefaultIncrementSize()
	{
		return defaultIncrementSize;
	}

	public static void setDefaultIncrementSize(int defaultIncrementSize)
	{
		C3P0ConnectionPropertiesReader.defaultIncrementSize = defaultIncrementSize;
	}

	public static int getDefaultIdleTestPeriod()
	{
		return defaultIdleTestPeriod;
	}

	public static void setDefaultIdleTestPeriod(int defaultIdleTestPeriod)
	{
		C3P0ConnectionPropertiesReader.defaultIdleTestPeriod = defaultIdleTestPeriod;
	}

	public static int getDefaultMaxStatements()
	{
		return defaultMaxStatements;
	}

	public static void setDefaultMaxStatements(int defaultMaxStatements)
	{
		C3P0ConnectionPropertiesReader.defaultMaxStatements = defaultMaxStatements;
	}

	public static int getDefaultTimeout()
	{
		return defaultTimeout;
	}

	public static void setDefaultTimeout(int defaultTimeout)
	{
		C3P0ConnectionPropertiesReader.defaultTimeout = defaultTimeout;
	}
}
