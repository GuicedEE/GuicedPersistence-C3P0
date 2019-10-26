package com.guicedee.guicedpersistence.c3p0;

import com.google.inject.BindingAnnotation;

import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.TYPE_USE, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
@BindingAnnotation
public @interface TestCustomPersistenceLoader2
{

}
