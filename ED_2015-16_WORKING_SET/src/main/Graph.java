package main;

import main.GraphNode;

import java.util.ArrayList;

public class Graph<T extends Comparable<T>> {

	ArrayList<GraphNode<T>> nodes;
	private boolean[][] edges;
	private double[][] weight;

	// Floyd attributes.
	private double[][] A;
	private int[][] P;

	// Constants.
	public static final int INDEX_NOT_FOUND = -1;
	public final static Double MAX_NUMBER = Double.MAX_VALUE;

	public Graph(int n) {
		if (n > 0) {
			nodes = new ArrayList<GraphNode<T>>();
			edges = new boolean[n][n];
			weight = new double[n][n];
		}
	}

	/**
	 * Return the actual position of the given T element.
	 * 
	 * @param node
	 *            to be searched inside the graph.
	 * @return the position of the node if it's inside the graph, -1 otherwise.
	 */
	public int getNode(T node) {
		int i = 0;
		for (GraphNode<T> curr : nodes) {
			if (node.compareTo(curr.getElement()) == 0)
				return i;
			i++;
		}
		return INDEX_NOT_FOUND;
	}

	public T getElement(int index) {
		return nodes.get(index).getElement();
	}

	/**
	 * 
	 * @return the size of the graph. Or the number of nodes that the graph
	 *         contains.
	 */
	public int getSize() {
		return nodes.size();
	}

	/**
	 * Given a T element we create a node in the graph.
	 * 
	 * @param element
	 *            to be added to the graph
	 * @throws Exception
	 *             if the node already exits on the graph. Or if the graph is
	 *             full.
	 */
	public void addNode(T element) throws Exception {
		if (element == null) {
			throw new Exception("You cannot add null elements to the graph.");
		} else if (getSize() == weight.length) {
			throw new Exception("The node cannot be added because there's no space.");
		}
		for (GraphNode<T> node : nodes) {
			if (node.getElement().equals(element))
				throw new Exception("Element is already in the graph.");
		}
		nodes.add(new GraphNode<T>(element));
	}

	/**
	 * Returns true if exists an edge between the given origin and dest.
	 * 
	 * @param origin
	 * @param dest
	 * @return
	 * @throws Exception
	 */
	public boolean existsEdge(T origin, T dest) throws Exception {
		return edges[getNode(origin)][getNode(dest)];
	}

	/**
	 * Adds and edge between the given origin, destination and sets a weight.
	 * 
	 * @param origin
	 * @param dest
	 * @param weight
	 * @throws Exception
	 */
	public void addEdge(T origin, T dest, double weight) throws Exception {
		if (existsEdge(origin, dest))
			throw new Exception("You cannot add a repeated edge.");
		else {
			this.weight[getNode(origin)][getNode(dest)] = weight;
			edges[getNode(origin)][getNode(dest)] = true;
		}
	}

	/**
	 * Just for testing proposes...
	 * 
	 * @return the edges array.
	 */
	public boolean[][] getEdges() {
		return this.edges;
	}

	/**
	 * Just for testing proposes...
	 * 
	 * @return the weights array.
	 */
	public double[][] getWeight() {
		return this.weight;
	}

	/**
	 * Traverse over the graph by using the DFPrint private method.
	 * 
	 * @param element
	 * @return
	 * @throws Exception
	 */
	public String traverseGraph(T element) throws Exception {
		int v = getNode(element);
		if (v == INDEX_NOT_FOUND)
			throw new Exception("That node does not exists.");
		for (GraphNode<T> n : nodes)
			n.setVisited(false);
		return DFPrint(v);
	}

	/**
	 * Recursive method that traverses over the and returns its content as
	 * "a-b-c-"
	 * 
	 * @param v
	 * @return
	 */
	private String DFPrint(int v) {
		nodes.get(v).setVisited(true);
		StringBuilder aux = new StringBuilder();
		aux.append(getElement(v).toString() + "-");
		for (int i = 0; i < getSize(); i++) {
			if (edges[v][i] && !nodes.get(i).isVisited())
				aux.append(DFPrint(i));
		}
		return aux.toString();
	}

