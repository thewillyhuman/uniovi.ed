package com.guille.util.annotations;

/**
 * Annotation only for Martin's tests in order to provide them with a priority
 * at execution time.
 * 
 * @author Guillermo Facundo Colunga
 * @version carlos.2
 * @deprecated This annotation may not be included in future versions.
 */
public @interface MartinTest {

	public enum Priority {
		LOW, MEDIUM, HIGH
	}

	Priority priority() default Priority.HIGH;

	String author() default "Martin Gonzalez";

	Priority value();
}
