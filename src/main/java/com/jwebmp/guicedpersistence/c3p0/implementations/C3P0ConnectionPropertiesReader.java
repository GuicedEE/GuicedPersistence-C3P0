package com.jwebmp.guicedpersistence.c3p0.implementations;

import com.jwebmp.guicedpersistence.services.IPropertiesEntityManagerReader;
import com.oracle.jaxb21.PersistenceUnit;
import com.oracle.jaxb21.PersistenceUnitTransactionType;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Adds in the necessary properties to enable C3P0 for Hibernate
 */
public class C3P0ConnectionPropertiesReader
		implements IPropertiesEntityManagerReader
{
	/**
	 * A map of properties specific to a persistence unit
	 */
	private static final Map<String, C3P0ConnectionPropertiesReader> persistenceUnitSpecificMappings = new HashMap<>();
	/**
	 * The default properties to apply
	 */
	private static final C3P0ConnectionPropertiesReader defaultProperties = new C3P0ConnectionPropertiesReader();

	private static final String minSize = "hibernate.c3p0.min_size";
	private static final String maxSize = "hibernate.c3p0.max_size";
	private static final String acquireIncrement = "hibernate.c3p0.acquire_increment";
	private static final String idleTestPeriod = "hibernate.c3p0.idle_test_period";
	private static final String max_statements = "hibernate.c3p0.max_statements";
	private static final String timeout = "hibernate.c3p0.timeout";

	/**
	 * The default minimum pool size
	 */
	private static int defaultMinSize = 10;
	/**
	 * The default minimum max size
	 */
	private static int defaultMaxSize = 20;
	/**
	 * The default idle test period
	 */
	private static int defaultIncrementSize = 1;
	/**
	 * The default idle test period
	 */
	private static int defaultIdleTestPeriod = 3000;
	/**
	 * The default max statements
	 */
	private static int defaultMaxStatements = 50;
	/**
	 * The default connection timeout
	 */
	private static int defaultTimeout = 1800;

	/**
	 * Method getMinSize returns the minSize of this C3P0ConnectionPropertiesReader object.
	 *
	 * @return the minSize (type String) of this C3P0ConnectionPropertiesReader object.
	 */
	public static String getMinSize()
	{
		return minSize;
	}

	/**
	 * Method getMaxSize returns the maxSize of this C3P0ConnectionPropertiesReader object.
	 *
	 * @return the maxSize (type String) of this C3P0ConnectionPropertiesReader object.
	 */
	public static String getMaxSize()
	{
		return maxSize;
	}

	/**
	 * Method getAcquireIncrement returns the acquireIncrement of this C3P0ConnectionPropertiesReader object.
	 *
	 * @return the acquireIncrement (type String) of this C3P0ConnectionPropertiesReader object.
	 */
	public static String getAcquireIncrement()
	{
		return acquireIncrement;
	}

	/**
	 * Method getIdleTestPeriod returns the idleTestPeriod of this C3P0ConnectionPropertiesReader object.
	 *
	 * @return the idleTestPeriod (type String) of this C3P0ConnectionPropertiesReader object.
	 */
	public static String getIdleTestPeriod()
	{
		return idleTestPeriod;
	}

	/**
	 * Method getMax_statements returns the max_statements of this C3P0ConnectionPropertiesReader object.
	 *
	 * @return the max_statements (type String) of this C3P0ConnectionPropertiesReader object.
	 */
	public static String getMax_statements()
	{
		return max_statements;
	}

	/**
	 * Method getTimeout returns the timeout of this C3P0ConnectionPropertiesReader object.
	 *
	 * @return the timeout (type String) of this C3P0ConnectionPropertiesReader object.
	 */
	public static String getTimeout()
	{
		return timeout;
	}

	/**
	 * Method getDefaultMinSize returns the defaultMinSize of this C3P0ConnectionPropertiesReader object.
	 * <p>
	 * The default minimum pool size
	 *
	 * @return the defaultMinSize (type int) of this C3P0ConnectionPropertiesReader object.
	 */
	public static int getDefaultMinSize()
	{
		return defaultMinSize;
	}

	/**
	 * Method setDefaultMinSize sets the defaultMinSize of this C3P0ConnectionPropertiesReader object.
	 * <p>
	 * The default minimum pool size
	 *
	 * @param defaultMinSize
	 * 		the defaultMinSize of this C3P0ConnectionPropertiesReader object.
	 */
	public static void setDefaultMinSize(int defaultMinSize)
	{
		C3P0ConnectionPropertiesReader.defaultMinSize = defaultMinSize;
	}

	/**
	 * Method getDefaultMaxSize returns the defaultMaxSize of this C3P0ConnectionPropertiesReader object.
	 * <p>
	 * The default minimum max size
	 *
	 * @return the defaultMaxSize (type int) of this C3P0ConnectionPropertiesReader object.
	 */
	public static int getDefaultMaxSize()
	{
		return defaultMaxSize;
	}

	/**
	 * Method setDefaultMaxSize sets the defaultMaxSize of this C3P0ConnectionPropertiesReader object.
	 * <p>
	 * The default minimum max size
	 *
	 * @param defaultMaxSize
	 * 		the defaultMaxSize of this C3P0ConnectionPropertiesReader object.
	 */
	public static void setDefaultMaxSize(int defaultMaxSize)
	{
		C3P0ConnectionPropertiesReader.defaultMaxSize = defaultMaxSize;
	}

	/**
	 * Method getDefaultIncrementSize returns the defaultIncrementSize of this C3P0ConnectionPropertiesReader object.
	 * <p>
	 * The default idle test period
	 *
	 * @return the defaultIncrementSize (type int) of this C3P0ConnectionPropertiesReader object.
	 */
	public static int getDefaultIncrementSize()
	{
		return defaultIncrementSize;
	}

	/**
	 * Method setDefaultIncrementSize sets the defaultIncrementSize of this C3P0ConnectionPropertiesReader object.
	 * <p>
	 * The default idle test period
	 *
	 * @param defaultIncrementSize
	 * 		the defaultIncrementSize of this C3P0ConnectionPropertiesReader object.
	 */
	public static void setDefaultIncrementSize(int defaultIncrementSize)
	{
		C3P0ConnectionPropertiesReader.defaultIncrementSize = defaultIncrementSize;
	}

	/**
	 * Method getDefaultIdleTestPeriod returns the defaultIdleTestPeriod of this C3P0ConnectionPropertiesReader object.
	 * <p>
	 * The default idle test period
	 *
	 * @return the defaultIdleTestPeriod (type int) of this C3P0ConnectionPropertiesReader object.
	 */
	public static int getDefaultIdleTestPeriod()
	{
		return defaultIdleTestPeriod;
	}

	/**
	 * Method setDefaultIdleTestPeriod sets the defaultIdleTestPeriod of this C3P0ConnectionPropertiesReader object.
	 * <p>
	 * The default idle test period
	 *
	 * @param defaultIdleTestPeriod
	 * 		the defaultIdleTestPeriod of this C3P0ConnectionPropertiesReader object.
	 */
	public static void setDefaultIdleTestPeriod(int defaultIdleTestPeriod)
	{
		C3P0ConnectionPropertiesReader.defaultIdleTestPeriod = defaultIdleTestPeriod;
	}

	/**
	 * Method getDefaultMaxStatements returns the defaultMaxStatements of this C3P0ConnectionPropertiesReader object.
	 * <p>
	 * The default max statements
	 *
	 * @return the defaultMaxStatements (type int) of this C3P0ConnectionPropertiesReader object.
	 */
	public static int getDefaultMaxStatements()
	{
		return defaultMaxStatements;
	}

	/**
	 * Method setDefaultMaxStatements sets the defaultMaxStatements of this C3P0ConnectionPropertiesReader object.
	 * <p>
	 * The default max statements
	 *
	 * @param defaultMaxStatements
	 * 		the defaultMaxStatements of this C3P0ConnectionPropertiesReader object.
	 */
	public static void setDefaultMaxStatements(int defaultMaxStatements)
	{
		C3P0ConnectionPropertiesReader.defaultMaxStatements = defaultMaxStatements;
	}

	/**
	 * Method getDefaultTimeout returns the defaultTimeout of this C3P0ConnectionPropertiesReader object.
	 * <p>
	 * The default connection timeout
	 *
	 * @return the defaultTimeout (type int) of this C3P0ConnectionPropertiesReader object.
	 */
	public static int getDefaultTimeout()
	{
		return defaultTimeout;
	}

	/**
	 * Method setDefaultTimeout sets the defaultTimeout of this C3P0ConnectionPropertiesReader object.
	 * <p>
	 * The default connection timeout
	 *
	 * @param defaultTimeout
	 * 		the defaultTimeout of this C3P0ConnectionPropertiesReader object.
	 */
	public static void setDefaultTimeout(int defaultTimeout)
	{
		C3P0ConnectionPropertiesReader.defaultTimeout = defaultTimeout;
	}

	/**
	 * Goes through the defaults then applies per annotated unit
	 *
	 * @param persistenceUnit
	 * 		The unit
	 * @param incomingProperties
	 * 		The properties
	 *
	 * @return The string,string map to apply
	 *
	 * @see com.jwebmp.guicedpersistence.services.IPropertiesEntityManagerReader#processProperties(PersistenceUnit, Properties)
	 */
	@Override
	public Map<String, String> processProperties(PersistenceUnit persistenceUnit, Properties incomingProperties)
	{
		Map<String, String> props = new HashMap<>();
		C3P0ConnectionPropertiesReader.getDefaultProperties()
		                              .process(persistenceUnit, incomingProperties);
		if (C3P0ConnectionPropertiesReader.getPersistenceUnitSpecificMappings()
		                                  .containsKey(persistenceUnit.getName()))
		{
			C3P0ConnectionPropertiesReader.getPersistenceUnitSpecificMappings()
			                              .get(persistenceUnit.getName())
			                              .process(persistenceUnit, incomingProperties);
		}
		return props;
	}

	/**
	 * Method process ...
	 *
	 * @param persistenceUnit
	 * 		of type PersistenceUnit
	 * @param incomingProperties
	 * 		of type Properties
	 *
	 * @return Map String   ,       String
	 */
	public Map<String, String> process(PersistenceUnit persistenceUnit, Properties incomingProperties)
	{
		Map<String, String> props = new HashMap<>();
		if (persistenceUnit.getJtaDataSource() == null && (persistenceUnit.getTransactionType() == null || persistenceUnit.getTransactionType()
		                                                                                                                  .equals(PersistenceUnitTransactionType.RESOURCE_LOCAL)))
		{
			incomingProperties.put("hibernate.connection.provider_class", "org.hibernate.connection.C3P0ConnectionProvider");
			if (!incomingProperties.containsKey(C3P0ConnectionPropertiesReader.minSize))
			{
				incomingProperties.put(C3P0ConnectionPropertiesReader.minSize, Integer.toString(C3P0ConnectionPropertiesReader.defaultMinSize));
			}
			if (!incomingProperties.containsKey(C3P0ConnectionPropertiesReader.maxSize))
			{
				incomingProperties.put(C3P0ConnectionPropertiesReader.maxSize, Integer.toString(C3P0ConnectionPropertiesReader.defaultMaxSize));
			}
			if (!incomingProperties.containsKey(C3P0ConnectionPropertiesReader.acquireIncrement))
			{
				incomingProperties.put(C3P0ConnectionPropertiesReader.acquireIncrement, Integer.toString(C3P0ConnectionPropertiesReader.defaultIncrementSize));
			}
			if (!incomingProperties.containsKey(C3P0ConnectionPropertiesReader.idleTestPeriod))
			{
				incomingProperties.put(C3P0ConnectionPropertiesReader.idleTestPeriod, Integer.toString(C3P0ConnectionPropertiesReader.defaultIdleTestPeriod));
			}
			if (!incomingProperties.containsKey(C3P0ConnectionPropertiesReader.max_statements))
			{
				incomingProperties.put(C3P0ConnectionPropertiesReader.max_statements, Integer.toString(C3P0ConnectionPropertiesReader.defaultMaxStatements));
			}
			if (!incomingProperties.containsKey(C3P0ConnectionPropertiesReader.minSize))
			{
				incomingProperties.put(C3P0ConnectionPropertiesReader.timeout, Integer.toString(C3P0ConnectionPropertiesReader.defaultTimeout));
			}
		}
		return props;
	}

	/**
	 * Method getDefaultProperties returns the defaultProperties of this C3P0ConnectionPropertiesReader object.
	 * <p>
	 * The default properties to apply
	 *
	 * @return the defaultProperties (type C3P0ConnectionPropertiesReader) of this C3P0ConnectionPropertiesReader object.
	 */
	public static C3P0ConnectionPropertiesReader getDefaultProperties()
	{
		return defaultProperties;
	}

	/**
	 * Method getPersistenceUnitSpecificMappings returns the persistenceUnitSpecificMappings of this C3P0ConnectionPropertiesReader object.
	 * <p>
	 * A map of properties specific to a persistence unit
	 *
	 * @return the persistenceUnitSpecificMappings (type Map String, C3P0ConnectionPropertiesReader ) of this C3P0ConnectionPropertiesReader object.
	 */
	public static Map<String, C3P0ConnectionPropertiesReader> getPersistenceUnitSpecificMappings()
	{
		return persistenceUnitSpecificMappings;
	}
}
