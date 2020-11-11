module com.guicedee.guicedpersistence.c3p0 {
	exports com.guicedee.guicedpersistence.c3p0;
	requires transitive com.guicedee.guicedpersistence;
	requires c3p0;

	requires java.sql;

	provides com.guicedee.guicedpersistence.services.IPropertiesEntityManagerReader with com.guicedee.guicedpersistence.c3p0.implementations.C3P0ConnectionPropertiesReader;

}
