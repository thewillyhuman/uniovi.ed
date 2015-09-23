package src;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;

public class TestBench {

	public static final int SLEEP_TIME = 2;
	public static final int START_N = 1; //Initial workload.
	public static final int FINAL_N = 50; //Final workload.
	public static long result = 0;
	public static long mean = 0;
	public static final int SAMPLES = 3 ; //Samples to measure.
	public static final String[] FILE_NAMES =  {"linear_means.csv", "quadratic_means.csv", "cubic_means.csv", "logarithmic_means.csv"};
	public static final String[] ALGORITHMS = {"linear", "quadratic", "cubic", "logarithmic"};
	
	public static void main(String[] args) throws IOException {
		for(int i = 0; i < FILE_NAMES.length; i++)
			TestBench.test(FILE_NAMES[i], ALGORITHMS[i], START_N, FINAL_N, SAMPLES);
	}
	
	public static void test (long n) {
		long i = System.currentTimeMillis();
		Algorithms.linear(n);
		long f = System.currentTimeMillis();
		result = f - i;
		System.out.println("Time to execute = " + result +"ms.");
	}
	
	/**
	 * 
	 * @param o String, output file name, example: quadratic.txt
	 * @param a String, the name of the algorithm to test.
	 * @param s Integer(int), the iteration where the algorithm will start.
	 * @param e Integer(int), the iteration where the algorithm will end.
	 * @param st Integer(int), the number of times the experiment must be repeated.
	 * @throws IOException if there's any problem while writing and or creating the file.
	 */
	public static void test(String o,String a, int s, int e, int st) throws IOException {
		int i=s;
		int j=st;
		FileWriter file = new FileWriter(o);
		while(i <= e) {
			while(j > 0 ) {
				long before = System.currentTimeMillis();
				//Executes an algorithm for a given workload 'n'.
				testAlgorithm ("Algorithms", a, i);
				long after = System.currentTimeMillis();
				result = (after-before);
				mean = (mean + result)/2;
				System.out.println("TIME SPENT... "+ result +"ms" );
				j = j-1;
			}
			j=st;
			file.write(mean + ";");
			mean = 0;
			result = 0;
			i = i+1;
		}
		file.close();
	}
	
	/**
	 * Performs the heavy task of nothing during the sleep time provided time.
	 * @param i the current iteration, just to print.
	 */
	public static void doNothing(long i) {
		System.out.println("Soing nothing at iteration... ("+i+")");
		long endTime = System.currentTimeMillis() + SLEEP_TIME;
		while(System.currentTimeMillis() < endTime) {
			//do nothing.
		}
	}
	
	/**
	 * It's used to execute an algorithm from the Algorithms class. It can be used to execute any method from any class.
	 * 
	 * @param String className, the name of the class the method you want to execute is placed.
	 * @param String methodName, the name of the method you want to test.
	 * @param int n.
	 */
	public static void testAlgorithm (String cn, String mn, long n)	{    
		Class<?> myClass = null;
		Object myObject = null;

		try {
			myClass = Class.forName("src." + cn);
			myObject = myClass.newInstance();
		} catch (Exception ex) {
			System.err.println("Error loading the class 1");
			System.out.println(ex.toString());

		}

		try {
			Class<?>[] params = new Class[1];
			params[0] = Long.TYPE;
			Method m = myClass.getMethod(mn, params);
			m.invoke(myObject, n);
		} catch (Exception ex) {
			System.err.println("Error loading the class 2");
			System.out.println(ex.toString());
		}
	}

}
