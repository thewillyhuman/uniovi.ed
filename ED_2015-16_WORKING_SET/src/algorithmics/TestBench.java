package algorithmics;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;

public class TestBench {

	private static final int SLEEP_TIME = 2;
	private static final int SAMPLES = 3;
	private static final int START_N = 1;
	private static final int FINAL_N = 50;
	private static final String[] ALGORITHMS = {"linear", "quadratic", "cubic", "logarithmic", "factorial", "factorialRec","pow", "powRec1", "powRec2", "powRec3", "powRec4"};
	
	private static long result = 0;
	private static long mean = 0;
	
	public static void main(String[] args) throws IOException {
		for(int i = 0; i < ALGORITHMS.length; i++) {
			System.out.println("Algorithm..." + ALGORITHMS[i]);
			if(i==2 || i==7) {
				TestBench.test(ALGORITHMS[i]+"_means.csv", ALGORITHMS[i], START_N, 12, SAMPLES); //Override for the exponential version.
			} else {
				TestBench.test(ALGORITHMS[i]+"_means.csv", ALGORITHMS[i], START_N, FINAL_N, SAMPLES);
			}
		}
	}
	
	/**
	 * DEPRECATED
	 * Old and deprecated test method.
	 * @param n long, represents the workload.
	 */
	@SuppressWarnings("unused")
	private static void test (long n) {
		long i = System.currentTimeMillis();
		Algorithms.linear(n);
		long f = System.currentTimeMillis();
		result = (f-i);
		System.out.println("Time to execute = "+result+"ms.");
	}
	
	/**
	 * @param o String, output file name, example: quadratic.txt
	 * @param a String, the name of the algorithm to test.
	 * @param s Integer(int), the iteration where the algorithm will start.
	 * @param e Integer(int), the iteration where the algorithm will end.
	 * @param st Integer(int), the number of times the experiment must be repeated.
	 * @throws IOException if there's any problem while writing and or creating the file.
	 */
	private static void test(String o,String a, int s, int e, int st) throws IOException {
		int i=s;
		int j=st;
		FileWriter file = new FileWriter(o);
		while(i <= e) {
			while(j > 0 ) {
				long before = System.currentTimeMillis();
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
	 * It's used to execute an algorithm from the Algorithms class. It can be used to execute any method from any class.
	 * 
	 * @param String className, the name of the class the method you want to execute is placed.
	 * @param String methodName, the name of the method you want to test.
	 * @param int n.
	 */
	private static void testAlgorithm (String cn, String mn, long n) {    
		Class<?> myClass = null;
		Object myObject = null;
		try {
			myClass = Class.forName("algorithmics." + cn);
			myObject = myClass.newInstance();
		} catch (Exception e) {
			System.err.println("Error loading the class 1");
			System.out.println(e.toString());
		} try {
			Class<?>[] params = new Class[1];
			params[0] = Long.TYPE;
			Method m = myClass.getMethod(mn, params);
			m.invoke(myObject, n);
		} catch (Exception e) {
			System.err.println("Error loading the class 2");
			System.out.println(e.toString());
		}
	}
	
	/**
	 * Performs the heavy task of nothing during the sleep time provided time.
	 * @param i the current iteration, just to print.
	 */
	protected static void doNothing(long i) {
		long endTime = System.currentTimeMillis() + SLEEP_TIME;
		while(System.currentTimeMillis() < endTime) {
			//do nothing.
		}
	}
}
