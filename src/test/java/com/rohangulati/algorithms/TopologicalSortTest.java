package com.rohangulati.algorithms;

import org.junit.Test;

import com.rohangulati.algorithm.templates.TopologicalSort;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static org.junit.Assert.assertEquals;

public class TopologicalSortTest {

    @Test
    public void testSorting() {
        Map<Character, Collection<Character>> graph =
                new TreeMap<Character, Collection<Character>>() {
                    {
                        put('A', Collections.singletonList('C'));
                        put('B', Arrays.asList('C', 'E'));
                        put('C', Collections.singletonList('D'));
                        put('D', Collections.singletonList('F'));
                        put('E', Collections.singletonList('F'));
                        put('F', Collections.singletonList('G'));
                        put('G', Collections.emptyList());
                    }
                };

        List<Character> actual = TopologicalSort.sort(graph);
        List<Character> expected = Arrays.asList('B', 'E', 'A', 'C', 'D', 'F', 'G');
        assertEquals(expected, actual);
    }
}
