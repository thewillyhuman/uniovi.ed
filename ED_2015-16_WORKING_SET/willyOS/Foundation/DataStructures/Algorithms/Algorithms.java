package willyOS.Foundation.DataStructures.Algorithms;

/**
 * The Algorithms class contains sample algorithms whose temporal complexities
 * will be evaluated.
 * 
 * @author Guillermo Facundo Colunga
 * @version 1.2
 */
public class Algorithms {

    /**
     * Simulates a linear algorithm.
     * 
     * @param n
     *            long, the workload.
     */
    public static void linear(long n) {
	for (long i = 0; i <= n; i++)
	    TestBench.doNothing(i);
    }

    /**
     * Simulates a quadratic algorithm.
     * 
     * @param n
     *            long, the workload.
     */
    public static void quadratic(long n) {
	for (long i = 0; i <= n; i++)
	    for (long j = 0; j <= n; j++)
		TestBench.doNothing(j);
    }

    /**
     * Simulates a cubic algorithm.
     * 
     * @param n
     *            long, the workload
     */
    public static void cubic(long n) {
	for (long i = 0; i <= n; i++)
	    for (long j = 0; j <= n; j++)
		for (long k = 0; k <= n; k++)
		    TestBench.doNothing(k);
    }

    /**
     * Simulates a logarithmic algorithm.
     * 
     * @param n
     *            long, the workload for the logarithmic algorithm.
     */
    public static void logarithmic(long n) {
	for (long i = n; i > 0; i = i / 2) {
	    TestBench.doNothing(i);
	}
    }

    /**
     * Simulates a factorial non recursive algorithm.
     * 
     * @param n
     *            long, the number to calculate the factorial.
     * @return the factorial of n.
     */
    public static long factorial(long n) {
	long result = 1;
	for (long i = 1; i <= n; i++)
	    result *= i;
	return result;
    }

    /**
     * Simulates a factorial recursive algorithm.
     * 
     * @param n
     * @return the factorial of n.
     */
    public static long factorialRec(long n) {
	if (n == 0)
	    return 1;
	else
	    return n * factorialRec(n - 1);
    }

    /**
     * Simulates a pow of 2 algorithm in a iterative way. 2^n.
     * 
     * @param n
     *            the exponent of 2.
     * @return the result after the pow method executed.
     */
    public static long pow(long n) {
	long result = 1;
	for (long i = 1; i <= n; i++) {
	    result *= 2;
	    TestBench.doNothing(n);
	}
	return result;
    }

    /**
     * ENORMOUS COMPLEXITY Simulates a pow of 2 algorithm in a recursive way.
     * 2^n
     * 
     * @param n
     *            the exponent of 2.
     * @return the result after the pow method executed.
     */
    public static long powRec1(long n) {
	TestBench.doNothing(n);
	if (n == 0)
	    return 1;
	else
	    return powRec1(n - 1) + powRec1(n - 1);
    }

    /**
     * Simulates a pow of 2 algorithm in a recursive way. 2^n
     * 
     * @param n
     *            the exponent of 2.
     * @return the result after the pow method executed.
     */
    public static long powRec2(long n) {
	TestBench.doNothing(n);
	if (n == 0)
	    return 1;
	else
	    return 2 * powRec2(n - 1);
    }

    /**
     * Simulates a pow of 2 algorithm in a recursive way. 2^n
     * 
     * @param n
     *            the exponent of 2.
     * @return the result after the pow method executed.
     */
    public static long powRec3(long n) {
	TestBench.doNothing(n);
	if (n == 0) {
	    return 1;
	} else {
	    if (n % 2 == 0)
		return powRec3(n / 2) * powRec3(n / 2);
	    else
		return powRec3(n / 2) * powRec3(n / 2) * 2;
	}
    }

    /**
     * Simulates a pow of 2 algorithm in a recursive way. 2^n
     * 
     * @param n
     *            the exponent of 2.
     * @return the result after the pow method executed.
     */
    public static long powRec4(long n) {
	TestBench.doNothing(n);
	if (n == 0) {
	    return 1;
	} else {
	    long aux = powRec4(n / 2);
	    aux = aux * aux;
	    if (n % 2 != 0)
		return aux * 2;
	    else
		return aux;
	}
    }
}
