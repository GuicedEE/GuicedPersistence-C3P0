module guiced.persistence.c3p0.test {
	requires com.guicedee.guicedpersistence.c3p0;
	requires org.junit.platform.commons;
	requires org.junit.jupiter.api;
	
	opens com.guicedee.guicedpersistence.c3p0.test.entities to org.hibernate.orm.core;
	opens com.guicedee.guicedpersistence.c3p0.test to org.hibernate.orm.core,org.junit.platform.commons;
	
}