package algorithmics;

import graphs.Graph;

public class GraphPerformanceTest {

    private static final double MAX_WEIGHT = Graph.MAX_NUMBER;

    /**
     * Return a graph of integer element containing n nodes Every node is
     * connected with each other by an edge of weight calculated as a random
     * value.
     * 
     * @param int n Number of nodes
     * @return Graph of integer element containing n nodes
     * @throws Exception if there's an error adding an edge or a node
     */
    public static Graph<Integer> initGraph(int n) throws Exception {
	Graph<Integer> graph = new Graph<Integer>(n);

	for (int i = 0; i < n; i++) {
	    graph.addNode(i);
	}

	for (int i = 0; i < n; i++) {
	    for (int j = 0; j < n; j++) {
		graph.addEdge(i, j, (int) Math.random() * MAX_WEIGHT);
	    }
	}

	return graph;

    }

    /**
     * Calls to the initGraph(n) method and applies Dijkstra's algorithm on the
     * resulting graph.
     * 
     * @param n Number of nodes
     * @throws Exception given from init graph if there's any error while adding nodes or edges.
     */
    public static void runDijkstra(int n) throws Exception {
	Graph<Integer> graph = initGraph(n);
	for (int i = 0; i < n; i++)
	    graph.Dijkstra(i);
    }

    /**
     * Calls to the initGraph(n) method and applies the Dijkstra algorithm on
     * the resulting graph.
     * 
     * @param n Number of nodes
     * @throws  Exception given from init graph if there's any error while adding nodes or edges.
     */
    public static void runFloyd(int n) throws Exception {
	Graph<Integer> graph = initGraph(n);
	graph.floyd(graph.getSize());

    }

}
