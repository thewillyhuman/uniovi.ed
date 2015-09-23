package src;

/**
 * The Algorithms class contains sample algorithms whose  temporal complexities will be evaluated. 
 * @author
 */
public class Algorithms {
	
	public static void linear (long n) {
		for(long i=0; i<=n; i++)
			TestBench.doNothing(i);
	}
	
	public static void quadratic (long n) {
		for(long i=0; i<=n; i++)
			for(long j=0; j<=n; j++)
				TestBench.doNothing(j);
	}
	
	public static void cubic (long n) {
		for(long i=0; i<=n; i++)
			for(long j=0; j<=n; j++)
				for(long k=0; k<=n; k++)
					TestBench.doNothing(k);
	}
	
	public static void logarithmic(long n) {	
		//double log = n;
		for(long i=n; i>0; i=i/2) {
			System.out.println("executing job: " + i);
			TestBench.doNothing(i);
		}
	}

}
