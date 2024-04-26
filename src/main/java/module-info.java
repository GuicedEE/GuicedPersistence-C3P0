module com.guicedee.guicedpersistence.c3p0 {
	exports com.guicedee.guicedpersistence.c3p0;
	
	requires transitive com.guicedee.guicedpersistence;
	requires org.hibernate.orm.c3p0;
	
	requires static lombok;
	
	requires java.sql;

	provides com.guicedee.guicedpersistence.services.IPropertiesEntityManagerReader with com.guicedee.guicedpersistence.c3p0.implementations.C3P0ConnectionPropertiesReader;

}
