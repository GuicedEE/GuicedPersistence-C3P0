import com.jwebmp.guicedinjection.interfaces.IGuiceScanJarExclusions;
import com.jwebmp.guicedinjection.interfaces.IGuiceScanModuleExclusions;
import com.jwebmp.guicedpersistence.c3p0.implementations.C3P0ConnectionPropertiesReader;
import com.jwebmp.guicedpersistence.c3p0.implementations.C3P0ModuleExclusions;
import com.jwebmp.guicedpersistence.services.PropertiesEntityManagerReader;

module com.jwebmp.guicedpersistence.c3p0 {
	exports com.jwebmp.guicedpersistence.c3p0.implementations;

	requires com.jwebmp.guicedpersistence;
	requires com.jwebmp.guicedpersistence.readers.hibernateproperties;
	requires com.jwebmp.guicedinjection;
	requires java.validation;

	provides PropertiesEntityManagerReader with C3P0ConnectionPropertiesReader;

	provides IGuiceScanModuleExclusions with C3P0ModuleExclusions;
	provides IGuiceScanJarExclusions with C3P0ModuleExclusions;

}
