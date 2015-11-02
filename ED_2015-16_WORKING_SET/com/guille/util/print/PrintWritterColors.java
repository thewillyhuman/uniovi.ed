package com.guille.util.print;

import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class PrintWritterColors extends PrintWriter {
	
	public static final String BLACK = "\u001B[30m";
	public static final String RED = "\u001B[31m";
	public static final String GREEN = "\u001B[32m";
	public static final String YELLOW = "\u001B[33m";
	public static final String BLUE = "\u001B[34m";
	public static final String PURPLE = "\u001B[35m";
	public static final String CYAN = "\u001B[36m";
	public static final String WHITE = "\u001B[37m";
	//Reset code
	public static final String RESET = "\u001B[0m";
	
	public enum PrintColor {

		  BLACK("\u001B[30m"),
		  RED("\u001B[31m"),
		  GREEN("\u001B[32m"),
		  YELLOW("\u001B[33m"),
		  BLUE("\u001B[34m"),
		  PURPLE("\u001B[35m"),
		  CYAN("\u001B[36m"),
		  WHITE("\u001B[37m");

		  private String ansiColor;

		  PrintColor(String ansiColor) {
		    this.ansiColor = ansiColor;
		  }

		  public String getAnsiColor() {
		    return ansiColor;
		  }
	}
	
	 public PrintWritterColors(PrintStream out) throws UnsupportedEncodingException {
		    super(new OutputStreamWriter(out, "UTF-8"), true);
		  }

		  public void println(PrintColor color, String string) {
		    print(color.getAnsiColor());
		    print(string);
		    println(RESET);
		    flush();
		  }

		  public void green(String string) {
		    println(PrintColor.GREEN, string);
		  }

		  public void red(String string) {
		    println(PrintColor.RED, string);
		  }
}
