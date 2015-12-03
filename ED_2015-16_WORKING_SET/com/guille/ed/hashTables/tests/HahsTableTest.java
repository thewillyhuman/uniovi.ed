package com.guille.ed.hashTables.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.guille.ed.hashTables.HashTable;

public class HahsTableTest {

	HashTable<Integer> ht;

	@Before
	public void setUp() {
		ht = new HashTable<Integer>(7, 0, 0.5);
	}

	@Test
	public void isPrimeTest() {
		// Some base cases.
		assertEquals(false, HashTable.isPrime(-2));
		assertEquals(false, HashTable.isPrime(-1));
		assertEquals(false, HashTable.isPrime(0));
		assertEquals(false, HashTable.isPrime(1));
		assertEquals(true, HashTable.isPrime(2));

		// Some random prime testing.
		Integer[] prime = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89,
				97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197,
				199, 211, 223, 227, 229, 233, 239, 241, 251, 257, 263, 269, 271, 277, 281, 283, 293, 307, 311, 313, 317,
				331, 337, 347, 349, 353, 359, 367, 373, 379, 383, 389, 397, 401, 409, 419, 421, 431, 433, 439, 443, 449,
				457, 461, 463, 467, 479, 487, 491, 499, 503, 509, 521, 523, 541, 547, 557, 563, 569, 571, 577, 587, 593,
				599, 601, 607, 613, 617, 619, 631, 641, 643, 647, 653, 659, 661, 673, 677, 683, 691, 701, 709, 719, 727,
				733, 739, 743, 751, 757, 761, 769, 773, 787, 797, 809, 811, 821, 823, 827, 829, 839, 853, 857, 859, 863,
				877, 881, 883, 887, 907, 911, 919, 929, 937, 941, 947, 953, 967, 971, 977, 983, 991, 997 };

		for (int i = 0; i < prime.length; i++) {
			assertEquals(true, HashTable.isPrime(prime[i]));
		}

		// Some random non prime testing.
		Integer[] nonPrime = { 4, 6, 8, 9, 10, 12, 14, 15, 16, 18, 20, 21, 22, 24, 25, 26, 27, 28, 30, 32, 33, 34, 35,
				36, 38, 39, 40, 42, 44, 45, 46, 48, 49, 50, 51, 52, 54, 55, 56, 57, 58, 60, 62, 63, 64, 65, 66, 68, 69,
				70, 72, 74, 75, 76, 77, 78, 80, 81, 82, 84, 85, 86, 87, 88, 90, 91, 92, 93, 94, 95, 96, 98, 99, 100,
				102, 104, 105, 106, 108, 110, 111, 112, 114, 115, 116, 117, 118, 119, 120, 121, 122, 123, 124, 125, 126,
				128, 129, 130, 132, 133, 134, 135, 136, 138, 140, 141, 142, 143, 144, 145, 146, 147, 148, 150 };

