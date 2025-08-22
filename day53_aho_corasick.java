import java.util.*;

public class day53_aho_corasick {
    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        TrieNode failLink;
        List<String> output = new ArrayList<>();
    }

    static TrieNode root = new TrieNode();

    public static void addPattern(String pattern) {
        TrieNode node = root;
        for (char c : pattern.toCharArray()) {
            node = node.children.computeIfAbsent(c, k -> new TrieNode());
        }
        node.output.add(pattern);
    }

    public static void buildFailureLinks() {
        Queue<TrieNode> queue = new LinkedList<>();
        root.failLink = root;
        queue.add(root);

        while (!queue.isEmpty()) {
            TrieNode current = queue.poll();
            for (Map.Entry<Character, TrieNode> entry : current.children.entrySet()) {
                char c = entry.getKey();
                TrieNode child = entry.getValue();
                TrieNode fail = current.failLink;

                while (fail != root && !fail.children.containsKey(c)) {
                    fail = fail.failLink;
                }

                if (fail.children.containsKey(c) && fail.children.get(c) != child) {
                    child.failLink = fail.children.get(c);
                } else {
                    child.failLink = root;
                }
                child.output.addAll(child.failLink.output);

                queue.add(child);
            }
        }
    }

    public static void search(String text) {
        TrieNode node = root;
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            while (node != root && !node.children.containsKey(c)) {
                node = node.failLink;
            }
            if (node.children.containsKey(c)) {
                node = node.children.get(c);
            }
            if (!node.output.isEmpty()) {
                for (String pattern : node.output) {
                    System.out.println("Pattern \"" + pattern + "\" found at index " + (i - pattern.length() + 1));
                }
            }
        }
    }

    public static void main(String[] args) {
        addPattern("he");
        addPattern("she");
        addPattern("his");
        addPattern("hers");

        buildFailureLinks();
        search("ahishers");
    }
}
