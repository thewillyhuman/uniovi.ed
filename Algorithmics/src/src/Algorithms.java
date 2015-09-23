package src;

/**
 * The Algorithms class contains sample algorithms whose  temporal complexities will be evaluated. 
 * @author
 */
public class Algorithms {
	
	/**
	 * Simulates a linear algorithm.
	 * @param n long, the workload.
	 */
	public static void linear (long n) {
		for(long i=0; i<=n; i++)
			TestBench.doNothing(i);
	}
	
	/**
	 * Simulates a quadratic algorithm.
	 * @param n long, the workload.
	 */
	public static void quadratic (long n) {
		for(long i=0; i<=n; i++)
			for(long j=0; j<=n; j++)
				TestBench.doNothing(j);
	}
	
	/**
	 * Simulates a cubic algorithm.
	 * @param n long, the workload
	 */
	public static void cubic (long n) {
		for(long i=0; i<=n; i++)
			for(long j=0; j<=n; j++)
				for(long k=0; k<=n; k++)
					TestBench.doNothing(k);
	}
	
	/**
	 * Simulates a logarithmic algorithm.
	 * @param n long, the workload for the logarithmic algorithm.
	 */
	public static void logarithmic(long n) {
		for(long i=n; i>0; i=i/2) {
			TestBench.doNothing(i);
		}
	}
}
