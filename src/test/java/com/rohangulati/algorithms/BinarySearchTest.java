package com.rohangulati.algorithms;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static com.rohangulati.algorithm.templates.BinarySearch.lowerBound;
import static com.rohangulati.algorithm.templates.BinarySearch.upperBound;
import static org.junit.Assert.assertEquals;

public class BinarySearchTest {

  @Test
  public void testUpperBound() {
    List<Integer> list = Arrays.asList(1, 2, 4, 4, 5, 10);
    assertEquals(4, upperBound(list, 4));
    assertEquals(0, upperBound(list, -1));
    assertEquals(-1, upperBound(list, 11));
    assertEquals(2, upperBound(list, 3));
  }

  @Test
  public void testLowerBound() {
    List<Integer> list = Arrays.asList(1, 2, 4, 4, 5, 10);
    assertEquals(1, lowerBound(list, 4));
    assertEquals(3, lowerBound(list, 5));
    assertEquals(-1, lowerBound(list, 1));
    assertEquals(5, lowerBound(list, 11));
  }
}