	public void print() throws Exception {
		System.out.println(traverseGraph(nodes.get(0).getElement()));
	}

	/**
	 * Removes a node from the graph.
	 * 
	 * @param element
	 *            stored in the graph to be removed.
	 * @throws Exception
	 *             if the node doesn't exist in the graph.
	 */
	public void removeNode(T element) throws Exception {
		int index = getNode(element);
		if (index < 0)
			throw new Exception("Attempting to remove a non existing node");
		nodes.remove(index);
		for (int i = index; i < getSize(); i++) {
			for (int j = 0; j < getSize(); j++) {
				weight[i][j] = weight[i + 1][j];
				weight[j][i] = weight[j][i + 1];
				edges[i][j] = edges[i + 1][j];
				edges[j][i] = edges[j][i + 1];
			}
			weight[i][i] = weight[i + 1][i + 1];
			edges[i][i] = edges[i + 1][i + 1];
		}
	}

	/**
	 * Removes an edge between two nodes.
	 * 
	 * @param origin
	 *            the element contained in the node that's the starting point of
	 *            the edge.
	 * @param dest
	 *            the element contained in the node that's the end point of the
	 *            edge.
	 * @throws Exception
	 *             if the edge does not exist.
	 */
	public void removeEdge(T origin, T dest) throws Exception {
		if (!existsEdge(origin, dest))
			throw new Exception("There's no edge between the selected nodes");
		edges[getNode(origin)][getNode(dest)] = false;
		weight[getNode(origin)][getNode(dest)] = 0.0;
	}

	/* ---------- FLOYD ALGORITHM ---------- */

	/**
	 * Returns matrix A from Floyd's algorithm. Contains the minimum cost of
	 * going to any node from any other node.
	 * 
	 * @return Floyd's A matrix
	 */
	public double[][] getA() {
		return A;
	}

	/**
	 * Returns matrix P from Floyd's algorithm. Contains the previous node that
	 * must be visited to get to any node from any other node.
	 * 
	 * @return Floyd's P matrix
	 */
	public int[][] getP() {
		return P;
	}

	/**
	 * Initializes the A matrix giving it the weight of the edges of going
	 * directly from each node to all the others, with infinite
	 * (Double.MAX_VALUE) if there's no direct connection.
	 */
	private void initFloyd() {
		A = getWeight();
		P = new int[getSize()][getSize()];
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A[0].length; j++) {
				P[i][j] = -1;
				if (A[i][j] == 0.0 && i != j)
					A[i][j] = MAX_NUMBER;
			}
		}
	}

	/**
	 * Executes the algorithm. Calculates the weight of going from each node to
	 * all the others making a stop through a different node each time. If it's
	 * less than the direct value, the A matrix is updated and the intermediate
	 * node is written in the P matrix.
	 */
	public void floyd(int An) {
		initFloyd();
		for (int i = 0; i < An; i++) {
			for (int j = 0; j < An; j++) {
				for (int k = 0; k < An; k++) {
					if ((A[i][k] + A[k][j]) < A[i][j]) {
						A[i][j] = (A[i][k] + A[k][j]);
						P[i][j] = k;
						i = 0;
						j = 0;
					}
				}
			}
		}
	}

	/**
	 * Returns a string containing the path with the minimum cost to get from
	 * one node to a different one using Floyd's algorithm
	 * 
	 * @param departure
	 *            node to start floyd
	 * @param destination
	 *            node to end floyd
	 * @return string describing the minimum cost path.
	 */
	public String printFloydPath(T departure, T destination) {
		if (departure.equals(destination)) {
			return departure.toString();
		}
		int start = getNode(departure);
		int end = getNode(destination);
		int step = P[start][end];
		if (step == -1 && edges[start][end])
			step = start;
		return printFloydPath(departure, getElement(step)) + getElement(end).toString();
	}
}
