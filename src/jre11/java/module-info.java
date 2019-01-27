module com.jwebmp.guicedpersistence.c3p0 {

	exports com.jwebmp.guicedpersistence.c3p0;

	requires com.jwebmp.guicedpersistence;
	requires com.jwebmp.guicedpersistence.readers.hibernateproperties;
	requires com.jwebmp.guicedinjection;
	requires java.validation;
	requires java.sql;
	requires com.jwebmp.guicedpersistence.jpa;
	requires c3p0;

	provides com.jwebmp.guicedpersistence.services.IPropertiesEntityManagerReader with com.jwebmp.guicedpersistence.c3p0.implementations.C3P0ConnectionPropertiesReader;

	provides com.jwebmp.guicedinjection.interfaces.IGuiceScanModuleExclusions with com.jwebmp.guicedpersistence.c3p0.implementations.C3P0ModuleExclusions;
	provides com.jwebmp.guicedinjection.interfaces.IGuiceScanJarExclusions with com.jwebmp.guicedpersistence.c3p0.implementations.C3P0ModuleExclusions;

}
