import com.jwebmp.guicedpersistence.c3p0.implementations.C3P0ConnectionPropertiesReader;
import com.jwebmp.guicedpersistence.services.PropertiesEntityManagerReader;

module com.jwebmp.guicedpersistence.c3p0 {
	exports com.jwebmp.guicedpersistence.c3p0.implementations;

	requires com.jwebmp.guicedpersistence;
	requires com.jwebmp.guicedpersistence.readers.hibernateproperties;

	provides PropertiesEntityManagerReader with C3P0ConnectionPropertiesReader;
}
