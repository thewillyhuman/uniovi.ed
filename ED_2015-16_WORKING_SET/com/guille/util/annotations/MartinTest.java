package com.guille.util.annotations;

/**
 * Annotation only for Martin's tests in order to provide them with a priority
 * at execution time.
 * 
 * @author Guillermo Facundo Colunga
 */
public @interface MartinTest {

	public enum Priority {
		LOW, MEDIUM, HIGH
	}

	Priority priority() default Priority.HIGH;

	String author() default "Martin Gonzalez";

	Priority value();
}
