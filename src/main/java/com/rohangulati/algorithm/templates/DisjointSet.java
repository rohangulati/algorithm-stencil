package com.rohangulati.algorithm.templates;

import java.util.stream.IntStream;

public class DisjointSet {

    /**
     * UnionFindBasic is a basic implementation of UnionFind
     */
    private static class UnionFindBasic extends AbstractUnionFind {
        public UnionFindBasic(int n) {
            super(n);
        }

        @Override
        public int find(int x) {
            while (parent[x] != x) {
                x = parent[x];
            }
            return x;
        }
    }

    /**
     * UnionFindWithPathCompression is an implementation of UnionFind algorithm
     * with path compression
     */
    private static class UnionFindWithPathCompression extends AbstractUnionFind {
        public UnionFindWithPathCompression(int n) {
            super(n);
        }

        @Override
        public int find(int x) {
            if (parent[x] == x) {
                return x;
            }
            parent[x] = find(parent[x]);
            return parent[x];
        }
    }


    /**
     * A abstract union find implements the union by rank algorithm
     */
    private abstract static class AbstractUnionFind implements UnionFind {
        protected final int[] parent;
        protected final int[] rank;

        public AbstractUnionFind(int n) {
            this.parent = IntStream.range(0, n).toArray();
            this.rank = new int[n];
        }

        @Override
        public void union(int x, int y) {
            int root1 = find(x);
            int root2 = find(y);
            if (root1 == root2) {
                return;
            }

            if (rank[root1] > rank[root2]) {
                parent[root2] = root1;
            } else {
                parent[root1] = root2;
            }

            if (rank[root1] == rank[root2]) {
                rank[root2]++;
            }
        }

        @Override
        public int count() {
            return (int) IntStream.range(0, parent.length).map(this::find).distinct().count();
        }
    }

    /**
     * UnionFind in a classic algorithm to union of disjoint sets and finding the member of a element
     * to a set
     */
    interface UnionFind {

        /**
         * Union operation merges the 2 elements into the single set
         *
         * @param x first element
         * @param y second element
         */
        void union(int x, int y);

        /**
         * Find operation finds the set this element belongs to
         *
         * @param x the given element
         * @return the id of the set to which this element belongs to
         */
        int find(int x);


        /**
         * Returns the total number of sets
         *
         * @return the count of disjoint sets
         */
        int count();
    }
}
