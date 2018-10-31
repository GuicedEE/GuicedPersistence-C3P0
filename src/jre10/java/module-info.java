import com.jwebmp.guicedpersistence.c3p0.implementations.C3P0ConnectionPropertiesReader;
import com.jwebmp.guicedpersistence.services.PropertiesEntityManagerReader;

module com.jwebmp.guicedpersistence.c3p0 {
	exports com.jwebmp.guicedpersistence.c3p0.implementations;

	requires transitive com.jwebmp.guicedpersistence;
	requires transitive com.jwebmp.guicedpersistence.readers.hibernateproperties;

	provides PropertiesEntityManagerReader with C3P0ConnectionPropertiesReader;
}
