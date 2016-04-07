package com.guille.util.exceptions;

/**
 * Just joking...
 * 
 * @author Guillermo Facundo Colunga
 * @version 2.2
 */
public class HijoPutaException extends Exception {

    private static final long serialVersionUID = 1L;

    public HijoPutaException() {
    }

    public HijoPutaException(String message) {
	super("JUST JOKING --> " + message);
    }

    public HijoPutaException(Throwable cause) {
	super(cause);
    }

    public HijoPutaException(String message, Throwable cause) {
	super(message, cause);
    }

    public HijoPutaException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
	super(message, cause, enableSuppression, writableStackTrace);
    }

}
