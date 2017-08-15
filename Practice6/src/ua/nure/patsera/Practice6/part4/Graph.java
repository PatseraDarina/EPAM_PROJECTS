package ua.nure.patsera.Practice6.part4;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Graph implements Iterable<Integer> {
	public HashMap<Integer, Set<Integer>> adjacencyMap;

	public Graph(int numberOfVertex) {
		adjacencyMap = new HashMap<>();
		for (int i = 0; i < numberOfVertex; i++) {
			adjacencyMap.put(i + 1, new HashSet<>());
		}
	}

	public void addEdge(Integer from, Integer to) {
		if (adjacencyMap.containsKey(from) && adjacencyMap.containsKey(to)) {
			adjacencyMap.get(from).add(to);
			adjacencyMap.get(to).add(from);
		} else {
			throw new IllegalArgumentException();
		}
	}

	public void removeEdge(Integer from, Integer to) {
		if (adjacencyMap.containsKey(from) && adjacencyMap.containsKey(to))
			if (checkAdjacency(from, to)) {
				adjacencyMap.get(from).remove(to);
				adjacencyMap.get(to).remove(from);
		} else {
			throw new IllegalArgumentException();
		}
	}

	public boolean checkAdjacency(Integer from, Integer to) {
		return adjacencyMap.get(from).contains(to) &&
				adjacencyMap.get(to).contains(from);
	}

	@Override
	public Iterator<Integer> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
}
