package com.rohangulati.algorithm.templates;

import java.util.List;

public class BinarySearch {

    public static <T extends Comparable<T>> int upperBound(List<T> a, T val) {
        int s = 0, e = a.size() - 1, m, ans = Integer.MAX_VALUE;
        while (s <= e) {
            m = s + (e - s) / 2;
            int result = a.get(m).compareTo(val);
            if (result <= 0) {
                s = m + 1;
            } else {
                e = m - 1;
            }
            if (result > 0) {
                ans = Math.min(ans, m);
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public static <T extends Comparable<T>> int lowerBound(List<T> a, T val) {
        int s = 0, e = a.size() - 1, m, ans = -1;
        while (s <= e) {
            m = s + (e - s) / 2;
            int result = a.get(m).compareTo(val);
            if (result < 0) {
                s = m + 1;
            } else {
                e = m - 1;
            }
            if (result < 0) {
                ans = Math.max(ans, m);
            }
        }
        return ans;
    }
}