		for (int i = 0; i < nonPrime.length; i++) {
			assertEquals(false, HashTable.isPrime(nonPrime[i]));
		}
	}
	
	@Test
	public void isPrimeAKSTest() {
		// Some base cases.
		assertEquals(false, HashTable.isPrimeAKS(-2));
		assertEquals(false, HashTable.isPrimeAKS(-1));
		assertEquals(false, HashTable.isPrimeAKS(0));
		assertEquals(false, HashTable.isPrimeAKS(1));
		assertEquals(true, HashTable.isPrimeAKS(2));

		// Some random prime testing.
		Integer[] prime = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89,
				97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197,
				199, 211, 223, 227, 229, 233, 239, 241, 251, 257, 263, 269, 271, 277, 281, 283, 293, 307, 311, 313, 317,
				331, 337, 347, 349, 353, 359, 367, 373, 379, 383, 389, 397, 401, 409, 419, 421, 431, 433, 439, 443, 449,
				457, 461, 463, 467, 479, 487, 491, 499, 503, 509, 521, 523, 541, 547, 557, 563, 569, 571, 577, 587, 593,
				599, 601, 607, 613, 617, 619, 631, 641, 643, 647, 653, 659, 661, 673, 677, 683, 691, 701, 709, 719, 727,
				733, 739, 743, 751, 757, 761, 769, 773, 787, 797, 809, 811, 821, 823, 827, 829, 839, 853, 857, 859, 863,
				877, 881, 883, 887, 907, 911, 919, 929, 937, 941, 947, 953, 967, 971, 977, 983, 991, 997 };

		for (int i = 0; i < prime.length; i++) {
			assertEquals(true, HashTable.isPrimeAKS(prime[i]));
		}

		// Some random non prime testing.
		Integer[] nonPrime = { 4, 6, 8, 9, 10, 12, 14, 15, 16, 18, 20, 21, 22, 24, 25, 26, 27, 28, 30, 32, 33, 34, 35,
				36, 38, 39, 40, 42, 44, 45, 46, 48, 49, 50, 51, 52, 54, 55, 56, 57, 58, 60, 62, 63, 64, 65, 66, 68, 69,
				70, 72, 74, 75, 76, 77, 78, 80, 81, 82, 84, 85, 86, 87, 88, 90, 91, 92, 93, 94, 95, 96, 98, 99, 100,
				102, 104, 105, 106, 108, 110, 111, 112, 114, 115, 116, 117, 118, 119, 120, 121, 122, 123, 124, 125, 126,
				128, 129, 130, 132, 133, 134, 135, 136, 138, 140, 141, 142, 143, 144, 145, 146, 147, 148, 150 };

		for (int i = 0; i < nonPrime.length; i++) {
			assertEquals(false, HashTable.isPrimeAKS(nonPrime[i]));
		}
	}

	@Test
	public void getNextPrimeTest() {
		// Some base cases.
		assertEquals(2, HashTable.getNextPrime(-2));
		assertEquals(2, HashTable.getNextPrime(-1));
		assertEquals(2, HashTable.getNextPrime(0));
		assertEquals(2, HashTable.getNextPrime(1));
		// Status changed.
		assertEquals(3, HashTable.getNextPrime(2));

		// Some random prime testing.
		Integer[] prime = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89,
				97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197,
				199, 211, 223, 227, 229, 233, 239, 241, 251, 257, 263, 269, 271, 277, 281, 283, 293, 307, 311, 313, 317,
				331, 337, 347, 349, 353, 359, 367, 373, 379, 383, 389, 397, 401, 409, 419, 421, 431, 433, 439, 443, 449,
				457, 461, 463, 467, 479, 487, 491, 499, 503, 509, 521, 523, 541, 547, 557, 563, 569, 571, 577, 587, 593,
				599, 601, 607, 613, 617, 619, 631, 641, 643, 647, 653, 659, 661, 673, 677, 683, 691, 701, 709, 719, 727,
				733, 739, 743, 751, 757, 761, 769, 773, 787, 797, 809, 811, 821, 823, 827, 829, 839, 853, 857, 859, 863,
				877, 881, 883, 887, 907, 911, 919, 929, 937, 941, 947, 953, 967, 971, 977, 983, 991, 997 };

		// For every number in the array the next one is the next prime so we
		// check that.
		for (int i = 0; i < prime.length - 1; i++) {
			int aux = prime[i + 1];
			assertEquals(aux, HashTable.getNextPrime(prime[i]));
		}
	}

	@Test
	public void getPrevPrimeTest() {
		// Some base cases.
		try {
			assertEquals(2, HashTable.getPrevPrime(-2));
			fail("There's no prime previus to -2");
		} catch (IllegalArgumentException e) {
			System.out.println("FROM TESTING: " + e);
		}
		try {
			assertEquals(2, HashTable.getPrevPrime(-1));
			fail("There's no prime previus to -1");
		} catch (IllegalArgumentException e) {

		}
		try {
			assertEquals(2, HashTable.getPrevPrime(0));
			fail("There's no prime previus to 0");
		} catch (IllegalArgumentException e) {
			System.out.println("FROM TESTING: " + e);
		}
		try {
			assertEquals(2, HashTable.getPrevPrime(1));
			fail("There's no prime previus to 1");
		} catch (IllegalArgumentException e) {
			System.out.println("FROM TESTING: " + e);
		}
		try {
			assertEquals(2, HashTable.getPrevPrime(2));
			fail("There's no prime previus to 2");
		} catch (IllegalArgumentException e) {
			System.out.println("FROM TESTING: " + e);
		}

		// Some random prime testing.
		Integer[] prime = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89,
				97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197,
				199, 211, 223, 227, 229, 233, 239, 241, 251, 257, 263, 269, 271, 277, 281, 283, 293, 307, 311, 313, 317,
				331, 337, 347, 349, 353, 359, 367, 373, 379, 383, 389, 397, 401, 409, 419, 421, 431, 433, 439, 443, 449,
				457, 461, 463, 467, 479, 487, 491, 499, 503, 509, 521, 523, 541, 547, 557, 563, 569, 571, 577, 587, 593,
				599, 601, 607, 613, 617, 619, 631, 641, 643, 647, 653, 659, 661, 673, 677, 683, 691, 701, 709, 719, 727,
				733, 739, 743, 751, 757, 761, 769, 773, 787, 797, 809, 811, 821, 823, 827, 829, 839, 853, 857, 859, 863,
				877, 881, 883, 887, 907, 911, 919, 929, 937, 941, 947, 953, 967, 971, 977, 983, 991, 997 };

		// For every number in the array the next one is the next prime so we
		// check that.
		for (int i = 1; i < prime.length; i++) {
			int aux = prime[i - 1];
			assertEquals(aux, HashTable.getPrevPrime(prime[i]));
		}
	}

}
