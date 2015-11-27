package com.guille.ed.hashTables;

import java.util.ArrayList;

public class HashTable<T extends Comparable<T>> {

	// Constants.
	public final static int LINEAR_PROBING = 0;
	public final static int QUADRATIC_PROBING = 1;
	public final static int DOUBLE_HASHING = 2;
	public final static int ATTEMPS = 10;

	// Variables.
	private int B = 7;
	private int redispersionType = LINEAR_PROBING;
	private double minLF = 0.5;
	private ArrayList<HashNode<T>> associativeArray;
	private int n = 0;
	private int R = 5;

	/**
	 * Main constructor.
	 * 
	 * @param B the size of the HashTable
	 * @param redispersionType type of redispersion that is going to be used.
	 * @param minLF the minimum load factor accepted.
	 */
	public HashTable(int B, int redispersionType, double minLF) {
		setB(B);
		setRedispersionType(redispersionType);
		setMinLF(minLF);
		associativeArray = new ArrayList<HashNode<T>>(B);
		for (int i = 0; i < B; i++) {
			associativeArray.add(new HashNode<T>());
		}
	}

	/**
	 * Return the value size of the hash table.
	 * 
	 * @return B, the size of the hash table.
	 */
	public int getB() {
		return B;
	}

	/**
	 * Sets the parameter B that represents the size of the hash table.
	 * 
	 * @param b, the size of the hash table.
	 */
	public void setB(int b) {
		if (b < 0) {
			throw new IllegalArgumentException("B can not be negative.");
		} else {
			B = b;
		}
	}

	/**
	 * Return the re-dispersion type.
	 * 
	 * @return redispersionType that represents which one of the re-dispersion is used.
	 */
	public int getRedispersionType() {
		return redispersionType;
	}

	/**
	 * Sets the re-dispersion of the hash table.
	 * 
	 * @param redispersionType the redispersionType to set
	 */
	public void setRedispersionType(int redispersionType) {
		this.redispersionType = redispersionType;
	}

	/**
	 * Return the minimum load factor accepted by the hash table.
	 * 
	 * @return the minLF that represents the minimum load factor accepted.
	 */
	public double getMinLF() {
		return minLF;
	}

	/**
	 * Return the R, that represents something that I already don't know.
	 * 
	 * @return R
	 */
	public int getR() {
		return this.R;
	}

	/**
	 * Sets the minimum accepted load factor for the hash table.
	 * 
	 * @param minLF, the minimum accepted load factor for the hash table.
	 */
	public void setMinLF(double minLF) {
		if (minLF < 0) {
			throw new IllegalArgumentException("B can not be negative.");
		} else {
			this.minLF = minLF;
		}
	}

	/**
	 * Return the associative array.
	 * 
	 * @return the ArrayList associativeArray.
	 */
	public ArrayList<HashNode<T>> getAssociativeArray() {
		return this.associativeArray;
	}

	/**
	 * Hashing function
	 * 
	 * @param element to be stored.
	 * @param i Attempt number.
	 * @return slot in the array where the element should be placed
	 */
	protected int f(T element, int i) {
		switch (redispersionType) {
		case LINEAR_PROBING:
			return ((Math.abs(element.hashCode()) + i) % B);
			// case QUADRATIC_PROBING: return (( Math.abs(element.hashCode()) +
			// i*(R-Math.abs(element.hashCode() % R ))) % B );
		}
		return ((Math.abs(element.hashCode()) + (i * i)) % B);
	}

	/**
	 * Gets the Load Factor.
	 * 
	 * @return the LF
	 */
	public double getLF() {
		System.out.println("Hello there " + (double) n);
		return (double) n / (double) B;
	}

