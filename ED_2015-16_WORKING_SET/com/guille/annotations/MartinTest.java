package com.guille.annotations;

public @interface MartinTest {

	public enum Priority {
		   LOW, MEDIUM, HIGH
	}

	Priority priority() default Priority.HIGH;
	
	String author() default "Martin Gonzalez";
	
	Priority value();
}
