package com.rohangulati.algorithm.templates;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * A topological sort is an ordering in a directed acyclic graph in which if there is a directed
 * edge between
 */
public class TopologicalSort {

    private TopologicalSort() {
        // no instance creation
    }

    public static <T> List<T> sort(Map<T, Collection<T>> graph) {
        List<T> order = new ArrayList<>(graph.size());
        Set<T> visited = new HashSet<>();
        for (T vertex : graph.keySet()) {
            sortRecursive(vertex, graph, visited, order);
        }
        Collections.reverse(order);
        return order;
    }

    private static <T> void sortRecursive(
            T vertex, Map<T, Collection<T>> graph, Set<T> visited, List<T> stack) {
        if (visited.contains(vertex)) {
            return;
        }
        visited.add(vertex);
        Collection<T> neighbours = graph.getOrDefault(vertex, Collections.emptyList());
        for (T neighbour : neighbours) {
            sortRecursive(neighbour, graph, visited, stack);
        }
        stack.add(vertex);
    }
}