	/**
	 * Add method. Adds an element to the Hash Table
	 * 
	 * @param element
	 */
	public void add(T element) {
		boolean success = false;
		int i = -1;
		do {
			i++;

			if (associativeArray.get(f(element, i)).getStatus() != HashNode.VALID) {
				associativeArray.get(f(element, i)).setElement(element);
				associativeArray.get(f(element, i)).setStatus(HashNode.VALID);
				success = true;
			}
		} while (!success && i < ATTEMPS);
		n++;
		if (getLF() > minLF) {
			dynamicResize();
		}
	}

	/**
	 * Search. Given an element it checks if it is in the possition it should
	 * be.
	 * 
	 * @param element
	 * @return true if the element is in the hashTable; false otherwise.
	 */
	public boolean search(T element) {

		int i = 0;
		do {
			HashNode<T> hashNode = associativeArray.get(f(element, i));
			if (hashNode.getStatus() == HashNode.EMPTY) {
				return false;
			} else if ((hashNode.getStatus() == HashNode.VALID) && (hashNode.getElement().equals(element))) {
				return true;
			} i++;
		} while (i < ATTEMPS);

		return false;
	}

	/**
	 * Public dynamic resizing method. It calls to another with 2*B as a
	 * parameter.
	 */
	public void dynamicResize() {
		dynamicResize(nextPrime(2 * B));
	}

	/**
	 * Resizes the table dynamicly.
	 * 
	 * @param size (2*B)
	 */
	public void dynamicResize(int size) {
		HashTable<T> auxTable = new HashTable<T>(size,
				HashTable.DOUBLE_HASHING, minLF);
		for (HashNode<T> element : associativeArray) {
			if (element.getStatus() == HashNode.VALID) {
				auxTable.add(element.getElement());
			}
		}
		this.associativeArray = auxTable.getAssociativeArray();
		this.B = size;
		this.R = prevPrime(B);

	}

	/**
	 * Remove method. Given an element as a parameter this method removes it
	 * from the hash table.
	 * 
	 * @param element to be removed.
	 */
	public void remove(T element) {
		boolean success = false;
		int i = -1;

		do {
			i++;
			HashNode<T> hashNode = associativeArray.get(f(element, i));

			if (hashNode.getStatus() == HashNode.VALID
					&& hashNode.getElement().equals(element)) {
				hashNode.setStatus(HashNode.DELETED);
			}

		} while (!success && i < ATTEMPS);

		n--;
	}

	/**
	 * Given an integer number as a parameter it returns true only in the case
	 * that this number is a pime number. False otherwise
	 * 
	 * @param number to check if it's prime or not
	 * @return true if the parameter is a prime number and false otherwise.
	 */
	protected static boolean isPrime(int prime) {
		if (prime < 0) {
			prime = Math.abs(prime);
		}
		for (int i = 2; i < prime; i++) {
			if (prime % i == 0) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Returns the next prime number given an integer number as a parameter
	 * 
	 * @param number where you start to check for the next prime number
	 * @return an integer number that will be the next prime with respect to the
	 *         parameter.
	 */
	protected static int nextPrime(int prime) {
		int prim = prime + 1;
		while (!isPrime(prim)) {
			prim++;
		}
		return prim;
	}

	/**
	 * Returns the previous prime number given an integer number as a parameter
	 * 
	 * @param number where you start to check for the previous prime number
	 * @return an integer number that will be the previous prime with respect to
	 *         the parameter.
	 */
	protected static int prevPrime(int prime) {
		int prim = (prime - 1);
		while (!isPrime(prim)) {
			prim--;
		}
		return prim;
	}

	/**
	 * To String default method.
	 * 
	 * @format [Slot] (Node’s status) = element.toString() -
	 */
	public String toString() {
		StringBuilder aux = new StringBuilder();
		int i = 0;
		if (associativeArray != null) {
			for (HashNode<T> element : associativeArray) {
				aux.append("[").append(i).append("]")
						.append(" (" + element.getStatus() + ")").append(" = ")
						.append(element.getElement()).append(" - ");
				i++;
			}
		}
		return aux.toString();
	}
}