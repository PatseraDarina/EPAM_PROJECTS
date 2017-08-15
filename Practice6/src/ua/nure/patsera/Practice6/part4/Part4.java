package ua.nure.patsera.Practice6.part4;

import java.util.Map;
import java.util.Set;

public class Part4 {
	public static void main(String[] args) {
		Graph graph = new Graph(5);
		graph.addEdge(1, 3);
		graph.addEdge(2, 4);
		graph.addEdge(5, 4);

		graph.removeEdge(4, 2);

		for (Map.Entry<Integer, Set<Integer>> g : graph.adjacencyMap.entrySet())
			System.out.println(g);
	}
}
