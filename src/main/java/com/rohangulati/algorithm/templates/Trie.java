package com.rohangulati.algorithm.templates;

import java.util.HashMap;
import java.util.Map;

public class Trie {

    public static TrieNode buildPrefixTree(String s) {
        int n = s.length();
        TrieNode root = new TrieNode();
        for (int i = 0; i < n; i++) {
            addPrefix(root, s, i);
        }
        return root;
    }

    private static void addPrefix(TrieNode root, String s, int start) {
        for (int i = start; i < s.length(); i++) {
            root = root.putIfAbsent(s.charAt(i));
        }
        root.end = true;
    }

    public static void add(TrieNode root, String s) {
        for (int i = 0; i < s.length(); i++) {
            root = root.putIfAbsent(s.charAt(i));
        }
        root.end = true;
    }

    public static boolean contains(TrieNode root, String s) {
        TrieNode node = root;
        for (int i = 0; i < s.length(); i++) {
            node = node.get(s.charAt(i));
            if (node == null) {
                return false;
            }
        }
        return node.end;
    }

    private static class TrieNode {
        private Map<Character, TrieNode> children;
        private boolean end = false;

        public TrieNode() {
            this.children = new HashMap<>();
        }

        public TrieNode putIfAbsent(char c) {
            return this.children.computeIfAbsent(c, k -> new TrieNode());
        }

        public TrieNode get(char c) {
            return this.children.get(c);
        }
    }
}
